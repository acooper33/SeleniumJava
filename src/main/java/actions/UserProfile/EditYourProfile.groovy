package actions.UserProfile;
import actions.selenium.*
import actions.selenium.SendKeys
import java.nio.file.Paths

class EditYourProfile{
    public void run(def params){
		def os = System.getProperty("os.name").toLowerCase();
        if (Exists.run(ID:"//*[@id='admin_user_save_profile_button']")==0) {
            Click.run(ID:"//*[@id='profile_edit_profile_link']")
        }
        sleep(2000)
        if(params."Display Picture"){
            if(params."Display Picture Change or Remove" == "Change"){
                Click.run(ID:"//*[@id='edit_profilephoto']","Type of Click":"Javascript")   
                SwitchToFrame.run(ID:"//*[@id='profile_photo_upload_form']")
                def fileName
                if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ 	//linux
        			fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Display Picture"}"
        		}else{																//windows
        			fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Display Picture"}"  
       			}
                SendKeys.run(ID:"//*[@id='file_upload']",Text:fileName)
                SwitchToDefaultContent.run()
                sleep(5000)
            } else {Click.run(ID:"//*[@id='profile_photo_upload_static_link']")}
        }
        SetText.run(ID:"//*[@id='user_screen_name']",Text:params."Screen Name")
        SetText.run(ID:"//*[@field-type='First Name']//INPUT",Text:params."First Name")
        SetText.run(ID:"//*[@field-type='Last Name']//INPUT",Text:params."Last Name")
        SetText.run(ID:"//*[@field-type='Job Title']//INPUT",Text:params."Job Title")
        SelectItem.run(ID:"//*[text()='Department']/../..//select","Visible Text":params."Department")
        SelectItem.run(ID:"//*[text()='Location']/../..//select","Visible Text":params."Location")
        SetText.run(ID:"//*[@field-type='Custom Field']//INPUT",Text:params."Custom Field")
        
        //Anna: update to include a small pause while typing in the expertise value
         if(params."Expertise"){
            params."Expertise".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove Expertise".split(",")[x]=="Add"){
                    for(int i = 1;i <= 25;i++){
                        for(int j=0;j<name.size();j++){
                            SetText.run(ID:"//*[@id='expertise-input']",Text:name[j], "Type of Clear":"None")
                            sleep(300) //need to properly trigger suggestion
                        }
                        sleep(1000)
                        if(Exists.run(ID:"//*[@id='at-view-expertise']//LI[@data-value='${name}']")==1){
                            Click.run(ID:"//*[@id='at-view-expertise']//LI[@data-value='${name}']")
                            break
                        } 
                    }
                } else{Click.run(ID:"//*[@id='expertise-input']//SPAN[contains(text(),'${name}')]/I")}
            }
        }
        SetCheckBox.run(ID:"//*[@id='user_comment_notification']",Check:params."Receive e-mail notification when a comment is made to my idea")
        if(params."Email notices are sent immediately") {Click.run(ID:"//*[@id='user_emails_digest_daily']")}
        if(params."Send me daily digests of all email") {Click.run(ID:"//*[@id='user_emails_immediate']")}
        SelectItem.run(ID:"//*[@id='user_emails_digest_daily_period']","Visible Text":params."Send me daily digests of all email Times")
        if(params."Send me weekly digests of all email") {Click.run(ID:"//*[@id='user_emails_all1']")}
        SelectItem.run(ID:"//*[@id='user_emails_digest_weekly_days']","Visible Text":params."Send me weekly digests of all email day")
        SelectItem.run(ID:"//*[@id='user_emails_digest_weekly_period']","Visible Text":params."Send me weekly digests of all email time")
        if(params."Turn off all emails sent to me") {Click.run(ID:"//*[@id='user_emails_all2']")}

        Click.run(ID:"//*[@id='admin_user_save_profile_button']")
    }
}