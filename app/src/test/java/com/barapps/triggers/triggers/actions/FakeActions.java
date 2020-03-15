package com.barapps.triggers.triggers.actions;

import com.barapps.triggers.triggers.actions.exceptions.ActionExecutionException;

public class FakeActions {

    public static Action failAction() {
        return new Action() {
            @Override
            public void execute() throws ActionExecutionException {
                throw new ActionExecutionException();
            }
        };
    }

}
