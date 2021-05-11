// Compilation Unit of /ActionNavigateAction.java 
 
package org.argouml.uml.ui;
import org.argouml.model.Model;
public class ActionNavigateAction extends AbstractActionNavigate
  { 
private static final long serialVersionUID = -4136512885671684476L;
protected Object navigateTo(Object source)
    { 
return Model.getFacade().getAction(source);
} 

 } 


