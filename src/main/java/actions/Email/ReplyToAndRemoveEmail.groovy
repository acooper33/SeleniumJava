package actions.Email;

import actions.Email.RetrieveMessage;
import actions.Email.CreateReplyMessage;
import actions.Email.SendMessage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Folder;
import javax.mail.Store;
import java.utils.*;


class ReplyToAndRemoveEmail{
    public void run(def params){
        Properties props = SetEmailProperties.run(params)
        def username = params."Sender's Email".split("@",2)[0]
        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){return new PasswordAuthentication(username, params."Password")}
        });
        Store store = session.getStore("imaps");
        store.connect(params."Sender Host", params."Sender's Email", params."Password")
        Folder inbox = store.getFolder(params.Folder);
        inbox.open(Folder.READ_WRITE);
        println("In Inbox folder...")
        
        //retrieve an email, get Reply To address and create a new email message addressed to that Reply To address        
        Message message = RetrieveMessage.run(params, session, inbox)
        if(message==null){return}
        params."To Email" = message.getReplyTo().toString().replace("[", "").replace("]","")
        println("Retrieve Subject: ${message.getSubject()}")
        println("Retrieved ReplyTo : ${params."To Email"} , Type: ${params."To Email".getClass()}") 
        
        props.put("mail.smtp.host", "smtp.mail.yahoo.com")
        session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){return new PasswordAuthentication(username, params."Password")}
        });
        /*if(params."Email body"){
			Message newMessage = CreateNewMessage.run(session, params)
            if (newMessage==null){return}
            if (SendMessage.run(session, newMessage, params."Sender's Email", params."Password", props)) {println("Successfully sent email")}
        }*/
        Message newMessage = CreateNewMessage.run(session, params)
        if (newMessage==null){return}
        if (SendMessage.run(session, newMessage, params."Sender's Email", params."Password", props)) {println("Successfully sent email")}
        DeleteMessage.run(message, params."Remove Email")
        inbox.close(params."Remove Email") //if true, all marked 'Deleted' emails will get deleted from server
        store.close()  
    }
}