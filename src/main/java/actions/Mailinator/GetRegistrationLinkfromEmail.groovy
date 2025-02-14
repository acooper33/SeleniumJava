package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GetRegistrationLinkfromEmail{
    public static def run(def params){
        //def body = GetMailinatorEmail.run(params).body
        def emailReceived = GetMailinatorEmail.run(params)
        def body = emailReceived.body
        println("subject received: ${emailReceived.subject}")
        println("from received: ${emailReceived.from}")
        if(emailReceived.subject.contains("no subject")){
            println("Will repeat get email")
            sleep(30000)
            emailReceived = GetMailinatorEmail.run(params)
            body = emailReceived.body
            println("subject received: ${emailReceived.subject}")
        	println("from received: ${emailReceived.from}")
        }
        def link
        //Parse for the Registration link
        if(body.contains("Join Now")){link = body.substring(body.indexOf("title=\"Join Now!\" href=\"") + 24, body.indexOf("\" target"))}
        else if(body.contains("Follow this link to complete registration:")){link = body.substring(body.indexOf(">https:")+1, body.indexOf("</a>"))}
        else if(body.contains("To register and join their team, please follow this link:")){link = body.substring(body.indexOf(">https:")+1, body.indexOf("</a>"))}
        else if(body.contains("To view the room, and start working, click here:")){link = body.substring(body.indexOf(">https:")+1, body.indexOf("</a>"))}
        else{
            println("Expected email message not found, using default https link")
            link = body.substring(body.indexOf("blank_\">") + 8, body.indexOf("</a>"))
        }
        println(link)
        return link
    }
}