package actions.NGAViewIdea;

import actions.selenium.Click
import actions.selenium.SelectItem

class ChangeIdeaStepinNGAViewIdea{
    public void run(def params){
        Click.run(ID:"//*[@id='idea-step-edit']", "Type of Click":"Javascript")
        if(params."New Step"){SelectItem.run(ID:"//*[@id='update_idea_select']", "Visible Text": params."New Step")}
        if(params.Action == "Change Step"){Click.run(ID:"//*[@class='green_btn_center' and text()='Change Step']")}
        else if(params.Action=="Cancel") {Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
        sleep(1000)
        
    }
}