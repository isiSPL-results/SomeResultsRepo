
//#if 2005013506 
// Compilation Unit of /SplashScreen.java 
 

//#if -998179088 
package org.argouml.ui;
//#endif 


//#if -1400165254 
import java.awt.BorderLayout;
//#endif 


//#if -497804454 
import java.awt.Cursor;
//#endif 


//#if 757195712 
import java.awt.Dimension;
//#endif 


//#if 777671045 
import java.awt.Graphics;
//#endif 


//#if 253968670 
import java.awt.GraphicsEnvironment;
//#endif 


//#if -619524522 
import java.awt.Point;
//#endif 


//#if 1740764456 
import javax.swing.JPanel;
//#endif 


//#if 275689978 
import javax.swing.JWindow;
//#endif 


//#if -1048644461 
import javax.swing.border.EtchedBorder;
//#endif 


//#if -1174652040 
import org.tigris.gef.ui.IStatusBar;
//#endif 


//#if 980429462 
public class SplashScreen extends 
//#if 1771958100 
JWindow
//#endif 

 implements 
//#if 1599072190 
IStatusBar
//#endif 

  { 

//#if -816881959 
private StatusBar statusBar = new StatusBar();
//#endif 


//#if -1707468571 
private boolean paintCalled = false;
//#endif 


//#if -1292627145 
private SplashScreen(String title, String iconName)
    { 

//#if 1431092133 
super();
//#endif 


//#if -1536730245 
setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//#endif 


//#if 674968273 
getContentPane().setLayout(new BorderLayout(0, 0));
//#endif 


//#if 2068941553 
SplashPanel panel = new SplashPanel(iconName);
//#endif 


//#if 1078994528 
if(panel.getImage() != null)//1
{ 

//#if 754281804 
int imgWidth = panel.getImage().getIconWidth();
//#endif 


//#if 1866351772 
int imgHeight = panel.getImage().getIconHeight();
//#endif 


//#if -1989403685 
Point scrCenter = GraphicsEnvironment.getLocalGraphicsEnvironment()
                              .getCenterPoint();
//#endif 


//#if 441257831 
setLocation(scrCenter.x - imgWidth / 2,
                        scrCenter.y - imgHeight / 2);
//#endif 

} 

//#endif 


//#if -346025339 
JPanel splash = new JPanel(new BorderLayout());
//#endif 


//#if 1140499992 
splash.setBorder(new EtchedBorder(EtchedBorder.RAISED));
//#endif 


//#if -1385308529 
splash.add(panel, BorderLayout.CENTER);
//#endif 


//#if -86875206 
splash.add(statusBar, BorderLayout.SOUTH);
//#endif 


//#if 2061186748 
getContentPane().add(splash);
//#endif 


//#if -177397945 
Dimension contentPaneSize = getContentPane().getPreferredSize();
//#endif 


//#if -1313562942 
setSize(contentPaneSize.width, contentPaneSize.height);
//#endif 


//#if -1538259909 
pack();
//#endif 

} 

//#endif 


//#if -644221821 
public SplashScreen()
    { 

//#if 1180511294 
this("Loading ArgoUML...", "Splash");
//#endif 

} 

//#endif 


//#if 1398571549 
public void showStatus(String s)
    { 

//#if -1406103030 
statusBar.showStatus(s);
//#endif 

} 

//#endif 


//#if 476081401 
public boolean isPaintCalled()
    { 

//#if 499292176 
return paintCalled;
//#endif 

} 

//#endif 


//#if 714532282 
@Override
    public void paint(Graphics g)
    { 

//#if -1181058898 
super.paint(g);
//#endif 


//#if 1758590527 
if(!paintCalled)//1
{ 

//#if -1008366419 
synchronized (this) //1
{ 

//#if -1960586458 
paintCalled = true;
//#endif 


//#if 208769607 
notifyAll();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1320351134 
public StatusBar getStatusBar()
    { 

//#if 377933048 
return statusBar;
//#endif 

} 

//#endif 


//#if 1021840528 
public void setPaintCalled(boolean called)
    { 

//#if 631514363 
this.paintCalled = called;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

