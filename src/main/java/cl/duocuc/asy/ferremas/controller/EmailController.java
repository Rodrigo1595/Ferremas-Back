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
        // Aquí puedes mockear el body, subject, etc. si quieres
        emailService.sendMockEmail(request.getTo(), request.getSubject(), request.getBody());
        return "Email enviado a " + request.getTo();
    }

    @Data
    public static class EmailRequest {
        private String to;
        private String subject;
        private String body;
    }
}
