package matchfinder;

import java.util.HashMap;
import java.util.Scanner;

public class MatchFinder {
	private Scanner scanner;
	private HashMap<String, Person> persons;

	public MatchFinder() {
		scanner = new Scanner(System.in);
		persons = new HashMap<String, Person>();
	}

	public void addDetails() {
		System.out.println("Enter Name of The Person:");
		String name = scanner.nextLine();
		Person newPerson;
		if (persons.containsKey(name)) {
			newPerson = persons.get(name);
		} else {
			newPerson = new Person(name);
		}
		System.out.println("Enter Gender of The Person:");
		String gender = scanner.nextLine();
		newPerson.setGender(gender);
		System.out.println("Enter Father Name of The Person:");
		String fatherName = scanner.nextLine();
		System.out.println("Enter Mother Name of The Person:");
		String motherName = scanner.nextLine();
		Person father;
		Person mother;
		persons.put(name, newPerson);
		if (!persons.isEmpty() && persons.containsKey(fatherName)) {
			father = persons.get(fatherName);
		} else {
			father = new Father(fatherName);
			persons.put(fatherName, father);
		}
		if (!persons.isEmpty() && persons.containsKey(motherName)) {
			mother = persons.get(motherName);
		} else {
			mother = new Mother(motherName);
			persons.put(motherName, mother);
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
			if (!person.name.equals(name) && person.father != null && person.father.name.equals(fatherName)
					&& person.mother.name.equals(motherName)) {
				if (person.gender.equals("male")) {
					newPerson.addBrother(person);
					if (gender.equals("male")) {
						person.addBrother(newPerson);
					} else {
						person.addSister(newPerson);

					}
				} else {
					newPerson.addSister(person);
					if (gender.equals("male")) {
						person.addBrother(newPerson);
					} else {
						person.addSister(newPerson);
					}

				}
			}
		}

	}

	public void findMatch() {

		System.out.println("Enter Your Name to Find Your Match:");
		String name = scanner.nextLine();
		Person person;
		if (!persons.containsKey(name)) {
			System.out.println("Your Name not Found in family!");

		} else {
			person = persons.get(name);
			System.out.println("Your Matches: ");
			if (person.gender.equals("male")) {
				for (Person aunty : person.father.sisters) {
					for (Person girl : aunty.daughters) {
						System.out.println(girl.name);
					}
				}
				for (Person uncle : person.mother.brothers) {
					for (Person girl : uncle.daughters) {
						System.out.println(girl.name);
					}
				}
			} else {

				for (Person aunty : person.father.sisters) {
					for (Person boy : aunty.sons) {
						System.out.println(boy.name);
					}
				}
				for (Person uncle : person.mother.brothers) {

					for (Person boy : uncle.sons) {
						System.out.println(boy.name);
					}
				}

			}
		}
	}
}
