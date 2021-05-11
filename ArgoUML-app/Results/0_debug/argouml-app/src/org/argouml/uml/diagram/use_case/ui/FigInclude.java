
//#if -200127448 
// Compilation Unit of /FigInclude.java 
 

//#if 1166754226 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if 1402244864 
import java.awt.Graphics;
//#endif 


//#if -1369631044 
import java.awt.Rectangle;
//#endif 


//#if 2124601827 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1401835843 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if -464842582 
import org.argouml.uml.diagram.ui.FigSingleLineText;
//#endif 


//#if -1142220662 
import org.argouml.uml.diagram.ui.PathItemPlacement;
//#endif 


//#if 2045346538 
import org.tigris.gef.presentation.ArrowHeadGreater;
//#endif 


//#if 835478007 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2028247564 
public class FigInclude extends 
//#if 578950482 
FigEdgeModelElement
//#endif 

  { 

//#if -1772908972 
private static final long serialVersionUID = 6199364390483239154L;
//#endif 


//#if 765714355 
private FigSingleLineText label;
//#endif 


//#if 442218022 
private ArrowHeadGreater endArrow = new ArrowHeadGreater();
//#endif 


//#if -1116113784 
@Override
    public void setFig(Fig f)
    { 

//#if -19202260 
super.setFig(f);
//#endif 


//#if -1411543044 
setDashed(true);
//#endif 

} 

//#endif 


//#if 819244917 
@Override
    protected boolean canEdit(Fig f)
    { 

//#if 907030596 
return false;
//#endif 

} 

//#endif 


//#if -548008954 
private void initialize()
    { 

//#if 1339287427 
label.setTextColor(TEXT_COLOR);
//#endif 


//#if 1311129738 
label.setTextFilled(false);
//#endif 


//#if 1041271037 
label.setFilled(false);
//#endif 


//#if 1708658302 
label.setLineWidth(0);
//#endif 


//#if -1314319233 
label.setEditable(false);
//#endif 


//#if 52523585 
label.setText("<<include>>");
//#endif 


//#if -975196649 
addPathItem(label, new PathItemPlacement(this, label, 50, 10));
//#endif 


//#if -422424209 
setDashed(true);
//#endif 


//#if 1653764233 
setDestArrowHead(endArrow);
//#endif 


//#if 1637511783 
setBetweenNearestPoints(true);
//#endif 

} 

//#endif 


//#if -1407653474 
@Override
    public void paint(Graphics g)
    { 

//#if -1790915113 
endArrow.setLineColor(getLineColor());
//#endif 


//#if -1858479028 
super.paint(g);
//#endif 

} 

//#endif 


//#if 463240519 
public FigInclude(Object edge, DiagramSettings settings)
    { 

//#if -790241002 
super(edge, settings);
//#endif 


//#if 2140909263 
label = new FigSingleLineText(edge, new Rectangle(X0, Y0 + 20, 90, 20),
                                      settings, false);
//#endif 


//#if -1152366167 
initialize();
//#endif 

} 

//#endif 


//#if 1553052835 

//#if 1587711716 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigInclude(Object edge)
    { 

//#if -1146474582 
this();
//#endif 


//#if -124700940 
setOwner(edge);
//#endif 

} 

//#endif 


//#if -1115923905 

//#if 47528106 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigInclude()
    { 

//#if 1098538133 
label = new FigSingleLineText(X0, Y0 + 20, 90, 20, false);
//#endif 


//#if -706860641 
initialize();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

