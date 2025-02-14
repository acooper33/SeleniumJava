package actions.Mailinator;

import actions.general.Navigate
import actions.general.RegisteruserfromLoginpage
import actions.Mailinator.GetRegistrationLinkfromEmail
import actions.selenium.NavigateToURL
import actions.general.CompleteUserRegistration
import actions.general.LogOut
import actions.general.Login
import actions.general.NavigateWebStormAdminBar
import actions.SetupUsers.SetWebstormSetupUsersAdministratorspage
import actions.SetupUsers.SetEnterpriseSetupUsersAdministratorspage

class CreateMailinatorUser{
    public void run(def params){
        LogOut.run()
        RegisteruserfromLoginpage.run("Email Address":params."Email"+"@mailinator.com","First Name":"Autofirst","Last Name":"Autolast")
        println("Waiting for 15 seconds...")
        sleep(15000)
        def link = GetRegistrationLinkfromEmail.run("Email Address":params."Email")
        NavigateToURL.run(URL:link)
        CompleteUserRegistration.run(Password:"brightidea1","Confirm Password":"brightidea1","Screen Name":"Auto")
        
        if(params."Webstorm Name" || params."Enterprise System Administrator" || params."Affiliate Sponsor"){
            LogOut.run()
            Login.run(Email:"bi.adminuser1@brightidea.com",Password:"brightidea1")
            
            if(params."Webstorm Name"){
                NavigateWebStormAdminBar.run("WebStorm Name":params."Webstorm Name","Area to Navigate to":"Setup")
                if(params."Webstorm Sponsor"){SetWebstormSetupUsersAdministratorspage.run("WebStorm Sponsor":params."Email"+"@mailinator.com")}
                if(params."Webstorm Administrator"){SetWebstormSetupUsersAdministratorspage.run("WebStorm Administrators":params."Email"+"@mailinator.com","WebStorm Administrators Add or Remove":"Add")}
                if(params."Webstorm Moderator"){SetWebstormSetupUsersAdministratorspage.run("Moderators":params."Email"+"@mailinator.com","Moderators Add or Remove":"Add")}
            }
            if(params."Affiliate Sponsor"){
                Navigate.run("Area to Navigate to":"Enterprise Setup")
                SetEnterpriseSetupUsersAdministratorspage.run("Affiliate Sponsor":params."Email"+"@mailinator.com")
            }
            if(params."Enterprise System Administrator"){
                Navigate.run("Area to Navigate to":"Enterprise Setup")
                SetEnterpriseSetupUsersAdministratorspage.run("System Administrators":"Auto","System Administrators Add or Remove":"Add")
            }
        }
        LogOut.run()
        Login.run(Email:params."Finally Login as What User")
    }
}