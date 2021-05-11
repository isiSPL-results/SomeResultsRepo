
//#if 935824792 
// Compilation Unit of /ZoomSliderButton.java 
 

//#if 1722051637 
package org.argouml.ui;
//#endif 


//#if 834064895 
import java.awt.BorderLayout;
//#endif 


//#if 846002084 
import java.awt.Component;
//#endif 


//#if 1707783259 
import java.awt.Dimension;
//#endif 


//#if -1406790339 
import java.awt.FlowLayout;
//#endif 


//#if 138978630 
import java.awt.Font;
//#endif 


//#if -852921263 
import java.awt.event.ActionEvent;
//#endif 


//#if -1600108393 
import java.awt.event.ActionListener;
//#endif 


//#if -1068551830 
import java.awt.event.FocusAdapter;
//#endif 


//#if 849697535 
import java.awt.event.FocusEvent;
//#endif 


//#if -44272372 
import java.awt.event.MouseEvent;
//#endif 


//#if -418144790 
import java.util.Enumeration;
//#endif 


//#if 1197465157 
import javax.swing.AbstractAction;
//#endif 


//#if 1088488804 
import javax.swing.Icon;
//#endif 


//#if -1718489389 
import javax.swing.JLabel;
//#endif 


//#if -1603615293 
import javax.swing.JPanel;
//#endif 


//#if -2145326468 
import javax.swing.JPopupMenu;
//#endif 


//#if 505345518 
import javax.swing.JSlider;
//#endif 


//#if 1251771162 
import javax.swing.JTextField;
//#endif 


//#if 1134176323 
import javax.swing.event.ChangeEvent;
//#endif 


//#if -1510164635 
import javax.swing.event.ChangeListener;
//#endif 


//#if -775498205 
import javax.swing.event.MouseInputAdapter;
//#endif 


//#if -2072299494 
import javax.swing.event.PopupMenuEvent;
//#endif 


//#if -1263598546 
import javax.swing.event.PopupMenuListener;
//#endif 


//#if 1315208195 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1771766204 
import org.argouml.i18n.Translator;
//#endif 


//#if 2118558699 
import org.tigris.swidgets.PopupButton;
//#endif 


