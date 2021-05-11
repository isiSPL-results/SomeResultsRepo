
//#if 259779845 
// Compilation Unit of /ModeChangeHeight.java 
 

//#if 1253580412 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -1907258759 
import java.awt.Color;
//#endif 


//#if 118507055 
import java.awt.Graphics;
//#endif 


//#if -332610383 
import java.awt.event.MouseEvent;
//#endif 


//#if -1998726762 
import org.tigris.gef.base.Editor;
//#endif 


//#if -568839044 
import org.tigris.gef.base.FigModifyingModeImpl;
//#endif 


//#if 319458531 
import org.tigris.gef.base.Globals;
//#endif 


//#if 308279465 
import org.argouml.i18n.Translator;
//#endif 


//#if 1643504819 
public class ModeChangeHeight extends 
//#if 590321042 
FigModifyingModeImpl
//#endif 

  { 

//#if -1377519559 
private boolean contract;
//#endif 


//#if 728146811 
private boolean contractSet;
//#endif 


//#if -1163477787 
private int startX, startY, currentY;
//#endif 


//#if -2120830135 
private Editor editor;
//#endif 


//#if 774751176 
private Color rubberbandColor;
//#endif 


//#if 26483789 
private static final long serialVersionUID = 2383958235268066102L;
//#endif 


//#if 580563662 
public void mouseReleased(MouseEvent me)
    { 

//#if -1848056751 
if(me.isConsumed())//1
{ 

//#if -1500055071 
return;
//#endif 

} 

//#endif 


//#if -1468888844 
SequenceDiagramLayer layer =
            (SequenceDiagramLayer) Globals.curEditor().getLayerManager()
            .getActiveLayer();
//#endif 


//#if 200687100 
int endY = me.getY();
//#endif 


//#if 2001969765 
if(isContract())//1
{ 

//#if -1301899898 
int startOffset = layer.getNodeIndex(startY);
//#endif 


//#if 1023885657 
int endOffset;
//#endif 


//#if 1689637349 
if(startY > endY)//1
{ 

//#if -857896933 
endOffset = startOffset;
//#endif 


//#if 1589652083 
startOffset = layer.getNodeIndex(endY);
//#endif 

} 
else
{ 

//#if -1157999242 
endOffset = layer.getNodeIndex(endY);
//#endif 

} 

//#endif 


//#if -440833775 
int diff = endOffset - startOffset;
//#endif 


//#if 990499047 
if(diff > 0)//1
{ 

//#if 646913536 
layer.contractDiagram(startOffset, diff);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1704658540 
int startOffset = layer.getNodeIndex(startY);
//#endif 


//#if 21280440 
if(startOffset > 0 && endY < startY)//1
{ 

//#if 1827653490 
startOffset--;
//#endif 

} 

//#endif 


//#if -1976784121 
int diff = layer.getNodeIndex(endY) - startOffset;
//#endif 


//#if -289790717 
if(diff < 0)//1
{ 

//#if -356354798 
diff = -diff;
//#endif 

} 

//#endif 


//#if -232532415 
if(diff > 0)//1
{ 

//#if -1681334812 
layer.expandDiagram(startOffset, diff);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1815895049 
me.consume();
//#endif 


//#if 257396845 
done();
//#endif 

} 

//#endif 


//#if 1302078079 
public void paint(Graphics g)
    { 

//#if -944767910 
g.setColor(rubberbandColor);
//#endif 


//#if -2041412918 
g.drawLine(startX, startY, startX, currentY);
//#endif 

} 

//#endif 


//#if 631061901 
private boolean isContract()
    { 

//#if 1512987446 
if(!contractSet)//1
{ 

//#if 1739186137 
contract = getArg("name").equals("button.sequence-contract");
//#endif 


//#if -616575657 
contractSet = true;
//#endif 

} 

//#endif 


//#if -977751667 
return contract;
//#endif 

} 

//#endif 


//#if -417838311 
public void mousePressed(MouseEvent me)
    { 

//#if 661637970 
if(me.isConsumed())//1
{ 

//#if -1580642688 
return;
//#endif 

} 

//#endif 


//#if 1471363003 
startY = me.getY();
//#endif 


//#if 1342250493 
startX = me.getX();
//#endif 


//#if 1131858756 
start();
//#endif 


//#if -2085462040 
me.consume();
//#endif 

} 

//#endif 


//#if 302196011 
public String instructions()
    { 

//#if -1741930822 
if(isContract())//1
{ 

//#if -1955996530 
return Translator.localize("action.sequence-contract");
//#endif 

} 

//#endif 


//#if -358866859 
return Translator.localize("action.sequence-expand");
//#endif 

} 

//#endif 


//#if -552711377 
public ModeChangeHeight()
    { 

//#if 115518051 
contractSet = false;
//#endif 


//#if 2036110941 
editor = Globals.curEditor();
//#endif 


//#if 341168474 
rubberbandColor = Globals.getPrefs().getRubberbandColor();
//#endif 

} 

//#endif 


//#if 443957385 
public void mouseDragged(MouseEvent me)
    { 

//#if -1771707596 
if(me.isConsumed())//1
{ 

//#if 1997565140 
return;
//#endif 

} 

//#endif 


//#if 558390448 
currentY = me.getY();
//#endif 


//#if -611907173 
editor.damageAll();
//#endif 


//#if -924745274 
me.consume();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

