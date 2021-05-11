
//#if 389792167 
// Compilation Unit of /SettingsTabAppearance.java 
 

//#if -1806437862 
package org.argouml.ui;
//#endif 


//#if 249665572 
import java.awt.BorderLayout;
//#endif 


//#if -1192379060 
import java.awt.event.ActionEvent;
//#endif 


//#if 260643260 
import java.awt.event.ActionListener;
//#endif 


//#if -82786177 
import java.util.ArrayList;
//#endif 


//#if -1828220890 
import java.util.Arrays;
//#endif 


//#if -1226773310 
import java.util.Collection;
//#endif 


//#if -755368186 
import java.util.Locale;
//#endif 


//#if -1399125984 
import javax.swing.BorderFactory;
//#endif 


//#if 915020945 
import javax.swing.JCheckBox;
//#endif 


//#if -1285048809 
import javax.swing.JComboBox;
//#endif 


//#if 375415502 
import javax.swing.JLabel;
//#endif 


//#if 490289598 
import javax.swing.JPanel;
//#endif 


//#if 2062208871 
import javax.swing.SwingConstants;
//#endif 


//#if 757255736 
import org.argouml.application.api.Argo;
//#endif 


//#if -1777562045 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 1490118997 
import org.argouml.configuration.Configuration;
//#endif 


//#if 589943977 
import org.argouml.i18n.Translator;
//#endif 


//#if -1078565881 
import org.tigris.swidgets.LabelledLayout;
//#endif 


//#if 386307828 
class SettingsTabAppearance extends 
//#if 1544954511 
JPanel
//#endif 

 implements 
//#if -939467635 
GUISettingsTabInterface
//#endif 

  { 

//#if -983984106 
private JComboBox	lookAndFeel;
//#endif 


//#if 10205632 
private JComboBox	metalTheme;
//#endif 


//#if -2031239702 
private JComboBox   language;
//#endif 


//#if -872849674 
private JLabel      metalLabel;
//#endif 


//#if 1776294354 
private JCheckBox   smoothEdges;
//#endif 


//#if 2062489273 
private Locale locale;
//#endif 


//#if -417125753 
private static final long serialVersionUID = -6779214318672690570L;
//#endif 


//#if -2051778349 
public void handleSettingsTabCancel() { 
} 

//#endif 


//#if 1935167090 
public void handleResetToDefault()
    { 
} 

//#endif 


//#if -1211239486 
SettingsTabAppearance()
    { 

//#if -60053619 
setLayout(new BorderLayout());
//#endif 


//#if 929277360 
int labelGap = 10;
//#endif 


//#if 2132335623 
int componentGap = 10;
//#endif 


//#if -1561425713 
JPanel top = new JPanel(new LabelledLayout(labelGap, componentGap));
//#endif 


//#if -557901789 
JLabel label = new JLabel(Translator.localize("label.look-and-feel"));
//#endif 


//#if -1811811292 
lookAndFeel =
            new JComboBox(LookAndFeelMgr.getInstance()
                          .getAvailableLookAndFeelNames());
//#endif 


//#if 1043383988 
lookAndFeel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setMetalThemeState();
            }
        });
//#endif 


//#if 1646348645 
label.setLabelFor(lookAndFeel);
//#endif 


//#if -1079004186 
top.add(label);
//#endif 


//#if 1174891248 
top.add(lookAndFeel);
//#endif 


//#if -840323399 
metalLabel = new JLabel(Translator.localize("label.metal-theme"));
//#endif 


//#if 575735605 
metalTheme =
            new JComboBox(LookAndFeelMgr.getInstance()
                          .getAvailableThemeNames());
//#endif 


//#if 730865030 
metalLabel.setLabelFor(metalTheme);
//#endif 


//#if 1793472863 
top.add(metalLabel);
//#endif 


//#if 506973940 
top.add(metalTheme);
//#endif 


//#if 1068815398 
JCheckBox j = new JCheckBox(Translator.localize("label.smooth-edges"));
//#endif 


//#if -1536201114 
smoothEdges = j;
//#endif 


//#if 1704339580 
JLabel emptyLabel = new JLabel();
//#endif 


//#if -224689694 
emptyLabel.setLabelFor(smoothEdges);
//#endif 


//#if 1255957593 
top.add(emptyLabel);
//#endif 


//#if 1931911482 
top.add(smoothEdges);
//#endif 


//#if 92157049 
JLabel languageLabel =
            new JLabel(Translator.localize("label.language"));
//#endif 


//#if -640870845 
Collection<MyLocale> c = MyLocale.getLocales();
//#endif 


//#if -1861566902 
language = new JComboBox(c.toArray());
//#endif 


//#if 308751699 
Object o = MyLocale.getDefault(c);
//#endif 


//#if 1036013711 
if(o != null)//1
{ 

//#if -138536227 
language.setSelectedItem(o);
//#endif 

} 
else
{ 

//#if 20465976 
language.setSelectedIndex(-1);
//#endif 

} 

//#endif 


//#if 639934191 
language.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox combo = (JComboBox) e.getSource();
                locale = ((MyLocale) combo.getSelectedItem()).getLocale();
            }
        });
//#endif 


//#if -219111699 
languageLabel.setLabelFor(language);
//#endif 


