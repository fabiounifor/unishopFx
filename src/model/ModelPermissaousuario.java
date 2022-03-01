package model;

import java.util.ArrayList;

/**
*
* @author BLSoft Desenvolvimento de Sistemas
*/
public class ModelPermissaousuario {

    private int codigo;
    private int codigo_usuario;
    private String permissao;
    private ArrayList<ModelPermissaousuario> listaModelPermissaousuarios;

    /**
    * Construtor
    */
    public ModelPermissaousuario(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return pk_codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de codigo_usuario
    * @param pCodigo_usuario
    */
    public void setCodigo_usuario(int pCodigo_usuario){
        this.codigo_usuario = pCodigo_usuario;
    }
    /**
    * return fk_codigo_usuario
    */
    public int getCodigo_usuario(){
        return this.codigo_usuario;
    }

    /**
    * seta o valor de permissao
    * @param pPermissao
    */
    public void setPermissao(String pPermissao){
        this.permissao = pPermissao;
    }
    /**
    * return permissao
    */
    public String getPermissao(){
        return this.permissao;
    }

    @Override
    public String toString(){
        return "ModelPermissaousuario {" + "::codigo = " + this.codigo + "::codigo_usuario = " + this.codigo_usuario + "::permissao = " + this.permissao +  "}";
    }

    /**
     * @return the listaModelPermissaousuarios
     */
    public ArrayList<ModelPermissaousuario> getListaModelPermissaousuarios() {
        return listaModelPermissaousuarios;
    }

    /**
     * @param listaModelPermissaousuarios the listaModelPermissaousuarios to set
     */
    public void setListaModelPermissaousuarios(ArrayList<ModelPermissaousuario> listaModelPermissaousuarios) {
        this.listaModelPermissaousuarios = listaModelPermissaousuarios;
    }
}