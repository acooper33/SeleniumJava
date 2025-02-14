package actions.SetupEnterpriseSystemEmailMessages;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.GetText
import actions.selenium.*

class SetSystemEmailMessages{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Site",Section:"System Email Messages")
        if(params."Email Under"){
            SelectItem.run(ID:"//SELECT[@id='template_product']", "Visible Text":params."Email Under")
            sleep(1000)
        }
        if(params."Template Title"){
            SelectItem.run(ID:"//SELECT[@id='template_key']", "Visible Text":params."Template Title")
            sleep(1000)
        }
        if(params."Enable System Message"){
            SetCheckBox.run(ID:"//*[@id='ENT_ENABLE_CURRENT_MESSAGE']", Check:params."Enable System Message")

        }
        if(params."Template Email Subject"){
            SetText.run(ID:"//*[@id='email_subject']", Text:params."Template Email Subject")
        }
        if(params."Template Email Body"){
            SwitchToFrame.run(ID:"//*[@id='email_template_body_ifr']")
            SetText.run(ID:"//*[@id='tinymce']", Text:params."Template Email Body")
            SwitchToDefaultContent.run()
        }
        if(params."Append Template Email Body"){
            println("Append Template Email Body")
            SwitchToFrame.run(ID:"//*[@id='email_template_body_ifr']")
            def originalText = GetText.run(ID:"//*[@id='tinymce']")
            def text = originalText + " " + params."Append Template Email Body"
            println("Original Text: ${originalText}")
            println("Updated Text: ${text}")
            SetText.run(ID:"//*[@id='tinymce']", Text:text)
            SwitchToDefaultContent.run()
        }
        if(params.Action == 'Save'){Click.run(ID:"//*[@id='site_email_save_button']")}
        if(params.Action == 'Cancel'){Click.run(ID:"//*[@id='site_email_cancel_button']")}
    }
}