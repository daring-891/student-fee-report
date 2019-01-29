package feeReport;

import java.util.Scanner;

public class Test {


	private static Scanner input;

	public static void main(String args[]) {
		String adminId="admin";
		String adminpassword="admin";
		input = new Scanner(System.in);
		String ch;	
		String temp1,temp2;
		try {
		while(true) {
	
					System.out.print("a to enter as admin\nb to enter as Accountant\nx for exit\n");
					ch = input.next();
					
					switch(ch.charAt(0)) {
					
					case 'a' :
									
					case 'A' :
								
									System.out.println("Enter Id");
									temp1=input.next();
									System.out.println("Enter password");
									temp2=input.next();
									
									if(temp1.equals(adminId)&&temp2.equals(adminpassword)) {
									while(true) {

										System.out.print("a to add a accountant\nv to view all accountant\nd t odelete a accountant \nx for exit\n");
										ch = input.next();
										if(ch.charAt(0)=='x'||ch.charAt(0)=='X') {
											break;
										
										}
										
										else if(ch.charAt(0)=='a'||ch.charAt(0)=='A') {
											Accountant a = new Accountant();
											a.takeInput();
											AccountantDao.save(a);
										
										}
										
										else if(ch.charAt(0)=='v'||ch.charAt(0)=='V') {
											
											AccountantDao.view();
										}
										else if(ch.charAt(0)=='d'||ch.charAt(0)=='D') {
											
											System.out.println("Enter the name of accountant you wand to delete");
											temp1=input.next();
											AccountantDao.delete(temp1);
										}
									
										else {
											System.out.println("Wrong input");
										}
								
										}
									}
									else {
										
										System.out.println("Worng Credentials");
									
										
										
									}
									
									break;
						
 					case 'b' :
						
					case 'B' :
						
						System.out.println("Enter name");
						temp1=input.next();
						System.out.println("Enter password");
						temp2=input.next();
						
						if(AccountantDao.validate(temp1, temp2)) {
						while(true) {

							System.out.print("a to add a student\nv to view all student\nd to delete a student\nc to check the student with due \nU to update a student\nx to log out\n");
							ch = input.next();
							if(ch.charAt(0)=='x'||ch.charAt(0)=='X') {
								break;
							
							}
							
							else if(ch.charAt(0)=='a'||ch.charAt(0)=='A') {
								
								Student s = new Student();
								s.takeInput();
								StudentDao.save(s);
							}
							
							else if(ch.charAt(0)=='v'||ch.charAt(0)=='V') {
								
								StudentDao.view();
							}
							else if(ch.charAt(0)=='d'||ch.charAt(0)=='D') {
								int temp3;
								System.out.println("Enter the roll no of Student you wand to delete");
								temp3=input.nextInt();
								StudentDao.delete(temp3);
							
							
							}

							else if(ch.charAt(0)=='u'||ch.charAt(0)=='U') {
								System.out.println("Enter the updated result");
								Student s = new Student();
								s.takeInput();
								StudentDao.update(s);
								
							}
							
							else if(ch.charAt(0)=='c'||ch.charAt(0)=='C') {
								System.out.println("Students with Due are");
								StudentDao.due();
							}
							
							else {
								System.out.println("Wrong input");
							}
						
							}
						}
						else {
							
							System.out.println("Worng Credentials");
						
							
							
						}
						

									break;
									
					
					case 'x' :
					case 'X' :
						
						System.exit(0);
						break;
					default : 
						
								System.out.println("Wrong input");
					}
					
	
	
	
	
			}
	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
	
}
