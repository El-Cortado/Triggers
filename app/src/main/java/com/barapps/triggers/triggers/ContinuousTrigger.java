package com.barapps.triggers.triggers;

import com.barapps.triggers.triggers.actions.ContinuousAction;
import com.barapps.triggers.triggers.conditions.Condition;

import static com.barapps.triggers.triggers.actions.Actions.tryExecute;

public class ContinuousTrigger implements Trigger {

    private final Condition mCondition;
    private final ContinuousAction mAction;

    private volatile boolean mWasExecuted;

    public ContinuousTrigger(Condition condition, ContinuousAction action) {
        mCondition = condition;
        mAction = action;

        mWasExecuted = false;
    }

    @Override
    public synchronized void run() {
        if (mCondition.test()) {
            if (!wasExecuted()) {
                tryExecute(mAction);
                mWasExecuted = true;
            }
        } else if (wasExecuted()) {
            mAction.stop();
            mWasExecuted = false;
        }

    }

    public boolean wasExecuted() {
        return mWasExecuted;
    }


}
