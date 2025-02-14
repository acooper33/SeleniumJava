package actions.CommandCenter;

import actions.selenium.Exists


class VerifyTopUsersbyReputationPointsinCommandCenter{
    public void run(def params){
        sleep(3000)
        println(params."User Name")
        println(params."Reputation Points")
        println(params."Row Number")
        if(params."User Name"){
            assert(Exists.run(ID:"//*[@id='active-users']//table/tbody/tr['${params."Row Number"}']/td[@class='screen_name']/a[text()='${params."User Name"}']", "Timeout":60)>0), "Error"
        	assert(Exists.run(ID:"//*[@id='active-users']//table/tbody/tr['${params."Row Number"}']/td[@class='point' and text()='${params."Reputation Points"}']", "Timeout":60)>0), "Error - invalid number of points"
        }
        
    }
}