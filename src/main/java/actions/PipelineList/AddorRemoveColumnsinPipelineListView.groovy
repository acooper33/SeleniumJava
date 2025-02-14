package actions.PipelineList;

import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.ExecuteJavascript
import org.openqa.selenium.WebElement

class AddorRemoveColumnsinPipelineListView{
    public void run(def params){
        WebElement configMenuItem
        if(params.Columns){
           Click.run(ID:"//*[@id='grid-config-menu']")
           params.Columns.split(",").eachWithIndex{name, x ->
                configMenuItem = Elements.find(ID:"//*[@id='grid-config']/DIV[contains(@class,'grid-config-item')]/*[normalize-space(.)='${name}']",Browser.Driver)
                ExecuteJavascript.run(Code:"arguments[0].scrollIntoView(true);", "Arguments":configMenuItem)
                if (params."Add or Remove".split(",")[x]=="Add"){SetCheckBox.run(ID:"//*[@id='grid-config']/DIV[contains(@class,'grid-config-item')]/*[text()='${name}']/../input", Check:true, "Type of Click":"Javascript")}
                else{SetCheckBox.run(ID:"//*[@id='grid-config']/DIV[contains(@class,'grid-config-item')]/*[normalize-space(.)='${name}']/../input", Check:false, "Type of Click":"Javascript")}
           		sleep(5000) 
           }
            sleep(2000)
		}
    }
}