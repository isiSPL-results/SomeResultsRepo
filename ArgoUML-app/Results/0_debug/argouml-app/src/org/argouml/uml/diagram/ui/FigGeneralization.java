
//#if -220301429 
// Compilation Unit of /FigGeneralization.java 
 

//#if -1912369095 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1134878785 
import java.awt.Font;
//#endif 


//#if -297396349 
import java.awt.Graphics;
//#endif 


//#if 1776066201 
import java.awt.Rectangle;
//#endif 


//#if -193285394 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1812231484 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 1088553539 
import org.argouml.model.Model;
//#endif 


//#if -547369434 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1589379126 
import org.tigris.gef.base.Layer;
//#endif 


//#if 1249716973 
import org.tigris.gef.presentation.ArrowHeadTriangle;
//#endif 


//#if 1316440378 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1147937293 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 297768859 
public class FigGeneralization extends 
//#if 1714374465 
FigEdgeModelElement
//#endif 

  { 

//#if 1758135810 
private static final int TEXT_HEIGHT = 20;
//#endif 


//#if -1624497165 
private static final int DISCRIMINATOR_WIDTH = 90;
//#endif 


//#if -2081471512 
private static final long serialVersionUID = 3983170503390943894L;
//#endif 


//#if 1257267776 
private FigText discriminator;
//#endif 


//#if 325562604 
private ArrowHeadTriangle endArrow;
//#endif 


//#if 351679916 
private void addListener(Object owner)
    { 

//#if -518917608 
addElementListener(owner, new String[] {"remove", "discriminator"});
//#endif 

} 

//#endif 


//#if -1184307113 
@Deprecated
    public FigGeneralization(Object edge, Layer lay)
    { 

//#if 1220416983 
this();
//#endif 


//#if 1380401986 
setLayer(lay);
//#endif 


//#if 1315348513 
setOwner(edge);
//#endif 

} 

//#endif 


//#if -1804412212 
public FigGeneralization(Object owner, DiagramSettings settings)
    { 

//#if 310519093 
super(owner, settings);
//#endif 


//#if 1818673747 
discriminator = new ArgoFigText(owner, new Rectangle(X0, Y0,
                                        DISCRIMINATOR_WIDTH, TEXT_HEIGHT), settings, false);
//#endif 


//#if 1208251024 
initialize();
//#endif 


//#if -1503813581 
fixup(owner);
//#endif 


//#if -806279752 
addListener(owner);
//#endif 

} 

//#endif 


//#if -339589352 

//#if 2103637979 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigGeneralization()
    { 

//#if -428059162 
discriminator = new ArgoFigText(null, new Rectangle(X0, Y0,
                                        DISCRIMINATOR_WIDTH, TEXT_HEIGHT), getSettings(), false);
//#endif 


//#if 700942844 
initialize();
//#endif 

} 

//#endif 


//#if 1727604625 
private void fixup(Object owner)
    { 

//#if 1863156058 
if(Model.getFacade().isAGeneralization(owner))//1
{ 

//#if 1183034158 
Object subType = Model.getFacade().getSpecific(owner);
//#endif 


//#if 1973714347 
Object superType = Model.getFacade().getGeneral(owner);
//#endif 


//#if 1129505819 
if(subType == null || superType == null)//1
{ 

//#if -1472385569 
removeFromDiagram();
//#endif 


//#if 1430009217 
return;
//#endif 

} 

//#endif 


//#if 171807565 
updateDiscriminatorText();
//#endif 

} 
else

//#if -867792744 
if(owner != null)//1
{ 

//#if 2059232242 
throw new IllegalStateException(
                "FigGeneralization has an illegal owner of "
                + owner.getClass().getName());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 640090406 
@Override
    protected boolean canEdit(Fig f)
    { 

//#if 1289273517 
return false;
//#endif 

} 

//#endif 


//#if 1143647861 
private void initialize()
    { 

//#if -1439544103 
discriminator.setFilled(false);
//#endif 


//#if 381706018 
discriminator.setLineWidth(0);
//#endif 


//#if -2037570031 
discriminator.setReturnAction(FigText.END_EDITING);
//#endif 


//#if 820163362 
discriminator.setTabAction(FigText.END_EDITING);
//#endif 


//#if -599931656 
addPathItem(discriminator,
                    new PathItemPlacement(this, discriminator, 50, -10));
//#endif 


//#if 304609856 
endArrow = new ArrowHeadTriangle();
//#endif 


//#if 1650092393 
endArrow.setFillColor(FILL_COLOR);
//#endif 


//#if 912934589 
setDestArrowHead(endArrow);
//#endif 


//#if -876445773 
setBetweenNearestPoints(true);
//#endif 

} 

//#endif 


//#if 1675091953 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if 196025204 
if(oldOwner != null)//1
{ 

//#if -1666437534 
removeElementListener(oldOwner);
//#endif 

} 

//#endif 


//#if -800350501 
if(newOwner != null)//1
{ 

//#if 1909500502 
addListener(newOwner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -941990515 
@Override
    public void paint(Graphics g)
    { 

//#if -1006109647 
endArrow.setLineColor(getLineColor());
//#endif 


//#if -1344451790 
super.paint(g);
//#endif 

} 

//#endif 


//#if -1571178619 
@Override
    protected void modelChanged(PropertyChangeEvent e)
    { 

//#if -322962809 
super.modelChanged(e);
//#endif 


//#if 1076829016 
if(e instanceof AttributeChangeEvent
                && "discriminator".equals(e.getPropertyName()))//1
{ 

//#if 1497507909 
updateDiscriminatorText();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 455280035 

//#if -671257487 
@SuppressWarnings("deprecation")
//#endif 


    @Override
    public void setOwner(Object own)
    { 

//#if -205240241 
super.setOwner(own);
//#endif 


//#if 821019749 
fixup(own);
//#endif 

} 

//#endif 


//#if 1274057617 
public void updateDiscriminatorText()
    { 

//#if 119984381 
Object generalization = getOwner();
//#endif 


//#if -442957292 
if(generalization == null)//1
{ 

//#if -517952545 
return;
//#endif 

} 

//#endif 


//#if -1967119127 
String disc =
            (String) Model.getFacade().getDiscriminator(generalization);
//#endif 


//#if 233692461 
if(disc == null)//1
{ 

//#if 1823913974 
disc = "";
//#endif 

} 

//#endif 


//#if 1820387630 
discriminator.setFont(getSettings().getFont(Font.PLAIN));
//#endif 


//#if 858055604 
discriminator.setText(disc);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

