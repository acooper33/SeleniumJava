package actions.People;

import actions.selenium.Click
import actions.common.PeopleCommon
import actions.selenium.SetText

class SetCertificationtab{
    public void run(def params){

        PeopleCommon.NavigateTab(Tab:"Certifications")
        params."Certificate".split(",").eachWithIndex{ certificate, x ->
            if(params."Add or Update or Remove".split(",")[x]=="Add"){
                SetText.run(ID:"//*[@class='certification add-cert']/*[@class='cert-input']","Text":certificate) 
                Click.run(ID:"//*[@class='certification add-cert']//I")
            }
            else if(params."Add or Update or Remove".split(",")[x]=="Update"){
                def updatedCertificate = params."Updated Certificate".split(",")
                SetText.run(ID:"//*[@class='cert-input' and @value='${certificate}']","Text": updatedCertificate[x]) 
            }
            else{Click.run(ID:"//*[@class='cert-input' and @value='${certificate}']/..//I[contains(@class,'fa-remove')]")}
        }
        
        Click.run(ID:"//*[@id='save-certifications-btn']")
    }
}