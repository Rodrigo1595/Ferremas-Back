package cl.duocuc.asy.ferremas.services.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    @Async
    public void sendMockEmail(String to, String subject, String body) {
        try {
            // Detectar si el contenido es HTML
            if (isHtmlContent(body)) {
                sendHtmlEmail(to, subject, body);
            } else {
                sendPlainTextEmail(to, subject, body);
            }
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar email", e);
        }
    }

    private void sendHtmlEmail(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true); // true indica que es HTML
        helper.setFrom("no-reply@demomailtrap.co");
        
        mailSender.send(message);
    }

    private void sendPlainTextEmail(String to, String subject, String textBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(textBody);
        message.setFrom("no-reply@demomailtrap.co");
        mailSender.send(message);
    }

    private boolean isHtmlContent(String content) {
        // Detectar si el contenido contiene etiquetas HTML
        return content != null && 
               (content.contains("<html>") || 
                content.contains("<body>") || 
                content.contains("<div>") || 
                content.contains("<p>") || 
                content.contains("<br>") ||
                content.contains("</"));
    }

    // Método adicional para enviar HTML específicamente
    @Async
    public void sendHtmlEmail(String to, String subject, String htmlBody, String from) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        helper.setFrom(from != null ? from : "no-reply@demomailtrap.co");
        
        mailSender.send(message);
    }
}
