
//#if -1681517809 
// Compilation Unit of /ModeContract.java 
 

//#if 988232609 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -492105378 
import java.awt.Color;
//#endif 


//#if -446097110 
import java.awt.Graphics;
//#endif 


//#if 1957457068 
import java.awt.event.MouseEvent;
//#endif 


//#if 273887483 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1183172831 
import org.tigris.gef.base.FigModifyingModeImpl;
//#endif 


//#if 2051023390 
import org.tigris.gef.base.Globals;
//#endif 


//#if 2039844324 
import org.argouml.i18n.Translator;
//#endif 


//#if 286558323 
public class ModeContract extends 
//#if 420098483 
FigModifyingModeImpl
//#endif 

  { 

//#if -612327836 
private int startX, startY, currentY;
//#endif 


//#if 2003914602 
private Editor editor;
//#endif 


//#if 2055122665 
private Color rubberbandColor;
//#endif 


//#if 92175018 
public void mouseDragged(MouseEvent me)
    { 

//#if 1702445393 
if(me.isConsumed())//1
{ 

//#if -1654196578 
return;
//#endif 

} 

//#endif 


//#if 106822579 
currentY = me.getY();
//#endif 


//#if -1063475042 
editor.damageAll();
//#endif 


//#if -1706074359 
me.consume();
//#endif 

} 

//#endif 


//#if -769620678 
public void mousePressed(MouseEvent me)
    { 

//#if -1678812946 
if(me.isConsumed())//1
{ 

//#if 1200923193 
return;
//#endif 

} 

//#endif 


//#if -442460001 
startY = me.getY();
//#endif 


//#if -571572511 
startX = me.getX();
//#endif 


//#if 1663179232 
start();
//#endif 


//#if -1692675380 
me.consume();
//#endif 

} 

//#endif 


//#if -549166037 
public ModeContract()
    { 

//#if 1605762656 
editor = Globals.curEditor();
//#endif 


//#if -1067750345 
rubberbandColor = Globals.getPrefs().getRubberbandColor();
//#endif 

} 

//#endif 


//#if 364863968 
public void paint(Graphics g)
    { 

//#if -2016132408 
g.setColor(rubberbandColor);
//#endif 


//#if -758386504 
g.drawLine(startX, startY, startX, currentY);
//#endif 

} 

//#endif 


//#if -1734755123 
public void mouseReleased(MouseEvent me)
    { 

//#if 262563701 
if(me.isConsumed())//1
{ 

//#if -410912696 
return;
//#endif 

} 

//#endif 


//#if 545673808 
SequenceDiagramLayer layer =
            (SequenceDiagramLayer) Globals.curEditor().getLayerManager()
            .getActiveLayer();
//#endif 


//#if 1261105952 
int endY = me.getY();
//#endif 


//#if -2008252142 
int startOffset = layer.getNodeIndex(startY);
//#endif 


//#if -15340979 
int endOffset;
//#endif 


//#if 166633841 
if(startY > endY)//1
{ 

//#if -2086354761 
endOffset = startOffset;
//#endif 


//#if -1098570153 
startOffset = layer.getNodeIndex(endY);
//#endif 

} 
else
{ 

//#if -1740903849 
endOffset = layer.getNodeIndex(endY);
//#endif 

} 

//#endif 


//#if -656718179 
int diff = endOffset - startOffset;
//#endif 


//#if -48727589 
if(diff > 0)//1
{ 

//#if -305263389 
layer.contractDiagram(startOffset, diff);
//#endif 

} 

//#endif 


//#if 36438117 
me.consume();
//#endif 


//#if 696297929 
done();
//#endif 

} 

//#endif 


//#if -635018100 
public String instructions()
    { 

//#if 694711773 
return Translator.localize("action.sequence-contract");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

