package model;

import javafx.beans.property.BooleanProperty;

/**
*
* @author Leandro
*/
public class ModelSeleciona {

    private boolean seleciona;
    

    /**
    * Construtor
    */
    public ModelSeleciona(){}

    public boolean getSeleciona() {
        return seleciona;
    }

    public BooleanProperty  setSeleciona(boolean seleciona) {
        this.seleciona = seleciona;
        return null;
    }

    @Override
    public String toString() {
        return "ModelSeleciona{" + "seleciona=" + seleciona + '}';
    }

}