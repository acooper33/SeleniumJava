package actions.Mailinator;

import actions.Mailinator.GetMailinatorEmail
import java.util.regex.Pattern
import java.util.regex.Matcher

class GetDownloadLinkfromEmail{
    public static def run(def params){
        def body
        def link
        List<String> extractedUrls
        if(params."Link Number" == null) {params."Link Number"='1'}
        
        //get body of the email
        body = GetMailinatorEmail.run(params).body
        println("Body: ${body}")
        
        //extract all URLs
        extractedUrls = extractUrls(body)        
        link = extractedUrls[params."Link Number".toInteger()-1]
        println("Requested URL: ${link}")
        
        //for debugging
        /*for (String url : extractedUrls)
		{
    		println("Printing all URLs:")
            System.out.println(url);
		}*/
        
        return link;

        /*
        if(body.contains("To download, click the link below:")){
            println("1")
            link = body.substring(body.indexOf("below:") + 12, body.indexOf("Please note") - 12)}
        else if(body.contains("Click the link below to download:")){
            println("2")
            link = body.substring(body.indexOf("download:") + 15, body.indexOf("Please note") - 12)}
        else if(body.contains("Recurring")){
            println("3")
            link = body.substring(body.indexOf("https//:"), body.indexOf(" "))}
        else{
            println("4")
            link = body.substring(body.indexOf("blank_\">") + 8, body.indexOf("</a>"))}
        */
        //println("Download link: ${link}")
        //return link
    }
    public static List<String> extractUrls(String text){
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;\$()~_?\\+-=\\\\\\.&]*(?=<))";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);
        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }
        return containedUrls;
   }

}