// Compilation Unit of /ActionAddAssociationRole.java 
 
package org.argouml.uml.diagram.ui;
import javax.swing.Action;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.tigris.gef.base.ModeCreatePolyEdge;
public class ActionAddAssociationRole extends ActionSetMode
  { 
private static final long serialVersionUID = -2842826831538374107L;
public ActionAddAssociationRole(Object aggregationKind,
                                    boolean unidirectional,
                                    String name)
    { 
super(ModeCreatePolyEdge.class,
              "edgeClass",
              Model.getMetaTypes().getAssociationRole(),
              name);
modeArgs.put("aggregation", aggregationKind);
modeArgs.put("unidirectional", Boolean.valueOf(unidirectional));
} 

public ActionAddAssociationRole(Object aggregationKind,
                                    boolean unidirectional,
                                    String name,
                                    String iconName)
    { 
super(ModeCreatePolyEdge.class,
              "edgeClass",
              Model.getMetaTypes().getAssociationRole(),
              name);
modeArgs.put("aggregation", aggregationKind);
modeArgs.put("unidirectional", Boolean.valueOf(unidirectional));
Icon icon = ResourceLoaderWrapper.lookupIconResource(iconName,
                    iconName);
if(icon != null)//1
{ 
putValue(Action.SMALL_ICON, icon);
} 

} 

 } 


