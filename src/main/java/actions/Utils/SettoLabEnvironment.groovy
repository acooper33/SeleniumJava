package actions.Utils;

import actions.API.HttpClient
import actions.general.Navigate
import actions.general.LogOut
import actions.general.Login
import actions.common.SetupCommon
import actions.selenium.*
    
class SettoLabEnvironment{
    public void run(def params){
        if(redwood.launcher.Launcher.variables.CodeEnvironment=="Labs"){
            println("Switching to Labs Code Environment!")
            
            //If user is not admin, then login as admin first
            if(params."Email"!="bi.adminuser1@brightidea.com" && params."Email" != null){
                println("relogin")
                LogOut.run()
                Login.run(Email:"bi.adminuser1@brightidea.com",Password:"brightidea1")
            }
            
            Navigate.run("Area to Navigate to":"Enterprise Setup")
            SetupCommon.NavigateTab(Tab:"Site",Section:params."Info")
            Click.run(ID:"//*[@id='add_host_name']")
            SetText.run(ID:"//*[@id='domain_name_container']/DIV[2]/INPUT[1]",Text:HttpClient.affiliatename+".bidev.us")
        	Click.run(ID:"//*[@id='site_info_save_button']")
            //CloseWindow.run()
            //Browser.run(URL:"https://"+HttpClient.affiliatename+".bidev.us","Browser Type":redwood.launcher.Launcher.variables.Browser)
            //LogOut.run()
            println("Navigate to LABS url: "+"https://"+HttpClient.affiliatename+".bidev.us")
            NavigateToURL.run(URL:"https://"+HttpClient.affiliatename+".bidev.us")
            if(!params."Email"){params."Username Email"="bi.adminuser1@brightidea.com"}
            Login.run(Email:params."Email",Password:"brightidea1")
            //sleep(5000)
        }
    }
}