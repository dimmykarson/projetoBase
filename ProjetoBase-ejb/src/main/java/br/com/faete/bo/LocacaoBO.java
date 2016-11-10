/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.bo;

import br.com.faete.dao.LocacaoDAO;
import br.com.faete.dao.VeiculoDAO;
import br.com.faete.modelos.Locacao;
import br.com.faete.modelos.Veiculo;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sticdev30
 */
@Stateless
public class LocacaoBO {
    
    @EJB
    private LocacaoDAO locacaoDAO;
    @EJB
    private VeiculoDAO veiculoDAO;
    
    public Locacao locar(Locacao locacao) throws Exception {
        if (locacao == null) {
            throw new Exception("Locação não pode ser nula!");
        }
        
        if (locacao.getCpfCliente() == null || locacao.getCpfCliente().isEmpty()) {
            throw new Exception("Locação deve ter o CPF do cliente informado!");
        }
        
        if (locacao.getVeiculosLocados() == null
                || locacao.getVeiculosLocados().isEmpty()) {
            throw new Exception("Locação deve possuir pelo menos um veículo informado!");
        }
        
        for (Veiculo v : locacao.getVeiculosLocados()) {
            if (!veiculoDAO.veiculoEstaDisponivel(v, locacao.getDataInicio(), locacao.getDataFim())) {
                throw new Exception("Veículo " + v.getModelo() + " não está disponível");
            }
        }
        
        locacaoDAO.salvar(locacao);
        
        return locacao;
    }
    
}
