package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.Random;

public class Controller {
    public Button rb1;
    public Button rb2;
    public Button rb4;
    public Button rb3;
    public Button start;

    public void startUp() throws NullPointerException { //method to generate random numbers for the buttons
        final Button[] selectrb = new Button[4];
        selectrb[0] = rb1;
        selectrb[1] = rb2;
        selectrb[2] = rb3;
        selectrb[3] = rb4;
        Random rnd = new Random();
        for (int allrbA = 0; allrbA < 4; allrbA++)
            selectrb[allrbA].setText(String.valueOf(rnd.nextInt(5) + 5));
    }

    public void changeNeighbour(int id) { // based on pressed button number make appropriate changes to other buttons
        switch (id) {
            case 1: {
                if (Integer.parseInt(rb1.getText()) != 0 && Integer.parseInt(rb1.getText()) > 0) {
                    rb1.setText(String.valueOf(Integer.parseInt(rb1.getText()) - 1));
                    rb2.setText(String.valueOf(Integer.parseInt(rb2.getText()) + 1));
                    rb3.setText(String.valueOf(Integer.parseInt(rb3.getText()) + 1));
                }
                break;
            }
            case 2: {
                if (Integer.parseInt(rb2.getText()) != 0 && Integer.parseInt(rb2.getText()) > 0) {
                    rb2.setText(String.valueOf(Integer.parseInt(rb2.getText()) - 1));
                    rb1.setText(String.valueOf(Integer.parseInt(rb1.getText()) + 1));
                    rb4.setText(String.valueOf(Integer.parseInt(rb4.getText()) + 1));
                }
                break;
            }
            case 3: {
                if (Integer.parseInt(rb3.getText()) != 0 && Integer.parseInt(rb3.getText()) > 0) {
                    rb3.setText(String.valueOf(Integer.parseInt(rb3.getText()) - 1));
                    rb1.setText(String.valueOf(Integer.parseInt(rb1.getText()) + 1));
                    rb4.setText(String.valueOf(Integer.parseInt(rb4.getText()) + 1));
                }
                break;
            }
            case 4: {
                if (Integer.parseInt(rb4.getText()) != 0 && Integer.parseInt(rb4.getText()) > 0) {
                    rb4.setText(String.valueOf(Integer.parseInt(rb4.getText()) - 1));
                    rb2.setText(String.valueOf(Integer.parseInt(rb2.getText()) + 1));
                    rb3.setText(String.valueOf(Integer.parseInt(rb3.getText()) + 1));
                }
                break;
            }
            default: {
                System.out.println("Some error has occurred! Inputted value: " + id);
                break;
            }
        }
    }

    public void btnClicked(ActionEvent actionEvent) { // get the number of clicked button
        String temp = ((Button) actionEvent.getSource()).getId().substring(2);
        int value = Integer.parseInt(temp);
        //System.out.println(value); // check if program got the correct button number
        changeNeighbour(value);
    }
}
