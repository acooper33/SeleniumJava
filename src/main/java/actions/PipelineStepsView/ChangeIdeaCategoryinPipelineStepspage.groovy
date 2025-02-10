package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SelectItem

class ChangeIdeaCategoryinPipelineStepspage{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']")
        Click.run(ID:"//*[@id='action-category']")
        SelectItem.run(ID:"//*[@id='change_category_dropdown']","Visible Text":params."Category")
        if(params.Action=="Change Category"){Click.run(ID:"//*[@class='green_btn_container']/*[text()='Change Category']")}
        else{Click.run(ID:"//BODY/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[3]/A[1]")}
        sleep(3000)
    }
}