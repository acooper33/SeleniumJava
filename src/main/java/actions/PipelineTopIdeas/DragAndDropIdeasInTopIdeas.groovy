package actions.PipelineTopIdeas;

import actions.selenium.DragAndDrop
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Click
import actions.selenium.Exists
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.interactions.Actions
import actions.selenium.MouseOver

class DragAndDropIdeasInTopIdeas{
    public void run(def params){
        final String jsMove ="var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +"ction(format,data){this.items[format]=data;this.types.append(for" +"mat);},getData:function(format){return this.items[format];},clea" +"rData:function(format){}};var emit=function(event,target){var ev" +"t=document.createEvent('Event');evt.initEvent(event,true,false);" +"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +"'drop',tgt);emit('dragend',src);"
        WebElement source = Elements.find(ID:"//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea Title"}')]/../..",Browser.Driver)	
        if(params."Category"){
            WebElement target = Elements.find(ID:"//*[@class='f-stack-title']/*[text()='${params."Category"}']/../../..//*[contains(@class,'f-stack-scroll-area')]/..",Browser.Driver)
        	((JavascriptExecutor)Browser.Driver).executeScript(jsMove, source, target)   
        }
    	else if(params."My List Title"){
            WebElement target = Elements.find(ID:"//*[@class='f-best-idea-right-wing']/*[text()='${params."My List Title"}']",Browser.Driver)
        	((JavascriptExecutor)Browser.Driver).executeScript(jsMove, source, target)
    	}
	}
}