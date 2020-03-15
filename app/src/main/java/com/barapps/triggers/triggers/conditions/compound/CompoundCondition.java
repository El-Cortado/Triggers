package com.barapps.triggers.triggers.conditions.compound;

import com.barapps.triggers.triggers.conditions.Condition;

import java.util.List;

public interface CompoundCondition extends Condition {

    List<Condition> getConditions();
}
