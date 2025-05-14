/**
* A Deck class
* @author Jary Chen
* @verion 17.0.1
* created: Nov 26 2023
* last edited: Dec 1 2023
*/


//utilities
import java.util.ArrayList;
import java.util.Random;

class Deck {
  
  //instance varible
  //deck of cards(ln18)
  ArrayList<Card> deck = new ArrayList<Card>();

  
  //first constructor
  /**
   * sets the card array in the params into this deck
   * @param arr and Card[] an array of cards that is given by the user
   */
  public Deck(Card[] arr) {
    for(int i = 0; i < arr.length; i++) {
      this.deck.add(arr[i]);
    }
  }

  //second constructor
  /**
   * Generates a defult deck of cards if there is no array of cards given by the user. Cards will be from ace-king with a given suit(hearts, clubs, diamonds,spades) as well as a value
   */
  public Deck() {
    String[] name = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suit = {"hearts", "clubs", "diamonds", "spades"};
    int vals = 1;

    //puts all 52 cards in an orginial deck into this deck(ln42-48)
    for(int i = 0; i < name.length; i++) {
      for(int a = 0; a < suit.length; a++) {
        Card card = new Card(name[i], suit[a], vals);
        this.deck.add(card);
        vals++;
      }
    }
  }


  //methods(ln58-119)
  
  /**
   * returns the amount of this deck of cards
   * @return returns the amount of cards in the deck as a int
   */
  public int size() {
    return this.deck.size();
  }

  /**
   * draws a card from this deck from the top
   * @return returns the top card of this deck back to the user and returns null if there isn't any cards in this deck
   */
  public Card draw() {

    //checks if the size of this deck is equal to zero(ln69)
    if (this.deck.size() == 0) {
      return null;
    }
    return this.deck.remove(0);
  }

  /**
   * shuffles the the current cards in this deck in random order
   */
  public void shuffle() {
    Random random = new Random();

    //shuffles the deck(ln82-87)
    for (int i = 0; i < this.deck.size(); i++) {
      int shuffle = random.nextInt(this.deck.size());
      Card val = this.deck.get(i);
      this.deck.set(i, this.deck.get(shuffle));
      this.deck.set(shuffle, val);
    }
  }

  /**
   * reshuffles this deck of cards with new cards added in from the array of cards in the params
   * @param cards a Card[] the cards that will be added into this deck
   */
  public void reshuffle(Card[] cards) {
    Random random = new Random();

    //adds the new cards in this deck of cards(ln98-100)
    for (int a = 0; a < cards.length; a++) {
      this.deck.add(cards[a]);
    }

    //shuffles this deck(ln103-108)
    for (int i = 0; i < this.deck.size(); i++) {
      int shuffle = random.nextInt(this.deck.size());
      Card val = this.deck.get(i);
      this.deck.set(i, deck.get(shuffle));
      this.deck.set(shuffle, val);
    }
  }

  /**
   * it will add the given card in the param to this deck of cards if the card does not equal to null
   * @param card a Card with a name, suit and a value
   */
  public void addCard(Card card) {
    if (card != null) {
      this.deck.add(card);
    }
  }  
}