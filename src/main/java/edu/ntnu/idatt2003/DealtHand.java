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

  public int sumOfFaces() {
    return hand.stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
  }

  public List<String> getHearts() {
    return hand.stream()
        .filter(card -> card.getSuit() == 'H')
        .map(PlayingCard::getAsString)
        .toList();
  }

  public boolean QueenOfSpades() {
    return hand.stream()
        .anyMatch(card -> card.getAsString().equals("S12"));
  }
}
