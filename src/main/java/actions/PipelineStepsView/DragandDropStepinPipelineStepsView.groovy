package actions.PipelineStepsView;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class DragandDropStepinPipelineStepsView{
    public void run(def params){
       	Actions actions = new Actions(Browser.Driver);
        WebElement source = Elements.find(ID:"//*[contains(@id,'step-header')]//*[text()='${params."Step"}']",Browser.Driver)
        WebElement target = Elements.find(ID:"//*[contains(@id,'all_steps_inner')]/descendant::DIV[contains(@class,'apply_sortable')][${params."New Step Position"}]//*[@class='step_header_name']/../..",Browser.Driver)
        actions.moveToElement(source).clickAndHold().pause(2000).moveToElement(target).moveByOffset(-40, 0).pause(2000).release().build().perform();
    }
}