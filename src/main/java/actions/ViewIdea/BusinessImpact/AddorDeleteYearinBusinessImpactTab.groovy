package actions.ViewIdea.BusinessImpact;

import actions.selenium.*

class AddorDeleteYearinBusinessImpactTab{
    public void run(def params){

        if(params."Add or Delete" == "Add"){
            Click.run(ID:"//*[@id='financial-impact-add-year']")
        } else {
            MouseOver.run(ID:"//*[@id='financial-table-header-row-0']/DIV[last()]")
            Click.run(ID:"//*[@id='financial-table-header-row-0']/DIV[last()]//I")
        }
    }
}