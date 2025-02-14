package actions.TopIdeas;

import actions.selenium.*

class SetTopIdeasGearMenu{
    public void run(def params){
        
        if(params."Click on gear icon"==true){
            Click.run(ID:"//*[contains(@class,'fractal-dropdown biw-gear')]/DIV")
        }
        if(params."Option"){
            def ID= "//*[contains(@class,'f-dropdown-options')]//LI//*[text()='${params."Option"}']"
            if(params." Click on Option"==true){
                Click.run(ID:ID)
            }
            if(params."Option Selected"){
                if(params."Option Selected"==true){
                assert Exists.run(ID:ID+"/..//*[contains(@class,'f-checkbox-checked')]")==1,"Error - ${params."Option"} not selected"
            } else {
          		assert Exists.run(ID:ID+"/..//*[not(contains(@class,'f-checkbox-checked'))]")==1,"Error - ${params."Option"} is selected"  
                } 
            } 
        }
    }
}