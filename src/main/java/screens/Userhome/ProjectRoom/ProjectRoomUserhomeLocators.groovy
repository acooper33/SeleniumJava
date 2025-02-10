package screens.Userhome.ProjectRoom;

import org.openqa.selenium.By

class ProjectRoomUserhomeLocators{
  
    // Static class-level variable
	static By searchField
	static By clearOnSearchField
    
    public static void run(def params){
        
        String baseXPath = params['Base XPath'] ?: ""
        clearOnSearchField = By.xpath("//*[contains(@class,'fractal-input fa-search')]/../I")
        searchField = By.xpath("//*[@id='f-pr-search']")
    }
}