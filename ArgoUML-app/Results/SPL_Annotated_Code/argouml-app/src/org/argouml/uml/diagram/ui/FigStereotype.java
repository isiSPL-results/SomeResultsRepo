// Compilation Unit of /FigStereotype.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Rectangle;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.notation.providers.uml.NotationUtilityUml;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigText;
public class FigStereotype extends FigSingleLineText
  { 
protected void updateLayout(UmlChangeEvent event)
    { 
assert event != null;
Rectangle oldBounds = getBounds();
setText();
if(oldBounds != getBounds())//1
{ 
setBounds(getBounds());
} 

if(getGroup() != null)//1
{ 
getGroup().calcBounds();
getGroup().setBounds(getGroup().getBounds());
if(oldBounds != getBounds())//1
{ 
Fig sg = getGroup().getGroup();
if(sg != null)//1
{ 
sg.calcBounds();
sg.setBounds(sg.getBounds());
} 

} 

} 

damage();
} 

public void setText(String text)
    { 
super.setText(NotationUtilityUml.formatStereotype(text,
                      getSettings().getNotationSettings().isUseGuillemets()));
damage();
} 

private void initialize()
    { 
setEditable(false);
setTextColor(TEXT_COLOR);
setTextFilled(false);
setJustification(FigText.JUSTIFY_CENTER);
setRightMargin(3);
setLeftMargin(3);
} 

public FigStereotype(Object owner, Rectangle bounds,
                         DiagramSettings settings)
    { 
super(owner, bounds, settings, true,
              new String[] {"name"});
assert owner != null;
initialize();
setText();
} 

@Override
    public void setLineWidth(int w)
    { 
super.setLineWidth(0);
} 

@Override
    protected void setText()
    { 
setText(Model.getFacade().getName(getOwner()));
} 

 } 


