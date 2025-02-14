package actions.PipelineDashBoard;

import actions.selenium.*

class VerifytheMousehoverongeographyChartinPipelineEngagementDashboard{
    public void run(def params){
        
      //SetFocus.run(ID:"//*[contains(@id,'participation-map-region')]/*[contains(@class,'highcharts-container')]")
      SetFocus.run(ID:"//*[contains(@class,'f-map-container')]//*[contains(@class,'highcharts-container')]")
      SetFocus.run(ID:"//*[contains(@class,'f-map-container')]//*[name()='g'][contains(@class,'highcharts-tracker')]//*[@class='highcharts-point'][3]")
      assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')][contains(@style,'opacity: 1')]//*[contains(.,\"Barcelona, Barcelona, Spain\")]")==1,"Error in location"
      assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')][contains(@style,'opacity: 1')]//*[text()='Submissions:']/..//*[text()='1']")==1,"Error in number of submissions" 
//      assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')][contains(@style,'opacity: 1')]//*[text()='Comments:']/..//*[text()='2']")==1,"Error in number of comments"
      assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')][contains(@style,'opacity: 1')]//*[text()='Votes:']/..//*[text()='1']")==1,"Error in number of votes"       
    }
}
