package data;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
public class Email {
    private final String username = "anna.bodnar.oi.2022@lpnu.ua";
    private final String password = "04.12.2005";
    public void send() {
//        final String username = "anna.bodnar.oi.2022@lpnu.ua";
//        final String password = "04.12.2005";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("anna.bodnar.oi.2022@lpnu.ua"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("anna.bodnar.oi.2022@lpnu.ua")
            );
            message.setSubject("Testing");
//            message.setText("Dear Anna,"
//                    + "\n\n Test message");
            BodyPart messageBody = new MimeBodyPart();
            messageBody.setText("Надсилаю лог файл");
            MimeBodyPart file = new MimeBodyPart();
            file.attachFile(new File("C:\\Users\\38098\\lr7\\src\\main\\resources\\Report.txt"));
            Multipart multipart=new MimeMultipart();
            multipart.addBodyPart(messageBody);
            multipart.addBodyPart(file);
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void registrationVerification(String mail){
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("anna.bodnar.oi.2022@lpnu.ua"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail)
            );
            message.setSubject("Testing");
            message.setText("Congratulations!!!"
                    + "\n\n Account on this email succesfully registered.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
