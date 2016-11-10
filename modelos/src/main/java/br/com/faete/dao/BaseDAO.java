/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sticdev30
 */
public abstract class BaseDAO {
    
    @PersistenceContext(unitName = "projetoBase_PU")
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }
    
    public abstract String getClassName();
    
    public void salvar(Object o) {
        getEm().persist(o);
    }
    
    public Object atualizar(Object o) {
        return getEm().merge(o);
    }
    
    public void deletar(Long id) {
        Query q = getEm().createQuery("delete from " + getClassName() + " where id = :id ");
        q.setParameter("id", id);
        q.executeUpdate();
    }
    
    public List listarTodos() {
        return getEm().createQuery("from " + getClassName()).getResultList();
    }
    
    public Object findById(Long id) {
        Query q = getEm().createQuery("from " + getClassName() + " where id = :id");
        q.setParameter("id", id);
        try {
            return q.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List findByFields(Map<String, String> mapa) {
        StringBuilder sql = new StringBuilder();
        sql.append("from ").append(getClassName());
        if (mapa != null) {
            sql.append(" where 1 = 1");
            for (String s : mapa.keySet()) {
                sql.append(" and ").append(s).append(" = :").append(s);
            }
        }
        Query q = getEm().createQuery(sql.toString());
        if (mapa != null) {
            for (String s : mapa.keySet()) {
                q.setParameter(s, mapa.get(s));
            }
        }
        try {
            return q.getResultList();
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    public List findByField(String campo, Object valor) {
        Query q = getEm().createQuery("from " + getClassName() + " where " + campo + " = :valor");
        q.setParameter("valor", valor);
        try {
            return q.getResultList();
        } catch (Exception ex) {
            return null;
        }
        
    }
    
}
