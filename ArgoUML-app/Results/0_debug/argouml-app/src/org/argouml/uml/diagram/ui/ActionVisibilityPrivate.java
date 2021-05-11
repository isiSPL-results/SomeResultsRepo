
//#if -606072092 
// Compilation Unit of /ActionVisibilityPrivate.java 
 

//#if 1244491292 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 958454928 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -132888154 
import org.argouml.model.Model;
//#endif 


//#if 2067369712 

//#if 837281070 
@UmlModelMutator
//#endif 

class ActionVisibilityPrivate extends 
//#if -738672012 
AbstractActionRadioMenuItem
//#endif 

  { 

//#if -1375685308 
private static final long serialVersionUID = -1342216726253371114L;
//#endif 


//#if 529224387 
Object valueOfTarget(Object t)
    { 

//#if -1695195275 
Object v = Model.getFacade().getVisibility(t);
//#endif 


//#if 1485628528 
return v == null ? Model.getVisibilityKind().getPublic() : v;
//#endif 

} 

//#endif 


//#if -341776340 
void toggleValueOfTarget(Object t)
    { 

//#if -1052935274 
Model.getCoreHelper().setVisibility(t,
                                            Model.getVisibilityKind().getPrivate());
//#endif 

} 

//#endif 


//#if 1066103792 
public ActionVisibilityPrivate(Object o)
    { 

//#if -306298462 
super("checkbox.visibility.private-uc", false);
//#endif 


//#if 1363982806 
putValue("SELECTED", Boolean.valueOf(
                     Model.getVisibilityKind().getPrivate()
                     .equals(valueOfTarget(o))));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

