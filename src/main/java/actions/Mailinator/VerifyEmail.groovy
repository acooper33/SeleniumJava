package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail
import java.lang.Math

class VerifyEmail{
    public void run(def params){
        def email = GetMailinatorEmail.run(params)
        if(params."Email Should Be Received"==false){
            println("Email should NOT exist")
            if(email.size()>0){
                println("Found some emails")
                if(params.Subject){
          			assert !email.subject.contains(params.Subject),"Error - Email with Subject '${email.subject}' received"
                }
                if(params.From){
           			assert !email.from.contains(params.From),"Error - Email From '${email.from}' received"
        		}
                if(params."Full From"){
            		assert !email.origfrom.contains(params."Full From"),"Error - Email Origfrom '${email.origfrom}' received"
        		}
            }else{
                println("No Emails Found")
               return 
            } 
            
        }else{
            assert email.size()>0, "Error - Email was not received by ${params."Email Address"}@mailinator.com"
            println("Email Should Be Received")
        	if(params.Subject){
          		assert email.subject.contains(params.Subject),"Error - Email Subject '${email.subject}' does not contain searched for value"
        	}
        	if(params.From){
           		assert email.from.contains(params.From),"Error - Email From '${email.from}' does not contain searched for value"
        	}
        	if(params."Full From"){
            	assert email.origfrom.contains(params."Full From"),"Error - Email Origfrom '${email.origfrom}' does not contain searched for value"
        	}
        }
    }
}