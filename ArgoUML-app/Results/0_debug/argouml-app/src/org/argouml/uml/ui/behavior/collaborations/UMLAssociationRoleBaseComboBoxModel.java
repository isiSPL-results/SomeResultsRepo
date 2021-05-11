
//#if -1965137373 
// Compilation Unit of /UMLAssociationRoleBaseComboBoxModel.java 
 

//#if 2121228252 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 1511423319 
import java.util.ArrayList;
//#endif 


//#if 949080810 
import java.util.Collection;
//#endif 


//#if 612951239 
import org.argouml.model.Model;
//#endif 


//#if 81477041 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1363816279 
public class UMLAssociationRoleBaseComboBoxModel extends 
//#if -471310268 
UMLComboBoxModel2
//#endif 

  { 

//#if -512860812 
private Collection others = new ArrayList();
//#endif 


//#if 1230143246 
@Override
    protected Object getSelectedModelElement()
    { 

//#if 828052187 
Object ar = getTarget();
//#endif 


//#if 340110496 
if(Model.getFacade().isAAssociationRole(ar))//1
{ 

//#if 776588812 
Object base = Model.getFacade().getBase(ar);
//#endif 


//#if -1402778848 
if(base != null)//1
{ 

//#if -1826382430 
return base;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -158144353 
return null;
//#endif 

} 

//#endif 


//#if 1585553932 
@Override
    protected void addOtherModelEventListeners(Object newTarget)
    { 

//#if -415725018 
super.addOtherModelEventListeners(newTarget);
//#endif 


//#if -454083005 
Collection connections = Model.getFacade().getConnections(newTarget);
//#endif 


//#if -357077472 
Collection types = new ArrayList();
//#endif 


//#if 1133877102 
for (Object conn : connections) //1
{ 

//#if -572517054 
types.add(Model.getFacade().getType(conn));
//#endif 

} 

//#endif 


//#if -1256580131 
for (Object classifierRole : types) //1
{ 

//#if 256800067 
others.addAll(Model.getFacade().getBases(classifierRole));
//#endif 

} 

//#endif 


//#if -1677574427 
for (Object classifier : others) //1
{ 

//#if 189943889 
Model.getPump().addModelEventListener(this,
                                                  classifier, "feature");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 716753626 
@Override
    protected boolean isValidElement(Object element)
    { 

//#if 1085147348 
Object ar = getTarget();
//#endif 


//#if 368684377 
if(Model.getFacade().isAAssociationRole(ar))//1
{ 

//#if 356473533 
Object base = Model.getFacade().getBase(ar);
//#endif 


//#if -965017120 
if(element == base)//1
{ 

//#if -713988725 
return true;
//#endif 

} 

//#endif 


//#if -1150699916 
Collection b =
                Model.getCollaborationsHelper().getAllPossibleBases(ar);
//#endif 


//#if -101473065 
return b.contains(element);
//#endif 

} 

//#endif 


//#if -1052742220 
return false;
//#endif 

} 

//#endif 


//#if 1126475706 
public UMLAssociationRoleBaseComboBoxModel()
    { 

//#if 356442673 
super("base", true);
//#endif 

} 

//#endif 


//#if -188354906 
@Override
    protected void buildModelList()
    { 

//#if 1027648415 
removeAllElements();
//#endif 


//#if -1039244249 
Object ar = getTarget();
//#endif 


//#if -144268038 
Object base = Model.getFacade().getBase(ar);
//#endif 


//#if 93763308 
if(Model.getFacade().isAAssociationRole(ar))//1
{ 

//#if -799345690 
setElements(
                Model.getCollaborationsHelper().getAllPossibleBases(ar));
//#endif 

} 

//#endif 


//#if -866612210 
if(base != null)//1
{ 

//#if 2094718355 
addElement(base);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -447521526 
@Override
    protected void removeOtherModelEventListeners(Object oldTarget)
    { 

//#if 475159872 
super.removeOtherModelEventListeners(oldTarget);
//#endif 


//#if 2028886493 
for (Object classifier : others) //1
{ 

//#if 1273821951 
Model.getPump().removeModelEventListener(this,
                    classifier, "feature");
//#endif 

} 

//#endif 


//#if -320355473 
others.clear();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

