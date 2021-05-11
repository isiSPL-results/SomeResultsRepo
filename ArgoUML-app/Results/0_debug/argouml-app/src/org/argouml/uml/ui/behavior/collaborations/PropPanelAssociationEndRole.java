
//#if -866626197 
// Compilation Unit of /PropPanelAssociationEndRole.java 
 

//#if -963032274 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 943194323 
import org.argouml.i18n.Translator;
//#endif 


//#if 847590450 
import org.argouml.uml.ui.foundation.core.PropPanelAssociationEnd;
//#endif 


//#if 1573845378 
public class PropPanelAssociationEndRole extends 
//#if -1393158688 
PropPanelAssociationEnd
//#endif 

  { 

//#if 2008495185 
@Override
    protected void positionControls()
    { 

//#if 1901300325 
addField(Translator.localize("label.base"),
                 getSingleRowScroll(new UMLAssociationEndRoleBaseListModel()));
//#endif 


//#if 919839156 
super.positionControls();
//#endif 

} 

//#endif 


//#if -850932626 
public PropPanelAssociationEndRole()
    { 

//#if 1334940667 
super("label.association-end-role", lookupIcon("AssociationEndRole"));
//#endif 


//#if -1095547855 
setAssociationLabel(Translator.localize("label.association-role"));
//#endif 


//#if 2078929472 
createControls();
//#endif 


//#if -136163338 
positionStandardControls();
//#endif 


//#if 1782050291 
positionControls();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

