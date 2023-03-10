package com.example.kik;

import javafx.beans.WeakInvalidationListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Text winnerText;
    private int signTurn = 0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;



    ArrayList<Button> buttons;




    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

        buttons.forEach(button -> {
            setButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Kółko i krzyżyk");

    }
    public void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }


    public void setSign(Button button) {
        if (signTurn % 2 == 0) {
            button.setText("X");
            signTurn = 1;
            winnerText.setText("Ruch: O");


        } else {
            button.setText("O");
            signTurn = 0;
            winnerText.setText("Ruch: X");
        }
    }


    private void setButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setSign(button);
            button.setDisable(true);

            checkWinner();
        });
    }



    public void checkWinner(){
        for (int i = 0; i < 8; i++) {
            String line = switch (i) {


                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();


                default -> " ";
            };


            if (line.equals("XXX")) {

                winnerText.setText("Wygrywa X!");

            } else if (line.equals("OOO")) {

                winnerText.setText("Wygrywa O!");

                }
        }
    }
}
