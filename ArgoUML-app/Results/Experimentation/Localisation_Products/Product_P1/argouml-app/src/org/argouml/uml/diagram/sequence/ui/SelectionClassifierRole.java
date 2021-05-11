package org.argouml.uml.diagram.sequence.ui;
import javax.swing.Icon;
import org.argouml.uml.diagram.ui.SelectionNodeClarifiers2;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.Handle;
public class SelectionClassifierRole extends SelectionNodeClarifiers2
  { 
@Override
    protected Object getNewNode(int index)
    { 
return null;
} 
public SelectionClassifierRole(Fig f)
    { 
super(f);
} 
@Override
    protected Object getNewEdgeType(int index)
    { 
return null;
} 
@Override
    protected Icon[] getIcons()
    { 
return null;
} 
@Override
    protected Object getNewNodeType(int index)
    { 
return null;
} 
public void dragHandle(int mX, int mY, int anX, int anY, Handle hand)
    { 
if(!getContent().isResizable())//1
{ 
return;
} 
switch (hand.index) //1
{ 
case Handle.NORTHWEST ://1

case Handle.NORTH ://1

case Handle.NORTHEAST ://1

return;

default://1

} 
super.dragHandle(mX, mY, anX, anY, hand);
} 
@Override
    protected String getInstructions(int index)
    { 
return null;
} 

 } 
