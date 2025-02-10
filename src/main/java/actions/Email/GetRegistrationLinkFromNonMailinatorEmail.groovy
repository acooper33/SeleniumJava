package actions.Email;

import javax.mail.Store;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.internet.*
import actions.Email.DeleteMessage;
import java.io.InputStream
import java.utils.*;

class GetRegistrationLinkFromNonMailinatorEmail{
    public static def run(def params){
        Properties props = SetEmailProperties.run(params)
        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){return new PasswordAuthentication(params."Sender's Email", params."Password")}
        })
        Store store = session.getStore("imaps");
        store.connect(params."Sender Host", params."Sender's Email", params."Password")
        Folder inbox = store.getFolder(params.Folder);
        inbox.open(Folder.READ_WRITE);
        Message message = RetrieveMessage.run(params, session, inbox)
        def content = message.getContent()
        def link = content.substring(content.indexOf("title=\"Join Now!\" href=\"") + 24, content.indexOf("\" target"))
        DeleteMessage.run(message, true)
        inbox.close(true) //if true, all marked 'Deleted' emails will get deleted from server
       	store.close()
        return link
        
    }
}