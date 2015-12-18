package com.jw.trip;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameData {
	
	public HashMap<String, List<String>>	data;
	
	public GameData() {
		
		data = new HashMap<String, List<String>>();
		
		data.put("0", r0);
		data.put("0a", r01);
		data.put("0b", r01);
		data.put("0c", r01);
		
	}
	
	// Format for the game data is r then screen number, and after screen number some letter code for identifying pathway
	
	public static final List<String> r0 = Arrays.asList(
			"Today is your tenth birthday - 23 August 2015. Your parents are taking you to see the launch of the space shuttle Atlantis"
			+ "They say you can bring one toy with you. What do you choose?",
			"Sword", 
			"Hammer", 
			"Laser gun");
	
	public static final List<String> r01 = Arrays.asList(
			"You arrive at the launchpad and you see your the crew boarding the space shuttle. "
			+ "You only have a chance to wave and say hi to one of them. Which astronaut do you greet?",
			"Buzz Legstrong", 
			"Callie Ride", 
			"Neil Aldrin");

}
