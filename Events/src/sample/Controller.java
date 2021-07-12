package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField name1;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label myLabel;

    @FXML
    private void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }
    @FXML
    private void onButtonClicked(ActionEvent e){
        if(e.getSource().equals(helloButton)){
            System.out.println("Hello, "+ name1.getText());
        }else if(e.getSource().equals(byeButton)){
            System.out.println("Bye, "+ name1.getText());
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {

                try {
                    String s = Platform.isFxApplicationThread()?"UI Thread":"Background thread";
                    System.out.println("I am going to sleep on: "+ s);
                    Thread.sleep(10000);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread()?"UI Thread":"Background thread";
                            System.out.println("I am updating the label on the: "+ s);
                            myLabel.setText("I did something!?");
                        }
                    });

                } catch (InterruptedException e1) {
                    //e1.printStackTrace();
                }

            }
        };
        new Thread(task).start();

        if(ourCheckBox.isSelected()){
            name1.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML
    private void keyReleased(){
        String text=name1.getText();
        boolean disable=text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disable);
        byeButton.setDisable(disable);
    }

    @FXML
     void boxChecked(){
        System.out.println("The check box is "+ (ourCheckBox.isSelected()?"checked":"not checked"));
    }
}
