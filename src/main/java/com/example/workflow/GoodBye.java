package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class GoodBye implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Feedback:::" + delegateExecution.getVariable("feedbackDetails"));
        System.out.println("\nGoodBye:::Good Bye and See you again! Sorry about your disadvantages");
    }
}
