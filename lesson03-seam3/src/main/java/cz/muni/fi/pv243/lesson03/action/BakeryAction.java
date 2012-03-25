package cz.muni.fi.pv243.lesson03.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.seam.faces.context.conversation.Begin;
import org.jboss.seam.faces.context.conversation.End;
import org.jboss.solder.exception.control.ExceptionHandled;

@Named
@Stateless
public class BakeryAction
{
   @Inject
   EntityManager em;
   
   @Begin
   public void edit()
   {
   }

   @End
   @ExceptionHandled
   public void save()
   {
      em.flush();
   }
}
