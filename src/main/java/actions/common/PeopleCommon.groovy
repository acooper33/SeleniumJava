package actions.common;

import actions.selenium.Click
import actions.selenium.ExecuteJavascript

class PeopleCommon{
    public static void NavigateTab(def params){
        //Tab (required) = Users, Certifications, Invite Email
        
        //Scroll to top first because top Bright idea bar might interfere with navigation
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        switch(params.Tab){
            case "Users":
            	Click.run(ID:"//*[@id='people-page-tabs']")
            	sleep(3000)
            	break
            case "Certifications":
            	Click.run(ID:"//*[@id='people-tab-certifications']")
            	break
            case "Administrators":
            	Click.run(ID:"//*[@id='people-tab-admins']")
            	break
            case "Invite Email":
            	Click.run(ID:"//*[@id='people-tab-email']")
            	break
            case "Licenses":
            	Click.run(ID:"//*[@id='people-tab-licenses']")
            	break
        }
    }
    
    public static void ExpandLicenseBreakdown(def params){
        def license
        if(params.License =="Brightidea Administrator License Type"){
            license = "admin"        
        } else if(params.License =="Idea Box Manager License Type"){
            license = "idea-box-manager"
        } else if (params.License =="Brightidea Moderator Licenses"){
			license = "moderator"
        }else {
            license = "whiteboard"
        }
        Click.run(ID:"//*[contains(@class,'${license}-license-container')]//*[contains(@class,'admins-unexpanded')]/BUTTON") 
        sleep(4000) 
    }
}