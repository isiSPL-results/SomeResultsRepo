package org.argouml.uml.diagram.sequence.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.FigModifyingModeImpl;
import org.tigris.gef.base.Globals;
import org.argouml.i18n.Translator;
public class ModeChangeHeight extends FigModifyingModeImpl
  { 
private boolean contract;
private boolean contractSet;
private int startX, startY, currentY;
private Editor editor;
private Color rubberbandColor;
private static final long serialVersionUID = 2383958235268066102L;
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
if(isContract())//1
{ 
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
} 
else
{ 
int startOffset = layer.getNodeIndex(startY);
if(startOffset > 0 && endY < startY)//1
{ 
startOffset--;
} 
int diff = layer.getNodeIndex(endY) - startOffset;
if(diff < 0)//1
{ 
diff = -diff;
} 
if(diff > 0)//1
{ 
layer.expandDiagram(startOffset, diff);
} 
} 
me.consume();
done();
} 
public void paint(Graphics g)
    { 
g.setColor(rubberbandColor);
g.drawLine(startX, startY, startX, currentY);
} 
private boolean isContract()
    { 
if(!contractSet)//1
{ 
contract = getArg("name").equals("button.sequence-contract");
contractSet = true;
} 
return contract;
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
public String instructions()
    { 
if(isContract())//1
{ 
return Translator.localize("action.sequence-contract");
} 
return Translator.localize("action.sequence-expand");
} 
public ModeChangeHeight()
    { 
contractSet = false;
editor = Globals.curEditor();
rubberbandColor = Globals.getPrefs().getRubberbandColor();
} 
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

 } 
