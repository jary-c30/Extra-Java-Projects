/**
* A Card class
* @author Jary Chen
* @verion 17.0.1
* created: Nov 23 2023
* last edited: Dec 1 2023
*/


class Card {

  //instance varibles(name of the card, suit of the card, and value of the card)(ln8-10)
  String name;
  String suit;
  int value;g
  

  //constructor
  
  /**
   * Assigns this cards descriptions in the params into the instance varibles
   * @param name2 a String the name of this card
   * @param suit2 a String the suit/symbol type of this card
   * @param value2 a int the value of this card 
   */
  public Card(String name2, String suit2, int value2) {
    this.name = name2;
    this.suit = suit2;
    this.value = value2;
  }


  //methods(ln39-84)
  
  /**
   * returns back the name of this card
   * @return returns the name of this card as a String 
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * return back the suit/symbol of this card 
   * @return returns the suit of this card as a String
   */
  public String getSuit() {
    return this.suit;
  }
  
  /**
   * return the value of this card
   * @return returns the value of this card as a integer
   */
  public int getValue() {
    return this.value;
  }
  
  /**
   * returns this name and this suit into to one string with "of" inbetween 
   * @return returns this name and this suit but together as a string
   */
  @Override
  public String toString() {
    return this.name + " of " + this.suit;
  }

  /**
   * returns a boolean telling the user(s) if they have the same card
   * @param obj an object a card
   * @return returns true if the cards are the same and returns false if they are not
   */
  @Override
  public boolean equals(Object obj) {
    Card card = (Card) obj;
    
    //checks if two cards are equal(ln78)
    if ((card.getName().equals(this.name)) && (card.getSuit().equals(this.suit)) && (card.getValue() == this.value)) {
      return true;
    }
    else {
      return false;
    }
  }
}