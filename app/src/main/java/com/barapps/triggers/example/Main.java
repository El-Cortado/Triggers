package com.barapps.triggers.example;

import com.barapps.triggers.triggers.Trigger;
import com.barapps.triggers.triggers.TriggerBuilder;
import com.barapps.triggers.triggers.actions.Actions;
import com.barapps.triggers.triggers.actions.compound.IndependentActions;
import com.barapps.triggers.triggers.actions.compound.RepeatingAction;

import static com.barapps.triggers.triggers.conditions.Conditions.axiom;
import static com.barapps.triggers.triggers.conditions.Conditions.not;
import static com.barapps.triggers.triggers.conditions.Conditions.or;

public class Main {

    public static void main(String[] args) {

        Trigger trigger = TriggerBuilder
                .when(not(or(axiom(), axiom())))
                .perform(Actions.empty())
                .build();



        Trigger trigger2 = TriggerBuilder
                .when(axiom())
                .perform(new IndependentActions.Builder()
                        .addAction(Actions.empty())
                        .addAction(Actions.empty())
                        .build())
                .build();

        Trigger trigger3 = TriggerBuilder
                .when(axiom())
                .perform(new RepeatingAction(Actions.empty(), 3, 10))
                .build();


    }
}