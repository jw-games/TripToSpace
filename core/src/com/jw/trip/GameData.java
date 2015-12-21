package com.jw.trip;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameData {
	
	public HashMap<String, List<String>>	data;
	
	public GameData() {
		
		data = new HashMap<String, List<String>>();
		
		// Screen 1
		data.put("0", r0);
		
		// Screen 2		
		data.put("0a", r01);
		data.put("0b", r01);
		data.put("0c", r01);
		
		// Screen 3
		data.put("0aa", r02a);
		data.put("0ba", r02a);
		data.put("0ca", r02a);
		data.put("0ab", r02bc);
		data.put("0ac", r02bc);
		data.put("0bb", r02bc);
		data.put("0bc", r02bc);
		data.put("0cb", r02bc);
		data.put("0cc", r02bc);
		
	}
	
	// Format for the game data is r then screen number, and after screen number some letter code for identifying pathway
	
	public static final List<String> r0 = Arrays.asList(
			"Today is your tenth birthday - the 23rd of August 2015. "
			+ "You have always loved astronauts, and wished to see a rocket launch. "
			+ "Today is your lucky day. "
			+ "Your parents are taking you to see the launch of the space shuttle Atlantis. "
			+ "They say you can bring one toy with you. What do you choose?",
			"Sword", 
			"Hammer", 
			"Laser gun");
	
	public static final List<String> r01 = Arrays.asList(
			"You arrive at the launchpad and you see your the crew boarding the space shuttle. "
			+ "You see your three favorite astronauts boarding the shuttle: "
			+ "the cranky old Buzz Legstrong, the scrappy genius Callie Ride, and the fearless leader Neil Aldrin. "
			+ "You also see Scampy Shrimpington, the world's smallest astronaut, limping along behind the rest of the crew; "
			+ "Shrimpington looks deathly ill, but is struggling along towards the shuttle to board for launch. "
			+ "You only have a chance to wave and say hi to one of your favorite astronauts. Which astronaut do you greet?",
			"Buzz Legstrong", 
			"Callie Ride", 
			"Neil Aldrin");
	
	public static final List<String> r02a = Arrays.asList(
			"Buzz Legstrong sees you waving, but he thinks you are threatening him. "
			+ "Buzz jumps over the guard rail that is blocking off the crowd, and jump kicks you in the neck. "
			+ "You fall to the ground clutching your trachyea.",
			"You are picked up and transported to the hospital in an ambulance, where you spend the next several weeks recovering."
			);
	
	public static final List<String> r02bc = Arrays.asList(
			"Your favorite astronaut smiles at your wave. "
			+ "Suddenly Scampy Shrimpington keels over and moans in pain. "
			+ "It looks like Shrimpington won't be able to go on the mission. "
			+ "Neil Alrdin calls out to the crowd, \"Is there anyone who is about 4 feet tall that is willing to go on a space mission?\"",
			"Raise your hand and holler",
			"Stay still and quiet"
			);

}
