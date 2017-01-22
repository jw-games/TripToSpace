package com.jw.trip.utils;

import java.util.ArrayList;
import java.util.List;

public class Page {
	
	private String title;
	private String text;
	private String picture;
	private ArrayList<String> choices;
	
	
	public Page() {
		
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public List<String> getChoices() {
		return choices;
	}


	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
	

}
