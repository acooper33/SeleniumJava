package actions.Utils;

import actions.API.HttpClient

class CreateMemoFreeTrial{
    public String run(def params){
        
        def name = "ftqafreetrialmemoauto"+System.currentTimeMillis().toString()
        def body = [:]
        def temp = params."Type of Free Trial".toLowerCase()

        body = [          
                first_name:"System",
                last_name:"Admin",
                email:"bi.adminuser1@brightidea.com",
                domain:name,
                password:"brightidea1",
                version:"2",
            	load_data: "false",
            	template: "${temp}",
            	db_name:"OnDemand_MySQLAutomation"
            ]  
        
        def response = HttpClient.MainMakeRequest(Type:"POST",Path: "/freeTrial/create",Body:body,RequestContentType:"application/x-www-form-urlencoded",ContentType:"application/json","App Environment":"Free Trial").responseData
             def affiliateid = response.affiliate
             HttpClient.affiliateid = affiliateid
             println("AffiliateID = ${affiliateid}")
             def systemid = response.systemId
             HttpClient.systemid = systemid
             println("SystemID = ${systemid}")
        
        switch(params."Type of Free Trial"){
            case "Ideabox":
            	return "https://${name}.brightideatest.com/ideabox"
				break
            case "Memo":
            	return "https://${name}.brightideatest.com/mts/MemoProgram"
				break
            case "Whiteboard":
            	return "https://${name}.brightideatest.com/userhome?wboxfree-trial"
				break            
        }
    }
}
