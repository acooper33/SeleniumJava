package actions.PipelineStepsView;
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import actions.selenium.ExplicitWait

class ReturnAllCompaniesfromScoutAppAIModal{
    public static run(def params){
        ExplicitWait.run(ID:"//*[contains(@class,'f-import-with-ai-results-item-wrapper')]") 
        
        List<WebElement> allList
        if(params."Company or Description"=="Company"){
            allList = Browser.Driver.findElements(By.xpath("//*[contains(@class,'f-import-with-ai-results-item-wrapper')]/DIV//*[contains(@class,'f-import-with-ai-results-item-name')]"))
        } else {
           allList = Browser.Driver.findElements(By.xpath("//*[contains(@class,'f-import-with-ai-results-item-wrapper')]/DIV//*[contains(@class,'f-import-with-ai-results-item-desc')]"))    
        }
        List<String> companyList = new ArrayList<>()
        for (int i = 0; i < allList.size(); i++) {
            String text = allList.get(i).getText()
            companyList.add(text)
            if (i < allList.size() - 1) {
                companyList.add("|||")
            }
        }      
/*        def companyList = []
        for(WebElement e : allList) {
            companyList.add(e.getText())
            companyList.add("|||")
            }*/
        println(companyList)
        return companyList
    }
}