package com.npl.employeemanager.services;

import com.npl.employeemanager.model.EmpUser;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired private Environment environment;

    @Override
    public void sendWelcomeEmail(EmpUser empUser) throws IOException{

        String supportEmailAddress=environment.getProperty("employee.support.email");
        String sendGridKey=environment.getProperty("sendgrid.api.key");

        Email fromAddress = new Email(supportEmailAddress);

        String subject = "Profile Created with Employee Manager ";

        Email toAddress = new Email(empUser.getUserName());

        Content content = new Content("text/plain", "Welcome aboard, your credentials have been created : userName = "+empUser.getUserName()+
                " , password = "+empUser.getPassword()+"\n\n"+"Thank You -  Employee Manager Team");

        Mail mail = new Mail(fromAddress, subject, toAddress, content);

        SendGrid sg = new SendGrid(sendGridKey);

        Request request = new Request();

        try {

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);

        } catch (IOException ex) {

            System.out.println("error sending email"+ex.getMessage());
            throw ex;
        }
    }
}
