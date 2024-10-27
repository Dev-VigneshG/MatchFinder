package Family;

import java.util.HashMap;
import java.util.Scanner;

public class MatchFinder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean stop = false;
		HashMap<String, Person> persons = new HashMap<String, Person>();
		while (!stop) {
			System.out.println("**********WELCOME TO MATCH FINDER****");
			System.out.println("Enter Your Choice");
			System.out.println("1.ADD DETAILS");
			System.out.println("2.FIND MATCH");
			System.out.println("3.EXIT");
			int choice = scanner.nextInt();
			scanner.nextLine();
			if (choice == 1) {
				System.out.println("Enter Name of The Person:");
				String name = scanner.nextLine();
				Person newPerson = new Person(name);
				System.out.println("Enter Gender of The Person:");
				String gender = scanner.nextLine();
				newPerson.setGender(gender);
				System.out.println("Enter Father Name of The Person:");
				String fatherName = scanner.nextLine();
				System.out.println("Enter Mother Name of The Person:");
				String motherName = scanner.nextLine();
				Person father;
				Person mother;
				persons.put(name,newPerson);
				if (!persons.isEmpty()&&persons.containsKey(fatherName)) {
					father = persons.get(fatherName);
					System.out.println("F T");
				} else {
					father = new Father(fatherName);
					System.out.println("F C");
					persons.put(fatherName, father);
				}
				if (!persons.isEmpty()&&persons.containsKey(motherName)) {
					mother = persons.get(motherName);
					System.out.println("M T");
				} else {
					mother = new Mother(motherName);
					persons.put(motherName, mother);
					System.out.println("M C");
				}
				newPerson.setFather(father);
				newPerson.setMother(mother);
				if (gender.equals("male")) {
					father.addSon(newPerson);
					mother.addSon(newPerson);
				} else {
					father.addDaughter(newPerson);
					mother.addDaughter(newPerson);
				}
				for (Person person : persons.values()) {
					if(!person.name.equals(name)&&person.father!=null&&person.father.name.equals(fatherName)&&person.mother.name.equals(motherName))
					{
						if(person.gender.equals("male"))
						{
							newPerson.addBrother(person);
							System.out.println("bro add");
							if(gender.equals("male"))
							{
								person.addBrother(newPerson);
							}
							else
							{
								System.out.println("sis add");
								person.addSister(newPerson);
							}
						}
						else
						{
							newPerson.addSister(person);
							if(gender.equals("male"))
							{
								person.addBrother(newPerson);
							}
							else
							{
								person.addSister(newPerson);
							}

						}
					}
				}

			}
			if (choice == 3) {
				stop = !stop;
			}

		}


		scanner.close();
	}
}
