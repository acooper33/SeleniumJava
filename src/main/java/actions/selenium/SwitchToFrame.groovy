package actions.selenium


import actions.selenium.utils.Elements

class SwitchToFrame{

    public static void run(def params){
        if(params.Name){
            Browser.Driver.switchTo().frame(params.Name)
        }
        else if(params.Index){
            Browser.Driver.switchTo().frame(params.Index.toInteger())
        }
        else if(params.xpath){
            def element = Elements.find(ID:params.xpath,Browser.Driver)
            Browser.Driver.switchTo().frame(element)
        }
        else{
            def element = Elements.find(params,Browser.Driver)
            Browser.Driver.switchTo().frame(element)}
    }
}
