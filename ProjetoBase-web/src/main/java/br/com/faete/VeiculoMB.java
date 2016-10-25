/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete;

import br.com.faete.bo.VeiculoBO;
import br.com.faete.modelos.Veiculo;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author sticdev30
 */
@ManagedBean
public class VeiculoMB implements Serializable {

    private Veiculo veiculo = new Veiculo();
    
    @EJB
    private VeiculoBO veiculoBO;
    
    public List<Veiculo> getVeiculos(){
        return veiculoBO.getVeiculoDAO().listarTodos();
    }
    
    public void salvar(){
        try {
            veiculoBO.salvar(veiculo);
            veiculo = new Veiculo();
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Sucesso", "Veículo Salvo com sucesso!"));
        } catch (Exception ex) {
            Logger.getLogger(VeiculoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
    
    
    
}
