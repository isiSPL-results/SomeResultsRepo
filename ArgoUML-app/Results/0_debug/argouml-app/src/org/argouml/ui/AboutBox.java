
//#if 1402898650 
// Compilation Unit of /AboutBox.java 
 

//#if 560075523 
package org.argouml.ui;
//#endif 


//#if 107193933 
import java.awt.BorderLayout;
//#endif 


//#if 1851995670 
import java.awt.Component;
//#endif 


//#if -1581190451 
import java.awt.Dimension;
//#endif 


//#if -1684302938 
import java.awt.Frame;
//#endif 


//#if 1890612173 
import java.awt.Insets;
//#endif 


//#if 1249655541 
import java.awt.Toolkit;
//#endif 


//#if -1512732175 
import java.util.HashMap;
//#endif 


//#if -1938674519 
import java.util.Iterator;
//#endif 


//#if 1819860419 
import java.util.Map;
//#endif 


//#if -597621707 
import javax.swing.JPanel;
//#endif 


//#if 1164139592 
import javax.swing.JScrollPane;
//#endif 


//#if -418606679 
import javax.swing.JTabbedPane;
//#endif 


//#if -690841117 
import javax.swing.JTextArea;
//#endif 


//#if -1746028360 
import javax.swing.border.EmptyBorder;
//#endif 


//#if 21553170 
import org.argouml.i18n.Translator;
//#endif 


//#if -771562666 
import org.argouml.moduleloader.ModuleLoader2;
//#endif 


//#if -664690210 
import org.argouml.profile.ProfileFacade;
//#endif 


//#if -1877666961 
import org.argouml.util.ArgoDialog;
//#endif 


//#if 259674635 
import org.argouml.util.Tools;
//#endif 


