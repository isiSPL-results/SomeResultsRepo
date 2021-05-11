// Compilation Unit of /SelectionState.java 
 
package org.argouml.uml.diagram.state.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionState extends SelectionNodeClarifiers2
  { 
private static Icon trans =
        ResourceLoaderWrapper.lookupIconResource("Transition");
private static Icon icons[] = {
        null,
        null,
        trans,
        trans,
        null,
    };
private static String instructions[] = {
        null,
        null,
        "Add an outgoing transition",
        "Add an incoming transition",
        null,
        "Move object(s)",
    };
private boolean showIncoming = true;
private boolean showOutgoing = true;
public SelectionState(Fig f)
    { 
super(f);
} 

@Override
    protected boolean isReverseEdge(int index)
    { 
if(index == LEFT)//1
{ 
return true;
} 

return false;
} 

public void setOutgoingButtonEnabled(boolean b)
    { 
showOutgoing = b;
} 

@Override
    protected Object getNewEdgeType(int index)
    { 
return Model.getMetaTypes().getTransition();
} 

public void setIncomingButtonEnabled(boolean b)
    { 
showIncoming = b;
} 

@Override
    protected Icon[] getIcons()
    { 
Icon workingIcons[] = new Icon[icons.length];
System.arraycopy(icons, 0, workingIcons, 0, icons.length);
if(!showOutgoing)//1
{ 
workingIcons[RIGHT - BASE] = null;
} 

if(!showIncoming)//1
{ 
workingIcons[LEFT - BASE] = null;
} 

return workingIcons;
} 

@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 

@Override
    protected Object getNewNodeType(int index)
    { 
return Model.getMetaTypes().getSimpleState();
} 

@Override
    protected Object getNewNode(int index)
    { 
return Model.getStateMachinesFactory().createSimpleState();
} 

 } 


