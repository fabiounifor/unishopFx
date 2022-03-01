package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
*/
public class ModelProgresso {

    private final DoubleProperty quantidade = new SimpleDoubleProperty();

    public final double getQuantidade() {
        return quantidade.get();
    }

    public final void setQuantidade(double value) {
        this.quantidade.set(value);
    }

    public final DoubleProperty quantidadeProperty() {
        return quantidade;
    }

    
}