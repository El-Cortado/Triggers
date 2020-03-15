package com.barapps.triggers.triggers.conditions.compound;

import com.barapps.triggers.triggers.conditions.Condition;
import com.barapps.triggers.triggers.conditions.Conditions;
import com.barapps.triggers.triggers.conditions.FakeCondition;

import org.junit.Assert;
import org.junit.Test;

public class AndConditionTest {

    @Test
    public void test_allTrue_shouldBeVerified() {
        Condition andCondition = Conditions.and(
                (new FakeCondition(true)),
                (new FakeCondition(true)),
                (new FakeCondition(true)));

        Assert.assertTrue(andCondition.test());
    }

    @Test
    public void test_AtLeastOneFalse_shouldBeUnverified() {
        Condition andCondition = Conditions.and(
                (new FakeCondition(true)),
                (new FakeCondition(false)),
                (new FakeCondition(true)));

        Assert.assertFalse(andCondition.test());
    }

}