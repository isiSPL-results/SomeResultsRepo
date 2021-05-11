package org.argouml.ui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.Document;
import org.argouml.i18n.Translator;
import org.argouml.swingext.SpacerPanel;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.diagram.DiagramSettings.StereotypeStyle;
import org.argouml.uml.diagram.ui.ArgoFig;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.argouml.uml.diagram.ui.StereotypeStyled;
import org.argouml.util.ArgoFrame;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.ui.ColorRenderer;
import org.apache.log4j.Logger;
public class StylePanelFig extends StylePanel
 implements ItemListener
,FocusListener
,KeyListener
  { 
private static final String CUSTOM_ITEM =
        Translator.localize("label.stylepane.custom") + "...";
private JLabel bboxLabel =
        new JLabel(Translator.localize("label.stylepane.bounds") + ": ");
private JTextField bboxField = new JTextField();
private JLabel fillLabel =
        new JLabel(Translator.localize("label.stylepane.fill") + ": ");
private JComboBox fillField = new JComboBox();
private JLabel lineLabel =
        new JLabel(Translator.localize("label.stylepane.line") + ": ");
private JComboBox lineField = new JComboBox();
private JLabel stereoLabel =
        new JLabel(Translator.localize("menu.popup.stereotype-view") + ": ");
private JComboBox stereoField = new JComboBox();
private SpacerPanel spacer = new SpacerPanel();
private SpacerPanel spacer2 = new SpacerPanel();
private SpacerPanel spacer3 = new SpacerPanel();
private static final long serialVersionUID = -6232843473753751128L;
private static final Logger LOG = Logger.getLogger(StylePanelFig.class);
protected JComboBox getLineField()
    { 
return lineField;
} 
protected JLabel getFillLabel()
    { 
return fillLabel;
} 
protected Rectangle parseBBox()
    { 
Fig target = getPanelTarget();
String bboxStr = bboxField.getText().trim();
if(bboxStr.length() == 0)//1
{ 
return null;
} 
Rectangle res = new Rectangle();
java.util.StringTokenizer st =
            new java.util.StringTokenizer(bboxStr, ", ");
try//1
{ 
boolean changed = false;
if(!st.hasMoreTokens())//1
{ 
return target.getBounds();
} 
res.x = Integer.parseInt(st.nextToken());
if(!st.hasMoreTokens())//2
{ 
res.y = target.getBounds().y;
res.width = target.getBounds().width;
res.height = target.getBounds().height;
return res;
} 
res.y = Integer.parseInt(st.nextToken());
if(!st.hasMoreTokens())//3
{ 
res.width = target.getBounds().width;
res.height = target.getBounds().height;
return res;
} 
res.width = Integer.parseInt(st.nextToken());
if((res.width + res.x) > 6000)//1
{ 
res.width = 6000 - res.x;
changed = true;
} 
if(!st.hasMoreTokens())//4
{ 
res.width = target.getBounds().width;
return res;
} 
res.height = Integer.parseInt(st.nextToken());
if((res.height + res.y) > 6000)//1
{ 
res.height = 6000 - res.y;
changed = true;
} 
if(res.x < 0 || res.y < 0)//1
{ 
LOG.warn("Part of bounding box is off screen " + res);
} 
if(res.width < 0 || res.height < 0)//1
{ 
throw new IllegalArgumentException(
                    "Bounding box has negative size " + res);
} 
if(changed)//1
{ 
StringBuffer sb = new StringBuffer();
sb.append(Integer.toString(res.x));
sb.append(",");
sb.append(Integer.toString(res.y));
sb.append(",");
sb.append(Integer.toString(res.width));
sb.append(",");
sb.append(Integer.toString(res.height));
bboxField.setText(sb.toString());
} 
} 
catch (NumberFormatException ex) //1
{ 
bboxField.setBackground(Color.RED);
return null;
} 
catch (IllegalArgumentException iae) //1
{ 
bboxField.setBackground(Color.RED);
return null;
} 
bboxField.setBackground(null);
return res;
} 
public void setTargetFill()
    { 
Fig target = getPanelTarget();
Object c = fillField.getSelectedItem();
if(target == null || c == null)//1
{ 
return;
} 
Boolean isColor = (c instanceof Color);
if(isColor)//1
{ 
target.setFillColor((Color) c);
} 
target.setFilled(isColor);
target.endTrans();
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
for (Object t : TargetManager.getInstance().getTargets()) //1
{ 
Fig fig = null;
if(t instanceof FigNodeModelElement)//1
{ 
fig = (Fig) t;
} 
else
{ 
fig = activeDiagram.presentationFor(t);
} 
if(fig != null && fig != target)//1
{ 
if(isColor)//1
{ 
fig.setFillColor((Color) c);
} 
fig.setFilled(isColor);
fig.endTrans();
} 
} 
} 
protected SpacerPanel getSpacer2()
    { 
return spacer2;
} 
protected void handleCustomColor(JComboBox field, String title,
                                     Color targetColor)
    { 
Color newColor =
            JColorChooser.showDialog(ArgoFrame.getInstance(),
                                     Translator.localize(title), targetColor);
if(newColor != null)//1
{ 
field.insertItemAt(newColor, field.getItemCount() - 1);
field.setSelectedItem(newColor);
} 
else
if(getPanelTarget() != null)//1
{ 
field.setSelectedItem(targetColor);
} 
} 
protected JLabel getLineLabel()
    { 
return lineLabel;
} 
protected JLabel getBBoxLabel()
    { 
return bboxLabel;
} 
public void keyPressed(KeyEvent e)
    { 
} 
protected JComboBox getFillField()
    { 
return fillField;
} 
public StylePanelFig()
    { 
super("Fig Appearance");
initChoices();
Document bboxDoc = bboxField.getDocument();
bboxDoc.addDocumentListener(this);
bboxField.addKeyListener(this);
bboxField.addFocusListener(this);
fillField.addItemListener(this);
lineField.addItemListener(this);
stereoField.addItemListener(this);
fillField.setRenderer(new ColorRenderer());
lineField.setRenderer(new ColorRenderer());
bboxLabel.setLabelFor(bboxField);
add(bboxLabel);
add(bboxField);
fillLabel.setLabelFor(fillField);
add(fillLabel);
add(fillField);
lineLabel.setLabelFor(lineField);
add(lineLabel);
add(lineField);
stereoLabel.setLabelFor(stereoField);
add(stereoLabel);
add(stereoField);
} 
protected SpacerPanel getSpacer()
    { 
return spacer;
} 
public void itemStateChanged(ItemEvent e)
    { 
Object src = e.getSource();
Fig target = getPanelTarget();
if(e.getStateChange() == ItemEvent.SELECTED
                && target != null)//1
{ 
if(src == fillField)//1
{ 
if(e.getItem() == CUSTOM_ITEM)//1
{ 
handleCustomColor(fillField,
                                      "label.stylepane.custom-fill-color",
                                      target.getFillColor());
} 
setTargetFill();
} 
else
if(src == lineField)//1
{ 
if(e.getItem() == CUSTOM_ITEM)//1
{ 
handleCustomColor(lineField,
                                      "label.stylepane.custom-line-color",
                                      target.getLineColor());
} 
setTargetLine();
} 
else
if(src == stereoField)//1
{ 
if(target instanceof StereotypeStyled)//1
{ 
Object item = e.getItem();
DefaultComboBoxModel model =
                        (DefaultComboBoxModel) stereoField.getModel();
int idx = model.getIndexOf(item);
StereotypeStyled fig = (StereotypeStyled) target;
fig.setStereotypeStyle(StereotypeStyle.getEnum(idx));
} 
} 
} 
} 
public void focusLost(FocusEvent e)
    { 
if(e.getSource() == bboxField)//1
{ 
setTargetBBox();
} 
} 
public void refresh()
    { 
Fig target = getPanelTarget();
if(target instanceof FigEdgeModelElement)//1
{ 
hasEditableBoundingBox(false);
} 
else
{ 
hasEditableBoundingBox(true);
} 
if(target == null)//1
{ 
return;
} 
Rectangle figBounds = target.getBounds();
Rectangle styleBounds = parseBBox();
if(!(figBounds.equals(styleBounds)))//1
{ 
bboxField.setText(figBounds.x + "," + figBounds.y + ","
                              + figBounds.width + "," + figBounds.height);
} 
if(target.isFilled())//1
{ 
Color c = target.getFillColor();
fillField.setSelectedItem(c);
if(c != null && !fillField.getSelectedItem().equals(c))//1
{ 
fillField.insertItemAt(c, fillField.getItemCount() - 1);
fillField.setSelectedItem(c);
} 
} 
else
{ 
fillField.setSelectedIndex(0);
} 
if(target.getLineWidth() > 0)//1
{ 
Color c = target.getLineColor();
lineField.setSelectedItem(c);
if(c != null && !lineField.getSelectedItem().equals(c))//1
{ 
lineField.insertItemAt(c, lineField.getItemCount() - 1);
lineField.setSelectedItem(c);
} 
} 
else
{ 
lineField.setSelectedIndex(0);
} 
stereoField.setEnabled(target instanceof StereotypeStyled);
stereoLabel.setEnabled(target instanceof StereotypeStyled);
if(target instanceof StereotypeStyled)//1
{ 
StereotypeStyled fig = (StereotypeStyled) target;
stereoField.setSelectedIndex(fig.getStereotypeStyle().ordinal());
} 
} 
protected JTextField getBBoxField()
    { 
return bboxField;
} 
public void keyReleased(KeyEvent e)
    { 
} 
protected void setTargetBBox()
    { 
Fig target = getPanelTarget();
if(target == null)//1
{ 
return;
} 
Rectangle bounds = parseBBox();
if(bounds == null)//1
{ 
return;
} 
if(!target.getBounds().equals(bounds))//1
{ 
target.setBounds(bounds.x, bounds.y, bounds.width,
                             bounds.height);
target.endTrans();
} 
} 
public void keyTyped(KeyEvent e)
    { 
if(e.getSource().equals(bboxField) && e.getKeyChar() == '\n')//1
{ 
setTargetBBox();
} 
} 
public void setTargetLine()
    { 
Fig target = getPanelTarget();
Object c = lineField.getSelectedItem();
if(target == null || c == null)//1
{ 
return;
} 
Boolean isColor = (c instanceof Color);
if(isColor)//1
{ 
target.setLineColor((Color) c);
} 
target.setLineWidth(isColor ? ArgoFig.LINE_WIDTH : 0);
target.endTrans();
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
for (Object t : TargetManager.getInstance().getTargets()) //1
{ 
Fig fig = null;
if(t instanceof FigNodeModelElement)//1
{ 
fig = (Fig) t;
} 
else
{ 
fig = activeDiagram.presentationFor(t);
} 
if(fig != null && fig != target)//1
{ 
if(isColor)//1
{ 
fig.setLineColor((Color) c);
} 
fig.setLineWidth(isColor ? ArgoFig.LINE_WIDTH : 0);
fig.endTrans();
} 
} 
} 
protected static String getCustomItemName()
    { 
return CUSTOM_ITEM;
} 
protected void initChoices()
    { 
fillField.addItem(Translator.localize("label.stylepane.no-fill"));
fillField.addItem(Color.black);
fillField.addItem(Color.white);
fillField.addItem(Color.gray);
fillField.addItem(Color.lightGray);
fillField.addItem(Color.darkGray);
fillField.addItem(new Color(255, 255, 200));
fillField.addItem(new Color(255, 200, 255));
fillField.addItem(new Color(200, 255, 255));
fillField.addItem(new Color(200, 200, 255));
fillField.addItem(new Color(200, 255, 200));
fillField.addItem(new Color(255, 200, 200));
fillField.addItem(new Color(200, 200, 200));
fillField.addItem(Color.red);
fillField.addItem(Color.blue);
fillField.addItem(Color.cyan);
fillField.addItem(Color.yellow);
fillField.addItem(Color.magenta);
fillField.addItem(Color.green);
fillField.addItem(Color.orange);
fillField.addItem(Color.pink);
fillField.addItem(CUSTOM_ITEM);
lineField.addItem(Translator.localize("label.stylepane.no-line"));
lineField.addItem(Color.black);
lineField.addItem(Color.white);
lineField.addItem(Color.gray);
lineField.addItem(Color.lightGray);
lineField.addItem(Color.darkGray);
lineField.addItem(new Color(60, 60, 200));
lineField.addItem(new Color(60, 200, 60));
lineField.addItem(new Color(200, 60, 60));
lineField.addItem(Color.red);
lineField.addItem(Color.blue);
lineField.addItem(Color.cyan);
lineField.addItem(Color.yellow);
lineField.addItem(Color.magenta);
lineField.addItem(Color.green);
lineField.addItem(Color.orange);
lineField.addItem(Color.pink);
lineField.addItem(CUSTOM_ITEM);
DefaultComboBoxModel model = new DefaultComboBoxModel();
stereoField.setModel(model);
model.addElement(Translator
                         .localize("menu.popup.stereotype-view.textual"));
model.addElement(Translator
                         .localize("menu.popup.stereotype-view.big-icon"));
model.addElement(Translator
                         .localize("menu.popup.stereotype-view.small-icon"));
} 
public void focusGained(FocusEvent e)
    { 
} 
protected void hasEditableBoundingBox(boolean value)
    { 
bboxField.setEnabled(value);
bboxLabel.setEnabled(value);
} 
public StylePanelFig(String title)
    { 
super(title);
} 
protected SpacerPanel getSpacer3()
    { 
return spacer3;
} 

 } 
