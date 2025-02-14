package actions.Rules;

import actions.selenium.*

class SetNewRulewindow{
    public void run(def params){
     SetText.run(ID:"//*[@id='f-rule-name-input']",Text:params."Rule Name")
        if(params.Action){
            if(params.Action=="Create"){Click.run(ID:"//*[@id='f-modal-submit']/SPAN[text()='Create']/..")}
            else if(params.Action=="Save"){Click.run(ID:"//*[@id='f-modal-submit']/SPAN[text()='Save']/..")}
            else{Click.run(ID:"//*[@data-test='modal-footer-cancel']")}
            sleep(3000)
        }
    }
}