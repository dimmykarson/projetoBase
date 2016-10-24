/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.dao;

import br.com.faete.dao.BaseDAO;
import br.com.faete.modelos.Imovel;
import javax.ejb.Stateless;

/**
 *
 * @author sticdev30
 */
@Stateless
public class ImovelDAO extends BaseDAO {

    @Override
    public String getClassName() {
        return Imovel.class.getSimpleName();
    }

}
