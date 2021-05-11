
//#if 1194561892 
// Compilation Unit of /ActionVisibilityProtected.java 
 

//#if 728182379 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 636220769 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 1008765301 
import org.argouml.model.Model;
//#endif 


//#if 290090410 

//#if 766903554 
@UmlModelMutator
//#endif 

class ActionVisibilityProtected extends 
//#if -309447136 
AbstractActionRadioMenuItem
//#endif 

  { 

//#if -999024080 
private static final long serialVersionUID = -8808296945094744255L;
//#endif 


//#if -369303552 
void toggleValueOfTarget(Object t)
    { 

//#if 1692948033 
Model.getCoreHelper().setVisibility(t,
                                            Model.getVisibilityKind().getProtected());
//#endif 

} 

//#endif 


//#if 950293655 
Object valueOfTarget(Object t)
    { 

//#if 490177143 
Object v = Model.getFacade().getVisibility(t);
//#endif 


//#if -1844827090 
return v == null ? Model.getVisibilityKind().getPublic() : v;
//#endif 

} 

//#endif 


//#if -332698247 
public ActionVisibilityProtected(Object o)
    { 

//#if 1000655986 
super("checkbox.visibility.protected-uc", false);
//#endif 


//#if -208882266 
putValue("SELECTED", Boolean.valueOf(
                     Model.getVisibilityKind().getProtected()
                     .equals(valueOfTarget(o))));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