//#if -1650183013 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1760587138 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1328995364 
public class ZoomSliderButton extends 
//#if -914214534 
PopupButton
//#endif 

  { 

//#if 1497506926 
private static final String RESOURCE_NAME = "Zoom Reset";
//#endif 


//#if -1458604222 
private static final Font LABEL_FONT = new Font("Dialog", Font.PLAIN, 10);
//#endif 


//#if -242889933 
public static final int MINIMUM_ZOOM = 25;
//#endif 


//#if -1254673601 
public static final int MAXIMUM_ZOOM = 300;
//#endif 


//#if 521309100 
private static final int SLIDER_HEIGHT = 250;
//#endif 


//#if -841290140 
private JSlider slider = null;
//#endif 


//#if -1912185743 
private JTextField currentValue = null;
//#endif 


//#if -752658251 
private boolean popupButtonIsActive = true;
//#endif 


//#if -821032036 
private boolean popupMenuIsShowing = false;
//#endif 


//#if -1815366607 
private boolean mouseIsOverPopupButton = false;
//#endif 


//#if -176293909 
private void handleTextEntry()
    { 

//#if -1138072856 
String value = currentValue.getText();
//#endif 


//#if 965289020 
if(value.endsWith("%"))//1
{ 

//#if -61296893 
value = value.substring(0, value.length() - 1);
//#endif 

} 

//#endif 


//#if 1455107806 
try //1
{ 

//#if 1313572465 
int newZoom = Integer.parseInt(value);
//#endif 


//#if 256589166 
if(newZoom < MINIMUM_ZOOM || newZoom > MAXIMUM_ZOOM)//1
{ 

//#if 698383210 
throw new NumberFormatException();
//#endif 

} 

//#endif 


//#if -91398934 
slider.setValue(newZoom);
//#endif 

} 

//#if 671539220 
catch (NumberFormatException ex) //1
{ 

//#if 451233973 
updateCurrentValueLabel();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2109543222 
@Override
    protected void showPopup()
    { 

//#if -1001069402 
if(slider == null)//1
{ 

//#if 673604172 
createPopupComponent();
//#endif 

} 

//#endif 


//#if 1166775367 
Editor ed = Globals.curEditor();
//#endif 


//#if 1038442112 
if(ed != null)//1
{ 

//#if 69448259 
slider.setValue((int) (ed.getScale() * 100d));
//#endif 

} 

//#endif 


//#if -2000881184 
if(popupButtonIsActive)//1
{ 

//#if 1699353689 
super.showPopup();
//#endif 


//#if 415647948 
JPopupMenu pm = (JPopupMenu) this.getPopupComponent().getParent();
//#endif 


//#if -1093679691 
PopupMenuListener pml = new MyPopupMenuListener();
//#endif 


//#if -402767507 
pm.addPopupMenuListener(pml);
//#endif 


//#if -2002926373 
popupMenuIsShowing = true;
//#endif 

} 

//#endif 


//#if -1554306279 
slider.requestFocus();
//#endif 

} 

//#endif 


//#if -867220588 
public ZoomSliderButton()
    { 

//#if -60688516 
super();
//#endif 


//#if -590341078 
setAction(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                /* If action comes in with *no* modifiers, it is a pure
                 * keyboard event (e.g. spacebar), so do it.  Anything else
                 * is probably a mouse event, so ignore it. Mouse events are
                 * dealt with by mousePressed() instead (see bottom of page).
                 */
                if (e.getModifiers() == 0) {
                    showPopup();
                }
            }
        });
//#endif 


//#if -1788556221 
Icon icon = ResourceLoaderWrapper.lookupIcon(RESOURCE_NAME);
//#endif 


//#if 678134317 
MyMouseListener myMouseListener = new MyMouseListener();
//#endif 


//#if 943473442 
addMouseMotionListener(myMouseListener);
//#endif 


//#if 1315908492 
addMouseListener(myMouseListener);
//#endif 


//#if -1174409995 
setIcon(icon);
//#endif 


//#if -530661170 
setToolTipText(Translator.localize("button.zoom"));
//#endif 

} 

//#endif 


//#if 1512489414 
private void handleSliderValueChange()
    { 

//#if -1105195819 
updateCurrentValueLabel();
//#endif 


//#if 36389649 
double zoomPercentage = slider.getValue() / 100d;
//#endif 


//#if -305858770 
Editor ed = Globals.curEditor();
//#endif 


//#if 1289148553 
if(ed == null || zoomPercentage <= 0.0)//1
{ 

//#if 1364124452 
return;
//#endif 

} 

//#endif 


//#if -74679482 
if(zoomPercentage != ed.getScale())//1
{ 

//#if -173869993 
ed.setScale(zoomPercentage);
//#endif 


//#if -1530493200 
ed.damageAll();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -989179007 
private void createPopupComponent()
    { 

//#if -1032647603 
slider =
            new JSlider(
            JSlider.VERTICAL,
            MINIMUM_ZOOM,
            MAXIMUM_ZOOM,
            MINIMUM_ZOOM);
//#endif 


//#if -2145286479 
slider.setInverted(true);
//#endif 


//#if 1079442926 
slider.setMajorTickSpacing(25);
//#endif 


//#if 1482924114 
slider.setMinorTickSpacing(5);
//#endif 


//#if 2138710030 
slider.setPaintTicks(true);
//#endif 


//#if -238770279 
slider.setPaintTrack(true);
//#endif 


//#if 1619022036 
int sliderBaseWidth = slider.getPreferredSize().width;
//#endif 


//#if 529415725 
slider.setPaintLabels(true);
//#endif 


//#if 1021159343 
for (Enumeration components = slider.getLabelTable().elements();
                components.hasMoreElements();) //1
{ 

//#if 142293435 
((Component) components.nextElement()).setFont(LABEL_FONT);
//#endif 

} 

//#endif 


//#if 285543852 
slider.setToolTipText(Translator.localize(
                                  "button.zoom.slider-tooltip"));
//#endif 


//#if -1099658000 
slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                handleSliderValueChange();
            }
        });
//#endif 


//#if 82908921 
int labelWidth =
            slider.getFontMetrics(LABEL_FONT).stringWidth(
                String.valueOf(MAXIMUM_ZOOM)) + 6;
//#endif 


//#if -1577080161 
slider.setPreferredSize(new Dimension(
                                    sliderBaseWidth + labelWidth, SLIDER_HEIGHT));
//#endif 


//#if -194806774 
currentValue = new JTextField(5);
//#endif 


//#if -1695542775 
currentValue.setHorizontalAlignment(JLabel.CENTER);
//#endif 


//#if 1210460076 
currentValue.setFont(LABEL_FONT);
//#endif 


//#if 1978012539 
currentValue.setToolTipText(Translator.localize(
                                        "button.zoom.current-zoom-magnification"));
//#endif 


//#if 830829524 
updateCurrentValueLabel();
//#endif 


//#if -1758532941 
currentValue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleTextEntry();
            }
        });
