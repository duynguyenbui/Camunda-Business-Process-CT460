package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PrintPDF implements JavaDelegate {
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

        InvoiceDetails invoice = new InvoiceDetails(extra, senderName,
                senderAddress, senderPhone, recipientName, recipientAddress,
                recipientPhone, packageType, weight, shippingType, amount);

        try {
            invoice.exportInvoiceDetails();
            System.out.println("Print PDF successfully");
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
