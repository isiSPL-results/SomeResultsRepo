// Compilation Unit of /ModeContract.java 
 
package org.argouml.uml.diagram.sequence.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.FigModifyingModeImpl;
import org.tigris.gef.base.Globals;
import org.argouml.i18n.Translator;
public class ModeContract extends FigModifyingModeImpl
  { 
private int startX, startY, currentY;
private Editor editor;
private Color rubberbandColor;
public void mouseDragged(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 

currentY = me.getY();
editor.damageAll();
me.consume();
} 

public void mousePressed(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 

startY = me.getY();
startX = me.getX();
start();
me.consume();
} 

public ModeContract()
    { 
editor = Globals.curEditor();
rubberbandColor = Globals.getPrefs().getRubberbandColor();
} 

public void paint(Graphics g)
    { 
g.setColor(rubberbandColor);
g.drawLine(startX, startY, startX, currentY);
} 

public void mouseReleased(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 

SequenceDiagramLayer layer =
            (SequenceDiagramLayer) Globals.curEditor().getLayerManager()
            .getActiveLayer();
int endY = me.getY();
int startOffset = layer.getNodeIndex(startY);
int endOffset;
if(startY > endY)//1
{ 
endOffset = startOffset;
startOffset = layer.getNodeIndex(endY);
} 
else
{ 
endOffset = layer.getNodeIndex(endY);
} 

int diff = endOffset - startOffset;
if(diff > 0)//1
{ 
layer.contractDiagram(startOffset, diff);
} 

me.consume();
done();
} 

public String instructions()
    { 
return Translator.localize("action.sequence-contract");
} 

 } 


