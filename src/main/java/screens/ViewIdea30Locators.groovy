package screens;
import org.openqa.selenium.By

public class ViewIdea30Locators {  
    
   	public static By VI3Modal = By.xpath("//*[contains(@class, 'ReactModal__Content ReactModal__Content--after-open')]")

    // Header
    public static By header_Title;
    public static By header_IdeaCodeInTitle = By.xpath("//*[contains(@class, 'ReactModal__Content ReactModal__Content--after-open')]//*[contains(@class, 'f-static-title')]//a")
    public static By header_IdeaCode = By.xpath("//*[contains(@class, 'ReactModal__Content ReactModal__Content--after-open')]//*[contains(@class, 'fractal-modal-header ')]//*[contains(@class, 'title')]//a")
	public static By header_IdeaImage = By.xpath("//*[contains(@class, 'ReactModal__Content ReactModal__Content--after-open')]//*[contains(@class, 'f-idea-image ')]")
    public static By header_PromoteButton = By.xpath("//*[contains(@class, 'ReactModal__Content ReactModal__Content--after-open')]//BUTTON[contains(@class,'f-promote-btn')]")
	public static By header_ViewVotersLink = By.xpath("//*[contains(@class, 'ReactModal__Content ReactModal__Content--after-open')]//*[contains(@class,'f-votes-btn-link')][text()='View Voters']")
	public static By header_IdeaDropdown = By.xpath("//*[contains(@class, 'ReactModal__Content ReactModal__Content--after-open')]//*[contains(@class, 'f-idea-dropdown')]//*[contains(@class, 'f-dropdown-btn fractal-button')]")
	public static By header_FavoriteSelector= By.xpath("//*[contains(@class, 'ReactModal__Content ReactModal__Content--after-open')]//*[contains(@class, 'f-idea-favorite')]")
    
    // Whiteboard Widget
    public static By header_CanvasName = By.xpath("//*[contains(@class, 'f-canvas-name')]")
    
    //Tags
    public static By ideaTagsContainer = By.xpath("//*[@ID='f-tags-container']")
    public static By ideaTagsComboBox = By.xpath("//*[@ID='react-tags-idea-tags-combobox']")
    public static By ideaTagsPencilButton = By.xpath("//*[@ID='f-tags-container']//I[contains(@class,'far fa-pencil')]")
    public static By ideaTagsSubscriberTooltipButton = By.xpath("//*[@ID='f-tags-container']//*[@ID='f-tags-container']//*[@id='f-tag-subscribe-tooltip']//button")
		    
    // Team Workspace Widget
    public static By createTeamWorkspaceButton = By.xpath("//*[contains(@class,'f-create-workspace-btn')]")
    public static By teamWorkspaceButton = By.xpath("//a[.='View Workspace']")

    
    
    //********************************************************************************************************************************
    
    // Constructor to initialize the driver and instantiate elements using PageFactory
    public ViewIdea30Locators() {
        header_Title = VI3Modal.findElementBy(By.xpath("//*[contains(@class, 'f-static-title')]"))
    }
    
    
    // Dynamic locator for Idea Tags
    public static By getTagLocatorByName(String name) {
        return By.xpath("//*[@ID='f-tags-container']//*[@class='f-tag-name'][text()='" + name + "']");
    }
	


}    
