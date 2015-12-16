package com.jw.trip;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameData {
	
	public HashMap<String, List<String>>	data;
	
	public GameData() {
		
		data = new HashMap<String, List<String>>();
		
		data.put("0", Arrays.asList(
				"Today is your tenth birthday - 23 August 2015. Your parents are taking you to see the launch of the spaceshuttle Atlantis"
				+ "They say you can bring one thing with you. What do you choose?", 
				"A. Shovel", 
				"B. Hammer", 
				"C. Fruit snacks"));
		
		
	}

}
