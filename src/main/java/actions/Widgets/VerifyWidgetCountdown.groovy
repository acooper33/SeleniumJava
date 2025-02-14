package actions.Widgets;

import actions.selenium.*

class VerifyWidgetCountdown{
    public void run(def params){
        VerifyText.run(ID:"//*[@id='countdown-info-wrapper']//SPAN[@class='c-days-number']",Text:params."Days")
        VerifyText.run(ID:"//*[@id='countdown-info-wrapper']//DIV[@class='c-info-bottom']/DIV[@class='c-info-bottom']","Contains Text":params."Hours"+" hours")
        VerifyText.run(ID:"//*[@id='countdown-info-wrapper']//DIV[@class='c-info-bottom']/DIV[@class='c-info-bottom']","Contains Text":params."Mins"+" mins")
    }
}