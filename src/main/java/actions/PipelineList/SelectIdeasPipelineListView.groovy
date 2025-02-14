package actions.PipelineList;

//import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.SetFocus

class SelectIdeasPipelineListView{
    public void run(def params){
        if(params."Idea Title(s)"){
            if (params."Idea Title(s)"=="Select All"){Click.run(ID:"//TABLE[@class='header_table']//TR/TH/INPUT[@type='checkbox']")}
            else {
                params."Idea Title(s)".split(',').each(){ name ->
                Click.run(ID:"//TABLE[@class='body_table']/TBODY/TR/TD[contains(@class,'title_cell')]/A[contains(.,'${name}')]/../../TD[contains(@class,'select-row-cell')]/INPUT", "Handle Stale Element":true)
            	}
            }
        }
        if(params."Click Select All Checkbox"){
            SetFocus.run(ID:"//TR/TH[contains(@class,'select-all-header-cell')]/INPUT[@type='checkbox']")
            sleep(500)
            Click.run(ID:"//TR/TH[contains(@class,'select-all-header-cell')]/INPUT[@type='checkbox']")
            sleep(1000)
        }
        if(params."Click Select All Link"){
            Click.run(ID:"//A[@id='select-all-link']")
        }
    }
}