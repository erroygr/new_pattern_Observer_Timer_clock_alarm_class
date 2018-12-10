package model;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ComponentText implements Observer {
    public Text circle;
    public Group g;
    public Subject subject;

    public ComponentText(Subject subject){
        super();
        this.subject=subject;
        this.subject.attach(this);

        //circle= new Text("Прошло с");
/*        circle.setFont(Font.font("Times New Roman", 30));
        circle.setLayoutX(70.0);
        circle.setLayoutY(70.0);
        circle.setFill(Color.RED);
        circle.setEffect(new Bloom());*/

        g = new Group();
        PerspectiveTransform pt = new PerspectiveTransform();
        pt.setUlx(10.0f);
        pt.setUly(10.0f);
        pt.setUrx(210.0f);
        pt.setUry(40.0f);
        pt.setLrx(210.0f);
        pt.setLry(60.0f);
        pt.setLlx(10.0f);
        pt.setLly(90.0f);

        g.setEffect(pt);
        g.setCache(true);

        Rectangle r = new Rectangle();
        r.setX(10.0f);
        r.setY(10.0f);
        r.setWidth(300.0f);
        r.setHeight(80.0f);
        r.setFill(Color.DARKBLUE);

         circle = new Text();
        circle.setX(20.0f);
        circle.setY(65.0f);
        circle.setText("Прошло с");
        circle.setFill(Color.RED);
        circle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40));

        g.getChildren().add(r);
        g.getChildren().add(circle);
    }

    public void set(Subject st){
        subject.attach(this);
    }
    public void setText(Text text){
        this.circle=text;
    }
    public Text getText(){
        return circle;
    }

    public Group getG(){
        return g;
    }

    @Override
    public Circle getCircle() {
        return null;
    }

    @Override
    public void StopMedia() {

    }

    @Override
    public void  update(Subject st) {
       if(st==(Subject) subject){

        circle.setText("Прошло "+subject.getState()+" с");
          // g.getChildren().add(circle);
       display((circle));
    }
    }

    @Override
    public String display(Text time) {
        System.out.println(time);
        return String.valueOf(time);
    }

}
