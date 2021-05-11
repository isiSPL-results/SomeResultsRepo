
//#if 2084867566 
// Compilation Unit of /StylePanelFig.java 
 

//#if 891464666 
package org.argouml.ui;
//#endif 


//#if -1069204295 
import java.awt.Color;
//#endif 


//#if 984143789 
import java.awt.Rectangle;
//#endif 


//#if -1157099420 
import java.awt.event.FocusEvent;
//#endif 


//#if -990589020 
import java.awt.event.FocusListener;
//#endif 


//#if -973094935 
import java.awt.event.ItemEvent;
//#endif 


//#if 308753919 
import java.awt.event.ItemListener;
//#endif 


//#if -1223721109 
import java.awt.event.KeyEvent;
//#endif 


//#if -1442435267 
import java.awt.event.KeyListener;
//#endif 


//#if -577124339 
import javax.swing.DefaultComboBoxModel;
//#endif 


//#if -1898824772 
import javax.swing.JColorChooser;
//#endif 


//#if 255074263 
import javax.swing.JComboBox;
//#endif 


//#if 1866617102 
import javax.swing.JLabel;
//#endif 


//#if 814436309 
import javax.swing.JTextField;
//#endif 


//#if 1750999010 
import javax.swing.text.Document;
//#endif 


//#if -1863324055 
import org.argouml.i18n.Translator;
//#endif 


//#if -2137339434 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if 396861267 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -259626770 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1214196432 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 1084794401 
import org.argouml.uml.diagram.DiagramSettings.StereotypeStyle;
//#endif 


//#if 2019024573 
import org.argouml.uml.diagram.ui.ArgoFig;
//#endif 


//#if -1594872140 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if 446383759 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if -75839671 
import org.argouml.uml.diagram.ui.StereotypeStyled;
//#endif 


//#if -55801797 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 811823270 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 747057130 
import org.tigris.gef.ui.ColorRenderer;
//#endif 


//#if 131279420 
import org.apache.log4j.Logger;
//#endif 


//#if 769168920 
public class StylePanelFig extends 
//#if 721100753 
StylePanel
//#endif 

 implements 
//#if -1361848731 
ItemListener
//#endif 

, 
//#if 1915674606 
FocusListener
//#endif 

