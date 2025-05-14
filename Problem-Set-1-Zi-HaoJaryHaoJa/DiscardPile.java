/**
* A DiscardPile class
* @author Jary Chen
* @verion 17.0.1
* created: Nov 27 2023
* last edited: Dec 1 2023
*/


//utility
import java.util.ArrayList;

class DiscardPile {
  
  //instance varible
  //discard pile(ln17)
  ArrayList<Card> discard = new ArrayList<Card>();

  //constructor 1
  
  /**
   * adds the array of cards in the params given by the user to this discard ArrayList
   * @param arr a Card[] the array of cards that is given
   */
  public DiscardPile(Card[] arr) {
    for(int i = 0; i < arr.length; i++) {
      this.discard.add(arr[i]);
    }
  }

  //constructor 2
  
  /**
   * sets the deck so if there isnt any params it will set it as a empty ArrayList
   */
  public DiscardPile() {
    this.discard = new ArrayList<Card>();
  }

  //methods(ln46-121)

  /**
   * returns this discard pile in an array
   * @return returns this dicard pile as a Card[]
   */
  public Card[] getDiscardPile() {
    Card[] arr = new Card[this.discard.size()];

    //puts all the elements in this discard pile(ln50-52)
    for(int i = 0; i < this.discard.size(); i++) {
      arr[i] = this.discard.get(i);
    }
    return arr;
  }

  /**
   * returns the size or the amount of cards in this discard pile
   * @return returns the amount of cards that is in this discard pile as a int
   */
  public int size() {
    return this.discard.size();
  }

  /**
   * adds a card to this discardPile
   * @param card a Card it contains the name suit and value and gets added into this discard pile
   */
  public void addCard(Card card) {
    this.discard.add(card);
  }

  /**
   * removes the card from this discard pile if it is in it
   * @param card a Card it has a name, suit and value;
   * @return returns the cards that has been removed from this discard pile and if the card is not in this discard pile it will return null
   */
  public Card removeCard(Card card) {

    //goes through discard pile to see if card is found(ln80-88)
    for (int i = 0; i < this.discard.size(); i++) {
      Card card2 = this.discard.get(i);

      //check if current index is equal to the card so it can remove it(ln84-87)
      if (card2.equals(card)) {
        this.discard.remove(i);
        return card2;
      }
    }
    return null;
  }

  /**
   * returns the cards in this discard pile as an array and removes all the cards in this discard ArrayList
   * @return returns the cards in the discard pile as an array
   */
  public Card[] returnCards() {
    Card[] arr = new Card[this.discard.size()];
    arr = getDiscardPile();
    this.discard.clear();
    return arr;
  }

  /**
   * returns this discard pile as a String with a specific format for example("Ace of hearts, Queen of diamonds, King of Spades")
   * @return returns all the cards in this discard pile as a String
   */
  @Override
  public String toString() {
    String discardCardPile = "";
    
    //gets every card from this discard pile(ln112-119)
    for(int i = 0; i < this.discard.size(); i++) {
      discardCardPile = discardCardPile + this.discard.get(i);

      //puts a comma everytime there is another card after the other(ln116-118)
      if (i != this.discard.size() - 1) { 
      discardCardPile = discardCardPile + ", ";
      }  
    }
    return discardCardPile;
  }
}