package hu.bosslac.roulette;

import java.security.SecureRandom;
import java.util.Arrays;

import org.random.api.RandomOrgClient;

// feature1
// feature 2

public class Main {

	// master commit

	private final static String RANDOM_ORG_API_KEY = "197a9cab-b928-4c42-846f-b059b2217d5a";
	
	// Europen - true
	// American - false
	private final static boolean EUROEPEN_ROULETTE = true;
	
	public static void main(String[] args) {
		
		RandomOrgClient roc = RandomOrgClient.getRandomOrgClient(RANDOM_ORG_API_KEY);
		try {
			int[] randoms = new int[1000];
			boolean[] isRed = new boolean[randoms.length];
			
			if (EUROEPEN_ROULETTE) {
				randoms = roc.generateIntegers(randoms.length, 0, 36);
			} else {
				randoms = roc.generateIntegers(randoms.length, -1, 36);
			}
			
			SecureRandom rd = new SecureRandom();
			
			
//			for (int i = 0; i < randoms.length; i++) {
//				randoms[i] = rd.nextInt(37);
//				isRed[i] = rd.nextBoolean();
//			}
			
			
			//new Roulette63System(randoms, 5).playTheGame();
			//new Martingale(randoms).playTheGame();
			
			//new FourLinesStrategy(randoms).playTheGame();
			//new ElevenLinesStrategy(randoms).playTheGame();
			
			//new RedAndBlackPairsStrategy(randoms, isRed).playTheGame();
			new RomanoskyStrategy(randoms).playTheGame();
			
		    System.out.println(Arrays.toString(randoms));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
