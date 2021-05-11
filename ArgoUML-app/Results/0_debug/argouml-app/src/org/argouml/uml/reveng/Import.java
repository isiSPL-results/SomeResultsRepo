
//#if 1713204940 
// Compilation Unit of /Import.java 
 

//#if 74112906 
package org.argouml.uml.reveng;
//#endif 


//#if 1584107989 
import java.awt.BorderLayout;
//#endif 


//#if -397799138 
import java.awt.Frame;
//#endif 


//#if -1663554025 
import java.awt.GridBagConstraints;
//#endif 


//#if -1786588737 
import java.awt.GridBagLayout;
//#endif 


//#if -1177442987 
import java.awt.Insets;
//#endif 


//#if -876533189 
import java.awt.event.ActionEvent;
//#endif 


//#if -648359315 
import java.awt.event.ActionListener;
//#endif 


//#if 1957314517 
import java.awt.event.FocusEvent;
//#endif 


//#if 631479955 
import java.awt.event.FocusListener;
//#endif 


//#if -224827657 
import java.io.File;
//#endif 


//#if 525254443 
import java.nio.charset.Charset;
//#endif 


//#if 1866921457 
import java.util.List;
//#endif 


//#if 2117869537 
import java.util.StringTokenizer;
//#endif 


//#if -773244670 
import javax.swing.ButtonGroup;
//#endif 


//#if -2045503934 
import javax.swing.JCheckBox;
//#endif 


//#if 49393608 
import javax.swing.JComboBox;
//#endif 


//#if 1111680724 
import javax.swing.JComponent;
//#endif 


//#if -863716419 
import javax.swing.JDialog;
//#endif 


//#if -56052110 
import javax.swing.JFileChooser;
//#endif 


//#if 55258813 
import javax.swing.JLabel;
//#endif 


//#if 170132909 
import javax.swing.JPanel;
//#endif 


//#if 1806180676 
import javax.swing.JRadioButton;
//#endif 


//#if 1556593457 
import javax.swing.JTabbedPane;
//#endif 


//#if -1266696700 
import javax.swing.JTextField;
//#endif 


//#if -270968216 
import javax.swing.filechooser.FileSystemView;
//#endif 


//#if 430345191 
import org.argouml.application.api.Argo;
//#endif 


//#if 603764934 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1791231386 
import org.argouml.i18n.Translator;
//#endif 


//#if 239808724 
import org.argouml.moduleloader.ModuleInterface;
//#endif 


//#if -1261651979 
import org.argouml.uml.reveng.SettingsTypes.BooleanSelection2;
//#endif 


//#if -1295185062 
import org.argouml.uml.reveng.SettingsTypes.PathListSelection;
//#endif 


//#if -184341860 
import org.argouml.uml.reveng.SettingsTypes.PathSelection;
//#endif 


//#if -484802989 
import org.argouml.uml.reveng.SettingsTypes.Setting;
//#endif 


//#if -2049902884 
import org.argouml.uml.reveng.SettingsTypes.UniqueSelection2;
//#endif 


//#if -623359635 
import org.argouml.uml.reveng.SettingsTypes.UserString2;
//#endif 


//#if -1283321147 
import org.argouml.uml.reveng.ui.ImportClasspathDialog;
//#endif 


//#if 1363414062 
import org.argouml.uml.reveng.ui.ImportStatusScreen;
//#endif 


//#if 1908588559 
import org.argouml.util.SuffixFilter;
//#endif 


//#if -1113892287 
import org.argouml.util.UIUtils;
//#endif 


//#if 1802410452 
import org.tigris.gef.base.Globals;
//#endif 


//#if 942418845 
import org.tigris.swidgets.GridLayout2;
//#endif 


//#if -79168435 
public class Import extends 
//#if -701135454 
ImportCommon
//#endif 

 implements 
