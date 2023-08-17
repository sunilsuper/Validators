package com.kafka.jason.validators;



public class ValidatorEntity {
private String schemaPath;
public String getSchemaPath() {
	return schemaPath;
}
public void setSchemaPath(String schemaPath) {
	this.schemaPath = schemaPath;
}
public String getDataJsonPath() {
	return dataJsonPath;
}
public void setDataJsonPath(String dataJsonPath) {
	this.dataJsonPath = dataJsonPath;
}
private String dataJsonPath;

}