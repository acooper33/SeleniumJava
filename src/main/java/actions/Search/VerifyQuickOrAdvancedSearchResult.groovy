package actions.Search;

import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists
import actions.selenium.ExecuteJavascript
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class VerifyQuickOrAdvancedSearchResult{
    public void run(def params){
        def verify = [:]
        verify.IDChildren = []
        if(params."Tab" == "Quick Results"){
            println("Verifying Quick Results")
            if(params."Scroll Down"){
                WebElement list = Elements.find([ID:"//UL[@class='recent-list']", "ID Type":"xPath"],Browser.Driver)
        		ExecuteJavascript.run(Code:"arguments[0].scrollTo(0, arguments[0].scrollHeight)", Arguments:list)
            }
            if(params."No Search Results"){
                sleep(3000)
                assert Exists.run(ID:"//*[@class='recent-list']/LI")==0, "Error - Results Present For Quick Search"
                assert Exists.run(ID:"//DIV[contains(@class,'fractal-recently-viewed-list')]/DIV[@class='empty-state']/DIV[@class='f-tab-empty']/I[contains(@class, 'fa-search')]/../H2[text()='No Matches Found']/../P[contains(text(),'No matches were found for  \"${params."Name of the searched item"}\"')]/../P[contains(text(),'Check the spelling, or try searching instead')]")==1, "Error - Missing Empty State for Quick Results"
            }else{
                if(params.'Placement Number (for Quick Results)'){
                	verify.ID = "//*[@class='recent-list']//LI[contains(@class, 'f-search-item')][${params.'Placement Number (for Quick Results)'}]//DIV[@class='f-result-text']/SPAN[@class='f-result-bold' and .='${params."Name of the searched item"}']"
            	}else{
            		verify.ID = "//LI[contains(@class, 'f-search-item')]//DIV[@class='f-result-text']/SPAN[@class='f-result-bold' and .='${params."Name of the searched item"}']"                
            	}
            	if(params."Type"){verify.IDChildren << "./../SPAN[.='${params."Type"}']"}
            	if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
                VerifyNumberOfMatches.run(verify)
            } 
        }
        if(params."Tab" == "Advanced Search"){
            println("Verifying Advanced Search")
            if(params."Scroll Down"){
                WebElement list = Elements.find([ID:"//DIV[@class='f-inner-search-results']", "ID Type":"xPath"],Browser.Driver)
        		ExecuteJavascript.run(Code:"arguments[0].scrollTo(0, arguments[0].scrollHeight)", Arguments:list)
            }
            if(params."No Search Results"){
                sleep(3000)
                assert Exists.run(ID:"//DIV[@class='f-global-nav-search-results']//DIV[@class='f-tab-empty']/I[contains(@class, 'fa-search')]/../H2[text()='No Search Results']/../P[contains(text(),'No results were found for  \"${params."Name of the searched item"}\"')]/../P[contains(text(),'Check the spelling, or try another term')]")==1, "Error - Missing Empty State For Advanced Search"
            }else{
                if(params."Type"){
                	//verify.ID = "//*[@class='f-global-nav-search-results']/DIV[@class='f-inner-search-results']/DIV[@class='f-result-header']/DIV[@class='f-header-left']/H2[.='${params."Type"}']/../../../A[contains(@class, 'f-search-item')]/DIV[@class='f-result-text']/SPAN[@class='f-result-bold' and .='${params."Name of the searched item"}']"
            		verify.ID = "//*[@class='f-global-nav-search-results']//DIV[@class='f-result-header']/DIV[@class='f-header-left']/H2[.='${params."Type"}']/../../following-sibling::A[contains(@class, 'f-search-item')]/DIV[@class='f-result-text']/SPAN[@class='f-result-bold' and .='${params."Name of the searched item"}']"
                }else{
                	verify.ID = "//*[@class='f-global-nav-search-results']//A[contains(@class, 'f-search-item')]/DIV[@class='f-result-text']/SPAN[@class='f-result-bold' and .='${params."Name of the searched item"}']"
            	}
            	if(params."Description (for Advanced Search)"){verify.IDChildren << "./../*[contains(.,'${params."Description (for Advanced Search)"}')]"}
            	if(params."Number of Total (for Advanced Search)"){verify.IDChildren << "./../../..//DIV/A[@class='f-of' and contains(.,'${params."Number of Total (for Advanced Search)"}')]"}
            	if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
                VerifyNumberOfMatches.run(verify)
            	//if(params."Click on View All Results"){Click.run(ID:"//*[contains(@class,'f-results-see-all')]/A")}
            	if(params."Click on Number of Total"){
                	def xPath = verify.ID + "./../../..//DIV/A[@class='f-of' and contains(.,'${params."Number of Total (for Advanced Search)"}')]"
                	Click.run(ID:xPath)
            	}
            }  	
        }
        if(params."Number of Total (for View All Results)"){assert Exists.run(ID:"//*[contains(@class,'f-results-see-all')]/A/SPAN[position()='3' and contains(.,'${params."Number of Total (for View All Results)"}')]")==1,"Error in View All Results total"}
        if(params."Click on result"==true){Click.run(verify)}
        if(params."Click on View All Results"){Click.run(ID:"//*[contains(@class,'f-results-see-all')]/A")}
    }
}