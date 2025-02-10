package screens;
import org.openqa.selenium.By

public class WhiteboardLocators {
    // This is a screen based on the Journey Pattern. See here for more details on the Journey Pattern: https://fasterchaos.svbtle.com/journey-pattern & https://www.slideshare.net/RiverGlide/a-journey-beyond-the-page-object-pattern#17
    // The screen includes the locators from a standard page object but doesn't include actions, getters or setters. 
    // This allowed locators to be defined, reused and updated easily
    // Note that Elements.groovy was updated to support ID Type 'By', any actions that use Elements.groovy should work fine. Those that don't will need to be updated.
    // Example:    Click.run("ID Type":"By",By:WhiteboardLocators.rightClick_Copy)
    
    // Header Bar
    public static By header_ShareButton = By.xpath("//*[@id='f-share-dialog-btn']")
    public static By header_BackButton = By.xpath("//*[contains(@class, 'fal fa-angle-left')]")
    public static By header_HamburgerButton = By.xpath("//*[contains(@class, 'fal fa-bars')]")
    public static By header_CanvasName = By.xpath("//*[contains(@class, 'f-canvas-name')]")


    // Find Text Dialog
    public static By findResults = By.xpath("//*[contains(@class,'f-text-search-footer-text')]")
    public static By findCloseButton = By.xpath("//*[contains(@class,'f-text-search-close')]")
    public static By nextButton = By.xpath("//span[contains(text(), 'Next')]")
    public static By clearButton = By.xpath("//*[contains(@class,'f-input-search-clear')]")
    public static By searchTextField = By.xpath("//*[contains(@id,'f-text-search-input-inner')]")

    // Whiteboard Right Side Panel
    public static By rightSidePanel_assignee = By.xpath("//*[contains(@class,'f-assign-member')]")
    
    // Whiteboard Right Click Dialog
    public static By rightClick_Copy = By.xpath("//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Copy']")
    public static By rightClick_CopyAsPNG = By.xpath("//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Copy as PNG']")
    public static By rightClick_Paste = By.xpath("//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Paste here']")
    
    //********************************************************************************************************************************

    // Constructor to initialize the driver and instantiate elements using PageFactory
    public WhiteboardLocators() {
    }
    

}

