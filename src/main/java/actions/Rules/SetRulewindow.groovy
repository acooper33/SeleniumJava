package actions.Rules;

import actions.selenium.*

class SetRulewindow{
    public void run(def params){
        SetText.run(ID:"//*[@id='name']",Text:params."Rule Name")
        if(params.Action){
            if(params.Action=="Create"){Click.run(ID:"//*[@id='bi-modal-button']/SPAN[text()='Create']")}
            else if(params.Action=="Save"){Click.run(ID:"//*[@id='bi-modal-button']/SPAN[text()='Save']")}
            else{Click.run(ID:"//A[text()='Cancel']")}
            sleep(3000)
        }
    }
}