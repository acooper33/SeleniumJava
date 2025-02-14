package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Click
import actions.selenium.Exists
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor

class RearrangeFieldinSubmissionFormBuilder{
    public void run(def params){
      	if (Exists.run(ID:"//*[@id='ideas_tab']")>0){
            SetupCommon.NavigateTab(Tab:"Ideas",Section:"Submission Form")
            Click.run(ID:"//*[@id='edit-idea']")
        }
        sleep(3000)
        final String jsMove ="var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +"ction(format,data){this.items[format]=data;this.types.append(for" +"mat);},getData:function(format){return this.items[format];},clea" +"rData:function(format){}};var emit=function(event,target){var ev" +"t=document.createEvent('Event');evt.initEvent(event,true,false);" +"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +"'drop',tgt);emit('dragend',src);"
        //WebElement source = Elements.find(ID:"//*[@class='f-question-row f-question-header']//*[text()='${params."Field Title"}']/../../../*[@class='f-rearrange-icon']",Browser.Driver)
        WebElement source = Elements.find(ID:"//*[contains(@class, 'f-question-header')]/DIV/H3[contains(normalize-space(),'${params."Field Title"}')]/../../../*[@class='f-drag-handle']",Browser.Driver)
        WebElement target = Elements.find(ID:"//*[contains(@class,'f-submission-form-questions-scroll')]/descendant::DIV[@class='f-drag-handle'][${params."New Row Number"}]",Browser.Driver)
        
        //WebElement target = Elements.find(ID:"//*[contains(@class,'f-submission-form-questions-scroll')]/descendant::DIV[@class='f-rearrange-icon'][${params."New Row Number"}]",Browser.Driver)
        ((JavascriptExecutor)Browser.Driver).executeScript(jsMove, source, target)
        sleep(4000)
        Click.run(ID:"//*[@class='f-submission-form-buttons']//*[text()='Save Form']")
        sleep(4000)
    }
}