package com.nesper.alkemy.springboot.disney.models.services;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class SendGridService {

    public Response sendEmail(String email) throws IOException {
        Email from = new Email("fernandonesper@gmail.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email(email);
        Content content = new Content("text/plain", "Registro exitoso en App Disney!");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        Response response = new Response();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
            System.out.println(response.getClass());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return response;
    }
}