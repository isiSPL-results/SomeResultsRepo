
//#if 293216134 
// Compilation Unit of /SelectionActionState.java 
 

//#if -1221883431 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if 1634057390 
import javax.swing.Icon;
//#endif 


//#if 540502777 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1624380288 
import org.argouml.model.Model;
//#endif 


//#if -89090737 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if 327657079 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 688895575 
public class SelectionActionState extends 
//#if 501060773 
SelectionNodeClarifiers2
//#endif 

  { 

//#if 1015863646 
private static Icon trans =
        ResourceLoaderWrapper.lookupIconResource("Transition");
//#endif 


//#if 917902494 
private static Icon transDown =
        ResourceLoaderWrapper.lookupIconResource("TransitionDown");
//#endif 


//#if -175483982 
private static Icon icons[] = {
        transDown,
        transDown,
        trans,
        trans,
        null,
    };
//#endif 


//#if -2029762025 
private static String instructions[] = {
        "Add an incoming transition",
        "Add an outgoing transition",
        "Add an incoming transition",
        "Add an outgoing transition",
        null,
        "Move object(s)",
    };
//#endif 


//#if -286043660 
private boolean showIncomingLeft = true;
//#endif 


//#if -1725237520 
private boolean showIncomingAbove = true;
//#endif 


//#if 668047145 
private boolean showOutgoingRight = true;
//#endif 


//#if 1670495614 
private boolean showOutgoingBelow = true;
//#endif 


//#if -1361444265 
@Override
    protected Icon[] getIcons()
    { 

//#if -2133381516 
Icon[] workingIcons = new Icon[icons.length];
//#endif 


//#if 909569603 
System.arraycopy(icons, 0, workingIcons, 0, icons.length);
//#endif 


//#if 1291990459 
if(!showOutgoingBelow)//1
{ 

//#if 1990511142 
workingIcons[BOTTOM - BASE] = null;
//#endif 

} 

//#endif 


//#if 1444881325 
if(!showIncomingAbove)//1
{ 

//#if -853637839 
workingIcons[TOP - BASE] = null;
//#endif 

} 

//#endif 


//#if -1380114425 
if(!showIncomingLeft)//1
{ 

//#if 229936637 
workingIcons[LEFT - BASE] = null;
//#endif 

} 

//#endif 


//#if 473071142 
if(!showOutgoingRight)//1
{ 

//#if 1011679961 
workingIcons[RIGHT - BASE] = null;
//#endif 

} 

//#endif 


//#if 425772451 
return workingIcons;
//#endif 

} 

//#endif 


//#if 572000401 
@Override
    protected String getInstructions(int index)
    { 

//#if 2005783331 
return instructions[index - BASE];
//#endif 

} 

//#endif 


//#if -1817162471 
public void setIncomingLeftButtonEnabled(boolean b)
    { 

//#if -1108795302 
showIncomingLeft = b;
//#endif 

} 

//#endif 


//#if -17995039 
public void setOutgoingBelowButtonEnabled(boolean b)
    { 

//#if 977649784 
showOutgoingBelow = b;
//#endif 

} 

//#endif 


//#if -726951014 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if 2005228204 
return Model.getMetaTypes().getActionState();
//#endif 

} 

//#endif 


//#if -145242086 
public void setOutgoingButtonEnabled(boolean b)
    { 

//#if 688099611 
setOutgoingRightButtonEnabled(b);
//#endif 


//#if 30118822 
setOutgoingBelowButtonEnabled(b);
//#endif 

} 

//#endif 


//#if -1977543092 
public SelectionActionState(Fig f)
    { 

//#if -2071790410 
super(f);
//#endif 

} 

//#endif 


//#if 530662562 
@Override
    protected boolean isReverseEdge(int index)
    { 

//#if -1483271864 
if(index == TOP || index == LEFT)//1
{ 

//#if 696700852 
return true;
//#endif 

} 

//#endif 


//#if -1237985315 
return false;
//#endif 

} 

//#endif 


//#if 418625557 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if -1949535757 
return Model.getMetaTypes().getTransition();
//#endif 

} 

//#endif 


//#if -1832647761 
public void setIncomingAboveButtonEnabled(boolean b)
    { 

//#if 1638770488 
showIncomingAbove = b;
//#endif 

} 

//#endif 


//#if -893234656 
public void setIncomingButtonEnabled(boolean b)
    { 

//#if -1857950753 
setIncomingAboveButtonEnabled(b);
//#endif 


//#if -817990445 
setIncomingLeftButtonEnabled(b);
//#endif 

} 

//#endif 


//#if -794531450 
@Override
    protected Object getNewNode(int arg0)
    { 

//#if -537681596 
return Model.getActivityGraphsFactory().createActionState();
//#endif 

} 

//#endif 


//#if 1454161046 
public void setOutgoingRightButtonEnabled(boolean b)
    { 

//#if -1421879958 
showOutgoingRight = b;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

