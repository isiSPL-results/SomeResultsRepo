
//#if 263802594 
// Compilation Unit of /ActionAddAssociationRole.java 
 

//#if 1643728980 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1898459507 
import javax.swing.Action;
//#endif 


//#if 1694273296 
import javax.swing.Icon;
//#endif 


//#if -931410473 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 31066078 
import org.argouml.model.Model;
//#endif 


//#if 193350988 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if -1385431690 
public class ActionAddAssociationRole extends 
//#if 1265617160 
ActionSetMode
//#endif 

  { 

//#if -302266897 
private static final long serialVersionUID = -2842826831538374107L;
//#endif 


//#if -1444160318 
public ActionAddAssociationRole(Object aggregationKind,
                                    boolean unidirectional,
                                    String name)
    { 

//#if -944815922 
super(ModeCreatePolyEdge.class,
              "edgeClass",
              Model.getMetaTypes().getAssociationRole(),
              name);
//#endif 


//#if -1805262922 
modeArgs.put("aggregation", aggregationKind);
//#endif 


//#if 1178362717 
modeArgs.put("unidirectional", Boolean.valueOf(unidirectional));
//#endif 

} 

//#endif 


//#if -1687041649 
public ActionAddAssociationRole(Object aggregationKind,
                                    boolean unidirectional,
                                    String name,
                                    String iconName)
    { 

//#if 1471517195 
super(ModeCreatePolyEdge.class,
              "edgeClass",
              Model.getMetaTypes().getAssociationRole(),
              name);
//#endif 


//#if -844945383 
modeArgs.put("aggregation", aggregationKind);
//#endif 


//#if -1715469798 
modeArgs.put("unidirectional", Boolean.valueOf(unidirectional));
//#endif 


//#if -163507748 
Icon icon = ResourceLoaderWrapper.lookupIconResource(iconName,
                    iconName);
//#endif 


//#if 1449815661 
if(icon != null)//1
{ 

//#if -1173104313 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

