package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ThankYou implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Evaluate:::" + delegateExecution.getVariable("numberOfStar"));
        System.out.println("\nThank You:::Thank you for using our services! Hope to have a room in the future.");
    }
}
