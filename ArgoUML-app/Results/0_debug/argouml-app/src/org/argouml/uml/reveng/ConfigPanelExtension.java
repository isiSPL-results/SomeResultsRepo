
//#if -2062971784 
// Compilation Unit of /ConfigPanelExtension.java 
 

//#if 647757162 
package org.argouml.uml.reveng;
//#endif 


//#if -477668361 
import java.awt.GridBagConstraints;
//#endif 


//#if 1002862559 
import java.awt.GridBagLayout;
//#endif 


//#if -630283467 
import java.awt.Insets;
//#endif 


//#if -199600414 
import javax.swing.ButtonGroup;
//#endif 


//#if -1816974302 
import javax.swing.JCheckBox;
//#endif 


//#if 1083630813 
import javax.swing.JLabel;
//#endif 


//#if 1198504909 
import javax.swing.JPanel;
//#endif 


//#if -1885683868 
import javax.swing.JRadioButton;
//#endif 


//#if 1522754596 
import javax.swing.JTextField;
//#endif 


//#if -1762257242 
import org.argouml.configuration.Configuration;
//#endif 


//#if -2019659887 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if -1317850246 
import org.argouml.i18n.Translator;
//#endif 


//#if 237472581 
public class ConfigPanelExtension extends 
//#if 471483183 
JPanel
//#endif 

  { 

//#if -2018306080 
public static final ConfigurationKey KEY_IMPORT_EXTENDED_MODEL_ATTR =
        Configuration
        .makeKey("import", "extended", "java", "model", "attributes");
//#endif 


//#if -1163470810 
public static final ConfigurationKey KEY_IMPORT_EXTENDED_MODEL_ARRAYS =
        Configuration.makeKey("import", "extended", "java", "model", "arrays");
//#endif 


//#if 1617328678 
public static final ConfigurationKey KEY_IMPORT_EXTENDED_COLLECTIONS_FLAG =
        Configuration
        .makeKey("import", "extended", "java", "collections", "flag");
//#endif 


//#if -2101497114 
public static final ConfigurationKey KEY_IMPORT_EXTENDED_COLLECTIONS_LIST =
        Configuration
        .makeKey("import", "extended", "java", "collections", "list");
//#endif 


//#if -304598708 
public static final ConfigurationKey KEY_IMPORT_EXTENDED_ORDEREDCOLLS_FLAG =
        Configuration
        .makeKey("import", "extended", "java", "orderedcolls", "flag");
//#endif 


//#if 1605349864 
public static final ConfigurationKey KEY_IMPORT_EXTENDED_ORDEREDCOLLS_LIST =
        Configuration
        .makeKey("import", "extended", "java", "orderedcolls", "list");
//#endif 


//#if -1262150975 
private JPanel configPanel;
//#endif 


//#if 1281397776 
private JRadioButton attribute;
//#endif 


//#if 515708358 
private JRadioButton datatype;
//#endif 


//#if 2028831019 
private JCheckBox modelcollections, modelorderedcollections;
//#endif 


//#if 15130513 
private JTextField collectionlist, orderedcollectionlist;
//#endif 


//#if 1525573966 
private GridBagConstraints createGridBagConstraints(boolean topInset,
            boolean bottomInset, boolean fill)
    { 

//#if -329659632 
GridBagConstraints gbc = new GridBagConstraints();
//#endif 


//#if -1965270041 
gbc.gridx = GridBagConstraints.RELATIVE;
//#endif 


//#if -1953953914 
gbc.gridy = GridBagConstraints.RELATIVE;
//#endif 


//#if -1481754580 
gbc.gridwidth = GridBagConstraints.REMAINDER;
//#endif 


//#if 985311091 
gbc.gridheight = 1;
//#endif 


//#if 623798060 
gbc.weightx = 1.0;
//#endif 


//#if 652397420 
gbc.weighty = 0.0;
//#endif 


//#if 340006944 
gbc.anchor = GridBagConstraints.NORTHWEST;
//#endif 


//#if -1529015762 
gbc.fill = fill ? GridBagConstraints.HORIZONTAL
                   : GridBagConstraints.NONE;
//#endif 


//#if -2089595332 
gbc.insets =
            new Insets(
            topInset ? 5 : 0,
            5,
            bottomInset ? 5 : 0,
            5);
//#endif 


//#if 658156321 
gbc.ipadx = 0;
//#endif 


//#if 658186112 
gbc.ipady = 0;
//#endif 


//#if -72178556 
return gbc;
//#endif 

} 

//#endif 


//#if -1542289830 
public JRadioButton getDatatype()
    { 

//#if 307183544 
return datatype;
//#endif 

} 

//#endif 


//#if 2061465381 
private GridBagConstraints createGridBagConstraintsFinal()
    { 

//#if -1839863744 
GridBagConstraints gbc = createGridBagConstraints(false, true, false);
//#endif 


//#if -383778347 
gbc.gridheight = GridBagConstraints.REMAINDER;
//#endif 


//#if 1194985113 
gbc.weighty = 1.0;
//#endif 


//#if -1155392046 
return gbc;
//#endif 

} 

//#endif 


//#if -1652990730 
public void disposeDialog()
    { 

//#if 2144854739 
Configuration.setString(KEY_IMPORT_EXTENDED_MODEL_ATTR,
                                String.valueOf(getAttribute().isSelected() ? "0" : "1"));
//#endif 


//#if -818724520 
Configuration.setString(KEY_IMPORT_EXTENDED_MODEL_ARRAYS,
                                String.valueOf(getDatatype().isSelected() ? "0" : "1"));
//#endif 


//#if -237375947 
Configuration.setString(KEY_IMPORT_EXTENDED_COLLECTIONS_FLAG,
                                String.valueOf(modelcollections.isSelected()));
//#endif 


//#if -723846187 
Configuration.setString(KEY_IMPORT_EXTENDED_COLLECTIONS_LIST,
                                String.valueOf(collectionlist.getText()));
//#endif 


//#if -206054543 
Configuration.setString(KEY_IMPORT_EXTENDED_ORDEREDCOLLS_FLAG,
                                String.valueOf(modelorderedcollections.isSelected()));
//#endif 


//#if -1785426443 
Configuration.setString(KEY_IMPORT_EXTENDED_ORDEREDCOLLS_LIST,
                                String.valueOf(orderedcollectionlist.getText()));
//#endif 

} 

//#endif 


//#if 418835356 
public ConfigPanelExtension()
    { 

//#if -828314992 
configPanel = this;
//#endif 


//#if 644034233 
configPanel.setLayout(new GridBagLayout());
//#endif 


//#if 371953160 
JLabel attributeLabel1 =
            new JLabel(
            Translator.localize("action.import-java-attr-model"));
//#endif 


//#if -467410017 
configPanel.add(attributeLabel1,
                        createGridBagConstraints(true, false, false));
//#endif 


//#if 1528814269 
ButtonGroup group1 = new ButtonGroup();
//#endif 


//#if -2029521633 
attribute =
            new JRadioButton(
            Translator.localize("action.import-java-UML-attr"));
//#endif 


//#if 713371197 
group1.add(attribute);
//#endif 


//#if 1788816141 
configPanel.add(attribute,
                        createGridBagConstraints(false, false, false));
//#endif 


//#if -1831728229 
JRadioButton association =
            new JRadioButton(
            Translator.localize("action.import-java-UML-assoc"));
//#endif 


//#if 1617550114 
group1.add(association);
//#endif 


//#if 664036197 
configPanel.add(association,
                        createGridBagConstraints(false, true, false));
//#endif 


//#if 293452356 
String modelattr =
            Configuration.getString(KEY_IMPORT_EXTENDED_MODEL_ATTR);
//#endif 


//#if 594711916 
if("1".equals(modelattr))//1
{ 

//#if 28677411 
association.setSelected(true);
//#endif 

} 
else
{ 

//#if -35426004 
attribute.setSelected(true);
//#endif 

} 

//#endif 


//#if -1705091219 
JLabel attributeLabel2 =
            new JLabel(
            Translator.localize("action.import-java-array-model"));
//#endif 


//#if -1650757314 
configPanel.add(attributeLabel2,
                        createGridBagConstraints(true, false, false));
//#endif 


//#if 684342398 
ButtonGroup group2 = new ButtonGroup();
//#endif 


//#if -1850589563 
datatype =
            new JRadioButton(
            Translator.localize(
                "action.import-java-array-model-datatype"));
//#endif 


//#if -1022167898 
group2.add(datatype);
//#endif 


//#if 795852607 
configPanel.add(datatype,
                        createGridBagConstraints(false, false, false));
//#endif 


//#if -648895368 
JRadioButton multi =
            new JRadioButton(
            Translator.localize(
                "action.import-java-array-model-multi"));
//#endif 


//#if 733035419 
group2.add(multi);
//#endif 


//#if 1441480045 
configPanel.add(multi,
                        createGridBagConstraints(false, true, false));
//#endif 


//#if -1664111708 
String modelarrays =
            Configuration.getString(KEY_IMPORT_EXTENDED_MODEL_ARRAYS);
//#endif 


//#if 536152259 
if("1".equals(modelarrays))//1
{ 

//#if 468465291 
multi.setSelected(true);
//#endif 

} 
else
{ 

//#if 2101012936 
datatype.setSelected(true);
//#endif 

} 

//#endif 


//#if 874912986 
String s = Configuration
                   .getString(KEY_IMPORT_EXTENDED_COLLECTIONS_FLAG);
//#endif 


//#if 791035874 
boolean flag = ("true".equals(s));
//#endif 


//#if 500686271 
modelcollections =
            new JCheckBox(Translator.localize(
                              "action.import-option-model-collections"), flag);
//#endif 


//#if -904991294 
configPanel.add(modelcollections,
                        createGridBagConstraints(true, false, false));
//#endif 


//#if 1378208475 
s = Configuration.getString(KEY_IMPORT_EXTENDED_COLLECTIONS_LIST);
//#endif 


//#if -995416463 
collectionlist = new JTextField(s);
//#endif 


//#if -2019963346 
configPanel.add(collectionlist,
                        createGridBagConstraints(false, false, true));
//#endif 


//#if -849446409 
JLabel listLabel =
            new JLabel(
            Translator.localize("action.import-comma-separated-names"));
//#endif 


//#if 1239696976 
configPanel.add(listLabel,
                        createGridBagConstraints(false, true, false));
//#endif 


//#if -2079557534 
s = Configuration.getString(KEY_IMPORT_EXTENDED_ORDEREDCOLLS_FLAG);
//#endif 


//#if -1915491682 
flag = ("true".equals(s));
//#endif 


//#if -968094944 
modelorderedcollections =
            new JCheckBox(Translator.localize(
                              "action.import-option-model-ordered-collections"), flag);
//#endif 


//#if 1215858983 
configPanel.add(modelorderedcollections,
                        createGridBagConstraints(true, false, false));
//#endif 


//#if -1910004460 
s = Configuration.getString(KEY_IMPORT_EXTENDED_ORDEREDCOLLS_LIST);
//#endif 


//#if -1523765254 
orderedcollectionlist = new JTextField(s);
//#endif 


//#if -997919093 
configPanel.add(orderedcollectionlist,
                        createGridBagConstraints(false, false, true));
//#endif 


//#if -463522131 
listLabel =
            new JLabel(
            Translator.localize("action.import-comma-separated-names"));
//#endif 


//#if -695967138 
configPanel.add(listLabel,
                        createGridBagConstraintsFinal());
//#endif 

} 

//#endif 


//#if -1172195640 
public JRadioButton getAttribute()
    { 

//#if -360652297 
return attribute;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

