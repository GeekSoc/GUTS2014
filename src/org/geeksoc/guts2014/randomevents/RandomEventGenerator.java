package org.geeksoc.guts2014.randomevents;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.geeksoc.guts2014.Job;
import org.geeksoc.guts2014.Main;

public class RandomEventGenerator {
	
	private static List<String> methods;
	private static List<String> reasons;

	static{
		try {
			methods = Files.readAllLines(Paths.get("res/txt/methods.txt"), Charset.defaultCharset());
			reasons = Files.readAllLines(Paths.get("res/txt/reasons.txt"), Charset.defaultCharset());
			System.out.println(methods.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void generateEvent(Queue<Job> jobQueue) {
		Random rand = new Random();
		
		String method = methods.get(rand.nextInt(methods.size()));
		String jobTypes = method.split("!")[0];
		String reason = reasons.get(rand.nextInt(reasons.size()));
		
		System.out.println(method);
		for(String j:jobTypes.split("")){
			System.out.println(j);
			for(int x = 0; x< rand.nextInt(30);x++){
				//Job job = new Job(JobType.values()[Integer.parseInt(j)]);
			}
		}
		
		Main.flash = method.split("!")[1] + " " + reason;
	}

}
