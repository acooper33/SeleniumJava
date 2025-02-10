package screens.SystemSetup;

import org.openqa.selenium.By

class GroupCreationLocators{
    
    // Static class-level variables
    static By createGroup
    static By searchField
    static By closeIconOnSearchField
    static By editGroup
    static By deleteGroup
    static By groupName
    static By resetPoints
    static By memberSearchField
    static By userMemberInitial
    static By userMemberImage
    static By deleteCheckbox
    static By groupList
    static By groupListWithPlacementNumber
    static By userOnLeftRail
    static By userOnLeftRailWithPlacementNumber
    static By userOnRightRail
    static By userOnRightRailWithPlacementNumber
    
    public static void run(def params) {
        createGroup = By.xpath("//span[normalize-space()='Create Group']")
        searchField = By.xpath("//*[contains(@class,'f-group-manager-search')]//INPUT")
        closeIconOnSearchField = By.xpath("//*[contains(@class,'f-group-manager-search')]//I")
        editGroup = By.xpath("//*[contains(@class,'f-group-manager-list-item-name') and .='${params['Group Name to Edit or Delete']}']/..//*[contains(@data-tooltip-id,'f-group-top-tooltip')]")
        deleteGroup = By.xpath("//*[contains(@class,'f-group-manager-list-item-name') and .='${params['Group Name to Edit or Delete']}']/..//*[contains(@data-tooltip-id,'f-group-delete-tooltip')]")
        groupName = By.xpath("//*[contains(@class,'f-modal-body')]//*[contains(@id,'-name-input')]")
        resetPoints = By.xpath("//*[@ID='group-reset-points']")
        memberSearchField = By.xpath("//*[contains(@id,'-members-search')]")       
        userMemberInitial = By.xpath("./../..//*[@class='member-initial']")
        userMemberImage = By.xpath("./../..//*[@class='member-img']")
        deleteCheckbox = By.xpath("//*[contains(@id,'f-delete-group-checkbox')]/..") 
        groupList = By.xpath("//*[contains(@class,'list-item-name') and text()='${params['Group Name']}']")
        groupListWithPlacementNumber = By.xpath("//*[contains(@class,'list-item')][${params['Placement Number']}]//*[contains(@class,'list-item-name') and text()='${params['Group Name']}']")
        userOnLeftRail = By.xpath("//*[contains(@class,'-list-selection')]//*[contains(@class,'member-name') and text()='${params['User']}']")
        userOnLeftRailWithPlacementNumber = By.xpath("//*[contains(@class,'list-selection')][${params['Placement Number']}]//*[contains(@class,'-list-selection')]//*[contains(@class,'member-name') and text()='${params['User']}']")
        userOnRightRail = By.xpath("//*[contains(@class,'-list-right')]//*[contains(@class,'member-name') and text()='${params['User']}']")
        userOnRightRailWithPlacementNumber = By.xpath("//*[contains(@class,'list-right')][${params['Placement Number']}]//*[contains(@class,'-list-selection')]//*[contains(@class,'member-name') and text()='${params['User']}']")
    }
    
    // Dynamic locator for user on the left rail
    public static By getUserOnLeftRail(String name) {
        return By.xpath("//*[contains(@class,'-list-selection')]//*[contains(@class,'member-name') and text()='" + name + "']");
    }

     // Dynamic locator for user on the left rail
    public static By getUserOnRightRail(String name) {
        return By.xpath("//*[contains(@class,'-list-right')]//*[contains(@class,'member-name') and text()='" + name + "']");
    }

    // Dynamic locator for removing user on the right rail
    public static By getRemoveUserInRightRail(String name) {
        return By.xpath("//*[@class='member-name' and text()='" + name + "']/..//I[contains(@class,'far fa-times')]");
    }
}