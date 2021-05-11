package org.argouml.uml.diagram.ui;
import org.argouml.kernel.UmlModelMutator;
import org.argouml.model.Model;
@UmlModelMutator
class ActionModifierAbstract extends AbstractActionCheckBoxMenuItem
  { 
private static final long serialVersionUID = 2005311943576318145L;
boolean valueOfTarget(Object t)
    { 
return Model.getFacade().isAbstract(t);
} 
void toggleValueOfTarget(Object t)
    { 
Model.getCoreHelper().setAbstract(t,
                                          !Model.getFacade().isAbstract(t));
} 
public ActionModifierAbstract(Object o)
    { 
super("checkbox.abstract-uc");
putValue("SELECTED", Boolean.valueOf(valueOfTarget(o)));
} 

 } 
