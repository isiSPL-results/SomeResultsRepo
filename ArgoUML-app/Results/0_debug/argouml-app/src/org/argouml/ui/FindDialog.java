
//#if -1307632514 
// Compilation Unit of /FindDialog.java 
 

//#if 1776567293 
package org.argouml.ui;
//#endif 


//#if 962048967 
import java.awt.BorderLayout;
//#endif 


//#if -1733389258 
import java.awt.Color;
//#endif 


//#if -2008914029 
import java.awt.Dimension;
//#endif 


//#if 1175163529 
import java.awt.GridBagConstraints;
//#endif 


//#if 404418061 
import java.awt.GridBagLayout;
//#endif 


//#if -135187475 
import java.awt.GridLayout;
//#endif 


//#if -1187863353 
import java.awt.Insets;
//#endif 


//#if -2022692694 
import java.awt.Rectangle;
//#endif 


//#if -784961655 
import java.awt.event.ActionEvent;
//#endif 


//#if 54977119 
import java.awt.event.ActionListener;
//#endif 


//#if -1566100780 
import java.awt.event.MouseEvent;
//#endif 


//#if -727886028 
import java.awt.event.MouseListener;
//#endif 


//#if 177172706 
import java.util.ArrayList;
//#endif 


//#if 619659327 
import java.util.List;
//#endif 


//#if -682506875 
import javax.swing.JButton;
//#endif 


//#if -572665414 
import javax.swing.JComboBox;
//#endif 


//#if -1140219381 
import javax.swing.JLabel;
//#endif 


//#if -1025345285 
import javax.swing.JPanel;
//#endif 


//#if -1953893566 
import javax.swing.JScrollPane;
//#endif 


//#if 758327459 
import javax.swing.JTabbedPane;
//#endif 


//#if 164013917 
import javax.swing.JTextArea;
//#endif 


//#if -1657260930 
import javax.swing.border.EmptyBorder;
//#endif 


//#if -450549223 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if 334981644 
import org.argouml.i18n.Translator;
//#endif 


//#if 598989041 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1089936082 
import org.argouml.model.Model;
//#endif 


//#if -1003611117 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if -741517583 
import org.argouml.uml.PredicateSearch;
//#endif 


//#if -1564238487 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -229466379 
import org.argouml.util.Predicate;
//#endif 


//#if 82163629 
import org.argouml.util.PredicateStringMatch;
//#endif 


//#if 988355035 
import org.argouml.util.PredicateType;
//#endif 


//#if 105787223 
public class FindDialog extends 
//#if -1820177900 
ArgoDialog
//#endif 

 implements 
//#if -727849443 
ActionListener
//#endif 

