/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.dao;

import br.com.faete.modelos.Veiculo;
import javax.ejb.Stateless;

/**
 *
 * @author sticdev30
 */
@Stateless
public class VeiculoDAO extends BaseDAO {

    @Override
    public String getClassName() {
        return Veiculo.class.getSimpleName();
    }

}
