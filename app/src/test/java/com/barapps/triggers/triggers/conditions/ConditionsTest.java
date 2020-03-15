package com.barapps.triggers.triggers.conditions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ConditionsTest {

    @Test
    public void flat() {
        Condition c1 = Conditions.axiom();
        Condition c2 = Conditions.axiom();
        Condition c3 = Conditions.axiom();

        Condition condition = Conditions.or(Conditions.and(c1, c3), Conditions.not(c2));

        Assert.assertEquals( Conditions.flat(condition), Arrays.asList(c1, c2, c3));
    }

}