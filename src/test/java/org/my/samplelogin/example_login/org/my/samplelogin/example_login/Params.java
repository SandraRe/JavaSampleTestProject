package org.my.samplelogin.example_login.org.my.samplelogin.example_login;

import org.openqa.selenium.By;

public class Params {

	
	//credentials and urls
	public static String testURL="http://exam.doubleoctopus.com/exam.html";
	
	
	
	//Of course, having a DB I'd store the credentials encrypted
	public static String userName="correctUserName";
	public static String password="correctpassword";
	public static String wrongPassword="wrongpassword";
	
	//titles
	public static String formSumbittedTitle="Submitted Form Data";
	public static String mainPageTitle="Modal Login Form";
	public static String userTitle="Username";
	public static String passwordTitle="Password";

		

	
	//elements
	public static By loginButton=By.xpath("/html/body/button");
	public static By usernameInput=By.name("uname");
	public static By passwordInput=By.name("psw");
	public static By signInButton=By.xpath("//*[@id=\"id01\"]/form/div[2]/button\n");
	public static By rememberMeCheckbox=By.name("remember");
	public static By cancelButton=By.className("cancelbtn");
	public static By closeButton=By.className("close");
	
	//timeOuts
	public static final int MAX_WAIT_TIME=10;

	
}
