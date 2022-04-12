package com.jonaskaad.easter;

import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

public class PrimaryController {
    @FXML
    private Label winLabel;
    @FXML
    private Label timerLabel;
    @FXML
    private Label eggLabel_1;
    @FXML
    private Label eggLabel_2;
    @FXML
    private Label eggLabel_3;
    @FXML
    private VBox vBox_Egg1;
    @FXML
    private VBox vBox_Egg2;
    @FXML
    private VBox vBox_Egg3;
    @FXML
    private Button startButton;
    @FXML
    private Button submitButton1;
    @FXML
    private Button submitButton2;
    @FXML
    private Button submitButton3;
    @FXML
    private ImageView imageView1_top;
    @FXML
    private ImageView imageView1_middle;
    @FXML
    private ImageView imageView1_bottom;
    @FXML
    private Button nextButton1_1;
    @FXML
    private Button nextButton1_2;
    @FXML
    private Button nextButton1_3;
    @FXML
    private Button backButton1_1;
    @FXML
    private Button backButton1_2;
    @FXML
    private Button backButton1_3;

    @FXML
    private ImageView imageView2_top;
    @FXML
    private ImageView imageView2_middle;
    @FXML
    private ImageView imageView2_bottom;
    @FXML
    private Button nextButton2_1;
    @FXML
    private Button nextButton2_2;
    @FXML
    private Button nextButton2_3;
    @FXML
    private Button backButton2_1;
    @FXML
    private Button backButton2_2;
    @FXML
    private Button backButton2_3;

    @FXML
    private ImageView imageView3_top;
    @FXML
    private ImageView imageView3_middle;
    @FXML
    private ImageView imageView3_bottom;
    @FXML
    private Button nextButton3_1;
    @FXML
    private Button nextButton3_2;
    @FXML
    private Button nextButton3_3;
    @FXML
    private Button backButton3_1;
    @FXML
    private Button backButton3_2;
    @FXML
    private Button backButton3_3;


    int egg1_top_index = 0;
    int egg1_mid_index = 1;
    int egg1_bot_index = 2;

    int egg2_top_index = 0;
    int egg2_mid_index = 1;
    int egg2_bot_index = 2;

    int egg3_top_index = 0;
    int egg3_mid_index = 1;
    int egg3_bot_index = 2;


    ArrayList<Image> top_images;
    ArrayList<Image> middle_images;
    ArrayList<Image> bottom_images;

    DoubleProperty time;
    BooleanProperty running;

