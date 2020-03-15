package com.barapps.triggers.triggers.conditions.compound;

import com.barapps.triggers.triggers.conditions.Condition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrCondition implements CompoundCondition {

    private final List<Condition> mConditions;

    public OrCondition(List<Condition> conditions) {
        mConditions = conditions;
    }


    @Override
    public boolean test() {
        for (Condition condition: mConditions) {
            if (condition.test()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Condition> getConditions() {
        return mConditions;
    }
}
