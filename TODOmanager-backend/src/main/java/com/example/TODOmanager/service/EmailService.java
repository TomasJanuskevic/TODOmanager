package com.example.TODOmanager.service;

import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;

@Service
@Slf4j
@AllArgsConstructor
public class EmailService {
    private final PdfService pdfService;
    private final JavaMailSender javaMailSender;
    private static final String EMAIL = "tomjanuskevic@gmail.com";

    public void sendEmailWIthAttachment(String toEmail) throws MessagingException, FileNotFoundException, DocumentException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setFrom(EMAIL);
        messageHelper.setTo(toEmail);
        messageHelper.setSubject("Your Tasks");
        messageHelper.setText("See your task in PDF file");

        pdfService.generatePdf();
        File file = new File(PdfService.PDF_FILE_PATH);
        messageHelper.addAttachment(file.getName(), file);

        javaMailSender.send(message);
        log.info("Email was sent with attachment");

    }
}
