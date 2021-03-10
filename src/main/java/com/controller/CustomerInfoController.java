package com.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
import com.bean.CustomerBean;
@RestController
public class CustomerInfoController {
@PostMapping(value="/saveCustomerData", consumes="application/json")
String saveCustomerInfo(@RequestBody CustomerBean custBean) {
	System.out.println(custBean.getName()+" "+custBean.getAge());
	return "Saved successfully";
}

@GetMapping(value="/getDetails")
JSONArray getDetails() {
	
	 JSONParser jsonParser = new JSONParser();
	 JSONArray bookList=null, list=null;
	 ClassPathResource resource = new ClassPathResource("book-info.json");
	 
     try (FileReader reader = new FileReader(resource.getFile()))
     {
         //Read JSON file
         Object obj = jsonParser.parse(reader);

          list = new JSONArray();
         list.add(obj);
         System.out.println(list);
          
      //   list.forEach( emp -> getJson( (JSONObject) emp ) );

     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     } catch (ParseException e) {
         e.printStackTrace();
     }
	return list;
}



private static void getJson(JSONObject info) {
	 //Get employee object within list
	JSONArray array = (JSONArray) info.get("books");
    JSONObject infoObj=(JSONObject)array.get(0);
    
    //Get employee first name
    String firstName = (String) infoObj.get(0);    
    System.out.println(firstName);
     
  
    String lastName = (String) infoObj.get("subtitle");  
    System.out.println(lastName);
     
    //Get employee website name
    String website = (String) infoObj.get("published");    
    System.out.println(website);
    
    String pages = (String) infoObj.get("pages");   
		
}
}