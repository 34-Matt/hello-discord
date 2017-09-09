package TestBot;

import java.util.Random;

public class EventUtil {

	private static Random rand = new Random();
	
        
        
	public static int rollDice(int dice){
		return rand.nextInt(dice) + 1;
	}
        
        public static int[] rollDice(int num, int dice){
            int[] results = new int[num+1];
            results[0] = dice;
            
            for (int i=1; i<=num; i++){ //Excludes the first one, but includes the number of rolls
                results[i] = rand.nextInt(dice) + 1;
            }
            return results;
        }

}