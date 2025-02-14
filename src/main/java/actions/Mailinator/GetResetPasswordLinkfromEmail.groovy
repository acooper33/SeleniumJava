package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GetResetPasswordLinkfromEmail{
    public static run(def params){
        def body = GetMailinatorEmail.run(params).body
        //Parse for the Reset password
        def link
        def part
        if(body.contains("register an existing account")){
            part = body.substring(body.indexOf("</a>") + 5)
            println("part" +part)
            link = part.substring(part.indexOf("href=\"") + 6, part.indexOf("\" target"))
        } else {link = body.substring(body.indexOf("href=\"") + 6, body.indexOf("\" target"))}
        println(link)
        return link
    }
} 
