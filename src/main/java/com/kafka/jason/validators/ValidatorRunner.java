package com.kafka.jason.validators;

public class ValidatorRunner {
	 public static void main(String[] arg) throws Exception {
		 ValidatorEntity en=new ValidatorEntity();
		 JsonSchemaValidators.validatorRun(en);
	 }
}
