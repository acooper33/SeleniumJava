package actions.ViewIdea30;

import actions.selenium.Exists
import actions.selenium.Click
import actions.selenium.SetText

class SetChipinViewIdea3page{
    public void run(def params){
        
        if(params."Button content"){
            if(params."Button content"=="Edit Chips"){
            	Click.run(ID:"//*[contains(@class,'f-chips-vote-btn')]//*[@class='f-chips-btn-text' and text()='Edit Chips']")
        	} else {
            	Click.run(ID:"//*[contains(@class,'f-chips-vote-btn')]//*[@class='f-chips-btn-text' and text()='Add Chips']")
            }
        }
        if(params."Chip Count on the Button"){
            assert Exists.run(ID:"//*[@class='f-chips-count' and text()='${params."Chip Count on the Button"}']")==1, "Error - Incorrect chip count on the button"
        }
        if(params."View My Investments"==true){
            Click.run(ID:"//*[@class='fractal-button f-btn-link f-btn-xs' and contains(text(),'View My Investments')]")
        }
        SetText.run(ID:"//*[@class='f-chip-bottom']//INPUT",Text:params."Choose Amount")
        if(params."Custom Chip Amount Action"){
            Click.run(ID:"//*[@class='f-chips-action-btns']//SPAN[text()='${params."Custom Chip Amount Action"}']")           
        }
    }
}