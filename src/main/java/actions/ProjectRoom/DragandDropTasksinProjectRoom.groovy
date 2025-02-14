package actions.ProjectRoom;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor

class DragandDropTasksinProjectRoom{
    public void run(def params){
        
        final String jsMove ="var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +"ction(format,data){this.items[format]=data;this.types.append(for" +"mat);},getData:function(format){return this.items[format];},clea" +"rData:function(format){}};var emit=function(event,target){var ev" +"t=document.createEvent('Event');evt.initEvent(event,true,false);" +"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +"'drop',tgt);emit('dragend',src);"
        WebElement source = Elements.find(ID:"//*[@value='${params."Task"}']/../../../..//DIV[contains(@class,'f-table-dd-handle')]",Browser.Driver)
        WebElement target
        if(params."Last Row"==true){
            target = Elements.find(ID:"//*[contains(@class,'f-table-v2-row')][${params."New Row Number"}]",Browser.Driver)
        } else {
            target = Elements.find(ID:"//*[contains(@class,'f-table-v2-row-body')][${params."New Row Number"}]/DIV[contains(@class,'f-table-dd-handle')]/..",Browser.Driver)
        }        
        ((JavascriptExecutor)Browser.Driver).executeScript(jsMove, source, target)                
    }
}