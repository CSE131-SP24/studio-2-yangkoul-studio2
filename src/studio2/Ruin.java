package studio2;

public class Ruin {

	public static void main(String[] args) {
		int startAmount = 2;
		double winChance = 0.7;
		int winLimit = 10;
		int totalSimulations = 7;
		int lossCount = 0;
		
		for(int i=1; i<=totalSimulations; i++) {
			int today = startAmount;
			
			int compare = (int)(winChance * 100);
			int betTimes = 0;
			
			while (today > 0 && today < winLimit) {
				int rand = (int)(Math.random()*100) + 1;
				
				if (rand < compare) {
					today = today +1;
				//	System.out.println("You have won $1. You have " + startAmount);
				}else {
					today = today -1;
				//	System.out.println("You have lost $1. You have " + startAmount);
				}
				betTimes++;
			}
			
			if(today == winLimit) {
				System.out.println("Simulation " + i + ": " + betTimes + " WIN");
			}else {
				System.out.println("Simulation " + i + ": " + betTimes + " LOSE");
				lossCount++;
			}
		}
		
		double alpha = (1-winChance)/winChance;
		double expectedRuin = (Math.pow(alpha,startAmount)-Math.pow(alpha,winLimit))/(1-Math.pow(alpha,winLimit));
		
		System.out.println("Losses: " + lossCount + "Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + (double)lossCount/totalSimulations + " Expected Ruin Rate: " + expectedRuin);
	}
}
