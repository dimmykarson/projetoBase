/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete;

import br.com.faete.bo.ImovelBO;
import br.com.faete.modelos.Imovel;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author sticdev30
 */
@ManagedBean
public class ImovelMB implements Serializable {

    @EJB
    private ImovelBO imovelBO;
    
    public List<Imovel> getImoveis(){
        return imovelBO.getImovelDAO().listarTodos();
    }
    
    
    
}
