package hu.bme.mit.yakindu.analysis.workhere;

import java.io.IOException;
import java.util.Scanner;

import hu.bme.mit.yakindu.analysis.RuntimeService;
import hu.bme.mit.yakindu.analysis.TimerService;
import hu.bme.mit.yakindu.analysis.example.ExampleStatemachine;
import hu.bme.mit.yakindu.analysis.example.IExampleStatemachine;



public class RunStatechart {
	
	public static void main(String[] args) throws IOException {
		ExampleStatemachine s = new ExampleStatemachine();
		s.setTimer(new TimerService());
		RuntimeService.getInstance().registerStatemachine(s, 200);
	
		s.init();
		s.enter();
		
		s.runCycle();
		print(s);
		
		Scanner sc; 
		while(true) {
			sc = new Scanner(System.in);
			String input=sc.nextLine();
			
			if(input.equals("start")) {
				s.raiseStart();
				s.runCycle();
				print(s);
			}
			
			if(input.equals("white")) {
				s.raiseWhite();
				s.runCycle();
				print(s);
			}
			
			if(input.equals("black")) {
				s.raiseBlack();
				s.runCycle();
				print(s);
			}
			
			if(input.equals("exit")) {
				print(s);
				System.exit(0);
			}
		}
		
		
		
		
	}

	public static void print(IExampleStatemachine s) {
		System.out.println("W = " + s.getSCInterface().getWhiteTime());
		System.out.println("B = " + s.getSCInterface().getBlackTime());
	}
}
