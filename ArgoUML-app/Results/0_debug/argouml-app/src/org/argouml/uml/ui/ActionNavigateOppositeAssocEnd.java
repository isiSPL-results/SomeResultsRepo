
//#if 966086726 
// Compilation Unit of /ActionNavigateOppositeAssocEnd.java 
 

//#if 891681456 
package org.argouml.uml.ui;
//#endif 


//#if -1277977454 
import java.util.Collection;
//#endif 


//#if 219363986 
import javax.swing.Action;
//#endif 


//#if 1498675288 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1319970273 
import org.argouml.model.Model;
//#endif 


//#if 698246371 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -991730947 
public class ActionNavigateOppositeAssocEnd extends 
//#if 1138471829 
AbstractActionNavigate
//#endif 

  { 

//#if 316227391 
private static final long serialVersionUID = 7054600929513339932L;
//#endif 


//#if 1520875764 
protected Object navigateTo(Object source)
    { 

//#if 1549652786 
return Model.getFacade().getNextEnd(source);
//#endif 

} 

//#endif 


//#if -1086510102 
public ActionNavigateOppositeAssocEnd()
    { 

//#if -174751230 
super("button.go-opposite", true);
//#endif 


//#if -695016410 
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIconResource("AssociationEnd"));
//#endif 

} 

//#endif 


//#if -2039804699 
public boolean isEnabled()
    { 

//#if -566537349 
Object o = TargetManager.getInstance().getTarget();
//#endif 


//#if 168643753 
if(o != null && Model.getFacade().isAAssociationEnd(o))//1
{ 

//#if 1680515476 
Collection ascEnds =
                Model.getFacade().getConnections(
                    Model.getFacade().getAssociation(o));
//#endif 


//#if 1582224198 
return !(ascEnds.size() > 2);
//#endif 

} 

//#endif 


//#if -1194359025 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

