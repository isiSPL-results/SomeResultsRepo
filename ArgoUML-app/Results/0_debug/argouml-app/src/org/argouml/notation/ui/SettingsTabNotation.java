
//#if -175508789 
// Compilation Unit of /SettingsTabNotation.java 
 

//#if -1724204031 
package org.argouml.notation.ui;
//#endif 


//#if 254766699 
import java.awt.BorderLayout;
//#endif 


//#if -1917611336 
import java.awt.Component;
//#endif 


//#if -1179460439 
import java.awt.FlowLayout;
//#endif 


//#if 1227735597 
import java.awt.GridBagConstraints;
//#endif 


//#if -46495767 
import java.awt.GridBagLayout;
//#endif 


//#if -813421973 
import java.awt.Insets;
//#endif 


//#if 1633068336 
import javax.swing.BoxLayout;
//#endif 


//#if 920122072 
import javax.swing.JCheckBox;
//#endif 


//#if -1279947682 
import javax.swing.JComboBox;
//#endif 


//#if -187135513 
import javax.swing.JLabel;
//#endif 


//#if -72261417 
import javax.swing.JPanel;
//#endif 


//#if -1925704303 
import org.argouml.application.api.Argo;
//#endif 


//#if 898592330 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 936827868 
import org.argouml.configuration.Configuration;
//#endif 


//#if 342103707 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 387553712 
import org.argouml.i18n.Translator;
//#endif 


//#if 407150292 
import org.argouml.kernel.Project;
//#endif 


//#if -306922091 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1072946673 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if -1251984916 
import org.argouml.notation.Notation;
//#endif 


//#if 919789601 
import org.argouml.notation.NotationName;
//#endif 


//#if 1108233233 
import org.argouml.swingext.JLinkButton;
//#endif 


//#if 95159056 
import org.argouml.ui.ActionProjectSettings;
//#endif 


//#if -1470746045 
import org.argouml.ui.ShadowComboBox;
//#endif 


//#if -1229260286 
public class SettingsTabNotation extends 
//#if 820051955 
JPanel
//#endif 

 implements 
