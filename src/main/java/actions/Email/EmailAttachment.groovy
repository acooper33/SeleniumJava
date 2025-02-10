package actions.Email;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import actions.Email.SendMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Multipart;
import javax.mail.BodyPart;
import javax.mail.PasswordAuthentication;

class EmailAttachment{
    public static void run(def params){
        String filename
        Properties props = SetEmailProperties.run(params)
        def username = params."Sender's Email".split("@",2)[0]
        Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, params."Sender's Password");
            }
         });
        //session.setDebug(true);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(params."Sender's Email"))
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(params."To Email"))
        message.setSubject(params."Email Subject")
        //part 1 is the body
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(params."Email Body")
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        //part 2 is attachment
        messageBodyPart = new MimeBodyPart();
        def os = System.getProperty("os.name").toLowerCase();

        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            filename = System.getProperty("user.home")+"/"+"${params."File Name"}"
        }else{
            filename = System.getProperty("user.home")+"\\Downloads"+"\\${params."File Name"}"
        }
        
		//String filename = System.getProperty("user.home")+"\\Downloads"+"\\${params."File Name"}"
        println("Our file to attach is located at ${filename}")
        DataSource source = new FileDataSource(filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
        //set two complete parts
        message.setContent(multipart);
		if(SendMessage.run(session, message, params."Sender's Email", params."Sender's Password", props)){println("Successfully sent email")}
    }
}