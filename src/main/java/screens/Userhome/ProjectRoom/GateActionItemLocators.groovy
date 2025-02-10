package screens.Userhome.ProjectRoom;

import org.openqa.selenium.By

class GateActionItemLocators{
    // Static class-level variable
	static By popoutReviewButton
	static By collapse
	static By expand
	static By completeGate
    static By deleteGateCheckbox
    
    public static void run(def params){
        
        String baseXPath = params['Base XPath'] ?: ""
        popoutReviewButton = By.xpath("//*[contains(@class,'f-pop-out-btn')]")
        collapse = By.xpath("//*[contains(@data-tooltip-content,'Collapse')]")
        expand = By.xpath("//*[contains(@data-tooltip-content,'Expand')]")
        completeGate = By.xpath(baseXPath + "//BUTTON[contains(@class,'f-gate-submit')]")
        deleteGateCheckbox= By.xpath("//*[@for='f-delete-room-hackathon-checkbox']")
        
    }
}