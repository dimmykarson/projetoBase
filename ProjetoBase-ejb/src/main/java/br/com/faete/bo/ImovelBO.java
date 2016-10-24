/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.bo;

import br.com.faete.dao.ImovelDAO;
import br.com.faete.modelos.Imovel;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sticdev30
 */
@Stateless
public class ImovelBO {
    
    @EJB
    private ImovelDAO imovelDAO;
    
    public void salvar(Imovel imovel) throws Exception {
        if (imovel == null) {
            throw new Exception("Passe um imóvel!");
        }
        if (imovel.getDescricao() == null || imovel.getDescricao().isEmpty()) {
            throw new Exception("Informe a descrição do imóvel!");
        }
        imovelDAO.salvar(imovel);
    }

    public ImovelDAO getImovelDAO() {
        return imovelDAO;
    }
    
    
    
}
