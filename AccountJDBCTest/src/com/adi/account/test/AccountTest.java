package com.adi.account.test;

import java.util.Scanner;

import com.adi.account.dao.AccountDAOImpl;

public class AccountTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			//1. create dao instance - init phase
			AccountDAOImpl dao=new AccountDAOImpl();
			//2. accept inputs n invoke dao's method - clnt servicing phase
			System.out.println("Enter src , dest a/c nos n amount");
			System.out.println(dao.transferFunds(sc.nextInt(), 
					sc.nextInt(),sc.nextDouble()));
			
			//3. clean up dao - destroy(shut down)
			dao.cleanUp();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
