package com.barapps.triggers.triggers.actions;

import com.barapps.triggers.triggers.actions.exceptions.ActionExecutionException;

public class Actions {

    public static ContinuousAction empty() {
        return new ContinuousAction() {
            @Override
            public void stop() { }

            @Override
            public void execute() { }
        };
    }

    public static void tryExecute(Action action) {
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            // TODO: Log about action execution failure
        }
    }
}
