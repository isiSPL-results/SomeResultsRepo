
//#if 472310461 
// Compilation Unit of /HeapMonitor.java 
 

//#if -985082640 
package org.argouml.ui;
//#endif 


//#if 1087019235 
import java.awt.Color;
//#endif 


//#if 71454144 
import java.awt.Dimension;
//#endif 


//#if 478455685 
import java.awt.Graphics;
//#endif 


//#if 57675479 
import java.awt.Rectangle;
//#endif 


//#if 1777850550 
import java.awt.event.ActionEvent;
//#endif 


//#if 1454722578 
import java.awt.event.ActionListener;
//#endif 


//#if -1922263069 
import java.text.MessageFormat;
//#endif 


//#if -722335025 
import javax.swing.JComponent;
//#endif 


//#if 897951055 
import javax.swing.Timer;
//#endif 


//#if -1247840629 
public class HeapMonitor extends 
//#if -1529725843 
JComponent
//#endif 

 implements 
//#if 2041138372 
ActionListener
//#endif 

  { 

//#if -1390751697 
private static final int ORANGE_THRESHOLD = 70;
//#endif 


//#if -291338860 
private static final int RED_THRESHOLD = 90;
//#endif 


//#if 1180029221 
private static final Color GREEN = new Color(0, 255, 0);
//#endif 


//#if -63133554 
private static final Color ORANGE  = new Color(255, 190, 125);
//#endif 


//#if -1815871249 
private static final Color RED = new Color(255, 70, 70);
//#endif 


//#if 717912764 
private static final long M = 1024 * 1024;
//#endif 


//#if -1711346358 
private long free;
//#endif 


//#if -1113647396 
private long total;
//#endif 


//#if 83535356 
private long max;
//#endif 


//#if -1697463783 
private long used;
//#endif 


//#if 667025338 
private void updateStats()
    { 

//#if -2052371219 
free = Runtime.getRuntime().freeMemory();
//#endif 


//#if -1965266571 
total = Runtime.getRuntime().totalMemory();
//#endif 


//#if -1780478347 
max = Runtime.getRuntime().maxMemory();
//#endif 


//#if -2108844766 
used = total - free;
//#endif 


//#if -887714258 
String tip = MessageFormat.format(
                         "Heap use: {0}%  {1}M used of {2}M total.  Max: {3}M",
                         new Object[] {used * 100 / total, (long) (used / M),
                                       (long) (total / M), (long) (max / M)
                                      });
//#endif 


//#if 1677389583 
setToolTipText(tip);
//#endif 

} 

//#endif 


//#if -1513442898 
public void paint (Graphics g)
    { 

//#if 473178344 
Rectangle bounds = getBounds();
//#endif 


//#if -1337022646 
int usedX = (int) (used * bounds.width / total);
//#endif 


//#if 1104189302 
int warnX = ORANGE_THRESHOLD * bounds.width / 100;
//#endif 


//#if 1997091400 
int dangerX = RED_THRESHOLD * bounds.width / 100;
//#endif 


//#if 913108008 
Color savedColor = g.getColor();
//#endif 


//#if 425226815 
g.setColor(getBackground().darker());
//#endif 


//#if 7171896 
g.fillRect(0, 0, Math.min(usedX, warnX), bounds.height);
//#endif 


//#if 509224608 
g.setColor(ORANGE);
//#endif 


//#if 68856301 
g.fillRect(warnX, 0,
                   Math.min(usedX - warnX, dangerX - warnX),
                   bounds.height);
//#endif 


//#if -787937629 
g.setColor(RED);
//#endif 


//#if 2061959746 
g.fillRect(dangerX, 0,
                   Math.min(usedX - dangerX, bounds.width - dangerX),
                   bounds.height);
//#endif 


//#if -1582700564 
g.setColor(getForeground());
//#endif 


//#if -1801551655 
String s = MessageFormat.format("{0}M used of {1}M total",
                                        new Object[] {(long) (used / M), (long) (total / M) });
//#endif 


//#if -1811386700 
int x = (bounds.width - g.getFontMetrics().stringWidth(s)) / 2;
//#endif 


//#if 2116685893 
int y = (bounds.height + g.getFontMetrics().getHeight()) / 2;
//#endif 


//#if 600224658 
g.drawString(s, x, y);
//#endif 


//#if 175207950 
g.setColor(savedColor);
//#endif 

} 

//#endif 


//#if 387629068 
public HeapMonitor()
    { 

//#if -122164613 
super();
//#endif 


//#if -688355366 
Dimension size = new Dimension(200, 20);
//#endif 


//#if 297310271 
setPreferredSize(size);
//#endif 


//#if 1454918080 
updateStats();
//#endif 


//#if -432895077 
Timer timer = new Timer(1000, this);
//#endif 


//#if -1059449923 
timer.start();
//#endif 

} 

//#endif 


//#if -781810157 
public void actionPerformed(ActionEvent e)
    { 

//#if -1226405284 
updateStats();
//#endif 


//#if 1604156807 
repaint();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

