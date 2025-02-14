package actions.SetupMail;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.*

class SetWebstormSetupMailIdeaSubmission{
    public String run(def params){
        SetupCommon.NavigateTab(Tab:"Mail",Section:"Idea Submission")
        def createdMailbox
        if (params.Action=="Delete Mailbox"){
            Click.run(ID:"//*[@id='mailbox_table_content']//TBODY/TR/TD[preceding-sibling::TD[A/text()='${params."Mailbox"}']]/DIV")
        }else{
            Click.run(ID:"//*[@id='create_mailbox_container']")
            sleep(1000)
            if(params."Mailbox"){
                SetText.run(ID:"//INPUT[@id='mail_address']", Text:params."Mailbox")
                sleep(2000)
            }
            if(params."Is Mailbox Available? (optional)"){
                assert Exists.run(ID:"//SPAN[@id='mail_identifier_status' and .='Available']")>0, "Error - Unavailable Error Is Showing"
            }else if(params."Is Mailbox Available? (optional)"){
                assert Exists.run(ID:"//SPAN[@id='mail_identifier_status' and .='Unavailable']")>0, "Error - Unavailable Error Not Showing"
            }
            if(params."Category"){
                SelectItem.run(ID:"//SELECT[@id='mail_category']", "Visible Text":params.Category)
                sleep(1000)
            }
            if(params.Action=="Create Mailbox"){
                Click.run(ID:"//*[@id='create_mailbox_btn_txt']")
            }
            else if (params.Action=="Cancel"){
                Click.run(ID:"//A[text()='Cancel']")
            }
            //Support for Labs code environment
            
            if(Browser.Driver.getCurrentUrl().contains("bidev.us")){
                createdMailbox = params."Mailbox"+"@"+"${Browser.Driver.getCurrentUrl().split("\\.")[0]}.${Browser.Driver.getCurrentUrl().split("\\.")[1]}.us".replaceAll("https://", "")
            }
            else{createdMailbox = params."Mailbox"+"@"+params."Affiliate URL".replaceAll("https://", "")}
      } 
      return createdMailbox
   }
}