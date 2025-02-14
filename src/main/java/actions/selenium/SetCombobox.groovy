package actions.selenium;

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

//import emoji4j.EmojiUtils
import org.openqa.selenium.StaleElementReferenceException;

class SetCombobox{
    public static void run(def params){
        //params.ID
        //params.Option
        //param."Set Text by Pasting" true|false - set to true when inputting emoji
        //params."Type of Clear"
        
        int maxAttempts = 3
        boolean success = false
        int attempts = 0
        def noEmoji
        WebElement comboBox = null
        String elClass
        while (!success && attempts < maxAttempts) {
            try {
                comboBox = Elements.find(params, Browser.Driver)
        		comboBox.click()
        		Thread.sleep(500)
        		elClass = comboBox.getAttribute("class")
        		success = true; // If no exception is thrown, consider the operation successful
    		} catch (StaleElementReferenceException e) {
        		attempts++;
        		println("Stale element encountered. Retrying... Attempt: " + attempts)
        		// Optionally, add a delay between retries if needed
        		Thread.sleep(1000)
            }
        }  
        if(!elClass.contains("readonly")){												//dropdown's search is disabled if less than seven options
            comboBox.sendKeys(Keys.chord(Keys.CONTROL, "a"))
            comboBox.sendKeys(Keys.chord(Keys.CONTROL, "x"))
            if(params."Option"){
                if(containsEmoji(params.Option)){  //remove emoji
                    noEmoji = params."Option".substring(0, params."Option".length() - 2) 
                    SetText.run(ID:params.ID, Text:noEmoji, "Type of Clear":params."Type of Clear")
                } else {
                    SetText.run(ID:params.ID, Text:params.Option, "Type of Clear":params."Type of Clear")
                }                 
            }
        }
        try{
        	MouseOver.run(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/DIV[contains(@class,'f-combobox-list-item') and starts-with(.,'${params.Option}')]")
			sleep(500)
        	Click.run(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/DIV[contains(@class,'f-combobox-list-item') and starts-with(.,'${params.Option}')]", "Type of Click":"Move to Element")
  		}catch (StaleElementReferenceException e){
            sleep(2000)
            System.out.println("Stale element encountered. Retrying...")
            MouseOver.run(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/DIV[contains(@class,'f-combobox-list-item') and starts-with(.,'${params.Option}')]")
			sleep(500)
        	Click.run(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/DIV[contains(@class,'f-combobox-list-item') and starts-with(.,'${params.Option}')]", "Type of Click":"Move to Element")
        }
        //MouseOver.run(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/DIV[contains(@class,'f-combobox-list-item') and starts-with(.,'${params.Option}')]")
        //sleep(500)
        //Click.run(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/DIV[contains(@class,'f-combobox-list-item') and starts-with(.,'${params.Option}')]", "Type of Click":"Move to Element")
    }
    private static boolean containsEmoji(String str) {
    	int length = str.length();

    	for (int i = 0; i < length; i++) {
      		int type = Character.getType(str.charAt(i));
      		if (type == Character.SURROGATE || type == Character.OTHER_SYMBOL) {
        		return true;
      		}
    	}
    	return false;
  	}
}