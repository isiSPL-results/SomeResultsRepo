// Compilation Unit of /ZoomSliderButton.java 
 
package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.tigris.swidgets.PopupButton;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
public class ZoomSliderButton extends PopupButton
  { 
private static final String RESOURCE_NAME = "Zoom Reset";
private static final Font LABEL_FONT = new Font("Dialog", Font.PLAIN, 10);
public static final int MINIMUM_ZOOM = 25;
public static final int MAXIMUM_ZOOM = 300;
private static final int SLIDER_HEIGHT = 250;
private JSlider slider = null;
private JTextField currentValue = null;
private boolean popupButtonIsActive = true;
private boolean popupMenuIsShowing = false;
private boolean mouseIsOverPopupButton = false;
private void handleTextEntry()
    { 
String value = currentValue.getText();
if(value.endsWith("%"))//1
{ 
value = value.substring(0, value.length() - 1);
} 

try //1
{ 
int newZoom = Integer.parseInt(value);
if(newZoom < MINIMUM_ZOOM || newZoom > MAXIMUM_ZOOM)//1
{ 
throw new NumberFormatException();
} 

slider.setValue(newZoom);
} 
catch (NumberFormatException ex) //1
{ 
updateCurrentValueLabel();
} 


} 

@Override
    protected void showPopup()
    { 
if(slider == null)//1
{ 
createPopupComponent();
} 

Editor ed = Globals.curEditor();
if(ed != null)//1
{ 
slider.setValue((int) (ed.getScale() * 100d));
} 

if(popupButtonIsActive)//1
{ 
super.showPopup();
JPopupMenu pm = (JPopupMenu) this.getPopupComponent().getParent();
PopupMenuListener pml = new MyPopupMenuListener();
pm.addPopupMenuListener(pml);
popupMenuIsShowing = true;
} 

slider.requestFocus();
} 

public ZoomSliderButton()
    { 
super();
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
Icon icon = ResourceLoaderWrapper.lookupIcon(RESOURCE_NAME);
MyMouseListener myMouseListener = new MyMouseListener();
addMouseMotionListener(myMouseListener);
addMouseListener(myMouseListener);
setIcon(icon);
setToolTipText(Translator.localize("button.zoom"));
} 

private void handleSliderValueChange()
    { 
updateCurrentValueLabel();
double zoomPercentage = slider.getValue() / 100d;
Editor ed = Globals.curEditor();
if(ed == null || zoomPercentage <= 0.0)//1
{ 
return;
} 

if(zoomPercentage != ed.getScale())//1
{ 
ed.setScale(zoomPercentage);
ed.damageAll();
} 

} 

private void createPopupComponent()
    { 
slider =
            new JSlider(
            JSlider.VERTICAL,
            MINIMUM_ZOOM,
            MAXIMUM_ZOOM,
            MINIMUM_ZOOM);
slider.setInverted(true);
slider.setMajorTickSpacing(25);
slider.setMinorTickSpacing(5);
slider.setPaintTicks(true);
slider.setPaintTrack(true);
int sliderBaseWidth = slider.getPreferredSize().width;
slider.setPaintLabels(true);
for (Enumeration components = slider.getLabelTable().elements();
                components.hasMoreElements();) //1
{ 
((Component) components.nextElement()).setFont(LABEL_FONT);
} 

slider.setToolTipText(Translator.localize(
                                  "button.zoom.slider-tooltip"));
slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                handleSliderValueChange();
            }
        });
int labelWidth =
            slider.getFontMetrics(LABEL_FONT).stringWidth(
                String.valueOf(MAXIMUM_ZOOM)) + 6;
slider.setPreferredSize(new Dimension(
                                    sliderBaseWidth + labelWidth, SLIDER_HEIGHT));
currentValue = new JTextField(5);
currentValue.setHorizontalAlignment(JLabel.CENTER);
currentValue.setFont(LABEL_FONT);
currentValue.setToolTipText(Translator.localize(
                                        "button.zoom.current-zoom-magnification"));
updateCurrentValueLabel();
currentValue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleTextEntry();
            }
        });
currentValue.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                handleTextEntry();
            }
        });
JPanel currentValuePanel =
            new JPanel(new FlowLayout(
                           FlowLayout.CENTER, 0, 0));
currentValuePanel.add(currentValue);
JPanel zoomPanel = new JPanel(new BorderLayout(0, 0));
zoomPanel.add(slider, BorderLayout.CENTER);
zoomPanel.add(currentValuePanel, BorderLayout.NORTH);
setPopupComponent(zoomPanel);
} 

private void updateCurrentValueLabel()
    { 
currentValue.setText(String.valueOf(slider.getValue()) + '%');
} 

private class MyPopupMenuListener extends AbstractAction
 implements PopupMenuListener
  { 
public void popupMenuCanceled(PopupMenuEvent e)
        { 
if(mouseIsOverPopupButton)//1
{ 
popupButtonIsActive = false;
} 
else
{ 
popupButtonIsActive = true;
} 

popupMenuIsShowing = false;
} 

public void actionPerformed(ActionEvent e)
        { 
} 

public void popupMenuWillBecomeVisible(PopupMenuEvent e)
        { 
} 

public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
        { 
} 

 } 

private class MyMouseListener extends MouseInputAdapter
  { 
@Override
        public void mouseExited(MouseEvent me)
        { 
mouseIsOverPopupButton = false;
if(!popupButtonIsActive && !popupMenuIsShowing)//1
{ 
popupButtonIsActive = true;
} 

} 

@Override
        public void mouseEntered(MouseEvent me)
        { 
mouseIsOverPopupButton = true;
} 

@Override
        public void mousePressed(MouseEvent me)
        { 
if(popupButtonIsActive)//1
{ 
showPopup();
} 
else
if(!popupMenuIsShowing)//1
{ 
popupButtonIsActive = true;
} 


} 

 } 

 } 


