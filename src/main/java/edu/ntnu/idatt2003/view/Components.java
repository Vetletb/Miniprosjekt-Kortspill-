package edu.ntnu.idatt2003.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Components {
  private final DropShadow dropShadow;
  private final static int borderRadius = 15;

  public Components() {
    dropShadow = new DropShadow();
    dropShadow.setRadius(10.0);
    dropShadow.setOffsetX(3.0);
    dropShadow.setOffsetY(3.0);
    dropShadow.setColor(Color.web("#404040"));
  }

  public Rectangle createBox(int width, int height, String color) {
    Rectangle box = new Rectangle(width, height);
    box.setFill(Color.web(color));
    box.setArcHeight(borderRadius);
    box.setArcWidth(borderRadius);
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

  public Button createButton(String text) {
    Button button = new Button(text);
    button.setEffect(dropShadow);
    return button;
  }

  public AnchorPane createAnchorPane(String backgroundColor) {
    AnchorPane anchorPane = new AnchorPane();
    anchorPane.setBackground(new Background(
      new BackgroundFill(Color.web(backgroundColor), CornerRadii.EMPTY, Insets.EMPTY)));
    return anchorPane;
  }
}
