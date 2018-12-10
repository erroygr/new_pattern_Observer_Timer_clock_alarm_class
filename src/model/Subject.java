package model;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public interface Subject {


     int getState();
    void setState(int time);
     void notifyAllObservers();
     void attach(Observer obs);
     void detach(Observer obs);
    void setDelay(int in);
    void setPeriod(int parseInt);
    int getDelay();
    int getPeriod();



}
