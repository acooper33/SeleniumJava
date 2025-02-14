package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail

class GetLinkfromActionItemEmail{
   public static run(def params){
        def body = GetMailinatorEmail.run(params).body
        //Parse for the Reset password
        def link
        link = body.substring(body.indexOf("href=\'") + 6, body.indexOf("\'>https:"))
        println(link)
        return link
    }
} 
