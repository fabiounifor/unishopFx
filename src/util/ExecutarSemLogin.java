/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import blserial.BLCriptografiaReversivel;
import blserial.ConfigXML;
import controller.ControllerBanco;
import controller.ControllerUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelConfig;
import model.ModelSessaoUsuario;
import model.ModelUsuario;
import FXController.ViewBackup;
//import FXController.ViewLogin;

/**
 *
 * @author leand
 */
public class ExecutarSemLogin {

    ModelConfig modelConfig = new ModelConfig();
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    BLCriptografiaReversivel criptografiaReversivel = new BLCriptografiaReversivel();

    private void carregarDadosDoBanco() {
        modelConfig = new ModelConfig();
        modelConfig = manipularXML.lerXmlConfig();
        ModelSessaoUsuario.ipServidor = modelConfig.getIp();
        ModelSessaoUsuario.nomeDoBanco = modelConfig.getNomeBanco();
        ModelSessaoUsuario.usuarioBanco = modelConfig.getUsuario();
        ModelSessaoUsuario.senhaBanco = modelConfig.getSenha();
        ModelSessaoUsuario.caminhoMySQL = modelConfig.getCaminhoMySQL();
        ModelSessaoUsuario.quantidadeMesas = modelConfig.getQuantidadeMesas();
    }

    public void autenticar() {
        carregarDadosDoBanco();
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        modelUsuario.setLogin("admin");
        modelUsuario.setSenha("123");

        try {
            if (controllerUsuario.getUsuarioController(modelUsuario)) {
                modelUsuario = controllerUsuario.getUsuarioController(modelUsuario.getLogin());
                ModelSessaoUsuario.nome = modelUsuario.getNome();
                ModelSessaoUsuario.codigo = modelUsuario.getCodigo();
                ModelSessaoUsuario.login = modelUsuario.getLogin();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário/Senha inválida.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            try {
                ControllerBanco controllerBanco = new ControllerBanco();
                if (controllerBanco.criarBancoCtrl()) {
                    new ViewBackup().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível criar o banco.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
//                Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
