package emailapp;

import java.util.Scanner;

public class Email {
private String firstName;
private String lastName;
private String password;
private String department;
private String email;
private int mailboxCapacity=500;
private int defaultPasswordLength=8;
private String alternateEmail;
private String companySuffix = "ampltd.com";

//Constructor to receive the firstname and lastname
public Email(String firstName,String lastName) {
	this.firstName=firstName;
	this.lastName=lastName;
	//System.out.println("EMAIL CREATED: "+this.firstName+" "+this.lastName);
	
	//call a method for asking department. Return the department
	this.department=setDepartment();
	//System.out.println("Department: "+ this.department);
	
	//call a method that returns random password
    this.password = randomPassword(defaultPasswordLength);
    System.out.println("Your Password is: "+this.password);
    
    //combine elements to generate email
    email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@" + department.toLowerCase() +"."+ companySuffix;
    //System.out.println("Your Email is: " +email);
}
//Ask for the Department
private String setDepartment() {
	System.out.print("New Employee: "+ firstName +".Department\n1 for Sales\n2 for Developement\n3 for Accounting\n0 for none\nEnter Department Code: ");
	Scanner in=new Scanner(System.in);
	int depChoice = in.nextInt();
	if(depChoice == 1) {
		return "Sales";
		}
	else if(depChoice == 2){
		return "Developement";
		}
	else if(depChoice == 3){
		return "Accounts";
		}
	else {
		return "";
	}
	
}

//Generate the Random Password
private String randomPassword(int length) {
	String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
	char[] password = new char[length];
	for (int i=0;i<length;i++) {
		int rand = (int)(Math.random() * passwordSet.length());
		password[i] =passwordSet.charAt(rand);
	}
	return new String(password);
	
}

//Set the mail box capacity
public void setMailboxCapacity(int capacity) {
	this.mailboxCapacity = capacity;
}
//Set the alternate email
public void setAlternateEmail(String altEmail) {
	this.alternateEmail = altEmail;
}
//Change the 
public void changePassword(String password) {
	this.password = password;
}
public int getMailboxCapacity() {
	return mailboxCapacity;
}
public String getAlternateEmail() {
	return alternateEmail;
}
public String getPassword() {
	return password;
}
public String showInfo() {
	return "DISPLAY NAME: " + firstName.toUpperCase() + " " + lastName.toUpperCase() +
			"\nCOMPANY EMAIL: " + email +
			"\nMAILBOX CAPACITY: " + mailboxCapacity + "gb";
}

}
