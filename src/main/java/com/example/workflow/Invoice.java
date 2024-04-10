package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Invoice implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        // Export Invoice Online
        long extra = 0;
        String senderName = delegateExecution.getVariable("senderName").toString();
        String senderAddress = delegateExecution.getVariable("senderAddress").toString();
        String senderPhone = delegateExecution.getVariable("senderPhone").toString();
        String recipientName = delegateExecution.getVariable("recipientName").toString();
        String recipientAddress = delegateExecution.getVariable("recipientAddress").toString();
        String recipientPhone = delegateExecution.getVariable("recipientPhone").toString();
        String packageType = delegateExecution.getVariable("packageType").toString();
        String weight = delegateExecution.getVariable("weight").toString();
        String shippingType = delegateExecution.getVariable("shippingType").toString();
        String amount = delegateExecution.getVariable("amount").toString();

        if (delegateExecution.getVariable("extra") != null) {
            extra = (long) delegateExecution.getVariable("extra");
        }

        System.out.println("LOG:::Export Invoice Processing");
        System.out.println("**************************************************");
        System.out.println("****************** INVOICE ***********************");
        System.out.println("**************************************************");
        System.out.println("SENDER INFORMATION");
        System.out.println("Name: " + senderName
                + "\nAddress: " + senderAddress
                + "\nPhone: " + senderPhone);
        System.out.println("\nRECIPIENT INFORMATION");
        System.out.println("Name: " + recipientName
                + "\nAddress: " + recipientAddress
                + "\nPhone: " + recipientPhone);
        System.out.println("\nPACKAGE DETAILS");
        System.out.println("Type: " + packageType
                + "\nWeight: " + weight
                + "\nShipping service type: " + shippingType);
        System.out.println("**************************************************");
        if (extra != 0) {
            System.out.println("Insurance for " + packageType + ": " + extra);
        }
        System.out.println("Amount: " + amount + " VND");
        System.out.println("**************************************************");
    }
}
