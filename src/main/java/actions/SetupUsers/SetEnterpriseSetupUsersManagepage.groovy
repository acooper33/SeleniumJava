package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetEnterpriseSetupUsersManagepage{
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
                sleep(3000)
                /*if(params."Existing User's Email or New".contains("mailinator")){ // remove when BPD-36833 fixed
            		params."Existing User's Email or New" = params."Existing User's Email or New".replaceAll('_','\\.')
        		}*/
                Click.run(ID:"//*[@id='as_ul']//*[text()='${params."Existing User's Email or New"}']")
                Click.run(ID:"//*[@id='admin_user_search_edit_button']")
                switch(params.Action){
                    case "Show Details":
                    	Click.run(ID:"//A[@id='detailLink']")
                    	break
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
                    	SetCheckBox.run(ID:"//*[@id='f-delete-user-understand']" , Check:true)
                    	if(params."Delete User Confirmation Button"==null || params."Delete User Confirmation Button"==true){
                           Click.run(ID:"//*[contains(@class,'fractal-button f-submit-btn f-btn-primary f-btn-sm f-btn-kill')]")
                            sleep(3000) 
                        }                    	
                    	break
                   }
             }
    	}
	}    
}