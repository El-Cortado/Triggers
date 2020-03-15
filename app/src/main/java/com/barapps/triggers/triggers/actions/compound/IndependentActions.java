package com.barapps.triggers.triggers.actions.compound;

import com.barapps.triggers.triggers.actions.Action;
import com.barapps.triggers.triggers.actions.ContinuousAction;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static com.barapps.triggers.triggers.actions.Actions.tryExecute;

/**
 * Defines collection of independent actions. Each {@link Action} been invoked independently
 * by iterating the pre-defined actions.
 */
public class IndependentActions implements ContinuousAction {

    private final Deque<Action> mActions;

    private IndependentActions(Deque<Action> actions) {
        mActions = actions;
    }

    @Override
    public synchronized void execute() {
        for (Action action : mActions) {
            tryExecute(action);
        }
    }

    @Override
    public synchronized void stop() {
        Iterator<Action> actionIterator = mActions.descendingIterator();
        while (actionIterator.hasNext()) {
            Action action = actionIterator.next();
            if (action instanceof ContinuousAction) {
                ((ContinuousAction)action).stop();
            }
        }
    }

    public static class Builder {

        private final Deque<Action> mActions;

        public Builder() {
            mActions = new ArrayDeque<>();
        }

        public Builder addAction(Action action) {
            mActions.add(action);
            return this;
        }

        public IndependentActions build() {
            return new IndependentActions(mActions);
        }
    }
}
