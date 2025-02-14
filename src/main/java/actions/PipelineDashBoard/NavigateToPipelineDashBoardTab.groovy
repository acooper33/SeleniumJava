package actions.PipelineDashBoard;

import actions.selenium.*
    
class NavigateToPipelineDashBoardTab{
    public void run(def params){

        if(params."Tab"=="Business Impact Tab"){
            Click.run(ID:"//*[@id='dashboards-top-tabs']/A[@tab='businessImpact']")
            sleep(5000)
        } else if(params."Tab"=="Engagement"){
            Click.run(ID:"//*[@id='dashboards-top-tabs']/A[@tab='engagement']")
            sleep(5000)
        } else{Click.run(ID:"//*[@id='dashboards-top-tabs']/A[@tab='overall']")}
    }
}