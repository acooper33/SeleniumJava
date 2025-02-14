package actions.Mailinator;

import actions.API.HttpClient


class GetMailinatorEmail{
    public static def run(def params){
        //RETURNS: email.subject, email.from, email.body
        
        def response
        def emailID
        def token = "8b78dcda9cc34e0da48d7c28ede59eda"
        sleep(7000)
        for(int i = 1;i <= 10;i++){
            sleep(7000)
            response = HttpClient.MakeRequest(RequestContentType:"text/html",ContentType:"application/json",Type:"GET",URL:"https://api.mailinator.com/api/inbox?to=${params."Email Address"}&token=${token}")
            println("Response data: "+response.responseData)
            try{
                //println(response.responseData.public_msgs[0])
                emailID = response.responseData.messages[0].id
                break
            }
            catch(Exception | Error e){
                println("Try number: "+i)
            }
        }
        def email = [:]
        //check in case no emails is expected
        if(params."Email Should Be Received"==false && emailID == null){return email}
        assert emailID != null,"Error - Email was not received by ${params."Email Address"}@mailinator.com"
        println("Email ID: "+emailID)
        sleep(6000)
        
        //Get the email content based on emailID
        response = HttpClient.MakeRequest(RequestContentType:"text/html",ContentType:"application/json",Type:"GET",URL:"https://api.mailinator.com/api/email?id=${emailID}&token=${token}")
        email.subject = response.responseData.data.subject
        email.from = response.responseData.data.from
        email.body = response.responseData.data.parts[0].body
        email.origfrom = response.responseData.data.origfrom
        println("Subject: ${email.subject}")
        println("From: ${email.from}")
        println("Origfrom: ${email.origfrom}")
        println("Body: ${email.body}")
        sleep(7000)
        
        response = HttpClient.MakeRequest(RequestContentType:"text/html",ContentType:"application/json",Type:"GET",URL:"https://api.mailinator.com/api/delete?id=${emailID}&token=${token}").responseData
        sleep(1000)
        response = HttpClient.MakeRequest(RequestContentType:"text/html",ContentType:"application/json",Type:"GET",URL:"https://api.mailinator.com/api/delete?id=${emailID}&token=${token}").responseData
        println("Delete response: "+response)
        return email
        
	}
}