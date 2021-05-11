package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.application.helpers.ResourceLoaderWrapper;
class SplashPanel extends JPanel
  { 
private ImageIcon splashImage = null;
public SplashPanel(String iconName)
    { 
super();
splashImage =
            ResourceLoaderWrapper.lookupIconResource(iconName);
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
if(splashImage != null)//1
{ 
splashLabel.setIcon(splashImage);
} 
setLayout(new BorderLayout(0, 0));
add(splashLabel, BorderLayout.CENTER);
} 
public ImageIcon getImage()
    { 
return splashImage;
} 

 } 
