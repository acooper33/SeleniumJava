package actions.Email;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;


class CreateNewMessage{
    public static Message run(Session session, def params){
        println("Creating new message...")
        try{
            def replyTo
            Message message = new MimeMessage(session)
            message.setFrom(new InternetAddress(params."Sender's Email"))
            println("From: ${params."Sender's Email"}")
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(params."To Email"))
            println("To: ${params."To Email"}")
        	message.setSubject(params."Email Subject")
            println("Subject: ${params."Email Subject"}")
        	message.setText(params."Email Body")
            println("Body: ${params."Email Body"}")
            if(params."Attachment"){
                String filename = System.getProperty("user.home")+"\\Downloads"+"\\${params."Attachment"}"
                DataSource source = new FileDataSource(filename);
                message.setDataHandler(new DataHandler(source));
                message.setFileName(filename);
            }
        	return message
        }catch(Exception e){
            println("Error while creating new message!")
            e.printStackTrace()
    		return null
        }
    }
}