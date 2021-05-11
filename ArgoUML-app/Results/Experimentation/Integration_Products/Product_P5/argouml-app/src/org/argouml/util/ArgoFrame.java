package org.argouml.util;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
public class ArgoFrame  { 
private static final Logger LOG = Logger.getLogger(ArgoFrame.class);
private static JFrame topFrame;
private ArgoFrame()
    { 
} 
public static void setInstance(JFrame frame)
    { 
topFrame = frame;
} 
public static JFrame getInstance()
    { 
if(topFrame == null)//1
{ 
Frame rootFrame = JOptionPane.getRootFrame();
if(rootFrame instanceof JFrame)//1
{ 
topFrame = (JFrame) rootFrame;
} 
else
{ 
Frame[] frames = Frame.getFrames();
for (int i = 0; i < frames.length; i++) //1
{ 
if(frames[i] instanceof JFrame)//1
{ 
if(topFrame != null)//1
{ 
LOG.warn("Found multiple JFrames");
} 
else
{ 
topFrame = (JFrame) frames[i];
} 
} 
} 
if(topFrame == null)//1
{ 
LOG.warn("Failed to find application JFrame");
} 
} 
ArgoDialog.setFrame(topFrame);
} 
return topFrame;
} 

 } 
