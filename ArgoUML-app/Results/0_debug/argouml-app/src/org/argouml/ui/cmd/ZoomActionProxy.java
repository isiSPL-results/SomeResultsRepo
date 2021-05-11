
//#if 904087526 
// Compilation Unit of /ZoomActionProxy.java 
 

//#if 1855959519 
package org.argouml.ui.cmd;
//#endif 


//#if 1193136155 
import java.awt.event.ActionEvent;
//#endif 


//#if -403274012 
import org.argouml.ui.ZoomSliderButton;
//#endif 


//#if 395874405 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1537650676 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1058671081 
import org.tigris.gef.base.ZoomAction;
//#endif 


//#if 1099868797 
public class ZoomActionProxy extends 
//#if 2004996131 
ZoomAction
//#endif 

  { 

//#if -1031687041 
private double zoomFactor;
//#endif 


//#if 926387590 
public ZoomActionProxy(double zF)
    { 

//#if 1342018049 
super(zF);
//#endif 


//#if -172118134 
zoomFactor = zF;
//#endif 

} 

//#endif 


//#if -1408159624 
@Override
    public void actionPerformed(ActionEvent arg0)
    { 

//#if 720564652 
Editor ed = Globals.curEditor();
//#endif 


//#if 732577801 
if(ed == null)//1
{ 

//#if -808560485 
return;
//#endif 

} 

//#endif 


//#if 440433760 
if((zoomFactor == 0)
                || ((ed.getScale() * zoomFactor
                     > ZoomSliderButton.MINIMUM_ZOOM / 100.0)
                    && ed.getScale() * zoomFactor
                    < ZoomSliderButton.MAXIMUM_ZOOM / 100.0))//1
{ 

//#if -1633557241 
super.actionPerformed(arg0);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

