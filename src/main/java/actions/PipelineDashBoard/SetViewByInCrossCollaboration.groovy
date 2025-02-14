package actions.PipelineDashBoard;

import actions.selenium.Click

class SetViewByInCrossCollaboration{
    public static void ViewBy(def params){
        
        //SelectItem.run(ID:"//*[@id='collaborators-select']","Visible Text":params)
        //SelectItem.run(ID:"//*[@class='f-collab-container']/../..//select","Visible Text":params)
        Click.run(ID:"//*[@class='f-collab-container']/..//DIV[contains(@class,'dropdown-container')]//*[@data-test='f-test-dropdown']")
        sleep(500)
        Click.run(ID:"//UL[contains(@class,'f-dropdown-options') and contains(@style, 'display: block')]//LI[contains(.,'${params}')]")
    }
}