
//#if 504677972 
// Compilation Unit of /ModeExpand.java 
 

//#if 542166203 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if 319189496 
import java.awt.Color;
//#endif 


//#if 1058519632 
import java.awt.Graphics;
//#endif 


//#if 1280477138 
import java.awt.event.MouseEvent;
//#endif 


//#if 762346133 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1088312517 
import org.tigris.gef.base.FigModifyingModeImpl;
//#endif 


//#if 13372356 
import org.tigris.gef.base.Globals;
//#endif 


//#if 2193290 
import org.argouml.i18n.Translator;
//#endif 


//#if -789833003 
public class ModeExpand extends 
//#if -680896147 
FigModifyingModeImpl
//#endif 

  { 

//#if 1576817898 
private int startX, startY, currentY;
//#endif 


//#if 902919972 
private Editor editor;
//#endif 


//#if -8356701 
private Color rubberbandColor;
//#endif 


//#if -2145653148 
public void mouseDragged(MouseEvent me)
    { 

//#if -1088460838 
if(me.isConsumed())//1
{ 

//#if 2000633960 
return;
//#endif 

} 

//#endif 


//#if 531597770 
currentY = me.getY();
//#endif 


//#if -638699851 
editor.damageAll();
//#endif 


//#if -1156642208 
me.consume();
//#endif 

} 

//#endif 


//#if 1907015763 
public void mouseReleased(MouseEvent me)
    { 

//#if -946440470 
if(me.isConsumed())//1
{ 

//#if -1957455891 
return;
//#endif 

} 

//#endif 


//#if -2099010693 
SequenceDiagramLayer layer =
            (SequenceDiagramLayer) Globals.curEditor().getLayerManager()
            .getActiveLayer();
//#endif 


//#if 403637525 
int endY = me.getY();
//#endif 


//#if -1601747961 
int startOffset = layer.getNodeIndex(startY);
//#endif 


//#if -511791427 
if(startOffset > 0 && endY < startY)//1
{ 

//#if -172196336 
startOffset--;
//#endif 

} 

//#endif 


//#if 1942078348 
int diff = layer.getNodeIndex(endY) - startOffset;
//#endif 


//#if 871010696 
if(diff < 0)//1
{ 

//#if -516342137 
diff = -diff;
//#endif 

} 

//#endif 


//#if 928268998 
if(diff > 0)//1
{ 

//#if -1655375672 
layer.expandDiagram(startOffset, diff);
//#endif 

} 

//#endif 


//#if 1013434704 
me.consume();
//#endif 


//#if 181681908 
done();
//#endif 

} 

//#endif 


//#if -757835578 
public String instructions()
    { 

//#if 1765277158 
return Translator.localize("action.sequence-expand");
//#endif 

} 

//#endif 


//#if 1347912685 
public ModeExpand()
    { 

//#if -1741016275 
editor = Globals.curEditor();
//#endif 


//#if -1552341366 
rubberbandColor = Globals.getPrefs().getRubberbandColor();
//#endif 

} 

//#endif 


//#if 242046490 
public void paint(Graphics g)
    { 

//#if 1851710185 
g.setColor(rubberbandColor);
//#endif 


//#if 1546992409 
g.drawLine(startX, startY, startX, currentY);
//#endif 

} 

//#endif 


//#if 1287518452 
public void mousePressed(MouseEvent me)
    { 

//#if 340119535 
if(me.isConsumed())//1
{ 

//#if 890314321 
return;
//#endif 

} 

//#endif 


//#if -1335229186 
startY = me.getY();
//#endif 


//#if -1464341696 
startX = me.getX();
//#endif 


//#if 1004435105 
start();
//#endif 


//#if 521160363 
me.consume();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

