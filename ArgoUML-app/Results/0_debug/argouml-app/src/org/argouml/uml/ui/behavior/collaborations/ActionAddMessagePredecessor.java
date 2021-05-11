
//#if -514019800 
// Compilation Unit of /ActionAddMessagePredecessor.java 
 

//#if 227946905 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -1510181356 
import java.util.ArrayList;
//#endif 


//#if 1768616397 
import java.util.Collection;
//#endif 


//#if -1007464746 
import java.util.Collections;
//#endif 


//#if 175915981 
import java.util.List;
//#endif 


//#if 1038949694 
import org.argouml.i18n.Translator;
//#endif 


//#if -1491454204 
import org.argouml.model.Model;
//#endif 


//#if -762501646 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -1712670615 
public class ActionAddMessagePredecessor extends 
//#if 865913653 
AbstractActionAddModelElement2
//#endif 

  { 

//#if 145375154 
private static final ActionAddMessagePredecessor SINGLETON =
        new ActionAddMessagePredecessor();
//#endif 


//#if -315342166 
protected List getChoices()
    { 

//#if 142387055 
if(getTarget() == null)//1
{ 

//#if 1693709391 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -747193671 
List vec = new ArrayList();
//#endif 


//#if 77630858 
vec.addAll(Model.getCollaborationsHelper()
                   .getAllPossiblePredecessors(getTarget()));
//#endif 


//#if 1021485530 
return vec;
//#endif 

} 

//#endif 


//#if -1894521765 
protected String getDialogTitle()
    { 

//#if 2056698921 
return Translator.localize("dialog.add-predecessors");
//#endif 

} 

//#endif 


//#if 1963776789 
public static ActionAddMessagePredecessor getInstance()
    { 

//#if -1192594119 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -658523103 
protected void doIt(Collection selected)
    { 

//#if 852082765 
if(getTarget() == null)//1
{ 

//#if 1631392781 
throw new IllegalStateException(
                "doIt may not be called with null target");
//#endif 

} 

//#endif 


//#if -728931255 
Object message = getTarget();
//#endif 


//#if 994379215 
Model.getCollaborationsHelper().setPredecessors(message, selected);
//#endif 

} 

//#endif 


//#if 917457029 
protected List getSelected()
    { 

//#if -1659054876 
if(getTarget() == null)//1
{ 

//#if 1547251446 
throw new IllegalStateException(
                "getSelected may not be called with null target");
//#endif 

} 

//#endif 


//#if 303073956 
List vec = new ArrayList();
//#endif 


//#if 1651064403 
vec.addAll(Model.getFacade().getPredecessors(getTarget()));
//#endif 


//#if -669102065 
return vec;
//#endif 

} 

//#endif 


//#if -983727553 
protected ActionAddMessagePredecessor()
    { 

//#if -1023703948 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

