package com.barapps.triggers.triggers.conditions.compound;

import com.barapps.triggers.triggers.conditions.Condition;
import com.barapps.triggers.triggers.conditions.Conditions;
import com.barapps.triggers.triggers.conditions.FakeCondition;

import org.junit.Assert;
import org.junit.Test;

public class OrConditionTest {

    @Test
    public void test_allFalse_shouldBeUnverified() {
        Condition orCondition = Conditions.or(
                (new FakeCondition(false)),
                (new FakeCondition(false)),
                (new FakeCondition(false)));

        Assert.assertFalse(orCondition.test());
    }

    @Test
    public void test_AtLeastOneTrue_shouldBeVerified() {
        Condition orCondition = Conditions.or(
                (new FakeCondition(false)),
                (new FakeCondition(false)),
                (new FakeCondition(true)));

        Assert.assertTrue(orCondition.test());
    }

}