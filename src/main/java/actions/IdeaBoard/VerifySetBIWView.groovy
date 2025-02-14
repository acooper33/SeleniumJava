package actions.IdeaBoard;

import actions.selenium.Exists

class VerifySetBIWView{
    public void run(def params){
        if (params."Set Name"){
             assert Exists.run(ID:"//*[contains(@class, 'f-best-idea-top-left-bar')]/*[contains(@class,'f-best-idea-set-name')]/SPAN[contains(., '${params.'Set Name'}')]")==1, "Error - Set ${params."Set Name"} Not Found"
            //assert Exists.run(ID:"//*[contains(@class, 'f-best-idea-top-left-bar')]/*[contains(@class,'f-best-idea-set-name') and contains(.,'${params.'Set Name'}')]")==1, "1-Error - Set ${params."Set Name"} Not Found"
    	}
    }
}