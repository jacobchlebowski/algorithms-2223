package jachlebowski.hw2;

import algs.hw2.Card;
import algs.hw2.Deck;
import algs.hw2.Node;
import algs.hw2.Suit;

/**
 * COPY THIS CLASS into your development area and complete it.
 * @author Home
 *
 */
public class MyDeck extends Deck {
	int x = 0;
	/**
	 * Ensure that no one OUTSIDE of this class invokes the no-argument constructor. You will find
	 * it useful to have this constructor within the copy() method since it must return an accurate
	 * copy of the current Deck, and it will first need to construct an "empty" MyDeck object
	 * without using the MyDeck(int max_rank) constructor.
	 * 
	 */
	protected MyDeck() {
		// You do not need to modify this method. This constructor exists to ensure that 
		// within this class, you can construct an empty MyDeck whose first and last are null.
	}
	
	/** 
	 * Construct a playing deck with {max_rank} cards in specific order.
	 * 
	 * Once done, the linked list of card Nodes must represent a deck that looks like the following (if 
	 * {max_rank} were 3). The suites are ordered Club < Diamond < Hearts < Spades.
	 * 
	 * AC -> 2C -> 3C -> AD -> 2D -> 3D -> AH -> 2D -> 3H -> AS -> 2S -> 3S->null
	 * 
	 * Note your deck will have 4*{max_rank} cards.
	 * 
	 * Performance must be O(N) where N is max_rank.
	 */
	public MyDeck(int max_rank) {
			
		   Suit[] suitValues = new Suit[] {Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS};
			
			for(Suit s: suitValues) {
		     for(int i=max_rank;i>=1; i--) {
			  
		    
			  Card card = new Card(s,i);
			   x++;
			  Node temp = new Node(card,first);
			  first = temp; 
			   
			  if(i==max_rank&&s.equals(Suit.SPADES)) {
				  last = temp;
			  }
		   }
		}	
	}


	


	@Override
	public Card peekTop() {
		return first.card;
	}
	
	

	@Override
	public Card peekBottom() {
		return last.card;
	}
	
	
	
	
	@Override
	public boolean match(Card c, int n) {
		Node temp = first;
		boolean match = false;
		
		for(int i=1;i<=this.size();i++) {
			if(i==n&&temp.card.equals(c)) {
					match=true;
			}
			temp=temp.next;
		}
		return match;
	}
	

	
	@Override
	public Deck copy() {
		MyDeck d = new MyDeck();
		for(Node temp = first; temp!=null;temp=temp.next) {
			Node n = new Node(temp.card);
					if(d.first==null) {
						d.first=n;
					}
					else {
						d.last.next=n;
					}
			d.last=n;
			d.x++;
		}
		return d;
	}
	
	
	
	
	
	

	
	@Override
	public int size() {
		return x;
	}

	
	
	
	@Override
	protected Node cutInHalf() {
		Node n1 =first;
        Node n2 =first;
        String firstHalfRep="";

        while(n1!=null) {
            //advance n2 twice as fast
            n2=n2.next;

            firstHalfRep=firstHalfRep + " " + n1.card.toString();

            if(n2==null||n2.next==null) {
                this.x=x/2;
                //reached the end
                //n2=n1.next;
                Node sH = n1.next;
                n1.next=null;//next is null
                Node out = first;
                first = sH;

                return out;
            }

            n1=n1.next;
            n2=n2.next;

        }
        return null;
	}

	
	
	
	

	
	@Override
	public void out() {
		Node firstHalfFirst=this.cutInHalf(); //first in second half
		Node secondHalfFirst=first; //second in first half
		
		Node firstNext = null;//next in first half
		Node secondNext = null; //next in second half
		
		
		//start with firstNext and secondNext = null;??????????
		
		while(firstHalfFirst!=null&&secondHalfFirst!=null) {
		
			
			if(firstNext==null&&secondNext==null) {
				first=firstHalfFirst;
			}
			
			//next nodes
			firstNext=firstHalfFirst.next;
			secondNext=secondHalfFirst.next;
			
			//alternating
			secondHalfFirst.next=firstNext;
			firstHalfFirst.next=secondHalfFirst;
			
		    //set next nodes
			firstHalfFirst=firstNext;
			secondHalfFirst=secondNext;
			
			
		}
		x=x*2;
	}
		

	

	
	
	
	
	@Override
	public void in() {
		Node secondHalfFirst=this.cutInHalf(); //first in second half
		Node firstHalfFirst=first; //first in first half
		
		
		Node firstNext = null;//next in first half
		Node secondNext = null; //next in second half
		
		
		//start with firstNext and secondNext = null;??????????
		
		while(firstHalfFirst!=null&&secondHalfFirst!=null) {
		
			
			if(firstNext==null&&secondNext==null) {
				first=firstHalfFirst;
			}
			
			//next nodes
			firstNext=firstHalfFirst.next;
			secondNext=secondHalfFirst.next;
			
			//alternating
			secondHalfFirst.next=firstNext;
			firstHalfFirst.next=secondHalfFirst;
			
		    //set next nodes
			firstHalfFirst=firstNext;
			secondHalfFirst=secondNext;
			
			
		}
		x=x*2;
	}


	
	
	
	
	
	
	
	
	@Override
	public String representation() {
		String rep = "";
		Node temp = first;
		rep=temp.card.toString();
		temp=temp.next;
		while(temp.next!=null) {
			
			rep=rep + " " + temp.card.toString();
					
			temp=temp.next;
		}
		if(temp.next==null) {
			rep=rep+ " " + temp.card.toString();
		}
		//System.out.println(rep);
		return rep;
	}
	
	
	
	
	
	@Override
	public boolean isInOrder() {
		Suit[] suits = new Suit[] {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
		//node to the left
		Node leftNode = first;
		
		//for each Suit i in suits
		for(Suit s: suits) {
			//for each j (num_card)
			for(int j=1;j<=(this.size()/4);j++) {
				
				//if leftNode is not equal to correct suit return false
				if(leftNode.card.suit !=s) {
					return false;
				}
				//if leftNode is not equal to correct num return false
				if(leftNode.card.rank !=j) {
					return false;
				}
				leftNode=leftNode.next;
			}
		}
		//return true otherwise
	 return true;
	}
	
	
	

	@Override
	public boolean isInReverseOrder() {
		Suit[] suits = new Suit[] {Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS};
		//node to the left
		Node leftNode = first;
		
		//for each Suit i in suits
		for(Suit s: suits) {
			//for each j (num_card)
			
			//GO BACKWARDS THIS TIME CHECKING EACH J
			for(int j=(this.size()/4);j>=1;j--) {
				//if leftNode is not equal to correct suit return false
				if(leftNode.card.suit !=s) {
					return false;
				}
				//if leftNode is not equal to correct num return false
				if(leftNode.card.rank !=j) {
					return false;
				}
				leftNode=leftNode.next;
			}
		}
		//return true otherwise
	 return true;
	}
	
	

	
	
}
