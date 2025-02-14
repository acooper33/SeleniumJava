package actions.NGAViewIdea;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SendKeys
import actions.selenium.MouseOver

class SetTagforNGAViewIdea{
    public void run(def params){
        if(params."Tag Name"){
            params."Tag Name".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                    Click.run(ID:"//*[@id='add-tag-container']")
                    sleep(500)
                    Click.run(ID:"//*[@id='add-tag']")
                    sleep(500)
                    SetText.run(ID:"//*[@id='add-tag']", Text:name)
                    sleep(4000)
                    SendKeys.run(ID:"//*[@id='add-tag']", Key:"ENTER")
                    sleep(4000)
                }
                else if((params."Add or Remove".split(",")[x]=="Remove")){
                    def xpathId ="removebutton-bi-${name}"
                    Click.run(ID:"//*[@id='${xpathId}']","Type of Click":"Javascript")
                }
            }
		}
	}
}