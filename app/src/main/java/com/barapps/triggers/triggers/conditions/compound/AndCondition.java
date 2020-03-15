package com.barapps.triggers.triggers.conditions.compound;

import com.barapps.triggers.triggers.conditions.Condition;

import java.util.List;

public class AndCondition implements CompoundCondition {

    private final List<Condition> mConditions;

    public AndCondition(List<Condition> conditions) {
        mConditions = conditions;
    }


    @Override
    public boolean test() {
        for (Condition condition: mConditions) {
            if (!condition.test()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public List<Condition> getConditions() {
        return mConditions;
    }
}
