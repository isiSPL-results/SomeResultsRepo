
//#if -1788554172 
// Compilation Unit of /SelectionState.java 
 

//#if 72105661 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if -1291992246 
import javax.swing.Icon;
//#endif 


//#if -1415408163 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1725595236 
import org.argouml.model.Model;
//#endif 


//#if -739169997 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 1057363035 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 411531145 
public class SelectionState extends 
//#if 780479491 
SelectionNodeClarifiers2
//#endif 

  { 

//#if -717980100 
private static Icon trans =
        ResourceLoaderWrapper.lookupIconResource("Transition");
//#endif 


//#if -406302920 
private static Icon icons[] = {
        null,
        null,
        trans,
        trans,
        null,
    };
//#endif 


//#if -148267651 
private static String instructions[] = {
        null,
        null,
        "Add an outgoing transition",
        "Add an incoming transition",
        null,
        "Move object(s)",
    };
//#endif 


//#if 2136635115 
private boolean showIncoming = true;
//#endif 


//#if 341550513 
private boolean showOutgoing = true;
//#endif 


//#if -1832933440 
public SelectionState(Fig f)
    { 

//#if 785838049 
super(f);
//#endif 

} 

//#endif 


//#if 1919951360 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1331944088 
if(index == LEFT)//1
{ 

//#if -680768434 
return true;
//#endif 

} 

//#endif 


//#if -1434050150 
return false;
//#endif 

} 

//#endif 


//#if 125305976 
public void setOutgoingButtonEnabled(boolean b)
    { 

//#if -2031774298 
showOutgoing = b;
//#endif 

} 

//#endif 


//#if 1807914355 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if 245908152 
return Model.getMetaTypes().getTransition();
//#endif 

} 

//#endif 


//#if -622686594 
public void setIncomingButtonEnabled(boolean b)
    { 

//#if -104055233 
showIncoming = b;
//#endif 

} 

//#endif 


//#if -332760011 
@Override
    protected Icon[] getIcons()
    { 

//#if -136422784 
Icon workingIcons[] = new Icon[icons.length];
//#endif 


//#if -1964111625 
System.arraycopy(icons, 0, workingIcons, 0, icons.length);
//#endif 


//#if -1295887526 
if(!showOutgoing)//1
{ 

//#if -761919207 
workingIcons[RIGHT - BASE] = null;
//#endif 

} 

//#endif 


//#if 198716180 
if(!showIncoming)//1
{ 

//#if -2002921784 
workingIcons[LEFT - BASE] = null;
//#endif 

} 

//#endif 


//#if -61540497 
return workingIcons;
//#endif 

} 

//#endif 


//#if 690280179 
@Override
    protected String getInstructions(int index)
    { 

//#if 10060828 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if 662337784 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if 724653001 
return Model.getMetaTypes().getSimpleState();
//#endif 

} 

//#endif 


//#if 1635180062 
@Override
    protected Object getNewNode(int index)
    { 

//#if -1985047938 
return Model.getStateMachinesFactory().createSimpleState();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

