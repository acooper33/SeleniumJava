package actions.Email;

import javax.mail.Flags;
import javax.mail.Message;

class DeleteMessage{
    public static boolean run(Message message, def deleteMessage){
        try{
            message.setFlag(Flags.Flag.DELETED, deleteMessage)
            println("<Delete Message> flag set to ${deleteMessage}")
            return true
        }catch(Exception e){
            e.printStackTrace()
    		println("Error in deleting email.")
            return false
  		}
        
    }
}