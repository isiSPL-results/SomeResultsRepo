
//#if 1239205155 
// Compilation Unit of /ClassGenerationDialog.java 
 

//#if -677431280 
package org.argouml.uml.generator.ui;
//#endif 


//#if -35815537 
import java.awt.BorderLayout;
//#endif 


//#if 2091889684 
import java.awt.Component;
//#endif 


//#if -1341296437 
import java.awt.Dimension;
//#endif 


//#if -1438980403 
import java.awt.FlowLayout;
//#endif 


//#if -723468095 
import java.awt.event.ActionEvent;
//#endif 


//#if -1941412313 
import java.awt.event.ActionListener;
//#endif 


//#if -601518422 
import java.util.ArrayList;
//#endif 


//#if -127603721 
import java.util.Collection;
//#endif 


//#if 339253740 
import java.util.Collections;
//#endif 


//#if 19026995 
import java.util.HashMap;
//#endif 


//#if 19209709 
import java.util.HashSet;
//#endif 


//#if -228612745 
import java.util.List;
//#endif 


//#if -1531373307 
import java.util.Map;
//#endif 


//#if -1531190593 
import java.util.Set;
//#endif 


//#if 321691803 
import java.util.StringTokenizer;
//#endif 


//#if 1257179261 
import java.util.TreeSet;
//#endif 


//#if 1664041483 
import javax.swing.BorderFactory;
//#endif 


//#if -1461198003 
import javax.swing.JButton;
//#endif 


//#if -1570529918 
import javax.swing.JComboBox;
//#endif 


//#if -945277320 
import javax.swing.JFileChooser;
//#endif 


//#if -472601789 
import javax.swing.JLabel;
//#endif 


//#if -357727693 
import javax.swing.JPanel;
//#endif 


//#if 1170992394 
import javax.swing.JScrollPane;
//#endif 


//#if -243562071 
import javax.swing.JTable;
//#endif 


//#if -960839184 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if -1944426884 
import javax.swing.table.JTableHeader;
//#endif 


//#if 781149285 
import javax.swing.table.TableColumn;
//#endif 


//#if -1927681753 
import org.apache.log4j.Logger;
//#endif 


//#if -2053685292 
import org.argouml.i18n.Translator;
//#endif 


//#if -80145254 
import org.argouml.model.Model;
//#endif 


//#if 2064443152 
import org.argouml.notation.Notation;
//#endif 


//#if 857469933 
import org.argouml.uml.generator.CodeGenerator;
//#endif 


//#if -2086193975 
import org.argouml.uml.generator.GeneratorManager;
//#endif 


//#if -1755524469 
import org.argouml.uml.generator.Language;
//#endif 


//#if 342061873 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -602127179 
import org.tigris.swidgets.Dialog;
//#endif 


//#if -513478358 
public class ClassGenerationDialog extends 
//#if 1983438860 
ArgoDialog
//#endif 

 implements 
