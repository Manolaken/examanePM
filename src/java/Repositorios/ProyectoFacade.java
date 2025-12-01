/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Proyecto;
import Entidades.Inspectoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dmaic
 */
@Stateless
public class ProyectoFacade extends AbstractFacade<Proyecto> {

    @PersistenceContext(unitName = "PeiroPerezPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }
    
    public List<Proyecto> findByInspectoria(Inspectoria inspectoria) {
        Query query = em.createNamedQuery("Proyecto.findByInspectoria");
        query.setParameter("inspectoria", inspectoria);
        return query.getResultList();
    }
    
    public List<Proyecto> findByPais(String pais) {
        Query query = em.createNamedQuery("Proyecto.findByPais");
        query.setParameter("pais", pais);
        return query.getResultList();
    }
    
    public List<Proyecto> findByAnyo(Integer anyo) {
        Query query = em.createNamedQuery("Proyecto.findByAnyo");
        query.setParameter("anyo", anyo);
        return query.getResultList();
    }
    
    public List<Proyecto> findByStatus(Integer status) {
        Query query = em.createNamedQuery("Proyecto.findByStatus");
        query.setParameter("status", status);
        return query.getResultList();
    }
    
    public List<Proyecto> findByPaisAndAnyo(String pais, Integer anyo) {
        Query query = em.createNamedQuery("Proyecto.findByPaisAndAnyo");
        query.setParameter("pais", pais);
        query.setParameter("anyo", anyo);
        return query.getResultList();
    }
    
}
