package actions.ViewIdea;
import actions.selenium.ExecuteJavascript
import actions.selenium.Click
import actions.selenium.SelectItem

class SetCategoryForViewIdeaPage{
    public void run(def params){
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        Click.run(ID:"//*[@id='inline-edit-icon-idea-category']","Type of Click":"Javascript")
        SelectItem.run(ID:"//*[@id='category-list-dropdown']","Visible Text":params."Field Value")
        if(params.Action=="Change Category") {
            Click.run(ID:"//*[@class='bimodal-footer']//*[text()='Change Category']")
        } else { Click.run(ID:"//*[@class='bimodal-container']//*[text()='${params.Action}']")}
        sleep(2000)
    }
}