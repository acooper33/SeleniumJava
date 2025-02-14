package actions.NGAViewIdea;

import actions.selenium.Click
import actions.selenium.SelectItem

class ChangeIdeaCategoryinNGAViewIdea{
    public void run(def params){
        Click.run(ID:"//*[@id='idea-category-edit']", "Type of Click":"Javascript")
        SelectItem.run(ID:"//*[@id='category-list-dropdown']", "Visible Text": params."New Idea Category")
        if(params.Action=="Change Category"){Click.run(ID:"//*[@class='green_btn_center' and text()='Change Category']")}
        else{Click.run(ID:"//*[@id='change-category-popup']//A[text()='Cancel']")}
        sleep(3000)
    }
}