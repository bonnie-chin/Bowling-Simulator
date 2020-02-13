import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);
	    System.out.println("Welcome to CB Bowling");
	    System.out.print("Enter number of bowlers:");
	    int numBowlers = user_input.nextInt();
	    String names[] = new String[numBowlers];
	    user_input.nextLine(); 
	    for (int i=0;i<numBowlers; i++) {
	      System.out.println("Enter bowler " + (i+1) + ":");
	      names [i] = user_input.nextLine();
	    }
	      
	    int[][][] scores = new int[numBowlers][3][3];
	    
	    
	    
	    for (int f=0; f<3; f++) {
	      System.out.println("----------");
	      
	      //Determining which frame to output
	    	if (f==0) {
	    	  System.out.println("\nFrame 1\n");
	    	}
	    	else if (f==1) {
	    		System.out.println("\nFrame 2\n");
	    	}
	    	else if (f==2) {
	    		System.out.println("\nFrame 3\n");
	    	}
	    	
	    	//for loop for the number of players
	    	for (int p=0; p<numBowlers; p++) {
			      for (int i=0;i<2; i++) {
			        System.out.println("Enter " + names[p] + "'s score for ball " + (i+1) + ":");
			        scores[p][f][i] = user_input.nextInt();
			        if (f != 2){
			          if (scores[p][f][i] == 10) {
			            System.out.println(names[p] + " has a strike!");
			            i++;
			          }
			          else if (i==1 && (scores[p][f][0] + scores[p][f][1] == 10)) {
			            System.out.println(names[p] + " has a spare!"); 
			          }
			        }
			        else {
			        	if (i==0) {
			        		if (scores[p][f][i] == 10) {
			    	            System.out.println(names[p] +" has a strike!");
			    	            //not sure whether we should continue outputting they got a strike if they get 10s afterwards
			    	          }
			        		else if (i==1 && (scores[p][f][0] == scores[p][f][1])) {
			    	            System.out.println(names[p] +" has a spare!"); 
			    	          }
			        	}
			        	else  {
			        		if (scores[p][2][0] == 10 ||(scores[p][2][0] + scores[p][2][1]) == 10 ) {
			        			System.out.println("Enter " + names[p] + "'s score for ball 3:");
			        			scores[p][f][2] = user_input.nextInt();
			        		}
			          }
			        }
			      }
	    	}
	    }
	    
	    //SCORE CALCULATION
	    int [] bowlerScores = new int[numBowlers];
	    int winnerScore = 0;
	    String winnerName = ""; 
	    
	    for (int p=0;p<numBowlers;p++) {
	    	for (int i=0;i<3;i++) {
	  	      if (scores[p][i][0] == 10) {
	  	        if (i==0) {
	  	          if (scores[p][1][0] == 10) {
	  	            bowlerScores[p] = bowlerScores[p] + 10 + 10 + scores[p][2][0];
	  	          }
	  	          else {
	  	            bowlerScores[p] = bowlerScores[p] + 10 + scores[p][2][0] + scores[p][2][1];
	  	          }
	  	        }
	  	        else if (i==1) {
	  	            bowlerScores[p] = bowlerScores[p] + 10 + scores[p][2][0] + scores[p][2][1];
	  	        }
	  	        else {
	  	          bowlerScores[p] = bowlerScores[p] + 10 + scores[p][2][1] + scores[p][2][2];
	  	        }
	  	      }
	  	      else {
	  	        if ((scores[p][i][0] + scores[p][i][1]) == 10){
	  	          if (i!=2) {
	  	        	  bowlerScores[p] = bowlerScores[p] + 10 + scores[p][i+1][0];  
	  	          }
	  	          else {
	  	        	  bowlerScores[p] = bowlerScores[p] + 10 + scores[p][i][2];
	  	          }
	  	        }
	  	        else {
	  	            bowlerScores[p] = bowlerScores[p] + scores[p][i][0] + scores[p][i][1];
	  	        }
	  	      }
	  	    }
	    	System.out.println(names[p] + " scored " + bowlerScores[p] + " points.");
	    	
	    	if (bowlerScores[p] > winnerScore) {
	    		winnerScore = bowlerScores[p];
	    		winnerName = names[p];
	    	}
	    	else if (bowlerScores[p] == winnerScore) {
	    	  winnerName = winnerName + names[p];
	    	}
	    }
	    
	    System.out.println(winnerName + " wins!");
	}

}
