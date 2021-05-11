
//#if 919765872 
// Compilation Unit of /ActionModifierAbstract.java 
 

//#if -718173491 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1966425791 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -71538985 
import org.argouml.model.Model;
//#endif 


//#if -208673847 

//#if 1950522595 
@UmlModelMutator
//#endif 

class ActionModifierAbstract extends 
//#if -1121806557 
AbstractActionCheckBoxMenuItem
//#endif 

  { 

//#if -728881703 
private static final long serialVersionUID = 2005311943576318145L;
//#endif 


//#if -1087024491 
boolean valueOfTarget(Object t)
    { 

//#if -764005224 
return Model.getFacade().isAbstract(t);
//#endif 

} 

//#endif 


//#if -1345874463 
void toggleValueOfTarget(Object t)
    { 

//#if -69799724 
Model.getCoreHelper().setAbstract(t,
                                          !Model.getFacade().isAbstract(t));
//#endif 

} 

//#endif 


//#if 739854163 
public ActionModifierAbstract(Object o)
    { 

//#if -687124407 
super("checkbox.abstract-uc");
//#endif 


//#if 574853491 
putValue("SELECTED", Boolean.valueOf(valueOfTarget(o)));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

