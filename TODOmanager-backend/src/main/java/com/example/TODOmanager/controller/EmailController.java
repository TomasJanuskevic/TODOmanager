package com.example.TODOmanager.controller;

import com.example.TODOmanager.service.EmailService;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/{toEmail}")
    public void sendEmailWithTasks(@PathVariable String toEmail) throws FileNotFoundException, DocumentException, MessagingException {
        emailService.sendEmailWIthAttachment(toEmail);
    }
}
