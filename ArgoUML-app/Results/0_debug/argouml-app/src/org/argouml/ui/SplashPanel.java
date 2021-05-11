
//#if 2060539638 
// Compilation Unit of /SplashPanel.java 
 

//#if 946139996 
package org.argouml.ui;
//#endif 


//#if 734601190 
import java.awt.BorderLayout;
//#endif 


//#if 957537009 
import java.awt.Graphics;
//#endif 


//#if 1184904940 
import javax.swing.ImageIcon;
//#endif 


//#if -1388199348 
import javax.swing.JLabel;
//#endif 


//#if -1273325252 
import javax.swing.JPanel;
//#endif 


//#if -5517083 
import javax.swing.SwingConstants;
//#endif 


//#if -1602965390 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if -240292374 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 840583325 
class SplashPanel extends 
//#if 1613768660 
JPanel
//#endif 

  { 

//#if -1409711264 
private ImageIcon splashImage = null;
//#endif 


//#if 899117382 
public SplashPanel(String iconName)
    { 

//#if -127441126 
super();
//#endif 


//#if -1241322243 
splashImage =
            ResourceLoaderWrapper.lookupIconResource(iconName);
//#endif 


//#if 1875808639 
JLabel splashLabel = new JLabel("", SwingConstants.LEFT) {

            /*
                 * The following values were determined experimentally:
                 * left margin 10, top margin 18.
                 *
             * @see javax.swing.JComponent#paint(java.awt.Graphics)
             */
            public void paint(Graphics g) {
                super.paint(g);
                g.drawString("v" + ApplicationVersion.getVersion(),
                             getInsets().left + 10, getInsets().top + 18);
            }

        };
//#endif 


//#if -109019313 
if(splashImage != null)//1
{ 

//#if -1067675462 
splashLabel.setIcon(splashImage);
//#endif 

} 

//#endif 


//#if 322992304 
setLayout(new BorderLayout(0, 0));
//#endif 


//#if 344618750 
add(splashLabel, BorderLayout.CENTER);
//#endif 

} 

//#endif 


//#if 1678147447 
public ImageIcon getImage()
    { 

//#if -512980211 
return splashImage;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

