
//#if -1136972235 
// Compilation Unit of /GoClassToSummary.java 
 

//#if 1547839724 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 27055193 
import java.util.ArrayList;
//#endif 


//#if -2116658136 
import java.util.Collection;
//#endif 


//#if -1191890981 
import java.util.Collections;
//#endif 


//#if -507509924 
import java.util.HashSet;
//#endif 


//#if -847219944 
import java.util.Iterator;
//#endif 


//#if 1875433390 
import java.util.Set;
//#endif 


//#if 281110147 
import org.argouml.i18n.Translator;
//#endif 


//#if 1663560393 
import org.argouml.model.Model;
//#endif 


//#if -523928838 
public class GoClassToSummary extends 
//#if -475778129 
AbstractPerspectiveRule
//#endif 

  { 

//#if 704425151 
public Collection getChildren(Object parent)
    { 

//#if 992075640 
if(Model.getFacade().isAClass(parent))//1
{ 

//#if -1515562545 
ArrayList list = new ArrayList();
//#endif 


//#if -1485160857 
if(Model.getFacade().getAttributes(parent).size() > 0)//1
{ 

//#if -1406839890 
list.add(new AttributesNode(parent));
//#endif 

} 

//#endif 


//#if 919240431 
if(Model.getFacade().getAssociationEnds(parent).size() > 0)//1
{ 

//#if -1631524701 
list.add(new AssociationsNode(parent));
//#endif 

} 

//#endif 


//#if 839282418 
if(Model.getFacade().getOperations(parent).size() > 0)//1
{ 

//#if -406910000 
list.add(new OperationsNode(parent));
//#endif 

} 

//#endif 


//#if -776016055 
if(hasIncomingDependencies(parent))//1
{ 

//#if 1441421550 
list.add(new IncomingDependencyNode(parent));
//#endif 

} 

//#endif 


//#if 232499311 
if(hasOutGoingDependencies(parent))//1
{ 

//#if 311605102 
list.add(new OutgoingDependencyNode(parent));
//#endif 

} 

//#endif 


//#if -501580466 
if(hasInheritance(parent))//1
{ 

//#if 535847883 
list.add(new InheritanceNode(parent));
//#endif 

} 

//#endif 


//#if 1111651361 
return list;
//#endif 

} 

//#endif 


//#if 1691233129 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 240211643 
private boolean hasOutGoingDependencies(Object parent)
    { 

//#if 332638299 
Iterator incomingIt =
            Model.getFacade().getClientDependencies(parent).iterator();
//#endif 


//#if 1317521516 
while (incomingIt.hasNext()) //1
{ 

//#if -49623361 
if(!Model.getFacade().isAAbstraction(incomingIt.next()))//1
{ 

//#if -268160407 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -113520572 
return false;
//#endif 

} 

//#endif 


//#if 411850245 
public Set getDependencies(Object parent)
    { 

//#if -427381875 
if(Model.getFacade().isAClass(parent))//1
{ 

//#if -369606181 
Set set = new HashSet();
//#endif 


//#if 228436225 
set.add(parent);
//#endif 


//#if 1689612650 
set.addAll(Model.getFacade().getAttributes(parent));
//#endif 


//#if -1618859585 
set.addAll(Model.getFacade().getOperations(parent));
//#endif 


//#if 518998872 
set.addAll(Model.getFacade().getAssociationEnds(parent));
//#endif 


//#if 793016104 
set.addAll(Model.getFacade().getSupplierDependencies(parent));
//#endif 


//#if -1116200345 
set.addAll(Model.getFacade().getClientDependencies(parent));
//#endif 


//#if -1093329866 
set.addAll(Model.getFacade().getGeneralizations(parent));
//#endif 


//#if -1426103865 
set.addAll(Model.getFacade().getSpecializations(parent));
//#endif 


//#if 1165397435 
return set;
//#endif 

} 

//#endif 


//#if -100245196 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1719553813 
private boolean hasIncomingDependencies(Object parent)
    { 

//#if 789445641 
Iterator incomingIt =
            Model.getFacade().getSupplierDependencies(parent).iterator();
//#endif 


//#if 909378521 
while (incomingIt.hasNext()) //1
{ 

//#if -269257708 
if(!Model.getFacade().isAAbstraction(incomingIt.next()))//1
{ 

//#if 740666401 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1689713905 
return false;
//#endif 

} 

//#endif 


//#if 276420605 
public String getRuleName()
    { 

//#if -229005839 
return Translator.localize("misc.class.summary");
//#endif 

} 

//#endif 


//#if -1400739500 
private boolean hasInheritance(Object parent)
    { 

//#if -403239821 
Iterator incomingIt =
            Model.getFacade().getSupplierDependencies(parent).iterator();
//#endif 


//#if -644301448 
Iterator outgoingIt =
            Model.getFacade().getClientDependencies(parent).iterator();
//#endif 


//#if 1873902868 
Iterator generalizationsIt =
            Model.getFacade().getGeneralizations(parent).iterator();
//#endif 


//#if 419836916 
Iterator specializationsIt =
            Model.getFacade().getSpecializations(parent).iterator();
//#endif 


//#if 647638642 
if(generalizationsIt.hasNext())//1
{ 

//#if -1548882961 
return true;
//#endif 

} 

//#endif 


//#if -811318461 
if(specializationsIt.hasNext())//1
{ 

//#if 1407560167 
return true;
//#endif 

} 

//#endif 


//#if 1204249283 
while (incomingIt.hasNext()) //1
{ 

//#if -1809387499 
if(Model.getFacade().isAAbstraction(incomingIt.next()))//1
{ 

//#if -1947761186 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1870048759 
while (outgoingIt.hasNext()) //1
{ 

//#if 209470416 
if(Model.getFacade().isAAbstraction(outgoingIt.next()))//1
{ 

//#if -1737497607 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 991765083 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

