package jachlebowski.hw2;


public class Num_shuffles {

	//How many in() shuffles to return deck to original position?
	

	
	public void inTable() {
		System.out.println("IN TABLE:");
		for(int max_rank=1;max_rank<=20;max_rank++) {
			MyDeck d = new MyDeck(max_rank);
			int number=1;
			d.in();
			
			
			//while it's NOT in order keep shuffling
			while(!d.isInOrder()) {
				d.in();
				number++;
			}
			System.out.println(max_rank + "\t" + number);
			
		}
	}
	
	
	public void outTable() {
		System.out.println("\nOUT TABLE:");
		for(int max_rank=1;max_rank<=20;max_rank++) {
			MyDeck d = new MyDeck(max_rank);
			int number=1;
			d.out();
		
			//while it's NOT in order keep shuffling
			while(!d.isInOrder()) {
				d.out();
				number++;
			}

			System.out.println(max_rank + "\t" + number);
			
		}
	}
	
	
	
	public void numReverse() {
		int number = 0;
		MyDeck d = new MyDeck(13);
		
		while(!d.isInReverseOrder()) {
			d.in();
			number++;
		}
		System.out.println("\nNumber of in() shuffles to reverse 52-card deck: " + number);
	}
	
	
	
	
	
}
