package com.barapps.triggers.triggers;

import com.barapps.triggers.triggers.actions.Action;
import com.barapps.triggers.triggers.conditions.Condition;

import static com.barapps.triggers.triggers.actions.Actions.tryExecute;

public class StatelessTrigger implements Trigger {

    private final Condition mCondition;
    private final Action mAction;

    public StatelessTrigger(Condition condition, Action action) {
        mCondition = condition;
        mAction = action;
    }

    @Override
    public void run() {
        if (mCondition.test()) {
            tryExecute(mAction);
        }
    }
}
