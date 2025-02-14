package actions.common


import actions.selenium.*
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class SetupCommon{
    public static void NavigateTab(def params){
        //Tab (required) = Site, Scheduling, Users, etc.
        //ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        Click.run(ID:"//A[text()='${params.Tab}']")

        if(params.Section){
            if(params.Tab=='BI' && params.Section=='Custom') {
                Click.run(ID:"//LI[@id='bi_custom_tab']")
            } else if(params.Tab=='Users' && params.Section=='Groups'){
                Click.run(ID:"//LI[@id='groups_old_tab']")
            }else if(params.Tab=='Users' && params.Section=='Manage'){
                Click.run(ID:"//LI[contains(@id,'manage')]")
            }
            else if(params.Tab=='Users' && params.Section=='EnterpriseSetupGroups'){
                Click.run(ID:"//LI[@id='usergroups_tab']")
            }
            else if(params.Tab=='Exports' && params.Section=='Initiatives'){
                Click.run(ID:"//LI[@id='rep_campaigns_tab']")
            }
            else if(params.Tab=='Exports' && params.Section=='Users'){
                Click.run(ID:"//LI[@id='rep_users_tab']")
            }
            else if(params.Tab=='Site' && params.Section=='Global Navigation'){
                Click.run(ID:"//LI[@id='global_navigation_tab']")
            }
            else if (params.Tab == "Ideas" && params.Section=="Idea Boards"){
                Click.run(ID: "//*[@id='idea_boards_tab']","Type of Click":"Javascript")
            }  
            else if (params.Tab == "Ideas" && params.Section=="Submission Form"){
                Click.run(ID: "//*[@id='submission_form_tab']")
            }
            else if (params.Tab == "Site" && params.Section=="Navigation"){
                Click.run(ID: "//LI[@id='navigation_tab']")
            }     
            else if(params.Tab=='BI Only' && params.Section=='Beta'){
                sleep(1000)
                Click.run(ID:"//a[text()='BI Only']")
            }
            else if(params.Tab=='Exports' && params."Section"=='Categories'){
                Click.run(ID:"//*[@id='rep_category_tab']")
            }
            else if(params.Tab=='Beta' && params."Section"=="Beta"){
                Click.run(ID:"//*[@id='beta_beta_tab']")
            }
            else if(params.Tab=='Mail' && params."Section"=="Idea Comments"){
                Click.run(ID:"//*[@id='idea_comments_tab']")
            }
            else if(params.Tab=='Initiatives' && params."Section"=="Communities"){
                Click.run(ID:"//*[@id='pooling_tab']")
            }
            else if(params.Tab=='Ideas' && params."Section"=="Team Workspace"){
                Click.run(ID:"//*[@id='team_workspace_tab']")
            }
            else if(params.Tab=='BI Only' && params."Section"=="Search"){
                Click.run(ID:"//*[@id='bi_search_tab']")
            }
            else {Click.run(ID:"//LI[contains(text(),'${params.Section}')]")}
         }
    }
    public static void setWarningModal(def params){
        if(params."Tick the Checkbox"==true){
            Click.run(ID:"//*[contains(@class,'f-modal-body')]//DIV[contains(@class,'f-checkbox')]//LABEL[starts-with(.,'I understand')]/../..//INPUT[@type='checkbox']/..")
        }
        if(params."Action"){
            def j = 1
            if(Exists.run(ID:"//*[contains(@class,'f-idea-modal-container')]")>0){j = 2}
            if(params."Action".contains("Add") | (params."Action".contains("Insert")) | (params."Action".contains("Update"))){
                Click.run(ID:"(//*[contains(@class,'footer')]//BUTTON[position()='2'])[${j}]")
            } else {
                Click.run(ID:"(//*[contains(@class,'footer')]//BUTTON[position()='1'])[${j}]")
            }
        }
    }
    public static void VerifyModalWarningBody(def params){
        if(params.Body){
            WebElement modal = Elements.find(ID:"//*[contains(@class,'f-modal-body')]",Browser.Driver)
            println("Warning message: ${modal.getText()}")
            println("Expected: ${params."Body"}")
            assert Exists.run(ID:"//*[contains(@class,'f-modal-body')]//*[contains(.,'${params.Body}')]")>0, "Error - Expected Warning Message Does Not Exist"
        }
        //SetActionOnChangeBackgroundModal.setAction(Action:"Update") //same elements, reusing this action from image modal;
        setWarningModal(Action:"Update") //same elements, reusing this action from image modal;
    }
}
