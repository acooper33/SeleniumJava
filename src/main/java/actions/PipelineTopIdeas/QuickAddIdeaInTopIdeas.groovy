package actions.PipelineTopIdeas;

import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SetText
import actions.selenium.SetCombobox

class QuickAddIdeaInTopIdeas{
    public void run(def params){
        if(params."Click Quick Add to Trigger Dialog"==true){
        	Click.run(ID:"//*[contains(@class,'f-quick-add-wrapper')]//BUTTON", "Type of Click":"Javascript")
        }
        if(params."Quick Add Button Should Be Active After Click"==true){
                assert Exists.run(ID:"//*[contains(@class,'f-quick-add-wrapper')]//BUTTON[contains(@class,'f-btn-active')]")>0, "Error - Quick Add Button Not Active"     
        }
        if(params."Title"){
            SetText.run(ID:"//*[@id='f-quick-add-memoidea']", Text:params."Title")  
        }
        
        // Expand more options if category or status are needed
        if(params."Category" || params."Status"){
            Click.run(ID:"//*[contains(@class,'f-quick-add-dropdown f-quick-add-idea')]//BUTTON[.='Show more fields']")
            assert Exists.run(ID:"//*[@id='fractal-combobox-input' and @placeholder='Choose Category']")>0, "Error - Category Combobox not found after clicking 'Show more fields'"     

        }
        
        if(params."Category"){
            SetCombobox.run(ID:"//*[@id='fractal-combobox-input' and @placeholder='Choose Category']", Option:params."Category")
            //SetText.run(ID:"", Text:)
			//Click.run(ID:"//*[contains(@id,'f-combobox-list')]/DIV[contains(@class,'f-combobox-list-item') and contains(.,'${params."Category"}')]")
            sleep(1000)
        }
        if(params.Action=="Submit"){
            Click.run(ID:"//*[contains(@class,'f-quick-add-wrapper')]//BUTTON[contains(@class,'fractal-button') and .='Submit']", "Type of Click":"Javascript")
            sleep(1000)
        }
        else if(params.Action == "Click Outside of Container to Close it"){
            Click.run(ID:"//SPAN[@class='f-best-idea-set-name']")
        	
        }
        if(params."Quick Add Button Should Be Inactive At The End"==true){
            sleep(3000)
            assert Exists.run(ID:"//*[contains(@class,'f-quick-add-wrapper')]//BUTTON[contains(@class,'f-btn-active')]")==0, "Error - Quick Add Button Is Still Active"
        }
        else if(params."Quick Add Button Should Be Inactive At The End"==false){
            sleep(3000)
            assert Exists.run(ID:"//*[contains(@class,'f-quick-add-wrapper')]//BUTTON[contains(@class,'f-btn-active')]")==1, "Error - Quick Add Button Is Inactive"
        }
    }
}