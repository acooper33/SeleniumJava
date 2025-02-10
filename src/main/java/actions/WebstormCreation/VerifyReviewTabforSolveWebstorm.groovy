package actions.WebstormCreation;
import actions.selenium.VerifyText
import actions.selenium.Exists

class VerifyReviewTabforSolveWebstorm{
    public void run(def params){

        //General
        VerifyText.run(ID:"//*[text()='Name']/..//SPAN[@class='help-block-top' and text()='${params."Name"}']",Text:params."Name")
        if (params."Description") {VerifyText.run(ID:"//*[text()='Description']/..//SPAN[@class='help-block-top' and text()='${params."Description"}']",Text:params."Description")}
        if (params."Sponsor") {VerifyText.run(ID:"//*[text()='Sponsor']/..//SPAN[@class='help-block-top' and text()='${params."Sponsor"}']",Text:params."Sponsor")}

        //Design
        if(params."Design Template"){
            VerifyText.run(ID:"//*[text()='Design Template']/..//SPAN[@class='help-block-top' and text()='${params."Design Template"}']",Text:params."Design Template")
            if(params."Design Template"=="Copied from an existing initiative:") {VerifyText.run(ID:"//*[text()='Design Template']/../../../..//*[@class='help-block-top' and text()='${params."Pipeline to Copy"}']']",Text:params."Pipeline to Copy")}
        }

        //Participants
        if(params."Early Access"){
            params."Early Access".split(",").eachWithIndex{ participant, x ->
                if(params."Should Early Access Exist".split(",")[x]=="TRUE") {
                    assert Exists.run(ID:"//DIV[text()='People']/../DIV[@class='region-form']/DIV/DIV[position()=1 or position()=2]//SPAN[contains(text(),'${participant}')]")==1,"'${participant}' not found as Early Access Participant"  
                } else {assert Exists.run(ID:"//DIV[text()='People']/../DIV[@class='region-form']/DIV/DIV[position()=1 or position()=2]//SPAN[contains(text(),'${participant}')]")==0,"'${participant}' found as Early Access Participant"}
            } 
        }
        if(params."General Access"){
            params."General Access".split(",").eachWithIndex{ participant, x ->
                if(params."Should General Access Exist".split(",")[x]=="TRUE") {
                    assert Exists.run(ID:"//DIV[text()='People']/../DIV[@class='region-form']/DIV/DIV[position()=3 or position()=4]//SPAN[contains(text(),'${participant}')]")==1,"'${participant}' not found as General Access Participant"  
                } else {assert Exists.run(ID:"//DIV[text()='People']/../DIV[@class='region-form']/DIV/DIV[position()=3 or position()=4]//SPAN[contains(text(),'${participant}')]")==0,"'${participant}' found as General Access Participant"}
            } 
        }
        if(params."Administrators"){
            params."Administrators".split(",").eachWithIndex{ admin, x ->
                if(params."Should Administrators Exist".split(",")[x]=="TRUE") {
                    assert Exists.run(ID:"//*[text()='Administrators']/../../../..//*[@class='help-block-top' and contains(.,'${admin}')]")>0,"'${admin}' not found as Administrator"
                } else {assert Exists.run(ID:"//*[text()='Administrators']/../../../..//*[@class='help-block-top' and contains(.,'${admin}')]")==0,"'${admin}' found as Administrator"}
            }
        }

        if(params."Moderators"){
            params."Moderators".split(",").eachWithIndex{ moderator, x ->
                if(params."Should Moderators Exist".split(",")[x]=="TRUE") {
                    assert Exists.run(ID:"//*[text()='Moderators']/../../../..//*[@class='help-block-top' and contains(.,'${moderator}')]")>0,"'${moderator}' not found as Moderator"
                } else { assert Exists.run(ID:"//*[text()='Moderators']/../../../..//*[@class='help-block-top' and contains(.,'${moderator}')]")==0,"'${moderator}' found as Moderator"}
            }
        } 

        //Schedule
        if(params."Launch Date") {VerifyText.run(ID:"//*[text()='Launch Date']/..//SPAN[@class='help-block-top' and text()='${params."Launch Date"}']",Text:params."Launch Date")}
        //VerifyText.run(ID:"//*[text()='Launch Date']/..//SPAN[@class='help-block-top' and text()='${params."Launch Date"}']",Text:params."Launch Date")}
        if(params."End Date") {VerifyText.run(ID:"//*[text()='End Date']/..//SPAN[@class='help-block-top' and text()='${params."End Date"}']",Text:params."End Date")}

        //Communications
        if(params."Launch Message") {VerifyText.run(ID:"//*[text()='Launch Message']/..//SPAN[@class='help-block-top' and text()='${params."Launch Message"}']",Text:params."Launch Message")}
        if(params."Challenge Update") {VerifyText.run(ID:"//*[text()='Challenge Update']/..//SPAN[@class='help-block-top' and text()='${params."Challenge Update"}']",Text:params."Challenge Update")}
        if(params."Challenge Last Day") {VerifyText.run(ID:"//*[text()='Challenge Last Day']/..//SPAN[@class='help-block-top' and text()='${params."Challenge Last Day"}']",Text:params."Challenge Last Day")}
        if(params."Challenge End") {VerifyText.run(ID:"//*[text()='Challenge End']/..//SPAN[@class='help-block-top' and text()='${params."Challenge End"}']",Text:params."Challenge End")}

        //Process
        if(params."Initial Screen (Single Scale) Assignee"){
            params."Initial Screen (Single Scale) Assignee".split(",").eachWithIndex{ assignee, x ->
                if(params."Should Initial Screen (Single Scale) Assignee Exist".split(",")[x]=="TRUE") {
                    assert Exists.run(ID:"//*[text()='Initial Screen (Single Scale)']/../../..//*[@class='help-block-top' and contains(.,'${assignee}')]")>0,"'${assignee}' not found as Initial Screen (Single Scale) participant"
                } else { assert Exists.run(ID:"//*[text()='Initial Screen (Single Scale)']/../../..//*[@class='help-block-top' and contains(.,'${assignee}')]")==0,"'${assignee}' found as Initial Screen (Single Scale) participant"}
            }
        } 
        if(params."Scorecard Assignee"){
            params."Scorecard Assignee".split(",").eachWithIndex{ assignee, x ->
                if(params."Should Scorecard Assignee Exist".split(",")[x]=="TRUE") {
                    assert Exists.run(ID:"//*[text()='Scorecard']/../../..//*[@class='help-block-top' and contains(.,'${assignee}')]")>0,"'${assignee}' not found as Scorecard participant"
                } else {assert Exists.run(ID:"//*[text()='Scorecard']/../../..//*[@class='help-block-top' and contains(.,'${assignee}')]")==0,"'${assignee}' found as Scorecard participant"}
            }
        }
        if(params."Template") {VerifyText.run(ID:"//*[text()='Template']/..//SPAN[@class='help-block-top' and text()='${params."Template"}']",Text:params."Template")}
    }
}