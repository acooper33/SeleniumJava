package actions.general;

import actions.selenium.Click
import actions.general.Navigate
import actions.selenium.MouseOver
import actions.selenium.SetFocus
import actions.selenium.NavigateToURL
import actions.selenium.Browser
import org.openqa.selenium.interactions.Actions
import actions.selenium.utils.Elements
import actions.selenium.Exists
import org.openqa.selenium.JavascriptExecutor
import actions.selenium.ExplicitWait
import actions.selenium.*
import actions.PipelineSetup.SetLeftSideTabInPipelineSetup

class NavigateWebStormAdminBar{
    public static void run(def params){
        switch(params."Area to Navigate to"){
            case "Home":
                GoToWebStormHome(params)
            	break
            case "Memo Post Idea":
            	def currentURL = Browser.Driver.getCurrentUrl().split(".com")[0]
            	def initiativeName = params."WebStorm Name".replaceAll("\\s","")
            	NavigateToURL.run(URL:currentURL+".com/"+initiativeName+"/submit")
            	break
            case "Memo Idea Boards":
				def currentURL = Browser.Driver.getCurrentUrl().split(".com")[0]
            	def initiativeName = params."WebStorm Name".replaceAll("\\s","")
            	NavigateToURL.run(URL:currentURL+".com/"+initiativeName+"/boards")
            	break
             case "Memo Top Ideas":
            	def currentURL = Browser.Driver.getCurrentUrl().split(".com")[0]
            	def initiativeName = params."WebStorm Name".replaceAll("\\s","")
            	NavigateToURL.run(URL:currentURL+".com/"+initiativeName+"/boards/bestIdea/eu?")
            	break
            case "Post Idea":
            	GoToWebStormHome(params)
            	if(Exists.run(ID:"//*[@id='hh-buttons']/A[1]")==0) { 
                	Click.run(ID:"//*[@class='nav-desktop']//*[contains(@href,'submit')]", "Type of Click":"Javascript")
                } else 
                    Click.run(ID:"//*[@id='hh-buttons']/A[1]", "Type of Click":"Javascript")
            	sleep(5000)
            	break
            case "Idea Board":
            	GoToWebStormHome(params)
            	if(Exists.run(ID:"//*[@id='hh-buttons']/A[contains(text(),'Browse')]")==1) { 
               	Click.run(ID:"//*[@id='hh-buttons']/A[contains(text(),'Browse')]", "Type of Click":"Javascript")
                } else Click.run(ID:"//*[@class='nav-desktop']//*[contains(@href,'boards')]", "Type of Click":"Javascript")
            	break
            case "Pipeline Steps":
            	Navigate.run("Area to Navigate to":"Command Center")
            	Click.run(ID:"//*[@id='pipeline-list']//DIV[text()='${params."WebStorm Name"}']")
            	sleep(2000)
            	break
            case "Pipeline List":
            	Navigate.run("Area to Navigate to":"Command Center")
            	Click.run(ID:"//*[@id='pipeline-list']//DIV[text()='${params."WebStorm Name"}']")
            	Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='List']")
            	sleep(2000)
            	break
            case "Pipeline Action Items Manager":
            	Navigate.run("Area to Navigate to":"Command Center")
            	Click.run(ID:"//*[@id='pipeline-list']//DIV[text()='${params."WebStorm Name"}']")
            	Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
            	Click.run(ID:"//*[contains(@class,'fractal-dropdownPopout-popout-container')]//UL/LI[contains(@class,'nav-item')]/A/*[text()='Action Items Manager']")
            	sleep(2000)
            	break
            case "Setup":
            	Navigate.run("Area to Navigate to":"Command Center")
            	Click.run(ID:"//*[@id='pipeline-list']//DIV[text()='${params."WebStorm Name"}']")
            	Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
            	sleep(2000)
            	Click.run(ID:"//*[contains(@class,'fractal-dropdownPopout-popout-container')]//UL/LI[contains(@class,'nav-item')]/A/*[text()='Site Setup']")
            	sleep(2000)
            	break
            case "Pipeline Setup":
            	Navigate.run("Area to Navigate to":"Command Center")
            	Click.run(ID:"//*[@id='pipeline-list']//DIV[text()='${params."WebStorm Name"}']")
            	sleep(2000)
            	Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='Pipeline Setup']")
            	break
            case "Rules":
            	NavigateWebStormAdminBar.run("Area to Navigate to":"Pipeline Steps","WebStorm Name":params."WebStorm Name")
            	Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='Pipeline Setup']")
            	sleep(2000)
            	SetLeftSideTabInPipelineSetup.run(Tab:"Rules")
            	sleep(3000)
            	break
            case "a.bix":
            	def currentURL = Browser.Driver.getCurrentUrl().split("#")[0]
            	def startingURL = currentURL.split("/ct_admin")[0]
            	def endingURL = currentURL.substring(currentURL.lastIndexOf("?"));
            	NavigateToURL.run(URL:startingURL+"/a.bix"+endingURL)
            	break
             case "c.bix":
            	def currentURL = Browser.Driver.getCurrentUrl().split("#")[0]
            	def startingURL = currentURL.split("/ct_admin")[0]
            	def endingURL = currentURL.substring(currentURL.lastIndexOf("?"));
            	NavigateToURL.run(URL:startingURL+"/c.bix"+endingURL)
            	break
             case "z.bix":
            	def currentURL = Browser.Driver.getCurrentUrl().split("#")[0]
            	def startingURL = currentURL.split("/ct_admin")[0]
            	def endingURL = currentURL.substring(currentURL.lastIndexOf("?"));
            	NavigateToURL.run(URL:startingURL+"/z.bix"+endingURL)
            	break
            case "Blog":
            	NavigateWebStormAdminBar.run("Area to Navigate to":"Setup","WebStorm Name":params."WebStorm Name")
            	def currentURL = Browser.Driver.getCurrentUrl().split("#")[0]
            	def startingURL = currentURL.split("/ct_")[0]
            	def endingURL = currentURL.substring(currentURL.lastIndexOf("?"));
            	NavigateToURL.run(URL:startingURL+"/ct_blog_list.bix"+endingURL)
            	break
            case "Public Webstorm Idea Board":
  				NavigateWebStormAdminBar.run("Area to Navigate to":"Public Webstorm Home","WebStorm Name":params."WebStorm Name")
            	Click.run(ID:"//*[@id='hh-buttons']/A[contains(text(),'Browse')]")
            	break
            case "Public Webstorm Home":
            	def currentURL
        		//Support for Labs code environment
        		if(Browser.Driver.getCurrentUrl().contains("bidev.us")){
            		currentURL = "${Browser.Driver.getCurrentUrl().split("\\.")[0]}.${Browser.Driver.getCurrentUrl().split("\\.")[1]}.us"
        		} else  if(Browser.Driver.getCurrentUrl().contains("eu.brightidea")){
            			currentURL = "${Browser.Driver.getCurrentUrl().split("\\.")[0]}.eu.${Browser.Driver.getCurrentUrl().split("\\.")[2]}.com"
                } else{currentURL = "${Browser.Driver.getCurrentUrl().split("\\.")[0]}.${Browser.Driver.getCurrentUrl().split("\\.")[1]}.com"}
            	//def currentURL = "${Browser.Driver.getCurrentUrl().split("\\.")[0]}.${Browser.Driver.getCurrentUrl().split("\\.")[1]}.com"
            	def webstormName = params."WebStorm Name".replaceAll(" ","")
            	NavigateToURL.run(URL:currentURL+"/${webstormName}")
            	break
             case "Pipeline Dashboard":
            	Navigate.run("Area to Navigate to":"Command Center")
            	Click.run(ID:"//*[@id='pipeline-list']//DIV[text()='${params."WebStorm Name"}']")
            	sleep(2000)
            	Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
            	Click.run(ID:"//*[contains(@class,'backbone-link') and .='Dashboard']")
            	break
            case "Communications":
            	NavigateWebStormAdminBar.run("Area to Navigate to":"Pipeline Setup")
            	Click.run(ID:"//*[@tab='communicationEmails']")
            	sleep(2000)
            	break
            case "Top Ideas":
            	GoToWebStormHome(params)
            	Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
            	sleep(2000)
            	Click.run(ID:"//*[contains(@class,'fractal-dropdownPopout-popout-container')]//UL/LI[contains(@class,'nav-item')]/A/*[text()='Top Ideas']")
            	sleep(2000)
            	break
            case "Create Memo":
            	MouseOver.run(ID:"//*[text()='CREATE A MEMO']/..")
                Click.run(ID:"//*[contains(@class,'nav-children-visible')]//*[contains(@href,'memo/create') and text()='Create Memo']", "Type of Click":"Javascript")
            	break
            case "Memo Team Site":
            	def currentURL = Browser.Driver.getCurrentUrl().split(".com")[0]
            	NavigateToURL.run(URL:currentURL+".com/mts/${params."Memo Team Site Link"}")
            	break
            case "Participants Page":
				def currentURL = Browser.Driver.getCurrentUrl().split(".com")[0]
            	def initiativeName = params."WebStorm Name".replaceAll("\\s","")
            	NavigateToURL.run(URL:currentURL+".com/"+initiativeName+"/participants")
            	break
            case "Top Bar Navigation":
				GoToWebStormHome(params)
            	Click.run(ID:"//ul[@class='desktop-nav-core-items']//a[contains(text(),'${params."Top Bar Navigation Option"}')]")
            	break
            case "Hackathon Team Site":
            	def currentURL = Browser.Driver.getCurrentUrl().split(".com")[0]
            	def initiativeName = params."WebStorm Name".replaceAll("\\s","")
            	NavigateToURL.run(URL:currentURL+".com/hts/"+initiativeName)
            	break
        }
    }
    
    public static void GoToWebStormHome(def params){
        Navigate.run("Area to Navigate to":"Home")
        //sleep(3000)
        ExplicitWait.run(ID:"//*[@id='navbar']")
        def currentURL = Browser.Driver.getCurrentUrl()
        switch(params."WebStorm Name"){
            case "Custom App":
                //NavigateToURL.run(URL:currentURL+"CustomApp")	
                Click.run(ID:"//*[text()='${params."WebStorm Name"}']/parent::DIV/parent::DIV//A[.='View Topic']","Type of Click":"Javascript")
                 break
            case "Evaluators app":
                NavigateToURL.run(URL:currentURL+"evaluatorsapp")	
                break
            case "Solve App":
                NavigateToURL.run(URL:currentURL+"SolveApp")	
                break
            default:
                Click.run(ID:"//*[text()='${params."WebStorm Name"}']/parent::DIV/parent::DIV//A[.='View Topic']","Type of Click":"Javascript")
        }
    }
}