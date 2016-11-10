/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete;

import br.com.faete.bo.LocacaoBO;
import br.com.faete.modelos.Locacao;
import br.com.faete.modelos.Veiculo;
import java.io.Serializable;
import java.util.HashSet;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sticdev30
 */
@ManagedBean
@SessionScoped
public class LocacaoMB implements Serializable {

    private Locacao locacao = new Locacao();
    @EJB
    private LocacaoBO locacaoBO;

    public void adicionarVeiculo(Veiculo veiculo) {
        if (locacao.getVeiculosLocados() == null) {
            locacao.setVeiculosLocados(new HashSet<Veiculo>());
        }
        locacao.getVeiculosLocados().add(veiculo);
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Sucesso", "Veículo adicionado com sucesso!"));

    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

}
