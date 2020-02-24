package mainMenu.swapManagament;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Swap {

    //BE CAREFUL THAT HERE "Swap" means a row in the table of swaps:"9|P1->S1|S2->S3|..." is a "Swap"
    //again you do not need to change this again hopefully

    private SimpleStringProperty time;
    private SimpleStringProperty T1;
    private SimpleStringProperty T2;
    private SimpleStringProperty T3;
    private SimpleStringProperty T4;

    public Swap(String time, String T1, String T2 ,String T3 ,String T4) {
        this.time=new SimpleStringProperty(time);
        this.T1 = new SimpleStringProperty(T1);
        this.T2 = new SimpleStringProperty(T2);
        this.T3 = new SimpleStringProperty(T3);
        this.T4 = new SimpleStringProperty(T4);
    }

    public String getTime() {
        return time.get();
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getT1() {
        return T1.get();
    }

    public SimpleStringProperty t1Property() {
        return T1;
    }

    public void setT1(String t1) {
        this.T1.set(t1);
    }

    public String getT2() {
        return T2.get();
    }

    public SimpleStringProperty t2Property() {
        return T2;
    }

    public void setT2(String t2) {
        this.T2.set(t2);
    }

    public String getT3() {
        return T3.get();
    }

    public SimpleStringProperty t3Property() {
        return T3;
    }

    public void setT3(String t3) {
        this.T3.set(t3);
    }

    public String getT4() {
        return T4.get();
    }

    public SimpleStringProperty t4Property() {
        return T4;
    }

    public void setT4(String t4) {
        this.T4.set(t4);
    }
}
