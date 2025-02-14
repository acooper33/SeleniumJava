package actions.MTS;

import actions.selenium.Click
import actions.selenium.Exists

class SetMTStabonhomepage{
    public void run(def params){
              
        if(params."Should Tab Exist"==true){
            assert Exists.run(ID:"//H2/*[text()='${params."Heading"}']/../following-sibling::UL[1]/*[${params."Placement Number of Tab"}]//*[text()='${params."Tabs"}']")==1, "Error - 'Tab is not displayed" 
        } else {
            assert Exists.run(ID:"//H2/*[text()='${params."Heading"}']/../following-sibling::UL[1]/*[${params."Placement Number of Tab"}]//*[text()='${params."Tabs"}']")==0, "Error - 'Tab is displayed"  
        }
        if(params."Should User Click on Tab"==true){
              Click.run(ID:"//H2/*[text()='${params."Heading"}']/../following-sibling::UL[1]//*[text()='${params."Tabs"}']") 
              sleep(5000)
        }            
    }
}
       