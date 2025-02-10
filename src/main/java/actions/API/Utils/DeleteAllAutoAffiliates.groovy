package actions.API.Utils;

import actions.API.HttpClient
import actions.API.Utils.BIAdminLogin

class DeleteAllAutoAffiliates{
    public void run(def params){
        //Deletes all affiliates that begins with 'auto_' to clean it up
        //Login
        BIAdminLogin.run()
        
        //Create a list of systemid's in order to delete them
        HttpClient.MainMakeRequest(Type:"GET",Path:"/bi/bi_copy_affiliate.bix",RequestContentType:"text/html,application/xhtml+xml,application/xml",ContentType:"text/html","App Environment":"BI Admin")
        
        /*
        if(!params.systemid){params.systemid=HttpClient.systemid}
        def body = [
            all_dbs:"ondemand_test",
            all_affiliates:params.systemid
        ]
        HttpClient.MainMakeRequest(Type:"POST",Path:"/bi/bi_xt_really_delete_affiliate.bix",Body:body,RequestContentType:"application/x-www-form-urlencoded",ContentType:"text/html","App Environment":"BI Admin")*/
    }
}