, 
//#if -547574522 
MouseListener
//#endif 

  { 

//#if 1307252679 
private static FindDialog instance;
//#endif 


//#if 1859124674 
private static int nextResultNum = 1;
//#endif 


//#if -389861610 
private static int numFinds;
//#endif 


//#if -532845788 
private static final int INSET_PX = 3;
//#endif 


//#if -919653589 
private JButton     search     =
        new JButton(
        Translator.localize("dialog.find.button.find"));
//#endif 


//#if 1322374235 
private JButton     clearTabs  =
        new JButton(
        Translator.localize("dialog.find.button.clear-tabs"));
//#endif 


//#if 1200130739 
private JPanel nameLocTab = new JPanel();
//#endif 


//#if 559640422 
private JComboBox elementName = new JComboBox();
//#endif 


//#if -2126549059 
private JComboBox diagramName = new JComboBox();
//#endif 


//#if -1702461310 
private JComboBox location = new JComboBox();
//#endif 


//#if -2070558329 
private JComboBox type = new JComboBox();
//#endif 


//#if 1160002943 
private JPanel typeDetails = new JPanel();
//#endif 


//#if 341042503 
private JTabbedPane results = new JTabbedPane();
//#endif 


//#if -1936857038 
private JPanel help = new JPanel();
//#endif 


//#if 291094223 
private List<TabResults> resultTabs = new ArrayList<TabResults>();
//#endif 


//#if 45673658 
private static final long serialVersionUID = 9209251878896557216L;
//#endif 


//#if 1143214790 
public void mouseReleased(MouseEvent me)
    { 
} 

//#endif 


//#if -1483389196 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -13279226 
if(e.getSource() == search)//1
{ 

//#if 1229990626 
doSearch();
//#endif 

} 
else

//#if -915003324 
if(e.getSource() == clearTabs)//1
{ 

//#if -790037534 
doClearTabs();
//#endif 

} 
else

//#if 718336157 
if(e.getSource() == getOkButton())//1
{ 

//#if 286455090 
doGoToSelection();
//#endif 

} 
else
{ 

//#if -654349637 
super.actionPerformed(e);
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 305410310 
public void mouseExited(MouseEvent me)
    { 
} 

//#endif 


//#if 1262999394 
private void myDoubleClick(int tab)
    { 

//#if 1907866090 
JPanel t = resultTabs.get(tab);
//#endif 


//#if -347083593 
if(t instanceof AbstractArgoJPanel)//1
{ 

//#if -1604105233 
if(((AbstractArgoJPanel) t).spawn() != null)//1
{ 

//#if 1064203995 
resultTabs.remove(tab);
//#endif 


//#if -858730724 
location.removeItem("In Tab: "
                                    + ((AbstractArgoJPanel) t).getTitle());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 106683040 
public void reset()
    { 

//#if 553989463 
doClearTabs();
//#endif 


//#if -396698936 
doResetFields(true);
//#endif 

} 

//#endif 


//#if -815330271 
public void mousePressed(MouseEvent me)
    { 
} 

//#endif 


//#if 621539613 
private void doClearTabs()
    { 

//#if -708650106 
int numTabs = resultTabs.size();
//#endif 


//#if -1692968800 
for (int i = 0; i < numTabs; i++) //1
{ 

//#if 1860667349 
results.remove(resultTabs.get(i));
//#endif 

} 

//#endif 


//#if -1867847368 
resultTabs.clear();
//#endif 


//#if 315204695 
clearTabs.setEnabled(false);
//#endif 


//#if -295146531 
getOkButton().setEnabled(false);
//#endif 


//#if 1639401666 
doResetFields(false);
//#endif 

} 

//#endif 


//#if -1498388066 
public FindDialog()
    { 

//#if -958285294 
super(Translator.localize("dialog.find.title"),
              ArgoDialog.OK_CANCEL_OPTION, false);
//#endif 


//#if -766364284 
JPanel mainPanel = new JPanel(new BorderLayout());
//#endif 


//#if -1629103169 
initNameLocTab();
//#endif 


//#if 291837078 
mainPanel.add(nameLocTab, BorderLayout.NORTH);
//#endif 


//#if -1666387615 
initHelpTab();
//#endif 


//#if -1283596279 
results.addTab(Translator.localize("dialog.find.tab.help"), help);
//#endif 


//#if 776248756 
mainPanel.add(results, BorderLayout.CENTER);
//#endif 


//#if 1983772424 
search.addActionListener(this);
//#endif 


//#if 463131037 
results.addMouseListener(this);
//#endif 


//#if 2045580187 
clearTabs.addActionListener(this);
//#endif 


//#if 118010874 
clearTabs.setEnabled(false);
//#endif 


//#if 471245623 
setContent(mainPanel);
//#endif 


//#if -2021592576 
getOkButton().setEnabled(false);
//#endif 

} 

//#endif 


//#if -1022994426 
private void initTypes()
    { 

//#if 31018477 
type.addItem(PredicateMType.create());
//#endif 


//#if 710044028 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getUMLClass()));
//#endif 


//#if -1384499173 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getInterface()));
//#endif 


//#if 1451352330 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getAction()));
//#endif 


//#if -1257161249 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getActor()));
//#endif 


//#if 1084698451 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getAssociation()));
//#endif 


//#if -932336919 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getAssociationClass()));
//#endif 


//#if 819774032 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getAssociationEndRole()));
//#endif 


//#if 679580669 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getAssociationRole()));
//#endif 


//#if 1696338286 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getArtifact()));
//#endif 


//#if 2121654424 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getAttribute()));
//#endif 


//#if 528551167 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getClassifier()));
//#endif 


//#if 647805865 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getClassifierRole()));
//#endif 


//#if 391234959 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getCollaboration()));
//#endif 


//#if -1715731147 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getComment()));
//#endif 


//#if 1158398679 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getComponent()));
//#endif 


//#if 940443510 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getCompositeState()));
//#endif 


//#if 124192451 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getConstraint()));
//#endif 


//#if -235775876 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getDataType()));
//#endif 


//#if 1101168149 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getDependency()));
//#endif 


//#if 459258771 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getElementImport()));
//#endif 


//#if 935898445 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getEnumeration()));
//#endif 


//#if 405452056 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getEnumerationLiteral()));
//#endif 


//#if -256879931 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getException()));
//#endif 


//#if -828404058 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getExtend()));
//#endif 


//#if 1420108175 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getExtensionPoint()));
//#endif 


//#if -1397606609 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getGuard()));
//#endif 


//#if -604516732 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getGeneralization()));
//#endif 


//#if 1733960844 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getInclude()));
//#endif 


//#if -332315509 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getInstance()));
//#endif 


//#if -779972510 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getInteraction()));
//#endif 


//#if -1043872681 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getInterface()));
//#endif 


//#if 682308422 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getLink()));
//#endif 


//#if 497532045 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getMessage()));
//#endif 


//#if -2107011797 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getModel()));
//#endif 


//#if -1522550210 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getNode()));
//#endif 


//#if -93366354 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getPackage()));
//#endif 


//#if 921401259 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getParameter()));
//#endif 


//#if -1237354230 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getPartition()));
//#endif 


//#if 561397121 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getPseudostate()));
//#endif 


//#if -1644905299 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getOperation()));
//#endif 


//#if -1922504555 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getSimpleState()));
//#endif 


//#if 540698584 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getSignal()));
//#endif 


//#if -144677693 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getState()));
//#endif 


//#if -1428215734 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getStateMachine()));
//#endif 


//#if 1602299583 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getStateVertex()));
//#endif 


//#if -583156082 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getStereotype()));
//#endif 


//#if -1415064505 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getTagDefinition()));
//#endif 


//#if 1639357003 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getTransition()));
//#endif 


//#if -777489091 
type.addItem(PredicateMType.create(
                         Model.getMetaTypes().getUseCase()));
//#endif 

} 

//#endif 


//#if 1201014369 
private void initHelpTab()
    { 

//#if 886962178 
help.setLayout(new BorderLayout());
//#endif 


//#if -106534743 
JTextArea helpText = new JTextArea();
//#endif 


//#if 55196086 
helpText.setText(Translator.localize("dialog.find.helptext"));
//#endif 


//#if 541323957 
helpText.setEditable(false);
//#endif 


//#if -313606409 
helpText.setMargin(new Insets(INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if -1925081801 
help.add(new JScrollPane(helpText), BorderLayout.CENTER);
//#endif 

} 

//#endif 


//#if -251069170 
@Override
    protected void nameButtons()
    { 

//#if -2095664380 
super.nameButtons();
//#endif 


//#if -1021603788 
nameButton(getOkButton(), "button.go-to-selection");
//#endif 


//#if -1764424451 
nameButton(getCancelButton(), "button.close");
//#endif 

} 

//#endif 


//#if 117229527 
private void doResetFields(boolean complete)
    { 

//#if 1010079498 
if(complete)//1
{ 

//#if 937490314 
elementName.removeAllItems();
//#endif 


//#if 784743969 
diagramName.removeAllItems();
//#endif 


//#if 1078513803 
elementName.addItem("*");
//#endif 


//#if -1190200670 
diagramName.addItem("*");
//#endif 

} 

//#endif 


//#if 560548320 
location.removeAllItems();
//#endif 


//#if 1473273497 
location.addItem(
            Translator.localize("dialog.find.comboboxitem.entire-project"));
//#endif 

} 

//#endif 


//#if -53144872 
private void doSearch()
    { 

//#if 1897437335 
numFinds++;
//#endif 


//#if 1274936909 
String eName = "";
//#endif 


//#if -416630962 
if(elementName.getSelectedItem() != null)//1
{ 

//#if 615779353 
eName += elementName.getSelectedItem();
//#endif 


//#if 751340638 
elementName.removeItem(eName);
//#endif 


//#if -1664663126 
elementName.insertItemAt(eName, 0);
//#endif 


//#if -303727235 
elementName.setSelectedItem(eName);
//#endif 

} 

//#endif 


//#if -1212575924 
String dName = "";
//#endif 


//#if -1617564379 
if(diagramName.getSelectedItem() != null)//1
{ 

//#if 1827111163 
dName += diagramName.getSelectedItem();
//#endif 


//#if 653929100 
diagramName.removeItem(dName);
//#endif 


//#if -870163304 
diagramName.insertItemAt(dName, 0);
//#endif 


//#if 1766913581 
diagramName.setSelectedItem(dName);
//#endif 

} 

//#endif 


//#if 1492330140 
String name = eName;
//#endif 


//#if 321643387 
if(dName.length() > 0)//1
{ 

//#if 1694626588 
Object[] msgArgs = {name, dName };
//#endif 


//#if 856465190 
name =
                Translator.messageFormat(
                    "dialog.find.comboboxitem.element-in-diagram", msgArgs);
//#endif 

} 

//#endif 


//#if -369096344 
String typeName = type.getSelectedItem().toString();
//#endif 


//#if -92928391 
if(!typeName.equals("Any Type"))//1
{ 

//#if -176091847 
name += " " + typeName;
//#endif 

} 

//#endif 


//#if -195007543 
if(name.length() == 0)//1
{ 

//#if 1714808406 
name =
                Translator.localize("dialog.find.tabname") + (nextResultNum++);
//#endif 

} 

//#endif 


//#if 353563931 
if(name.length() > 15)//1
{ 

//#if -1059579373 
name = name.substring(0, 12) + "...";
//#endif 

} 

//#endif 


//#if -1427193000 
String pName = "";
//#endif 


//#if 819114004 
Predicate eNamePred = PredicateStringMatch.create(eName);
//#endif 


//#if 463443818 
Predicate pNamePred = PredicateStringMatch.create(pName);
//#endif 


//#if 1632350802 
Predicate dNamePred = PredicateStringMatch.create(dName);
//#endif 


//#if 1113401067 
Predicate typePred = (Predicate) type.getSelectedItem();
//#endif 


//#if 714432880 
PredicateSearch pred =
            new PredicateSearch(eNamePred, pNamePred, dNamePred, typePred);
//#endif 


//#if 402924663 
ChildGenSearch gen = new ChildGenSearch();
//#endif 


//#if 1531723660 
Object root = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1161200913 
TabResults newResults = new TabResults();
//#endif 


//#if -2000865945 
newResults.setTitle(name);
//#endif 


//#if 1886171710 
newResults.setPredicate(pred);
//#endif 


//#if -225248832 
newResults.setRoot(root);
//#endif 


//#if 1437109267 
newResults.setGenerator(gen);
//#endif 


//#if -540706926 
resultTabs.add(newResults);
//#endif 


//#if 877329213 
results.addTab(name, newResults);
//#endif 


//#if 21896310 
clearTabs.setEnabled(true);
//#endif 


//#if 1517449264 
getOkButton().setEnabled(true);
//#endif 


//#if -2026012184 
results.setSelectedComponent(newResults);
//#endif 


//#if 1245817236 
Object[] msgArgs = {name };
//#endif 


//#if -1584129982 
location.addItem(Translator.messageFormat(
                             "dialog.find.comboboxitem.in-tab", msgArgs));
//#endif 


//#if 1233281135 
invalidate();
//#endif 


//#if -173178761 
results.invalidate();
//#endif 


//#if -2077035852 
validate();
//#endif 


//#if 1608139735 
newResults.run();
//#endif 


//#if -1049452215 
newResults.requestFocus();
//#endif 


//#if 1298092251 
newResults.selectResult(0);
//#endif 

} 

//#endif 


//#if 638845798 
public void mouseClicked(MouseEvent me)
    { 

//#if 1490590142 
int tab = results.getSelectedIndex();
//#endif 


//#if 590260934 
if(tab != -1)//1
{ 

//#if 1090838300 
Rectangle tabBounds = results.getBoundsAt(tab);
//#endif 


//#if -508266144 
if(!tabBounds.contains(me.getX(), me.getY()))//1
{ 

//#if 1817996623 
return;
//#endif 

} 

//#endif 


//#if 772265700 
if(tab >= 1 && me.getClickCount() >= 2)//1
{ 

//#if -946875084 
myDoubleClick(tab - 1);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -408767903 
public static FindDialog getInstance()
    { 

//#if 1685690396 
if(instance == null)//1
{ 

//#if -425168216 
instance = new FindDialog();
//#endif 

} 

//#endif 


//#if -54720125 
return instance;
//#endif 

} 

//#endif 


//#if -1521895851 
private void initNameLocTab()
    { 

//#if 1736800950 
elementName.setEditable(true);
//#endif 


//#if 1372756579 
elementName.getEditor()
        .getEditorComponent().setBackground(Color.white);
//#endif 


//#if 1296631551 
diagramName.setEditable(true);
//#endif 


//#if 2081405804 
diagramName.getEditor()
        .getEditorComponent().setBackground(Color.white);
//#endif 


//#if -2087844028 
elementName.addItem("*");
//#endif 


//#if -61591205 
diagramName.addItem("*");
//#endif 


//#if -1023485109 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if 935840362 
nameLocTab.setLayout(gb);
//#endif 


//#if -1979548194 
JLabel elementNameLabel =
            new JLabel(
            Translator.localize("dialog.find.label.element-name"));
//#endif 


//#if 781020694 
JLabel diagramNameLabel =
            new JLabel(
            Translator.localize("dialog.find.label.in-diagram"));
//#endif 


//#if 204965196 
JLabel typeLabel =
            new JLabel(
            Translator.localize("dialog.find.label.element-type"));
//#endif 


//#if -1928585150 
JLabel locLabel =
            new JLabel(
            Translator.localize("dialog.find.label.find-in"));
//#endif 


//#if 1337843470 
location.addItem(
            Translator.localize("dialog.find.comboboxitem.entire-project"));
//#endif 


//#if -51514882 
initTypes();
//#endif 


//#if -1920686946 
typeDetails.setMinimumSize(new Dimension(200, 100));
//#endif 


//#if -2085452207 
typeDetails.setPreferredSize(new Dimension(200, 100));
//#endif 


//#if 127501934 
typeDetails.setSize(new Dimension(200, 100));
//#endif 


//#if 470440705 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if 708844450 
c.fill = GridBagConstraints.BOTH;
//#endif 


//#if 1064792943 
c.ipadx = 3;
//#endif 


//#if 1064822734 
c.ipady = 3;
//#endif 


//#if -906646049 
c.gridwidth = 1;
//#endif 


//#if -416787250 
c.gridx = 0;
//#endif 


//#if -416757459 
c.gridy = 0;
//#endif 


//#if -1057793474 
c.weightx = 0.0;
//#endif 


//#if 622317860 
gb.setConstraints(elementNameLabel, c);
//#endif 


//#if -697335289 
nameLocTab.add(elementNameLabel);
//#endif 


//#if -416787219 
c.gridx = 1;
//#endif 


//#if 1129038341 
c.gridy = 0;
//#endif 


//#if -1057763683 
c.weightx = 1.0;
//#endif 


//#if -1979151966 
gb.setConstraints(elementName, c);
//#endif 


//#if 2005603729 
nameLocTab.add(elementName);
//#endif 


//#if 241534660 
c.gridx = 0;
//#endif 


//#if -416757428 
c.gridy = 1;
//#endif 


//#if -550286508 
c.weightx = 0.0;
//#endif 


//#if -1788382035 
gb.setConstraints(diagramNameLabel, c);
//#endif 


//#if -1540066352 
nameLocTab.add(diagramNameLabel);
//#endif 


//#if 242458181 
c.gridx = 1;
//#endif 


//#if 1129961862 
c.gridy = 1;
//#endif 


//#if 337217173 
c.weightx = 1.0;
//#endif 


//#if -1134488455 
gb.setConstraints(diagramName, c);
//#endif 


//#if 862349864 
nameLocTab.add(diagramName);
//#endif 


//#if 241534661 
c.gridx = 0;
//#endif 


//#if -416757366 
c.gridy = 3;
//#endif 


//#if -550286507 
c.weightx = 0.0;
//#endif 


//#if 274278315 
gb.setConstraints(locLabel, c);
//#endif 


//#if 1010534478 
nameLocTab.add(locLabel);
//#endif 


//#if 242458182 
c.gridx = 1;
//#endif 


//#if 1131808904 
c.gridy = 3;
//#endif 


//#if 337217174 
c.weightx = 1.0;
//#endif 


//#if 1931795276 
gb.setConstraints(location, c);
//#endif 


//#if -1276006353 
nameLocTab.add(location);
//#endif 


//#if -1226831524 
SpacerPanel spacer = new SpacerPanel();
//#endif 


//#if -416787188 
c.gridx = 2;
//#endif 


//#if 1129038342 
c.gridy = 0;
//#endif 


//#if -550286506 
c.weightx = 0.0;
//#endif 


//#if 97500099 
gb.setConstraints(spacer, c);
//#endif 


//#if 1847886054 
nameLocTab.add(spacer);
//#endif 


//#if -416787157 
c.gridx = 3;
//#endif 


//#if 1129038343 
c.gridy = 0;
//#endif 


//#if -550286505 
c.weightx = 0.0;
//#endif 


//#if -303535915 
gb.setConstraints(typeLabel, c);
//#endif 


//#if -789817596 
nameLocTab.add(typeLabel);
//#endif 


//#if -416787126 
c.gridx = 4;
//#endif 


//#if 1129038344 
c.gridy = 0;
//#endif 


//#if 337217175 
c.weightx = 1.0;
//#endif 


//#if -1705892015 
gb.setConstraints(type, c);
//#endif 


//#if -1091414412 
nameLocTab.add(type);
//#endif 


//#if 244305223 
c.gridx = 3;
//#endif 


//#if 1129961863 
c.gridy = 1;
//#endif 


//#if -906646018 
c.gridwidth = 2;
//#endif 


//#if 396504734 
c.gridheight = 5;
//#endif 


//#if -601639133 
gb.setConstraints(typeDetails, c);
//#endif 


//#if -169496750 
nameLocTab.add(typeDetails);
//#endif 


//#if -1979658808 
JPanel searchPanel = new JPanel();
//#endif 


//#if -338186555 
searchPanel.setLayout(new GridLayout(1, 2, 5, 5));
//#endif 


//#if 432099063 
searchPanel.add(clearTabs);
//#endif 


//#if -426263040 
searchPanel.add(search);
//#endif 


//#if -1907304891 
searchPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//#endif 


//#if 241534662 
c.gridx = 0;
//#endif 


//#if -416757335 
c.gridy = 4;
//#endif 


//#if -550286504 
c.weightx = 0.0;
//#endif 


//#if -1029164323 
c.weighty = 0.0;
//#endif 


//#if 1157848980 
c.gridwidth = 2;
//#endif 


//#if 396504610 
c.gridheight = 1;
//#endif 


//#if 1315275959 
gb.setConstraints(searchPanel, c);
//#endif 


//#if -676998682 
nameLocTab.add(searchPanel);
//#endif 

} 

//#endif 


//#if -1910998789 
private void doGoToSelection()
    { 

//#if 1201066903 
if(results.getSelectedComponent() instanceof TabResults)//1
{ 

//#if -223417298 
((TabResults) results.getSelectedComponent()).doDoubleClick();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1566268234 
public void mouseEntered(MouseEvent me)
    { 
} 

//#endif 

 } 

//#endif 


//#if 1311021071 
class PredicateMType extends 
//#if -313740268 
PredicateType
//#endif 

  { 

//#if -1169807602 
private static final long serialVersionUID = 901828109709882796L;
//#endif 


//#if -1218685626 
protected PredicateMType(Class[] pats)
    { 

//#if 1224945682 
super(pats, pats.length);
//#endif 

} 

//#endif 


//#if 350423438 
public static PredicateType create(Object c0)
    { 

//#if -1158120241 
Class[] classes = new Class[1];
//#endif 


//#if -2137924286 
classes[0] = (Class) c0;
//#endif 


//#if 2105351010 
return new PredicateMType(classes);
//#endif 

} 

//#endif 


//#if 2105118938 
public static PredicateType create()
    { 

//#if -745695670 
return new PredicateMType(null, 0);
//#endif 

} 

//#endif 


//#if -1577322931 
public static PredicateType create(Object c0, Object c1, Object c2)
    { 

//#if -1844407905 
Class[] classes = new Class[3];
//#endif 


//#if 1490648336 
classes[0] = (Class) c0;
//#endif 


//#if 1197245360 
classes[1] = (Class) c1;
//#endif 


//#if 903842384 
classes[2] = (Class) c2;
//#endif 


//#if 1908241968 
return new PredicateMType(classes);
//#endif 

} 

//#endif 


//#if -2026074410 
@Override
    public String toString()
    { 

//#if -240585850 
String result = super.toString();
//#endif 


//#if -283928334 
if(result.startsWith("Uml"))//1
{ 

//#if -951937756 
result = result.substring(3);
//#endif 

} 

//#endif 


//#if -1665510732 
return result;
//#endif 

} 

//#endif 


//#if -877075573 
public static PredicateType create(Object c0, Object c1)
    { 

//#if 433545609 
Class[] classes = new Class[2];
//#endif 


//#if 612838651 
classes[0] = (Class) c0;
//#endif 


//#if 319435675 
classes[1] = (Class) c1;
//#endif 


//#if -1516003941 
return new PredicateMType(classes);
//#endif 

} 

//#endif 


//#if 1268954649 
protected PredicateMType(Class[] pats, int numPats)
    { 

//#if -1293720906 
super(pats, numPats);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

