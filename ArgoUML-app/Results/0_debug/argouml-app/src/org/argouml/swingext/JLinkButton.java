
//#if 511936114 
// Compilation Unit of /JLinkButton.java 
 

//#if -2120143774 
package org.argouml.swingext;
//#endif 


//#if -99205150 
import java.awt.Color;
//#endif 


//#if 1397041723 
import java.awt.Cursor;
//#endif 


//#if 1225614449 
import java.awt.FontMetrics;
//#endif 


//#if 658713638 
import java.awt.Graphics;
//#endif 


//#if 1350704726 
import java.awt.Rectangle;
//#endif 


//#if -71192937 
import java.net.URL;
//#endif 


//#if -783152213 
import javax.swing.Action;
//#endif 


//#if 516091102 
import javax.swing.ButtonModel;
//#endif 


//#if 1271371592 
import javax.swing.Icon;
//#endif 


//#if 813598041 
import javax.swing.JButton;
//#endif 


//#if 593642190 
import javax.swing.JComponent;
//#endif 


//#if 1164843869 
import javax.swing.plaf.ComponentUI;
//#endif 


//#if -1407743864 
import javax.swing.plaf.metal.MetalButtonUI;
//#endif 


//#if 761244020 
public class JLinkButton extends 
//#if 157505966 
JButton
//#endif 

  { 

//#if -776551730 
public static final int ALWAYS_UNDERLINE = 0;
//#endif 


//#if 859423036 
public static final int HOVER_UNDERLINE = 1;
//#endif 


//#if -1476238837 
public static final int NEVER_UNDERLINE = 2;
//#endif 


//#if -390780938 
public static final int SYSTEM_DEFAULT = 3;
//#endif 


//#if -1413945643 
private int linkBehavior;
//#endif 


//#if -1685011040 
private Color linkColor;
//#endif 


//#if -1745170866 
private Color colorPressed;
//#endif 


//#if -131463922 
private Color visitedLinkColor;
//#endif 


//#if -1407106244 
private Color disabledLinkColor;
//#endif 


//#if -1876987752 
private URL buttonURL;
//#endif 


//#if -1564067409 
private Action defaultAction;
//#endif 


//#if -580810520 
private boolean isLinkVisited;
//#endif 


//#if -206937740 
public JLinkButton(String text, Icon icon, URL url)
    { 

//#if 2103339368 
super(text, icon);
//#endif 


//#if 2036922670 
linkBehavior = SYSTEM_DEFAULT;
//#endif 


//#if -318105683 
linkColor = Color.blue;
//#endif 


//#if 320244606 
colorPressed = Color.red;
//#endif 


//#if -1328159844 
visitedLinkColor = new Color(128, 0, 128);
//#endif 


//#if 877224624 
if(text == null && url != null)//1
{ 

//#if 1068518211 
setText(url.toExternalForm());
//#endif 

} 

//#endif 


//#if 2074267041 
setLinkURL(url);
//#endif 


//#if 587874577 
setCursor(Cursor.getPredefinedCursor(12));
//#endif 


//#if -810160463 
setBorderPainted(false);
//#endif 


//#if -84156376 
setContentAreaFilled(false);
//#endif 


//#if 1358344965 
setRolloverEnabled(true);
//#endif 


//#if 299494647 
addActionListener(defaultAction);
//#endif 

} 

//#endif 


//#if 670232322 
int getLinkBehavior()
    { 

//#if -167976987 
return linkBehavior;
//#endif 

} 

//#endif 


//#if 31974024 
protected void setupToolTipText()
    { 

//#if -1932911293 
String tip = null;
//#endif 


//#if -1472502501 
if(buttonURL != null)//1
{ 

//#if -1503359911 
tip = buttonURL.toExternalForm();
//#endif 

} 

//#endif 


//#if 2137474065 
setToolTipText(tip);
//#endif 

} 

//#endif 


//#if 1352585345 
Color getVisitedLinkColor()
    { 

//#if -1759736438 
return visitedLinkColor;
//#endif 

} 

//#endif 


//#if -1113090173 
Color getActiveLinkColor()
    { 

//#if 747176 
return colorPressed;
//#endif 

} 

//#endif 


//#if -582229202 
protected String paramString()
    { 

//#if 1794820793 
String str;
//#endif 


//#if 385921373 
if(linkBehavior == ALWAYS_UNDERLINE)//1
{ 

//#if -1648719548 
str = "ALWAYS_UNDERLINE";
//#endif 

} 
else

//#if 322987137 
if(linkBehavior == HOVER_UNDERLINE)//1
{ 

//#if -941929502 
str = "HOVER_UNDERLINE";
//#endif 

} 
else

//#if -2080069222 
if(linkBehavior == NEVER_UNDERLINE)//1
{ 

//#if -1746077398 
str = "NEVER_UNDERLINE";
//#endif 

} 
else
{ 

//#if -218504211 
str = "SYSTEM_DEFAULT";
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -1848951010 
String colorStr = linkColor == null ? "" : linkColor.toString();
//#endif 


//#if -296241349 
String colorPressStr = colorPressed == null ? "" : colorPressed
                               .toString();
//#endif 


//#if -549127128 
String disabledLinkColorStr = disabledLinkColor == null ? ""
                                      : disabledLinkColor.toString();
//#endif 


//#if -273185510 
String visitedLinkColorStr = visitedLinkColor == null ? ""
                                     : visitedLinkColor.toString();
//#endif 


//#if -1437080424 
String buttonURLStr = buttonURL == null ? "" : buttonURL.toString();
//#endif 


//#if 996688134 
String isLinkVisitedStr = isLinkVisited ? "true" : "false";
//#endif 


//#if 1115604241 
return super.paramString() + ",linkBehavior=" + str + ",linkURL="
               + buttonURLStr + ",linkColor=" + colorStr + ",activeLinkColor="
               + colorPressStr + ",disabledLinkColor=" + disabledLinkColorStr
               + ",visitedLinkColor=" + visitedLinkColorStr
               + ",linkvisitedString=" + isLinkVisitedStr;
//#endif 

} 

//#endif 


//#if -86329139 
boolean isLinkVisited()
    { 

//#if -1453826861 
return isLinkVisited;
//#endif 

} 

//#endif 


//#if 1839690240 
public JLinkButton()
    { 

//#if 1279529711 
this(null, null, null);
//#endif 

} 

//#endif 


//#if 1466704513 
URL getLinkURL()
    { 

//#if 1153911734 
return buttonURL;
//#endif 

} 

//#endif 


//#if 720771316 
public JLinkButton(Action action)
    { 

//#if 1529611634 
this();
//#endif 


//#if 597894306 
setAction(action);
//#endif 

} 

//#endif 


//#if -520605271 
Color getLinkColor()
    { 

//#if 892135912 
return linkColor;
//#endif 

} 

//#endif 


//#if 556390818 
@Override
    public String getUIClassID()
    { 

//#if -343013827 
return "LinkButtonUI";
//#endif 

} 

//#endif 


//#if -1712532391 
@Override
    public void updateUI()
    { 

//#if -108526050 
setUI(BasicLinkButtonUI.createUI(this));
//#endif 

} 

//#endif 


//#if -1111444650 
void setLinkURL(URL url)
    { 

//#if 2087747846 
URL urlOld = buttonURL;
//#endif 


//#if -972817954 
buttonURL = url;
//#endif 


//#if -855025003 
setupToolTipText();
//#endif 


//#if 1322123205 
firePropertyChange("linkURL", urlOld, url);
//#endif 


//#if -1289189889 
revalidate();
//#endif 


//#if 1239344289 
repaint();
//#endif 

} 

//#endif 


//#if 92646029 
Color getDisabledLinkColor()
    { 

//#if 1170768590 
return disabledLinkColor;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1055230493 
class BasicLinkButtonUI extends 
//#if -1400781918 
MetalButtonUI
//#endif 

  { 

//#if -1410889919 
private static final BasicLinkButtonUI UI = new BasicLinkButtonUI();
//#endif 


//#if -896408582 
public static ComponentUI createUI(JComponent jcomponent)
    { 

//#if -2125588425 
return UI;
//#endif 

} 

//#endif 


//#if -1660858716 
BasicLinkButtonUI()
    { 
} 

//#endif 


//#if -1069589822 
protected void paintText(Graphics g, JComponent com, Rectangle rect,
                             String s)
    { 

//#if -686571423 
JLinkButton bn = (JLinkButton) com;
//#endif 


//#if 1516951107 
ButtonModel bnModel = bn.getModel();
//#endif 


//#if 1090351018 
bn.getForeground();
//#endif 


//#if 1645461021 
if(bnModel.isEnabled())//1
{ 

//#if 2056452044 
if(bnModel.isPressed())//1
{ 

//#if 789216441 
bn.setForeground(bn.getActiveLinkColor());
//#endif 

} 
else

//#if 1350786042 
if(bn.isLinkVisited())//1
{ 

//#if 1912294695 
bn.setForeground(bn.getVisitedLinkColor());
//#endif 

} 
else
{ 

//#if -1228107159 
bn.setForeground(bn.getLinkColor());
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 65053733 
if(bn.getDisabledLinkColor() != null)//1
{ 

//#if -1852759049 
bn.setForeground(bn.getDisabledLinkColor());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1348338666 
super.paintText(g, com, rect, s);
//#endif 


//#if -554899580 
int behaviour = bn.getLinkBehavior();
//#endif 


//#if -773100978 
boolean drawLine = false;
//#endif 


//#if -1703349682 
if(behaviour == JLinkButton.HOVER_UNDERLINE)//1
{ 

//#if -1616463943 
if(bnModel.isRollover())//1
{ 

//#if -280985162 
drawLine = true;
//#endif 

} 

//#endif 

} 
else

//#if -1997303462 
if(behaviour == JLinkButton.ALWAYS_UNDERLINE
                   || behaviour == JLinkButton.SYSTEM_DEFAULT)//1
{ 

//#if -1038205383 
drawLine = true;
//#endif 

} 

//#endif 


//#endif 


//#if -595278513 
if(!drawLine)//1
{ 

//#if -1746144599 
return;
//#endif 

} 

//#endif 


//#if 570518874 
FontMetrics fm = g.getFontMetrics();
//#endif 


//#if 454546598 
int x = rect.x + getTextShiftOffset();
//#endif 


//#if 1627592243 
int y = (rect.y + fm.getAscent() + fm.getDescent()
                 + getTextShiftOffset()) - 1;
//#endif 


//#if 1467603828 
if(bnModel.isEnabled())//2
{ 

//#if 1948613858 
g.setColor(bn.getForeground());
//#endif 


//#if 1167006621 
g.drawLine(x, y, (x + rect.width) - 1, y);
//#endif 

} 
else
{ 

//#if 1520814556 
g.setColor(bn.getBackground().brighter());
//#endif 


//#if 28271214 
g.drawLine(x, y, (x + rect.width) - 1, y);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

