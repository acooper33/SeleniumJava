package actions.Widgets;

import actions.selenium.*

class VerifyWidgetCommunityStats{
    public void run(def params){
        sleep(2000)
        VerifyText.run(ID:"//*[@id='community_stats_widget_ideas']/TD[1]",Text:params."submissions")
        VerifyText.run(ID:"//*[@id='community_stats_widget_comments']/TD[1]",Text:params."comment")
        VerifyText.run(ID:"//*[@id='community_stats_widget_votes']/TD[1]",Text:params."votes")
        VerifyText.run(ID:"//*[@id='community_stats_widget_users']/TD[1]",Text:params."users")
    }
}