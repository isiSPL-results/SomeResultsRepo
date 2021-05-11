// Compilation Unit of /PropPanelAssociationEndRole.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import org.argouml.i18n.Translator;
import org.argouml.uml.ui.foundation.core.PropPanelAssociationEnd;
public class PropPanelAssociationEndRole extends PropPanelAssociationEnd
  { 
@Override
    protected void positionControls()
    { 
addField(Translator.localize("label.base"),
                 getSingleRowScroll(new UMLAssociationEndRoleBaseListModel()));
super.positionControls();
} 

public PropPanelAssociationEndRole()
    { 
super("label.association-end-role", lookupIcon("AssociationEndRole"));
setAssociationLabel(Translator.localize("label.association-role"));
createControls();
positionStandardControls();
positionControls();
} 

 } 