, 
//#if 1361730293 
KeyListener
//#endif 

  { 

//#if -29642078 
private static final String CUSTOM_ITEM =
        Translator.localize("label.stylepane.custom") + "...";
//#endif 


//#if -1446383564 
private JLabel bboxLabel =
        new JLabel(Translator.localize("label.stylepane.bounds") + ": ");
//#endif 


//#if 730007051 
private JTextField bboxField = new JTextField();
//#endif 


//#if -815286616 
private JLabel fillLabel =
        new JLabel(Translator.localize("label.stylepane.fill") + ": ");
//#endif 


//#if 1725906795 
private JComboBox fillField = new JComboBox();
//#endif 


//#if 1348799432 
private JLabel lineLabel =
        new JLabel(Translator.localize("label.stylepane.line") + ": ");
//#endif 


//#if 1723606426 
private JComboBox lineField = new JComboBox();
//#endif 


//#if 1467911856 
private JLabel stereoLabel =
        new JLabel(Translator.localize("menu.popup.stereotype-view") + ": ");
//#endif 


//#if 1313706134 
private JComboBox stereoField = new JComboBox();
//#endif 


//#if -351745788 
private SpacerPanel spacer = new SpacerPanel();
//#endif 


//#if -1986807016 
private SpacerPanel spacer2 = new SpacerPanel();
//#endif 


//#if 1463688409 
private SpacerPanel spacer3 = new SpacerPanel();
//#endif 


//#if -404176679 
private static final long serialVersionUID = -6232843473753751128L;
//#endif 


//#if -190686151 
private static final Logger LOG = Logger.getLogger(StylePanelFig.class);
//#endif 


//#if -1472950744 
protected JComboBox getLineField()
    { 

//#if 60983052 
return lineField;
//#endif 

} 

//#endif 


//#if 850209046 
protected JLabel getFillLabel()
    { 

//#if -790280334 
return fillLabel;
//#endif 

} 

//#endif 


//#if 165975998 
protected Rectangle parseBBox()
    { 

//#if -163034090 
Fig target = getPanelTarget();
//#endif 


//#if -422297746 
String bboxStr = bboxField.getText().trim();
//#endif 


//#if 371281853 
if(bboxStr.length() == 0)//1
{ 

//#if 464137513 
return null;
//#endif 

} 

//#endif 


//#if 2030930620 
Rectangle res = new Rectangle();
//#endif 


//#if 388094583 
java.util.StringTokenizer st =
            new java.util.StringTokenizer(bboxStr, ", ");
//#endif 


//#if -768597293 
try //1
{ 

//#if 848500299 
boolean changed = false;
//#endif 


//#if 1067007993 
if(!st.hasMoreTokens())//1
{ 

//#if -1799695983 
return target.getBounds();
//#endif 

} 

//#endif 


//#if -1637532169 
res.x = Integer.parseInt(st.nextToken());
//#endif 


//#if 182238232 
if(!st.hasMoreTokens())//2
{ 

//#if 250902048 
res.y = target.getBounds().y;
//#endif 


//#if 1738797312 
res.width = target.getBounds().width;
//#endif 


//#if 787677486 
res.height = target.getBounds().height;
//#endif 


//#if -1597542150 
return res;
//#endif 

} 

//#endif 


//#if 87948728 
res.y = Integer.parseInt(st.nextToken());
//#endif 


//#if 182268024 
if(!st.hasMoreTokens())//3
{ 

//#if -731052680 
res.width = target.getBounds().width;
//#endif 


//#if -1916217434 
res.height = target.getBounds().height;
//#endif 


//#if 1235289474 
return res;
//#endif 

} 

//#endif 


//#if 1773153733 
res.width = Integer.parseInt(st.nextToken());
//#endif 


//#if -1695667789 
if((res.width + res.x) > 6000)//1
{ 

//#if -100890975 
res.width = 6000 - res.x;
//#endif 


//#if -1475055034 
changed = true;
//#endif 

} 

//#endif 


//#if 182297816 
if(!st.hasMoreTokens())//4
{ 

//#if 380806214 
res.width = target.getBounds().width;
//#endif 


//#if 1944193780 
return res;
//#endif 

} 

//#endif 


//#if 1414446654 
res.height = Integer.parseInt(st.nextToken());
//#endif 


//#if 156343303 
if((res.height + res.y) > 6000)//1
{ 

//#if -304351829 
res.height = 6000 - res.y;
//#endif 


//#if -2064045420 
changed = true;
//#endif 

} 

//#endif 


//#if -277388010 
if(res.x < 0 || res.y < 0)//1
{ 

//#if 48577073 
LOG.warn("Part of bounding box is off screen " + res);
//#endif 

} 

//#endif 


//#if -18258192 
if(res.width < 0 || res.height < 0)//1
{ 

//#if 628563764 
throw new IllegalArgumentException(
                    "Bounding box has negative size " + res);
//#endif 

} 

//#endif 


//#if -99118705 
if(changed)//1
{ 

//#if 1601780828 
StringBuffer sb = new StringBuffer();
//#endif 


//#if 935975748 
sb.append(Integer.toString(res.x));
//#endif 


//#if 2054429297 
sb.append(",");
//#endif 


//#if 936005539 
sb.append(Integer.toString(res.y));
//#endif 


//#if 219265601 
sb.append(",");
//#endif 


//#if 1993427638 
sb.append(Integer.toString(res.width));
//#endif 


//#if 219265602 
sb.append(",");
//#endif 


//#if 105059731 
sb.append(Integer.toString(res.height));
//#endif 


//#if -943086210 
bboxField.setText(sb.toString());
//#endif 

} 

//#endif 

} 

//#if -136691752 
catch (NumberFormatException ex) //1
{ 

//#if -163838059 
bboxField.setBackground(Color.RED);
//#endif 


//#if -1534890 
return null;
//#endif 

} 

//#endif 


//#if 472515687 
catch (IllegalArgumentException iae) //1
{ 

//#if -1910770994 
bboxField.setBackground(Color.RED);
//#endif 


//#if 2105105039 
return null;
//#endif 

} 

//#endif 


//#endif 


//#if 625314955 
bboxField.setBackground(null);
//#endif 


//#if -1705773464 
return res;
//#endif 

} 

//#endif 


//#if -639617412 
public void setTargetFill()
    { 

//#if 1654471202 
Fig target = getPanelTarget();
//#endif 


//#if 1463950167 
Object c = fillField.getSelectedItem();
//#endif 


//#if -1044140832 
if(target == null || c == null)//1
{ 

//#if -1189862077 
return;
//#endif 

} 

//#endif 


//#if 1656428979 
Boolean isColor = (c instanceof Color);
//#endif 


//#if 228790119 
if(isColor)//1
{ 

//#if -1427020419 
target.setFillColor((Color) c);
//#endif 

} 

//#endif 


//#if 286389179 
target.setFilled(isColor);
//#endif 


//#if -1759748639 
target.endTrans();
//#endif 


//#if 218146668 
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if 482919518 
for (Object t : TargetManager.getInstance().getTargets()) //1
{ 

//#if -473932493 
Fig fig = null;
//#endif 


//#if 612380784 
if(t instanceof FigNodeModelElement)//1
{ 

//#if 148142610 
fig = (Fig) t;
//#endif 

} 
else
{ 

//#if -1522723665 
fig = activeDiagram.presentationFor(t);
//#endif 

} 

//#endif 


//#if -156302463 
if(fig != null && fig != target)//1
{ 

//#if 1417660702 
if(isColor)//1
{ 

//#if -1895772065 
fig.setFillColor((Color) c);
//#endif 

} 

//#endif 


//#if 744948821 
fig.setFilled(isColor);
//#endif 


//#if 221292667 
fig.endTrans();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 957055577 
protected SpacerPanel getSpacer2()
    { 

//#if 540785262 
return spacer2;
//#endif 

} 

//#endif 


//#if -671883330 
protected void handleCustomColor(JComboBox field, String title,
                                     Color targetColor)
    { 

//#if -1634821411 
Color newColor =
            JColorChooser.showDialog(ArgoFrame.getInstance(),
                                     Translator.localize(title), targetColor);
//#endif 


//#if -617201048 
if(newColor != null)//1
{ 

//#if -1191548759 
field.insertItemAt(newColor, field.getItemCount() - 1);
//#endif 


//#if -1423314171 
field.setSelectedItem(newColor);
//#endif 

} 
else

//#if 424877830 
if(getPanelTarget() != null)//1
{ 

//#if -1264417201 
field.setSelectedItem(targetColor);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 23723397 
protected JLabel getLineLabel()
    { 

//#if 1177115558 
return lineLabel;
//#endif 

} 

//#endif 


//#if 1128630736 
protected JLabel getBBoxLabel()
    { 

//#if 450511116 
return bboxLabel;
//#endif 

} 

//#endif 


//#if 817571145 
public void keyPressed(KeyEvent e)
    { 
} 

//#endif 


//#if -646465095 
protected JComboBox getFillField()
    { 

//#if 795248464 
return fillField;
//#endif 

} 

//#endif 


//#if -456235093 
public StylePanelFig()
    { 

//#if 1520933491 
super("Fig Appearance");
//#endif 


//#if 457447878 
initChoices();
//#endif 


//#if 276014429 
Document bboxDoc = bboxField.getDocument();
//#endif 


//#if -81683403 
bboxDoc.addDocumentListener(this);
//#endif 


//#if -1709568037 
bboxField.addKeyListener(this);
//#endif 


//#if 892408514 
bboxField.addFocusListener(this);
//#endif 


//#if -656854571 
fillField.addItemListener(this);
//#endif 


//#if -366688058 
lineField.addItemListener(this);
//#endif 


//#if -937197750 
stereoField.addItemListener(this);
//#endif 


//#if 702651073 
fillField.setRenderer(new ColorRenderer());
//#endif 


//#if -2055866254 
lineField.setRenderer(new ColorRenderer());
//#endif 


//#if -340561279 
bboxLabel.setLabelFor(bboxField);
//#endif 


//#if 1447215880 
add(bboxLabel);
//#endif 


//#if 649165710 
add(bboxField);
//#endif 


//#if -1144309555 
fillLabel.setLabelFor(fillField);
//#endif 


//#if -1132708242 
add(fillLabel);
//#endif 


//#if -1930758412 
add(fillField);
//#endif 


//#if -1565567893 
lineLabel.setLabelFor(lineField);
//#endif 


//#if -1959193891 
add(lineLabel);
//#endif 


//#if 1537723235 
add(lineField);
//#endif 


//#if 2097881635 
stereoLabel.setLabelFor(stereoField);
//#endif 


//#if 1025079193 
add(stereoLabel);
//#endif 


//#if 227029023 
add(stereoField);
//#endif 

} 

//#endif 


//#if 862156443 
protected SpacerPanel getSpacer()
    { 

//#if -519055438 
return spacer;
//#endif 

} 

//#endif 


//#if 1846037780 
public void itemStateChanged(ItemEvent e)
    { 

//#if -713161242 
Object src = e.getSource();
//#endif 


//#if 92028663 
Fig target = getPanelTarget();
//#endif 


//#if 1720326498 
if(e.getStateChange() == ItemEvent.SELECTED
                && target != null)//1
{ 

//#if -912524339 
if(src == fillField)//1
{ 

//#if 76313331 
if(e.getItem() == CUSTOM_ITEM)//1
{ 

//#if 924648039 
handleCustomColor(fillField,
                                      "label.stylepane.custom-fill-color",
                                      target.getFillColor());
//#endif 

} 

//#endif 


//#if 198270660 
setTargetFill();
//#endif 

} 
else

//#if -181041434 
if(src == lineField)//1
{ 

//#if -1232593125 
if(e.getItem() == CUSTOM_ITEM)//1
{ 

//#if 417843955 
handleCustomColor(lineField,
                                      "label.stylepane.custom-line-color",
                                      target.getLineColor());
//#endif 

} 

//#endif 


//#if -1249490037 
setTargetLine();
//#endif 

} 
else

//#if -1247722676 
if(src == stereoField)//1
{ 

//#if -308519240 
if(target instanceof StereotypeStyled)//1
{ 

//#if -1214730457 
Object item = e.getItem();
//#endif 


//#if 1797163528 
DefaultComboBoxModel model =
                        (DefaultComboBoxModel) stereoField.getModel();
//#endif 


//#if -56895420 
int idx = model.getIndexOf(item);
//#endif 


//#if -222378638 
StereotypeStyled fig = (StereotypeStyled) target;
//#endif 


//#if -1102900511 
fig.setStereotypeStyle(StereotypeStyle.getEnum(idx));
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1929976755 
public void focusLost(FocusEvent e)
    { 

//#if 1313679141 
if(e.getSource() == bboxField)//1
{ 

//#if 1590903157 
setTargetBBox();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2023652129 
public void refresh()
    { 

//#if 761082099 
Fig target = getPanelTarget();
//#endif 


//#if 1392099700 
if(target instanceof FigEdgeModelElement)//1
{ 

//#if 2004296362 
hasEditableBoundingBox(false);
//#endif 

} 
else
{ 

//#if 1738486834 
hasEditableBoundingBox(true);
//#endif 

} 

//#endif 


//#if -131966709 
if(target == null)//1
{ 

//#if 199675926 
return;
//#endif 

} 

//#endif 


//#if -2048658119 
Rectangle figBounds = target.getBounds();
//#endif 


//#if -525710748 
Rectangle styleBounds = parseBBox();
//#endif 


//#if 813003180 
if(!(figBounds.equals(styleBounds)))//1
{ 

//#if 487090995 
bboxField.setText(figBounds.x + "," + figBounds.y + ","
                              + figBounds.width + "," + figBounds.height);
//#endif 

} 

//#endif 


//#if 1808136071 
if(target.isFilled())//1
{ 

//#if -985481738 
Color c = target.getFillColor();
//#endif 


//#if 284959084 
fillField.setSelectedItem(c);
//#endif 


//#if -293337653 
if(c != null && !fillField.getSelectedItem().equals(c))//1
{ 

//#if -1576676902 
fillField.insertItemAt(c, fillField.getItemCount() - 1);
//#endif 


//#if -992984015 
fillField.setSelectedItem(c);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1603009691 
fillField.setSelectedIndex(0);
//#endif 

} 

//#endif 


//#if -1491959351 
if(target.getLineWidth() > 0)//1
{ 

//#if 1579688195 
Color c = target.getLineColor();
//#endif 


//#if -23854665 
lineField.setSelectedItem(c);
//#endif 


//#if 1898695646 
if(c != null && !lineField.getSelectedItem().equals(c))//1
{ 

//#if -166330160 
lineField.insertItemAt(c, lineField.getItemCount() - 1);
//#endif 


//#if -972834122 
lineField.setSelectedItem(c);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1310057297 
lineField.setSelectedIndex(0);
//#endif 

} 

//#endif 


//#if -2098772975 
stereoField.setEnabled(target instanceof StereotypeStyled);
//#endif 


//#if -1551450997 
stereoLabel.setEnabled(target instanceof StereotypeStyled);
//#endif 


//#if 603840725 
if(target instanceof StereotypeStyled)//1
{ 

//#if -1366762995 
StereotypeStyled fig = (StereotypeStyled) target;
//#endif 


//#if -1666141266 
stereoField.setSelectedIndex(fig.getStereotypeStyle().ordinal());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1262669935 
protected JTextField getBBoxField()
    { 

//#if 1358935740 
return bboxField;
//#endif 

} 

//#endif 


//#if -2144054458 
public void keyReleased(KeyEvent e)
    { 
} 

//#endif 


//#if -492612071 
protected void setTargetBBox()
    { 

//#if 339346703 
Fig target = getPanelTarget();
//#endif 


//#if -1422718681 
if(target == null)//1
{ 

//#if 2074254975 
return;
//#endif 

} 

//#endif 


//#if 549989243 
Rectangle bounds = parseBBox();
//#endif 


//#if 1200189771 
if(bounds == null)//1
{ 

//#if -2010060903 
return;
//#endif 

} 

//#endif 


//#if -647798824 
if(!target.getBounds().equals(bounds))//1
{ 

//#if -1971031514 
target.setBounds(bounds.x, bounds.y, bounds.width,
                             bounds.height);
//#endif 


//#if 1621872074 
target.endTrans();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -734692095 
public void keyTyped(KeyEvent e)
    { 

//#if -392242387 
if(e.getSource().equals(bboxField) && e.getKeyChar() == '\n')//1
{ 

//#if -1717266683 
setTargetBBox();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -467789651 
public void setTargetLine()
    { 

//#if 1932439558 
Fig target = getPanelTarget();
//#endif 


//#if -2026652316 
Object c = lineField.getSelectedItem();
//#endif 


//#if -1017056388 
if(target == null || c == null)//1
{ 

//#if 1844735531 
return;
//#endif 

} 

//#endif 


//#if 722991951 
Boolean isColor = (c instanceof Color);
//#endif 


//#if -1980508413 
if(isColor)//1
{ 

//#if -1539268368 
target.setLineColor((Color) c);
//#endif 

} 

//#endif 


//#if -991450220 
target.setLineWidth(isColor ? ArgoFig.LINE_WIDTH : 0);
//#endif 


//#if 1749546877 
target.endTrans();
//#endif 


//#if -1935034800 
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -972011270 
for (Object t : TargetManager.getInstance().getTargets()) //1
{ 

//#if -1976764270 
Fig fig = null;
//#endif 


//#if -1802646031 
if(t instanceof FigNodeModelElement)//1
{ 

//#if 2096337638 
fig = (Fig) t;
//#endif 

} 
else
{ 

//#if 250716487 
fig = activeDiagram.presentationFor(t);
//#endif 

} 

//#endif 


//#if -1144081918 
if(fig != null && fig != target)//1
{ 

//#if 148519432 
if(isColor)//1
{ 

//#if 880402470 
fig.setLineColor((Color) c);
//#endif 

} 

//#endif 


//#if 2061089000 
fig.setLineWidth(isColor ? ArgoFig.LINE_WIDTH : 0);
//#endif 


//#if -467381039 
fig.endTrans();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1954945015 
protected static String getCustomItemName()
    { 

//#if -1584326223 
return CUSTOM_ITEM;
//#endif 

} 

//#endif 


//#if -1564131809 
protected void initChoices()
    { 

//#if -1093608766 
fillField.addItem(Translator.localize("label.stylepane.no-fill"));
//#endif 


//#if 1602732198 
fillField.addItem(Color.black);
//#endif 


//#if -1341154736 
fillField.addItem(Color.white);
//#endif 


//#if 477501696 
fillField.addItem(Color.gray);
//#endif 


//#if 1717340224 
fillField.addItem(Color.lightGray);
//#endif 


//#if -736299370 
fillField.addItem(Color.darkGray);
//#endif 


//#if -383892126 
fillField.addItem(new Color(255, 255, 200));
//#endif 


//#if -55904926 
fillField.addItem(new Color(255, 200, 255));
//#endif 


//#if 442475874 
fillField.addItem(new Color(200, 255, 255));
//#endif 


//#if 765696514 
fillField.addItem(new Color(200, 200, 255));
//#endif 


//#if 437709314 
fillField.addItem(new Color(200, 255, 200));
//#endif 


//#if -60671486 
fillField.addItem(new Color(255, 200, 200));
//#endif 


//#if 760929954 
fillField.addItem(new Color(200, 200, 200));
//#endif 


//#if 440817144 
fillField.addItem(Color.red);
//#endif 


//#if 329391415 
fillField.addItem(Color.blue);
//#endif 


//#if 369439168 
fillField.addItem(Color.cyan);
//#endif 


//#if -2019109871 
fillField.addItem(Color.yellow);
//#endif 


//#if -973468272 
fillField.addItem(Color.magenta);
//#endif 


//#if 1920814762 
fillField.addItem(Color.green);
//#endif 


//#if 366939979 
fillField.addItem(Color.orange);
//#endif 


//#if 727226195 
fillField.addItem(Color.pink);
//#endif 


//#if -1121960205 
fillField.addItem(CUSTOM_ITEM);
//#endif 


//#if 34705252 
lineField.addItem(Translator.localize("label.stylepane.no-line"));
//#endif 


//#if -1713043563 
lineField.addItem(Color.black);
//#endif 


//#if -361963201 
lineField.addItem(Color.white);
//#endif 


//#if 1894561841 
lineField.addItem(Color.gray);
//#endif 


//#if 298762159 
lineField.addItem(Color.lightGray);
//#endif 


//#if -1059154617 
lineField.addItem(Color.darkGray);
//#endif 


//#if -732935907 
lineField.addItem(new Color(60, 60, 200));
//#endif 


//#if 1290728297 
lineField.addItem(new Color(60, 200, 60));
//#endif 


//#if -184904291 
lineField.addItem(new Color(200, 60, 60));
//#endif 


//#if 2010549415 
lineField.addItem(Color.red);
//#endif 


//#if 1746451560 
lineField.addItem(Color.blue);
//#endif 


//#if 1786499313 
lineField.addItem(Color.cyan);
//#endif 


//#if -1728943358 
lineField.addItem(Color.yellow);
//#endif 


//#if -568240961 
lineField.addItem(Color.magenta);
//#endif 


//#if -1394960999 
lineField.addItem(Color.green);
//#endif 


//#if 657106492 
lineField.addItem(Color.orange);
//#endif 


//#if 2144286340 
lineField.addItem(Color.pink);
//#endif 


//#if -142768670 
lineField.addItem(CUSTOM_ITEM);
//#endif 


//#if -1944400701 
DefaultComboBoxModel model = new DefaultComboBoxModel();
//#endif 


//#if 667090715 
stereoField.setModel(model);
//#endif 


//#if -341052943 
model.addElement(Translator
                         .localize("menu.popup.stereotype-view.textual"));
//#endif 


//#if -1886070310 
model.addElement(Translator
                         .localize("menu.popup.stereotype-view.big-icon"));
//#endif 


//#if -1776695565 
model.addElement(Translator
                         .localize("menu.popup.stereotype-view.small-icon"));
//#endif 

} 

//#endif 


//#if 361859219 
public void focusGained(FocusEvent e)
    { 
} 

//#endif 


//#if -1949330875 
protected void hasEditableBoundingBox(boolean value)
    { 

//#if 1960021265 
bboxField.setEnabled(value);
//#endif 


//#if 1553918167 
bboxLabel.setEnabled(value);
//#endif 

} 

//#endif 


//#if 1451491200 
public StylePanelFig(String title)
    { 

//#if 2004097291 
super(title);
//#endif 

} 

//#endif 


//#if 957056538 
protected SpacerPanel getSpacer3()
    { 

//#if -1587947151 
return spacer3;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

