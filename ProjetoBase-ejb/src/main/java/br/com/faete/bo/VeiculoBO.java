/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.bo;

import br.com.faete.dao.VeiculoDAO;
import br.com.faete.modelos.Veiculo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
            List lista = veiculoDAO.findByField("chassi", veiculo.getChassi());
            if (lista != null && !lista.isEmpty()) {
                throw new Exception("Já existe um veículo no banco com este Chassi!");
            }
            veiculoDAO.salvar(veiculo);
        } else {
            List<Veiculo> lista = veiculoDAO.findByField("chassi", veiculo.getChassi());
            if (lista != null && !lista.isEmpty()) {
                for (Veiculo v : lista) {
                    if (!Objects.equals(v.getId(), veiculo.getId())) {
                        throw new Exception("Já existe um veículo no banco com este Chassi!");
                    }
                }
            }
            veiculoDAO.atualizar(veiculo);
        }
    }

    public VeiculoDAO getVeiculoDAO() {
        return veiculoDAO;
    }

}
