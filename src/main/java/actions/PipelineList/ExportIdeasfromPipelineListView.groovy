package actions.PipelineList;

import actions.selenium.Click

class ExportIdeasfromPipelineListView{
    public void run(def params){
        Click.run(ID:"//*[starts-with(@id,'report')]/I[contains(@class,'fa fa-file-excel-o')]")
    }
}