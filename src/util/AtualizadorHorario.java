/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Administrador
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.Label;
import javax.swing.JLabel;
/**
 *
 * @author AJFILHO
 */
public class AtualizadorHorario extends Thread {

    private Label hr;
    private boolean mostrarData;

    public AtualizadorHorario(Label hora) {
        this.hr = hora;
    }

    public void mostrarData(boolean mostrar) {
        if (mostrar) {
            this.mostrarData = true;
        } else {
            this.mostrarData = false;
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Date d = new Date();
                StringBuilder data = new StringBuilder();
                if (mostrarData) {
                    SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");
                    data.append(sdfData.format(d));
                    data.append(" - ");
                }
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                this.hr.setText(data.toString() + sdf.format(d));
                Thread.sleep(1000);
                
            }
        } catch (InterruptedException ex) {
            System.out.println("Problema na atualização da data/hora");
        }
    }
}
