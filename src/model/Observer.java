package model;


import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public interface Observer {

    public abstract void  update(Subject st);
    String display(Text time);
    Text getText();
    void StopMedia();
    Group getG();
    Circle getCircle();

}
