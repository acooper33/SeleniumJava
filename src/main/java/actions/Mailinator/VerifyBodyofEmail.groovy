package actions.Mailinator;

class VerifyBodyofEmail{
    public void run(def params){
        def expected
        def bodyWithHtml = GetMailinatorEmail.run(params).body.toString()
        def body = bodyWithHtml.replaceAll("\\<.*?>","").trim().replaceAll("\\s","").replaceAll("<br\\s*/?>","")
        println("Body of the email with HTML: ${bodyWithHtml}")
        println("Body of the email text only: ${body}")
        if(params."Contains Text"){
            expected = params."Contains Text".replaceAll("\\<.*?>","").trim().replaceAll("\\s","")
            println("Email should contain: ${expected} ")
            assert body.contains(expected)==true, "Error - Body of the email does not contain expected"
        }else if (params."Expected Text"){
            expected = params."Expected Text".replaceAll("\\<.*?>","").trim().replaceAll("\\s","")
            println("Expected text: ${expected}")
            assert body.equalsIgnoreCase(expected)==true, "Error - Body of the email is not what expected"
        }else if(params."Contains Text With HTML"){
            println("Expected text: ${params."Contains Text With HTML"}")            
            assert bodyWithHtml.contains(params."Contains Text With HTML")==true, "Error - Body of the email does not contain expected text with HTML"
        }
    }
}