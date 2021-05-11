
//#if 1511804807 
// Compilation Unit of /ActionModifierActive.java 
 

//#if 1051811798 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 806774166 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 1685727328 
import org.argouml.model.Model;
//#endif 


//#if -1997808316 

//#if 1449714776 
@UmlModelMutator
//#endif 

class ActionModifierActive extends 
//#if -796381736 
AbstractActionCheckBoxMenuItem
//#endif 

  { 

//#if 467227449 
private static final long serialVersionUID = -4458846555966612262L;
//#endif 


//#if -2145234090 
void toggleValueOfTarget(Object t)
    { 

//#if -969535277 
Model.getCoreHelper().setActive(t, !Model.getFacade().isActive(t));
//#endif 

} 

//#endif 


//#if -937979584 
boolean valueOfTarget(Object t)
    { 

//#if 1326269340 
return Model.getFacade().isActive(t);
//#endif 

} 

//#endif 


//#if 1433235546 
public ActionModifierActive(Object o)
    { 

//#if 1585168440 
super("checkbox.active-uc");
//#endif 


//#if 884058632 
putValue("SELECTED", Boolean.valueOf(valueOfTarget(o)));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

