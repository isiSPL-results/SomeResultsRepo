
//#if -1973909301 
// Compilation Unit of /ArgoFrame.java 
 

//#if -177789383 
package org.argouml.util;
//#endif 


//#if 1843195970 
import java.awt.Frame;
//#endif 


//#if -1358692216 
import javax.swing.JFrame;
//#endif 


//#if 489723524 
import javax.swing.JOptionPane;
//#endif 


//#if -185046199 
import org.apache.log4j.Logger;
//#endif 


//#if 931859144 
public class ArgoFrame  { 

//#if 271028074 
private static final Logger LOG = Logger.getLogger(ArgoFrame.class);
//#endif 


//#if -1382796901 
private static JFrame topFrame;
//#endif 


//#if 815845054 
private ArgoFrame()
    { 
} 

//#endif 


//#if 873587239 
public static void setInstance(JFrame frame)
    { 

//#if -1984341995 
topFrame = frame;
//#endif 

} 

//#endif 


//#if -715278906 
public static JFrame getInstance()
    { 

//#if -1756653589 
if(topFrame == null)//1
{ 

//#if -925192811 
Frame rootFrame = JOptionPane.getRootFrame();
//#endif 


//#if 2057909389 
if(rootFrame instanceof JFrame)//1
{ 

//#if 2061340328 
topFrame = (JFrame) rootFrame;
//#endif 

} 
else
{ 

//#if 1695753205 
Frame[] frames = Frame.getFrames();
//#endif 


//#if 1646418768 
for (int i = 0; i < frames.length; i++) //1
{ 

//#if 1948399988 
if(frames[i] instanceof JFrame)//1
{ 

//#if 1817486842 
if(topFrame != null)//1
{ 

//#if -691654143 
LOG.warn("Found multiple JFrames");
//#endif 

} 
else
{ 

//#if -379418684 
topFrame = (JFrame) frames[i];
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1611387972 
if(topFrame == null)//1
{ 

//#if -889027553 
LOG.warn("Failed to find application JFrame");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 407450320 
ArgoDialog.setFrame(topFrame);
//#endif 

} 

//#endif 


//#if -526714516 
return topFrame;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

