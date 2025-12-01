/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Sederesponsable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dmaic
 */
@Stateless
public class SederesponsableFacade extends AbstractFacade<Sederesponsable> {

    @PersistenceContext(unitName = "PeiroPerezPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SederesponsableFacade() {
        super(Sederesponsable.class);
    }
    
}
