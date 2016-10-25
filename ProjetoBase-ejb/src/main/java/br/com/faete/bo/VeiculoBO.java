/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.bo;

import br.com.faete.dao.VeiculoDAO;
import br.com.faete.modelos.Veiculo;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sticdev30
 */
@Stateless
public class VeiculoBO {

    @EJB
    private VeiculoDAO veiculoDAO;

    public void salvar(Veiculo veiculo) throws Exception {
        if (veiculo == null) {
            throw new Exception("Passe um veículo!");
        }
        if (veiculo.getChassi() == null || veiculo.getChassi().isEmpty()) {
            throw new Exception("Informe o chassi do veículo!");
        }
        if (veiculo.getId() == null) {
            veiculoDAO.salvar(veiculo);
        }else{
            veiculoDAO.atualizar(veiculo);
        }
    }

    public VeiculoDAO getVeiculoDAO() {
        return veiculoDAO;
    }

}
