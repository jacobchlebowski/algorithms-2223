package jachlebowski.hw3;



import algs.hw3.ShakespearePlay;

public class Q3 {

//find MOSTCOMMON (most common word in all of shakespeares plays)
//using the BST<String,Integer> data structure.
	
	public static void main(String[]args) {
	
	
	
		BST wordsInPlays = new BST();				//created bst with every play
		BST total = new BST();
		System.out.println("Loading Most Common...");
		for(int play=1;play<=38;play++) {			//iterate through all 38 plays
			ShakespearePlay sp = new ShakespearePlay(play);	//play
			
			for(String s:sp) {
				if(wordsInPlays.get(s)==null) {wordsInPlays.put(s, 1);}
				else{wordsInPlays.put(s, wordsInPlays.get(s)+1);}	//add it to BST
			}
			total.put(wordsInPlays.mostFrequent(), wordsInPlays.get(wordsInPlays.mostFrequent())+1);
		}
		System.out.println("MOSTCOMMON:  " + total.mostFrequent());
		String mc = total.mostFrequent();

	

	

		
		System.out.println("\n ");
		System.out.println("Top 5 in EACH Play");
		for(int play=1;play<=38;play++) {
			BST wordsInPlay = new BST();
			ShakespearePlay sp = new ShakespearePlay(play);
			
			for(String s:sp) {
				if(wordsInPlay.get(s)==null) {wordsInPlay.put(s, 1);}
				if(wordsInPlay.get(s)!=null){wordsInPlay.put(s, wordsInPlay.get(s)+1);}
			}
			String mostFreq1 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq1);
			
			String mostFreq2 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq2);
			
			String mostFreq3 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq3);
			
			String mostFreq4 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq4);
			
			String mostFreq5 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq5);
			
			
			System.out.println(mostFreq1 + "\t" + mostFreq2 + "\t" + mostFreq3 + "\t" + mostFreq4 + "\t" + mostFreq5 + "\t" + sp.getTitle());
			}
		
		
		
		
		
		
		System.out.println("\n ");
		System.out.println("PLAYS WITHOUT MOST COMMON IN TOP 5:");
		for(int play=1;play<=38;play++) {
			BST wordsInPlay = new BST();
			ShakespearePlay sp = new ShakespearePlay(play);
			
			for(String s:sp) {
				if(wordsInPlay.get(s)==null) {wordsInPlay.put(s, 1);}
				else{wordsInPlay.put(s, wordsInPlay.get(s)+1);}
			}
			String mostFreq1 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq1);
			
			String mostFreq2 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq2);
			
			String mostFreq3 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq3);
			
			String mostFreq4 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq4);
			
			String mostFreq5 = wordsInPlay.mostFrequent();
			wordsInPlay.delete(mostFreq5);
			
	
			if((!(mostFreq1.equals(mc)))&&(!(mostFreq2.equals(mc)))&&(!(mostFreq3.equals(mc)))&&(!(mostFreq4.equals(mc)))&&(!(mostFreq5.equals(mc)))) {   
			System.out.println(mostFreq1 + "\t" + mostFreq2 + "\t" + mostFreq3 + "\t" + mostFreq4 + "\t" + mostFreq5 + "\t" + sp.getTitle());
			}
	}

		
		
		
		System.out.println("\n\nLONGEST non-hyphenated word used in any plays...");
		String longest="";
		for(int play=1;play<=38;play++) {
			ShakespearePlay sp = new ShakespearePlay(play);
			for(String s: sp) {
				if((s.length()>=longest.length())&&(!(s.contains("-")))) {longest=s;}
			}	
		}
		System.out.println(longest);
		
		
		
		
	}

	
	

	
	
}