//#if -1739520486 
ImportSettings
//#endif 

  { 

//#if 847538141 
private JComponent configPanel;
//#endif 


//#if 806993741 
private JCheckBox descend;
//#endif 


//#if -518368201 
private JCheckBox changedOnly;
//#endif 


//#if 2063830691 
private JCheckBox createDiagrams;
//#endif 


//#if -1155525269 
private JCheckBox minimiseFigs;
//#endif 


//#if -1759131595 
private JCheckBox layoutDiagrams;
//#endif 


//#if 98364427 
private JRadioButton classOnly;
//#endif 


//#if 1104142859 
private JRadioButton classAndFeatures;
//#endif 


//#if 408245651 
private JRadioButton fullImport;
//#endif 


//#if 1858123895 
private JComboBox sourceEncoding;
//#endif 


//#if 1297520242 
private JDialog dialog;
//#endif 


//#if 484799142 
private ImportStatusScreen iss;
//#endif 


//#if -319170954 
private Frame myFrame;
//#endif 


//#if -961555579 
public boolean isChangedOnlySelected()
    { 

//#if -1440475896 
if(changedOnly != null)//1
{ 

//#if 1416915841 
return changedOnly.isSelected();
//#endif 

} 

//#endif 


//#if -1895986384 
return false;
//#endif 

} 

//#endif 


//#if 1776950282 
private JComponent getChooser()
    { 

//#if 1871863140 
String directory = Globals.getLastDirectory();
//#endif 


//#if 663070600 
final JFileChooser chooser = new ImportFileChooser(this, directory);
//#endif 


//#if -1102758174 
chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//#endif 


//#if -1421349111 
ImportInterface current = getCurrentModule();
//#endif 


//#if 242937519 
if(current != null)//1
{ 

//#if 746690872 
updateFilters(chooser, null, current.getSuffixFilters());
//#endif 

} 

//#endif 


//#if -804729850 
return chooser;
//#endif 

} 

//#endif 


//#if 1349899874 
public boolean isDiagramLayoutSelected()
    { 

//#if -889246621 
if(layoutDiagrams != null)//1
{ 

//#if -1611447858 
return layoutDiagrams.isSelected();
//#endif 

} 

//#endif 


//#if 1829556965 
return false;
//#endif 

} 

//#endif 


//#if -1276850480 
@Deprecated
    public boolean isAttributeSelected()
    { 

//#if -1677589296 
return false;
//#endif 

} 

//#endif 


//#if -1356018769 
public boolean isDescendSelected()
    { 

//#if -753747140 
if(descend != null)//1
{ 

//#if 1145703341 
return descend.isSelected();
//#endif 

} 

//#endif 


//#if 638000747 
return true;
//#endif 

} 

//#endif 


//#if -591834513 
public boolean isCreateDiagramsSelected()
    { 

//#if 2097686568 
if(createDiagrams != null)//1
{ 

//#if 1526135201 
return createDiagrams.isSelected();
//#endif 

} 

//#endif 


//#if -2052522029 
return true;
//#endif 

} 

//#endif 


//#if 388260157 
private void addDetailLevelButtons(JPanel panel)
    { 

//#if -1410009355 
JLabel importDetailLabel = new JLabel(Translator
                                              .localize("action.import-level-of-import-detail"));
//#endif 


//#if -646546737 
ButtonGroup detailButtonGroup = new ButtonGroup();
//#endif 


//#if -9216628 
classOnly = new JRadioButton(Translator
                                     .localize("action.import-option-classifiers"));
//#endif 


//#if -751178771 
detailButtonGroup.add(classOnly);
//#endif 


//#if -1147229472 
classAndFeatures = new JRadioButton(Translator
                                            .localize("action.import-option-classifiers-plus-specs"));
//#endif 


//#if 1061380727 
detailButtonGroup.add(classAndFeatures);
//#endif 


//#if -1655984915 
fullImport = new JRadioButton(Translator
                                      .localize("action.import-option-full-import"));
//#endif 


//#if -538279768 
String detaillevel = Configuration
                             .getString(Argo.KEY_IMPORT_GENERAL_DETAIL_LEVEL);
//#endif 


//#if 2047934098 
if("0".equals(detaillevel))//1
{ 

//#if -1807864931 
classOnly.setSelected(true);
//#endif 

} 
else

//#if 1209837431 
if("1".equals(detaillevel))//1
{ 

//#if -1159441665 
classAndFeatures.setSelected(true);
//#endif 

} 
else
{ 

//#if -2032787620 
fullImport.setSelected(true);
//#endif 

} 

//#endif 


//#endif 


//#if -2079910993 
detailButtonGroup.add(fullImport);
//#endif 


//#if -1835658737 
panel.add(importDetailLabel);
//#endif 


//#if 962612373 
panel.add(classOnly);
//#endif 


//#if 1593210063 
panel.add(classAndFeatures);
//#endif 


//#if -491993081 
panel.add(fullImport);
//#endif 

} 

//#endif 


//#if 439684677 
private static void updateFilters(JFileChooser chooser,
                                      SuffixFilter[] oldFilters, SuffixFilter[] newFilters)
    { 

//#if -1540779744 
if(oldFilters != null)//1
{ 

//#if -1817992560 
for (int i = 0; i < oldFilters.length; i++) //1
{ 

//#if -2121092799 
chooser.removeChoosableFileFilter(oldFilters[i]);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1280125241 
if(newFilters != null)//1
{ 

//#if -287098980 
for (int i = 0; i < newFilters.length; i++) //1
{ 

//#if -1710906903 
chooser.addChoosableFileFilter(newFilters[i]);
//#endif 

} 

//#endif 


//#if 2108696983 
if(newFilters.length > 0)//1
{ 

//#if -1166461331 
chooser.setFileFilter(newFilters[0]);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1611990781 
private void addSourceEncoding(JPanel panel)
    { 

//#if -317918499 
panel.add(new JLabel(
                      Translator.localize("action.import-file-encoding")));
//#endif 


//#if -1431240457 
String enc =
            Configuration.getString(Argo.KEY_INPUT_SOURCE_ENCODING);
//#endif 


//#if -1343217250 
if(enc == null || enc.trim().equals(""))//1
{ 

//#if 911909079 
enc = System.getProperty("file.encoding");
//#endif 

} 

//#endif 


//#if -1380572767 
if(enc.startsWith("cp"))//1
{ 

//#if -2038871538 
enc = "windows-" + enc.substring(2);
//#endif 

} 

//#endif 


//#if -1317894109 
sourceEncoding = new JComboBox(Charset
                                       .availableCharsets().keySet().toArray());
//#endif 


//#if -156594433 
sourceEncoding.setSelectedItem(enc);
//#endif 


//#if 1606897020 
panel.add(sourceEncoding);
//#endif 

} 

//#endif 


//#if -81921920 
public boolean isMinimizeFigsSelected()
    { 

//#if 377677982 
if(minimiseFigs != null)//1
{ 

//#if 318277367 
return minimiseFigs.isSelected();
//#endif 

} 

//#endif 


//#if -1927973100 
return false;
//#endif 

} 

//#endif 


//#if -1620566749 
private void disposeDialog()
    { 

//#if 1864891484 
StringBuffer flags = new StringBuffer(30);
//#endif 


//#if -1807004923 
flags.append(isDescendSelected()).append(",");
//#endif 


//#if 1973961179 
flags.append(isChangedOnlySelected()).append(",");
//#endif 


//#if -2079965765 
flags.append(isCreateDiagramsSelected()).append(",");
//#endif 


//#if -226279220 
flags.append(isMinimizeFigsSelected()).append(",");
//#endif 


//#if 645869065 
flags.append(isDiagramLayoutSelected());
//#endif 


//#if 1477438351 
Configuration.setString(Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS, flags
                                .toString());
//#endif 


//#if 148556498 
Configuration.setString(Argo.KEY_IMPORT_GENERAL_DETAIL_LEVEL, String
                                .valueOf(getImportLevel()));
//#endif 


//#if 1341841208 
Configuration.setString(Argo.KEY_INPUT_SOURCE_ENCODING,
                                getInputSourceEncoding());
//#endif 


//#if -2072726124 
dialog.setVisible(false);
//#endif 


//#if 1876343634 
dialog.dispose();
//#endif 

} 

//#endif 


//#if 444293288 
@Deprecated
    public boolean isDatatypeSelected()
    { 

//#if -990243913 
return false;
//#endif 

} 

//#endif 


//#if -399928296 
private void addConfigCheckboxes(JPanel panel)
    { 

//#if 1773017245 
boolean desc = true;
//#endif 


//#if 708925598 
boolean chan = true;
//#endif 


//#if -457089065 
boolean crea = true;
//#endif 


//#if -2024517149 
boolean mini = true;
//#endif 


//#if -1527137833 
boolean layo = true;
//#endif 


//#if 887457669 
String flags = Configuration
                       .getString(Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
//#endif 


//#if 578772435 
if(flags != null && flags.length() > 0)//1
{ 

//#if -859390139 
StringTokenizer st = new StringTokenizer(flags, ",");
//#endif 


//#if -347085471 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 

//#if 1352332554 
desc = false;
//#endif 

} 

//#endif 


//#if -2036908624 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//2
{ 

//#if 246977021 
chan = false;
//#endif 

} 

//#endif 


//#if -2036878832 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//3
{ 

//#if 1453309663 
crea = false;
//#endif 

} 

//#endif 


//#if -2036849040 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//4
{ 

//#if 312152923 
mini = false;
//#endif 

} 

//#endif 


//#if -2036819248 
if(st.hasMoreTokens() && st.nextToken().equals("false"))//5
{ 

//#if -911642296 
layo = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -796468213 
descend = new JCheckBox(Translator
                                .localize("action.import-option-descend-dir-recur"), desc);
//#endif 


//#if 1829947007 
panel.add(descend);
//#endif 


//#if -1677393289 
changedOnly = new JCheckBox(Translator
                                    .localize("action.import-option-changed_new"), chan);
//#endif 


//#if 1985652565 
panel.add(changedOnly);
//#endif 


//#if -545158711 
createDiagrams = new JCheckBox(Translator
                                       .localize("action.import-option-create-diagram"), crea);
//#endif 


//#if 2129679563 
panel.add(createDiagrams);
//#endif 


//#if -478981770 
minimiseFigs = new JCheckBox(Translator
                                     .localize("action.import-option-min-class-icon"), mini);
//#endif 


//#if -100207805 
panel.add(minimiseFigs);
//#endif 


//#if 2018559153 
layoutDiagrams = new JCheckBox(Translator.localize(
                                           "action.import-option-perform-auto-diagram-layout"),
                                       layo);
//#endif 


//#if -418034311 
panel.add(layoutDiagrams);
//#endif 


//#if -1865994331 
createDiagrams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (!createDiagrams.isSelected()) {
                    minimiseFigs.setSelected(false);
                    layoutDiagrams.setSelected(false);
                }
            }
        });
//#endif 

} 

//#endif 


//#if -1369327874 
public int getImportLevel()
    { 

//#if -1315789084 
if(classOnly != null && classOnly.isSelected())//1
{ 

//#if -272043948 
return ImportSettings.DETAIL_CLASSIFIER;
//#endif 

} 
else

//#if -502052899 
if(classAndFeatures != null && classAndFeatures.isSelected())//1
{ 

//#if 1583750733 
return ImportSettings.DETAIL_CLASSIFIER_FEATURE;
//#endif 

} 
else

//#if 1708110171 
if(fullImport != null && fullImport.isSelected())//1
{ 

//#if -29691221 
return ImportSettings.DETAIL_FULL;
//#endif 

} 
else
{ 

//#if 1098322913 
return ImportSettings.DETAIL_CLASSIFIER;
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 1513369200 
private JComponent getConfigPanelExtension()
    { 

//#if 702578071 
List<Setting> settings = null;
//#endif 


//#if 1664129410 
ImportInterface current = getCurrentModule();
//#endif 


//#if 1209186792 
if(current != null)//1
{ 

//#if -159708329 
settings = current.getImportSettings();
//#endif 

} 

//#endif 


//#if -1585306305 
return  new ConfigPanelExtension(settings);
//#endif 

} 

//#endif 


//#if -1175925641 
public void doFile()
    { 

//#if -1559363432 
iss = new ImportStatusScreen(myFrame, "Importing", "Splash");
//#endif 


//#if -844492426 
Thread t = new Thread(new Runnable() {
            public void run() {
                doImport(iss);
                // ExplorerEventAdaptor.getInstance().structureChanged();
                // ProjectBrowser.getInstance().getStatusBar().showProgress(0);
            }
        }, "Import Thread");
//#endif 


//#if 1097646742 
t.start();
//#endif 

} 

//#endif 


//#if -704496191 
public Import(Frame frame)
    { 

//#if 409566392 
super();
//#endif 


//#if -540062557 
myFrame = frame;
//#endif 


//#if -30422969 
JComponent chooser = getChooser();
//#endif 


//#if 887325691 
dialog =
            new JDialog(frame,
                        Translator.localize("action.import-sources"), true);
//#endif 


//#if -478011246 
dialog.getContentPane().add(chooser, BorderLayout.CENTER);
//#endif 


//#if -1146807644 
dialog.getContentPane().add(getConfigPanel(), BorderLayout.EAST);
//#endif 


//#if 1791079412 
dialog.pack();
//#endif 


//#if 742321668 
int x = (frame.getSize().width - dialog.getSize().width) / 2;
//#endif 


//#if 1780523665 
int y = (frame.getSize().height - dialog.getSize().height) / 2;
//#endif 


//#if 75310172 
dialog.setLocation(x > 0 ? x : 0, y > 0 ? y : 0);
//#endif 


//#if -1103154358 
UIUtils.loadCommonKeyMap(dialog);
//#endif 


//#if 269476683 
dialog.setVisible(true);
//#endif 

} 

//#endif 


//#if 867295663 
public String getInputSourceEncoding()
    { 

//#if 1984581674 
return (String) sourceEncoding.getSelectedItem();
//#endif 

} 

//#endif 


//#if 1580014065 
private JComponent getConfigPanel()
    { 

//#if -1583676597 
final JTabbedPane tab = new JTabbedPane();
//#endif 


//#if 1984920263 
if(configPanel == null)//1
{ 

//#if 2018794259 
JPanel general = new JPanel();
//#endif 


//#if 1011082710 
general.setLayout(new GridLayout2(20, 1, 0, 0, GridLayout2.NONE));
//#endif 


//#if 804784909 
general.add(new JLabel(Translator
                                   .localize("action.import-select-lang")));
//#endif 


//#if 2117817897 
JComboBox selectedLanguage = new JComboBox(getModules().keySet()
                    .toArray());
//#endif 


//#if 1810699515 
selectedLanguage
            .addActionListener(new SelectedLanguageListener(tab));
//#endif 


//#if -1759193866 
general.add(selectedLanguage);
//#endif 


//#if 1864959234 
addConfigCheckboxes(general);
//#endif 


//#if -1868988995 
addDetailLevelButtons(general);
//#endif 


//#if 707750013 
addSourceEncoding(general);
//#endif 


//#if 918762882 
tab.add(general, Translator.localize("action.import-general"));
//#endif 


//#if -487964841 
ImportInterface current = getCurrentModule();
//#endif 


//#if -217682563 
if(current != null)//1
{ 

//#if 813288870 
tab.add(getConfigPanelExtension(),
                        current.getName());
//#endif 

} 

//#endif 


//#if 1444761381 
configPanel = tab;
//#endif 

} 

//#endif 


//#if -2030643574 
return configPanel;
//#endif 

} 

//#endif 


//#if -409777215 
private static class ImportFileChooser extends 
//#if -667367932 
JFileChooser
//#endif 

  { 

//#if 840904862 
private Import theImport;
//#endif 


//#if -427291161 
public ImportFileChooser(Import imp, String currentDirectoryPath,
                                 FileSystemView fsv)
        { 

//#if -597861364 
super(currentDirectoryPath, fsv);
//#endif 


//#if 1710585837 
theImport = imp;
//#endif 


//#if 357545830 
initChooser();
//#endif 

} 

//#endif 


//#if 1109694650 
@Override
        public void approveSelection()
        { 

//#if 157008511 
File[] files = getSelectedFiles();
//#endif 


//#if -1057291187 
File dir = getCurrentDirectory();
//#endif 


//#if 2097476449 
if(files.length == 0)//1
{ 

//#if 202169674 
files = new File[] {dir};
//#endif 

} 

//#endif 


//#if 2098399970 
if(files.length == 1)//1
{ 

//#if -1746737033 
File file = files[0];
//#endif 


//#if -475627950 
if(file != null && file.isDirectory())//1
{ 

//#if -1769035228 
dir = file;
//#endif 

} 
else
{ 

//#if -1910049616 
dir = file.getParentFile();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1794085572 
theImport.setSelectedFiles(files);
//#endif 


//#if -2120891545 
try //1
{ 

//#if 1839542729 
theImport.setSelectedSuffixFilter(
                    (SuffixFilter) getFileFilter());
//#endif 

} 

//#if 283942843 
catch (Exception e) //1
{ 

//#if 1882206172 
theImport.setSelectedSuffixFilter(null);
//#endif 

} 

//#endif 


//#endif 


//#if 1483783881 
Globals.setLastDirectory(dir.getPath());
//#endif 


//#if -1788704932 
theImport.disposeDialog();
//#endif 


//#if -364247094 
theImport.doFile();
//#endif 

} 

//#endif 


//#if -1584442844 
private void initChooser()
        { 

//#if -2063198145 
setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//#endif 


//#if -1063191824 
setMultiSelectionEnabled(true);
//#endif 


//#if 746228898 
setSelectedFile(getCurrentDirectory());
//#endif 

} 

//#endif 


//#if 1880233883 
public ImportFileChooser(Import imp, FileSystemView fsv)
        { 

//#if 462010166 
super(fsv);
//#endif 


//#if 608915982 
theImport = imp;
//#endif 


//#if -744124025 
initChooser();
//#endif 

} 

//#endif 


//#if 704297657 
@Override
        public void cancelSelection()
        { 

//#if -368318573 
theImport.disposeDialog();
//#endif 

} 

//#endif 


//#if 1004979240 
public ImportFileChooser(Import imp)
        { 

//#if 499838606 
super();
//#endif 


//#if 620642117 
theImport = imp;
//#endif 


//#if -732397890 
initChooser();
//#endif 

} 

//#endif 


//#if 198309236 
public ImportFileChooser(Import imp, String currentDirectoryPath)
        { 

//#if -111718965 
super(currentDirectoryPath);
//#endif 


//#if -815661431 
theImport = imp;
//#endif 


//#if 2126265858 
initChooser();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 432652739 
class ConfigPanelExtension extends 
//#if -718228457 
JPanel
//#endif 

  { 

//#if -1785930227 
private GridBagConstraints createGridBagConstraintsFinal()
        { 

//#if -1143603828 
GridBagConstraints gbc = createGridBagConstraints(false, true,
                                     false);
//#endif 


//#if 514307337 
gbc.gridheight = GridBagConstraints.REMAINDER;
//#endif 


//#if -601960499 
gbc.weighty = 1.0;
//#endif 


//#if -388833786 
return gbc;
//#endif 

} 

//#endif 


//#if 1841555302 
private GridBagConstraints createGridBagConstraints(boolean topInset,
                boolean bottomInset, boolean fill)
        { 

//#if -1759888237 
GridBagConstraints gbc = new GridBagConstraints();
//#endif 


//#if -1904476054 
gbc.gridx = GridBagConstraints.RELATIVE;
//#endif 


//#if -1893159927 
gbc.gridy = GridBagConstraints.RELATIVE;
//#endif 


//#if -910168695 
gbc.gridwidth = GridBagConstraints.REMAINDER;
//#endif 


//#if -557721840 
gbc.gridheight = 1;
//#endif 


//#if -672903185 
gbc.weightx = 1.0;
//#endif 


//#if -644303825 
gbc.weighty = 0.0;
//#endif 


//#if -1366513693 
gbc.anchor = GridBagConstraints.NORTHWEST;
//#endif 


//#if -1683738767 
gbc.fill = fill ? GridBagConstraints.HORIZONTAL
                       : GridBagConstraints.NONE;
//#endif 


//#if 1563877401 
gbc.insets =
                new Insets(
                topInset ? 5 : 0,
                5,
                bottomInset ? 5 : 0,
                5);
//#endif 


//#if 863071588 
gbc.ipadx = 0;
//#endif 


//#if 863101379 
gbc.ipady = 0;
//#endif 


//#if 1143675783 
return gbc;
//#endif 

} 

//#endif 


//#if 1994973227 
public ConfigPanelExtension(final List<Setting> settings)
        { 

//#if -426618265 
setLayout(new GridBagLayout());
//#endif 


//#if 1943660020 
if(settings == null || settings.size() == 0)//1
{ 

//#if 391173634 
JLabel label = new JLabel("No settings for this importer");
//#endif 


//#if 350627412 
add(label, createGridBagConstraints(true, false, false));
//#endif 


//#if -740335277 
add(new JPanel(), createGridBagConstraintsFinal());
//#endif 


//#if 1173904477 
return;
//#endif 

} 

//#endif 


//#if -1458679078 
for (Setting setting : settings) //1
{ 

//#if -202867133 
if(setting instanceof UniqueSelection2)//1
{ 

//#if -1090118834 
JLabel label = new JLabel(setting.getLabel());
//#endif 


//#if -1473522348 
add(label, createGridBagConstraints(true, false, false));
//#endif 


//#if 218400405 
final UniqueSelection2 us = (UniqueSelection2) setting;
//#endif 


//#if -1897625296 
ButtonGroup group = new ButtonGroup();
//#endif 


//#if -419975206 
int count = 0;
//#endif 


//#if 1730798490 
for (String option : us.getOptions()) //1
{ 

//#if 835529610 
JRadioButton button = new JRadioButton(option);
//#endif 


//#if -1921875142 
final int index = count++;
//#endif 


//#if -2130829081 
if(us.getDefaultSelection() == index)//1
{ 

//#if -661668478 
button.setSelected(true);
//#endif 

} 

//#endif 


//#if -994406716 
group.add(button);
//#endif 


//#if -1122896997 
button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                us.setSelection(index);
                            }
                        });
//#endif 


//#if 1587536921 
add(button, createGridBagConstraints(false, false,
                                                             false));
//#endif 

} 

//#endif 

} 
else

//#if 1648052686 
if(setting instanceof UserString2)//1
{ 

//#if -1347358351 
JLabel label = new JLabel(setting.getLabel());
//#endif 


//#if 221220599 
add(label, createGridBagConstraints(true, false, false));
//#endif 


//#if -36661864 
final UserString2 us = (UserString2) setting;
//#endif 


//#if 532883282 
final JTextField text =
                        new JTextField(us.getDefaultString());
//#endif 


//#if -865773683 
text.addFocusListener(new FocusListener() {
                        public void focusGained(FocusEvent e) { }
                        public void focusLost(FocusEvent e) {
                            us.setUserString(text.getText());
                        }

                    });
//#endif 


//#if 1379691630 
add(text, createGridBagConstraints(true, false, false));
//#endif 

} 
else

//#if -1252814123 
if(setting instanceof BooleanSelection2)//1
{ 

//#if -27103008 
final BooleanSelection2 bs = (BooleanSelection2) setting;
//#endif 


//#if 1960979964 
final JCheckBox button = new JCheckBox(setting.getLabel());
//#endif 


//#if -2137998718 
button.setEnabled(bs.isSelected());
//#endif 


//#if 592975951 
button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            bs.setSelected(button.isSelected());
                        }
                    });
//#endif 


//#if -706412140 
add(button, createGridBagConstraints(true, false, false));
//#endif 

} 
else

//#if 804302876 
if(setting instanceof PathSelection)//1
{ 

//#if -80882385 
JLabel label = new JLabel(setting.getLabel());
//#endif 


//#if 850314677 
add(label, createGridBagConstraints(true, false, false));
//#endif 


//#if -1011973997 
PathSelection ps = (PathSelection) setting;
//#endif 


//#if 182684587 
JTextField text = new JTextField(ps.getDefaultPath());
//#endif 


//#if 2092721648 
add(text, createGridBagConstraints(true, false, false));
//#endif 

} 
else

//#if -1890711870 
if(setting instanceof PathListSelection)//1
{ 

//#if -856543466 
PathListSelection pls = (PathListSelection) setting;
//#endif 


//#if 1304512082 
add(new ImportClasspathDialog(pls),
                        createGridBagConstraints(true, false, false));
//#endif 

} 
else
{ 

//#if 1049088474 
throw new RuntimeException("Unknown setting type requested "
                                               + setting);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -1477816587 
add(new JPanel(), createGridBagConstraintsFinal());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1260660370 
private class SelectedLanguageListener implements 
//#if 1203511630 
ActionListener
//#endif 

  { 

//#if 163429061 
private JTabbedPane tab;
//#endif 


//#if -1819213623 
public void actionPerformed(ActionEvent e)
        { 

//#if -36020562 
JComboBox cb = (JComboBox) e.getSource();
//#endif 


//#if -344844101 
String selected = (String) cb.getSelectedItem();
//#endif 


//#if 1762221956 
ImportInterface oldModule = getCurrentModule();
//#endif 


//#if 1483422176 
setCurrentModule(getModules().get(selected));
//#endif 


//#if 363966448 
updateFilters((JFileChooser) dialog.getContentPane()
                          .getComponent(0), oldModule.getSuffixFilters(),
                          getCurrentModule().getSuffixFilters());
//#endif 


//#if -884579226 
updateTabbedPane();
//#endif 

} 

//#endif 


//#if -603592975 
private void updateTabbedPane()
        { 

//#if -248420106 
String name = ((ModuleInterface) getCurrentModule()).getName();
//#endif 


//#if -1776545587 
if(tab.indexOfTab(name) < 0)//1
{ 

//#if 1481034492 
tab.add(getConfigPanelExtension(), name);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 85463734 
SelectedLanguageListener(JTabbedPane t)
        { 

//#if -908940966 
tab = t;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

