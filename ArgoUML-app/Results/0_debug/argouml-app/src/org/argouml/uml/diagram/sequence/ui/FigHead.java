
//#if -583332059 
// Compilation Unit of /FigHead.java 
 

//#if -2027383411 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -1045279321 
import java.awt.Dimension;
//#endif 


//#if -1697820589 
import java.util.List;
//#endif 


//#if 1400780297 
import org.argouml.uml.diagram.ui.ArgoFigGroup;
//#endif 


//#if 897977457 
import org.tigris.gef.base.Layer;
//#endif 


//#if 1637350709 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1347427663 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -1345560440 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1258636271 
class FigHead extends 
//#if -1392810184 
ArgoFigGroup
//#endif 

  { 

//#if 599133980 
private final FigText nameFig;
//#endif 


//#if 1806807222 
private final Fig stereotypeFig;
//#endif 


//#if 1831667628 
private final FigRect rectFig;
//#endif 


//#if 401792770 
private static final long serialVersionUID = 2970745558193935791L;
//#endif 


//#if 532012363 
FigHead(Fig stereotype, FigText name)
    { 

//#if -480796885 
this.stereotypeFig = stereotype;
//#endif 


//#if -192209159 
this.nameFig = name;
//#endif 


//#if 462060608 
rectFig =
            new FigRect(0, 0,
                        FigClassifierRole.MIN_HEAD_WIDTH,
                        FigClassifierRole.MIN_HEAD_HEIGHT,
                        LINE_COLOR, FILL_COLOR);
//#endif 


//#if -1236356278 
addFig(rectFig);
//#endif 


//#if -1937538715 
addFig(name);
//#endif 


//#if -1108478388 
addFig(stereotype);
//#endif 

} 

//#endif 


//#if 94386434 
public int getMinimumHeight()
    { 

//#if -469792215 
int h = nameFig.getMinimumHeight();
//#endif 


//#if -1230063503 
if(stereotypeFig.isVisible())//1
{ 

//#if -2040201100 
h += stereotypeFig.getMinimumSize().height;
//#endif 

} 

//#endif 


//#if -1615651206 
h += 4;
//#endif 


//#if -1950852266 
if(h < FigClassifierRole.MIN_HEAD_HEIGHT)//1
{ 

//#if -1213577250 
h = FigClassifierRole.MIN_HEAD_HEIGHT;
//#endif 

} 

//#endif 


//#if -641339190 
return h;
//#endif 

} 

//#endif 


//#if 1795038730 
public void setFilled(boolean b)
    { 
} 

//#endif 


//#if -750246312 
public void setLineWidth(int i)
    { 
} 

//#endif 


//#if 1035148367 
@Override
    public Dimension getMinimumSize()
    { 

//#if 734742197 
int h = FigClassifierRole.MIN_HEAD_HEIGHT;
//#endif 


//#if -49316654 
Layer layer = this.getGroup().getLayer();
//#endif 


//#if 1328206041 
if(layer == null)//1
{ 

//#if -949609613 
return new Dimension(FigClassifierRole.MIN_HEAD_WIDTH,
                                 FigClassifierRole.MIN_HEAD_HEIGHT);
//#endif 

} 

//#endif 


//#if 496275137 
List<Fig> figs = layer.getContents();
//#endif 


//#if 765136940 
for (Fig f : figs) //1
{ 

//#if -274876879 
if(f instanceof FigClassifierRole)//1
{ 

//#if 569793146 
FigClassifierRole other = (FigClassifierRole) f;
//#endif 


//#if 1432184344 
int otherHeight = other.getHeadFig().getMinimumHeight();
//#endif 


//#if -1688129707 
if(otherHeight > h)//1
{ 

//#if 1635420738 
h = otherHeight;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -22378333 
int w = nameFig.getMinimumSize().width;
//#endif 


//#if -906371250 
if(stereotypeFig.isVisible())//1
{ 

//#if -578742780 
if(stereotypeFig.getMinimumSize().width > w)//1
{ 

//#if 649165946 
w = stereotypeFig.getMinimumSize().width;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -30526917 
if(w < FigClassifierRole.MIN_HEAD_WIDTH)//1
{ 

//#if -1739569255 
w = FigClassifierRole.MIN_HEAD_WIDTH;
//#endif 

} 

//#endif 


//#if -1222009161 
return new Dimension(w, h);
//#endif 

} 

//#endif 


//#if -603862403 
public void setBoundsImpl(int x, int y, int w, int h)
    { 

//#if 348516261 
rectFig.setBounds(x, y, w, h);
//#endif 


//#if -679144598 
int yy = y;
//#endif 


//#if -612754972 
if(stereotypeFig.isVisible())//1
{ 

//#if -1406471362 
stereotypeFig.setBounds(x, yy, w,
                                    stereotypeFig.getMinimumSize().height);
//#endif 


//#if -199706053 
yy += stereotypeFig.getMinimumSize().height;
//#endif 

} 

//#endif 


//#if -1263287902 
nameFig.setFilled(false);
//#endif 


//#if -582439623 
nameFig.setLineWidth(0);
//#endif 


//#if -69555416 
nameFig.setTextColor(TEXT_COLOR);
//#endif 


//#if 1150837038 
nameFig.setBounds(x, yy, w, nameFig.getHeight());
//#endif 


//#if -177547731 
_x = x;
//#endif 


//#if -177517909 
_y = y;
//#endif 


//#if -177577553 
_w = w;
//#endif 


//#if -178024883 
_h = h;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

