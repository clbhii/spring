package com.cl.spring.placeholder;

public class Actor implements Artist {
	private String name;
	
	
	public void act() {
		System.out.println(name+":act");
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
}
