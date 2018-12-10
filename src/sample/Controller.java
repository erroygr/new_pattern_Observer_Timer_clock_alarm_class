package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.*;

import java.util.Timer;

public class Controller {

    public ListView list_Time;
    public TextField val_period;
    public Label labelTimer;
    public VBox boxV;
    public TextField val_delay;
    public TextField valuesAlarm;
    public VBox boxVAlarm;
    public VBox boxVAnimCircle;


    Subject timeServer1;
    Observer componText;
    //Subject timeServer2=new SubjectTimer();
    Observer componAlarm;
    Observer componCircle;

    public void initialize() {

    }
    public void startTimer(ActionEvent actionEvent) {
        timeServer1=new SubjectTimer(Integer.parseInt(val_delay.getText()),Integer.parseInt(val_period.getText()));
        componText =new ComponentText(timeServer1);
       /* timeServer1.setPeriod(Integer.parseInt(val_period.getText()));
        timeServer1.setDelay(Integer.parseInt(val_delay.getText()));*/

        boxV.getChildren().add(componText.getG());
    }
    public void stopTimer(ActionEvent actionEvent) {

        timeServer1.detach(componText);
        boxV.getChildren().clear();
    }

    public void startAlarm(ActionEvent actionEvent) {

            componAlarm = new ComponentAlarm(timeServer1, Integer.parseInt(valuesAlarm.getText()));
            //int alarmSec= Integer.parseInt(valuesAlarm.getText());
            boxVAlarm.getChildren().add(componAlarm.getText());

    }

    public void stopAlarm(ActionEvent actionEvent) {
        componAlarm.StopMedia();
    }


    public void startAnimCircle(ActionEvent actionEvent) {
        componCircle=new ComponentCircle();
        boxVAnimCircle.getChildren().add(componCircle.getCircle());
    }

    public void stopAnimCircle(ActionEvent actionEvent) {
    }
}
