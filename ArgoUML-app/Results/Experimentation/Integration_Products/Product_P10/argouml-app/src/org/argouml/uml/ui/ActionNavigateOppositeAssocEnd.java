package org.argouml.uml.ui;
import java.util.Collection;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
public class ActionNavigateOppositeAssocEnd extends AbstractActionNavigate
  { 
private static final long serialVersionUID = 7054600929513339932L;
protected Object navigateTo(Object source)
    { 
return Model.getFacade().getNextEnd(source);
} 
public ActionNavigateOppositeAssocEnd()
    { 
super("button.go-opposite", true);
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIconResource("AssociationEnd"));
} 
public boolean isEnabled()
    { 
Object o = TargetManager.getInstance().getTarget();
if(o != null && Model.getFacade().isAAssociationEnd(o))//1
{ 
Collection ascEnds =
                Model.getFacade().getConnections(
                    Model.getFacade().getAssociation(o));
return !(ascEnds.size() > 2);
} 
return false;
} 

 } 
