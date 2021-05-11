
//#if -1238828982 
// Compilation Unit of /SelectionClassifierRole.java 
 

//#if -2143293170 
package org.argouml.uml.diagram.collaboration.ui;
//#endif 


//#if -1019454707 
import javax.swing.Icon;
//#endif 


//#if 1718856698 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 651769153 
import org.argouml.model.Model;
//#endif 


//#if 1096491664 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 1687374596 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1375516363 
import org.tigris.gef.base.Globals;
//#endif 


//#if -48634098 
import org.tigris.gef.base.Mode;
//#endif 


//#if -1125998565 
import org.tigris.gef.base.ModeManager;
//#endif 


//#if -956129736 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1715909106 
import org.tigris.gef.presentation.Handle;
//#endif 


//#if -566019428 
public class SelectionClassifierRole extends 
//#if -506850054 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 1115624518 
private static Icon assocrole =
        ResourceLoaderWrapper
        .lookupIconResource("AssociationRole");
//#endif 


//#if -1077076726 
private static Icon selfassoc =
        ResourceLoaderWrapper
        .lookupIconResource("SelfAssociation");
//#endif 


//#if 645010269 
private static Icon icons[] = {
        null,
        null,
        assocrole,
        assocrole,
        selfassoc,
    };
//#endif 


//#if 1695911893 
private static String instructions[] = {
        null,
        null,
        "Add an outgoing classifierrole",
        "Add an incoming classifierrole",
        "Add a associationrole to this",
        "Move object(s)",
    };
//#endif 


//#if -1052870430 
private boolean showIncoming = true;
//#endif 


//#if 1447012264 
private boolean showOutgoing = true;
//#endif 


//#if -796199261 
@Override
    public void dragHandle(int mx, int my, int anX, int anY, Handle hand)
    { 

//#if 194059150 
super.dragHandle(mx, my, anX, anY, hand);
//#endif 


//#if 791284372 
Editor curEditor = Globals.curEditor();
//#endif 


//#if 409626964 
ModeManager modeManager = curEditor.getModeManager();
//#endif 


//#if 690762356 
Mode mode = modeManager.top();
//#endif 


//#if 95810577 
mode.setArg("unidirectional", true);
//#endif 

} 

//#endif 


//#if 171464181 
public void setIncomingButtonEnabled(boolean b)
    { 

//#if 1678088287 
showIncoming = b;
//#endif 

} 

//#endif 


//#if -479606422 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if 1689350882 
Editor curEditor = Globals.curEditor();
//#endif 


//#if 431370530 
ModeManager modeManager = curEditor.getModeManager();
//#endif 


//#if -1212835226 
Mode mode = modeManager.top();
//#endif 


//#if -1399240189 
mode.setArg("unidirectional", true);
//#endif 


//#if 381122137 
return Model.getMetaTypes().getAssociationRole();
//#endif 

} 

//#endif 


//#if -1625182993 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if -368775361 
return Model.getMetaTypes().getClassifierRole();
//#endif 

} 

//#endif 


//#if -1865636459 
@Override
    protected Object getNewNode(int index)
    { 

//#if -1719535392 
return Model.getCollaborationsFactory().createClassifierRole();
//#endif 

} 

//#endif 


//#if 1159060588 
@Override
    protected Icon[] getIcons()
    { 

//#if -586134396 
Icon workingIcons[] = new Icon[icons.length];
//#endif 


//#if -1922269837 
System.arraycopy(icons, 0, workingIcons, 0, icons.length);
//#endif 


//#if -1397850480 
if(!showIncoming)//1
{ 

//#if -97100203 
workingIcons[BASE - LEFT] = null;
//#endif 

} 

//#endif 


//#if 1402513110 
if(!showOutgoing)//1
{ 

//#if 146914968 
workingIcons[BASE - RIGHT] = null;
//#endif 

} 

//#endif 


//#if -2023831394 
if(!showOutgoing && !showIncoming)//1
{ 

//#if -849131123 
workingIcons[BASE - LOWER_LEFT] = null;
//#endif 

} 

//#endif 


//#if -1914157965 
return workingIcons;
//#endif 

} 

//#endif 


//#if 919456751 
public void setOutgoingButtonEnabled(boolean b)
    { 

//#if -1468679192 
showOutgoing = b;
//#endif 

} 

//#endif 


//#if -1503387172 
@Override
    protected String getInstructions(int index)
    { 

//#if 1073074052 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if 1907812911 
public SelectionClassifierRole(Fig f)
    { 

//#if 2118412285 
super(f);
//#endif 

} 

//#endif 


//#if -367569417 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1734431098 
if(index == LEFT)//1
{ 

//#if -1902002472 
return true;
//#endif 

} 

//#endif 


//#if 1156929848 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

