// Compilation Unit of /SelectionClassifierRole.java 
 
package org.argouml.uml.diagram.collaboration.ui;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Mode;
import org.tigris.gef.base.ModeManager;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.Handle;
public class SelectionClassifierRole extends SelectionNodeClarifiers2
  { 
private static Icon assocrole =
        ResourceLoaderWrapper
        .lookupIconResource("AssociationRole");
private static Icon selfassoc =
        ResourceLoaderWrapper
        .lookupIconResource("SelfAssociation");
private static Icon icons[] = {
        null,
        null,
        assocrole,
        assocrole,
        selfassoc,
    };
private static String instructions[] = {
        null,
        null,
        "Add an outgoing classifierrole",
        "Add an incoming classifierrole",
        "Add a associationrole to this",
        "Move object(s)",
    };
private boolean showIncoming = true;
private boolean showOutgoing = true;
@Override
    public void dragHandle(int mx, int my, int anX, int anY, Handle hand)
    { 
super.dragHandle(mx, my, anX, anY, hand);
Editor curEditor = Globals.curEditor();
ModeManager modeManager = curEditor.getModeManager();
Mode mode = modeManager.top();
mode.setArg("unidirectional", true);
} 

public void setIncomingButtonEnabled(boolean b)
    { 
showIncoming = b;
} 

@Override
    protected Object getNewEdgeType(int index)
    { 
Editor curEditor = Globals.curEditor();
ModeManager modeManager = curEditor.getModeManager();
Mode mode = modeManager.top();
mode.setArg("unidirectional", true);
return Model.getMetaTypes().getAssociationRole();
} 

@Override
    protected Object getNewNodeType(int index)
    { 
return Model.getMetaTypes().getClassifierRole();
} 

@Override
    protected Object getNewNode(int index)
    { 
return Model.getCollaborationsFactory().createClassifierRole();
} 

@Override
    protected Icon[] getIcons()
    { 
Icon workingIcons[] = new Icon[icons.length];
System.arraycopy(icons, 0, workingIcons, 0, icons.length);
if(!showIncoming)//1
{ 
workingIcons[BASE - LEFT] = null;
} 

if(!showOutgoing)//1
{ 
workingIcons[BASE - RIGHT] = null;
} 

if(!showOutgoing && !showIncoming)//1
{ 
workingIcons[BASE - LOWER_LEFT] = null;
} 

return workingIcons;
} 

public void setOutgoingButtonEnabled(boolean b)
    { 
showOutgoing = b;
} 

@Override
    protected String getInstructions(int index)
    { 
return instructions[index - BASE];
} 

public SelectionClassifierRole(Fig f)
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

 } 


