package com.victorshub.coca.cocastock.Model;

public class Shop {
	private String id,name,owner,location;

	public Shop(String id, String name,String owner, String location) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Shop(){
		
	}
}
