// Compilation Unit of /ActionAddMessagePredecessor.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
public class ActionAddMessagePredecessor extends AbstractActionAddModelElement2
  { 
private static final ActionAddMessagePredecessor SINGLETON =
        new ActionAddMessagePredecessor();
protected List getChoices()
    { 
if(getTarget() == null)//1
{ 
return Collections.EMPTY_LIST;
} 

List vec = new ArrayList();
vec.addAll(Model.getCollaborationsHelper()
                   .getAllPossiblePredecessors(getTarget()));
return vec;
} 

protected String getDialogTitle()
    { 
return Translator.localize("dialog.add-predecessors");
} 

public static ActionAddMessagePredecessor getInstance()
    { 
return SINGLETON;
} 

protected void doIt(Collection selected)
    { 
if(getTarget() == null)//1
{ 
throw new IllegalStateException(
                "doIt may not be called with null target");
} 

Object message = getTarget();
Model.getCollaborationsHelper().setPredecessors(message, selected);
} 

protected List getSelected()
    { 
if(getTarget() == null)//1
{ 
throw new IllegalStateException(
                "getSelected may not be called with null target");
} 

List vec = new ArrayList();
vec.addAll(Model.getFacade().getPredecessors(getTarget()));
return vec;
} 

protected ActionAddMessagePredecessor()
    { 
super();
} 

 } 


