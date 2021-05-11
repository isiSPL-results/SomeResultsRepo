
//#if 853853643 
// Compilation Unit of /FigSingleLineText.java 
 

//#if 1879514756 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -551354665 
import java.awt.Dimension;
//#endif 


//#if 5422410 
import java.awt.Font;
//#endif 


//#if -565133330 
import java.awt.Rectangle;
//#endif 


//#if -1761372214 
import java.awt.event.KeyEvent;
//#endif 


//#if 1883667651 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1452862745 
import java.util.Arrays;
//#endif 


//#if 1355622029 
import javax.swing.SwingUtilities;
//#endif 


//#if -406371685 
import org.apache.log4j.Logger;
//#endif 


//#if 82287121 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -1298953843 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 1441164814 
import org.argouml.model.Model;
//#endif 


//#if 481323849 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1658930161 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -653380264 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -384793773 
public class FigSingleLineText extends 
//#if -2117257772 
ArgoFigText
//#endif 

  { 

//#if -1911906373 
private static final Logger LOG =
        Logger.getLogger(FigSingleLineText.class);
//#endif 


//#if -819827562 
private String[] properties;
//#endif 


//#if -1313347658 
public FigSingleLineText(Object owner, Rectangle bounds,
                             DiagramSettings settings, boolean expandOnly)
    { 

//#if 1156193700 
this(owner, bounds, settings, expandOnly, (String[]) null);
//#endif 

} 

//#endif 


//#if -1755491839 
public FigSingleLineText(Object owner, Rectangle bounds,
                             DiagramSettings settings, boolean expandOnly,
                             String[] allProperties)
    { 

//#if 2011077035 
super(owner, bounds, settings, expandOnly);
//#endif 


//#if 6590063 
initialize();
//#endif 


//#if 1191816092 
this.properties = allProperties;
//#endif 


//#if 1863591651 
addModelListener();
//#endif 

} 

//#endif 


//#if -1498161308 
private void initialize()
    { 

//#if 1407918529 
setFillColor(FILL_COLOR);
//#endif 


//#if -1828621297 
setFilled(false);
//#endif 


//#if -802414932 
setTabAction(FigText.END_EDITING);
//#endif 


//#if -410610105 
setReturnAction(FigText.END_EDITING);
//#endif 


//#if -462128852 
setLineWidth(0);
//#endif 


//#if -210132843 
setTextColor(TEXT_COLOR);
//#endif 

} 

//#endif 


//#if 1478681513 
@Override
    protected boolean isStartEditingKey(KeyEvent ke)
    { 

//#if 89636450 
if((ke.getModifiers()
                & (KeyEvent.META_MASK | KeyEvent.ALT_MASK)) == 0)//1
{ 

//#if 1868527331 
return super.isStartEditingKey(ke);
//#endif 

} 
else
{ 

//#if 1947542870 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1378752906 
public void renderingChanged()
    { 

//#if 1667018233 
super.renderingChanged();
//#endif 


//#if 741437041 
setText();
//#endif 

} 

//#endif 


//#if -2132584479 
@Override
    public void removeFromDiagram()
    { 

//#if -754221445 
if(getOwner() != null && properties != null)//1
{ 

//#if 827530862 
Model.getPump().removeModelEventListener(
                this,
                getOwner(),
                properties);
//#endif 

} 

//#endif 


//#if -1547508105 
super.removeFromDiagram();
//#endif 

} 

//#endif 


//#if -227512516 
protected void updateLayout(UmlChangeEvent event)
    { 

//#if -979480401 
assert event != null;
//#endif 


//#if 478225279 
if(getOwner() == event.getSource()
                && properties != null
                && Arrays.asList(properties).contains(event.getPropertyName())
                && event instanceof AttributeChangeEvent)//1
{ 

//#if 1584618398 
setText();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 351794800 
private void addModelListener()
    { 

//#if 338279138 
if(properties != null && getOwner() != null)//1
{ 

//#if -481270290 
Model.getPump().addModelEventListener(this, getOwner(), properties);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1300772508 

//#if -1795606910 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigSingleLineText(int x, int y, int w, int h, boolean expandOnly)
    { 

//#if 554108790 
super(x, y, w, h, expandOnly);
//#endif 


//#if -53919111 
initialize();
//#endif 

} 

//#endif 


//#if -1037243970 
public FigSingleLineText(Rectangle bounds,
                             DiagramSettings settings, boolean expandOnly)
    { 

//#if 1620731468 
this(null, bounds, settings, expandOnly);
//#endif 

} 

//#endif 


//#if 1553876746 
public FigSingleLineText(Object owner, Rectangle bounds,
                             DiagramSettings settings, boolean expandOnly, String property)
    { 

//#if 1056130475 
this(owner, bounds, settings, expandOnly, new String[] {property});
//#endif 

} 

//#endif 


//#if -1049260188 
@Deprecated
    public FigSingleLineText(int x, int y, int w, int h, boolean expandOnly,
                             String property)
    { 

//#if -907834514 
this(x, y, w, h, expandOnly, new String[] {property});
//#endif 

} 

//#endif 


//#if 311922639 
@Override
    public Dimension getMinimumSize()
    { 

//#if -1060350172 
Dimension d = new Dimension();
//#endif 


//#if -285916123 
Font font = getFont();
//#endif 


//#if -1671352294 
if(font == null)//1
{ 

//#if -2041914512 
return d;
//#endif 

} 

//#endif 


//#if 465327381 
int maxW = 0;
//#endif 


//#if 464880516 
int maxH = 0;
//#endif 


//#if -1711290486 
if(getFontMetrics() == null)//1
{ 

//#if -427805838 
maxH = font.getSize();
//#endif 

} 
else
{ 

//#if 1009748319 
maxH = getFontMetrics().getHeight();
//#endif 


//#if 1938836978 
maxW = getFontMetrics().stringWidth(getText());
//#endif 

} 

//#endif 


//#if 1360537198 
int overallH = (maxH + getTopMargin() + getBotMargin());
//#endif 


//#if 659523586 
int overallW = maxW + getLeftMargin() + getRightMargin();
//#endif 


//#if -183795487 
d.width = overallW;
//#endif 


//#if -441549501 
d.height = overallH;
//#endif 


//#if -217884042 
return d;
//#endif 

} 

//#endif 


//#if 1013895271 
@Deprecated
    public FigSingleLineText(int x, int y, int w, int h, boolean expandOnly,
                             String[] allProperties)
    { 

//#if 1051962244 
this(x, y, w, h, expandOnly);
//#endif 


//#if -1791029281 
this.properties = allProperties;
//#endif 

} 

//#endif 


//#if -1169242354 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 

//#if 1971046013 
if("remove".equals(pce.getPropertyName())
                && (pce.getSource() == getOwner()))//1
{ 

//#if 973095242 
deleteFromModel();
//#endif 

} 

//#endif 


//#if -1783481255 
if(pce instanceof UmlChangeEvent)//1
{ 

//#if -1665833237 
final UmlChangeEvent event = (UmlChangeEvent) pce;
//#endif 


//#if -1385552676 
Runnable doWorkRunnable = new Runnable() {
                public void run() {
                    try {
                        updateLayout(event);
                    } catch (InvalidElementException e) {



                        if (LOG.isDebugEnabled()) {
                            LOG.debug("event = "
                                      + event.getClass().getName());
                            LOG.debug("source = " + event.getSource());
                            LOG.debug("old = " + event.getOldValue());
                            LOG.debug("name = " + event.getPropertyName());
                            LOG.debug("updateLayout method accessed "
                                      + "deleted element ", e);
                        }

                    }
                }
            };
//#endif 


//#if -653611863 
SwingUtilities.invokeLater(doWorkRunnable);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1175043054 

//#if -551985632 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public void setOwner(Object owner)
    { 

//#if 1706765590 
super.setOwner(owner);
//#endif 


//#if 764707390 
if(owner != null && properties != null)//1
{ 

//#if -1561360884 
addModelListener();
//#endif 


//#if -1739090819 
setText();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2033022642 
protected void setText()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

