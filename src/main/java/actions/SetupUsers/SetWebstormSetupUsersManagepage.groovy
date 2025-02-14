package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox


class SetWebstormSetupUsersManagepage{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Users",Section:"Manage")
        if(params."Existing User's Email or New"){
            if(params."Existing User's Email or New" == "New"){
                Click.run(ID:"//*[@id='admin_user_new_account_button']")
                SetText.run(ID:"//*[@id='new_screen_name']",Text:params."New User's Screenname")
                SetText.run(ID:"//*[@id='new_email']",Text:params."New User's Email")
                sleep(3000)
                println("Check the PW Box")
                SetCheckBox.run(ID:"//*[@id='new_cb_password']" , Check:params."Random Password")
                SetText.run(ID:"//*[@id='new_password']",Text:params.Password)
                SetCheckBox.run(ID:"//*[@id='new_cb_send_email']" , Check:params."Send Email")
                if(params.Action=="Create"){Click.run(ID:"//*[@id='admin_user_new_account_create_button']")}
                if(params.Action=="Cancel"){Click.run(ID:"//*[@id='admin_user_new_account_cancel_button']")}
            }
            else{
               	SetText.run(ID:"//*[@id='admin_user_search_3_input']",Text:params."Existing User's Email or New")
                sleep(2000)
                Click.run(ID:"//*[@id='as_ul']//*[text()='${params."Existing User's Email or New"}']")
                Click.run(ID:"//*[@id='admin_user_search_edit_button']")
                switch(params.Action){
                    case "Block User":
            			Click.run(ID:"//*[@id='admin_user_block_button']")
            			break
                    case "Unblock User":
                    	Click.run(ID:"//*[@id='admin_user_block_button']")
            			break
                    case "Reset Password":
                    	Click.run(ID:"//A[contains(text(),'Reset Password')]")
                    	sleep(2000)
                    	break
                    case "Discretionary Points":
                    	Click.run(ID:"//A[contains(text(),'Discretionary Points')]")
                    	sleep(1000)
                    	SetText.run(ID:"//div[@id='gen_message_popup']//input[@id='discretionary_points']" ,Text:params."Discretionary Points to Give")
                     	Click.run(ID:"//div[@id='gen_message_popup']//input[@value='Submit']")
                    	break
                    case "Delete User":
                    	Click.run(ID:"//A[contains(text(),'Delete User')]")
                    	sleep(1000)
                    	Click.run(ID:"//div[@id='gen_message_popup']//input[@value='yes']")
                    	sleep(3000)
                    	break
                   }
                

            }
        }
        
        
    }
}