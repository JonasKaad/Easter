package com.jonaskaad.easter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

public class PrimaryController {
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


    @FXML
    public void initialize(){
        setButtonGraphic(backButton1_1, nextButton1_1, backButton1_2, nextButton1_2, backButton1_3, nextButton1_3, backButton2_1, nextButton2_1, backButton3_2);
        setButtonGraphic(backButton2_2, nextButton2_2, backButton3_3, nextButton3_3, backButton2_3, nextButton2_3, backButton3_1, nextButton3_1, nextButton3_2);

        top_images = new ArrayList<>();
        middle_images = new ArrayList<>();
        bottom_images = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            for (int j = 1; j < 4; j++) {
                String eggImage = "images/Egg" + i + "_" + j + ".png";
                try {
                    if(j - 1 == 0) {
                        top_images.add(new Image(getClass().getResource(eggImage).toURI().toString()));
                    }
                    else if (j - 2 == 0){
                        middle_images.add(new Image(getClass().getResource(eggImage).toURI().toString()));
                    }
                    else {
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

    private void setButtonGraphic(Button backButton2_2, Button nextButton2_2, Button backButton3_3, Button nextButton3_3, Button backButton2_3, Button nextButton2_3, Button backButton3_1, Button nextButton3_1, Button nextButton3_2) {
        try {
            backButton2_2.setGraphic(new ImageView(new Image(getClass().getResource("arrow-left-thick.png").toURI().toString())));
            nextButton2_2.setGraphic(new ImageView(new Image(getClass().getResource("arrow-right-thick.png").toURI().toString())));
            backButton3_3.setGraphic(new ImageView(new Image(getClass().getResource("arrow-left-thick.png").toURI().toString())));
            nextButton3_3.setGraphic(new ImageView(new Image(getClass().getResource("arrow-right-thick.png").toURI().toString())));
            backButton2_3.setGraphic(new ImageView(new Image(getClass().getResource("arrow-left-thick.png").toURI().toString())));
            nextButton2_3.setGraphic(new ImageView(new Image(getClass().getResource("arrow-right-thick.png").toURI().toString())));
            backButton3_1.setGraphic(new ImageView(new Image(getClass().getResource("arrow-left-thick.png").toURI().toString())));
            nextButton3_1.setGraphic(new ImageView(new Image(getClass().getResource("arrow-right-thick.png").toURI().toString())));
            nextButton3_2.setGraphic(new ImageView(new Image(getClass().getResource("arrow-right-thick.png").toURI().toString())));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public void buttonHandlerEggOne (ActionEvent event){
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


    public void buttonHandlerEggTwo (ActionEvent event){
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

    public void buttonHandlerEggThree (ActionEvent event){
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




    public int getRandomStartingEgg(){
        Random random = new Random();
        return random.nextInt(0, top_images.size());
    }


}