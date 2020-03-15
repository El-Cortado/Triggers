package com.barapps.triggers.triggers.actions.compound;

import com.barapps.triggers.triggers.actions.Action;
import com.barapps.triggers.triggers.actions.ContinuousAction;
import com.barapps.triggers.triggers.actions.FakeActions;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.inOrder;

public class IndependentActionsTest {

    @Test
    public void execute_internalActionBeenExecuted() throws Exception {
        Action mockedInternalAction = Mockito.mock(Action.class);
        IndependentActions actions = new IndependentActions.Builder()
                .addAction(mockedInternalAction)
                .build();

        actions.execute();

        Mockito.verify(mockedInternalAction).execute();
    }

    @Test
    public void stop_internalActionBeenStopped() {
        ContinuousAction mockedInternalAction = Mockito.mock(ContinuousAction.class);
        IndependentActions actions = new IndependentActions.Builder()
                .addAction(mockedInternalAction)
                .build();

        actions.stop();

        Mockito.verify(mockedInternalAction).stop();
    }

    @Test
    public void execute_previousActionFailed_stillExecuteNextActions() throws Exception {
        Action mockedInternalAction = Mockito.mock(Action.class);
        Action actions = new IndependentActions.Builder()
                .addAction(FakeActions.failAction())
                .addAction(mockedInternalAction)
                .build();

        actions.execute();

        Mockito.verify(mockedInternalAction).execute();

    }

    @Test
    public void execute_fifoOrder() throws Exception {
        Action action1 = Mockito.mock(Action.class);
        Action action2 = Mockito.mock(Action.class);
        InOrder inOrder = inOrder(action1, action2);

        Action actions = new IndependentActions.Builder()
                .addAction(action1)
                .addAction(action2)
                .build();

        actions.execute();

        inOrder.verify(action1).execute();
        inOrder.verify(action2).execute();
    }

    @Test
    public void stop_lifoOrder() throws Exception {
        ContinuousAction action1 = Mockito.mock(ContinuousAction.class);
        ContinuousAction action2 = Mockito.mock(ContinuousAction.class);
        InOrder inOrder = inOrder(action2, action1);

        IndependentActions actions = new IndependentActions.Builder()
                .addAction(action1)
                .addAction(action2)
                .build();

        actions.stop();

        inOrder.verify(action2).stop();
        inOrder.verify(action1).stop();
    }

}