package org.argouml.uml.diagram.sequence.ui;
import java.awt.Dimension;
import java.util.List;
import org.argouml.uml.diagram.ui.ArgoFigGroup;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigRect;
import org.tigris.gef.presentation.FigText;
class FigHead extends ArgoFigGroup
  { 
private final FigText nameFig;
private final Fig stereotypeFig;
private final FigRect rectFig;
private static final long serialVersionUID = 2970745558193935791L;
FigHead(Fig stereotype, FigText name)
    { 
this.stereotypeFig = stereotype;
this.nameFig = name;
rectFig =
            new FigRect(0, 0,
                        FigClassifierRole.MIN_HEAD_WIDTH,
                        FigClassifierRole.MIN_HEAD_HEIGHT,
                        LINE_COLOR, FILL_COLOR);
addFig(rectFig);
addFig(name);
addFig(stereotype);
} 
public int getMinimumHeight()
    { 
int h = nameFig.getMinimumHeight();
if(stereotypeFig.isVisible())//1
{ 
h += stereotypeFig.getMinimumSize().height;
} 
h += 4;
if(h < FigClassifierRole.MIN_HEAD_HEIGHT)//1
{ 
h = FigClassifierRole.MIN_HEAD_HEIGHT;
} 
return h;
} 
public void setFilled(boolean b)
    { 
} 
public void setLineWidth(int i)
    { 
} 
@Override
    public Dimension getMinimumSize()
    { 
int h = FigClassifierRole.MIN_HEAD_HEIGHT;
Layer layer = this.getGroup().getLayer();
if(layer == null)//1
{ 
return new Dimension(FigClassifierRole.MIN_HEAD_WIDTH,
                                 FigClassifierRole.MIN_HEAD_HEIGHT);
} 
List<Fig> figs = layer.getContents();
for (Fig f : figs) //1
{ 
if(f instanceof FigClassifierRole)//1
{ 
FigClassifierRole other = (FigClassifierRole) f;
int otherHeight = other.getHeadFig().getMinimumHeight();
if(otherHeight > h)//1
{ 
h = otherHeight;
} 
} 
} 
int w = nameFig.getMinimumSize().width;
if(stereotypeFig.isVisible())//1
{ 
if(stereotypeFig.getMinimumSize().width > w)//1
{ 
w = stereotypeFig.getMinimumSize().width;
} 
} 
if(w < FigClassifierRole.MIN_HEAD_WIDTH)//1
{ 
w = FigClassifierRole.MIN_HEAD_WIDTH;
} 
return new Dimension(w, h);
} 
public void setBoundsImpl(int x, int y, int w, int h)
    { 
rectFig.setBounds(x, y, w, h);
int yy = y;
if(stereotypeFig.isVisible())//1
{ 
stereotypeFig.setBounds(x, yy, w,
                                    stereotypeFig.getMinimumSize().height);
yy += stereotypeFig.getMinimumSize().height;
} 
nameFig.setFilled(false);
nameFig.setLineWidth(0);
nameFig.setTextColor(TEXT_COLOR);
nameFig.setBounds(x, yy, w, nameFig.getHeight());
_x = x;
_y = y;
_w = w;
_h = h;
} 

 } 
