package actions.WebstormCreation;

import actions.common.AppsCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SendKeys
import actions.selenium.ExecuteJavascript
import actions.selenium.SetReactTags
import actions.WebstormCreation.SetClickOnAppTileInAppsPillarPage

class CreateAppWebstorm{
    public void run(def params){

        SetClickOnAppTileInAppsPillarPage instance = new SetClickOnAppTileInAppsPillarPage()
		// Define the parameters as a map
		def apps = [ "App Name": params."App Name" ]
		// Call the run method with the parameters
		instance.run(apps)
/*        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        def appName
        def appCardTitle
        
        if(params."App Name".contains("Ideabox")){
           appName = params."App Name".split(" ")[0]
           appCardTitle = "Idea Box"
        } else if(params."App Name".contains(" ") && !params."App Name".contains("Ideabox") ){
            appName = "app-card-" + params."App Name".replaceAll(" ", "_").toLowerCase() 
            appCardTitle = params."App Name" 
        } else { 
            appName = params."App Name" 
            appCardTitle = params."App Name" 
        }
        println("appName is ${appName}")
        println("appCardTitle is ${appCardTitle}")
        
        if(Exists.run(ID:"//*[@class='app-card' and contains(@id,'${appName.toLowerCase()}')]/DIV[@class='app-card-text']/SPAN[@class='app-card-name' and text()='${appCardTitle}']")>0){
            Click.run(ID:"//*[@class='app-card' and contains(@id,'${appName.toLowerCase()}')]/DIV[@class='app-card-text']/SPAN[@class='app-card-name' and text()='${appCardTitle}']")
            Click.run(ID:"//*[@id='phase-app-detail']//BUTTON[@class='btn btn-primary navigate']")
        }else if(Exists.run(ID:"//DIV[contains(@class,'f-apps-cards')]/A/P[contains(@class,'f-apps-card-name') and starts-with(.,'${params."App Name"}')]")>0){
            Click.run(ID:"//DIV[contains(@class,'f-apps-cards')]/A/P[contains(@class,'f-apps-card-name') and starts-with(.,'${params."App Name"}')]")
        }*/
        if(params."Sponsor Name"){AppsCommon.UserPickerAddRemove("Field Name":"Sponsor",User:params."Sponsor Name","Add or Remove":params."Sponsor Add or Remove")}
        if(params."Webstorm Title"){SetText.run(Text:params."Webstorm Title",ID:"//*[@id='name']")}
        if(params."Description") {SetText.run(Text:params."Description",ID:"//*[@id='description']")}
        if(params."Action on General Information Tab"== null || params."Action on General Information Tab" == "Continue"){
            Click.run(ID:"//*[@class='bi-button-success-md']")
        }
        else if(params."Action on General Information Tab"== "Cancel"){
            Click.run(ID:"//*[@data-action='cancel']")
        }
        
        //Some have Business Model before going to Desing
        if(Exists.run(ID:"//*[@id='setup-main']//*[text()='SITE DESIGN']")==0){
            if(params."Business Model"){Click.run(ID:"//*[@id='setup-main']//LABEL[text()='${params."Business Model"}']")}
            Click.run(ID:"//BUTTON[@class='bi-button-success-md' and text()='Continue']")
        }
        
        AppsCommon.ChooseDesignTemplate(params)

        AppsCommon.UserPickerAddRemove("Field Name":"Early Access",User:params."Early Access","Add or Remove":params."Early Access Add or Remove")
        AppsCommon.UserPickerAddRemove("Field Name":"General Access",User:params."General Access","Add or Remove":params."General Access Add or Remove")
        
         if(params."Type of Licensing Model" == "Standard Licensing Model"){
            if(params."Idea Box Managers") SetReactTags.setMemberTagsWithAddRemoveNewSetupWizard("Field Name":"Idea Box Managers",User:params."Idea Box Managers","Add or Remove":params."Idea Box Managers Add or Remove")      
			if(params."Pipeline Administrators") SetReactTags.setMemberTagsWithAddRemoveNewSetupWizard("Field Name":params."Admin Field Name",User:params."Pipeline Administrators","Add or Remove":params."Administrators Add or Remove")
            if(params."Moderators") SetReactTags.setMemberTagsWithAddRemoveNewSetupWizard("Field Name":"Pipeline Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")

			//AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":"Idea Box Managers",User:params."Idea Box Managers","Add or Remove":params."Idea Box Managers Add or Remove")
             //AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":params."Admin Field Name",User:params."Pipeline Administrators","Add or Remove":params."Administrators Add or Remove")
             //AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":"Pipeline Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")
         } else {
             AppsCommon.UserPickerAddRemove("Field Name":"Pipeline Administrators",User:params."Pipeline Administrators","Add or Remove":params."Administrators Add or Remove")
             AppsCommon.UserPickerAddRemove("Field Name":"Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")
        }

        AppsCommon.ImportUserGroup("Import User Group As":params."Import Group as","Import Group File":params."Import File","Add or Remove User Group":params."Add or Remove Group","Import User Group Action":params."Import Group Action","Check Complete Modal Action":params."Check Modal Action","Group Name":params."Group Name")
        
        //Some have Create while others Continue, so if Continue exists then click on it
        sleep(5000)
        if(Exists.run(ID:"//BUTTON[@class='bi-button-success-md' and text()='Continue']")>0 && Exists.run(ID:"//*[text()='Participants']")>0){Click.run(ID:"//BUTTON[@class='bi-button-success-md' and text()='Continue']")}
        sleep(3000) //slooooow
        if(params."Action"){
            ExecuteJavascript.run(Code:"window.scrollTo(100, 100);")
            if(params."Action"=="Cancel"){
                Click.run(ID:"//*[@data-action='cancel']")
            }
            else if(params."Action"=="Back"){
                Click.run(ID:"//*[@data-action='back']")
            }
            else{
                sleep(5000)
                Click.run(ID:"//*[@data-action='create']")
                sleep(5000)
            }
        }
        sleep(10000)
    }
}