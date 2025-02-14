package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GetLinkforIdeasforSubscribedIdeaEmail{
    public static run(def params){
        
        def body = GetMailinatorEmail.run(params).body
        println("Body: ${body}")
        def link
        link = body.substring(body.indexOf("https:"), body.indexOf("</div>"))
        println("link: ${link}")
        return link
        
    }
}