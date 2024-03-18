package edu.ntnu.idatt2003;

import java.util.List;

public class PokerManager {
  private final DeckOfCards deckOfCards;
  private DealtHand dealtHand;

  public PokerManager() {
    this.deckOfCards = new DeckOfCards();
  }

  public List<String> dealHand() {
      dealtHand =  new DealtHand(deckOfCards.dealHand(5));
      return dealtHand.getHand().stream().map(PlayingCard::getAsString).toList();
  }

  public String sameSuit() {
    return dealtHand.sameSuit()? "Yes" : "No";
  }

  public String sumOfFaces() {
    return Integer.toString(dealtHand.sumOfFaces());
  }

  public String getHearts() {
    List<String> hearts = dealtHand.getHearts();
    if (hearts == null) {
      return "No hearts";
    }
    return hearts.toString();
  }

  public String queenOfSpades() {
    return dealtHand.QueenOfSpades()? "Yes" : "No";
  }
}
