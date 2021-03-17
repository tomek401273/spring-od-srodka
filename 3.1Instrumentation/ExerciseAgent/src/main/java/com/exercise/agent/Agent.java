package com.exercise.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.AgentBuilder.Default;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("Exercise agent is running.");

        AgentBuilder agentBuilder = new Default()
                .type(ElementMatchers.nameStartsWith("com.kodilla.instrumentation.User"))
                .transform(((builder, typeDescription, classLoader, module) -> {
                    System.out.println("Class " + typeDescription);
                    return builder.visit(Advice.to(MyMethodMonitor.class).on(ElementMatchers.any()));
                }));

        agentBuilder.installOn(instrumentation);
    }

    public static void agentmain(String args, Instrumentation instrumentation) {
        premain(args, instrumentation);
    }

}
