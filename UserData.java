package com.training.jsf.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name="data")
@SessionScoped
public class UserData {
 private String usrClass;
 private String name;
 private int rollNo;
 private int age;
 private static final List<Student> studlist=new ArrayList<>(Arrays.asList(
		 new Student("rohan","cse",101,21),new Student("david","ece",103,22),
		 new Student("sai","civil",102,21),new Student("ram","eee",104,23)));
 public List<Student> getStudents(){
	 return studlist;
 }
 public void addStudent() {
	 studlist.add(new Student (name,usrClass,rollNo,age));
 }
public String getUsrClass() {
	return usrClass;
}
public void setUsrClass(String usrClass) {
	this.usrClass = usrClass;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
 
}
