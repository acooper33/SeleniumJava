package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GetTheRegistrationLinkFromCommentEmail{
    public static run(def params){
        
        def body = GetMailinatorEmail.run(params).body
        println("Body: ${body}")
        def link
        link = body.substring(body.indexOf("link: ") + 6)
        println("link: ${link}")
        return link
    }
} 