//#if -1381449707 
ActionListener
//#endif 

  { 

//#if 1411745757 
private static final String SOURCE_LANGUAGE_TAG = "src_lang";
//#endif 


//#if 438616749 
private static final Logger LOG =
        Logger.getLogger(ClassGenerationDialog.class);
//#endif 


//#if 1237351928 
private TableModelClassChecks classTableModel;
//#endif 


//#if -270178954 
private boolean isPathInModel;
//#endif 


//#if -2141210432 
private List<Language> languages;
//#endif 


//#if -1914377303 
private JTable classTable;
//#endif 


//#if 1419771457 
private JComboBox outputDirectoryComboBox;
//#endif 


//#if -1112543338 
private int languageHistory;
//#endif 


//#if -1270380799 
private static final long serialVersionUID = -8897965616334156746L;
//#endif 


//#if 932883373 
public ClassGenerationDialog(List<Object> nodes, boolean inModel)
    { 

//#if -427400928 
super(
            Translator.localize("dialog.title.generate-classes"),
            Dialog.OK_CANCEL_OPTION,
            true);
//#endif 


//#if -254642317 
isPathInModel = inModel;
//#endif 


//#if 361767929 
buildLanguages();
//#endif 


//#if 593996659 
JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
//#endif 


//#if 1271630804 
classTableModel = new TableModelClassChecks();
//#endif 


//#if 91252607 
classTableModel.setTarget(nodes);
//#endif 


//#if -1203646610 
classTable = new JTable(classTableModel);
//#endif 


//#if -116419984 
classTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//#endif 


//#if 206876955 
classTable.setShowVerticalLines(false);
//#endif 


//#if 1049529388 
if(languages.size() <= 1)//1
{ 

//#if 1656347882 
classTable.setTableHeader(null);
//#endif 

} 

//#endif 


//#if 1855447859 
setClassTableColumnWidths();
//#endif 


//#if -565135700 
classTable.setPreferredScrollableViewportSize(new Dimension(300, 300));
//#endif 


//#if -866215568 
JButton selectAllButton = new JButton();
//#endif 


//#if 1041401790 
nameButton(selectAllButton, "button.select-all");
//#endif 


//#if 418039917 
selectAllButton.addActionListener(new ActionListener() {
            /*
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e) {
                classTableModel.setAllChecks(true);
                classTable.repaint();
            }
        });
//#endif 


//#if -763362161 
JButton selectNoneButton = new JButton();
//#endif 


//#if -2120152108 
nameButton(selectNoneButton, "button.select-none");
//#endif 


//#if -714024185 
selectNoneButton.addActionListener(new ActionListener() {
            /*
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e) {
                classTableModel.setAllChecks(false);
                classTable.repaint();
            }
        });
//#endif 


//#if 1320167820 
JPanel selectPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
//#endif 


//#if 2017462758 
selectPanel.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
//#endif 


//#if 1927527528 
JPanel selectButtons = new JPanel(new BorderLayout(5, 0));
//#endif 


//#if -172009402 
selectButtons.add(selectAllButton, BorderLayout.CENTER);
//#endif 


//#if -2122860603 
selectButtons.add(selectNoneButton, BorderLayout.EAST);
//#endif 


//#if 1208533974 
selectPanel.add(selectButtons);
//#endif 


//#if -1617773823 
JPanel centerPanel = new JPanel(new BorderLayout(0, 2));
//#endif 


//#if 445782642 
centerPanel.add(new JLabel(Translator.localize(
                                       "label.available-classes")), BorderLayout.NORTH);
//#endif 


//#if -2009085545 
centerPanel.add(new JScrollPane(classTable), BorderLayout.CENTER);
//#endif 


//#if 81443333 
centerPanel.add(selectPanel, BorderLayout.SOUTH);
//#endif 


//#if 712265836 
contentPanel.add(centerPanel, BorderLayout.CENTER);
//#endif 


//#if -417164236 
outputDirectoryComboBox =
            new JComboBox(getClasspathEntries().toArray());
//#endif 


//#if -1611575867 
JButton browseButton = new JButton();
//#endif 


//#if 1573359895 
nameButton(browseButton, "button.browse");
//#endif 


//#if 2132779014 
browseButton.setText(browseButton.getText() + "...");
//#endif 


//#if 21006765 
browseButton.addActionListener(new ActionListener() {
            /*
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e) {
                doBrowse();
            }
        });
//#endif 


//#if 1695879709 
JPanel southPanel = new JPanel(new BorderLayout(0, 2));
//#endif 


//#if -2034832382 
if(!inModel)//1
{ 

//#if -6598544 
outputDirectoryComboBox.setEditable(true);
//#endif 


//#if 1602035743 
JPanel outputPanel = new JPanel(new BorderLayout(5, 0));
//#endif 


//#if 392484053 
outputPanel.setBorder(
                BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder(
                        Translator.localize("label.output-directory")),
                    BorderFactory.createEmptyBorder(2, 5, 5, 5)));
//#endif 


//#if 1103982593 
outputPanel.add(outputDirectoryComboBox, BorderLayout.CENTER);
//#endif 


//#if -670301198 
outputPanel.add(browseButton, BorderLayout.EAST);
//#endif 


//#if -2070900195 
southPanel.add(outputPanel, BorderLayout.NORTH);
//#endif 

} 

//#endif 


//#if -1120381914 
contentPanel.add(southPanel, BorderLayout.SOUTH);
//#endif 


//#if -1533478886 
setContent(contentPanel);
//#endif 

} 

//#endif 


//#if -1905371664 
private void setClassTableColumnWidths()
    { 

//#if 791534655 
TableColumn column = null;
//#endif 


//#if -534703473 
Component c = null;
//#endif 


//#if 1479178943 
int width = 0;
//#endif 


//#if -188350682 
for (int i = 0; i < classTable.getColumnCount() - 1; ++i) //1
{ 

//#if 660679386 
column = classTable.getColumnModel().getColumn(i);
//#endif 


//#if 257635277 
width = 30;
//#endif 


//#if 1932170370 
JTableHeader header = classTable.getTableHeader();
//#endif 


//#if -296078295 
if(header != null)//1
{ 

//#if -1573642869 
c =
                    header.getDefaultRenderer().getTableCellRendererComponent(
                        classTable,
                        column.getHeaderValue(),
                        false,
                        false,
                        0,
                        0);
//#endif 


//#if 1493770218 
width = Math.max(c.getPreferredSize().width + 8, width);
//#endif 

} 

//#endif 


//#if -1627366439 
column.setPreferredWidth(width);
//#endif 


//#if -282608430 
column.setWidth(width);
//#endif 


//#if -2037096280 
column.setMinWidth(width);
//#endif 


//#if -1973227818 
column.setMaxWidth(width);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1450104218 
private void buildLanguages()
    { 

//#if 1558772360 
languages = new ArrayList<Language>(
            GeneratorManager.getInstance().getLanguages());
//#endif 

} 

//#endif 


//#if 446931692 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -215821473 
super.actionPerformed(e);
//#endif 


//#if -1879227384 
if(e.getSource() == getOkButton())//1
{ 

//#if -610238696 
String path = null;
//#endif 


//#if -195295267 
List<String>[] fileNames = new List[languages.size()];
//#endif 


//#if -715574334 
for (int i = 0; i < languages.size(); i++) //1
{ 

//#if 930839400 
fileNames[i] = new ArrayList<String>();
//#endif 


//#if -880447719 
Language language = languages.get(i);
//#endif 


//#if -1928870502 
GeneratorManager genMan = GeneratorManager.getInstance();
//#endif 


//#if -921642799 
CodeGenerator generator = genMan.getGenerator(language);
//#endif 


//#if -37342712 
Set nodes = classTableModel.getChecked(language);
//#endif 


//#if 1326553943 
if(!isPathInModel)//1
{ 

//#if 967832103 
path =
                        ((String) outputDirectoryComboBox.getModel()
                         .getSelectedItem());
//#endif 


//#if -1038062442 
if(path != null)//1
{ 

//#if 1582011051 
path = path.trim();
//#endif 


//#if -1376141957 
if(path.length() > 0)//1
{ 

//#if 846299759 
Collection<String> files =
                                generator.generateFiles(nodes, path, false);
//#endif 


//#if 416519564 
for (String filename : files) //1
{ 

//#if -1788995201 
fileNames[i].add(
                                    path + CodeGenerator.FILE_SEPARATOR
                                    + filename);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 955548776 
Map<String, Set<Object>> nodesPerPath =
                        new HashMap<String, Set<Object>>();
//#endif 


//#if -1409260621 
for (Object node : nodes) //1
{ 

//#if 816544848 
if(!Model.getFacade().isAClassifier(node))//1
{ 

//#if 845357923 
continue;
//#endif 

} 

//#endif 


//#if 1782390343 
path = GeneratorManager.getCodePath(node);
//#endif 


//#if -870418424 
if(path == null)//1
{ 

//#if -524028467 
Object parent =
                                Model.getFacade().getNamespace(node);
//#endif 


//#if 996704792 
while (parent != null) //1
{ 

//#if 710208303 
path = GeneratorManager.getCodePath(parent);
//#endif 


//#if 18441124 
if(path != null)//1
{ 

//#if -1377899507 
break;

//#endif 

} 

//#endif 


//#if 87301409 
parent =
                                    Model.getFacade().getNamespace(parent);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 336992420 
if(path != null)//1
{ 

//#if -1270886413 
final String fileSep = CodeGenerator.FILE_SEPARATOR;
//#endif 


//#if 920489623 
if(path.endsWith(fileSep))//1
{ 

//#if -2137846258 
path =
                                    path.substring(0, path.length()
                                                   - fileSep.length());
//#endif 

} 

//#endif 


//#if -1027403348 
Set<Object> np = nodesPerPath.get(path);
//#endif 


//#if -1738616808 
if(np == null)//1
{ 

//#if -353923136 
np = new HashSet<Object>();
//#endif 


//#if -1632582179 
nodesPerPath.put(path, np);
//#endif 

} 

//#endif 


//#if -2099879101 
np.add(node);
//#endif 


//#if 212802373 
saveLanguage(node, language);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1746646239 
for (Map.Entry entry : nodesPerPath.entrySet()) //1
{ 

//#if -1115586338 
String basepath = (String) entry.getKey();
//#endif 


//#if 1443013744 
Set nodeColl = (Set) entry.getValue();
//#endif 


//#if -1769598664 
Collection<String> files =
                            generator.generateFiles(nodeColl, basepath, false);
//#endif 


//#if -1343426069 
for (String filename : files) //1
{ 

//#if 1819646921 
fileNames[i].add(basepath
                                             + CodeGenerator.FILE_SEPARATOR
                                             + filename);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 964165525 
private void saveLanguage(Object node, Language language)
    { 

//#if 1278637256 
Object taggedValue =
            Model.getFacade().getTaggedValue(node, SOURCE_LANGUAGE_TAG);
//#endif 


//#if -1154741924 
if(taggedValue != null)//1
{ 

//#if 1261459055 
String savedLang = Model.getFacade().getValueOfTag(taggedValue);
//#endif 


//#if -152021082 
if(!language.getName().equals(savedLang))//1
{ 

//#if -1640969389 
Model.getExtensionMechanismsHelper().setValueOfTag(
                    taggedValue, language.getName());
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1509109356 
taggedValue =
                Model.getExtensionMechanismsFactory().buildTaggedValue(
                    SOURCE_LANGUAGE_TAG, language.getName());
//#endif 


//#if 1743270415 
Model.getExtensionMechanismsHelper().addTaggedValue(
                node, taggedValue);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2102786019 
public ClassGenerationDialog(List<Object> nodes)
    { 

//#if -2067330603 
this(nodes, false);
//#endif 

} 

//#endif 


//#if -1359180266 
@Override
    protected void nameButtons()
    { 

//#if 1149519289 
super.nameButtons();
//#endif 


//#if 1005049493 
nameButton(getOkButton(), "button.generate");
//#endif 

} 

//#endif 


//#if 665199170 
private void doBrowse()
    { 

//#if -934194569 
try //1
{ 

//#if -742372606 
JFileChooser chooser =
                new JFileChooser(
                (String) outputDirectoryComboBox
                .getModel()
                .getSelectedItem());
//#endif 


//#if 483679941 
if(chooser == null)//1
{ 

//#if -1836610116 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if 173358635 
chooser.setFileHidingEnabled(true);
//#endif 


//#if 1136181074 
chooser.setMultiSelectionEnabled(false);
//#endif 


//#if 827708941 
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//#endif 


//#if -1651384809 
chooser.setDialogTitle(Translator.localize(
                                       "dialog.generation.chooser.choose-output-dir"));
//#endif 


//#if 1475900075 
chooser.showDialog(this, Translator.localize(
                                   "dialog.generation.chooser.approve-button-text"));
//#endif 


//#if -495624705 
if(!"".equals(chooser.getSelectedFile().getPath()))//1
{ 

//#if 91781994 
String path = chooser.getSelectedFile().getPath();
//#endif 


//#if 985142751 
outputDirectoryComboBox.addItem(path);
//#endif 


//#if 2092956149 
outputDirectoryComboBox.getModel().setSelectedItem(path);
//#endif 

} 

//#endif 

} 

//#if -491894416 
catch (Exception userPressedCancel) //1
{ 

//#if -342588142 
LOG.info("user pressed cancel");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 765152885 
private static Collection<String> getClasspathEntries()
    { 

//#if 82659532 
String classpath = System.getProperty("java.class.path");
//#endif 


//#if -783814943 
Collection<String> entries = new TreeSet<String>();
//#endif 


//#if 1581413711 
final String pathSep = System.getProperty("path.separator");
//#endif 


//#if 1811412202 
StringTokenizer allEntries = new StringTokenizer(classpath, pathSep);
//#endif 


//#if -1963679953 
while (allEntries.hasMoreElements()) //1
{ 

//#if -1038166611 
String entry = allEntries.nextToken();
//#endif 


//#if 1237464559 
if(!entry.toLowerCase().endsWith(".jar")
                    && !entry.toLowerCase().endsWith(".zip"))//1
{ 

//#if 1521579491 
entries.add(entry);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1397137219 
return entries;
//#endif 

} 

//#endif 


//#if 102129883 
class TableModelClassChecks extends 
//#if -1909784053 
AbstractTableModel
//#endif 

  { 

//#if 1980252459 
private List<Object> classes;
//#endif 


//#if 356201702 
private Set<Object>[] checked;
//#endif 


//#if 1488183489 
private static final long serialVersionUID = 6108214254680694765L;
//#endif 


//#if -637658779 
@Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex)
        { 

//#if 550179952 
if(columnIndex == getLanguagesCount())//1
{ 

//#if 375361193 
return;
//#endif 

} 

//#endif 


//#if -990953874 
if(columnIndex >= getColumnCount())//1
{ 

//#if 345384553 
return;
//#endif 

} 

//#endif 


//#if -1342005307 
if(!(aValue instanceof Boolean))//1
{ 

//#if -513432586 
return;
//#endif 

} 

//#endif 


//#if -2052169591 
boolean val = ((Boolean) aValue).booleanValue();
//#endif 


//#if 34619208 
Object cls = classes.get(rowIndex);
//#endif 


//#if -69998171 
if(columnIndex >= 0 && columnIndex < getLanguagesCount())//1
{ 

//#if 286252542 
if(val)//1
{ 

//#if -1788867504 
checked[columnIndex].add(cls);
//#endif 

} 
else
{ 

//#if -615034832 
checked[columnIndex].remove(cls);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1076767486 
if(val && !getOkButton().isEnabled())//1
{ 

//#if 906627290 
getOkButton().setEnabled(true);
//#endif 

} 
else

//#if 1096223446 
if(!val && getOkButton().isEnabled()
                       && getChecked().size() == 0)//1
{ 

//#if 481243395 
getOkButton().setEnabled(false);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -712182950 
public Set<Object> getChecked(Language lang)
        { 

//#if -1962120829 
int index = languages.indexOf(lang);
//#endif 


//#if -1840156068 
if(index == -1)//1
{ 

//#if 583326990 
return Collections.emptySet();
//#endif 

} 

//#endif 


//#if -179972445 
return checked[index];
//#endif 

} 

//#endif 


//#if -1515637907 
public void setAllChecks(boolean value)
        { 

//#if 303003988 
int rows = getRowCount();
//#endif 


//#if -2072586301 
int checks = getLanguagesCount();
//#endif 


//#if 342006532 
if(rows == 0)//1
{ 

//#if -589973455 
return;
//#endif 

} 

//#endif 


//#if -684809951 
for (int i = 0; i < rows; ++i) //1
{ 

//#if -2009977626 
Object cls = classes.get(i);
//#endif 


//#if -562172871 
for (int j = 0; j < checks; ++j) //1
{ 

//#if 1676401721 
if(value && (j == languageHistory))//1
{ 

//#if 666428807 
checked[j].add(cls);
//#endif 

} 
else
{ 

//#if -1550722814 
checked[j].remove(cls);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 190477470 
if(value)//1
{ 

//#if 186914720 
if(++languageHistory >= checks)//1
{ 

//#if -297932074 
languageHistory = 0;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -581540333 
getOkButton().setEnabled(value);
//#endif 

} 

//#endif 


//#if 922826842 
public Class getColumnClass(int c)
        { 

//#if 1961323459 
if(c >= 0 && c < getLanguagesCount())//1
{ 

//#if -265707079 
return Boolean.class;
//#endif 

} 
else

//#if -1537408364 
if(c == getLanguagesCount())//1
{ 

//#if 883378398 
return String.class;
//#endif 

} 

//#endif 


//#endif 


//#if -1646369362 
return String.class;
//#endif 

} 

//#endif 


//#if -540204005 
public Object getValueAt(int row, int col)
        { 

//#if -355612585 
Object cls = classes.get(row);
//#endif 


//#if 2109913749 
if(col == getLanguagesCount())//1
{ 

//#if -1637570667 
String name = Model.getFacade().getName(cls);
//#endif 


//#if -47051364 
if(name.length() > 0)//1
{ 

//#if -421282778 
return name;
//#endif 

} 

//#endif 


//#if -1382510563 
return "(anon)";
//#endif 

} 
else

//#if -888999612 
if(col >= 0 && col < getLanguagesCount())//1
{ 

//#if 969830959 
if(checked[col].contains(cls))//1
{ 

//#if -763572617 
return Boolean.TRUE;
//#endif 

} 

//#endif 


//#if 1162331645 
return Boolean.FALSE;
//#endif 

} 
else
{ 

//#if 813319481 
return "CC-r:" + row + " c:" + col;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -511399732 
@Override
        public String getColumnName(int c)
        { 

//#if 512073670 
if(c >= 0 && c < getLanguagesCount())//1
{ 

//#if -24359515 
return languages.get(c).getName();
//#endif 

} 
else

//#if -384831358 
if(c == getLanguagesCount())//1
{ 

//#if -212736202 
return "Class Name";
//#endif 

} 

//#endif 


//#endif 


//#if 1628509508 
return "XXX";
//#endif 

} 

//#endif 


//#if 1010117468 
public int getColumnCount()
        { 

//#if -86517650 
return 1 + getLanguagesCount();
//#endif 

} 

//#endif 


//#if -578411666 
@Override
        public boolean isCellEditable(int row, int col)
        { 

//#if 1071222517 
Object cls = classes.get(row);
//#endif 


//#if 1143865907 
if(col == getLanguagesCount())//1
{ 

//#if 1080382943 
return false;
//#endif 

} 

//#endif 


//#if -1432357863 
if(!(Model.getFacade().getName(cls).length() > 0))//1
{ 

//#if -686450657 
return false;
//#endif 

} 

//#endif 


//#if 1478772454 
if(col >= 0 && col < getLanguagesCount())//1
{ 

//#if -1468360421 
return true;
//#endif 

} 

//#endif 


//#if -716149549 
return false;
//#endif 

} 

//#endif 


//#if 1905369714 
public TableModelClassChecks()
        { 
} 

//#endif 


//#if -1697206059 
private boolean isSupposedToBeGeneratedAsLanguage(
            Language lang,
            Object cls)
        { 

//#if -911576476 
if(lang == null || cls == null)//1
{ 

//#if 1692873376 
return false;
//#endif 

} 

//#endif 


//#if 1862723090 
Object taggedValue =
                Model.getFacade().getTaggedValue(cls, SOURCE_LANGUAGE_TAG);
//#endif 


//#if -963995756 
if(taggedValue == null)//1
{ 

//#if -300544130 
return false;
//#endif 

} 

//#endif 


//#if 1893347697 
String savedLang = Model.getFacade().getValueOfTag(taggedValue);
//#endif 


//#if 124433872 
return (lang.getName().equals(savedLang));
//#endif 

} 

//#endif 


//#if -846157519 
private int getLanguagesCount()
        { 

//#if -1307649412 
if(languages == null)//1
{ 

//#if -1100288297 
return 0;
//#endif 

} 

//#endif 


//#if 835642329 
return languages.size();
//#endif 

} 

//#endif 


//#if 854868089 
public void setTarget(List<Object> nodes)
        { 

//#if 1451147306 
classes = nodes;
//#endif 


//#if -1761638865 
checked = new Set[getLanguagesCount()];
//#endif 


//#if 632647179 
for (int j = 0; j < getLanguagesCount(); j++) //1
{ 

//#if -1917286377 
checked[j] = new HashSet<Object>();
//#endif 

} 

//#endif 


//#if 2143788919 
for (Object cls : classes) //1
{ 

//#if -1710883756 
for (int j = 0; j < getLanguagesCount(); j++) //1
{ 

//#if 1296323764 
if(isSupposedToBeGeneratedAsLanguage(
                                languages.get(j), cls))//1
{ 

//#if 1044836019 
checked[j].add(cls);
//#endif 

} 
else

//#if -1453114326 
if((languages.get(j)).getName().equals(
                                   Notation.getConfiguredNotation()
                                   .getConfigurationValue()))//1
{ 

//#if -424067295 
checked[j].add(cls);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 948570314 
fireTableStructureChanged();
//#endif 


//#if 1829416719 
getOkButton().setEnabled(classes.size() > 0
                                     && getChecked().size() > 0);
//#endif 

} 

//#endif 


//#if -527950208 
public Set<Object> getChecked()
        { 

//#if -729705987 
Set<Object> union = new HashSet<Object>();
//#endif 


//#if 235932172 
for (int i = 0; i < getLanguagesCount(); i++) //1
{ 

//#if 791259514 
union.addAll(checked[i]);
//#endif 

} 

//#endif 


//#if -589089431 
return union;
//#endif 

} 

//#endif 


//#if -158616300 
public int getRowCount()
        { 

//#if 25181764 
if(classes == null)//1
{ 

//#if 1377250399 
return 0;
//#endif 

} 

//#endif 


//#if -2013099961 
return classes.size();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

