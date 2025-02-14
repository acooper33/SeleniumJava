package actions.SetIdeaFields;

import actions.selenium.SetText
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Click


class SetPostIdeaUserSelection{
    public static void run(def params){
        if(params."Tag or User Name"){
            params."Tag or User Name".split(",").eachWithIndex{name, x ->
            //def xpath = "LEGEND[contains(text(),'${params."Field Name"}')]/../DIV[@class='user-select-wrap']//input[contains(@class,'input-tags-typeahead')]"
            def xpath = "//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV"
                if(params."Add or Remove".split(",")[x]=="Add"){
                    int iTimeout = 10
                    def tagnumber = Elements.findAll(ID:xpath+"//DIV[1]/SPAN",Browser.Driver).size()
                    def inputElem = Elements.find(ID:xpath+"//DIV[1]/SPAN[${tagnumber}]/INPUT[2]",Browser.Driver)
                    //SetText.run(ID:xpath+"//DIV[1]/SPAN[${tagnumber}]/INPUT[2]",Text:name)
                    //sleep(1000)
                    //Click.run(ID:xpath+"//DIV[1]/SPAN[${tagnumber}]/INPUT[2]")
                    for (int i=0; i<name.size(); i++){
                        println("Sending: ${name[i]}")
                        inputElem.sendKeys(name[i])
                        sleep(500)
                    }
                    //Browser.Driver.typeKeys(inputElem, name)
                    sleep(3000)
                    Click.run(ID:xpath+"//*[contains(@class,'tt-menu tt-open')]//*[starts-with(text(),'${name}')]","Type of Click":"Javascript")
                    //SetText.run(ID:xpath+"//DIV[1]/SPAN[${tagnumber}]/INPUT[2]",Text:name)
                }
            }
        }
    }
}