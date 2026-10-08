package murach.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Sends email through Gmail's SMTP server, which REQUIRES authentication.
 *
 * IMPORTANT: Gmail no longer accepts your normal account password here.
 * Turn on 2-Step Verification, then create an "App password"
 * (Google Account -> Security -> App passwords) and use that 16-character
 * password below.
 */
public class MailUtilGmail {

    // TODO: replace with your own Gmail address and App password
    private static final String USERNAME = "nguyendinhalam@gmail.com";
    private static final String PASSWORD = "jyln pzee plqt htkx";

    public static void sendMail(String to, String from,
                                String subject, String body, boolean bodyIsHTML)
            throws MessagingException {

        // 1 - get a mail session
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");
        Session session = Session.getInstance(props);
        session.setDebug(true);

        // 2 - create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html; charset=UTF-8");
        } else {
            message.setText(body);
        }

        // 3 - address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // 4 - send the message (authentication required)
        Transport transport = session.getTransport();
        try {
            transport.connect(USERNAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
        } finally {
            transport.close();
        }
    }

    /** The Gmail account used to send (Gmail rewrites From to this anyway). */
    public static String getSenderAddress() {
        return USERNAME;
    }
}
