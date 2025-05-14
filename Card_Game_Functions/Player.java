/**
* A player class
* @author Jary Chen
* @verion 17.0.1
* created: Nov 28 2023
* last edited: Dec 1 2023
*/


//utitlty
import java.util.ArrayList;

class Player {

  //instance varibles(name of the player, age of the player and the card(s) in their hands)(ln16-18)
  String name;
  int age;
  ArrayList<Card> hand = new ArrayList<Card>();

  /**
   * assgins the values in the varibles in the params to the instance varibles
   * @param name2 a String a name that is given by the user 
   * @param age2 an int the age of the player
   * @param arr a Card[] an array of card that will be set the hand
   */
  public Player(String name2, int age2, Card[] arr) { 
    this.name = name2;
    this.age = age2;

    //adds all the elements in the array into this players hand (ln31-33)
    for (int i = 0; i < arr.length; i++) {
      this.hand.add(arr[i]);
    }
  }

  /**
   * Giving a value to the instance varibles and gives a empty arrayList when no array is provided
   * @param name2 a String the name of this player
   * @param age2 an int the age of this player
   */
  public Player(String name2, int age2) {
    this.name = name2;
    this.age = age2;
    this.hand = new ArrayList<Card>();
  }


  //methods(ln54-155)
  
  /**
   * returns the name of this user
   * @return returns the name of this player as a String
   */
  public String getName() {
    return this.name;
  }

  /**
   * returns the age of the user
   * @return returns the age of this player as a String
   */
  public int getAge() {
    return this.age;
  }

  /**
   * returns the cards in this hand back as a Card[] array
   * @return returns the cards in this hand as a Card[]
   */
  public Card[] getHand() {
    Card[] hand1 = new Card[this.hand.size()];

    //adds all elements in this hnd into a array of cards(ln74-76)
    for (int i = 0; i < this.hand.size(); i++) {
      hand1[i] = this.hand.get(i);
    }
    return hand1;
  }

  /**
   * returns the amount of cards in this hand
   * @return returns the amount of cards in this hand as a interger
   */
  public int size() {
    return this.hand.size();
  }

  /**
   * draws a card from the deck to this hand of the player
   * @param deck a Deck a deck of cards
   */
  public void draw(Deck deck) {
    Card pick = deck.draw();
    this.hand.add(pick);
  }

  /**
   * removes the specified card from discard pile and returns a boolean value if card is in the discard pile
   * @param card a Card the card
   * @param discardPile a DiscardPile discard pile of cards
   * @return returns true if card has been added in to discardPile otherwise false
   */
  public boolean discardCard(Card card, DiscardPile discardPile) {

    //checks if the card is in the hand(ln106)
    if (this.hand.contains(card)) {
      this.hand.remove(card);
      discardPile.addCard(card);
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * returns the card in this hand back into deck if the specified card exist in the hand and returns a boolean value letting us know if it does
   * @param card a Card a card
   * @param deck a Deck a deck of cards
   * @return returns true if this hand contains the card otherwise false
   */
  public boolean returnCard(Card card, Deck deck) {

    //checks if card is in the hand(ln125)
    if (this.hand.contains(card)) {
      deck.addCard(card);
      this.hand.remove(card);
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * returns information about the player including the name, age, and the card(s) they have in their hand
   * @return returns info about the player that includes the name, age and card(s) they have
   */
  @Override
  public String toString() {
    String info = this.name + ", " + this.age;
    for (int i = 0; i < this.hand.size(); i++) {

      //adds a comma after every card(ln145-147)
      if (i != this.hand.size()) {
        info = info + ", ";
      }

      //puts it together as a string(ln150-152)
      Card card = this.hand.get(i);
      String card2 = card.toString();
      info = info + card2;
    }
    return info;
  } 
}