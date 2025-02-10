package actions.WebstormCreation;

import actions.common.AppsCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SelectItem
import actions.selenium.ExecuteJavascript

class CreateSolveWebstorm{
    public void run(def params){

        if(Exists.run(ID:"//*[@data-action='cancel']")==0){ 
            Click.run(ID:"//*[@class='app-card' and contains(@id,'${params."App Name".toLowerCase()}')]")
            Click.run(ID:"//*[@id='phase-app-detail']//BUTTON[@class='btn btn-primary navigate']")
        }  

        // General Information Tab
        AppsCommon.UserPickerAddRemove("Field Name":"Sponsor",User:params."Sponsor Name","Add or Remove":params."Sponsor Add or Remove")
        if(params."Webstorm Title"){SetText.run(Text:params."Webstorm Title",ID:"//*[@id='name']")}
        if(params."Challenge Brief") {SetText.run(Text:params."Challenge Brief",ID:"//*[@id='description']")}
        if(params."Action on General Information Tab"){
            if(params."Action on General Information Tab" == "Continue"){
                Click.run(ID:"//*[@class='bi-button-success-md']")
            }
            else {
                Click.run(ID:"//*[@data-action='cancel']")
            }
        }

        // Design Information Tab
        AppsCommon.ChooseDesignTemplate(params)

        // Participants Tab
        AppsCommon.UserPickerAddRemove("Field Name":"Early Access",User:params."Early Access","Add or Remove":params."Early Access Add or Remove")
        AppsCommon.UserPickerAddRemove("Field Name":"General Access",User:params."General Access","Add or Remove":params."General Access Add or Remove")
        AppsCommon.UserPickerAddRemove("Field Name":"Pipeline Administrators",User:params."Pipeline Administrators","Add or Remove":params."Administrators Add or Remove")
        AppsCommon.UserPickerAddRemove("Field Name":"Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")
        AppsCommon.ImportUserGroup("Import User Group As":params."Import Group as","Import Group File":params."Import File","Add or Remove User Group":params."Add or Remove Group","Import User Group Action":params."Import Group Action","Check Complete Modal Action":params."Check Modal Action","Group Name":params."Group Name")
        if(params."Action on Participants Tab"){
            sleep(4000)
            if (params."Action on Participants Tab"=="Continue"){
                Click.run(ID:"//*[@class='bi-button-success-md']")
            } else if(params."Action on Participants Tab"=="Cancel"){
                Click.run(ID:"//*[@data-action='cancel']")
            } else {
                Click.run(ID:"//*[@data-action='back']")
                sleep(4000)
            }
        }

        // Site Schedule Tab
        if(params."End Date"){SetText.run(Text:params."End Date",ID:"//*[@id='end-date']","Type of Clear":"Cut")
                              Click.run(ID:"//*[@id='setup-header-title']")}
        if(params."End Time"){SelectItem.run(ID:"//*[@id='end-date-timepicker']","Visible Text":params."End Time")}
        if(params."Launch Date"){SetText.run(Text:params."Launch Date",ID:"//*[@id='start-date']","Type of Clear":"Cut")
                                 Click.run(ID:"//*[@id='setup-header-title']")}
        if(params."Launch Time"){SelectItem.run(ID:"//*[@id='start-date-timepicker']","Visible Text":params."Launch Time")}
        if(params."Action on Site Schedule Tab"){
            sleep(4000)
            if (params."Action on Site Schedule Tab"=="Continue"){
                Click.run(ID:"//*[@class='bi-button-success-md']")
            } else if(params."Action on Site Schedule Tab"=="Cancel"){
                Click.run(ID:"//*[@data-action='cancel']")
            } else{
                Click.run(ID:"//*[@data-action='back']")
            }
            sleep(4000)
        }

        //Communications Tab
        if(Exists.run(ID:"//*[@id='setup-main']//*[@class='title' and text()='Communications']")==1){
            if(params."Launch Message"){SetText.run(Text:params."Launch Message",ID:"//*[@id='communications-launch']","Type of Clear":"Cut")
                                        Click.run(ID:"//*[@id='setup-header-title']")}
            if(params."Launch Message Toggle"=="OFF"){Click.run(ID:"//*[text()='Launch Message']/../../..//label[@class='btn btn-primary toggle-on']")}
            if(params."Challenge Update"){SetText.run(Text:params."Challenge Update",ID:"//*[@id='communications-update']","Type of Clear":"Cut")
                                          Click.run(ID:"//*[@id='setup-header-title']")}
            if(params."Challenge Update Toggle"=="OFF"){Click.run(ID:"//*[text()='Challenge Update']/../../..//label[@class='btn btn-primary toggle-on']")}
            if(params."Challenge Last Day"){SetText.run(Text:params."Challenge Last Day",ID:"//*[@id='communications-last']","Type of Clear":"Cut")
                                            Click.run(ID:"//*[@id='setup-header-title']")}
            if(params."Challenge Last Day Toggle"=="OFF"){Click.run(ID:"//*[text()='Challenge Last Day']/../../..//label[@class='btn btn-primary toggle-on']")}
            if(params."Challenge End"){SetText.run(Text:params."Challenge End",ID:"//*[@id='communications-end']","Type of Clear":"Cut")
                                       Click.run(ID:"//*[@id='setup-header-title']")}
            if(params."Challenge End Toggle"=="OFF"){Click.run(ID:"//*[text()='Challenge End']/../../..//label[@class='btn btn-primary toggle-on']")}
            if(params."Action on Communications Tab") {
                sleep(2000)
                if(params."Action on Communications Tab"=="Continue"){
                    Click.run(ID:"//*[@class='bi-button-success-md']")
                } else if(params."Action on Communications Tab"=="Cancel"){
                    Click.run(ID:"//*[@data-action='cancel']")
                } else {
                    Click.run(ID:"//*[@data-action='back']")  
                }
                sleep(4000)
            }
        }

        //Process Tab
        AppsCommon.UserPickerAddRemove("Field Name":params."Single Scale Field",User:params."Single Scale Field Assignee","Add or Remove":params."Single Scale Assignee Add or Remove")
        AppsCommon.UserPickerAddRemove("Field Name":params."Scorecard Field",User:params."Scorecard Field Assignee","Add or Remove":params."Scorecard Field Assignee Add or Remove")
        if(params."Scorecard Template"){SelectItem.run(ID:"//*[@id='scorecard_template']","Visible Text":params."Scorecard Template")}
        if(params."Action on Process Tab"){
            sleep(2000)
            ExecuteJavascript.run(Code:"window.scrollTo(100, 100);")
            if(params."Action on Process Tab"=="Continue"){
                Click.run(ID:"//*[@class='bi-button-success-md' and @data-tab='review']")
                sleep(5000)
            } else if(params."Action on Process Tab"=="Cancel"){
                Click.run(ID:"//*[@data-action='cancel']")
            } else {
                Click.run(ID:"//*[@data-action='back']")
            }
            sleep(4000)
        }

        //Review Tab
        if(params."Action"){
            ExecuteJavascript.run(Code:"window.scrollTo(100, 100);")
            if(params."Action"=="Cancel"){
                Click.run(ID:"//*[@data-action='cancel']")
            }
            else if(params."Action"=="Back"){
                Click.run(ID:"//*[@data-action='back']")
            }
            else{
                Click.run(ID:"//*[@data-action='create']")
                sleep(15000)
            }
        }
    }
}