package com.barapps.triggers.triggers.actions;

import com.barapps.triggers.triggers.actions.exceptions.ActionExecutionException;

public interface Action {

    void execute() throws ActionExecutionException;
}
