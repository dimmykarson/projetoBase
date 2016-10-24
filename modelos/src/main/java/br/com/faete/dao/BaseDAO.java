/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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

}
