package application;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Schehat
 * configuration of the first level in the game
 */
public class Level {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
    private static HBox hboxTop = new HBox();
    private static HBox hboxBottom = new HBox();
    private static Player player = new Player("neo");
    private static Image iBg = new Image("background.gif");
    private static ImageView iVBg = new ImageView(iBg);
    private static Image iMorpheus = new Image("morpheus_small.png");
    private static ImageView iVMorpheus = new ImageView(iMorpheus);
    private static Image iInstructions = new Image("instructions.png");
    private static ImageView iVInstructions = new ImageView(iInstructions);
    
    private static Media mPunch = new Media(new File("C:\\Users\\Schehat\\university\\prog_proj3\\src\\punch.mp3").toURI().toString());
    private static MediaPlayer mPPunch = new MediaPlayer(mPunch);
    private static Media mCollect = new Media(new File("C:\\Users\\Schehat\\university\\prog_proj3\\src\\collect.mp3").toURI().toString());
    private static MediaPlayer mPCollect = new MediaPlayer(mCollect);
    private static Media mButtonClicked = new Media(new File("C:\\Users\\Schehat\\university\\prog_proj3\\src\\buttonClicked.mp3").toURI().toString());
    private static MediaPlayer mPButtonClicked = new MediaPlayer(mButtonClicked);
    private static Media mSuccess = new Media(new File("C:\\Users\\Schehat\\university\\prog_proj3\\src\\success.mp3").toURI().toString());
    private static MediaPlayer mPSuccess = new MediaPlayer(mSuccess);
    
    private static int deathCounter = 0;
    private static Label lblDeathCounter = new Label("DEATH COUNTER:\n" + deathCounter);
    private static Button btnBack= new Button(); 
    private static Button btnLevel1 = new Button();
    private static Button btnLevel2 = new Button();     
    private static Button btnLevel3 = new Button();  
    private static Button btnLevel4 = new Button();  
    private static Button btnLevel5 = new Button();  
    private static Button btnLevel6 = new Button();  
    
    private static int btnPrefWidth = 100;
    private static int btnPrefHeight = 35;
    private static String btnTextLevel = "LEVEL";
    private static String btnBackYellow = "#E9DD25";
    private static String btnHexRed = "#C75A41";
    private static String btnHexBlue = "#415FC7";
    private static String btnHexGreen = "#47D92B";
    private static String btnBorderWidth = "2px";
    private static String btnBorderColor = "#000000"; 
    private static String btnFontSize = "20px";
    private static String btnBorderRadius = "6px";
    
    private static int currentLevel = 1;
    private static int maxLevel = 1;  // to track the highest level the player can play
    private static String rectHexWhite = "F3F5F6";
    private static String rectHexRed = "C75A41";
    private static String rectHexBlue = "415FC7";
    
    private static boolean leftKeyPressed = false;
    private static boolean rightKeyPressed = false;
    private static boolean upKeyPressed = false;
    private static boolean downKeyPressed = false;
    
    public static boolean invincible = false;  // allow player to be invincible
    public static boolean reversedControls = false; // allow reversed controls
    
