package actions.PipelineStepsView;

import actions.selenium.DragAndDrop

class DragandDropIdeasinPipelineSteps{
    public void run(def params){
        
        DragAndDrop.run("From ID":"//*[contains(@class,'active-ideas')]//*[@id='content-inside' and contains(.,'${params."Idea Title"}')]/../..", "To ID":"//*[@class='step_header_name' and text()='${params."Step"}']/../../..//*[@class='step_content_wrapper']/DIV","Type of Drag and Drop":"Dragging")
        
    }
}