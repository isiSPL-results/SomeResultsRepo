
//#if 1532423680 
// Compilation Unit of /FigProfileIcon.java 
 

//#if 1494245675 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1954393211 
import java.awt.Image;
//#endif 


//#if -1300034545 
import org.tigris.gef.presentation.FigImage;
//#endif 


//#if 101290698 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 106553599 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 172273617 
public class FigProfileIcon extends 
//#if -392464020 
FigNode
//#endif 

  { 

//#if -504957742 
private FigImage image = null;
//#endif 


//#if -1435303869 
private FigText  label = null;
//#endif 


//#if 1909580576 
private static final int GAP = 2;
//#endif 


//#if -1907357709 
public String getLabel()
    { 

//#if 641520965 
return label.getText();
//#endif 

} 

//#endif 


//#if 1597612232 
public FigProfileIcon(Image icon, String str)
    { 

//#if -1395038073 
image = new FigImage(0, 0, icon);
//#endif 


//#if 171228107 
label = new FigSingleLineText(0, image.getHeight() + GAP, 0, 0, true);
//#endif 


//#if -958605377 
label.setText(str);
//#endif 


//#if 676114437 
label.calcBounds();
//#endif 


//#if 740280857 
addFig(image);
//#endif 


//#if -1234854542 
addFig(label);
//#endif 


//#if 453690330 
image.setResizable(false);
//#endif 


//#if -774584352 
image.setLocked(true);
//#endif 

} 

//#endif 


//#if 444558569 
public void setLabel(String txt)
    { 

//#if 970451998 
this.label.setText(txt);
//#endif 


//#if -1690840091 
this.label.calcBounds();
//#endif 


//#if 13730975 
this.calcBounds();
//#endif 

} 

//#endif 


//#if 155072153 
public FigText getLabelFig()
    { 

//#if 1876019098 
return label;
//#endif 

} 

//#endif 


//#if 1346345836 
@Override
    protected void setBoundsImpl(int x, int y, int w, int h)
    { 

//#if -1283283677 
int width = Math.max(image.getWidth(), label.getWidth());
//#endif 


//#if -1884109395 
image.setLocation(x + (width - image.getWidth()) / 2, y);
//#endif 


//#if 1364132024 
label.setLocation(x + (width - label.getWidth()) / 2, y
                          + image.getHeight() + GAP);
//#endif 


//#if 1895651986 
calcBounds();
//#endif 


//#if -2020781941 
updateEdges();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

