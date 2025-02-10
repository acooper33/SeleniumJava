package screens;
import org.openqa.selenium.By

class ReactFormDifferentFieldLocators{
        
    	// Static class-level variables
    	static By dateField
    	static By dropdownField
    	static By dropdownFieldValue
    	static By longTextField
    	static By multiChoiceCheckboxChecked
    	static By multiChoiceCheckboxUnchecked
    	static By radioButton
    	static By radioButtonWithoutFieldName
        static By shortTextField
       	static By multiChoiceWithoutFieldNameCheckboxChecked
    	static By multiChoiceWithoutFieldNameCheckboxUnChecked
    
    	public static void run(def params) {

            String baseXPath = params['Base XPath'] ?: ""
        	// Date Field
        	dateField = By.xpath("//*[contains(@class,'react-datepicker__input-container')]/INPUT")

        	// Dropdown Field - using params dynamically
        	dropdownField = By.xpath("//*[text()='${params['Field Name']}']/..//*[@data-test='f-test-dropdown']")
        	dropdownFieldValue = By.xpath("//*[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//*[text()='${params['Field Value']}']")
        
        	// Long Text
        	longTextField = By.xpath(baseXPath + "//*[text()='${params['Field Name']}']/..//*[contains(@class,'fractal-textarea')]/TEXTAREA")
            
            // Checkboxes
            multiChoiceCheckboxChecked = By.xpath("//*[text()='${params['Field Name']}']/..//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='${params['Field Value']}']/..")
        	multiChoiceCheckboxUnchecked = By.xpath("//*[text()='${params['Field Name']}']/..//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='${params['Field Value']}']/..")
            multiChoiceWithoutFieldNameCheckboxChecked = By.xpath("//SPAN[text()='${params['Field Value']}']/../..//DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]//DIV[contains(@class,'f-checkbox-inner')]")
        	multiChoiceWithoutFieldNameCheckboxUnChecked = By.xpath("//SPAN[text()='${params['Field Value']}']/../..//DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]//DIV[contains(@class,'f-checkbox-inner')]")
            
            // Radiobutton
        	radioButton = By.xpath(baseXPath + "//*[text()='${params['Field Name']}']/..//*[text()='${params['Field Value']}']/../*[@class='f-radio-outer']")
            radioButtonWithoutFieldName = By.xpath(baseXPath + "//*[text()='${params['Field Value']}']/../*[@class='f-radio-outer']")
            
            // Short Text
        	shortTextField = By.xpath("//*[text()='${params['Field Name']}']/..//*[contains(@class,'fractal-input')]//INPUT")
                 
    }
}