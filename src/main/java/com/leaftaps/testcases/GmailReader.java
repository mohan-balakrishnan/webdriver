package com.leaftaps.testcases;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class GmailReader {

    public static void main(String[] args) {
        // Gmail IMAP server details
        String host = "imap.gmail.com";
        String mailStoreType = "imap";
        String username = "myselenium.reports@gmail.com"; // Your Gmail email address
        String password = "xqzq etlx izzs pxor";   // Replace with App Password

        // Read the emails
        checkMail(host, mailStoreType, username, password);
    }

    public static void checkMail(String host, String mailStoreType, String username, String password) {
        try {
            // Setup mail server properties
            Properties properties = new Properties();            
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.ssl.enable", "true");   // Use SSL
            properties.put("mail.imap.ssl.trust", host);      // Trust the host


            // Get the Session object
            Session emailSession = Session.getDefaultInstance(properties);

            // Create IMAP store object and connect with the email server
            Store store = emailSession.getStore(mailStoreType);
            store.connect(host, username, password);

            // Get inbox folder
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // Fetch messages from the server
            Message[] messages = emailFolder.getMessages();
            System.out.println("Total Messages: " + messages.length);

            for (int i = 0; i < 10 && i < messages.length; i++) { // Read top 10 emails
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Sent Date: " + message.getSentDate());

                // Fetch email content (if it's a text email or multipart)
                if (message.getContent() instanceof String) {
                    System.out.println("Body: " + message.getContent());
                } else if (message.getContent() instanceof Multipart) {
                    Multipart multipart = (Multipart) message.getContent();
                    for (int j = 0; j < multipart.getCount(); j++) {
                        BodyPart bodyPart = multipart.getBodyPart(j);
                        if (bodyPart.isMimeType("text/plain")) {
                            System.out.println("Body: " + bodyPart.getContent());
                        }
                    }
                }
            }

            // Close folder and store
            emailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
