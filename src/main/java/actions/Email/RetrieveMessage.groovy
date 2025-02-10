package actions.Email;

import javax.mail.Store;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.internet.*
import javax.mail.internet.ParameterList
import java.io.InputStream
import javax.activation.*
import java.utils.*;

class RetrieveMessage{
    public static Message run(def params, Session session, Folder inbox){
        def bodyStr
        System.out.println(ParameterList.class.getResource("ParameterList.class"));
        println("Retrieving Message... ")
        System.getProperty("java.class.path")
        def j =1
        try{
            Message[] messages = inbox.getMessages()
            println("Retrieved ${messages.length} messages")
            
            if (params."Email Subject to Look For"){
                println("Searching by Subject: ${params."Email Subject to Look For"}")
                for(def i=0; i<messages.length; i++){
                    println("Subject: ")
                    println(messages[i].getSubject())
                    if (messages[i].getSubject().contains(params."Email Subject to Look For")){
                        println("Retrieved Message: Subject: ${messages[i].getSubject()}")
                        println("From: ${messages[i].getFrom()}")
                        println("ReplyTo: ${messages[i].getReplyTo()}")
                        println("Content: ${messages[i].getContent()}")
                        if(params.Body){
                            if(params."Clean Up Spec Chars from Body"){
                                bodyStr = messages[i].getContent().toString().replaceAll("\\<.*?>","").trim().replaceAll("\\s","")
								println("Body Cleaned: ${bodyStr}")
                            }else{
                                bodyStr = messages[i].getContent()
                            }
                           if(bodyStr.contains(params.Body)){
                            //if(messages[i].getContent().contains(params.Body)){
                                return messages[i]}
                    	}else{
                            return messages[i]
                        }
                 	} 
               }
            //if no Email Subject specified, return the latest message in inbox
            }else{return messages[messages.length-1]} 
        }catch(Exception e){
            e.printStackTrace()
            return null
  		}
        
    }
}