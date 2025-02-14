package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GetEvaluationsLinkinEmailEvaluations{
    public static run(def params){
    def body = GetMailinatorEmail.run(params).body
        println("Body: ${body}")
        def link
        link = body.substring(body.indexOf(">https") + 1, body.indexOf("</a>"))
        println("link: ${link}")
        return link
        
    }
}