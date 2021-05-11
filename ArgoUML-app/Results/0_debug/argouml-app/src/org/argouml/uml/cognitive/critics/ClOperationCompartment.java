
//#if 689804996 
// Compilation Unit of /ClOperationCompartment.java 
 

//#if 2104333148 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1713276898 
import java.awt.Color;
//#endif 


//#if -122463548 
import java.awt.Component;
//#endif 


//#if -1993852310 
import java.awt.Graphics;
//#endif 


//#if 725538962 
import java.awt.Rectangle;
//#endif 


//#if 727906427 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -78359421 
import org.argouml.ui.Clarifier;
//#endif 


//#if 643468120 
import org.argouml.uml.diagram.OperationsCompartmentContainer;
//#endif 


//#if 1861405665 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 568962130 
public class ClOperationCompartment implements 
//#if -1356490129 
Clarifier
//#endif 

  { 

//#if -1110234222 
private static ClOperationCompartment theInstance =
        new ClOperationCompartment();
//#endif 


//#if -1103662318 
private static final int WAVE_LENGTH = 4;
//#endif 


//#if 1677912307 
private static final int WAVE_HEIGHT = 2;
//#endif 


//#if -865102424 
private Fig fig;
//#endif 


//#if 2053687246 
public int getIconWidth()
    { 

//#if -841018868 
return 0;
//#endif 

} 

//#endif 


//#if 496178483 
public void setToDoItem(ToDoItem i) { 
} 

//#endif 


//#if -256390463 
public int getIconHeight()
    { 

//#if -898126712 
return 0;
//#endif 

} 

//#endif 


//#if 916753646 
public void setFig(Fig f)
    { 

//#if -2080271962 
fig = f;
//#endif 

} 

//#endif 


//#if -1914917556 
public static ClOperationCompartment getTheInstance()
    { 

//#if 689650697 
return theInstance;
//#endif 

} 

//#endif 


//#if 1961664032 
public boolean hit(int x, int y)
    { 

//#if 1000897740 
if(!(fig instanceof OperationsCompartmentContainer))//1
{ 

//#if 1167983264 
return false;
//#endif 

} 

//#endif 


//#if -251231946 
OperationsCompartmentContainer fc =
            (OperationsCompartmentContainer) fig;
//#endif 


//#if -7623834 
Rectangle fr = fc.getOperationsBounds();
//#endif 


//#if -1101753769 
boolean res = fr.contains(x, y);
//#endif 


//#if 902380495 
fig = null;
//#endif 


//#if -2063765001 
return res;
//#endif 

} 

//#endif 


//#if 1192902484 
public void paintIcon(Component c, Graphics g, int x, int y)
    { 

//#if -1670124807 
if(fig instanceof OperationsCompartmentContainer)//1
{ 

//#if 1343475562 
OperationsCompartmentContainer fc =
                (OperationsCompartmentContainer) fig;
//#endif 


//#if -1332383422 
if(!fc.isOperationsVisible())//1
{ 

//#if 1429374286 
fig = null;
//#endif 


//#if 400983198 
return;
//#endif 

} 

//#endif 


//#if 314493338 
Rectangle fr = fc.getOperationsBounds();
//#endif 


//#if 178960326 
int left  = fr.x + 10;
//#endif 


//#if 1368126749 
int height = fr.y + fr.height - 7;
//#endif 


//#if -1610783344 
int right = fr.x + fr.width - 10;
//#endif 


//#if 2100063024 
g.setColor(Color.red);
//#endif 


//#if 1442479433 
int i = left;
//#endif 


//#if 972305317 
while (true) //1
{ 

//#if -1388739017 
g.drawLine(i, height, i + WAVE_LENGTH, height + WAVE_HEIGHT);
//#endif 


//#if 1886342825 
i += WAVE_LENGTH;
//#endif 


//#if -816896090 
if(i >= right)//1
{ 

//#if -30657160 
break;

//#endif 

} 

//#endif 


//#if -2082644045 
g.drawLine(i, height + WAVE_HEIGHT, i + WAVE_LENGTH, height);
//#endif 


//#if 687045385 
i += WAVE_LENGTH;
//#endif 


//#if -866641589 
if(i >= right)//2
{ 

//#if -1422061509 
break;

//#endif 

} 

//#endif 


//#if 1156805146 
g.drawLine(i, height, i + WAVE_LENGTH,
                           height + WAVE_HEIGHT / 2);
//#endif 


//#if 687045386 
i += WAVE_LENGTH;
//#endif 


//#if -866611797 
if(i >= right)//3
{ 

//#if -924908074 
break;

//#endif 

} 

//#endif 


//#if 1631471472 
g.drawLine(i, height + WAVE_HEIGHT / 2, i + WAVE_LENGTH,
                           height);
//#endif 


//#if 687045387 
i += WAVE_LENGTH;
//#endif 


//#if -866582005 
if(i >= right)//4
{ 

//#if -1889111938 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1726484477 
fig = null;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

