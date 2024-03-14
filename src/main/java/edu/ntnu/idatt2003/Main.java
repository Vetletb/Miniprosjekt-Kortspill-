package edu.ntnu.idatt2003;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    AnchorPane rootNode = new AnchorPane();
    rootNode.setBackground(new Background(new BackgroundFill(Color.web("32620B"), CornerRadii.EMPTY, Insets.EMPTY)));

    Graphics graphics = new Graphics();

    DropShadow dropShadow = new DropShadow();
    dropShadow.setRadius(10.0);
    dropShadow.setOffsetX(3.0);
    dropShadow.setOffsetY(3.0);
    dropShadow.setColor(Color.web("#404040"));

    StackPane pokerPane = new StackPane();
    pokerPane.setPrefSize(800, 246);

    Label pokerLabel = graphics.createTitle("Poker", 60, "FFFFFF");
    pokerLabel.setTranslateY(-80);
    pokerPane.getChildren().add(pokerLabel);


    VBox buttons = new VBox();
    buttons.setMaxSize(141, 354);
    buttons.setMinSize(141, 354);
    buttons.setAlignment(Pos.CENTER);
    buttons.setSpacing(10);
    buttons.setTranslateY(-100);

    Button dealButton = new Button("Deal Hand");
    Button checkButton = new Button("Check Hand");

    buttons.getChildren().add(dealButton);
    buttons.getChildren().add(checkButton);


    HBox playerCards = new HBox();
    playerCards.setMaxSize(424, 354);
    playerCards.setMinSize(424, 354);

    Rectangle cardBox = graphics.createBox(424, 354, "CFCFCF");
    playerCards.getChildren().add(cardBox);


    StackPane result = new StackPane();
    result.setMaxSize(235, 354);
    result.setMinSize(235, 354);

    StackPane resultContainer = new StackPane();
    resultContainer.setMaxSize(190, 283);
    resultContainer.setMinSize(190, 283);

    Rectangle resultBox = graphics.createBox(190, 283, "CFCFCF");
    StackPane.setAlignment(resultBox, Pos.CENTER);
    resultContainer.getChildren().add(resultBox);

    result.getChildren().add(resultContainer);

    VBox results = new VBox();
    results.setMaxSize(150, 46);
    results.setMinSize(150, 46);
    results.setAlignment(Pos.CENTER);
    results.setSpacing(5);
    results.setTranslateY(-100);


    rootNode.getChildren().add(pokerPane);
    AnchorPane.setTopAnchor(pokerPane, 0.0);

    rootNode.getChildren().add(buttons);
    AnchorPane.setLeftAnchor(buttons, 0.0);
    AnchorPane.setBottomAnchor(buttons, (rootNode.getPrefHeight() - buttons.getPrefHeight()) / 2);

    rootNode.getChildren().add(playerCards);
    AnchorPane.setLeftAnchor(playerCards, buttons.getMaxWidth());
    AnchorPane.setBottomAnchor(playerCards, (rootNode.getPrefHeight() - playerCards.getPrefHeight()) / 2);

    rootNode.getChildren().add(result);
    AnchorPane.setRightAnchor(result, 0.0);
    AnchorPane.setBottomAnchor(result, (rootNode.getPrefHeight() - result.getPrefHeight()) / 2);


    Scene scene = new Scene(rootNode, 800, 600);

    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.setAlwaysOnTop(true);
    primaryStage.show();
  }

  public static void main(String[] args) {
  }
}