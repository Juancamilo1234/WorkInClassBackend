/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.events.jpa.sessions;

import co.edu.events.jpa.entities.Asistence;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class AsistenceFacade extends AbstractFacade<Asistence> {

    @PersistenceContext(unitName = "co.edu.events_Events_1199561_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsistenceFacade() {
        super(Asistence.class);
    }
    
}
