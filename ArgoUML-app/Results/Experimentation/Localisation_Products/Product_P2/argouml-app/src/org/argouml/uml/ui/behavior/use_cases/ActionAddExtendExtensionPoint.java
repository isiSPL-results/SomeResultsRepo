package org.argouml.uml.ui.behavior.use_cases;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
public class ActionAddExtendExtensionPoint extends AbstractActionAddModelElement2
  { 
private static final ActionAddExtendExtensionPoint SINGLETON =
        new ActionAddExtendExtensionPoint();
protected ActionAddExtendExtensionPoint()
    { 
super();
} 
protected List getChoices()
    { 
List ret = new ArrayList();
if(getTarget() != null)//1
{ 
Object extend = /*(MExtend)*/getTarget();
Collection c = Model.getFacade().getExtensionPoints(
                               Model.getFacade().getBase(extend));
ret.addAll(c);
} 
return ret;
} 
@Override
    protected void doIt(Collection selected)
    { 
Model.getUseCasesHelper().setExtensionPoints(getTarget(), selected);
} 
protected List getSelected()
    { 
List ret = new ArrayList();
ret.addAll(Model.getFacade().getExtensionPoints(getTarget()));
return ret;
} 
protected String getDialogTitle()
    { 
return Translator.localize(
                   "dialog.title.add-extensionpoints");
} 
public static ActionAddExtendExtensionPoint getInstance()
    { 
return SINGLETON;
} 

 } 
