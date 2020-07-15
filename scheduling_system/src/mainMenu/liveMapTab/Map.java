package mainMenu.liveMapTab;

import javafx.beans.property.SimpleStringProperty;

public class Map {
    //BE CAREFUL THAT HERE "Swap" means a row in the table of swaps:"9|P1->S1|S2->S3|..." is a "Swap"
    //again you do not need to change this again hopefully

    private SimpleStringProperty vCo;
    private SimpleStringProperty nCo;
    private SimpleStringProperty sCo;
    private SimpleStringProperty dCo;

    public Map(String vCo, String nCo, String sCo ,String dCo) {
        this.vCo=new SimpleStringProperty(vCo);
        this.nCo = new SimpleStringProperty(nCo);
        this.sCo = new SimpleStringProperty(sCo);
        this.dCo = new SimpleStringProperty(dCo);
    }

    public String getvCo() {
        return vCo.get();
    }

    public SimpleStringProperty vCoProperty() {
        return vCo;
    }

    public void setvCo(String vCo) {
        this.vCo.set(vCo);
    }

    public String getnCo() {
        return nCo.get();
    }

    public SimpleStringProperty nCoProperty() {
        return nCo;
    }

    public void setnCo(String nCo) {
        this.nCo.set(nCo);
    }

    public String getsCo() {
        return sCo.get();
    }

    public SimpleStringProperty sCoProperty() {
        return sCo;
    }

    public void setsCo(String sCo) {
        this.sCo.set(sCo);
    }

    public String getdCo() {
        return dCo.get();
    }

    public SimpleStringProperty dCoProperty() {
        return dCo;
    }

    public void setdCo(String dCo) {
        this.dCo.set(dCo);
    }
}
