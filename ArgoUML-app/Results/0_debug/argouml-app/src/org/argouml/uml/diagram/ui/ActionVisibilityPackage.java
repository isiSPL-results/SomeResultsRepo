
//#if 1619942233 
// Compilation Unit of /ActionVisibilityPackage.java 
 

//#if -1931710377 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 382792181 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -1308909215 
import org.argouml.model.Model;
//#endif 


//#if -2019710930 

//#if 655466656 
@UmlModelMutator
//#endif 

class ActionVisibilityPackage extends 
//#if 1813498818 
AbstractActionRadioMenuItem
//#endif 

  { 

//#if 1106737134 
private static final long serialVersionUID = 8048943592787710460L;
//#endif 


//#if 1872330654 
void toggleValueOfTarget(Object t)
    { 

//#if 1619280138 
Model.getCoreHelper().setVisibility(t,
                                            Model.getVisibilityKind().getPackage());
//#endif 

} 

//#endif 


//#if -1957858507 
Object valueOfTarget(Object t)
    { 

//#if -1572849328 
Object v = Model.getFacade().getVisibility(t);
//#endif 


//#if -383196235 
return v == null ? Model.getVisibilityKind().getPublic() : v;
//#endif 

} 

//#endif 


//#if 855247487 
public ActionVisibilityPackage(Object o)
    { 

//#if -720145564 
super("checkbox.visibility.package-uc", false);
//#endif 


//#if 1104443352 
putValue("SELECTED", Boolean.valueOf(
                     Model.getVisibilityKind().getPackage()
                     .equals(valueOfTarget(o))));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

