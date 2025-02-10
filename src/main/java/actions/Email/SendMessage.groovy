package actions.Email;

import javax.mail.Transport;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;

class SendMessage{
    public static boolean run(Session session, Message message, def username, def password, Properties props){
        int iTimeout = 5
        while(iTimeout > 0){
            try{
        		println("In SendMessage")
            	Transport transport = session.getTransport("smtp")
                transport.connect((String)props.get("mail.host"), username, password) //error here
                println("Will send email to: ${message.getAllRecipients()}")	
	       		transport.sendMessage(message, message.getAllRecipients())
        		transport.close() //connection closed
            	return true
        	}catch(Exception e){
            	iTimeout--
                sleep(2000)
                println("Error while sending message! Email not sent! Error:")
            	e.printStackTrace()
            	println("Trying again ${iTimeout}")
        	}
        }
        return false //if we get here, means smth went wrong with sending the message
    }
}