
//#if -1903039824 
// Compilation Unit of /SelectionClassifierRole.java 
 

//#if 1390964054 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -148940807 
import javax.swing.Icon;
//#endif 


//#if 1476304420 
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
//#endif 


//#if -1681871924 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1995754462 
import org.tigris.gef.presentation.Handle;
//#endif 


//#if -1079037392 
public class SelectionClassifierRole extends 
//#if 1737680982 
SelectionNodeClarifiers2
//#endif 

  { 

//#if -68799759 
@Override
    protected Object getNewNode(int index)
    { 

//#if 425493169 
return null;
//#endif 

} 

//#endif 


//#if 773039443 
public SelectionClassifierRole(Fig f)
    { 

//#if 220208713 
super(f);
//#endif 

} 

//#endif 


//#if -502970170 
@Override
    protected Object getNewEdgeType(int index)
    { 

//#if -1201387765 
return null;
//#endif 

} 

//#endif 


//#if 845360328 
@Override
    protected Icon[] getIcons()
    { 

//#if -408001353 
return null;
//#endif 

} 

//#endif 


//#if -1648546741 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if 550127153 
return null;
//#endif 

} 

//#endif 


//#if 330630759 
public void dragHandle(int mX, int mY, int anX, int anY, Handle hand)
    { 

//#if 1824943176 
if(!getContent().isResizable())//1
{ 

//#if -1899635773 
return;
//#endif 

} 

//#endif 


//#if -809185760 
switch (hand.index) //1
{ 
case Handle.NORTHWEST ://1

case Handle.NORTH ://1

case Handle.NORTHEAST ://1


//#if 689249060 
return;
//#endif 


default://1

} 

//#endif 


//#if 611478280 
super.dragHandle(mX, mY, anX, anY, hand);
//#endif 

} 

//#endif 


//#if 2067303936 
@Override
    protected String getInstructions(int index)
    { 

//#if -54017920 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

