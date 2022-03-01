/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ModelSessaoUsuario;

/**
 *
 * @author MacMini
 */
public class BackupMySQL {

    ModelSessaoUsuario modelSessaoUsuario = new ModelSessaoUsuario();

    public boolean Backupdbtosql() {

        try {
           
            /*NOTE: Creating Path Constraints for folder saving*/
 /*NOTE: Here the backup folder is created for saving inside it*/
            String folderPath = "C:\\UniShop\\backup";

            /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(folderPath);
            f1.mkdir();

            /*NOTE: Creating Path Constraints for backup saving*/
 /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "C:\\UniShop\\backup\\" + "backup_" + new Date().getTime() + ".sql";

            /*NOTE: Used to create a cmd command*/
            String executeCmd = modelSessaoUsuario.caminhoMySQL +"mysqldump.exe --user=" + 
                    modelSessaoUsuario.usuarioBanco + 
                    " --password=" + modelSessaoUsuario.senhaBanco + 
                    " --database " + modelSessaoUsuario.nomeDoBanco + " -r " + savePath;
            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
                return true;
            } else {
                System.out.println("Backup Failure");
                return false;
            }

        } catch (IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
            return false;
        }
    }

    public boolean Restoredbfromsql(String pCaminho) {
        try {
            /*NOTE: Used to create a cmd command*/
            String[] executeCmd = new String[]{modelSessaoUsuario.caminhoMySQL+"mysql.exe", modelSessaoUsuario.nomeDoBanco, "--user=" + modelSessaoUsuario.usuarioBanco, "--password=" + modelSessaoUsuario.senhaBanco, "-e", " source " + pCaminho};

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error at restoring");
                return false;
            }
        } catch (IOException | InterruptedException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
            return false;
        }

    }

}
