package actions.NGAInnovationList;

import actions.selenium.Click

class ExportIdeasfromInnovationsList{
    public void run(def params){
        Click.run(ID:"//*[starts-with(@id,'report')]/I[contains(@class,'fa fa-file-excel-o')]")
        sleep(1000)
        if(params.Action=="Export"){Click.run(ID:"//*[@class='bimodal']/DIV[@class='bimodal-footer']//SPAN[@id='bi-modal-button']")}
        if(params.Action=="Cancel"){Click.run(ID:"//*[@class='bimodal']/DIV[@class='bimodal-footer']//A[text()='Cancel']")}
    }
}