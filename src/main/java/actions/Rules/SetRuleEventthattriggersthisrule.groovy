package actions.Rules;

import actions.selenium.*

class SetRuleEventthattriggersthisrule{
    public void run(def params){
        SelectItem.run(ID:"//*[@id='trigger']","Visible Text":params."Event")
        if(params."Event Value"){
            if(Exists.run(ID:"//*[@id='trigger-step-id']/SELECT[1]")>0){SelectItem.run(ID:"//*[@id='trigger-step-id']/SELECT[1]","Visible Text":params."Event Value")}
            else{SetText.run(ID:"//*[@id='trigger-value']",Text:params."Event Value")}
        }
    }
}