package actions.Widgets;

import actions.selenium.*

class VerifyWidgetEnterpriseMyStats{
    public void run(def params){
        VerifyText.run(ID:"//*[contains(@class,'widget_container enterprise_my_stats_widget')]//*[contains(@id,'_body')]//TR[1]/TD[1]",Text:params."submissions")
        VerifyText.run(ID:"//*[contains(@class,'widget_container enterprise_my_stats_widget')]//*[contains(@id,'_body')]//TR[2]/TD[1]",Text:params."votes of support")
        VerifyText.run(ID:"//*[contains(@class,'widget_container enterprise_my_stats_widget')]//*[contains(@id,'_body')]//TR[3]/TD[1]",Text:params."comments")
        VerifyText.run(ID:"//*[contains(@class,'widget_container enterprise_my_stats_widget')]//*[contains(@id,'_body')]//TR[4]/TD[1]",Text:params."total points")
    }
}