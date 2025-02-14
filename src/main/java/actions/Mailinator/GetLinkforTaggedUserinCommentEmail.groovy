package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GetLinkforTaggedUserinCommentEmail{
    public static run(def params){
        
        def body = GetMailinatorEmail.run(params).body
        println("Body: ${body}")
        def link
        link = body.substring(body.indexOf("URL:") + 4, body.indexOf("</div>"))
        println("link: ${link}")
        return link
        
    }
}