package actions.Email;

import javax.mail.Store;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.internet.*
import actions.Email.DeleteMessage;
import java.io.InputStream
import java.utils.*

class GetMemoNewCommentLinkFromNonMailinatorEmail{
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
        //extract whats in between 'https'
        def startIndex = content.indexOf("https://")
        def endIndex = content.indexOf("https://", content.indexOf("https://")+1)-2
        //println("First Index: ${startIndex}")
        //println("End Index: ${endIndex}")
        def link = content.substring(startIndex, endIndex)
        println("link: ${link}")
        
        DeleteMessage.run(message, true)
        inbox.close(true) //if true, all marked 'Deleted' emails will get deleted from server
       	store.close()
        return link
    }
}