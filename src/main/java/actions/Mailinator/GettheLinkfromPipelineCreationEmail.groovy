package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GettheLinkfromPipelineCreationEmail{
    public static run(def params){
        def body = GetMailinatorEmail.run(params).body
        def link
        if(params."Links"=="Site Home Page"){
            println(body.substring(body.indexOf("<ul>")))
            println(body.substring(body.indexOf("<ul>") + 18))
        	link = body.substring(body.indexOf("<ul>") + 18, body.indexOf("\" style=\"color:#00f;font-family:arial;font-size:10pt;\">Site Home Page"))
            println(link)
            return link
        } else {
            link = body.substring(body.indexOf("</li>") + 19, body.indexOf("\" style=\"color:#00f;font-family:arial;font-size:10pt;\">Pipeline Steps View"))
            println(link)
            return link
        }
    }
} 