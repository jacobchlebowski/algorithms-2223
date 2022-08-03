package jachlebowski.hw2;

import static org.junit.Assert.*;

import org.junit.Test;

import algs.hw2.Card;



public class Examples {

	@Test
    public void constructorTest() {
        MyDeck myDeck = new MyDeck(3);
        String output = "AC 2C 3C AD 2D 3D AH 2H 3H AS 2S 3S";

       assertEquals(myDeck.representation(), output);
       assertEquals(myDeck.size(), 12);
       assertEquals(myDeck.peekTop().toString(), "AC");
      assertEquals(myDeck.peekBottom().toString(), "3S");
       
      
      
      
      
      
   Num_shuffles num = new Num_shuffles();
    num.inTable();
     num.outTable();
    num.numReverse();
     
   // Card c = new Card(Suit.CLUBS,2);
    //System.out.println("\nReurn true: " + myDeck.match(c, 2));
     
   
//     System.out.println("AC: " + myDeck.cutInHalf().card.toString());
//     System.out.println("AH: " + myDeck.peekTop());
    

      // Deck newDeck = myDeck.copy();
       //System.out.println(newDeck.representation());

      // assertEquals(myDeck.representation(),newDeck.representation());
 
     //  assertTrue(myDeck.isInOrder());
      
     //  assertFalse(myDeck.isInReverseOrder());
       
       //myDeck.cutInHalf();
      
      
//    System.out.println("Before(OUT): " +myDeck.representation());
//       myDeck.out();
//      System.out.println("After(OUT): " +myDeck.representation());
       
      

//   System.out.println("Before(IN): " +myDeck.representation());
//   myDeck.in();
//   System.out.println("After(IN): " +myDeck.representation());
      
      
      
      
      
      
      
      
       //don't forget, size starts at first, so size is of second half of deck
      // System.out.println("First should be AH: " + myDeck.peekTop());
       
       
    }
	@Test
    public void matchTest() {
        MyDeck myDeck = new MyDeck(3);
        MyDeck myDeck2 = new MyDeck(13);

        assertTrue(myDeck.match(new Card("2S"), 11));
        assertTrue(myDeck2.match(new Card("AC"), 1));
        assertTrue(myDeck2.match(new Card("KS"), 52));
    }


}
