package actions.Utils


import actions.SSOLogin.SetSSOLogin
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Browser
import actions.general.NavigatetoSSOAffiliate
import actions.general.SetLicenseManager

class CreateAffiliateWithSystemManager{
    public String run(def params){
        
        def name = "auto"+System.currentTimeMillis().toString()
        def URLPath = redwood.launcher.Launcher.variables.URL
        def URL
        switch(URLPath.split("\\.")[1]){
                 case "brightideatest":
            	 	URL ="https://www."+"brightideatest.com/systemManager"
                 break
                 case "brightideasandbox":
					URL = "https://www."+"brightideasandbox.com/systemManager"
                 break
             }
        
        Browser.run("Browser Type":"Chrome","URL":URL) //to create an instance of Browser and navigate to System Manager
        if(!params."Username Email"){params."Username Email" = "bi.adminuser1@brightidea.com"}
        SetSSOLogin.run(Username:params."Username Email", Password:"Brightidea!16", "SSO Test":false) //SSO Login; update password here if needed
        
        SetText.run(ID:"//*[@id='company-name-setup']", Text:name)
        SetText.run(ID:"//*[@id='system-name-setup']", Text:name)
        SetText.run(ID:"//*[@id='domain-setup']", Text:name)
        
        Click.run(ID:"//DIV[contains(@class,'fractal-product-config')]//LABEL[@class='select-all-or-none' and .='Select All']") //select all
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_rules_engine']") //rules engine
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_category_assignment']") //category assignment
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_communities']") //Communities
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_sso']") //SSO
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_global_reporting']") //Global Reporting 
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_configurable_email']") //Configurable Emails  
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_configuration_submission_name']") //Configurable Submission Names  
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_packaging_system_user_home']") //Enterprise Pages  
        Click.run(ID:"//DIV[@class='fractal-apps']//LABEL[@for='feature_configurable_statuses']") //Configurable Statuses 
        Click.run(ID:"//*[@class='f-radio-lockup']//DIV[@aria-label='Full Team Workspace']") //Full Team Workspace
        Click.run(ID:"//BUTTON[@id='admin-console-create-system']")
        
        println("Affiliate Name: ${name}")
        println("Affiliate URL: https://${name}.${URLPath.split("\\.")[1]}.com")
        sleep(10000)
        SystemManagerHelper.setAffiliatename(name)
        SystemManagerHelper.setAffiliateURL("https://${name}.${URLPath.split("\\.")[1]}.com")
        ReturnAffiliateID.run() //sets affiliate ID 
        RetrunSystemID.run()    //sets system ID 
        
        //setting up licensing model with License Manager
        if(params."Licensing Model"=="Standard Licensing Model"){
            NavigatetoSSOAffiliate.run("DomainName":"licenseManager")
        	SetLicenseManager.run(System:SystemManagerHelper.getAffiliateURL(), "Licensing Model":params."Licensing Model", "Unlimited Brightidea Administrator License Type":params."Unlimited Brightidea Administrator License Type",
                              "Brightidea Administrator License Type Purchased Count":params."Brightidea Administrator License Type Purchased Count", 
                             "Unlimited Idea Box Manager License Type":params."Unlimited Idea Box Manager License Type", "Idea Box Manager License Type Purchased Count":params."Idea Box Manager License Type Purchased Count")
        }
        return "https://${name}.${URLPath.split("\\.")[1]}.com"
    }
}