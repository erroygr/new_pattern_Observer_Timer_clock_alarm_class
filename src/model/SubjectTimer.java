package model;


import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class SubjectTimer implements Subject {

    public Timer timer;
    public TimerTask task;
    public int  timeState;
    public int delay;
    public int period;
    List<Observer> observers = new ArrayList<Observer>();


    public SubjectTimer(int delay, int period) {
        this.delay=delay;
        this.period=period;
        this.timer = new Timer();
        task = new TimerTask() {
            public void run() {
                tick();
            }
        };
        timer.schedule(task, delay,period);
    }

    private  void tick(){
        timeState++;
        notifyAllObservers();
    }

    public int getState() {
        return timeState;
    }

    public void setState(int time)   {
        this.timeState=time;
    }
    public void setPeriod(int time)   {
        this.period=time;
    }
    public int getPeriod(){
        return period;
    }

    public void setDelay(int delay){
        this.delay=delay;
    }
    public int getDelay(){
        return delay;
    }


    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void attach(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        observers.remove(obs);
    }
}
