package com.kafka.jason.validators;

import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	public static ValidatorEntity loadProperty(ValidatorEntity entity) {
		Properties prop;
		try {
			prop = ReadProducerProperties.readPropertiesFile("validator.properties");
			if(entity==null)
			{
				entity=new ValidatorEntity();
			}
			if(entity==null||entity.getSchemaPath()==null)
			{
			entity.setSchemaPath(prop.getProperty("schemaPath"));
			}
			
			if(entity==null||entity.getDataJsonPath()==null)
			{
			entity.setDataJsonPath(prop.getProperty("dataJsonPath"));
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return entity;
	}
}
