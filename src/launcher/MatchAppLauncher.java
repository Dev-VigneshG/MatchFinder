package launcher;

import java.util.Scanner;

import matchfinder.MatchFinder;

public class MatchAppLauncher {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MatchFinder matchFinder=new MatchFinder();
		boolean stop = false;
		while (!stop) {
			System.out.println("**********WELCOME TO MATCH FINDER****");
			System.out.println("Enter Your Choice");
			System.out.println("1.ADD DETAILS");
			System.out.println("2.FIND MATCH");
			System.out.println("3.EXIT");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == 1) {
				matchFinder.addDetails();
         
			}
			else if(choice==2)
			{
				matchFinder.findMatch();
			}
			else if (choice == 3) {
				stop = !stop;
			}

		}

		scanner.close();
	}
}
