package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.services.email.EmailService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest request) {
        try {
            emailService.sendMockEmail(request.getTo(), request.getSubject(), request.getBody());
            return "Email enviado exitosamente a " + request.getTo();
        } catch (Exception e) {
            return "Error al enviar email: " + e.getMessage();
        }
    }

    @PostMapping("/send-html")
    public String sendHtmlEmail(@RequestBody EmailRequest request) {
        try {
            emailService.sendHtmlEmail(request.getTo(), request.getSubject(), request.getBody(), request.getFrom());
            return "Email HTML enviado exitosamente a " + request.getTo();
        } catch (Exception e) {
            return "Error al enviar email HTML: " + e.getMessage();
        }
    }

    @Data
    public static class EmailRequest {
        private String to;
        private String subject;
        private String body;
        private String from;
    }
}
