
//#if -2076011723 
// Compilation Unit of /ActionAddExtendExtensionPoint.java 
 

//#if 233597117 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 650841883 
import java.util.ArrayList;
//#endif 


//#if 40860070 
import java.util.Collection;
//#endif 


//#if 1142284902 
import java.util.List;
//#endif 


//#if 82952005 
import org.argouml.i18n.Translator;
//#endif 


//#if 2102850699 
import org.argouml.model.Model;
//#endif 


//#if 686258361 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 1597031737 
public class ActionAddExtendExtensionPoint extends 
//#if -157641947 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -1072430768 
private static final ActionAddExtendExtensionPoint SINGLETON =
        new ActionAddExtendExtensionPoint();
//#endif 


//#if -412607816 
protected ActionAddExtendExtensionPoint()
    { 

//#if -600524854 
super();
//#endif 

} 

//#endif 


//#if -1412086598 
protected List getChoices()
    { 

//#if -1386157065 
List ret = new ArrayList();
//#endif 


//#if 1151833082 
if(getTarget() != null)//1
{ 

//#if 738131918 
Object extend = /*(MExtend)*/getTarget();
//#endif 


//#if -1788998841 
Collection c = Model.getFacade().getExtensionPoints(
                               Model.getFacade().getBase(extend));
//#endif 


//#if -1818790939 
ret.addAll(c);
//#endif 

} 

//#endif 


//#if -267051876 
return ret;
//#endif 

} 

//#endif 


//#if 946736771 
@Override
    protected void doIt(Collection selected)
    { 

//#if 304946400 
Model.getUseCasesHelper().setExtensionPoints(getTarget(), selected);
//#endif 

} 

//#endif 


//#if 1278118005 
protected List getSelected()
    { 

//#if -1775042776 
List ret = new ArrayList();
//#endif 


//#if -671492397 
ret.addAll(Model.getFacade().getExtensionPoints(getTarget()));
//#endif 


//#if 315534795 
return ret;
//#endif 

} 

//#endif 


//#if 734993003 
protected String getDialogTitle()
    { 

//#if -99097411 
return Translator.localize(
                   "dialog.title.add-extensionpoints");
//#endif 

} 

//#endif 


//#if 203964700 
public static ActionAddExtendExtensionPoint getInstance()
    { 

//#if 1456470011 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

