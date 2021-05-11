
//#if -872556189 
// Compilation Unit of /ActionVisibilityPublic.java 
 

//#if 740828465 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -2039286821 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -657992901 
import org.argouml.model.Model;
//#endif 


//#if -1694118425 

//#if -1949928807 
@UmlModelMutator
//#endif 

class ActionVisibilityPublic extends 
//#if 1387279401 
AbstractActionRadioMenuItem
//#endif 

  { 

//#if 2003032320 
private static final long serialVersionUID = -4288749276325868991L;
//#endif 


//#if 2009208750 
Object valueOfTarget(Object t)
    { 

//#if 1160052511 
Object v = Model.getFacade().getVisibility(t);
//#endif 


//#if 1017886342 
return v == null ? Model.getVisibilityKind().getPublic() : v;
//#endif 

} 

//#endif 


//#if 264585111 
void toggleValueOfTarget(Object t)
    { 

//#if -1114788931 
Model.getCoreHelper().setVisibility(t,
                                            Model.getVisibilityKind().getPublic());
//#endif 

} 

//#endif 


//#if 373441947 
public ActionVisibilityPublic(Object o)
    { 

//#if 1185587853 
super("checkbox.visibility.public-uc", false);
//#endif 


//#if -177540153 
putValue("SELECTED", Boolean.valueOf(
                     Model.getVisibilityKind().getPublic()
                     .equals(valueOfTarget(o))));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

