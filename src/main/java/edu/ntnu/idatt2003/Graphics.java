package edu.ntnu.idatt2003;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Graphics {
  private final DropShadow dropShadow;

  public Graphics() {
    dropShadow = new DropShadow();
    dropShadow.setRadius(10.0);
    dropShadow.setOffsetX(3.0);
    dropShadow.setOffsetY(3.0);
    dropShadow.setColor(Color.web("#404040"));
  }

  public Rectangle createBox(int width, int height, String color) {
    Rectangle box = new Rectangle(width, height);
    box.setFill(Color.web(color));
    box.setArcHeight(5);
    box.setArcWidth(5);
    box.setEffect(dropShadow);
    return box;
  }

  public Label createLabel(String text, int fontSize, String color) {
    Label label = new Label(text);
    label.setFont(Font.font(fontSize));
    label.setTextFill(Color.web(color));
    return label;
  }

  public Label createTitle(String text, int fontSize, String color) {
    Label label = createLabel(text, fontSize, color);
    label.setFont(Font.font(null, FontWeight.BLACK, fontSize));
    label.setEffect(dropShadow);
    return label;
  }
}
