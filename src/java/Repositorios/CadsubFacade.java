/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Entidades.Cadsub;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manue
 */
@Stateless
public class CadsubFacade extends AbstractFacade<Cadsub> {

    @PersistenceContext(unitName = "PeiroPerezPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadsubFacade() {
        super(Cadsub.class);
    }
    
}
