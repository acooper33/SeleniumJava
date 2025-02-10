package actions.WebstormCreation;

import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.ExecuteJavascript

class SetClickOnAppTileInAppsPillarPage{
    public void run(def params){
        
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
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
        
        if(Exists.run(ID:"//*[contains(@class,'backbone-link app-link')]/*[not(contains(@class,'app-disabled'))]/..//*[@class='app-card' and contains(@id,'${appName.toLowerCase()}')]/DIV[@class='app-card-text']/SPAN[@class='app-card-name' and contains(text(),'${appCardTitle}')]")>0){
            Click.run(ID:"//*[@class='app-card' and contains(@id,'${appName.toLowerCase()}')]/DIV[@class='app-card-text']/SPAN[@class='app-card-name' and contains(text(),'${appCardTitle}')]")
            if(params."Click on Setup button"==null || params."Click on Setup button"==true){
                Click.run(ID:"//*[@id='phase-app-detail']//BUTTON[@class='btn btn-primary navigate']")                
            }
        }else if(Exists.run(ID:"//DIV[contains(@class,'f-apps-cards')]/A/P[contains(@class,'f-apps-card-name') and starts-with(.,'${params."App Name"}')]")>0){
            Click.run(ID:"//DIV[contains(@class,'f-apps-cards')]/A/P[contains(@class,'f-apps-card-name') and starts-with(.,'${params."App Name"}')]")
        }
    }
}
