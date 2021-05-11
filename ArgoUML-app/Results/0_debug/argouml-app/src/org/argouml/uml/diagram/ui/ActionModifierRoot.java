
//#if -318382355 
// Compilation Unit of /ActionModifierRoot.java 
 

//#if 669929250 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1156060982 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -2134205012 
import org.argouml.model.Model;
//#endif 


//#if -1890582828 

//#if -1736285337 
@UmlModelMutator
//#endif 

class ActionModifierRoot extends 
//#if 275949223 
AbstractActionCheckBoxMenuItem
//#endif 

  { 

//#if -448693880 
private static final long serialVersionUID = -5465416932632977463L;
//#endif 


//#if -1180482927 
boolean valueOfTarget(Object t)
    { 

//#if -1896098113 
return Model.getFacade().isRoot(t);
//#endif 

} 

//#endif 


//#if 1133456015 
public ActionModifierRoot(Object o)
    { 

//#if -652193272 
super("checkbox.root-uc");
//#endif 


//#if 1182297044 
putValue("SELECTED", Boolean.valueOf(valueOfTarget(o)));
//#endif 

} 

//#endif 


//#if 1867633765 
void toggleValueOfTarget(Object t)
    { 

//#if -157785662 
Model.getCoreHelper().setRoot(t, !Model.getFacade().isRoot(t));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

