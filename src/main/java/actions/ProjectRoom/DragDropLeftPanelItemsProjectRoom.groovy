package actions.ProjectRoom;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import actions.selenium.DragAndDrop

class DragDropLeftPanelItemsProjectRoom{
    public void run(def params){
        //jsMove ="var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +"ction(format,data){this.items[format]=data;this.types.append(for" +"mat);},getData:function(format){return this.items[format];},clea" +"rData:function(format){}};var emit=function(event,target){var ev" +"t=document.createEvent('Event');evt.initEvent(event,true,false);" +"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +"'drop',tgt);emit('dragend',src);"
        //((JavascriptExecutor)Browser.Driver).executeScript(jsMove, source, target)
        
        if(params."Or Folder Name"){
         	//DragAndDrop.run("From ID":"//DIV[contains(@class,'f-room-items')]//LI//*[starts-with(.,'${params."Item to Drag"}')]", "To ID":"//DIV[contains(@class,'f-room-items')]//LI//*[starts-with(.,'${params."Or Folder Name"}')]", "Type of Drag and Drop":"Dragging") 
        	DragAndDrop.run("From ID":"//DIV[contains(@class,'f-room-items')]//LI//*[starts-with(.,'${params."Item to Drag"}')]", "To ID":"//LI//*[starts-with(.,'${params."Or Folder Name"}')]", "Type of Drag and Drop":"Dragging") 
        }else if(params."New Row"){
            //params."New Row" = (params."New Row".toInteger()+1).toString()
            DragAndDrop.run("From ID":"//DIV[contains(@class,'f-room-items')]//LI//*[starts-with(.,'${params."Item to Drag"}')]", "To ID":"//DIV[contains(@class,'f-room-items')]//LI[position()='${params."New Row"}']", "Type of Drag and Drop":"Dragging") 
        }
        
    }
}