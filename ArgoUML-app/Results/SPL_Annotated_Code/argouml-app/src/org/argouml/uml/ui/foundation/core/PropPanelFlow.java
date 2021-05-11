// Compilation Unit of /PropPanelFlow.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.i18n.Translator;
public class PropPanelFlow extends PropPanelRelationship
  { 
private static final long serialVersionUID = 2967789232647658450L;
public PropPanelFlow()
    { 
super("label.flow", lookupIcon("Flow"));
initialize();
} 

private void initialize()
    { 
addField(Translator.localize("label.name"), getNameTextField());
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
addField(Translator.localize("label.constraints"),
                 getConstraintScroll());
addSeparator();
} 

 } 


