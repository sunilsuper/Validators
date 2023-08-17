package com.kafka.jason.validators;




import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;  
  
// create class to validate JSON document  
public class JsonSchemaValidators {
    // main() method start  
	 private static final Logger log = LoggerFactory.getLogger(JsonSchemaValidators.class);
    public static void validatorRun(ValidatorEntity entity) throws Exception {  
          
    	entity=LoadProperties.loadProperty(entity);
        // create instance of the ObjectMapper class  
        ObjectMapper objectMapper = new ObjectMapper();  
        InputStream jsonStream=null;
        InputStream schemaStream=null;
        // create an instance of the JsonSchemaFactory using version flag  
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance( SpecVersion.VersionFlag.V201909 );
       
        String DataJsonPath =entity.getDataJsonPath();
        String schemaPath  =entity.getSchemaPath();
        // store the JSON data in InputStream  
        try {
        	     File initialFile = new File(DataJsonPath);
        	     jsonStream = FileUtils.openInputStream(initialFile);
        	     
        		 //InputStream schemaStream = inputStreamFromClasspath("C:\\Users\\sunil.gopalghare\\eclipse-workspace_kafka\\consumer\\schema.json");
        	     Path fileName= Path.of(schemaPath);
        	     schemaStream = Files.newInputStream(fileName);
        	log.debug("Json=="+jsonStream); 
        	//System.out.println("Json=="+s);
        }catch(Exception e)
        {
        	log.debug("Issue while processing files:"+e.getMessage());
        }
        {  
              
            // read data from the stream and store it into JsonNode  
            JsonNode json = objectMapper.readTree(jsonStream);  
              
            // get schema from the schemaStream and store it into JsonSchema  
            JsonSchema schema = schemaFactory.getSchema(schemaStream);  
              
            // create set of validation message and store result in it  
            Set<ValidationMessage> validationResult = schema.validate( json );  
       
            // show the validation errors   
            if (validationResult.isEmpty()) {  
                  
                // show custom message if there is no validation error   
                System.out.println( "There is no validation errors" );  
              
            } else {  
                  
            	for (ValidationMessage vm : validationResult) {
            		System.out.println(vm.getMessage());
				}
                // show all the validation error  
                
                
            }  
        }  
    }  
}  