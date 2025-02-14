package actions.ViewIdea;
import actions.selenium.Click

class RemoveImageInViewIdeaPage{
    public void run(def params){
        Click.run(ID:"//*[@id='inline-edit-icon-idea-image']","Type of Click":"Javascript")
        Click.run(ID:"//*[@id='remove-idea-image']")
        if(params.Action=="Cancel"){Click.run(ID:"//*[@id='idea-image-remove-popup']//*[text()='Cancel']")}
        else if(params.Action=="Close"){Click.run(ID:"//*[@id='idea-image-remove-popup']//*[text()='Close']")}
        else{Click.run(ID:"//*[@id='idea-image-remove-popup']//*[text()='Remove']")}
    }
}