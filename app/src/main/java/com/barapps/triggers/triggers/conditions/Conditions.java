package com.barapps.triggers.triggers.conditions;

import com.barapps.triggers.triggers.conditions.compound.AndCondition;
import com.barapps.triggers.triggers.conditions.compound.CompoundCondition;
import com.barapps.triggers.triggers.conditions.compound.NotCondition;
import com.barapps.triggers.triggers.conditions.compound.OrCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Conditions {

    public static Condition axiom() {
        return () -> true;
    }

    public static Condition not(Condition condition) {
        return new NotCondition(condition);
    }

    public static Condition or(Condition... conditions) {
        return new OrCondition(Arrays.asList(conditions));
    }

    public static Condition and(Condition... conditions) {
        return new AndCondition(Arrays.asList(conditions));
    }

    public static List<Condition> flat(Condition condition) {
        List<Condition> conditionList = new ArrayList<>();

        if (condition instanceof CompoundCondition) {
            for (Condition internalCondition: ((CompoundCondition) condition).getConditions()) {
                conditionList.addAll(Conditions.flat(internalCondition));
            }
        } else {
            return Collections.singletonList(condition);
        }

        return conditionList;
    }
}
