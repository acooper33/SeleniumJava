package actions.ViewIdea30;

import actions.selenium.DragAndDrop

class DragWidgetOnViewIdea3{
    public void run(def params){
        if(params."Widget Title"){
    		DragAndDrop.run("From ID":"//DIV[contains(@class,'f-widget-editor')]/DIV[contains(@class,'f-widget') and starts-with(.,'${params."Widget Title"}')]", "To ID":"//DIV[contains(@class,'f-component')]//SPAN[contains(@class,'f-component-title') and starts-with(.,'${params."Above What Existing Widget"}')]", "Type of Drag and Drop":"Dragging") 
        }
    }
}