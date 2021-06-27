package com.example.TODOmanager.service;

import com.example.TODOmanager.model.Task;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class PdfService {

    public static final String PDF_FILE_PATH = "src/main/resources/static/TaskList.pdf";
    private final TaskService taskService;

    public void generatePdf() throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(PDF_FILE_PATH));

        document.open();
        printAllTasks(document);
        document.close();
    }

    private void printAllTasks(Document document) throws DocumentException {
        List<Task> tasks = taskService.findAllTasks();
        int counter = 1;
        Paragraph taskParagraph;
        for (Task task : tasks) {
            String text = counter++ + ". " + task.getTitle() + ": " + task.getTask() + ".";
            taskParagraph = new Paragraph(text);
            document.add(taskParagraph);
        }
    }
}
