package org.geeksoc.guts2014.randomevents;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.geeksoc.guts2014.Job;
import org.geeksoc.guts2014.JobType;
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
		System.out.println(jobTypes);
		for(char j:jobTypes.toCharArray()){
			System.out.println(j);
			for(int x = 10; x< rand.nextInt(20)+10;x++){
				Job job = new Job(JobType.values()[Integer.parseInt(Character.toString(j))-1]);
				jobQueue.add(job);
			}
		}
		
		Main.flash = method.split("!")[1] + " " + reason;
	}

}
