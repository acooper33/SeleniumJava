package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail
    
class GetLinkfromInviteParticipantEmail{
    public static def run(def params){
        
        def email = [:]
        def link = []
        def body,bodyofAnotherEmail
        email = GetMailinatorEmail.run(params)
        body = email.body
        if(params."Inbox Email Count"=="1" || params."Inbox Email Count"==null){
            link << body.substring(body.indexOf("href=\"") + 6, body.indexOf("\" style"))
        } else {
            if((email.subject).contains(params."Subject of New Administrator Added Email")){
                link << body.substring(body.indexOf("href=\"") + 6, body.indexOf("\" style"))
                bodyofAnotherEmail = GetMailinatorEmail.run(params).body
                link << bodyofAnotherEmail.substring(bodyofAnotherEmail.indexOf("title=\"Join Now!\" href=\"") + 24, bodyofAnotherEmail.indexOf("\" target"))
            } else {
                bodyofAnotherEmail  = GetMailinatorEmail.run(params).body
                link << bodyofAnotherEmail.substring(bodyofAnotherEmail.indexOf("href=\"") + 6, bodyofAnotherEmail.indexOf("\" style"))
                link << body.substring(body.indexOf("title=\"Join Now!\" href=\"") + 24, body.indexOf("\" target"))
            }
            println(link[1])
            println(link[0])
        }
        return link
    }
} 