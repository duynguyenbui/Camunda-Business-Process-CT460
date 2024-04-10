package com.example.workflow;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class InvoiceDetails {
    public long extra;
    public String senderName;
    public String senderAddress;
    public String senderPhone;
    public String recipientName;
    public String recipientAddress;
    public String recipientPhone;
    public String packageType;
    public String weight;
    public String shippingType;
    public String amount;

    public InvoiceDetails(long extra, String senderName, String senderAddress, String senderPhone, String recipientName, String recipientAddress, String recipientPhone, String packageType, String weight, String shippingType, String amount) {
        this.extra = extra;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderPhone = senderPhone;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.recipientPhone = recipientPhone;
        this.packageType = packageType;
        this.weight = weight;
        this.shippingType = shippingType;
        this.amount = amount;
    }

    public InvoiceDetails() {
    }

    public void exportInvoiceDetails() {
        String now = String.valueOf(java.time.LocalDate.now());
        String milliseconds = String.valueOf(System.currentTimeMillis());

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), 12);

            // Set leading to adjust the space between lines
            contentStream.setLeading(14.5f);

            // Set initial position
            float textYPosition = page.getMediaBox().getHeight() - 50;

            // Thêm nội dung sử dụng add function
            contentStream.newLineAtOffset(50, textYPosition);
            contentStream.showText("Sender Name: " + senderName);
            contentStream.newLine();

            contentStream.showText("Sender Address: " + senderAddress);
            contentStream.newLine();

            contentStream.showText("Sender Phone: " + senderPhone);
            contentStream.newLine();

            contentStream.showText("Recipient Name: " + recipientName);
            contentStream.newLine();

            contentStream.showText("Recipient Address: " + recipientAddress);
            contentStream.newLine();

            contentStream.showText("Recipient Phone: " + recipientPhone);
            contentStream.newLine();

            contentStream.showText("Package Type: " + packageType);
            contentStream.newLine();

            contentStream.showText("Weight: " + weight);
            contentStream.newLine();

            contentStream.showText("Shipping Type: " + shippingType);
            contentStream.newLine();

            contentStream.showText("Amount: " + amount);
            contentStream.newLine();

            if (extra != 0) {
                contentStream.showText("Extra fee for Insurance: " + extra);
                contentStream.newLine();
            }

            contentStream.endText();
            contentStream.close();

            document.save("invoice-" + now.toString() + "-" + milliseconds + ".pdf");
            document.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
