package com.barapps.triggers.triggers;

import com.barapps.triggers.triggers.actions.ContinuousAction;
import com.barapps.triggers.triggers.actions.exceptions.ActionExecutionException;
import com.barapps.triggers.triggers.conditions.Conditions;
import com.barapps.triggers.triggers.conditions.FakeCondition;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;

public class TriggerTest {

    private ContinuousAction mMockedAction;

    @Before
    public void init() {
        mMockedAction = Mockito.mock(ContinuousAction.class);
    }

    @Test
    public void run_conditionIsVerified_triggerWasExecuted() throws Exception {

        Trigger trigger = TriggerBuilder.when(Conditions.axiom()).perform(mMockedAction).build();
        trigger.run();

        Mockito.verify(mMockedAction).execute();
        Assert.assertThat(((ContinuousTrigger)trigger).wasExecuted(), is(true));
    }

    @Test
    public void run_conditionIsNotVerified_triggerWasNotBeenExecuted() throws Exception {

        ContinuousTrigger trigger = new ContinuousTrigger(new FakeCondition(false), mMockedAction);
        trigger.run();

        Mockito.verifyZeroInteractions(mMockedAction);
        Assert.assertThat(trigger.wasExecuted(), is(false));
    }

    @Test
    public void run_actionExecutionFailed_triggerStillConsideredAsBeenExecuted() throws Exception {
        Mockito.doThrow(ActionExecutionException.class).when(mMockedAction).execute();

        ContinuousTrigger trigger = new ContinuousTrigger(Conditions.axiom(), mMockedAction);
        trigger.run();

        Assert.assertThat(trigger.wasExecuted(), is(true));
    }


    @Test
    public void run_multipleTimes_executeActionOnlyOnce() throws Exception {
        ContinuousTrigger trigger = new ContinuousTrigger(Conditions.axiom(), mMockedAction);
        trigger.run();
        trigger.run();
        trigger.run();

        Mockito.verify(mMockedAction, Mockito.times(1)).execute();
    }

    @Test
    public void run_conditionIsVerifiedOnlyAtFirstTime_executeAndThenStop() throws Exception {
        FakeCondition fakeCondition = new FakeCondition(true);
        ContinuousTrigger trigger = new ContinuousTrigger(fakeCondition, mMockedAction);

        trigger.run();
        fakeCondition.set(false);
        trigger.run();
        trigger.run();

        Mockito.verify(mMockedAction, Mockito.times(1)).execute();
        Mockito.verify(mMockedAction, Mockito.times(1)).stop();
    }



}