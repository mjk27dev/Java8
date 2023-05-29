package com.ratanit.lambda;

import java.util.Scanner;

import com.ratanit.functionalInt.Service;
import com.ratanit.functionalInt.Service2;


public class LambdaLogin {

	public static void main(String[] args) {
		Service  service = (username, password) -> {return username.equalsIgnoreCase("Ayumi") && password.equals("Blades123")?"Login Success":"Login Failed";};
      String status = service.login("ayumi", "Blades123");
      System.out.println("Your Login status is:" +status);

      Service  service1 = (username, password) -> username.equalsIgnoreCase("Ayumi") && password.equals("Blades123")?"Login Success":"Login Failed";
      String status1 = service.login("ayumi", "Blades123");
      System.out.println("Your Login status is:" +status1);
      
      //while writing the lambda expression giving the return statement is optional.

      
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the username:");
      String usename = scanner.nextLine();
      Scanner scanner2 = new Scanner(System.in);
      System.out.println("Enter the Password:");
      String pass = scanner.nextLine();
      Service  service2 = (username, password) -> username.equalsIgnoreCase(usename) && password.equals(pass)?"Login Success":"Login Failed";
      String status2 = service2.login(usename, pass);
      System.out.println("Your Login status is:" +status2);
      
      Service2 service3 = (String name, int age, String location) -> age >= 18 && location.equals("Hyderabad")?"Eligible to Vote":"Not Eligible";
  	String voteStatus = service3.voteCheck("Manoj", 30, "Hyderabad");
  	System.out.println("Your Eligiblity is:" +voteStatus);
	}

}
