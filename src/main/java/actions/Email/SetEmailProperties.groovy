package actions.Email;

import java.util.Properties;

class SetEmailProperties{
    public static def run(def params){
        try{
            Properties props = new Properties(); 
				//using STARTTLS
            	props.put("mail.smtp.host", params."Sender Host");
      			props.put("mail.smtp.port", "587");
      			props.put("mail.smtp.starttls.enable", "true");
            	props.put("mail.smtp.starttls.required", "true");
      			props.put("mail.smtp.auth", "true");
                props.put("mail.debug", "true");
            	//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				// Configure the SSL/TLS protocols and cipher suites.
				props.put("mail.smtp.ssl.protocols", "TLSv1.2");
				props.put("mail.smtp.ssl.cipherSuites", "ECDHE-RSA-AES128-GCM-SHA256,ECDHE-RSA-AES256-GCM-SHA384");

            	return props
            
				
            	
            	//using SSL
            	/*props.put("mail.transport.protocol", "smtps");
            	props.put("mail.host", params."Sender Host");
            	props.put("mail.smtps.auth", "true");
            	props.put("mail.smtps.port", "465");
            	props.put("mail.smtps.ssl.trust", params."Sender Host");
            	props.put("mail.smtps.ssl.enable", "true");
            	props.setProperty("mail.smtps.ssl.protocols", "TLSv1.1 TLSv1.2");*/
				
            	return props
        }catch(Exception e){
            e.printStackTrace()
    		println("Error in creating props file.")
  		}
    }
}