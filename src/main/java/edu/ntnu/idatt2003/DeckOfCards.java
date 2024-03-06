package edu.ntnu.idatt2003;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class DeckOfCards {

  private final List<PlayingCard> deck;
  private static final char[] suit = { 'S', 'H', 'D', 'C' };
  public DeckOfCards() {
    deck = new ArrayList<>();
    for (char s : suit) {
      for (int f = 1; f <= 13; f++) {
        deck.add(new PlayingCard(s, f));
      }
    }
  }
}
