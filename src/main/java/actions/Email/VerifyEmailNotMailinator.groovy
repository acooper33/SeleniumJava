package actions.Email;

import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Folder;
import javax.mail.Store;
import actions.Email.DeleteMessage;
import actions.Email.RetrieveMessage;
import java.utils.*;
import javax.mail.Message;

class VerifyEmailNotMailinator{
    public void run(def params){
        Properties props = SetEmailProperties.run(params)
        props.put("mail.store.protocol", "imaps")
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){return new PasswordAuthentication(params."Sender's Email", params."Password")}
        })
        Store store = session.getStore("imaps");
        store.connect(params."Sender Host", params."Sender's Email", params."Password")
        Folder inbox = store.getFolder(params.Folder);
        inbox.open(Folder.READ_WRITE);
        println("In Inbox folder...")
        
        Message message = RetrieveMessage.run(params, session, inbox)
        if (params."Email Should Exist" == false) {assert message == null, "Error - Unexpected Email was receieved" }
        else {
            assert message != null, "Error - Expected Email Wasn't Received"
            DeleteMessage.run(message, true)
            inbox.close(true) //if true, all marked 'Deleted' emails will get deleted from server
        	store.close()
        }   
    }
}