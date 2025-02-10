package actions.Email;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

class CreateReplyMessage{ //this action not used yet, but might in the future
    public static Message run(Message message, Session session, def params){
        try{
            Message replyMessage = new MimeMessage(session)
            replyMessage = (MimeMessage) message.reply(false) //creates a reply msg as Reply (false), or replyAll(true)
            replyMessage.setFrom(new InternetAddress(params."Email Address"))
            replyMessage.setText(params."Email Body")
            replyMessage.setReplyTo(message.getReplyTo())
            return replyMessage
            
    	}catch(Exception e){
            e.printStackTrace()
    		println("Error in replying to email.")
            return null
        
    	}
    }
}