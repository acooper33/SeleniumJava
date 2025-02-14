package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GetLinkfromReviewRequestEmail{
    public static def run(def params){
        
        def body = GetMailinatorEmail.run(params).body
        //Parse for the Registration link
        def link
        link = body.substring(body.indexOf("href=\'") + 6, body.indexOf("\' style"))
        println(link)
        return link
    }
}
