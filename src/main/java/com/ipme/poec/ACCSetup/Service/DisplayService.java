package com.ipme.poec.ACCSetup.Service;

import org.springframework.stereotype.Service;

@Service
public class DisplayService {


	
	public void displayDisconnectHome() {
		System.out.println("+---------------------------------------+");
		System.out.println("|          Welcome to ACCsetup          |");
		System.out.println("+---------------------------------------+");
		System.out.println("|                                       |");
		System.out.println("|         - 'connect' for sign -        |");
		System.out.println("+---------------------------------------+");
	}
	
	public void displaySignIn() {
		System.out.println("+---------------------------------------+");
		System.out.println("|               SIGN IN                 |");
		System.out.println("+---------------------------------------+");
		System.out.println("|                                       |");
		System.out.println("|  USER NAME                            |");
		System.out.println("|  _______________                      |");
		System.out.println("|                                       |");
		System.out.println("|  PASSWORD                             |");
		System.out.println("|  _______________                      |");
		System.out.println("|                                       |");
		System.out.println("|         - 'in' for enter -            |");
		System.out.println("|     - 'up' create new account -       |");
		System.out.println("|       - or 'quit' for close -         |");
		System.out.println("+---------------------------------------+");
	}
	
	public void displaySignUp() {
		System.out.println("+---------------------------------------+");
		System.out.println("|               SIGN UP                 |");
		System.out.println("+---------------------------------------+");
		System.out.println("|                                       |");
		System.out.println("|  EMAIL                                |");
		System.out.println("|  _______________                      |");
		System.out.println("|                                       |");
		System.out.println("|  USER NAME                            |");
		System.out.println("|  _______________                      |");
		System.out.println("|                                       |");
		System.out.println("|  PASSWORD                             |");
		System.out.println("|  _______________                      |");
		System.out.println("|                                       |");
		System.out.println("+---------------------------------------+");
	}
	
	public void displayHomeMenu() {
		System.out.println("+---------------------------------------+");
		System.out.println("|               HOME MENU               |");
		System.out.println("+---------------------------------------+");
		System.out.println("|  1) ACCOUNT                           |");
		System.out.println("|  2) LOGOUT                            |");
		System.out.println("|  3) SESSION LIST                      |");
		System.out.println("|  4) CREATE A NEW SESSION              |");
		System.out.println("|                                       |");
		System.out.println("|         - Make your choise -          |");
		System.out.println("|       - or 'quit' for close -         |");
		System.out.println("+---------------------------------------+");
	}
	
	
	
	
}
