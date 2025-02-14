package actions.Mailinator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GetURLFromEmail{
    public String run(def params){
        def email = GetMailinatorEmail.run(params)
        def body = email.body.toString()
        def subject = email.subject.toString()
        //println("Subject:"+ subject)
        assert (subject.contains(params."Email Subject")), "Error in the Email Subject"
        String urlPattern = "https?://\\S+";
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(body);
        while (matcher.find()) {
            String url = matcher.group();
            //println("Found URL: " + url);
            return url
        }
    }
}