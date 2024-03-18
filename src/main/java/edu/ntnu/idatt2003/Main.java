package edu.ntnu.idatt2003;

import edu.ntnu.idatt2003.view.Components;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

  Components components;
  PokerManager pokerManager;

  private final static String backgroundColor = "#014f26";
  private final static String boxColor = "#CFCFCF";


  public Main() {
    components = new Components();
    pokerManager = new PokerManager();
  }

  @Override
  public void start(Stage primaryStage) {
    AnchorPane rootNode = components.createAnchorPane(backgroundColor);


    StackPane pokerPane = new StackPane();
    pokerPane.setPrefSize(800, 246);

    Label pokerLabel = components.createTitle("Poker", 60, "#FFFFFF");
    pokerLabel.setTranslateY(-80);
    pokerPane.getChildren().add(pokerLabel);


    VBox buttons = new VBox();
    buttons.setMaxSize(141, 354);
    buttons.setMinSize(141, 354);
    buttons.setAlignment(Pos.CENTER);
    buttons.setSpacing(10);
    buttons.setTranslateY(-100);

    Button dealButton = components.createButton("Deal Hand");
    Button checkButton = components.createButton("Check Hand");

    buttons.getChildren().add(dealButton);
    buttons.getChildren().add(checkButton);


    StackPane playerCardsContainer = new StackPane();
    playerCardsContainer.setMaxSize(424, 354);
    playerCardsContainer.setMinSize(424, 354);

    Rectangle cardBox = components.createBox(424, 354, boxColor);
    playerCardsContainer.getChildren().add(cardBox);

    HBox playerCards = new HBox();
    playerCards.setMaxSize(424, 354);
    playerCards.setMinSize(424, 354);
    playerCards.setSpacing(20);
    playerCardsContainer.getChildren().add(playerCards);


    StackPane result = new StackPane();
    result.setMaxSize(235, 354);
    result.setMinSize(235, 354);

    VBox resultContainer = new VBox();
    resultContainer.setMaxSize(140, 243);
    resultContainer.setMinSize(140, 243);
    resultContainer.setSpacing(10);

    Rectangle resultBox = components.createBox(190, 283, boxColor);
    result.getChildren().add(resultBox);

    result.getChildren().add(resultContainer);

    dealButton.setOnAction(e -> {
      System.out.println("Deal Hand");
      playerCards.getChildren().clear();
      List<String> hand = pokerManager.dealHand();
      for (String card : hand) {
        playerCards.getChildren().add(components.createLabel(card, 12, "#000000"));
      }
    });

    checkButton.setOnAction(e -> {
      System.out.println("Check Hand");
      resultContainer.getChildren().clear();
      Label sumOfFacesLabel = components.createLabel("Sum of faces:", 12, "#000000");
      Label sumOfFaces = components.createLabel(pokerManager.sumOfFaces(), 12, "#000000");
      Label cardsOfHeartsLabel = components.createLabel("Cards of hearts:", 12, "#000000");
      Label cardsOfHearts = components.createLabel(pokerManager.getHearts(), 12, "#000000");
      Label flushLabel = components.createLabel("Flush:", 12, "#000000");
      Label flush = components.createLabel(pokerManager.sameSuit(), 12, "#000000");
      Label queenOfSpadesLabel = components.createLabel("Queen of spades:", 12, "#000000");
      Label queenOfSpades = components.createLabel(pokerManager.queenOfSpades(), 12, "#000000");
      resultContainer.getChildren().add(sumOfFacesLabel);
      resultContainer.getChildren().add(sumOfFaces);
      resultContainer.getChildren().add(cardsOfHeartsLabel);
      resultContainer.getChildren().add(cardsOfHearts);
      resultContainer.getChildren().add(flushLabel);
      resultContainer.getChildren().add(flush);
      resultContainer.getChildren().add(queenOfSpadesLabel);
      resultContainer.getChildren().add(queenOfSpades);
    });


    rootNode.getChildren().add(pokerPane);
    AnchorPane.setTopAnchor(pokerPane, 0.0);

    rootNode.getChildren().add(buttons);
    AnchorPane.setLeftAnchor(buttons, 0.0);
    AnchorPane.setBottomAnchor(buttons, (rootNode.getPrefHeight() - buttons.getPrefHeight()) / 2);

    rootNode.getChildren().add(playerCardsContainer);
    AnchorPane.setLeftAnchor(playerCardsContainer, buttons.getMaxWidth());
    AnchorPane.setBottomAnchor(playerCardsContainer, (rootNode.getPrefHeight() - playerCardsContainer.getPrefHeight()) / 2);

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
    launch(args);
  }
}