
//#if 394331136 
// Compilation Unit of /JBackgroundPanel.java 
 

//#if 1629035379 
package de.ovgu.featureide.examples.elevator.ui;
//#endif 


//#if -4054646 
import java.awt.Graphics;
//#endif 


//#if 2069526072 
import java.awt.image.BufferedImage;
//#endif 


//#if -1615590812 
import java.io.IOException;
//#endif 


//#if 661086339 
import java.io.InputStream;
//#endif 


//#if -1671527947 
import javax.imageio.ImageIO;
//#endif 


//#if -1017895485 
import javax.swing.JPanel;
//#endif 


//#if 1971040490 
public class JBackgroundPanel extends 
//#if -2028366661 
JPanel
//#endif 

  { 

//#if 1888756923 
private static final long serialVersionUID = 4393744577987449476L;
//#endif 


//#if 1274358582 
private final BufferedImage backgroundImage;
//#endif 


//#if 1167789426 
public JBackgroundPanel(InputStream fileName) throws IOException { 

//#if -1958129674 
backgroundImage = ImageIO.read(fileName);
//#endif 

} 

//#endif 


//#if 1084717304 
public void paintComponent(Graphics g) { 

//#if 375199553 
super.paintComponent(g);
//#endif 


//#if -621754875 
g.drawImage(backgroundImage, 
			(this.getWidth()  - backgroundImage.getWidth() ) / 2,
			(this.getHeight() - backgroundImage.getHeight()) / 2, this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