//#if 1886979438 
top.add(languageLabel);
//#endif 


//#if 446221770 
top.add(language);
//#endif 


//#if 1447702045 
top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//#endif 


//#if 627564321 
add(top, BorderLayout.CENTER);
//#endif 


//#if -1272263760 
JLabel restart =
            new JLabel(Translator.localize("label.restart-application"));
//#endif 


//#if -1644641256 
restart.setHorizontalAlignment(SwingConstants.CENTER);
//#endif 


//#if -1560273338 
restart.setVerticalAlignment(SwingConstants.CENTER);
//#endif 


//#if 503790147 
restart.setBorder(BorderFactory.createEmptyBorder(10, 2, 10, 2));
//#endif 


//#if 1838596491 
add(restart, BorderLayout.SOUTH);
//#endif 


//#if 1714763693 
setMetalThemeState();
//#endif 

} 

//#endif 


//#if -1465210578 
public JPanel getTabPanel()
    { 

//#if -169925016 
return this;
//#endif 

} 

//#endif 


//#if -221713340 
public void handleSettingsTabRefresh()
    { 

//#if -741429227 
String laf = LookAndFeelMgr.getInstance().getCurrentLookAndFeelName();
//#endif 


//#if 1782700514 
String theme = LookAndFeelMgr.getInstance().getCurrentThemeName();
//#endif 


//#if 829598339 
lookAndFeel.setSelectedItem(laf);
//#endif 


//#if 801999023 
metalTheme.setSelectedItem(theme);
//#endif 


//#if -1423570241 
smoothEdges.setSelected(Configuration.getBoolean(
                                    Argo.KEY_SMOOTH_EDGES, false));
//#endif 

} 

//#endif 


//#if -1643681710 
public String getTabKey()
    { 

//#if -1770429291 
return "tab.appearance";
//#endif 

} 

//#endif 


//#if -1286845162 
public void handleSettingsTabSave()
    { 

//#if -326596532 
LookAndFeelMgr.getInstance().setCurrentLAFAndThemeByName(
            (String) lookAndFeel.getSelectedItem(),
            (String) metalTheme.getSelectedItem());
//#endif 


//#if 140961588 
Configuration.setBoolean(Argo.KEY_SMOOTH_EDGES,
                                 smoothEdges.isSelected());
//#endif 


//#if -679014998 
if(locale != null)//1
{ 

//#if 46456192 
Configuration.setString(Argo.KEY_LOCALE, locale.toString());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -759771472 
private void setMetalThemeState()
    { 

//#if -2019327674 
String lafName = (String) lookAndFeel.getSelectedItem();
//#endif 


//#if -1967325471 
boolean enabled =
            LookAndFeelMgr.getInstance().isThemeCompatibleLookAndFeel(
                LookAndFeelMgr.getInstance().getLookAndFeelFromName(lafName));
//#endif 


//#if -887605747 
metalLabel.setEnabled(enabled);
//#endif 


//#if 253642328 
metalTheme.setEnabled(enabled);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -2083999256 
class MyLocale  { 

//#if 1709815352 
private Locale myLocale;
//#endif 


//#if 953111063 
Locale getLocale()
    { 

//#if 1151835070 
return myLocale;
//#endif 

} 

//#endif 


//#if 872654151 
public String toString()
    { 

//#if -1885917490 
StringBuffer displayString = new StringBuffer(myLocale.toString());
//#endif 


//#if 48956098 
displayString.append(" (");
//#endif 


//#if 745607629 
displayString.append(myLocale.getDisplayLanguage(myLocale));
//#endif 


//#if 2071961870 
if(myLocale.getDisplayCountry(myLocale) != null
                && myLocale.getDisplayCountry(myLocale).length() > 0)//1
{ 

//#if 1763315450 
displayString.append(" ");
//#endif 


//#if 684865079 
displayString.append(myLocale.getDisplayCountry(myLocale));
//#endif 

} 

//#endif 


//#if 48985889 
displayString.append(")");
//#endif 


//#if -830747989 
if(myLocale.equals(Translator.getSystemDefaultLocale()))//1
{ 

//#if -1549734644 
displayString.append(" - Default");
//#endif 

} 

//#endif 


//#if 1394446268 
return displayString.toString();
//#endif 

} 

//#endif 


//#if -1349397271 
static MyLocale getDefault(Collection<MyLocale> c)
    { 

//#if 1101703500 
Locale locale = Locale.getDefault();
//#endif 


//#if 1970833453 
for (MyLocale ml : c) //1
{ 

//#if -361934728 
if(locale.equals(ml.getLocale()))//1
{ 

//#if 1673357262 
return ml;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1550343116 
return null;
//#endif 

} 

//#endif 


//#if 837723251 
MyLocale(Locale locale)
    { 

//#if 1132151386 
myLocale = locale;
//#endif 

} 

//#endif 


//#if -1420661620 
static Collection<MyLocale> getLocales()
    { 

//#if -1213483561 
Collection<MyLocale> c = new ArrayList<MyLocale>();
//#endif 


//#if 635187624 
for (Locale locale : Arrays.asList(Translator.getLocales())) //1
{ 

//#if 1531717765 
c.add(new MyLocale(locale));
//#endif 

} 

//#endif 


//#if -768073724 
return c;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

