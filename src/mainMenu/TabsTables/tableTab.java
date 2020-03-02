package mainMenu.TabsTables;

import javafx.beans.property.SimpleStringProperty;


public class tableTab {

    //read Swap class first if u really need to edit this

    private SimpleStringProperty cat;
    private SimpleStringProperty name;
    private SimpleStringProperty start;
    private SimpleStringProperty end;

    public tableTab(String cat, String name, String start ,String end ) {
        this.cat=new SimpleStringProperty(cat);
        this.name = new SimpleStringProperty(name);
        this.start = new SimpleStringProperty(start);
        this.end = new SimpleStringProperty(end);
    }

    public String getCat() {
        return cat.get();
    }

    public SimpleStringProperty catProperty() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat.set(cat);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getStart() {
        return start.get();
    }

    public SimpleStringProperty startProperty() {
        return start;
    }

    public void setStart(String start) {
        this.start.set(start);
    }

    public String getEnd() {
        return end.get();
    }

    public SimpleStringProperty endProperty() {
        return end;
    }

    public void setEnd(String end) {
        this.end.set(end);
    }
}