    @FXML
    public void initialize() {

        time = new SimpleDoubleProperty();
        running = new SimpleBooleanProperty();


        top_images = new ArrayList<>();
        middle_images = new ArrayList<>();
        bottom_images = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            for (int j = 1; j < 4; j++) {
                String eggImage = "images/Egg" + i + "_" + j + ".png";
                try {
                    if (j - 1 == 0) {
                        top_images.add(new Image(getClass().getResource(eggImage).toURI().toString()));
                    } else if (j - 2 == 0) {
                        middle_images.add(new Image(getClass().getResource(eggImage).toURI().toString()));
                    } else {
                        bottom_images.add(new Image(getClass().getResource(eggImage).toURI().toString()));
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }


        imageView1_top.setImage(top_images.get(getRandomStartingEgg()));
        imageView1_middle.setImage(middle_images.get(getRandomStartingEgg()));
        imageView1_bottom.setImage(bottom_images.get(getRandomStartingEgg()));

        imageView2_top.setImage(top_images.get(getRandomStartingEgg()));
        imageView2_middle.setImage(middle_images.get(getRandomStartingEgg()));
        imageView2_bottom.setImage(bottom_images.get(getRandomStartingEgg()));

        imageView3_top.setImage(top_images.get(getRandomStartingEgg()));
        imageView3_middle.setImage(middle_images.get(getRandomStartingEgg()));
        imageView3_bottom.setImage(bottom_images.get(getRandomStartingEgg()));

    }

    public void buttonHandlerEggOne(ActionEvent event) {
        if (event.getSource() == nextButton1_1) {
            egg1_top_index = (egg1_top_index + 1) % top_images.size();
            imageView1_top.setImage(top_images.get(egg1_top_index));
        }
        if (event.getSource() == nextButton1_2) {
            egg1_mid_index = (egg1_mid_index + 1) % middle_images.size();
            imageView1_middle.setImage(middle_images.get(egg1_mid_index));
        }
        if (event.getSource() == nextButton1_3) {
            egg1_bot_index = (egg1_bot_index + 1) % bottom_images.size();
            imageView1_bottom.setImage(bottom_images.get(egg1_bot_index));
        }
        if (event.getSource() == backButton1_1) {

            egg1_top_index = Math.floorMod((egg1_top_index - 1), top_images.size());
            imageView1_top.setImage(top_images.get(egg1_top_index));
        }
        if (event.getSource() == backButton1_2) {
            egg1_mid_index = Math.floorMod((egg1_mid_index - 1), middle_images.size());
            imageView1_middle.setImage(middle_images.get(egg1_mid_index));
        }
        if (event.getSource() == backButton1_3) {
            egg1_bot_index = Math.floorMod((egg1_bot_index - 1), bottom_images.size());
            imageView1_bottom.setImage(bottom_images.get(egg1_bot_index));
        }
    }


    public void buttonHandlerEggTwo(ActionEvent event) {
        if (event.getSource() == nextButton2_1) {
            egg2_top_index = (egg2_top_index + 1) % top_images.size();
            imageView2_top.setImage(top_images.get(egg2_top_index));
        }
        if (event.getSource() == nextButton2_2) {
            egg2_mid_index = (egg2_mid_index + 1) % middle_images.size();
            imageView2_middle.setImage(middle_images.get(egg2_mid_index));
        }
        if (event.getSource() == nextButton2_3) {
            egg2_bot_index = (egg2_bot_index + 1) % bottom_images.size();
            imageView2_bottom.setImage(bottom_images.get(egg2_bot_index));
        }
        if (event.getSource() == backButton2_1) {
            egg2_top_index = Math.floorMod((egg2_top_index - 1), top_images.size());
            imageView2_top.setImage(top_images.get(egg2_top_index));
        }
        if (event.getSource() == backButton2_2) {
            egg2_mid_index = Math.floorMod((egg2_mid_index - 1), middle_images.size());
            imageView2_middle.setImage(middle_images.get(egg2_mid_index));
        }
        if (event.getSource() == backButton2_3) {
            egg2_bot_index = Math.floorMod((egg2_bot_index - 1), bottom_images.size());
            imageView2_bottom.setImage(bottom_images.get(egg2_bot_index));
        }
    }

    public void buttonHandlerEggThree(ActionEvent event) {
        if (event.getSource() == nextButton3_1) {
            egg3_top_index = (egg3_top_index + 1) % top_images.size();
            imageView3_top.setImage(top_images.get(egg3_top_index));
        }
        if (event.getSource() == nextButton3_2) {
            egg3_mid_index = (egg3_mid_index + 1) % middle_images.size();
            imageView3_middle.setImage(middle_images.get(egg3_mid_index));
        }
        if (event.getSource() == nextButton3_3) {
            egg3_bot_index = (egg3_bot_index + 1) % bottom_images.size();
            imageView3_bottom.setImage(bottom_images.get(egg3_bot_index));
        }
        if (event.getSource() == backButton3_1) {
            egg3_top_index = Math.floorMod((egg3_top_index - 1), top_images.size());
            imageView3_top.setImage(top_images.get(egg3_top_index));
        }
        if (event.getSource() == backButton3_2) {
            egg3_mid_index = Math.floorMod((egg3_mid_index - 1), middle_images.size());
            imageView3_middle.setImage(middle_images.get(egg3_mid_index));
        }
        if (event.getSource() == backButton3_3) {
            egg3_bot_index = Math.floorMod((egg3_bot_index - 1), bottom_images.size());
            imageView3_bottom.setImage(bottom_images.get(egg3_bot_index));
        }
    }

    int imgIndex_1;
    int imgIndex_2;
    int imgIndex_3;


    public int getRandomIndex() {
        Random random = new Random();
        return random.nextInt(1, 4);
    }

    public int getRandomStartingEgg() {
        Random random = new Random();
        return random.nextInt(0, top_images.size());
    }

    int startingEggIndex_1;
    int startingEggIndex_2;
    int startingEggIndex_3;

    public void startHandler() {

        timerLabel.textProperty().bind(time.asString("%.3f seconds"));
        startingEggIndex_1 = getRandomIndex();
        startingEggIndex_2 = getRandomIndex();
        startingEggIndex_3 = getRandomIndex();

        switch (startingEggIndex_1) {
            case 1 -> {
                backButton1_2.setDisable(false);
                nextButton1_2.setDisable(false);
                backButton1_3.setDisable(false);
                nextButton1_3.setDisable(false);
                imgIndex_1 = top_images.indexOf(imageView1_top.getImage());
            }
            case 2 -> {
                backButton1_1.setDisable(false);
                nextButton1_1.setDisable(false);
                backButton1_3.setDisable(false);
                nextButton1_3.setDisable(false);
                imgIndex_1 = middle_images.indexOf(imageView1_middle.getImage());
            }
            case 3 -> {
                backButton1_1.setDisable(false);
                nextButton1_1.setDisable(false);
                backButton1_2.setDisable(false);
                nextButton1_2.setDisable(false);
                imgIndex_1 = bottom_images.indexOf(imageView1_bottom.getImage());
            }
        }

        switch (startingEggIndex_2) {
            case 1 -> {
                backButton2_2.setDisable(false);
                nextButton2_2.setDisable(false);
                backButton2_3.setDisable(false);
                nextButton2_3.setDisable(false);
                imgIndex_2 = top_images.indexOf(imageView2_top.getImage());
            }
            case 2 -> {
                backButton2_1.setDisable(false);
                nextButton2_1.setDisable(false);
                backButton2_3.setDisable(false);
                nextButton2_3.setDisable(false);
                imgIndex_2 = middle_images.indexOf(imageView2_middle.getImage());
            }
            case 3 -> {
                backButton2_1.setDisable(false);
                nextButton2_1.setDisable(false);
                backButton2_2.setDisable(false);
                nextButton2_2.setDisable(false);
                imgIndex_2 = bottom_images.indexOf(imageView2_bottom.getImage());
            }
        }

        switch (startingEggIndex_3) {
            case 1 -> {
                backButton3_2.setDisable(false);
                nextButton3_2.setDisable(false);
                backButton3_3.setDisable(false);
                nextButton3_3.setDisable(false);
                imgIndex_3 = top_images.indexOf(imageView3_top.getImage());
            }
            case 2 -> {
                backButton3_1.setDisable(false);
                nextButton3_1.setDisable(false);
                backButton3_3.setDisable(false);
                nextButton3_3.setDisable(false);
                imgIndex_3 = middle_images.indexOf(imageView3_middle.getImage());
            }
            case 3 -> {
                backButton3_1.setDisable(false);
                nextButton3_1.setDisable(false);
                backButton3_2.setDisable(false);
                nextButton3_2.setDisable(false);
                imgIndex_3 = bottom_images.indexOf(imageView3_bottom.getImage());
            }
        }

        submitButton1.setDisable(false);
        submitButton2.setDisable(false);
        submitButton3.setDisable(false);
        startButton.setDisable(true);
        animationTimer.start();
    }

    boolean eggOneSolved = false;
    boolean eggTwoSolved = false;
    boolean eggThreeSolved = false;


    public void submitHandler(ActionEvent event) {
        String cssWrong = """
                -fx-border-color: red;
                -fx-border-width: 4;
                """;
        String cssCorrect = """
                -fx-border-color: LAWNGREEN;
                -fx-border-width: 4;
                """;
        if (event.getSource() == submitButton1){
            eggOneSolved = isEggSolved(event, cssWrong, cssCorrect, submitButton1, startingEggIndex_1, imageView1_middle, imageView1_top, imgIndex_1, imageView1_bottom, backButton1_2, nextButton1_2, backButton1_3, nextButton1_3, eggLabel_1, vBox_Egg1, backButton1_1, nextButton1_1);
        }
        if (event.getSource() == submitButton2) {
            eggTwoSolved = isEggSolved(event, cssWrong, cssCorrect, submitButton2, startingEggIndex_2, imageView2_middle, imageView2_top, imgIndex_2, imageView2_bottom, backButton2_2, nextButton2_2, backButton2_3, nextButton2_3, eggLabel_2, vBox_Egg2, backButton2_1, nextButton2_1);
        }
        if (event.getSource() == submitButton3) {
            eggThreeSolved = isEggSolved(event, cssWrong, cssCorrect, submitButton3, startingEggIndex_3, imageView3_middle, imageView3_top, imgIndex_3, imageView3_bottom, backButton3_2, nextButton3_2, backButton3_3, nextButton3_3, eggLabel_3, vBox_Egg3, backButton3_1, nextButton3_1);
        }
        if (eggOneSolved && eggTwoSolved && eggThreeSolved) {
            winLabel.setText("You win!");
            timerLabel.setStyle("-fx-text-fill: LIMEGREEN");
            animationTimer.stop();
        }
    }

    private boolean isEggSolved(ActionEvent event, String cssWrong, String cssCorrect, Button submitButton, int startingEggIndex, ImageView imageView_middle, ImageView imageView_top, int imgIndex, ImageView imageView_bottom, Button backButton_2, Button nextButton_2, Button backButton_3, Button nextButton_3, Label eggLabel, VBox vboxEgg, Button backButton_1, Button nextButton_1) {
        boolean eggSolved = false;
        if (event.getSource() == submitButton) {
            switch (startingEggIndex) {
                case 1 -> {
                    if (middle_images.indexOf(imageView_middle.getImage()) == imgIndex && bottom_images.indexOf(imageView_bottom.getImage()) == imgIndex) {
                        backButton_2.setDisable(true);
                        nextButton_2.setDisable(true);
                        backButton_3.setDisable(true);
                        nextButton_3.setDisable(true);
                        submitButton.setDisable(true);
                        eggLabel.setText("Correct!");
                        vboxEgg.setStyle(cssCorrect);
                        eggSolved = true;
                    } else {
                        eggLabel.setText("Wrong!");
                        vboxEgg.setStyle(cssWrong);
                    }
                }
                case 2 -> {
                    if (top_images.indexOf(imageView_top.getImage()) == imgIndex && bottom_images.indexOf(imageView_bottom.getImage()) == imgIndex) {
                        backButton_1.setDisable(true);
                        nextButton_1.setDisable(true);
                        backButton_3.setDisable(true);
                        nextButton_3.setDisable(true);
                        submitButton.setDisable(true);
                        eggLabel.setText("Correct!");
                        vboxEgg.setStyle(cssCorrect);
                        eggSolved = true;
                    } else {
                        eggLabel.setText("Wrong!");
                        vboxEgg.setStyle(cssWrong);
                    }

                }
                case 3 -> {
                    if (middle_images.indexOf(imageView_middle.getImage()) == imgIndex && top_images.indexOf(imageView_top.getImage()) == imgIndex) {
                        backButton_1.setDisable(true);
                        nextButton_1.setDisable(true);
                        backButton_2.setDisable(true);
                        nextButton_2.setDisable(true);
                        submitButton.setDisable(true);
                        eggLabel.setText("Correct!");
                        vboxEgg.setStyle(cssCorrect);
                        eggSolved = true;
                    } else {
                        eggLabel.setText("Wrong!");
                        vboxEgg.setStyle(cssWrong);
                    }
                }
            }
        }
        return eggSolved;
    }

    AnimationTimer animationTimer = new AnimationTimer() {

        private long startTime ;

        @Override
        public void start() {
            startTime = System.currentTimeMillis();
            running.set(true);
            super.start();
        }

        @Override
        public void stop() {
            running.set(false);
            super.stop();
        }

        @Override
        public void handle(long timestamp) {
            long now = System.currentTimeMillis();
            time.set((now - startTime) / 1000.0);
        }
    };

}