package mainMenu.scheduleTab;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Schedule {
    //shit class cos lack of experience
    private SimpleStringProperty position;
    private SimpleStringProperty ride;
    private SimpleStringProperty st1;//9:00
    private SimpleStringProperty st2;//10:00...
    private SimpleStringProperty st3;
    private SimpleStringProperty st4;
    private SimpleStringProperty st5;
    private SimpleStringProperty st6;
    private SimpleStringProperty st7;
    private SimpleStringProperty st8;

        public Schedule(String position, String ride, String st1, String st2,
                        String st3, String st4, String st5, String st6,
                        String st7, String st8) {
        this.position = new SimpleStringProperty(position);
        this.ride = new SimpleStringProperty(ride);
        this.st1=new SimpleStringProperty(st1);
        this.st2=new SimpleStringProperty(st2);
        this.st3=new SimpleStringProperty(st3);
        this.st4=new SimpleStringProperty(st4);
        this.st5=new SimpleStringProperty(st5);
        this.st6=new SimpleStringProperty(st6);
        this.st7=new SimpleStringProperty(st7);
        this.st8=new SimpleStringProperty(st8);


    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }


    public String getRide() {
        return ride.get();
    }

    public SimpleStringProperty rideProperty() {
        return ride;
    }

    public String getSt1() {
        return st1.get();
    }

    public SimpleStringProperty st1Property() {
        return st1;
    }

    public void setSt1(String st1) {
        this.st1.set(st1);
    }

    public String getSt2() {
        return st2.get();
    }

    public SimpleStringProperty st2Property() {
        return st2;
    }

    public void setSt2(String st2) {
        this.st2.set(st2);
    }

    public String getSt3() {
        return st3.get();
    }

    public SimpleStringProperty st3Property() {
        return st3;
    }

    public void setSt3(String st3) {
        this.st3.set(st3);
    }

    public String getSt4() {
        return st4.get();
    }

    public SimpleStringProperty st4Property() {
        return st4;
    }

    public void setSt4(String st4) {
        this.st4.set(st4);
    }

    public String getSt5() {
        return st5.get();
    }

    public SimpleStringProperty st5Property() {
        return st5;
    }

    public void setSt5(String st5) {
        this.st5.set(st5);
    }

    public String getSt6() {
        return st6.get();
    }

    public SimpleStringProperty st6Property() {
        return st6;
    }

    public void setSt6(String st6) {
        this.st6.set(st6);
    }

    public String getSt7() {
        return st7.get();
    }

    public SimpleStringProperty st7Property() {
        return st7;
    }

    public void setSt7(String st7) {
        this.st7.set(st7);
    }

    public String getSt8() {
        return st8.get();
    }

    public SimpleStringProperty st8Property() {
        return st8;
    }

    public void setSt8(String st8) {
        this.st8.set(st8);
    }
}
