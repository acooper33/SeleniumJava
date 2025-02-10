package actions.PipelineStepsView;
import actions.selenium.Exists


class VerifyExportStepDataDialog{
    public void run(def params){
        if(params."Header"){
            assert Exists.run(ID:"//*[@class='bi_modal']/div[not(contains(@style,'display: none;'))]//*[contains(@id,'bitop-header')][.='" + params."Header" + "']")
            assert Exists.run(ID:"//*[@class='bi_modal']/div[not(contains(@style,'display: none;'))]//*[contains(@class,'bimodal-subhead')][.='" + params."Header" + "']") 
        }  
        if(params."Text"){
            // Usual text is: "Select the export(s) you want. When your report is available, you will receive an email with a link to download the file."
            assert Exists.run(ID:"//*[@class='bi_modal']/div[not(contains(@style,'display: none;'))]//*[contains(@class,'modal_content')]/div[.='" + params."Text" + "']")
        } 
        if(params."Options Turned Red"){
            assert Exists.run(ID:"//*[@class='bi_modal']/div[not(contains(@style,'display: none;'))]//*[@for='action_item_export'][contains(@style,'color: rgb(255, 0, 0);')]")
            assert Exists.run(ID:"//*[@class='bi_modal']/div[not(contains(@style,'display: none;'))]//*[@for='idea_export'][contains(@style,'color: rgb(255, 0, 0);')]")
        } 
        
    }
}