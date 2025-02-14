package actions.Widgets;

import actions.selenium.*

class VerifyandAccessEnterpriseLoginWidget{
    public void run(def params){

        if (params."Screen Name"){
            VerifyText.run(ID:"//*[@class='loginbox']//*[contains(text(),'Welcome, ${params."Screen Name"}!')]","Contains Text":params."Screen Name")
        }

        if(params."Logout or Setup"){
            if (params."Logout or Setup" == "Setup"){
                Click.run(ID:"//*[@id='setup_link']/A")
            } else {Click.run(ID:"//*[@class='loginbox']//A[contains(text(),'logout')]", "Type of Click": "Javascript")
                   sleep(3000)}
        }
    }
}