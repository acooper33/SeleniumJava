package actions.People;

import actions.selenium.Click

class SetBacktoLicensesonLicensesTab{
    public void run(def params){
        
        Click.run(ID:"//div[@class='admin-goback']")
        
    }
}