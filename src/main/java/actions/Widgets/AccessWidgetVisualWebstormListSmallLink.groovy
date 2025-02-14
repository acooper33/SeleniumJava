package actions.Widgets;

import actions.selenium.*

class AccessWidgetVisualWebstormListSmallLink{
    public void run(def params){
        Click.run(ID:"//*[@id='visual-small-webstorms-list']//A[text()='${params."Link Name"}']")
    }
}