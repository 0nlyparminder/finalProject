package com.mycompany.blackjack1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;     
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class App extends Application {

    private Deck deck = new Deck();
    private Hand dealer, player;
    private Text message = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox dealerCards = new HBox(10);
    private HBox playerCards = new HBox(10);

    private Parent createContent() {
        dealer = new Hand(dealerCards.getChildren());
        player = new Hand(playerCards.getChildren());

        Text dealerLab = new Text("Dealer:");
        dealerLab.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Text playerLab = new Text("Player:");
        playerLab.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        Pane root = new Pane();
        root.setPrefSize(1000, 600);

        Region background = new Region();
        background.setPrefSize(1000, 700);
       background.setStyle("-fx-background-color: rgba(255,255,255, 3)");

        VBox rootLayout = new VBox(5);
        rootLayout.setPadding(new Insets(10, 10, 10, 10));

        Rectangle topBG = new Rectangle(960, 450);
        topBG.setArcWidth(50);
        topBG.setArcHeight(50);
        topBG.setFill(Color.SEAGREEN);


        Rectangle bottomBG = new Rectangle(560, 130);
        bottomBG.setArcWidth(20);
        bottomBG.setArcHeight(20);
        bottomBG.setFill(Color.DARKRED);

        // LEFT
        VBox topVBox = new VBox(20);
        topVBox.setAlignment(Pos.TOP_CENTER);
        topVBox.setPadding(new Insets(5, 5, 5, 10));

        Text dealerScore = new Text("Dealer: ");
        Text playerScore = new Text("Player: ");

         HBox scoreboard = new HBox(100);
        scoreboard.getChildren().addAll(dealerScore,playerScore);
        scoreboard.setAlignment(Pos.TOP_CENTER);
        
        HBox h1 = new HBox(5);
        h1.getChildren().addAll(dealerLab,dealerCards);
        
         HBox h2 = new HBox(5);
        h2.getChildren().addAll(playerLab,playerCards);
        
        topVBox.getChildren().addAll(scoreboard, h1, message, h2);

        // RIGHT

        VBox bottomVBox = new VBox(20);
        bottomVBox.setAlignment(Pos.CENTER);

    
       
        Button Play = new Button("PLAY");
        Button Hit = new Button("HIT");
        Button Stand = new Button("STAND");

        HBox buttonsHBox = new HBox(25, Hit, Stand);
        buttonsHBox.setAlignment(Pos.CENTER);

        bottomVBox.getChildren().addAll( Play,  buttonsHBox);

        // ADD BOTH STACKS TO ROOT LAYOUT

        rootLayout.getChildren().addAll(new StackPane(topBG, topVBox), new StackPane(bottomBG, bottomVBox));
        root.getChildren().addAll(background, rootLayout);

        // BIND PROPERTIES

        Play.disableProperty().bind(playable);
        Hit.disableProperty().bind(playable.not());
        Stand.disableProperty().bind(playable.not());

        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.totalValProperty().asString()));
        dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.totalValProperty().asString()));
        
          playerScore.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
         dealerScore.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));

        player.totalValProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        dealer.totalValProperty().addListener((obs, old, newValue) -> {
            if (newValue.intValue() >= 21) {
                endGame();
            }
        });

        // INIT BUTTONS

        Play.setOnAction(event -> {
            startNewGame();
        });

        Hit.setOnAction(event -> {
            player.getCard(deck.drawCard());
        });

        Stand.setOnAction(event -> {
            while (dealer.totalValProperty().get() < 17) {
                dealer.getCard(deck.drawCard());
            }

            endGame();
        });

        return root;
    }

    private void startNewGame() {
        playable.set(true);
        message.setText("");

        deck.refill();

        dealer.reset();
        player.reset();

        dealer.getCard(deck.drawCard());
        dealer.getCard(deck.drawCard());
        player.getCard(deck.drawCard());
        player.getCard(deck.drawCard());
    }

    private void endGame() {
        playable.set(false);

        int valueofdealer = dealer.totalValProperty().get();
        int valueofplayer = player.totalValProperty().get();
        String winner = "";

        // the order of checking is important
        if (valueofdealer == 21 || valueofplayer > 21 || (valueofdealer < 21 && valueofdealer > valueofplayer)) {
            winner = "DEALER";
        }
        else if (valueofplayer == 21 || valueofdealer > 21 || valueofplayer > valueofdealer) {
            winner = "PLAYER";
        }else if(valueofdealer == valueofplayer){
            winner = "PUSH SITUATION!! NO ONE ";
        }
    message.setText(winner + " WINS");
    message.setStyle("-fx-font-size: 30px;");
    message.setFill(Color.BLACK);
     message.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
        primaryStage.setResizable(false);
        primaryStage.setTitle("THE BlackJack");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}