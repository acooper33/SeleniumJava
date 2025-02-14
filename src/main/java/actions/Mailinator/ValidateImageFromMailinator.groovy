package actions.Mailinator;


class ValidateImageFromMailinator{
    public void run(def params){
        def emailReceived = GetMailinatorEmail.run(params)
        def body = emailReceived.body
        println("Body: ${body}")
    }
}