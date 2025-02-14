package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem

class SetWebstormSetupCategoryIdeasTab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Categories")

        SetCheckBox.run(ID:"//*[@id='CB_DISABLE_SUBMISSION_CATEGORIES']",Check:params."Submission Categories")
        if(params."Submission Categories"==false){ 
            Click.run(ID:"//*[@data-test='modal-footer-submit']")
        }  

        if(params."Action"){
            if (params."Action"=="Add"){
                SetText.run(ID:"//INPUT[@id='category_add']", Text:"${params."New Category Name"}")
                Click.run(ID:"//*[@id='mark_cat_def']/A")
            } else if(params."Action"=="Modify"){
                SetText.run(ID:"//INPUT[@value='${params."Original Category Name"}' and contains(@id,'cat_input')]", Text:"${params."New Category Name"}")
                Click.run(ID:"//*[@id='category_add']") 
            } else {
                Click.run(ID:"//INPUT[@value='${params."Original Category Name"}']/../../..//*[contains(@class,'fa fa-trash-o')]")
                if(params."Delete Category Option"){
                    if(params."Delete Category Option"=="Delete ideas"){
                        Click.run(ID:"//*[@id='DELETE_CAT_ALL_IDEAS']")
                    } else {
                        SelectItem.run(ID:"//*[@id='available_cat']","Visible Text":params."New Category Name")  
                    }
                }
                if(params."Delete Category Action"=="OK"){
                    sleep(3000)
                    Click.run(ID:"//DIV[@id='delete_category_div']//INPUT[@id='cat_ideas_ok_btn']")
                }    
                else if (params."Delete Category Action"=="Cancel"){
                    sleep(3000)
                    Click.run(ID:"//DIV[@id='delete_category_div']//INPUT[@value='Cancel']")
                }   
            }
        }
    }
}


