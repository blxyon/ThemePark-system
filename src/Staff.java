import javafx.beans.property.SimpleStringProperty;

public class Staff {




    //BE CAREFUL THAT HERE "Swap" means a row in the table of swaps:"9|P1->S1|S2->S3|..." is a "Swap"
    //again you do not need to change this again hopefully

    private SimpleStringProperty category;
    private SimpleStringProperty Name;
    private SimpleStringProperty StartT;
    private SimpleStringProperty EndT;
    private String ride;

    public String getRide() {
        return ride;
    }

    public void setRide(String ride) {
        this.ride = ride;
    }

    public Staff(String category, String Name, String StartT , String EndT, String ride) {
        this.category=new SimpleStringProperty(category);
        this.Name = new SimpleStringProperty(Name);
        this.StartT = new SimpleStringProperty(StartT);
        this.EndT = new SimpleStringProperty(EndT);
        this.ride=ride;
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getStartT() {
        return StartT.get();
    }

    public SimpleStringProperty startTProperty() {
        return StartT;
    }

    public void setStartT(String startT) {
        this.StartT.set(startT);
    }

    public String getEndT() {
        return EndT.get();
    }

    public SimpleStringProperty endTProperty() {
        return EndT;
    }

    public void setEndT(String endT) {
        this.EndT.set(endT);
    }
}
