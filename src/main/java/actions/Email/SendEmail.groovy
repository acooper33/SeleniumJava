package actions.Email;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import actions.Email.SetEmailProperties;
import actions.Email.CreateNewMessage;
import actions.Email.SendMessage;

class SendEmail{
    public void run(def params){
        Properties props = SetEmailProperties.run(params) 
        def username = params."Sender's Email".split("@",2)[0]
        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){return new PasswordAuthentication(username, params."Sender's Password")}
        });
        session.setDebug(true);
        Message newMessage = CreateNewMessage.run(session, params)
        if(newMessage==null){return}
        if(SendMessage.run(session, newMessage, params."Sender's Email", params."Sender's Password", props)){println("Successfully sent email")}
    }
}