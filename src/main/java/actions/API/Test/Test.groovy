package actions.API.Test;

import org.testng.Assert
import org.testng.annotations.*

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.*;

//testing login api
    
class Test{
    @BeforeClass
    public void setBaseUri() {          
     		RestAssured.baseURI = params.URL;    
		}
    public void run(def params){
        
  		
        
        
        /*
        RestAssured.baseURI ="${params.URL} + "" 
        RequestSpecification request = RestAssured.given();
        
        JSONObject requestParams = new JSONObject();
        requestParams.put("name","test idea3")
        requestParams.put("description")
        
        */
        
        
    }
}