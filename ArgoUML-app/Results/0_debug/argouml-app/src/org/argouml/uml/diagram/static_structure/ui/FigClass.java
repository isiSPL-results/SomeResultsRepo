
//#if 1546944871 
// Compilation Unit of /FigClass.java 
 

//#if -11045900 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -1198143740 
import java.awt.Rectangle;
//#endif 


//#if -31613496 
import java.util.ArrayList;
//#endif 


//#if -1541849143 
import java.util.Iterator;
//#endif 


//#if -1106895975 
import java.util.List;
//#endif 


//#if 909665464 
import org.argouml.model.Model;
//#endif 


//#if 1297393307 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -1294767088 
import org.tigris.gef.base.Selection;
//#endif 


//#if -1149672476 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -2087557457 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 999442376 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if 320961794 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 273645092 
public class FigClass extends 
//#if 1258319235 
FigClassifierBoxWithAttributes
//#endif 

  { 

//#if -989090476 
protected FigText getPreviousVisibleFeature(FigGroup fgVec,
            FigText ft, int i)
    { 

//#if -1575899903 
if(fgVec == null || i < 1)//1
{ 

//#if -650653946 
return null;
//#endif 

} 

//#endif 


//#if 1241855200 
FigText ft2 = null;
//#endif 


//#if -837755862 
List figs = fgVec.getFigs();
//#endif 


//#if -689196634 
if(i >= figs.size() || !((FigText) figs.get(i)).isVisible())//1
{ 

//#if -233683059 
return null;
//#endif 

} 

//#endif 


//#if 1335692449 
do{ 

//#if -309731148 
i--;
//#endif 


//#if -1849726899 
while (i < 1) //1
{ 

//#if -778989614 
if(fgVec == getAttributesFig())//1
{ 

//#if -1902651801 
fgVec = getOperationsFig();
//#endif 

} 
else
{ 

//#if 1349827628 
fgVec = getAttributesFig();
//#endif 

} 

//#endif 


//#if -438683564 
figs = fgVec.getFigs();
//#endif 


//#if 418557812 
i = figs.size() - 1;
//#endif 

} 

//#endif 


//#if 275480559 
ft2 = (FigText) figs.get(i);
//#endif 


//#if 166337071 
if(!ft2.isVisible())//1
{ 

//#if 347607281 
ft2 = null;
//#endif 

} 

//#endif 

} 
 while (ft2 == null);//1

//#endif 


//#if -1643498851 
return ft2;
//#endif 

} 

//#endif 


//#if -2043284755 
public void setEnclosingFig(Fig encloser)
    { 

//#if -1982421596 
if(encloser == getEncloser())//1
{ 

//#if -928379682 
return;
//#endif 

} 

//#endif 


//#if -1589843365 
if(encloser == null
                || (encloser != null
                    && !Model.getFacade().isAInstance(encloser.getOwner())))//1
{ 

//#if -53751031 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 


//#if -1529981485 
if(!(Model.getFacade().isAUMLElement(getOwner())))//1
{ 

//#if -1773720817 
return;
//#endif 

} 

//#endif 


//#if 1758713912 
if(encloser != null
                && (Model.getFacade().isAComponent(encloser.getOwner())))//1
{ 

//#if 1536036426 
moveIntoComponent(encloser);
//#endif 


//#if 13775759 
super.setEnclosingFig(encloser);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 142528757 
protected Object buildModifierPopUp()
    { 

//#if 1885004012 
return buildModifierPopUp(ABSTRACT | LEAF | ROOT | ACTIVE);
//#endif 

} 

//#endif 


//#if 1384425261 
@Deprecated
    public FigClass(Object modelElement, int x, int y, int w, int h)
    { 

//#if -971776087 
this(null, modelElement);
//#endif 


//#if -1846271356 
setBounds(x, y, w, h);
//#endif 

} 

//#endif 


//#if -1829384196 
public Selection makeSelection()
    { 

//#if -1241395112 
return new SelectionClass(this);
//#endif 

} 

//#endif 


//#if -981581992 
@Override
    protected void updateNameText()
    { 

//#if -1606839880 
super.updateNameText();
//#endif 


//#if -1356159966 
calcBounds();
//#endif 


//#if 2027698271 
setBounds(getBounds());
//#endif 

} 

//#endif 


//#if -1171726702 
public FigClass(Object element, Rectangle bounds,
                    DiagramSettings settings)
    { 

//#if -1940306451 
super(element, bounds, settings);
//#endif 


//#if -1400785962 
constructFigs();
//#endif 


//#if -1970705273 
Rectangle r = getBounds();
//#endif 


//#if 1292429164 
setStandardBounds(r.x, r.y, r.width, r.height);
//#endif 

} 

//#endif 


//#if -1013118672 
private void constructFigs()
    { 

//#if -66805127 
addFig(getBigPort());
//#endif 


//#if 1295641610 
addFig(getStereotypeFig());
//#endif 


//#if -896371119 
addFig(getNameFig());
//#endif 


//#if -2050188784 
addFig(getOperationsFig());
//#endif 


//#if 1509911109 
addFig(getAttributesFig());
//#endif 


//#if 26638511 
addFig(borderFig);
//#endif 

} 

//#endif 


//#if -79308246 
@Override
    public Object clone()
    { 

//#if -1248732819 
FigClass figClone = (FigClass) super.clone();
//#endif 


//#if -525334867 
Iterator thisIter = this.getFigs().iterator();
//#endif 


//#if 1416619973 
Iterator cloneIter = figClone.getFigs().iterator();
//#endif 


//#if 1667659573 
while (thisIter.hasNext()) //1
{ 

//#if 208004726 
Fig thisFig = (Fig) thisIter.next();
//#endif 


//#if 481159560 
Fig cloneFig = (Fig) cloneIter.next();
//#endif 


//#if 769411664 
if(thisFig == borderFig)//1
{ 

//#if -7230886 
figClone.borderFig = thisFig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1458158350 
return figClone;
//#endif 

} 

//#endif 


//#if -1907998429 
public int getLineWidth()
    { 

//#if -1675431821 
return borderFig.getLineWidth();
//#endif 

} 

//#endif 


//#if -1736619851 
@Deprecated
    public FigClass(GraphModel gm, Object node)
    { 

//#if 794115377 
super();
//#endif 


//#if 531731673 
setOwner(node);
//#endif 


//#if -652901018 
constructFigs();
//#endif 

} 

//#endif 


//#if 507426000 
protected FigText getNextVisibleFeature(FigGroup fgVec, FigText ft, int i)
    { 

//#if -757623951 
if(fgVec == null || i < 1)//1
{ 

//#if -1022787392 
return null;
//#endif 

} 

//#endif 


//#if 1256500336 
FigText ft2 = null;
//#endif 


//#if 1648611259 
List v = fgVec.getFigs();
//#endif 


//#if -9432090 
if(i >= v.size() || !((FigText) v.get(i)).isVisible())//1
{ 

//#if -1318301151 
return null;
//#endif 

} 

//#endif 


//#if 1574321201 
do{ 

//#if 1957272889 
i++;
//#endif 


//#if -700484820 
while (i >= v.size()) //1
{ 

//#if 1671888102 
if(fgVec == getAttributesFig())//1
{ 

//#if -343080596 
fgVec = getOperationsFig();
//#endif 

} 
else
{ 

//#if 2115546576 
fgVec = getAttributesFig();
//#endif 

} 

//#endif 


//#if -826090895 
v = new ArrayList(fgVec.getFigs());
//#endif 


//#if -247913252 
i = 1;
//#endif 

} 

//#endif 


//#if 302556369 
ft2 = (FigText) v.get(i);
//#endif 


//#if 1865063882 
if(!ft2.isVisible())//1
{ 

//#if -1153884013 
ft2 = null;
//#endif 

} 

//#endif 

} 
 while (ft2 == null);//1

//#endif 


//#if -1149331923 
return ft2;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

