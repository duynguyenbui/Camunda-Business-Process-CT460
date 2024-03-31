package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Invoice implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("LOG:::Export Invoice Processing");
        System.out.println("**************************************************");
        System.out.println("****************** INVOICE ***********************");
        System.out.println("**************************************************");
        System.out.println("SENDER INFORMATION");
        System.out.println("Name: " + delegateExecution.getVariable("senderName")
                + "\nAddress: " + delegateExecution.getVariable("senderAddress")
                + "\nPhone: " + delegateExecution.getVariable("senderPhone"));
        System.out.println("\nRECIPIENT INFORMATION");
        System.out.println("Name: " + delegateExecution.getVariable("recipientName")
                + "\nAddress: " + delegateExecution.getVariable("recipientAddress")
                + "\nPhone: " + delegateExecution.getVariable("recipientPhone"));
        System.out.println("\nPACKAGE DETAILS");
        System.out.println("Type: " + delegateExecution.getVariable("packageType")
                + "\nWeight: " + delegateExecution.getVariable("weight")
                + "\nShipping service type: " + delegateExecution.getVariable("shippingType"));
        System.out.println("**************************************************");
        System.out.println("TOTAL AMOUNT: " + delegateExecution.getVariable("amount") + " VND");
        System.out.println("**************************************************");
    }
}
