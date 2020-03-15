package com.barapps.triggers.triggers;

import com.barapps.triggers.triggers.actions.Action;
import com.barapps.triggers.triggers.actions.Actions;
import com.barapps.triggers.triggers.actions.ContinuousAction;
import com.barapps.triggers.triggers.conditions.Condition;

public class TriggerBuilder {

    private Condition mCondition;
    private Action mAction;

    private TriggerBuilder(Condition condition, Action action) {
        mCondition = condition;
        mAction = action;
    }

    public static TriggerBuilder when(Condition condition) {
        return new TriggerBuilder(condition, Actions.empty());
    }

    public TriggerBuilder perform(Action action) {
        mAction = action;
        return this;
    }

    public Trigger build() {
        if (mAction instanceof ContinuousAction) {
            return new ContinuousTrigger(mCondition, (ContinuousAction) mAction);
        } else {
            return new StatelessTrigger(mCondition, mAction);
        }
    }
}
