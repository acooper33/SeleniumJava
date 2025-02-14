package actions.ViewIdea;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.*

class SetChipsinViewIdeapage{
    public void run(def params){
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        if(params."Add or Edit Chips" == "Add Chips" || params."Add or Edit Chips" == null) {
            Click.run(ID:"//*[@id='add_chip_button']","Type of Click":"Javascript")
        } else { Click.run(ID:"//*[@id='edit_chip_button']")}

        if(params."Chip count to be added"){
            Click.run(ID:"//*[@id='chips_vote_drop_ul']/li[text()='${params."Chip count to be added"}']")
        }

        if(params."Custom Amount"){
            Click.run(ID:"//*[@id='chips_vote_drop_ul']/li[text()='Custom Amount']")  
            SetText.run(Text:params."Custom Amount",ID:"//*[@id='custom_amount']")
            if(params."Custom Chip Amount Action"){
                if(params."Custom Chip Amount Action"=="Submit Chips"){
                    Click.run(ID:"//*[@id='bi-modal-button']/span[text()='Submit Chips']")
                } else {
                    Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")
                }
            }
        }
        sleep(1000)
    }
}