//#if 1280089646 
public class AboutBox extends 
//#if 1765830177 
ArgoDialog
//#endif 

  { 

//#if 1905088369 
private static final int INSET_PX = 3;
//#endif 


//#if 2140787634 
private static Map<String, Component> extraTabs =
        new HashMap<String, Component>();
//#endif 


//#if -1238761352 
private JTabbedPane tabs = new JTabbedPane();
//#endif 


//#if 594585048 
private SplashPanel splashPanel;
//#endif 


//#if -1152924222 
private static final long serialVersionUID = -3647983226617303893L;
//#endif 


//#if -1979533668 
public static void removeAboutTab(String name)
    { 

//#if 1240778170 
extraTabs.remove(name);
//#endif 

} 

//#endif 


//#if 1958049352 
public AboutBox()
    { 

//#if -1165485397 
this((Frame) null, false);
//#endif 

} 

//#endif 


//#if -745092414 
public AboutBox(Frame owner)
    { 

//#if -1489368489 
this(owner, false);
//#endif 

} 

//#endif 


//#if -671710618 
private static String localize(String str)
    { 

//#if 1976463587 
return Translator.localize(str);
//#endif 

} 

//#endif 


//#if -407211175 
private String getCredits()
    { 

//#if -2114054811 
StringBuffer buf = new StringBuffer();
//#endif 


//#if -1105175204 
buf.append(localize("aboutbox.developed-by"));
//#endif 


//#if 2026911200 
buf.append("\n\n");
//#endif 


//#if -1751006639 
buf.append(localize("aboutbox.project-leader"));
//#endif 


//#if 2101926584 
buf.append("Linus Tolke (linus@tigris.org)");
//#endif 


//#if 766391410 
buf.append("\n\n");
//#endif 


//#if -1232290913 
buf.append(localize("aboutbox.module-owners"));
//#endif 


//#if -1361075662 
buf.append("\n");
//#endif 


//#if -807658912 
buf.append("+ UML Model, Diagrams, GUI, Persistence: Bob Tarling\n");
//#endif 


//#if -1708759508 
buf.append("+ MDR Implementation: Tom Morris\n");
//#endif 


//#if 855678206 
buf.append("+ Sequence Diagrams: Christian Lopez Espinola\n");
//#endif 


//#if -442535245 
buf.append("+ C++: Luis Sergio Oliveira\n");
//#endif 


//#if -764620737 
buf.append("+ Csharp: Jan Magne Andersen\n");
//#endif 


//#if 1120988791 
buf.append("+ PHP 4/5: Kai Schroeder\n");
//#endif 


//#if -94819123 
buf.append("+ SQL: Kai Drahmann\n");
//#endif 


//#if -2110945093 
buf.append("+ Code Generation/Reverse Engineering: Thomas Neustupny\n");
//#endif 


//#if 2033109362 
buf.append("+ Cognitive support: Markus Klink\n");
//#endif 


//#if -1078428259 
buf.append("+ Notation, User Manual: Michiel van der Wulp\n");
//#endif 


//#if -887551595 
buf.append("+ Localization French: Jean-Hugues de Raigniac\n");
//#endif 


//#if 892373859 
buf.append("+ Localization Russian: Alexey Aphanasyev\n");
//#endif 


//#if -1700732232 
buf.append("+ Localization German: Harald Braun\n");
//#endif 


//#if 1771617767 
buf.append("+ Localization Spanish: Stewart Munoz\n");
//#endif 


//#if 1177148009 
buf.append("+ Localization British English: Alex Bagehot\n");
//#endif 


//#if 332781051 
buf.append("+ Localization Norwegian (bokm\u00E5l): "
                   + "Hans Fredrik Nordhaug\n");
//#endif 


//#if -571535098 
buf.append("+ Localization Chinese: Jeff Liu\n");
//#endif 


//#if -2091279734 
buf.append("+ Localization Portuguese: Sergio Agostinho\n");
//#endif 


//#if 981241568 
buf.append("\n");
//#endif 


//#if 2029045981 
buf.append(Translator.messageFormat(
                       "aboutbox.contrib-developers-for-release",
                       new Object[] {
                           "0.28",
                       }));
//#endif 


//#if 981241569 
buf.append("\n");
//#endif 


//#if -2093163967 
buf.append("+ Bob Tarling\n");
//#endif 


//#if 1621281249 
buf.append("+ Bogdan Szanto\n");
//#endif 


//#if 932009913 
buf.append("+ Bogdan Pistol\n");
//#endif 


//#if -1344592836 
buf.append("+ Brian Hudson\n");
//#endif 


//#if -2126394655 
buf.append("+ Christian Lopez Espinola\n");
//#endif 


//#if 358703463 
buf.append("+ Dave Thompson\n");
//#endif 


//#if -1932695853 
buf.append("+ Harald Braun\n");
//#endif 


//#if 1084903068 
buf.append("+ Jan Magne Andersen\n");
//#endif 


//#if -635504950 
buf.append("+ Luis Sergio Oliveira\n");
//#endif 


//#if 276080363 
buf.append("+ Linus Tolke\n");
//#endif 


//#if -1622883952 
buf.append("+ Lukasz Gromanowski\n");
//#endif 


//#if 1232067291 
buf.append("+ Marcos Aurelio\n");
//#endif 


//#if 2070887966 
buf.append("+ Michiel van der Wulp\n");
//#endif 


//#if 1241830930 
buf.append("+ Thilina Hasantha\n");
//#endif 


//#if -1136770148 
buf.append("+ Thomas Neustupny\n");
//#endif 


//#if 2140518911 
buf.append("+ Tom Morris\n");
//#endif 


//#if 981241570 
buf.append("\n");
//#endif 


//#if 254038619 
buf.append(Translator.messageFormat(
                       "aboutbox.contrib-developers-for-release",
                       new Object[] {
                           "0.26",
                       }));
//#endif 


//#if 981241571 
buf.append("\n");
//#endif 


//#if -1011721503 
buf.append("+ Aleksandar\n");
//#endif 


//#if 1587465295 
buf.append("+ Alexandre da Silva\n");
//#endif 


//#if 1268922069 
buf.append("+ Scott Roberts\n");
//#endif 


//#if -443938711 
buf.append("+ S�rgio Adriano Fernandes Lopes\n");
//#endif 


//#if 981241572 
buf.append("\n");
//#endif 


//#if -1520968743 
buf.append(Translator.messageFormat(
                       "aboutbox.contrib-developers-for-release",
                       new Object[] {
                           "0.24",
                       }));
//#endif 


//#if 981241573 
buf.append("\n");
//#endif 


//#if -1469145603 
buf.append("+ Andrea Nironi\n");
//#endif 


//#if 1130290708 
buf.append("+ Hans Fredrik Nordhaug\n");
//#endif 


//#if 688121155 
buf.append("+ Markus Klink\n");
//#endif 


//#if -1616607116 
buf.append("+ Sergio Agostinho\n");
//#endif 


//#if 846893094 
buf.append("+ Stewart Munoz\n");
//#endif 


//#if 981241574 
buf.append("\n");
//#endif 


//#if 998991191 
buf.append(Translator.messageFormat(
                       "aboutbox.contrib-developers-for-release",
                       new Object[] {
                           "0.22",
                       }));
//#endif 


//#if 981241575 
buf.append("\n");
//#endif 


//#if 1383516864 
buf.append("+ Jeff Liu\n");
//#endif 


//#if 1921168239 
buf.append("+ Ludovic Maitre\n");
//#endif 


//#if 353717553 
buf.append("\n");
//#endif 


//#if -776016171 
buf.append(Translator.messageFormat(
                       "aboutbox.contrib-developers-for-release",
                       new Object[] {
                           "0.20",
                       }));
//#endif 


//#if 353717554 
buf.append("\n");
//#endif 


//#if -2054754018 
final String cpbi =
            ", Polytechnic of Bandung Indonesia"
            + ", Computer Engineering Departement";
//#endif 


//#if 639232521 
buf.append("+ Decki" + cpbi + "\n");
//#endif 


//#if -833382427 
buf.append("+ Endi" + cpbi + "\n");
//#endif 


//#if -102045479 
buf.append("+ Kai Schroeder\n");
//#endif 


//#if -852875210 
buf.append("+ Michael A. MacDonald\n");
//#endif 


//#if 1286986059 
buf.append("+ Yayan" + cpbi + "\n");
//#endif 


//#if 353717555 
buf.append("\n");
//#endif 


//#if 1838782658 
buf.append(localize("aboutbox.past-developers"));
//#endif 


//#if 353717556 
buf.append("\n");
//#endif 


//#if -1781973487 
buf.append("+ Adam Gauthier\n");
//#endif 


//#if -927079138 
buf.append("+ Adam Bonner\n");
//#endif 


//#if -1659853333 
buf.append("+ Alex Bagehot\n");
//#endif 


//#if 1104020056 
buf.append("+ Alexander Lepekhine\n");
//#endif 


//#if -1752396605 
buf.append("+ Alexey Aphanasyev\n");
//#endif 


//#if -1998693421 
buf.append("+ Andreas Rueckert (a_rueckert@gmx.net) (Java RE)\n");
//#endif 


//#if 323071312 
buf.append("+ Clemens Eichler\n");
//#endif 


//#if -1828805399 
buf.append("+ Curt Arnold\n");
//#endif 


//#if 677766437 
buf.append("+ David Glaser\n");
//#endif 


//#if -66068053 
buf.append("+ David Hilbert\n");
//#endif 


//#if 2130164412 
buf.append("+ David Redmiles\n");
//#endif 


//#if -1907538605 
buf.append("+ Dennis Daniels (denny_d@hotmail.com)\n");
//#endif 


//#if 772569542 
buf.append("+ Donat Wullschleger\n");
//#endif 


//#if -586757322 
buf.append("+ Edwin Park\n");
//#endif 


//#if 349732115 
buf.append("+ Eric Lefevre\n");
//#endif 


//#if 1648071772 
buf.append("+ Eugenio Alvarez\n");
//#endif 


//#if 1904168386 
buf.append("+ Frank Finger\n");
//#endif 


//#if -679931400 
buf.append("+ Frank Wienberg\n");
//#endif 


//#if -1810340431 
buf.append("+ Grzegorz Prokopski\n");
//#endif 


//#if 511614569 
buf.append("+ Jaap Branderhorst\n");
//#endif 


//#if -959863232 
buf.append("+ Jason Robbins (Project founder, researcher)\n");
//#endif 


//#if -1956657020 
buf.append("+ Jean-Hugues de Raigniac\n");
//#endif 


//#if -1779351776 
buf.append("+ Jeremy Jones\n");
//#endif 


//#if -993155296 
buf.append("+ Jim Holt\n");
//#endif 


//#if 996561644 
buf.append("+ Luc Maisonobe\n");
//#endif 


//#if 424933597 
buf.append("+ Marcus Andersson\n");
//#endif 


//#if 341106508 
buf.append("+ Marko Boger (GentleWare) (UML Diagrams)\n");
//#endif 


//#if -634383342 
buf.append("+ Michael Stockman\n");
//#endif 


//#if -1054079172 
buf.append("+ Nick Santucci\n");
//#endif 


//#if 2129003570 
buf.append("+ Phil Sager\n");
//#endif 


//#if -307761853 
buf.append("+ Philippe Vanpeperstraete (User Manual)\n");
//#endif 


//#if -167059884 
buf.append("+ Piotr Kaminski\n");
//#endif 


//#if -418338770 
buf.append("+ Scott Guyer\n");
//#endif 


//#if 1241583386 
buf.append("+ Sean Chen\n");
//#endif 


//#if 573269946 
buf.append("+ Steffen Zschaler\n");
//#endif 


//#if 1442110001 
buf.append("+ Steve Poole\n");
//#endif 


//#if -349776791 
buf.append("+ Stuart Zakon\n");
//#endif 


//#if 1740698746 
buf.append("+ Thierry Lach\n");
//#endif 


//#if 1872004474 
buf.append("+ Thomas Schaumburg\n");
//#endif 


//#if -1364988650 
buf.append("+ Thorsten Sturm (thorsten.sturm@gentleware.de) (GEF)\n");
//#endif 


//#if -2115625723 
buf.append("+ Toby Baier (UML Metamodel, XMI, Project leader)\n");
//#endif 


//#if -346420391 
buf.append("+ Will Howery\n");
//#endif 


//#if 2130216285 
buf.append("+ ICS 125 team Spring 1996\n");
//#endif 


//#if 887394638 
buf.append("+ ICS 125 teams Spring 1998\n");
//#endif 


//#if -1079380158 
return buf.toString();
//#endif 

} 

//#endif 


//#if -1714641249 
public AboutBox(Frame owner, boolean modal)
    { 

//#if 1351417198 
super(localize("aboutbox.aboutbox-title"), modal);
//#endif 


//#if -1921520959 
splashPanel = new SplashPanel("Splash");
//#endif 


//#if -992594004 
int imgWidth = splashPanel.getImage().getIconWidth();
//#endif 


//#if -1379230130 
int imgHeight = splashPanel.getImage().getIconHeight();
//#endif 


//#if -1308741652 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
//#endif 


//#if 2041251064 
setLocation(scrSize.width / 2 - imgWidth / 2,
                    scrSize.height / 2 - imgHeight / 2);
//#endif 


//#if 21393666 
getContentPane().setLayout(new BorderLayout(0, 0));
//#endif 


//#if -1402744069 
JPanel myInsetPanel = new JPanel();
//#endif 


//#if -1954829729 
myInsetPanel.setBorder(new EmptyBorder(30, 40, 40, 40));
//#endif 


//#if 310455738 
imgWidth  += 40 + 40;
//#endif 


//#if -1152308809 
imgHeight += 40 + 40;
//#endif 


//#if -1370406750 
myInsetPanel.add(splashPanel);
//#endif 


//#if 161180374 
tabs.addTab(localize("aboutbox.tab.splash"), myInsetPanel);
//#endif 


//#if -1978325554 
tabs.addTab(localize("aboutbox.tab.version"), createPane(getVersion()));
//#endif 


//#if 180874954 
tabs.addTab(localize("aboutbox.tab.credits"), createPane(getCredits()));
//#endif 


//#if 327700339 
tabs.addTab(localize("aboutbox.tab.contacts"),
                    createPane(localize("aboutbox.contacts")));
//#endif 


//#if 984554143 
tabs.addTab(localize("aboutbox.tab.bugreport"),
                    createPane(localize("aboutbox.bugreport")));
//#endif 


//#if 389075069 
tabs.addTab(localize("aboutbox.tab.legal"),
                    createPane(localize("aboutbox.legal")));
//#endif 


//#if -2069862580 
for (String key : extraTabs.keySet()) //1
{ 

//#if 1270813878 
tabs.addTab(key, extraTabs.get(key));
//#endif 

} 

//#endif 


//#if 1683590672 
getContentPane().setLayout(new BorderLayout(0, 0));
//#endif 


//#if -371565179 
getContentPane().add(tabs, BorderLayout.CENTER);
//#endif 


//#if -1131764415 
setSize(imgWidth + 10, imgHeight + 120);
//#endif 

} 

//#endif 


//#if 1395202627 
private JScrollPane createPane(String text)
    { 

//#if -2004986026 
JTextArea a = new JTextArea();
//#endif 


//#if 729481958 
a.setEditable(false);
//#endif 


//#if 1858815637 
a.setLineWrap(true);
//#endif 


//#if -44896596 
a.setWrapStyleWord(true);
//#endif 


//#if -838809178 
a.setMargin(new Insets(INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 377398853 
a.setText(text);
//#endif 


//#if 773915281 
a.setCaretPosition(0);
//#endif 


//#if 573662042 
return new JScrollPane(a);
//#endif 

} 

//#endif 


//#if -1022276853 
public static void addAboutTab(String name, Component tab)
    { 

//#if 197901360 
extraTabs.put(name, tab);
//#endif 

} 

//#endif 


//#if 1806091287 
private String getVersion()
    { 

//#if -796477578 
StringBuffer buf = new StringBuffer();
//#endif 


//#if -2086744827 
buf.append(localize("aboutbox.generated-version-header"));
//#endif 


//#if 356579863 
buf.append(Tools.getVersionInfo());
//#endif 


//#if -92827556 
buf.append(localize("aboutbox.used-tools-header"));
//#endif 


//#if 1944551496 
buf.append("* GEF (gef.tigris.org)\n");
//#endif 


//#if -590743530 
buf.append("* Xerces-J 2.6.2\n");
//#endif 


//#if -1649050844 
buf.append("* NetBeans MDR (mdr.netbeans.org    )\n");
//#endif 


//#if -1151194671 
buf.append("* TU-Dresden OCL-Compiler "
                   + "(dresden-ocl.sourceforge.net)\n");
//#endif 


//#if -1486163056 
buf.append("* ANTLR 2.7.7 (www.antlr.org) *DEPRECATED*\n");
//#endif 


//#if -1953400831 
buf.append("\n");
//#endif 


//#if 1750607848 
buf.append(localize("aboutbox.loaded-modules-header"));
//#endif 


//#if 182715380 
Iterator<String> iter = ModuleLoader2.allModules().iterator();
//#endif 


//#if 1729374953 
while (iter.hasNext()) //1
{ 

//#if 1837865494 
String moduleName = iter.next();
//#endif 


//#if 1540039287 
buf.append("\nModule: ");
//#endif 


//#if 2036351372 
buf.append(moduleName);
//#endif 


//#if 37715781 
buf.append("\nDescription: ");
//#endif 


//#if -640441595 
String desc = ModuleLoader2.getDescription(moduleName);
//#endif 


//#if -1477637698 
buf.append(desc.replaceAll("\n\n", "\n"));
//#endif 

} 

//#endif 


//#if -261893137 
buf.append("\n\n");
//#endif 


//#if -2027697874 
buf.append(localize("aboutbox.thanks"));
//#endif 


//#if -1252216143 
buf.append("\n");
//#endif 


//#if -1597092463 
return buf.toString();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

