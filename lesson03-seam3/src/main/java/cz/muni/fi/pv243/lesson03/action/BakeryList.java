package cz.muni.fi.pv243.lesson03.action;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import cz.muni.fi.pv243.lesson03.model.Bakery;

@Stateless
@Named
public class BakeryList {

	@Inject
	private EntityManager em;
	
	@Inject
	CurrentBakeryProducer currentCakeStoreProducer;
	
	@Produces
    @Model
    public List<Bakery> getBakeries() {
        return em.createQuery("select b from Bakery b order by b.name", Bakery.class)
                .getResultList();
    }
}
