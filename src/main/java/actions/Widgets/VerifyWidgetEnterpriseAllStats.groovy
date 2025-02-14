package actions.Widgets;

import actions.selenium.*

class VerifyWidgetEnterpriseAllStats{
    public void run(def params){
        VerifyText.run(ID:"//*[contains(@class,'enterprise_all_stats_widget')]//TR[1]/TD[1]",Text:params."submissions")
        VerifyText.run(ID:"//*[contains(@class,'enterprise_all_stats_widget')]//TR[2]/TD[1]",Text:params."comment")
        VerifyText.run(ID:"//*[contains(@class,'enterprise_all_stats_widget')]//TR[3]/TD[1]",Text:params."votes")
        VerifyText.run(ID:"//*[contains(@class,'enterprise_all_stats_widget')]//TR[4]/TD[1]",Text:params."users")
    }
}