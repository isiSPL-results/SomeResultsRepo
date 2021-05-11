// Compilation Unit of /FigClass.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigGroup;
import org.tigris.gef.presentation.FigText;
public class FigClass extends FigClassifierBoxWithAttributes
  { 
protected FigText getPreviousVisibleFeature(FigGroup fgVec,
            FigText ft, int i)
    { 
if(fgVec == null || i < 1)//1
{ 
return null;
} 

FigText ft2 = null;
List figs = fgVec.getFigs();
if(i >= figs.size() || !((FigText) figs.get(i)).isVisible())//1
{ 
return null;
} 

do{ 
i--;
while (i < 1) //1
{ 
if(fgVec == getAttributesFig())//1
{ 
fgVec = getOperationsFig();
} 
else
{ 
fgVec = getAttributesFig();
} 

figs = fgVec.getFigs();
i = figs.size() - 1;
} 

ft2 = (FigText) figs.get(i);
if(!ft2.isVisible())//1
{ 
ft2 = null;
} 

} 
 while (ft2 == null);//1

return ft2;
} 

public void setEnclosingFig(Fig encloser)
    { 
if(encloser == getEncloser())//1
{ 
return;
} 

if(encloser == null
                || (encloser != null
                    && !Model.getFacade().isAInstance(encloser.getOwner())))//1
{ 
super.setEnclosingFig(encloser);
} 

if(!(Model.getFacade().isAUMLElement(getOwner())))//1
{ 
return;
} 

if(encloser != null
                && (Model.getFacade().isAComponent(encloser.getOwner())))//1
{ 
moveIntoComponent(encloser);
super.setEnclosingFig(encloser);
} 

} 

protected Object buildModifierPopUp()
    { 
return buildModifierPopUp(ABSTRACT | LEAF | ROOT | ACTIVE);
} 

@Deprecated
    public FigClass(Object modelElement, int x, int y, int w, int h)
    { 
this(null, modelElement);
setBounds(x, y, w, h);
} 

public Selection makeSelection()
    { 
return new SelectionClass(this);
} 

@Override
    protected void updateNameText()
    { 
super.updateNameText();
calcBounds();
setBounds(getBounds());
} 

public FigClass(Object element, Rectangle bounds,
                    DiagramSettings settings)
    { 
super(element, bounds, settings);
constructFigs();
Rectangle r = getBounds();
setStandardBounds(r.x, r.y, r.width, r.height);
} 

private void constructFigs()
    { 
addFig(getBigPort());
addFig(getStereotypeFig());
addFig(getNameFig());
addFig(getOperationsFig());
addFig(getAttributesFig());
addFig(borderFig);
} 

@Override
    public Object clone()
    { 
FigClass figClone = (FigClass) super.clone();
Iterator thisIter = this.getFigs().iterator();
Iterator cloneIter = figClone.getFigs().iterator();
while (thisIter.hasNext()) //1
{ 
Fig thisFig = (Fig) thisIter.next();
Fig cloneFig = (Fig) cloneIter.next();
if(thisFig == borderFig)//1
{ 
figClone.borderFig = thisFig;
} 

} 

return figClone;
} 

public int getLineWidth()
    { 
return borderFig.getLineWidth();
} 

@Deprecated
    public FigClass(GraphModel gm, Object node)
    { 
super();
setOwner(node);
constructFigs();
} 

protected FigText getNextVisibleFeature(FigGroup fgVec, FigText ft, int i)
    { 
if(fgVec == null || i < 1)//1
{ 
return null;
} 

FigText ft2 = null;
List v = fgVec.getFigs();
if(i >= v.size() || !((FigText) v.get(i)).isVisible())//1
{ 
return null;
} 

do{ 
i++;
while (i >= v.size()) //1
{ 
if(fgVec == getAttributesFig())//1
{ 
fgVec = getOperationsFig();
} 
else
{ 
fgVec = getAttributesFig();
} 

v = new ArrayList(fgVec.getFigs());
i = 1;
} 

ft2 = (FigText) v.get(i);
if(!ft2.isVisible())//1
{ 
ft2 = null;
} 

} 
 while (ft2 == null);//1

return ft2;
} 

 } 


