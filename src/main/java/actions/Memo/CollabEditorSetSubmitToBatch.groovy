package actions.Memo;

import actions.selenium.Click
import actions.selenium.GetText
import actions.selenium.SetText
import actions.Memo.ColabEditorSetTopBarDropdown
import actions.selenium.SetCombobox

class CollabEditorSetSubmitToBatch{
    public void run(def params){
        if(params."Via Button or Dropdown?"=="Button" ){
            Click.run(ID:"//DIV[contains(@class,'f-send-to-batch')]/BUTTON")
            assert GetText.run(ID:"//SPAN[@class='f-batch-text']").contains("Submit this Memo to a Batch for further development, evaluation, and consideration. Once submitted, you can request Memo Reviews for structured feedback from peers and subject matter experts."),
                "Error - Batch Text is not what expected"
        	if(params."Select batch"){
                SetCombobox.run(ID:"//DIV[@class='f-batch-body']//DIV[contains(@class,'fractal-combobox')]//INPUT[@id='select-campaign-combobox']", Option:params."Select batch")
            	//Click.run(ID:"//DIV[@class='f-batch-body']//DIV[contains(@class,'fractal-combobox')]//INPUT[@id='select-campaign-combobox']")
                //sleep(1000)
                //SetText.run(ID:"//DIV[@class='f-batch-body']//DIV[contains(@class,'fractal-combobox')]//INPUT[@id='select-campaign-combobox']", Text:params."Select batch")
            	//Click.run(ID:"//*[contains(@id,'f-combobox-list') and not(contains(@style,'none'))]/DIV[contains(@class,'f-combobox-list-item') and contains(.,'${params."Select batch"}')]")
        	}
        	if(params."Action"=="Close"){Click.run(ID:"//DIV[contains(@class,'f-batch-heading')]//*[contains(@class,'button')]")}
        	if(params."Action"=="Cancel"){Click.run(ID:"//DIV[@class='f-batch-footer']//BUTTON[contains(@class,'f-btn-subtle')]")}
        	if(params."Action"=="Submit"){Click.run(ID:"//DIV[@class='f-batch-footer']//BUTTON[contains(@class,'f-btn-primary')]")}
            
        }else if(params."Via Button or Dropdown?"=="Dropdown" || params."Via Button or Dropdown?"=="From Userhome/MTS"){
            if(params."Via Button or Dropdown?"=="Dropdown"){
                ColabEditorSetTopBarDropdown.run("Click on the Bar?":true, "Main Option":"Submit to Batch")
            	sleep(1000)
            }
            assert GetText.run(ID:"//DIV[contains(@class,'ReactModal')]//DIV[contains(@class,'f-modal-body')]").contains("Submit this Memo to a Batch for further development, evaluation, and consideration. Once submitted, you can request Memo Reviews for structured feedback from peers and subject matter experts."),
                "Error - Batch Text is not what expected"
            if(params."Select batch"){
                SetCombobox.run(ID:"//DIV[contains(@class,'ReactModal')]//INPUT[@id='select-campaign-combobox']", Option:params."Select batch")
                //Click.run(ID:"//DIV[contains(@class,'ReactModal')]//INPUT[@id='select-campaign-combobox']")
                //sleep(1000)
                //SetText.run(ID:"//DIV[contains(@class,'ReactModal')]//INPUT[@id='select-campaign-combobox']", Text:params."Select batch")
                //Click.run(ID:"//*[contains(@id,'f-combobox-list') and not(contains(@style,'none'))]/DIV[contains(@class,'f-combobox-list-item') and contains(.,'${params."Select batch"}')]")
                //sleep(1000)
            }
            if(params."Action"=="Close"){Click.run(ID:"//DIV[contains(@class,'ReactModal')]//DIV[contains(@class,'close-button')]")}
        	if(params."Action"=="Cancel"){Click.run(ID:"//DIV[contains(@class,'ReactModal')]//DIV[contains(@class,'f-footer')]//*[contains(@class,'f-btn-subtle')]")}
        	if(params."Action"=="Submit"){Click.run(ID:"//DIV[contains(@class,'ReactModal')]//DIV[contains(@class,'f-footer')]//*[contains(@class,'f-btn-primary')]")}
        }
        sleep(3000)
    }
}