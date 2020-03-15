package com.barapps.triggers.example;

import com.barapps.triggers.triggers.ContinuousTrigger;
import com.barapps.triggers.triggers.Trigger;
import com.barapps.triggers.triggers.TriggerBuilder;
import com.barapps.triggers.triggers.actions.Actions;

import static com.barapps.triggers.triggers.conditions.Conditions.axiom;
import static com.barapps.triggers.triggers.conditions.Conditions.not;
import static com.barapps.triggers.triggers.conditions.Conditions.or;

public class Main {

    public static void main(String[] args) {

        Trigger trigger = TriggerBuilder
                .when(not(or(axiom(), axiom())))
                .perform(Actions.empty())
                .build();



    }
}