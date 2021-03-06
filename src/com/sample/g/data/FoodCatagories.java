package com.sample.g.data;

import com.googlecode.objectify.annotation.Embed;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity @Embed
public class FoodCatagories extends AbstractDatastore {

	public FoodCatagories() {
	}

	@Id
	public Long id;
	
	public String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
