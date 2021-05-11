
//#if 1010075112 
// Compilation Unit of /HelpBox.java 
 

//#if -1937705786 
package org.argouml.ui;
//#endif 


//#if -931862064 
import java.awt.BorderLayout;
//#endif 


//#if 1619203626 
import java.awt.Dimension;
//#endif 


//#if 1127846290 
import java.awt.Toolkit;
//#endif 


//#if -1044037003 
import java.io.IOException;
//#endif 


//#if -768368074 
import java.net.MalformedURLException;
//#endif 


//#if 1593586626 
import java.net.URL;
//#endif 


//#if 300364907 
import javax.swing.JEditorPane;
//#endif 


//#if -1963166391 
import javax.swing.JFrame;
//#endif 


//#if -936260853 
import javax.swing.JScrollPane;
//#endif 


//#if 1775960172 
import javax.swing.JTabbedPane;
//#endif 


//#if -1336508508 
import javax.swing.event.HyperlinkEvent;
//#endif 


//#if 1467553892 
import javax.swing.event.HyperlinkListener;
//#endif 


//#if 1480484552 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if 260032296 
import org.apache.log4j.Logger;
//#endif 


//#if 581891293 
public class HelpBox extends 
//#if 1687210669 
JFrame
//#endif 

 implements 
//#if -672292496 
HyperlinkListener
//#endif 

  { 

//#if 567663330 
private JTabbedPane tabs = new JTabbedPane();
//#endif 


//#if 2090006266 
private JEditorPane[] panes = null;
//#endif 


//#if 491551425 
private String pages[][] = {{"Manual",
            ApplicationVersion.getOnlineManual(),
            "The ArgoUML online manual"
        },
        {
            "Support",
            ApplicationVersion.getOnlineSupport(),
            "The ArgoUML support page"
        }
    };
//#endif 


//#if -1306758663 
private static final long serialVersionUID = 0L;
//#endif 


//#if -1009928866 
private static final Logger LOG = Logger.getLogger(HelpBox.class);
//#endif 


//#if -2086668205 
public HelpBox( String title)
    { 

//#if 597299169 
super( title);
//#endif 


//#if 1905081381 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
//#endif 


//#if 1549411041 
setLocation(scrSize.width / 2 - 400, scrSize.height / 2 - 300);
//#endif 


//#if -39630149 
getContentPane().setLayout(new BorderLayout(0, 0));
//#endif 


//#if 1606955923 
setSize( 800, 600);
//#endif 


//#if -1185291268 
panes = new JEditorPane [ pages.length];
//#endif 


//#if 1432277644 
for ( int i = 0; i < pages.length; i++) //1
{ 

//#if 985129494 
panes[i] = new JEditorPane();
//#endif 


//#if -1851680547 
panes[i].setEditable( false);
//#endif 


//#if -1801762297 
panes[i].setSize( 780, 580);
//#endif 


//#if -1531329719 
panes[i].addHyperlinkListener( this);
//#endif 


//#if -1612307485 
URL paneURL = null;
//#endif 


//#if -332927126 
try //1
{ 

//#if -726640939 
paneURL = new URL( pages[i][1]);
//#endif 

} 

//#if -1212273669 
catch ( MalformedURLException e) //1
{ 

//#if 1150801698 
LOG.warn( pages[i][0] + " URL malformed: " + pages[i][1]);
//#endif 

} 

//#endif 


//#endif 


//#if -1432344997 
if(paneURL != null)//1
{ 

//#if 1112416041 
try //1
{ 

//#if 1301198391 
panes[i].setPage( paneURL);
//#endif 

} 

//#if 1189954182 
catch ( IOException e) //1
{ 

//#if 1815030292 
LOG.warn("Attempted to read a bad URL: " + paneURL);
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 2129919610 
LOG.warn("Couldn't find " + pages[i][0]);
//#endif 

} 

//#endif 


//#if -16776790 
JScrollPane paneScrollPane = new JScrollPane( panes[i]);
//#endif 


//#if -1709121303 
paneScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//#endif 


//#if 2027881040 
paneScrollPane.setPreferredSize(new Dimension(800, 600));
//#endif 


//#if 1275155652 
paneScrollPane.setMinimumSize(new Dimension(400, 300));
//#endif 


//#if -1653404676 
tabs.addTab( pages[i][0], null, paneScrollPane, pages[i][2]);
//#endif 

} 

//#endif 


//#if -2132520578 
getContentPane().add( tabs, BorderLayout.CENTER);
//#endif 

} 

//#endif 


//#if -1353402141 
public void hyperlinkUpdate(HyperlinkEvent event)
    { 

//#if 1511298001 
if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)//1
{ 

//#if 1294293814 
JEditorPane pane = (JEditorPane) event.getSource();
//#endif 


//#if -1910043623 
try //1
{ 

//#if 771370336 
pane.setPage(event.getURL());
//#endif 

} 

//#if 1796038791 
catch (IOException ioe) //1
{ 

//#if 1224972944 
LOG.warn( "Could not fetch requested URL");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

