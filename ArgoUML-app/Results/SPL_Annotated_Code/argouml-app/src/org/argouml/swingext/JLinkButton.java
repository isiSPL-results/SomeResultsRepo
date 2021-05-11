// Compilation Unit of /JLinkButton.java 
 
package org.argouml.swingext;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalButtonUI;
public class JLinkButton extends JButton
  { 
public static final int ALWAYS_UNDERLINE = 0;
public static final int HOVER_UNDERLINE = 1;
public static final int NEVER_UNDERLINE = 2;
public static final int SYSTEM_DEFAULT = 3;
private int linkBehavior;
private Color linkColor;
private Color colorPressed;
private Color visitedLinkColor;
private Color disabledLinkColor;
private URL buttonURL;
private Action defaultAction;
private boolean isLinkVisited;
public JLinkButton(String text, Icon icon, URL url)
    { 
super(text, icon);
linkBehavior = SYSTEM_DEFAULT;
linkColor = Color.blue;
colorPressed = Color.red;
visitedLinkColor = new Color(128, 0, 128);
if(text == null && url != null)//1
{ 
setText(url.toExternalForm());
} 

setLinkURL(url);
setCursor(Cursor.getPredefinedCursor(12));
setBorderPainted(false);
setContentAreaFilled(false);
setRolloverEnabled(true);
addActionListener(defaultAction);
} 

int getLinkBehavior()
    { 
return linkBehavior;
} 

protected void setupToolTipText()
    { 
String tip = null;
if(buttonURL != null)//1
{ 
tip = buttonURL.toExternalForm();
} 

setToolTipText(tip);
} 

Color getVisitedLinkColor()
    { 
return visitedLinkColor;
} 

Color getActiveLinkColor()
    { 
return colorPressed;
} 

protected String paramString()
    { 
String str;
if(linkBehavior == ALWAYS_UNDERLINE)//1
{ 
str = "ALWAYS_UNDERLINE";
} 
else
if(linkBehavior == HOVER_UNDERLINE)//1
{ 
str = "HOVER_UNDERLINE";
} 
else
if(linkBehavior == NEVER_UNDERLINE)//1
{ 
str = "NEVER_UNDERLINE";
} 
else
{ 
str = "SYSTEM_DEFAULT";
} 



String colorStr = linkColor == null ? "" : linkColor.toString();
String colorPressStr = colorPressed == null ? "" : colorPressed
                               .toString();
String disabledLinkColorStr = disabledLinkColor == null ? ""
                                      : disabledLinkColor.toString();
String visitedLinkColorStr = visitedLinkColor == null ? ""
                                     : visitedLinkColor.toString();
String buttonURLStr = buttonURL == null ? "" : buttonURL.toString();
String isLinkVisitedStr = isLinkVisited ? "true" : "false";
return super.paramString() + ",linkBehavior=" + str + ",linkURL="
               + buttonURLStr + ",linkColor=" + colorStr + ",activeLinkColor="
               + colorPressStr + ",disabledLinkColor=" + disabledLinkColorStr
               + ",visitedLinkColor=" + visitedLinkColorStr
               + ",linkvisitedString=" + isLinkVisitedStr;
} 

boolean isLinkVisited()
    { 
return isLinkVisited;
} 

public JLinkButton()
    { 
this(null, null, null);
} 

URL getLinkURL()
    { 
return buttonURL;
} 

public JLinkButton(Action action)
    { 
this();
setAction(action);
} 

Color getLinkColor()
    { 
return linkColor;
} 

@Override
    public String getUIClassID()
    { 
return "LinkButtonUI";
} 

@Override
    public void updateUI()
    { 
setUI(BasicLinkButtonUI.createUI(this));
} 

void setLinkURL(URL url)
    { 
URL urlOld = buttonURL;
buttonURL = url;
setupToolTipText();
firePropertyChange("linkURL", urlOld, url);
revalidate();
repaint();
} 

Color getDisabledLinkColor()
    { 
return disabledLinkColor;
} 

 } 

class BasicLinkButtonUI extends MetalButtonUI
  { 
private static final BasicLinkButtonUI UI = new BasicLinkButtonUI();
public static ComponentUI createUI(JComponent jcomponent)
    { 
return UI;
} 

BasicLinkButtonUI()
    { 
} 

protected void paintText(Graphics g, JComponent com, Rectangle rect,
                             String s)
    { 
JLinkButton bn = (JLinkButton) com;
ButtonModel bnModel = bn.getModel();
bn.getForeground();
if(bnModel.isEnabled())//1
{ 
if(bnModel.isPressed())//1
{ 
bn.setForeground(bn.getActiveLinkColor());
} 
else
if(bn.isLinkVisited())//1
{ 
bn.setForeground(bn.getVisitedLinkColor());
} 
else
{ 
bn.setForeground(bn.getLinkColor());
} 


} 
else
{ 
if(bn.getDisabledLinkColor() != null)//1
{ 
bn.setForeground(bn.getDisabledLinkColor());
} 

} 

super.paintText(g, com, rect, s);
int behaviour = bn.getLinkBehavior();
boolean drawLine = false;
if(behaviour == JLinkButton.HOVER_UNDERLINE)//1
{ 
if(bnModel.isRollover())//1
{ 
drawLine = true;
} 

} 
else
if(behaviour == JLinkButton.ALWAYS_UNDERLINE
                   || behaviour == JLinkButton.SYSTEM_DEFAULT)//1
{ 
drawLine = true;
} 


if(!drawLine)//1
{ 
return;
} 

FontMetrics fm = g.getFontMetrics();
int x = rect.x + getTextShiftOffset();
int y = (rect.y + fm.getAscent() + fm.getDescent()
                 + getTextShiftOffset()) - 1;
if(bnModel.isEnabled())//2
{ 
g.setColor(bn.getForeground());
g.drawLine(x, y, (x + rect.width) - 1, y);
} 
else
{ 
g.setColor(bn.getBackground().brighter());
g.drawLine(x, y, (x + rect.width) - 1, y);
} 

} 

 } 