//#if -1717046359 
GUISettingsTabInterface
//#endif 

  { 

//#if 1385746724 
private JComboBox notationLanguage;
//#endif 


//#if 1558873912 
private JCheckBox showBoldNames;
//#endif 


//#if 681042604 
private JCheckBox useGuillemots;
//#endif 


//#if -1217739916 
private JCheckBox showAssociationNames;
//#endif 


//#if 1835517193 
private JCheckBox showVisibility;
//#endif 


//#if -46434244 
private JCheckBox showMultiplicity;
//#endif 


//#if 401423086 
private JCheckBox showInitialValue;
//#endif 


//#if -1154097400 
private JCheckBox showProperties;
//#endif 


//#if -1499402942 
private JCheckBox showTypes;
//#endif 


//#if -331193542 
private JCheckBox showStereotypes;
//#endif 


//#if 293533191 
private JCheckBox showSingularMultiplicities;
//#endif 


//#if -1115351725 
private JCheckBox hideBidirectionalArrows;
//#endif 


//#if -1987380177 
private ShadowComboBox defaultShadowWidth;
//#endif 


//#if -935833652 
private int scope;
//#endif 


//#if -1253691086 
public void handleSettingsTabSave()
    { 

//#if -1383686843 
if(scope == Argo.SCOPE_APPLICATION)//1
{ 

//#if 638984456 
Notation.setDefaultNotation(
                (NotationName) notationLanguage.getSelectedItem());
//#endif 


//#if -546270540 
Configuration.setBoolean(Notation.KEY_SHOW_BOLD_NAMES,
                                     showBoldNames.isSelected());
//#endif 


//#if 323096133 
Configuration.setBoolean(Notation.KEY_USE_GUILLEMOTS,
                                     useGuillemots.isSelected());
//#endif 


//#if -1632817546 
Configuration.setBoolean(Notation.KEY_SHOW_ASSOCIATION_NAMES,
                                     showAssociationNames.isSelected());
//#endif 


//#if -661344985 
Configuration.setBoolean(Notation.KEY_SHOW_VISIBILITY,
                                     showVisibility.isSelected());
//#endif 


//#if -1506319801 
Configuration.setBoolean(Notation.KEY_SHOW_MULTIPLICITY,
                                     showMultiplicity.isSelected());
//#endif 


//#if 2043495836 
Configuration.setBoolean(Notation.KEY_SHOW_INITIAL_VALUE,
                                     showInitialValue.isSelected());
//#endif 


//#if 1250252615 
Configuration.setBoolean(Notation.KEY_SHOW_PROPERTIES,
                                     showProperties.isSelected());
//#endif 


//#if 1354605447 
Configuration.setBoolean(Notation.KEY_SHOW_TYPES,
                                     showTypes.isSelected());
//#endif 


//#if 2015614071 
Configuration.setBoolean(Notation.KEY_SHOW_STEREOTYPES,
                                     showStereotypes.isSelected());
//#endif 


//#if 856617476 
Configuration.setBoolean(Notation.KEY_SHOW_SINGULAR_MULTIPLICITIES,
                                     showSingularMultiplicities.isSelected());
//#endif 


//#if -1963320484 
Configuration.setBoolean(Notation.KEY_HIDE_BIDIRECTIONAL_ARROWS,
                                     hideBidirectionalArrows.isSelected());
//#endif 


//#if 255605892 
Configuration.setInteger(Notation.KEY_DEFAULT_SHADOW_WIDTH,
                                     defaultShadowWidth.getSelectedIndex());
//#endif 

} 

//#endif 


//#if 1473125646 
if(scope == Argo.SCOPE_PROJECT)//1
{ 

//#if 1271293784 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1693825770 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if -840003372 
NotationName nn = (NotationName) notationLanguage.getSelectedItem();
//#endif 


//#if -438666424 
if(nn != null)//1
{ 

//#if 1459546060 
ps.setNotationLanguage(nn.getConfigurationValue());
//#endif 

} 

//#endif 


//#if -184694873 
ps.setShowBoldNames(showBoldNames.isSelected());
//#endif 


//#if -659133041 
ps.setUseGuillemots(useGuillemots.isSelected());
//#endif 


//#if -1736918877 
ps.setShowAssociationNames(showAssociationNames.isSelected());
//#endif 


//#if 302950531 
ps.setShowVisibility(showVisibility.isSelected());
//#endif 


//#if -2080742237 
ps.setShowMultiplicity(showMultiplicity.isSelected());
//#endif 


//#if 1730342627 
ps.setShowInitialValue(showInitialValue.isSelected());
//#endif 


//#if -2080419165 
ps.setShowProperties(showProperties.isSelected());
//#endif 


//#if -1526833349 
ps.setShowTypes(showTypes.isSelected());
//#endif 


//#if 238175019 
ps.setShowStereotypes(showStereotypes.isSelected());
//#endif 


//#if 1050495043 
ps.setShowSingularMultiplicities(
                showSingularMultiplicities.isSelected());
//#endif 


//#if 526842591 
ps.setDefaultShadowWidth(defaultShadowWidth.getSelectedIndex());
//#endif 


//#if 16794845 
ps.setHideBidirectionalArrows(hideBidirectionalArrows.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 328940164 
protected static boolean getBoolean(ConfigurationKey key)
    { 

//#if 114374682 
return Configuration.getBoolean(key, false);
//#endif 

} 

//#endif 


//#if 949681642 
protected JLabel createLabel(String key)
    { 

//#if -1971777639 
return new JLabel(Translator.localize(key));
//#endif 

} 

//#endif 


//#if -255482385 
public void handleSettingsTabCancel()
    { 

//#if 1162955835 
handleSettingsTabRefresh();
//#endif 

} 

//#endif 


//#if 1873706862 
public String getTabKey()
    { 

//#if -2001915909 
return "tab.notation";
//#endif 

} 

//#endif 


//#if -437208148 
protected JCheckBox createCheckBox(String key)
    { 

//#if -2050824686 
JCheckBox j = new JCheckBox(Translator.localize(key));
//#endif 


//#if -1740868111 
return j;
//#endif 

} 

//#endif 


//#if -557615402 
public void handleResetToDefault()
    { 

//#if 1813596820 
if(scope == Argo.SCOPE_PROJECT)//1
{ 

//#if -1247978718 
notationLanguage.setSelectedItem(Notation.getConfiguredNotation());
//#endif 


//#if 96147995 
showBoldNames.setSelected(getBoolean(
                                          Notation.KEY_SHOW_BOLD_NAMES));
//#endif 


//#if 1017044628 
useGuillemots.setSelected(getBoolean(
                                          Notation.KEY_USE_GUILLEMOTS));
//#endif 


//#if -206488091 
showAssociationNames.setSelected(Configuration.getBoolean(
                                                 Notation.KEY_SHOW_ASSOCIATION_NAMES, true));
//#endif 


//#if -213868544 
showVisibility.setSelected(getBoolean(
                                           Notation.KEY_SHOW_VISIBILITY));
//#endif 


//#if -509019162 
showMultiplicity.setSelected(getBoolean(
                                             Notation.KEY_SHOW_MULTIPLICITY));
//#endif 


//#if -2104396023 
showInitialValue.setSelected(getBoolean(
                                             Notation.KEY_SHOW_INITIAL_VALUE));
//#endif 


//#if 635522966 
showProperties.setSelected(Configuration.getBoolean(
                                           Notation.KEY_SHOW_PROPERTIES));
//#endif 


//#if -808886070 
showTypes.setSelected(Configuration.getBoolean(
                                      Notation.KEY_SHOW_TYPES, true));
//#endif 


//#if 119033298 
showStereotypes.setSelected(Configuration.getBoolean(
                                            Notation.KEY_SHOW_STEREOTYPES));
//#endif 


//#if 512517769 
showSingularMultiplicities.setSelected(Configuration.getBoolean(
                    Notation.KEY_SHOW_SINGULAR_MULTIPLICITIES));
//#endif 


//#if 1427135521 
hideBidirectionalArrows.setSelected(Configuration.getBoolean(
                                                    Notation.KEY_HIDE_BIDIRECTIONAL_ARROWS, true));
//#endif 


//#if -128001316 
defaultShadowWidth.setSelectedIndex(Configuration.getInteger(
                                                    Notation.KEY_DEFAULT_SHADOW_WIDTH, 1));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1920577809 
public SettingsTabNotation(int settingsScope)
    { 

//#if -1440809256 
super();
//#endif 


//#if 1023949420 
scope = settingsScope;
//#endif 


//#if 432850676 
setLayout(new BorderLayout());
//#endif 


//#if -1795669477 
JPanel top = new JPanel();
//#endif 


//#if 202924187 
top.setLayout(new BorderLayout());
//#endif 


//#if 1936108951 
if(settingsScope == Argo.SCOPE_APPLICATION)//1
{ 

//#if -1214121984 
JPanel warning = new JPanel();
//#endif 


//#if 838129779 
warning.setLayout(new BoxLayout(warning, BoxLayout.PAGE_AXIS));
//#endif 


//#if -94667656 
JLabel warningLabel = new JLabel(Translator
                                             .localize("label.warning"));
//#endif 


//#if -1842942849 
warningLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
//#endif 


//#if -1998154296 
warning.add(warningLabel);
//#endif 


//#if 1195527410 
JLinkButton projectSettings = new JLinkButton();
//#endif 


//#if 1252215200 
projectSettings.setAction(new ActionProjectSettings());
//#endif 


//#if 733056837 
projectSettings.setText(Translator
                                    .localize("button.project-settings"));
//#endif 


//#if 1244340477 
projectSettings.setIcon(null);
//#endif 


//#if -1493106631 
projectSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
//#endif 


//#if 1619676656 
warning.add(projectSettings);
//#endif 


//#if 997190356 
top.add(warning, BorderLayout.NORTH);
//#endif 

} 

//#endif 


//#if -246371321 
JPanel settings = new JPanel();
//#endif 


//#if 1450211213 
settings.setLayout(new GridBagLayout());
//#endif 


//#if 1522451482 
GridBagConstraints constraints = new GridBagConstraints();
//#endif 


//#if 1615457545 
constraints.anchor = GridBagConstraints.WEST;
//#endif 


//#if 504512166 
constraints.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if 2064586822 
constraints.gridy = 0;
//#endif 


//#if 2064557031 
constraints.gridx = 0;
//#endif 


//#if 1434241144 
constraints.gridwidth = 1;
//#endif 


//#if -50436439 
constraints.gridheight = 1;
//#endif 


//#if 1283123510 
constraints.weightx = 1.0;
//#endif 


//#if -372703905 
constraints.insets = new Insets(0, 30, 0, 4);
//#endif 


//#if 127403536 
constraints.gridy = GridBagConstraints.RELATIVE;
//#endif 


//#if 4731349 
JPanel notationLanguagePanel =
            new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
//#endif 


//#if -574069897 
JLabel notationLanguageLabel =
            createLabel("label.notation-language");
//#endif 


//#if 1799763845 
notationLanguage = new NotationComboBox();
//#endif 


//#if -1911637142 
notationLanguageLabel.setLabelFor(notationLanguage);
//#endif 


//#if -337703736 
notationLanguagePanel.add(notationLanguageLabel);
//#endif 


//#if 1397626416 
notationLanguagePanel.add(notationLanguage);
//#endif 


//#if 1242356845 
settings.add(notationLanguagePanel, constraints);
//#endif 


//#if -773177849 
showBoldNames = createCheckBox("label.show-bold-names");
//#endif 


//#if 879466249 
settings.add(showBoldNames, constraints);
//#endif 


//#if 1363894380 
useGuillemots = createCheckBox("label.use-guillemots");
//#endif 


//#if -1190561771 
settings.add(useGuillemots, constraints);
//#endif 


//#if -1823322288 
showAssociationNames = createCheckBox("label.show-associationnames");
//#endif 


//#if 2092191161 
settings.add(showAssociationNames, constraints);
//#endif 


//#if 1475684890 
showVisibility = createCheckBox("label.show-visibility");
//#endif 


//#if -103428412 
settings.add(showVisibility, constraints);
//#endif 


//#if 1811185536 
showMultiplicity = createCheckBox("label.show-multiplicity");
//#endif 


//#if 1100781809 
settings.add(showMultiplicity, constraints);
//#endif 


//#if -935051836 
showInitialValue = createCheckBox("label.show-initialvalue");
//#endif 


//#if -309573761 
settings.add(showInitialValue, constraints);
//#endif 


//#if 170962776 
showProperties = createCheckBox("label.show-properties");
//#endif 


//#if -1352389851 
settings.add(showProperties, constraints);
//#endif 


//#if 500155742 
showTypes = createCheckBox("label.show-types");
//#endif 


//#if -858114497 
settings.add(showTypes, constraints);
//#endif 


//#if 1050245278 
showStereotypes = createCheckBox("label.show-stereotypes");
//#endif 


//#if 1556876231 
settings.add(showStereotypes, constraints);
//#endif 


//#if 716177227 
showSingularMultiplicities =
            createCheckBox("label.show-singular-multiplicities");
//#endif 


//#if -156894842 
settings.add(showSingularMultiplicities, constraints);
//#endif 


//#if 1495258003 
hideBidirectionalArrows =
            createCheckBox("label.hide-bidirectional-arrows");
//#endif 


//#if 49446990 
settings.add(hideBidirectionalArrows, constraints);
//#endif 


//#if -1355271430 
constraints.insets = new Insets(5, 30, 0, 4);
//#endif 


//#if -828074080 
JPanel defaultShadowWidthPanel = new JPanel(new FlowLayout(
                    FlowLayout.LEFT, 5, 0));
//#endif 


//#if -1178173676 
JLabel defaultShadowWidthLabel = createLabel(
                                             "label.default-shadow-width");
//#endif 


//#if -938152132 
defaultShadowWidth = new ShadowComboBox();
//#endif 


//#if 774731456 
defaultShadowWidthLabel.setLabelFor(defaultShadowWidth);
//#endif 


//#if 1451017650 
defaultShadowWidthPanel.add(defaultShadowWidthLabel);
//#endif 


//#if -754519290 
defaultShadowWidthPanel.add(defaultShadowWidth);
//#endif 


//#if -540797246 
settings.add(defaultShadowWidthPanel, constraints);
//#endif 


//#if 1923724175 
top.add(settings, BorderLayout.CENTER);
//#endif 


//#if 1498737270 
add(top, BorderLayout.NORTH);
//#endif 

} 

//#endif 


//#if -1394054838 
public JPanel getTabPanel()
    { 

//#if -403025215 
return this;
//#endif 

} 

//#endif 


//#if -371113304 
public void handleSettingsTabRefresh()
    { 

//#if 1287945120 
if(scope == Argo.SCOPE_APPLICATION)//1
{ 

//#if 1163130105 
showBoldNames.setSelected(getBoolean(
                                          Notation.KEY_SHOW_BOLD_NAMES));
//#endif 


//#if 1328558070 
useGuillemots.setSelected(getBoolean(
                                          Notation.KEY_USE_GUILLEMOTS));
//#endif 


//#if -936465276 
notationLanguage.setSelectedItem(Notation.getConfiguredNotation());
//#endif 


//#if 363312839 
showAssociationNames.setSelected(Configuration.getBoolean(
                                                 Notation.KEY_SHOW_ASSOCIATION_NAMES, true));
//#endif 


//#if -1497161502 
showVisibility.setSelected(getBoolean(
                                           Notation.KEY_SHOW_VISIBILITY));
//#endif 


//#if -1639566489 
showInitialValue.setSelected(getBoolean(
                                             Notation.KEY_SHOW_INITIAL_VALUE));
//#endif 


//#if 1209334752 
showProperties.setSelected(getBoolean(
                                           Notation.KEY_SHOW_PROPERTIES));
//#endif 


//#if 1340915240 
showTypes.setSelected(Configuration.getBoolean(
                                      Notation.KEY_SHOW_TYPES, true));
//#endif 


//#if 475806664 
showMultiplicity.setSelected(getBoolean(
                                             Notation.KEY_SHOW_MULTIPLICITY));
//#endif 


//#if 1098883660 
showStereotypes.setSelected(getBoolean(
                                            Notation.KEY_SHOW_STEREOTYPES));
//#endif 


//#if 139079765 
showSingularMultiplicities.setSelected(Configuration.getBoolean(
                    Notation.KEY_SHOW_SINGULAR_MULTIPLICITIES, true));
//#endif 


//#if 1166877571 
hideBidirectionalArrows.setSelected(Configuration.getBoolean(
                                                    Notation.KEY_HIDE_BIDIRECTIONAL_ARROWS, true));
//#endif 


//#if -167631810 
defaultShadowWidth.setSelectedIndex(Configuration.getInteger(
                                                    Notation.KEY_DEFAULT_SHADOW_WIDTH, 1));
//#endif 

} 

//#endif 


//#if 660037865 
if(scope == Argo.SCOPE_PROJECT)//1
{ 

//#if 549920999 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -211717511 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if 635350599 
notationLanguage.setSelectedItem(Notation.findNotation(
                                                 ps.getNotationLanguage()));
//#endif 


//#if -1020642341 
showBoldNames.setSelected(ps.getShowBoldNamesValue());
//#endif 


//#if -1764181309 
useGuillemots.setSelected(ps.getUseGuillemotsValue());
//#endif 


//#if -1541813153 
showAssociationNames.setSelected(ps.getShowAssociationNamesValue());
//#endif 


//#if -1953615489 
showVisibility.setSelected(ps.getShowVisibilityValue());
//#endif 


//#if -1929939361 
showMultiplicity.setSelected(ps.getShowMultiplicityValue());
//#endif 


//#if -1958303457 
showInitialValue.setSelected(ps.getShowInitialValueValue());
//#endif 


//#if -598749857 
showProperties.setSelected(ps.getShowPropertiesValue());
//#endif 


//#if 13294575 
showTypes.setSelected(ps.getShowTypesValue());
//#endif 


//#if -1354964513 
showStereotypes.setSelected(ps.getShowStereotypesValue());
//#endif 


//#if -262594369 
showSingularMultiplicities.setSelected(
                ps.getShowSingularMultiplicitiesValue());
//#endif 


//#if -1220186927 
hideBidirectionalArrows.setSelected(
                ps.getHideBidirectionalArrowsValue());
//#endif 


//#if 1754605675 
defaultShadowWidth.setSelectedIndex(
                ps.getDefaultShadowWidthValue());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1409782333 
public void setVisible(boolean visible)
    { 

//#if -438482026 
super.setVisible(visible);
//#endif 


//#if -1663036602 
if(visible)//1
{ 

//#if 1350569037 
handleSettingsTabRefresh();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

