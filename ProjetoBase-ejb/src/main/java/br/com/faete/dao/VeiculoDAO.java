/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.dao;

import br.com.faete.modelos.Veiculo;
import java.math.BigInteger;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.Query;

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

    /**
     * Retorna false se o veículo não está disponível para locação
     *
     * @param veiculo
     * @param inicio
     * @param fim
     * @return
     */
    public boolean veiculoEstaDisponivel(Veiculo veiculo, Date inicio, Date fim) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(*) from Locacao l ");
        sb.append(" inner join l.veiculosLocados v ");
        sb.append(" where v.id = :id ");
        sb.append(" and ((l.dataInicio <= :inicio and l.dataFim >= :inicio )");
        sb.append(" or l.dataInicio >= :inicio and l.dataFim <= :fim )");

        Query q = getEm().createQuery(sb.toString());
        q.setParameter("id", veiculo.getId());
        q.setParameter("inicio", inicio);
        q.setParameter("fim", fim);
        try {
            Integer i = (Integer) q.getSingleResult();
            return !(i > 0);
        } catch (Exception ex) {
            return true;
        }
    }

}