    /**
     * create level layout
     */
    public static void setLayout() {        
        root.getChildren().clear();
        hboxTop.getChildren().clear();
        hboxBottom.getChildren().clear();
        
        iVBg.setX(0.0);
        iVBg.setY(0.0);
        
        Level.setBtn(btnBack, "BACK", btnBackYellow);
        Level.setBtn(btnLevel1, btnTextLevel + " 1", btnHexGreen);
        Level.setBtn(btnLevel2, btnTextLevel + " 2", btnHexRed);
        Level.setBtn(btnLevel3, btnTextLevel + " 3", btnHexRed);
        Level.setBtn(btnLevel4, btnTextLevel + " 4", btnHexRed);
        Level.setBtn(btnLevel5, btnTextLevel + " 5", btnHexRed);
        Level.setBtn(btnLevel6, btnTextLevel + " 6", btnHexRed);
        
        lblDeathCounter.setFont(new Font("Arial", 18));
        // to not wrap text with ... sign
        lblDeathCounter.setMinWidth(170);
        lblDeathCounter.setTextFill(Color.WHITE);
        hboxTop.getChildren().addAll(iVMorpheus, iVInstructions, lblDeathCounter);
        hboxTop.setSpacing(10.0);
        hboxTop.setPadding(new Insets(30));
        hboxTop.setAlignment(Pos.CENTER);
        
        hboxBottom.getChildren().addAll(btnBack, btnLevel1, btnLevel2, btnLevel3, 
                                            btnLevel4, btnLevel5, btnLevel6);
        hboxBottom.setSpacing(10.0);
        hboxBottom.setPadding(new Insets(30));
        hboxBottom.setAlignment(Pos.CENTER);
              
        root.getChildren().addAll(iVBg, GameLoopManager.getCanvas(), player.getImageView());
        root.setTop(hboxTop);
        root.setBottom(hboxBottom);
        
        GameLoopManager.gameLoopManager();
    }
    
    /**
     * set properties of buttons & css styling
     * @param btn
     * @param text
     * @param bgColor
     */
    public static void setBtn(Button btn, String text, String bgColor) {
        btn.setText(text);
        btn.setMaxWidth(btnPrefWidth);
        btn.setMaxHeight(btnPrefHeight);
      
        btn.setStyle("-fx-border-width: " + btnBorderWidth + "; "
                  + "-fx-border-color: " + btnBorderColor + "; "
                  + "-fx-font-size: " + btnFontSize + "; "
                  + "-fx-background-color: " + bgColor + "; "
                  + "-fx-border-radius: " + btnBorderRadius + ";");
    }
    
