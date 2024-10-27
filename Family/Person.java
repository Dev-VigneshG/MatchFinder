package Family;

import java.util.ArrayList;

public class Person {
	String name;
	String gender;
	Person father;
	Person mother;
	ArrayList<Person> sisters;
	ArrayList<Person> brothers;
	ArrayList<Person> sons;
	ArrayList<Person> daughters;

	public Person(String name) {
		this.name = name;
		sisters=new ArrayList<Person>();
		brothers=new ArrayList<Person>();
		sons=new ArrayList<Person>();
		daughters=new ArrayList<Person>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public void addSon(Person son) {
		sons.add(son);
	}

	public void addDaughter(Person daughter) {
		daughters.add(daughter);
	}

	public void addBrother(Person brother) {
		brothers.add(brother);
	}

	public void addSister(Person sister) {
		sisters.add(sister);
	}

}

class Father extends Person {
	
	public Father(String name) {
		super(name);
		this.gender="male";
	}
}

class Mother extends Person {
	public Mother(String name) {
		super(name);
		this.gender="female";
	}
}

class Brother extends Person {
	public Brother(String name) {
		super(name);
		this.gender="male";
	}
}

class Sister extends Person {
	public Sister(String name) {
		super(name);
		this.gender="female";
	}
}

class Son extends Person {
	public Son(String name) {
		super(name);
		this.gender="male";
	}
}

class Daughter extends Person {
	public Daughter(String name) {
		super(name);
		this.gender="female";
	}
}
