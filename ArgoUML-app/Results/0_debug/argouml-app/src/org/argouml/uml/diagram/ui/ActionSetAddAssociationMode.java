
//#if 1318954001 
// Compilation Unit of /ActionSetAddAssociationMode.java 
 

//#if -1973462543 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1717004283 
import org.argouml.model.Model;
//#endif 


//#if -1104998513 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if -256647614 
public class ActionSetAddAssociationMode extends 
//#if 238170153 
ActionSetMode
//#endif 

  { 

//#if 1594568889 
private static final long serialVersionUID = -3869448253653259670L;
//#endif 


//#if 519230470 
public ActionSetAddAssociationMode(Object aggregationKind,
                                       boolean unidirectional,
                                       String name)
    { 

//#if -2007978169 
super(ModeCreatePolyEdge.class, "edgeClass",
              Model.getMetaTypes().getAssociation(), name);
//#endif 


//#if -1629878541 
modeArgs.put("aggregation", aggregationKind);
//#endif 


//#if -125767424 
modeArgs.put("unidirectional", Boolean.valueOf(unidirectional));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

