package actions.general;

import actions.selenium.Exists
import actions.selenium.ExecuteJavascript
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class VerifyValuesLicenseManager{
    public void run(def params){
        if(params."Idea Box Manager Licenses - Purchased"){
            WebElement adminSection = Elements.find(ID:"//*[contains(@class,'f-standard-license')][2]",Browser.Driver)
        	ExecuteJavascript.run(Code:"arguments[0].scrollIntoView(true);", "Arguments":adminSection)
            
            assert Exists.run(ID:"//DIV[@class='f-standard-license ']//DIV[contains(@class,'f-license-input-wrapper')]//INPUT[@class='f-license-input' and @value='${params."Idea Box Manager Licenses - Purchased"}']")==1, "Error in \'Idea Box Manager Licenses - Purchased\'."
        }
        if(params."Idea Box Manager Licenses - Unlimited"){
        	assert Exists.run(ID:"//DIV[@class='f-standard-license ']/DIV[contains(@class,'f-admin-license-area')]//DIV[contains(@class,'f-checkbox-checked')]//INPUT[@id='f-idea-box-unlimited' and @checked]/..")==1, "Error in \'Idea Box Manager Licenses - Unlimited\'." 
        }
        if(params."Idea Box Manager Licenses - Overage"){
          	assert Exists.run(ID:"//DIV[@class='f-standard-license ']//DIV[contains(@class,'f-overage-wrapper')]//INPUT[@id='f-standard-idea-box-overage' and @checked]/..")==1, "Error \'Idea Box Manager Licenses - Unlimited\' is not enabled." 
        	assert Exists.run(ID:"//DIV[@class='f-standard-license ']//DIV[contains(@class,'f-overage-wrapper')]/../INPUT[@class='f-license-input' and @value='${params."Idea Box Manager Licenses - Overage"}']")==1, "Error in \'Idea Box Manager Licenses - Unlimited\'."   
        }
        if(params."Idea Box Manager Licenses - Total Allocated"){
          	assert Exists.run(ID:"//*[contains(@class,'f-standard-license')][2]//*[text()='Total Allocated']//../../following-sibling::DIV/*[text()='${params."Idea Box Manager Licenses - Total Allocated"}']")==1, "Error - Incorrect total allocated count for ideabox manager"  
        }
        if(params."Idea Box Manager Licenses - In Use"){
          	assert Exists.run(ID:"//*[contains(@class,'f-standard-license')][2]//*[text()='In Use']//../../following-sibling::DIV/*[text()='${params."Idea Box Manager Licenses - In Use"}']")==1, "Error - Incorrect in use count for ideabox manager"  
        }
        if(params."Brightidea Administrator Licenses - Unlimited"){
            assert Exists.run(ID:"//DIV[@class='f-standard-license']/DIV[contains(@class,'f-admin-license-area')]//DIV[contains(@class,'f-checkbox-checked')]//INPUT[@id='f-admin-unlimited' and @checked]/..")==1, "Error in \'Brightidea Administrator Licenses - Unlimited\'." 
        }
        if(params."Brightidea Administrator Licenses - Purchased"){
            assert Exists.run(ID:"//DIV[@class='f-standard-license']/DIV[contains(@class,'f-admin-license-area')]//DIV[contains(@class,'f-license-input-wrapper')]//INPUT[@class='f-license-input' and @value='${params."Brightidea Administrator Licenses - Purchased"}']")==1, "Error in \'Brightidea Administrator Licenses - Purchased\'."
        }
        if(params."Brightidea Administrator Licenses - Overage"){
            assert Exists.run(ID:"//DIV[@class='f-standard-license']/DIV[contains(@class,'f-admin-license-area')]//DIV[contains(@class,'f-overage-wrapper')]//INPUT[@id='f-standard-admin-overage' and @checked]/..")==1, "Error \'Brightidea Administrator Licenses - Overage\' is not enabled." 
        	assert Exists.run(ID:"//DIV[@class='f-standard-license']/DIV[contains(@class,'f-admin-license-area')]//DIV[contains(@class,'f-overage-wrapper')]/..//INPUT[contains(@class,'f-license-input') and @value='${params."Brightidea Administrator Licenses - Overage"}']")==1, "Error in \'Brightidea Administrator Licenses - Overage\'." 
        }
        
        if(params."Brightidea Moderator Licenses - Unlimited"){
            WebElement moderatorSection = Elements.find(ID:"//*[contains(@class,'f-license-moderator-row')]//INPUT[@id='f-standard-moderator']",Browser.Driver)
        	ExecuteJavascript.run(Code:"arguments[0].scrollIntoView(true);", "Arguments":moderatorSection)
        	
            assert Exists.run(ID:"//DIV[contains(@class,'f-license-moderator-row')]//INPUT[@id='f-standard-moderator' and @checked]/.."), "Error - Brightidea Moderator Licenses not enabled."
            assert Exists.run(ID:"//DIV[@class='f-standard-license']/DIV[contains(@class,'f-moderator-license-area')]//DIV[contains(@class,'f-checkbox-checked')]//INPUT[@id='f-idea-box-unlimited' and @checked]/..")==1, "Error \'Brightidea Moderator Licenses - Unlimited\' not enabled." 
        }
        if(params."Brightidea Moderator Licenses - Purchased"){
           assert Exists.run(ID:"//DIV[@class='f-standard-license']/DIV[contains(@class,'f-moderator-license-area')]//DIV[contains(@class,'f-license-input-wrapper')]//INPUT[@class='f-license-input' and @value='${params."Brightidea Moderator Licenses - Purchased"}']")==1, "Error in \'Brightidea Moderator Licenses - Purchased - Purchased\'."
        }
    }
}