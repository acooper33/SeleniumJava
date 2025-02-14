package actions.MTS;

import actions.selenium.*

class SetHoverMenuonMemoTemplateTiles{
    public void run(def params){
        
        MouseOver.run(ID:"//*[contains(@class,'f-template-title') and text()='${params."Template"}']/../..")
        Click.run(ID:"//*[contains(@class,'f-template-item-memo')]//*[contains(@class,'fractal-clickoutside')]//*[@data-test='f-test-dropdown']")
        sleep(2000)
        Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//*[text()='${params."Menu Option"}']")
        sleep(2000)
    }
}