//#endif 


//#if 1867580390 
currentValue.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                handleTextEntry();
            }
        });
//#endif 


//#if 1290780286 
JPanel currentValuePanel =
            new JPanel(new FlowLayout(
                           FlowLayout.CENTER, 0, 0));
//#endif 


//#if 1317520256 
currentValuePanel.add(currentValue);
//#endif 


//#if 568375162 
JPanel zoomPanel = new JPanel(new BorderLayout(0, 0));
//#endif 


//#if -659332731 
zoomPanel.add(slider, BorderLayout.CENTER);
//#endif 


//#if 596788208 
zoomPanel.add(currentValuePanel, BorderLayout.NORTH);
//#endif 


//#if 670828257 
setPopupComponent(zoomPanel);
//#endif 

} 

//#endif 


//#if 1536535553 
private void updateCurrentValueLabel()
    { 

//#if -833644213 
currentValue.setText(String.valueOf(slider.getValue()) + '%');
//#endif 

} 

//#endif 


//#if 374843962 
private class MyPopupMenuListener extends 
//#if 330845062 
AbstractAction
//#endif 

 implements 
//#if 1669975217 
PopupMenuListener
//#endif 

  { 

//#if 1255841506 
public void popupMenuCanceled(PopupMenuEvent e)
        { 

//#if 506088112 
if(mouseIsOverPopupButton)//1
{ 

//#if -895862504 
popupButtonIsActive = false;
//#endif 

} 
else
{ 

//#if -764168205 
popupButtonIsActive = true;
//#endif 

} 

//#endif 


//#if 1692833927 
popupMenuIsShowing = false;
//#endif 

} 

//#endif 


//#if 1907574207 
public void actionPerformed(ActionEvent e)
        { 
} 

//#endif 


//#if -1434038014 
public void popupMenuWillBecomeVisible(PopupMenuEvent e)
        { 
} 

//#endif 


//#if -1539334937 
public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
        { 
} 

//#endif 

 } 

//#endif 


//#if -39756236 
private class MyMouseListener extends 
//#if -1743875014 
MouseInputAdapter
//#endif 

  { 

//#if 1879803773 
@Override
        public void mouseExited(MouseEvent me)
        { 

//#if 1178462087 
mouseIsOverPopupButton = false;
//#endif 


//#if -793028300 
if(!popupButtonIsActive && !popupMenuIsShowing)//1
{ 

//#if -744822389 
popupButtonIsActive = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -4711137 
@Override
        public void mouseEntered(MouseEvent me)
        { 

//#if -198787321 
mouseIsOverPopupButton = true;
//#endif 

} 

//#endif 


//#if 746226826 
@Override
        public void mousePressed(MouseEvent me)
        { 

//#if -1241323655 
if(popupButtonIsActive)//1
{ 

//#if 996726984 
showPopup();
//#endif 

} 
else

//#if 890447323 
if(!popupMenuIsShowing)//1
{ 

//#if -594246650 
popupButtonIsActive = true;
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

