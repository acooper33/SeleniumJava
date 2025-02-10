package screens.ViewIdea3;

import org.openqa.selenium.By

class StageGateActionItemInViewIdea3{
    
    static By dueDate
    static By completeActionItemButton
    static By completedMessage
    static By linkOnCompletedTab
    
    public static void run(def params){
        
        String actionItem = params['Stage or Gate action item']
        dueDate = By.xpath("//*[@class='f-action-item-type' and text()='${actionItem}']/..//*[contains(@class,'f-due-label') and .='Due: ${params['Due Date']}']")
        completeActionItemButton = By.xpath("//*[@class='f-action-item-type' and text()='${actionItem}']/..//*[contains(@class,'f-btn-primary f-btn-sm f-action-btn')]")
		completedMessage = By.xpath("//*[@class='f-action-item-type' and text()='${actionItem}']/..//*[contains(@class,'f-completed-label')]/*[text()='${params['Completed Message']}']")
        linkOnCompletedTab = By.xpath("//*[contains(@class,'f-action-item-type') and text()='${actionItem}']")
    }
}
