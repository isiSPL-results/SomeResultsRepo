
//#if 900333727 
// Compilation Unit of /StylePanelFigText.java 
 

//#if -1470193210 
package org.argouml.ui;
//#endif 


//#if -1006839475 
import java.awt.Color;
//#endif 


//#if 1109111677 
import java.awt.event.ItemEvent;
//#endif 


//#if 86176963 
import javax.swing.JComboBox;
//#endif 


//#if 1576108962 
import javax.swing.JLabel;
//#endif 


//#if 1236165205 
import org.argouml.i18n.Translator;
//#endif 


//#if -1146220910 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 59800421 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1210987050 
import org.tigris.gef.ui.ColorRenderer;
//#endif 


//#if -1157212079 
public class StylePanelFigText extends 
//#if 288106307 
StylePanelFig
//#endif 

  { 

//#if 608161503 
private static final String[] FONT_NAMES = {
        "dialog", "serif", "sanserif",
        "monospaced",
    };
//#endif 


//#if 677328800 
private static final Integer[] COMMON_SIZES = {
        Integer.valueOf(8), Integer.valueOf(9),
        Integer.valueOf(10), Integer.valueOf(12),
        Integer.valueOf(16), Integer.valueOf(18),
        Integer.valueOf(24), Integer.valueOf(36),
        Integer.valueOf(48), Integer.valueOf(72),
        Integer.valueOf(96),
    };
//#endif 


//#if 1116724449 
private static final String[] STYLES = {
        "Plain", "Bold", "Italic",
        "Bold-Italic",
    };
//#endif 


//#if -804112754 
private static final String[] JUSTIFIES = {
        "Left", "Right", "Center",
    };
//#endif 


//#if 2105955672 
private JLabel fontLabel = new JLabel(
        Translator.localize("label.stylepane.font") + ": ");
//#endif 


//#if -1952402969 
private JComboBox fontField = new JComboBox(FONT_NAMES);
//#endif 


//#if -763917928 
private JLabel sizeLabel = new JLabel(
        Translator.localize("label.stylepane.size") + ": ");
//#endif 


//#if 377195931 
private JComboBox sizeField = new JComboBox(COMMON_SIZES);
//#endif 


//#if 1133811196 
private JLabel styleLabel = new JLabel(
        Translator.localize("label.stylepane.style") + ": ");
//#endif 


//#if -563386989 
private JComboBox styleField = new JComboBox(STYLES);
//#endif 


//#if -2135003788 
private JLabel justLabel = new JLabel(
        Translator.localize("label.stylepane.justify") + ": ");
//#endif 


//#if -1677055616 
private JComboBox justField = new JComboBox(JUSTIFIES);
//#endif 


//#if -1756399325 
private JLabel textColorLabel = new JLabel(
        Translator.localize("label.stylepane.text-color") + ": ");
//#endif 


//#if -987271156 
private JComboBox textColorField = new JComboBox();
//#endif 


//#if 889247289 
private static final long serialVersionUID = 2019248527481196634L;
//#endif 


//#if -100769128 
protected void setTargetTextColor()
    { 

//#if 50574030 
if(getPanelTarget() == null)//1
{ 

//#if 66441403 
return;
//#endif 

} 

//#endif 


//#if 1312974107 
Object c = textColorField.getSelectedItem();
//#endif 


//#if 1519072379 
if(c instanceof Color)//1
{ 

//#if -921874697 
((FigText) getPanelTarget()).setTextColor((Color) c);
//#endif 

} 

//#endif 


//#if -171279605 
getPanelTarget().endTrans();
//#endif 

} 

//#endif 


//#if -1464973756 
public void itemStateChanged(ItemEvent e)
    { 

//#if -242299393 
Object src = e.getSource();
//#endif 


//#if 174183486 
Fig target = getPanelTarget();
//#endif 


//#if -1358794257 
if(e.getStateChange() == ItemEvent.SELECTED
                && target instanceof FigText)//1
{ 

//#if 2005617382 
if(src == fontField)//1
{ 

//#if -905248941 
setTargetFont();
//#endif 

} 
else

//#if 175681620 
if(src == sizeField)//1
{ 

//#if -1828715896 
setTargetSize();
//#endif 

} 
else

//#if 854379838 
if(src == styleField)//1
{ 

//#if 11828581 
setTargetStyle();
//#endif 

} 
else

//#if 396503422 
if(src == justField)//1
{ 

//#if -932019391 
setTargetJustification();
//#endif 

} 
else

//#if -640584335 
if(src == textColorField)//1
{ 

//#if 497658083 
if(e.getItem() == getCustomItemName())//1
{ 

//#if -2113355981 
handleCustomColor(textColorField,
                                      "label.stylepane.custom-text-color",
                                      ((FigText) target).getTextColor());
//#endif 

} 

//#endif 


//#if 1606270082 
setTargetTextColor();
//#endif 

} 
else
{ 

//#if 2095178990 
super.itemStateChanged(e);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 559034353 
public void refresh()
    { 

//#if -1639134065 
super.refresh();
//#endif 


//#if 1080057910 
FigText ft = (FigText) getPanelTarget();
//#endif 


//#if 1142711147 
if(ft == null)//1
{ 

//#if 782044963 
return;
//#endif 

} 

//#endif 


//#if 252327731 
String fontName = ft.getFontFamily().toLowerCase();
//#endif 


//#if -745943766 
int size = ft.getFontSize();
//#endif 


//#if -1817129212 
String styleName = STYLES[0];
//#endif 


//#if -839272572 
fontField.setSelectedItem(fontName);
//#endif 


//#if 1630409696 
sizeField.setSelectedItem(Integer.valueOf(size));
//#endif 


//#if 444458386 
if(ft.getBold())//1
{ 

//#if -568995545 
styleName = STYLES[1];
//#endif 

} 

//#endif 


//#if 238229501 
if(ft.getItalic())//1
{ 

//#if 1880205742 
styleName = STYLES[2];
//#endif 

} 

//#endif 


//#if -684557735 
if(ft.getBold() && ft.getItalic())//1
{ 

//#if 1975243435 
styleName = STYLES[3];
//#endif 

} 

//#endif 


//#if 1809397230 
styleField.setSelectedItem(styleName);
//#endif 


//#if -785899191 
String justName = JUSTIFIES[0];
//#endif 


//#if -1527209104 
int justCode = ft.getJustification();
//#endif 


//#if 1634739282 
if(justCode >= 0 && justCode <= JUSTIFIES.length)//1
{ 

//#if 822456990 
justName = JUSTIFIES[justCode];
//#endif 

} 

//#endif 


//#if -1949291778 
justField.setSelectedItem(justName);
//#endif 


//#if -1076929734 
Color c = ft.getTextColor();
//#endif 


//#if -2026394288 
textColorField.setSelectedItem(c);
//#endif 


//#if 1807422381 
if(c != null && !textColorField.getSelectedItem().equals(c))//1
{ 

//#if -1273197638 
textColorField.insertItemAt(c, textColorField.getItemCount() - 1);
//#endif 


//#if -106682024 
textColorField.setSelectedItem(c);
//#endif 

} 

//#endif 


//#if 1079208231 
if(ft.isFilled())//1
{ 

//#if -2104899886 
Color fc = ft.getFillColor();
//#endif 


//#if 2077558222 
getFillField().setSelectedItem(fc);
//#endif 


//#if -841874011 
if(fc != null && !getFillField().getSelectedItem().equals(fc))//1
{ 

//#if 1609501271 
getFillField().insertItemAt(fc,
                                            getFillField().getItemCount() - 1);
//#endif 


//#if 1579263699 
getFillField().setSelectedItem(fc);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -913044167 
getFillField().setSelectedIndex(0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2077428751 
protected void setTargetFont()
    { 

//#if -1399197428 
if(getPanelTarget() == null)//1
{ 

//#if -1918327741 
return;
//#endif 

} 

//#endif 


//#if 1056757571 
String fontStr = (String) fontField.getSelectedItem();
//#endif 


//#if -411578552 
if(fontStr.length() == 0)//1
{ 

//#if 2136789612 
return;
//#endif 

} 

//#endif 


//#if 1799420246 
((FigText) getPanelTarget()).setFontFamily(fontStr);
//#endif 


//#if -1049330419 
getPanelTarget().endTrans();
//#endif 

} 

//#endif 


//#if -999000696 
public StylePanelFigText()
    { 

//#if -928170746 
super();
//#endif 


//#if -1983915334 
fontField.addItemListener(this);
//#endif 


//#if -1826091156 
sizeField.addItemListener(this);
//#endif 


//#if 715252206 
styleField.addItemListener(this);
//#endif 


//#if 726984151 
justField.addItemListener(this);
//#endif 


//#if -1309764493 
textColorField.addItemListener(this);
//#endif 


//#if -565522465 
textColorField.setRenderer(new ColorRenderer());
//#endif 


//#if 1630300944 
textColorLabel.setLabelFor(textColorField);
//#endif 


//#if 601709118 
add(textColorLabel);
//#endif 


//#if -196341052 
add(textColorField);
//#endif 


//#if -1512700749 
addSeperator();
//#endif 


//#if 1225037884 
fontLabel.setLabelFor(fontField);
//#endif 


//#if -1984318231 
add(fontLabel);
//#endif 


//#if 1512598895 
add(fontField);
//#endif 


//#if 529201624 
sizeLabel.setLabelFor(sizeField);
//#endif 


//#if 1017230583 
add(sizeLabel);
//#endif 


//#if 219180413 
add(sizeField);
//#endif 


//#if 1355567856 
styleLabel.setLabelFor(styleField);
//#endif 


//#if -1556651677 
add(styleLabel);
//#endif 


//#if 1940265449 
add(styleField);
//#endif 


//#if -860713598 
justLabel.setLabelFor(justField);
//#endif 


//#if 2086359468 
add(justLabel);
//#endif 


//#if 1288309298 
add(justField);
//#endif 


//#if -113889341 
initChoices2();
//#endif 

} 

//#endif 


//#if -1850557631 
protected void setTargetSize()
    { 

//#if 2072929330 
if(getPanelTarget() == null)//1
{ 

//#if 1424367913 
return;
//#endif 

} 

//#endif 


//#if -1042321608 
Integer size = (Integer) sizeField.getSelectedItem();
//#endif 


//#if -1602996537 
((FigText) getPanelTarget()).setFontSize(size.intValue());
//#endif 


//#if 171052327 
getPanelTarget().endTrans();
//#endif 

} 

//#endif 


//#if 356067284 
protected void setTargetJustification()
    { 

//#if -35334166 
if(getPanelTarget() == null)//1
{ 

//#if -650712359 
return;
//#endif 

} 

//#endif 


//#if 36892767 
String justStr = (String) justField.getSelectedItem();
//#endif 


//#if -1733729223 
if(justStr == null)//1
{ 

//#if -1611188081 
return;
//#endif 

} 

//#endif 


//#if -170737106 
((FigText) getPanelTarget()).setJustificationByName(justStr);
//#endif 


//#if -35503505 
getPanelTarget().endTrans();
//#endif 

} 

//#endif 


//#if -1218447405 
protected void setTargetStyle()
    { 

//#if 613850716 
if(getPanelTarget() == null)//1
{ 

//#if -1559347090 
return;
//#endif 

} 

//#endif 


//#if -916937539 
String styleStr = (String) styleField.getSelectedItem();
//#endif 


//#if -426828452 
if(styleStr == null)//1
{ 

//#if -1889403166 
return;
//#endif 

} 

//#endif 


//#if 1570603405 
boolean bold = (styleStr.indexOf("Bold") != -1);
//#endif 


//#if -1468090141 
boolean italic = (styleStr.indexOf("Italic") != -1);
//#endif 


//#if -1525885517 
((FigText) getPanelTarget()).setBold(bold);
//#endif 


//#if -79114733 
((FigText) getPanelTarget()).setItalic(italic);
//#endif 


//#if -1954224707 
getPanelTarget().endTrans();
//#endif 

} 

//#endif 


//#if -1858301915 
protected void initChoices2()
    { 

//#if -1408273217 
textColorField.addItem(Color.black);
//#endif 


//#if -57192855 
textColorField.addItem(Color.white);
//#endif 


//#if -1836384825 
textColorField.addItem(Color.gray);
//#endif 


//#if 21661657 
textColorField.addItem(Color.lightGray);
//#endif 


//#if -1206640675 
textColorField.addItem(Color.darkGray);
//#endif 


//#if -2127676335 
textColorField.addItem(Color.red);
//#endif 


//#if -1984495106 
textColorField.addItem(Color.blue);
//#endif 


//#if -1090190653 
textColorField.addItem(Color.green);
//#endif 


//#if 1515052626 
textColorField.addItem(Color.orange);
//#endif 


//#if -1586660326 
textColorField.addItem(Color.pink);
//#endif 


//#if 727860529 
textColorField.addItem(getCustomItemName());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

