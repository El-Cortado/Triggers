package com.barapps.triggers.triggers.conditions.compound;

import com.barapps.triggers.triggers.conditions.FakeCondition;

import org.junit.Assert;
import org.junit.Test;

public class NotConditionTest {

    @Test
    public void test_conditionIsTrue_returnFalse() {
        Assert.assertFalse(new NotCondition(new FakeCondition(true)).test());
    }

    @Test
    public void test_conditionIsFalse_returnTrue(){
        Assert.assertTrue(new NotCondition(new FakeCondition(false)).test());
    }

}