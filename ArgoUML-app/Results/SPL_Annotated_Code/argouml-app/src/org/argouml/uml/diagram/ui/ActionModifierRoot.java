// Compilation Unit of /ActionModifierRoot.java 
 
package org.argouml.uml.diagram.ui;
import org.argouml.kernel.UmlModelMutator;
import org.argouml.model.Model;
@UmlModelMutator
class ActionModifierRoot extends AbstractActionCheckBoxMenuItem
  { 
private static final long serialVersionUID = -5465416932632977463L;
boolean valueOfTarget(Object t)
    { 
return Model.getFacade().isRoot(t);
} 

public ActionModifierRoot(Object o)
    { 
super("checkbox.root-uc");
putValue("SELECTED", Boolean.valueOf(valueOfTarget(o)));
} 

void toggleValueOfTarget(Object t)
    { 
Model.getCoreHelper().setRoot(t, !Model.getFacade().isRoot(t));
} 

 } 


