package actions.Enterprise.UserHomepage;

import actions.selenium.MouseOver
import actions.selenium.Click


class SelectActivityinUserHomepage{
    public void run(def params){
        def id = "//*[@class='f-campaigns-grid']/DIV[@class='f-campaign-card']/DIV[@class='f-card-image']/H2[@class='f-card-name' and text()='${params."Activity Name"}']"
        MouseOver.run(ID:id)
        Click.run(ID:"${id+"/../*[@class='f-card-btn-container']//*[text()='${params."Action"}']"}")
    }
}