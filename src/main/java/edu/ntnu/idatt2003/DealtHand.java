package edu.ntnu.idatt2003;

import java.util.List;

public class DealtHand {

  private List<PlayingCard> hand;

  public DealtHand(List<PlayingCard> hand) {
    this.hand = hand;
  }

  public List<PlayingCard> getHand() {
    return hand;
  }

  public boolean sameSuit() {
    char firstSuit = hand.get(0).getSuit();
    return hand.stream().allMatch(card -> card.getSuit() == firstSuit);
  }
}
