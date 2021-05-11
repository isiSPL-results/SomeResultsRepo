
//#if 756798416 
// Compilation Unit of /ActionModifierLeaf.java 
 

//#if -1801053398 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1857289278 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -887509580 
import org.argouml.model.Model;
//#endif 


//#if -1099135416 

//#if -738130273 
@UmlModelMutator
//#endif 

class ActionModifierLeaf extends 
//#if -1273542689 
AbstractActionCheckBoxMenuItem
//#endif 

  { 

//#if 875685118 
private static final long serialVersionUID = 1087245945242698348L;
//#endif 


//#if 841730907 
public ActionModifierLeaf(Object o)
    { 

//#if -284018634 
super("checkbox.final-uc");
//#endif 


//#if 1572551464 
putValue("SELECTED", Boolean.valueOf(valueOfTarget(o)));
//#endif 

} 

//#endif 


//#if -1135409251 
void toggleValueOfTarget(Object t)
    { 

//#if -168995918 
Model.getCoreHelper().setLeaf(t, !Model.getFacade().isLeaf(t));
//#endif 

} 

//#endif 


//#if 986290777 
boolean valueOfTarget(Object t)
    { 

//#if -585679541 
return Model.getFacade().isLeaf(t);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

