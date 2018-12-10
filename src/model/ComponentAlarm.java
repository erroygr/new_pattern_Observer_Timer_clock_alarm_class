package model;

import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Lighting;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

public class ComponentAlarm implements Observer {

    public Text AlarmText;
    public MediaPlayer mediaPlayer;
    public Subject subject;
    public int timeAlarm;
    public boolean activ=true;

   public ComponentAlarm( Subject subject,int  timeAlarm){

        super();
        this.subject=subject;
        this.subject.attach(this);
        this.timeAlarm=timeAlarm;

       AlarmText= new Text("Жду когда заведут");
       AlarmText.setFont(Font.font("Times New Roman", 20));
       AlarmText.setLayoutX(70.0);
       AlarmText.setLayoutY(70.0);
       AlarmText.setFill(Color.BLUE);
       AlarmText.setEffect(new Lighting());

        String file = "141715443_456239410 (mp3cut.ru).mp3";
        Media sound = new Media(new File(file).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);


    }
 public void StopMedia(){
     mediaPlayer.stop();
     subject.detach(this);
     AlarmText.setText("Я уже сработал. Заведи новый!");
     activ=false;
 }

    @Override
    public Group getG() {
        return null;
    }

    @Override
    public Circle getCircle() {
        return null;
    }

    public void set(Subject st){
        subject.attach(this);
    }

    @Override
    public void update(Subject st) {
        if(st==(Subject) subject){
            if(timeAlarm==subject.getState() && activ )
            {
                mediaPlayer.play();
                AlarmText.setText("Будильник сработал! ");

            }else {
                System.out.println("Ожидание");
                int raznica=0;
                raznica=Integer.valueOf(timeAlarm)- subject.getState();
                AlarmText.setText("Ожидание: "+raznica +" с");
            }

            display((AlarmText));
        }
    }

    @Override
    public String display(Text time) {
        System.out.println(time);
        return String.valueOf(time);
    }

    @Override
    public Text getText() {
        return AlarmText;
    }
}
