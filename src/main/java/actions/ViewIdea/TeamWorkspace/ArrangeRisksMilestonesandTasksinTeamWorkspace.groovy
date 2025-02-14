package actions.ViewIdea.TeamWorkspace;

import actions.common.TeamWorkspaceCommon
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import actions.selenium.DragAndDrop

class ArrangeRisksMilestonesandTasksinTeamWorkspace{
    public void run(def params){

        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        //sleep(7000)
/*        final String jsMove ="var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +"ction(format,data){this.items[format]=data;this.types.append(for" +"mat);},getData:function(format){return this.items[format];},clea" +"rData:function(format){}};var emit=function(event,target){var ev" +"t=document.createEvent('Event');evt.initEvent(event,true,false);" +"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +"'drop',tgt);emit('dragend',src);"
        WebElement source = Elements.find(ID:"//*[@value='${params."Risk/Milestone/Task"}']/../../../SPAN",Browser.Driver)
        WebElement target = Elements.find(ID:"//*[@id='table-body-row-${params."New Row Number".toInteger()-1}']/SPAN",Browser.Driver)
        ((JavascriptExecutor)Browser.Driver).executeScript(jsMove, source, target)*/
         DragAndDrop.run("From ID":"//*[@value='${params."Risk/Milestone/Task"}']/../../../SPAN", "To ID":"//*[@id='table-body-row-${params."New Row Number".toInteger()-1}']/SPAN", "Type of Drag and Drop":"Dragging") 
    }
}