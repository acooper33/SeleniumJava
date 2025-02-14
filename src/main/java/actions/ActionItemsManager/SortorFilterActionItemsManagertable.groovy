package actions.ActionItemsManager;
import actions.selenium.Click
import actions.selenium.Exists
import actions.Grid.FilterGridColumn
import actions.Grid.SortGridColumn

class SortorFilterActionItemsManagertable{
    public void run(def params){
        
        if(params."List"!="Initiative Action Items Manager"){
         	if(Exists.run(ID:"//*[@id='action_item_header_breadcrumb' and contains(text(),'My Action Items')]")>0){ 
            	Click.run(ID:"//*[@id='action_item_manager']/A")
         	}  
        }

        if(params."Sort Or Filter"=="Sort"){
            SortGridColumn.run("Column Name":params."Column","Sort":params."Sort Ascending or Descending")}
        else {
            FilterGridColumn.run("Column Name":params."Column","Filter Search":params."Keyword to Search","Action":params."Action","Clear Keywords":params."Clear Keywords")  
        }    
    }
}