package hello.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@Controller
@RequestMapping(path="/home/email")
public class EmailController {

    @GetMapping("/")
    public String emailForm(Model model, Model email) {
        model.addAttribute("email", new EmailAddress());
        return "email";
    }

    @PostMapping("/")
    public String emailSubmit(@ModelAttribute EmailAddress email, Model model) {
        String response = respondeHandler(email.getEmail());
        Email emailObject = createJsonEmail(response);
        model.addAttribute("email", emailObject);
        return "result";
    }

    public String respondeHandler(String email) {
        URLConnection connection = null;
        try {
            connection = new URL("https://hacked-emails.com/api?q=" + email).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        InputStream response = null;
        try {
            response = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String responseBody;
        try (Scanner scanner = new Scanner(response)) {
            responseBody = scanner.useDelimiter("\\A").next();
            try {
                writeToFile(responseBody, email);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseBody;
    }

    private Email createJsonEmail(String responseBody) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Email email = null;
        try {
            email = mapper.readValue(responseBody, Email.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return email;
    }

    public void writeToFile(String responseBody, String fileName) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        bufferedWriter.write(responseBody);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
