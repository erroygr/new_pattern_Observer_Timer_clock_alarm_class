
package model;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ComponentCircle implements Observer{

    public Subject subject;
    boolean flag=true;
    Timeline timeline;
    Circle circle;
public  ComponentCircle() {
     circle = new Circle(250,250, 50,Color.web("1c89f4"));
    circle.setEffect(new Lighting());
    timeline = new Timeline();

    timeline.setCycleCount(2);//кол-во повторов
    timeline.getKeyFrames().addAll(new KeyFrame(new Duration(5),
    new KeyValue(circle.translateXProperty(), 0) ),
            new KeyFrame(new Duration(1000),
    new KeyValue(circle.translateXProperty(), 205) ));
    flag=false;
}

    public void update(Subject st) {
        if(st==(Subject)subject) {
            if (flag) timeline.pause();
            else timeline.play();
            flag = !flag;
            System.out.print("Обновление " + flag);
        }
    }

    public Circle getCircle(){
    return  circle;
    }
    @Override
    public String display(Text time) {
        return null;
    }

    @Override
    public Text getText() {
        return null;
    }

    @Override
    public void StopMedia() {

    }

    @Override
    public Group getG() {
        return null;
    }

    public void start(){
        timeline.playFromStart();
        subject.attach(this);
        flag=true;
    }
    public void stop(){
        timeline.stop();
        subject.detach(this);
        flag=false;
    }
}


