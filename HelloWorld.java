package com.training.jsf.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name ="helloWorld")
@SessionScoped 
public class HelloWorld {

	private String output="New value";
  public String getMessage() {
	  return "Hello world from jsf..";
  }
public String getOutput() {
	return output;
}
public void setOutput(String output) {
	this.output = output;
}
  
}
