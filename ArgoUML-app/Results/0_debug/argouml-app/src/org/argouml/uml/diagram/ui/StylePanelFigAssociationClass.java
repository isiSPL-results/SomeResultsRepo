
//#if -1996585658 
// Compilation Unit of /StylePanelFigAssociationClass.java 
 

//#if 621380136 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 578089930 
import java.awt.Rectangle;
//#endif 


//#if 1060514689 
import java.awt.event.FocusListener;
//#endif 


//#if -456365438 
import java.awt.event.ItemListener;
//#endif 


//#if 1303830106 
import java.awt.event.KeyListener;
//#endif 


//#if 746445526 
import org.argouml.uml.diagram.static_structure.ui.StylePanelFigClass;
//#endif 


//#if 742697897 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1199524366 
public class StylePanelFigAssociationClass extends 
//#if -37934480 
StylePanelFigClass
//#endif 

 implements 
//#if 825338448 
ItemListener
//#endif 

, 
//#if 999000419 
FocusListener
//#endif 

, 
//#if 1293737386 
KeyListener
//#endif 

  { 

//#if -1996909122 
@Override
    protected void setTargetBBox()
    { 

//#if -410362331 
Fig target = getPanelTarget();
//#endif 


//#if 1742788669 
if(target == null)//1
{ 

//#if -1590403434 
return;
//#endif 

} 

//#endif 


//#if -1216154331 
Rectangle bounds = parseBBox();
//#endif 


//#if 70729825 
if(bounds == null)//1
{ 

//#if 557148112 
return;
//#endif 

} 

//#endif 


//#if 79655999 
Rectangle oldAssociationBounds = target.getBounds();
//#endif 


//#if -704147624 
if(((FigAssociationClass) target).getAssociationClass() != null)//1
{ 

//#if -1218129093 
target = ((FigAssociationClass) target).getAssociationClass();
//#endif 

} 

//#endif 


//#if -1359011145 
if(!target.getBounds().equals(bounds)
                && !oldAssociationBounds.equals(bounds))//1
{ 

//#if -51994008 
target.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
//#endif 


//#if -321400248 
target.endTrans();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -195560512 
@Override
    protected void hasEditableBoundingBox(boolean value)
    { 

//#if 1346756158 
super.hasEditableBoundingBox(true);
//#endif 

} 

//#endif 


//#if -1021043236 
@Override
    public void refresh()
    { 

//#if -1940631359 
super.refresh();
//#endif 


//#if -488384796 
Fig target = getPanelTarget();
//#endif 


//#if -2074349063 
if(((FigAssociationClass) target).getAssociationClass() != null)//1
{ 

//#if 2058212040 
target = ((FigAssociationClass) target).getAssociationClass();
//#endif 

} 

//#endif 


//#if -26157400 
Rectangle figBounds = target.getBounds();
//#endif 


//#if 178190229 
Rectangle styleBounds = parseBBox();
//#endif 


//#if -913983971 
if(!(figBounds.equals(styleBounds)))//1
{ 

//#if -735189445 
getBBoxField().setText(
                figBounds.x + "," + figBounds.y + "," + figBounds.width
                + "," + figBounds.height);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1778815497 
public StylePanelFigAssociationClass()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