    /**
     * set up all events in the first level
     */
    public static void setEvents() {
        scene.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.A)) {
                if (reversedControls) {
                    rightKeyPressed = true;
                } else {
                    leftKeyPressed = true; 
                }
            }
            if (e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D))   {
                if (reversedControls) {
                    leftKeyPressed = true;
                } else {
                    rightKeyPressed = true; 
                }
            }
            if (e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {
                if (reversedControls) {
                    downKeyPressed = true;
                } else {
                    upKeyPressed = true; 
                }
            }
            if (e.getCode().equals(KeyCode.DOWN) || e.getCode().equals(KeyCode.S)) {
                if (reversedControls) {
                    upKeyPressed = true;
                } else {
                    downKeyPressed = true; 
                }
            }
            
            // Mainly for debugging purposes skipping levels
            if (e.getCode().equals(KeyCode.N)) {
                maxLevel = 6;
                clearRoot();
                GameLoopManager.gameLoopManager();
            }
            
            // player gets invincible be pressing i key
            if (e.getCode().equals(KeyCode.I)) {
                invincible = !invincible;
            }
            
            // player gets reversed controls be pressing r key
            if (e.getCode().equals(KeyCode.R)) {
                reversedControls = !reversedControls;
            }
        });
        
        scene.setOnKeyReleased(e -> {
            if (e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.A)) {
                if (reversedControls) {
                    rightKeyPressed = false;
                } else {
                    leftKeyPressed = false; 
                }
            }
            if (e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D))   {
                if (reversedControls) {
                    leftKeyPressed = false;
                } else {
                    rightKeyPressed = false; 
                }
            }
            if (e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {
                if (reversedControls) {
                    downKeyPressed = false;
                } else {
                    upKeyPressed = false; 
                }
            }
            if (e.getCode().equals(KeyCode.DOWN) || e.getCode().equals(KeyCode.S)) {
                if (reversedControls) {
                    upKeyPressed = false;
                } else {
                    downKeyPressed = false; 
                }
            }
        });
        
        btnBack.setOnMouseEntered(e -> scene.setCursor(Cursor.HAND));
        btnBack.setOnMouseExited(e -> scene.setCursor(Cursor.DEFAULT));
        btnBack.setOnAction(e -> {
            mPButtonClicked.play();
            mPButtonClicked.seek(Duration.seconds(0.0));
            GameLoopManager.stopAllTimelines();
            StartScene.setLayout();
            stage.setScene(StartScene.getScene());
        });
        
        Level.setButtonEvents(btnLevel1, 1);
        Level.setButtonEvents(btnLevel2, 2);
        Level.setButtonEvents(btnLevel3, 3);
        Level.setButtonEvents(btnLevel4, 4);
        Level.setButtonEvents(btnLevel5, 5);
        Level.setButtonEvents(btnLevel6, 6);
    }
    
    /**
     * set events for buttons
     * @param btn
     * @param level
     */
    public static void setButtonEvents(Button btn, int level) {
        btn.setOnAction(e -> {
            mPButtonClicked.play();
            mPButtonClicked.seek(Duration.seconds(0.0));
            
            Level.setBtn(btn, btn.getText(), btnHexGreen);
            
            currentLevel = level;
            
            // to reset Layout & remove enemies from previous level
            clearRoot();
            
            // change green colored button to blue
            if (currentLevel == 1) {
                Level.setBtn(btnLevel1, btnLevel1.getText(), btnHexBlue);
            } else if (currentLevel == 2) {
                Level.setBtn(btnLevel2, btnLevel2.getText(), btnHexBlue);
            } else if (currentLevel == 3) {
                Level.setBtn(btnLevel3, btnLevel3.getText(), btnHexBlue);
            } else if (currentLevel == 4) {
                Level.setBtn(btnLevel4, btnLevel4.getText(), btnHexBlue);
            } else if (currentLevel == 5) {
                Level.setBtn(btnLevel5, btnLevel5.getText(), btnHexBlue);
            } else if (currentLevel == 6) {
                Level.setBtn(btnLevel6, btnLevel6.getText(), btnHexBlue);
            }
            
            // if green button clicked again then it will turn blue
            // thats why after setting new level state need to 
            // turn the button to green color again
            if (currentLevel == 1) {
                Level.setBtn(btnLevel1, btnLevel1.getText(), btnHexGreen);
            } else if (currentLevel == 2) {
                Level.setBtn(btnLevel2, btnLevel2.getText(), btnHexGreen);
            } else if (currentLevel == 3) {
                Level.setBtn(btnLevel3, btnLevel3.getText(), btnHexGreen);
            } else if (currentLevel == 4) {
                Level.setBtn(btnLevel4, btnLevel4.getText(), btnHexGreen);
            } else if (currentLevel == 5) {
                Level.setBtn(btnLevel5, btnLevel5.getText(), btnHexGreen);
            } else if (currentLevel == 6) {
                Level.setBtn(btnLevel6, btnLevel6.getText(), btnHexGreen);
            }
            
            deathCounter = 0;
            lblDeathCounter.setText("DEATH COUNTER:\n" + deathCounter);
            
            GameLoopManager.gameLoopManager();
        });
        
        btn.setOnMouseEntered(e -> {
            // this if statement at the end not necessary due to 
            // only buttons which are not disabled allow events 
            if (!btn.isDisabled()) {
                scene.setCursor(Cursor.HAND);
            }
        });
        
        btn.setOnMouseExited(e -> {
            if (!btn.isDisabled()) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });
    }
    
    /**
     * 
     * @return scene of Level
     */
    public static Scene getScene() {
        return Level.scene;
    }
    
    /**
     * to customize scene need current stage
     * @param stage
     */
    public static void setStage(Stage stage) {
        Level.stage = stage;
    }
    
    /**
     * if keys pressed move player according to the pressed key
     */
    public static void checkKeysPressed() {
        if (leftKeyPressed) Controller.moveLeft(player);
        if (rightKeyPressed) Controller.moveRight(player);
        if (upKeyPressed) Controller.moveUp(player);
        if (downKeyPressed) Controller.moveDown(player);
    }
    
    /**
     * 
     * @return btnLevel2
     */
    public static Button getBtnLevel2() {
        return btnLevel2;
    }
    
    /**
     * 
     * @return btnLevel3
     */
    public static Button getBtnLevel3() {
        return btnLevel3;
    }
    
    /**
     * 
     * @return btnLevel4
     */
    public static Button getBtnLevel4() {
        return btnLevel4;
    }
    
    /**
     * 
     * @return btnLevel5
     */
    public static Button getBtnLevel5() {
        return btnLevel5;
    }
    
    /**
     * 
     * @return btnLevel6
     */
    public static Button getBtnLevel6() {
        return btnLevel6;
    }
    
    /**
     * 
     * @return maxLevel
     */
    public static int getMaxLevel() {
        return maxLevel;
    }
    
    /**
     * 
     * @return currentLevel
     */
    public static int getCurrentLevel() {
        return currentLevel;
    }
    
    /**
     * 
     * @return player
     */
    public static Player getPlayer() {
        return player;
    }
    
    /**
     * 
     * @return rectHexBlue
     */
    public static String getRectHexBlue() {
        return rectHexBlue;
    }
    
    /**
     * 
     * @return rectHexWhite
     */
    public static String getRectHexWhite() {
        return rectHexWhite;
    }
    
    /**
     * 
     * @return rectHexRed
     */
    public static String getRectHexRed() {
        return rectHexRed;
    }
    
    /**
     * 
     * @return btnHexBlue
     */
    public static String getBtnHexBlue() {
        return btnHexBlue;
    }
    
    /**
     * 
     * @return btnHexGreen
     */
    public static String getBtnHexGreen() {
        return btnHexGreen;
    }
    
    /**
     * 
     * @return btnHexRed
     */
    public static String getBtnHexRed() {
        return btnHexRed;
    }
    
    /**
     * 
     * @return leftKeyPressed
     */
    public static boolean getLeftKeyPressed() {
        return leftKeyPressed;
    }
    
    /**
     * 
     * @return rightKeyPressed
     */
    public static boolean getRightKeyPressed() {
        return rightKeyPressed;
    }
    
    /**
     * 
     * @return upKeyPressed
     */
    public static boolean getUpKeyPressed() {
        return upKeyPressed;
    }
    
    /**
     * 
     * @return downKeyPressed
     */
    public static boolean getDownKeyPressed() {
        return downKeyPressed;
    }
    
    /**
     * set maxLevel
     * @param max
     */
    public static void setMaxLevel(int max) {
        maxLevel = max;
    }
    
    /**
     * 
     * @return root BorderPane which the main node in the level
     */
    public static BorderPane getRoot() {
        return root;
    }
    
    /**
     * reset root to avoid problems when switching between scenes
     */
    public static void clearRoot() {
        root.getChildren().clear();
        root.getChildren().addAll(iVBg, GameLoopManager.getCanvas(), player.getImageView());
        root.setTop(hboxTop);
        root.setBottom(hboxBottom);
    }
    
    
    /**
     * increment death counter & updates the label
     * @return deathCounter 
     */
    public static void incrementDeathCounter() {
        deathCounter++;
        lblDeathCounter.setText("DEATH COUNTER:\n" + deathCounter);
    }
    
    /**
     * 
     * @return mPPunsh punching sound effect
     */
    public static MediaPlayer getMPPunch() {
        return mPPunch;
    }
    
    /**
     * 
     * @return mPCollect collecting sound effect 
     */
    public static MediaPlayer getMPCollect() {
        return mPCollect;
    }
    
    /**
     * 
     * @return mPSuccess mission complete sound effect
     */
    public static MediaPlayer getMPSucess() {
        return mPSuccess;
    }
    
    /**
     * 
     * @return invincible 
     */
    public static boolean getInvincible() {
        return invincible;
    }
}