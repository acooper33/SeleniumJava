package actions.Utils;

import actions.selenium.Browser
import java.util.regex.Pattern
import java.util.regex.Matcher

import actions.selenium.NavigateToURL

class ReturnAffiliateID{
    public static String run(def params){
        
        def affiliateID
        NavigateToURL.run(URL:SystemManagerHelper.getAffiliateURL())  	//navigate to here to invoke the affiliate ID to show in the URL
        
        def affiliateURL = Browser.Driver.getCurrentUrl() 				//copying current URL because it has affiliate ID (ODXXX)
        int index = affiliateURL.indexOf("#")
        if (index >= 0){affiliateURL = affiliateURL.substring(0, index)}
        println("Getting affiliate ID from ${affiliateURL}")
        Pattern pattern = Pattern.compile("(?<=\\=)(.*)")
        Matcher matcher = pattern.matcher(affiliateURL)
        if (matcher.find()) {
  			affiliateID = matcher.group()
            println("AffiliateID: ${affiliateID}")
		}
        
        SystemManagerHelper.setAffiliateId(affiliateID)
        return affiliateID
    }
}