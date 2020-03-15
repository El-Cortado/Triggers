package com.barapps.triggers.triggers.conditions.compound;

import com.barapps.triggers.triggers.conditions.Condition;

import java.util.Collections;
import java.util.List;

public class NotCondition implements CompoundCondition {

    private final Condition mCondition;

    public NotCondition(Condition condition) {
        mCondition = condition;
    }

    @Override
    public boolean test() {
        return !mCondition.test();
    }

    @Override
    public List<Condition> getConditions() {
        return Collections.singletonList(mCondition);
    }
}
