// Compilation Unit of /SelectionActionState.java 
 
package org.argouml.uml.diagram.activity.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
public class SelectionActionState extends SelectionNodeClarifiers2
  { 
private static Icon trans =
        ResourceLoaderWrapper.lookupIconResource("Transition");
private static Icon transDown =
        ResourceLoaderWrapper.lookupIconResource("TransitionDown");
private static Icon icons[] = {
        transDown,
        transDown,
        trans,
        trans,
        null,
    };
private static String instructions[] = {
        "Add an incoming transition",
        "Add an outgoing transition",
        "Add an incoming transition",
        "Add an outgoing transition",
        null,
        "Move object(s)",
    };
private boolean showIncomingLeft = true;
private boolean showIncomingAbove = true;
private boolean showOutgoingRight = true;
private boolean showOutgoingBelow = true;
@Override
    protected Icon[] getIcons()
    { 
Icon[] workingIcons = new Icon[icons.length];
System.arraycopy(icons, 0, workingIcons, 0, icons.length);
if(!showOutgoingBelow)//1
{ 
workingIcons[BOTTOM - BASE] = null;
} 

if(!showIncomingAbove)//1
{ 
workingIcons[TOP - BASE] = null;
} 

if(!showIncomingLeft)//1
{ 
workingIcons[LEFT - BASE] = null;
} 

if(!showOutgoingRight)//1
{ 
workingIcons[RIGHT - BASE] = null;
} 

return workingIcons;
} 

@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 

public void setIncomingLeftButtonEnabled(boolean b)
    { 
showIncomingLeft = b;
} 

public void setOutgoingBelowButtonEnabled(boolean b)
    { 
showOutgoingBelow = b;
} 

@Override
    protected Object getNewNodeType(int index)
    { 
return Model.getMetaTypes().getActionState();
} 

public void setOutgoingButtonEnabled(boolean b)
    { 
setOutgoingRightButtonEnabled(b);
setOutgoingBelowButtonEnabled(b);
} 

public SelectionActionState(Fig f)
    { 
super(f);
} 

@Override
    protected boolean isReverseEdge(int index)
    { 
if(index == TOP || index == LEFT)//1
{ 
return true;
} 

return false;
} 

@Override
    protected Object getNewEdgeType(int index)
    { 
return Model.getMetaTypes().getTransition();
} 

public void setIncomingAboveButtonEnabled(boolean b)
    { 
showIncomingAbove = b;
} 

public void setIncomingButtonEnabled(boolean b)
    { 
setIncomingAboveButtonEnabled(b);
setIncomingLeftButtonEnabled(b);
} 

@Override
    protected Object getNewNode(int arg0)
    { 
return Model.getActivityGraphsFactory().createActionState();
} 

public void setOutgoingRightButtonEnabled(boolean b)
    { 
showOutgoingRight = b;
} 

 } 


