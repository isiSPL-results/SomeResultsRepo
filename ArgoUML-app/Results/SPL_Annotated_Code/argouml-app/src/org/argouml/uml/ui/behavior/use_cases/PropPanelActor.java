// Compilation Unit of /PropPanelActor.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
public class PropPanelActor extends PropPanelClassifier
  { 
private static final long serialVersionUID = 7368183497864490115L;
public PropPanelActor()
    { 
super("label.actor", lookupIcon("Actor"));
addField("label.name", getNameTextField());
addField("label.namespace", getNamespaceSelector());
add(getModifiersPanel());
addSeparator();
addField("label.generalizations", getGeneralizationScroll());
addField("label.specializations", getSpecializationScroll());
addSeparator();
addField("label.association-ends", getAssociationEndScroll());
addAction(new ActionNavigateContainerElement());
addAction(new ActionNewActor());
addAction(getActionNewReception());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

 } 


