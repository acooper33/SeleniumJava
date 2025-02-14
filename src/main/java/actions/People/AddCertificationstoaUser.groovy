package actions.People;

import actions.selenium.Click

class AddCertificationstoaUser{
    public void run(def params){

        sleep(2000)
        Click.run(ID:"//*[@id='add-certs-link']")

        params."Certifications".split(",").eachWithIndex{ certiftificate, x ->
            if(params."Add or Remove".split(",")[x]=="Add"){
                Click.run(ID:"//*[text()='${certiftificate}']/..//*[@class='fa fa-angle-double-right right']")
            }
            else {
                Click.run(ID:"//*[@class='certification' and .='${certiftificate}']/..//*[@class='fa fa-times right']")
            }
        } 
        if(params.Action=="Update"){
            Click.run(ID:"//*[@class='green_btn_center' and text()='Update']")
        } else {
            Click.run(ID:"//*[@class='bimodal-footer']/A[@class='bimodal-secondary']")
        }
    }
}