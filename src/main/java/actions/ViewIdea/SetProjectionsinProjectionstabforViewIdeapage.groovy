package actions.ViewIdea;

import actions.common.ViewIdeaCommon
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists
import actions.selenium.SendKeys
import actions.POMHelperAndLocators.FormElements.SetReactDateField

class SetProjectionsinProjectionstabforViewIdeapage{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='fractal-modal-body fractal-projections-modal-body']")==0){ 
            ViewIdeaCommon.NavigateTab(Tab:"Projections")
            Click.run(ID:"//*[@id='projectionModal']")} 

        if(params."Launch Date") {
            SetReactDateField.run("Date":params."Launch Date")
//            SetText.run(ID:"//*[contains(@class,'react-datepicker__input-container')]/INPUT",Text:params."Launch Date","Type of Clear":"Cut")
            Click.run(ID:"//*[@id='projections-net-1']")
        }

        if(params."Year"){
            params."Year".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove Year".split(",")[x]=="Add"){
                    def cost = params."Cost Value".split(",")
                    def revenue  = params."Revenue Savings".split(",")
                    if(name<="3") {
                        SetText.run(ID:"//*[@id='projections-cost-${name}']",Text:cost[x])
                        SetText.run(ID:"//*[@id='projections-revenue-${name}']",Text:revenue[x])
                    } else {
                        if(Exists.run(ID:"//*[@id='projections-cost-${name}']")>0) {
                            SetText.run(ID:"//*[@id='projections-cost-${name}']",Text:cost[x])
                            SetText.run(ID:"//*[@id='projections-revenue-${name}']",Text:revenue[x])
                        } else { Click.run(ID:"//*[@id='projectionsAdd']")
                                SetText.run(ID:"//*[@id='projections-cost-${name}']",Text:cost[x])
                                SetText.run(ID:"//*[@id='projections-revenue-${name}']",Text:revenue[x])
                               }
                    }
                } else (Click.run(ID:"//*[@id='projections-year-${name}']//I"))
            }
        }
        SetText.run(ID:"//*[@id='projectionsNotes']",Text:params."Notes")

        if(params.Action) {  if(params.Action=="Cancel"){Click.run(ID:"//*[@id='projectionsCancel']")}
                           else{Click.run(ID:"//*[@id='projectionsSave']")}}
    }
}