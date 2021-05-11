
//#if 1226225484 
// Compilation Unit of /StatusBar.java 
 

//#if 1995065476 
package org.argouml.ui;
//#endif 


//#if 1748236046 
import java.awt.BorderLayout;
//#endif 


//#if -1172151601 
import java.awt.Color;
//#endif 


//#if 395002284 
import java.awt.Dimension;
//#endif 


//#if -173586091 
import java.awt.Font;
//#endif 


//#if 1263696932 
import javax.swing.JLabel;
//#endif 


//#if 1378571028 
import javax.swing.JPanel;
//#endif 


//#if 1960706290 
import javax.swing.JProgressBar;
//#endif 


//#if -1804954073 
import javax.swing.border.EtchedBorder;
//#endif 


//#if -857071004 
import org.tigris.gef.ui.IStatusBar;
//#endif 


//#if 455957330 
public class StatusBar extends 
//#if 332377923 
JPanel
//#endif 

 implements 
//#if 1495136358 
Runnable
//#endif 

, 
//#if 585519969 
IStatusBar
//#endif 

  { 

//#if -55265264 
private JLabel msg = new JLabel();
//#endif 


//#if 1870120440 
private JProgressBar progress = new JProgressBar();
//#endif 


//#if 1182343953 
private String statusText;
//#endif 


//#if 1916848628 
public synchronized void doFakeProgress(String s, int work)
    { 

//#if 850573581 
statusText = s;
//#endif 


//#if -2082307513 
showStatus(statusText + "... not implemented yet ...");
//#endif 


//#if 1980640357 
progress.setMaximum(work);
//#endif 


//#if -77557615 
progress.setValue(0);
//#endif 


//#if 1705440890 
Thread t = new Thread(this);
//#endif 


//#if 1045764811 
t.start();
//#endif 

} 

//#endif 


//#if 1176490642 
public synchronized void run()
    { 

//#if -249066144 
int work = progress.getMaximum();
//#endif 


//#if -1747555435 
for (int i = 0; i < work; i++) //1
{ 

//#if 1272285270 
progress.setValue(i);
//#endif 


//#if 309957116 
repaint();
//#endif 


//#if 768716227 
try //1
{ 

//#if -1460181592 
wait(10);
//#endif 

} 

//#if 465446953 
catch (InterruptedException ex) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if 385648539 
showStatus(statusText + "... done.");
//#endif 


//#if 1760682147 
repaint();
//#endif 


//#if -1131321366 
try //1
{ 

//#if -795669067 
wait(1000);
//#endif 

} 

//#if 689803009 
catch (InterruptedException ex) //1
{ 
} 

//#endif 


//#endif 


//#if -542997162 
progress.setValue(0);
//#endif 


//#if 1838744311 
showStatus("");
//#endif 


//#if -1953698097 
repaint();
//#endif 

} 

//#endif 


//#if 1807170043 
public void showProgress(int percent)
    { 

//#if 308196366 
progress.setValue(percent);
//#endif 

} 

//#endif 


//#if 1823192474 
public void showStatus(String s)
    { 

//#if -975249533 
msg.setText(s);
//#endif 


//#if -778598734 
paintImmediately(getBounds());
//#endif 

} 

//#endif 


//#if -411904621 
public void incProgress(int delataPercent)
    { 

//#if -1578926644 
progress.setValue(progress.getValue() + delataPercent);
//#endif 

} 

//#endif 


//#if 54408784 
public StatusBar()
    { 

//#if -518520034 
progress.setMinimum(0);
//#endif 


//#if -1902729679 
progress.setMaximum(100);
//#endif 


//#if 1055195939 
progress.setMinimumSize(new Dimension(100, 20));
//#endif 


//#if -1841820547 
progress.setSize(new Dimension(100, 20));
//#endif 


//#if -1672697593 
msg.setMinimumSize(new Dimension(300, 20));
//#endif 


//#if -768844579 
msg.setSize(new Dimension(300, 20));
//#endif 


//#if -887654455 
msg.setFont(new Font("Dialog", Font.PLAIN, 10));
//#endif 


//#if 1545054957 
msg.setForeground(Color.black);
//#endif 


//#if -830149980 
setLayout(new BorderLayout());
//#endif 


//#if 1903945630 
setBorder(new EtchedBorder(EtchedBorder.LOWERED));
//#endif 


//#if -1367941276 
add(msg, BorderLayout.CENTER);
//#endif 


//#if 1151279512 
add(progress, BorderLayout.EAST);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

