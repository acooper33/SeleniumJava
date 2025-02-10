package actions.PipelineStepsView;

import actions.selenium.MouseOver
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class DragandDropStagesinPipelineStepsView{
    public void run(def params){
        
        Actions actions = new Actions(Browser.Driver)
        MouseOver.run(ID:"//DIV[contains(@class,'stage_name')]/DIV[text()='${params."Stage"}']/following-sibling::DIV[contains(@class,'order_stage_icon')]/I")        
        WebElement source = Elements.find(ID:"//*[contains(@class,'stage_holder')]//*[text()='${params."Stage"}']/following-sibling::DIV[contains(@class,'order_stage_icon')]",Browser.Driver)
        WebElement target = Elements.find(ID:"//*[contains(@id,'all_steps_inner')]/descendant::DIV[starts-with(@class,'stage_holder')][${params."New Stage Position"}]",Browser.Driver)
        actions.moveToElement(source).clickAndHold().pause(2000).moveToElement(target).moveByOffset(-40, 0).pause(2000).release().build().perform();
    }
}