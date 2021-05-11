// Compilation Unit of /FigGeneralization.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.ArrowHeadTriangle;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigText;
public class FigGeneralization extends FigEdgeModelElement
  { 
private static final int TEXT_HEIGHT = 20;
private static final int DISCRIMINATOR_WIDTH = 90;
private static final long serialVersionUID = 3983170503390943894L;
private FigText discriminator;
private ArrowHeadTriangle endArrow;
private void addListener(Object owner)
    { 
addElementListener(owner, new String[] {"remove", "discriminator"});
} 

@Deprecated
    public FigGeneralization(Object edge, Layer lay)
    { 
this();
setLayer(lay);
setOwner(edge);
} 

public FigGeneralization(Object owner, DiagramSettings settings)
    { 
super(owner, settings);
discriminator = new ArgoFigText(owner, new Rectangle(X0, Y0,
                                        DISCRIMINATOR_WIDTH, TEXT_HEIGHT), settings, false);
initialize();
fixup(owner);
addListener(owner);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public FigGeneralization()
    { 
discriminator = new ArgoFigText(null, new Rectangle(X0, Y0,
                                        DISCRIMINATOR_WIDTH, TEXT_HEIGHT), getSettings(), false);
initialize();
} 

private void fixup(Object owner)
    { 
if(Model.getFacade().isAGeneralization(owner))//1
{ 
Object subType = Model.getFacade().getSpecific(owner);
Object superType = Model.getFacade().getGeneral(owner);
if(subType == null || superType == null)//1
{ 
removeFromDiagram();
return;
} 

updateDiscriminatorText();
} 
else
if(owner != null)//1
{ 
throw new IllegalStateException(
                "FigGeneralization has an illegal owner of "
                + owner.getClass().getName());
} 


} 

@Override
    protected boolean canEdit(Fig f)
    { 
return false;
} 

private void initialize()
    { 
discriminator.setFilled(false);
discriminator.setLineWidth(0);
discriminator.setReturnAction(FigText.END_EDITING);
discriminator.setTabAction(FigText.END_EDITING);
addPathItem(discriminator,
                    new PathItemPlacement(this, discriminator, 50, -10));
endArrow = new ArrowHeadTriangle();
endArrow.setFillColor(FILL_COLOR);
setDestArrowHead(endArrow);
setBetweenNearestPoints(true);
} 

@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
if(oldOwner != null)//1
{ 
removeElementListener(oldOwner);
} 

if(newOwner != null)//1
{ 
addListener(newOwner);
} 

} 

@Override
    public void paint(Graphics g)
    { 
endArrow.setLineColor(getLineColor());
super.paint(g);
} 

@Override
    protected void modelChanged(PropertyChangeEvent e)
    { 
super.modelChanged(e);
if(e instanceof AttributeChangeEvent
                && "discriminator".equals(e.getPropertyName()))//1
{ 
updateDiscriminatorText();
} 

} 

@SuppressWarnings("deprecation")

    @Override
    public void setOwner(Object own)
    { 
super.setOwner(own);
fixup(own);
} 

public void updateDiscriminatorText()
    { 
Object generalization = getOwner();
if(generalization == null)//1
{ 
return;
} 

String disc =
            (String) Model.getFacade().getDiscriminator(generalization);
if(disc == null)//1
{ 
disc = "";
} 

discriminator.setFont(getSettings().getFont(Font.PLAIN));
discriminator.setText(disc);
} 

 } 


