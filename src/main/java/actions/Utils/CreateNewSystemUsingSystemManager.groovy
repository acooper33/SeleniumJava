package actions.Utils;

import actions.API.HttpClient

class CreateNewSystemUsingSystemManager{
    public String run(def params){
        
        def name = "auto"+System.currentTimeMillis().toString()
        def body = [:]
        def URLPath = redwood.launcher.Launcher.variables.URL
        println("URLPath: ${URLPath}")
        
        body = [
                company:name,
                domain:name,
            	name:name
            ]
        
        def response = HttpClient.MainMakeRequest(Type:"POST",Path:"/systemManager/create",Body:body,RequestContentType:"application/x-www-form-urlencoded",ContentType:"application/json","App Environment":"System Manager").responseData
        println("Response: ${response}")
        println("Affiliate Name = ${name}")
        HttpClient.affiliatename = name
        def affiliateid = response.affiliate
        HttpClient.affiliateid = affiliateid
        println("AffiliateID = ${affiliateid}")
        def systemid = response.systemId
        HttpClient.systemid = systemid
        println("SystemID = ${systemid}")
        
        body = [
                 affiliate: affiliateid,
                 dbName: "OnDemand_MySQLAutomation",
                 onCreate: true,
             ]
        
        response = HttpClient.MainMakeRequest(Type:"POST",Path:"/systemManager/updateConfiguration",Body:body,RequestContentType:"application/x-www-form-urlencoded",ContentType:"application/json","App Environment":"System Manager").responseData
        def affURL = "https://${name}.${URLPath.split("\\.")[1]}.com"
        println("Affiliate URL: ${affURL}")
        return affURL
        //return "https://${name}.${URLPath.split("\\.")[1]}.com"
              
    }
}