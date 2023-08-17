package com.kafka.jason.validators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProducerProperties {
	 public static void main(String args[]) throws IOException {
	      Properties prop = readPropertiesFile("validator.properties");
	      System.out.println("username: "+ prop.getProperty("username"));
	      System.out.println("password: "+ prop.getProperty("password"));
	      System.out.println("topic: "+ prop.getProperty("topic"));
	      System.out.println("bootstrapServers: "+ prop.getProperty("bootstrapServers"));
	      System.out.println("groupId: "+ prop.getProperty("groupId"));
	      
	   }
	   public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }
	

}
