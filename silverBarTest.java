package CreditSuisse;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import java.sql.Timestamp;
import java.time.*;

import CreditSuisse.silverBarVO;
import CreditSuisse.silverBar;

public class silverBarTest
{
	//=================================================
	public static void main(String[] args) {

		silverBar sb = new silverBar();

		// {userid,quantity,priceperkg,type}
		silverBarVO[] sb1 = {
			new silverBarVO("user1",3.5f,306.00f,"SELL"),
			new silverBarVO("user2",1.2f,310.00f,"SELL"),
			new silverBarVO("user3",1.5f,307.00f,"SELL"),
			new silverBarVO("user4",2.0f,306.00f,"SELL")
		};
		System.out.println("===========================");
		System.out.println("Test 1");
		sb.displaySummary(sb1);

		// {userid,quantity,priceperkg,type}
		silverBarVO[] sb2 = {
			new silverBarVO("user1",3.5f,306.00f,"BUY"),
			new silverBarVO("user2",1.2f,310.00f,"BUY"),
			new silverBarVO("user3",1.5f,307.00f,"BUY"),
			new silverBarVO("user4",2.0f,306.00f,"BUY")
		};
		System.out.println("===========================");
		System.out.println("Test 2");
		sb.displaySummary(sb2);

		System.out.println("===========================");
		System.out.println("Test 3");
		sb2 = null;
		sb.displaySummary(sb2);

		// {userid,quantity,priceperkg,type}
		silverBarVO[] sb3 = {
			new silverBarVO("user1",3.5f,306.00f,"BUY"),
			new silverBarVO("user2",1.2f,310.00f,"BUY"),
			new silverBarVO("user3",1.5f,307.00f,"BUY"),
			new silverBarVO("user4",2.0f,306.00f,"BUY"),		//duplicate
			new silverBarVO("user4",1.0f,306.00f,"SELL"),
			new silverBarVO("user5",1.0f,291.00f,"SELL"),
			new silverBarVO("user6",2.5f,306.00f,"SELL"),
			new silverBarVO("user4",1.0f,291.50f,"SELL"),
			new silverBarVO("user7",1.0f,299.00f,"SELL"),
			new silverBarVO("user8",1.5f,306.00f,"BUY"),		//duplicate
			new silverBarVO("user9",1.5f,299.00f,"BUY"),
			new silverBarVO("user10",1.5f,299.00f,"SELL")		//duplicate
		};
		System.out.println("===========================");
		System.out.println("Test 4");
		sb.displaySummary(sb3);
	}
}