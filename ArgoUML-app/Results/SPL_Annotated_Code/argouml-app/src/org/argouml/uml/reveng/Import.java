// Compilation Unit of /Import.java 
 
package org.argouml.uml.reveng;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import org.argouml.application.api.Argo;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.moduleloader.ModuleInterface;
import org.argouml.uml.reveng.SettingsTypes.BooleanSelection2;
import org.argouml.uml.reveng.SettingsTypes.PathListSelection;
import org.argouml.uml.reveng.SettingsTypes.PathSelection;
import org.argouml.uml.reveng.SettingsTypes.Setting;
import org.argouml.uml.reveng.SettingsTypes.UniqueSelection2;
import org.argouml.uml.reveng.SettingsTypes.UserString2;
import org.argouml.uml.reveng.ui.ImportClasspathDialog;
import org.argouml.uml.reveng.ui.ImportStatusScreen;
import org.argouml.util.SuffixFilter;
import org.argouml.util.UIUtils;
import org.tigris.gef.base.Globals;
import org.tigris.swidgets.GridLayout2;
public class Import extends ImportCommon
 implements ImportSettings
  { 
private JComponent configPanel;
private JCheckBox descend;
private JCheckBox changedOnly;
private JCheckBox createDiagrams;
private JCheckBox minimiseFigs;
private JCheckBox layoutDiagrams;
private JRadioButton classOnly;
private JRadioButton classAndFeatures;
private JRadioButton fullImport;
private JComboBox sourceEncoding;
private JDialog dialog;
private ImportStatusScreen iss;
private Frame myFrame;
public boolean isChangedOnlySelected()
    { 
if(changedOnly != null)//1
{ 
return changedOnly.isSelected();
} 

return false;
} 

private JComponent getChooser()
    { 
String directory = Globals.getLastDirectory();
final JFileChooser chooser = new ImportFileChooser(this, directory);
chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
ImportInterface current = getCurrentModule();
if(current != null)//1
{ 
updateFilters(chooser, null, current.getSuffixFilters());
} 

return chooser;
} 

public boolean isDiagramLayoutSelected()
    { 
if(layoutDiagrams != null)//1
{ 
return layoutDiagrams.isSelected();
} 

return false;
} 

@Deprecated
    public boolean isAttributeSelected()
    { 
return false;
} 

public boolean isDescendSelected()
    { 
if(descend != null)//1
{ 
return descend.isSelected();
} 

return true;
} 

public boolean isCreateDiagramsSelected()
    { 
if(createDiagrams != null)//1
{ 
return createDiagrams.isSelected();
} 

return true;
} 

private void addDetailLevelButtons(JPanel panel)
    { 
JLabel importDetailLabel = new JLabel(Translator
                                              .localize("action.import-level-of-import-detail"));
ButtonGroup detailButtonGroup = new ButtonGroup();
classOnly = new JRadioButton(Translator
                                     .localize("action.import-option-classifiers"));
detailButtonGroup.add(classOnly);
classAndFeatures = new JRadioButton(Translator
                                            .localize("action.import-option-classifiers-plus-specs"));
detailButtonGroup.add(classAndFeatures);
fullImport = new JRadioButton(Translator
                                      .localize("action.import-option-full-import"));
String detaillevel = Configuration
                             .getString(Argo.KEY_IMPORT_GENERAL_DETAIL_LEVEL);
if("0".equals(detaillevel))//1
{ 
classOnly.setSelected(true);
} 
else
if("1".equals(detaillevel))//1
{ 
classAndFeatures.setSelected(true);
} 
else
{ 
fullImport.setSelected(true);
} 


detailButtonGroup.add(fullImport);
panel.add(importDetailLabel);
panel.add(classOnly);
panel.add(classAndFeatures);
panel.add(fullImport);
} 

private static void updateFilters(JFileChooser chooser,
                                      SuffixFilter[] oldFilters, SuffixFilter[] newFilters)
    { 
if(oldFilters != null)//1
{ 
for (int i = 0; i < oldFilters.length; i++) //1
{ 
chooser.removeChoosableFileFilter(oldFilters[i]);
} 

} 

if(newFilters != null)//1
{ 
for (int i = 0; i < newFilters.length; i++) //1
{ 
chooser.addChoosableFileFilter(newFilters[i]);
} 

if(newFilters.length > 0)//1
{ 
chooser.setFileFilter(newFilters[0]);
} 

} 

} 

private void addSourceEncoding(JPanel panel)
    { 
panel.add(new JLabel(
                      Translator.localize("action.import-file-encoding")));
String enc =
            Configuration.getString(Argo.KEY_INPUT_SOURCE_ENCODING);
if(enc == null || enc.trim().equals(""))//1
{ 
enc = System.getProperty("file.encoding");
} 

if(enc.startsWith("cp"))//1
{ 
enc = "windows-" + enc.substring(2);
} 

sourceEncoding = new JComboBox(Charset
                                       .availableCharsets().keySet().toArray());
sourceEncoding.setSelectedItem(enc);
panel.add(sourceEncoding);
} 

public boolean isMinimizeFigsSelected()
    { 
if(minimiseFigs != null)//1
{ 
return minimiseFigs.isSelected();
} 

return false;
} 

private void disposeDialog()
    { 
StringBuffer flags = new StringBuffer(30);
flags.append(isDescendSelected()).append(",");
flags.append(isChangedOnlySelected()).append(",");
flags.append(isCreateDiagramsSelected()).append(",");
flags.append(isMinimizeFigsSelected()).append(",");
flags.append(isDiagramLayoutSelected());
Configuration.setString(Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS, flags
                                .toString());
Configuration.setString(Argo.KEY_IMPORT_GENERAL_DETAIL_LEVEL, String
                                .valueOf(getImportLevel()));
Configuration.setString(Argo.KEY_INPUT_SOURCE_ENCODING,
                                getInputSourceEncoding());
dialog.setVisible(false);
dialog.dispose();
} 

@Deprecated
    public boolean isDatatypeSelected()
    { 
return false;
} 

private void addConfigCheckboxes(JPanel panel)
    { 
boolean desc = true;
boolean chan = true;
boolean crea = true;
boolean mini = true;
boolean layo = true;
String flags = Configuration
                       .getString(Argo.KEY_IMPORT_GENERAL_SETTINGS_FLAGS);
if(flags != null && flags.length() > 0)//1
{ 
StringTokenizer st = new StringTokenizer(flags, ",");
if(st.hasMoreTokens() && st.nextToken().equals("false"))//1
{ 
desc = false;
} 

if(st.hasMoreTokens() && st.nextToken().equals("false"))//2
{ 
chan = false;
} 

if(st.hasMoreTokens() && st.nextToken().equals("false"))//3
{ 
crea = false;
} 

if(st.hasMoreTokens() && st.nextToken().equals("false"))//4
{ 
mini = false;
} 

if(st.hasMoreTokens() && st.nextToken().equals("false"))//5
{ 
layo = false;
} 

} 

descend = new JCheckBox(Translator
                                .localize("action.import-option-descend-dir-recur"), desc);
panel.add(descend);
changedOnly = new JCheckBox(Translator
                                    .localize("action.import-option-changed_new"), chan);
panel.add(changedOnly);
createDiagrams = new JCheckBox(Translator
                                       .localize("action.import-option-create-diagram"), crea);
panel.add(createDiagrams);
minimiseFigs = new JCheckBox(Translator
                                     .localize("action.import-option-min-class-icon"), mini);
panel.add(minimiseFigs);
layoutDiagrams = new JCheckBox(Translator.localize(
                                           "action.import-option-perform-auto-diagram-layout"),
                                       layo);
panel.add(layoutDiagrams);
createDiagrams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (!createDiagrams.isSelected()) {
                    minimiseFigs.setSelected(false);
                    layoutDiagrams.setSelected(false);
                }
            }
        });
} 

public int getImportLevel()
    { 
if(classOnly != null && classOnly.isSelected())//1
{ 
return ImportSettings.DETAIL_CLASSIFIER;
} 
else
if(classAndFeatures != null && classAndFeatures.isSelected())//1
{ 
return ImportSettings.DETAIL_CLASSIFIER_FEATURE;
} 
else
if(fullImport != null && fullImport.isSelected())//1
{ 
return ImportSettings.DETAIL_FULL;
} 
else
{ 
return ImportSettings.DETAIL_CLASSIFIER;
} 



} 

private JComponent getConfigPanelExtension()
    { 
List<Setting> settings = null;
ImportInterface current = getCurrentModule();
if(current != null)//1
{ 
settings = current.getImportSettings();
} 

return  new ConfigPanelExtension(settings);
} 

public void doFile()
    { 
iss = new ImportStatusScreen(myFrame, "Importing", "Splash");
Thread t = new Thread(new Runnable() {
            public void run() {
                doImport(iss);
                // ExplorerEventAdaptor.getInstance().structureChanged();
                // ProjectBrowser.getInstance().getStatusBar().showProgress(0);
            }
        }, "Import Thread");
t.start();
} 

public Import(Frame frame)
    { 
super();
myFrame = frame;
JComponent chooser = getChooser();
dialog =
            new JDialog(frame,
                        Translator.localize("action.import-sources"), true);
dialog.getContentPane().add(chooser, BorderLayout.CENTER);
dialog.getContentPane().add(getConfigPanel(), BorderLayout.EAST);
dialog.pack();
int x = (frame.getSize().width - dialog.getSize().width) / 2;
int y = (frame.getSize().height - dialog.getSize().height) / 2;
dialog.setLocation(x > 0 ? x : 0, y > 0 ? y : 0);
UIUtils.loadCommonKeyMap(dialog);
dialog.setVisible(true);
} 

public String getInputSourceEncoding()
    { 
return (String) sourceEncoding.getSelectedItem();
} 

private JComponent getConfigPanel()
    { 
final JTabbedPane tab = new JTabbedPane();
if(configPanel == null)//1
{ 
JPanel general = new JPanel();
general.setLayout(new GridLayout2(20, 1, 0, 0, GridLayout2.NONE));
general.add(new JLabel(Translator
                                   .localize("action.import-select-lang")));
JComboBox selectedLanguage = new JComboBox(getModules().keySet()
                    .toArray());
selectedLanguage
            .addActionListener(new SelectedLanguageListener(tab));
general.add(selectedLanguage);
addConfigCheckboxes(general);
addDetailLevelButtons(general);
addSourceEncoding(general);
tab.add(general, Translator.localize("action.import-general"));
ImportInterface current = getCurrentModule();
if(current != null)//1
{ 
tab.add(getConfigPanelExtension(),
                        current.getName());
} 

configPanel = tab;
} 

return configPanel;
} 

private static class ImportFileChooser extends JFileChooser
  { 
private Import theImport;
public ImportFileChooser(Import imp, String currentDirectoryPath,
                                 FileSystemView fsv)
        { 
super(currentDirectoryPath, fsv);
theImport = imp;
initChooser();
} 

@Override
        public void approveSelection()
        { 
File[] files = getSelectedFiles();
File dir = getCurrentDirectory();
if(files.length == 0)//1
{ 
files = new File[] {dir};
} 

if(files.length == 1)//1
{ 
File file = files[0];
if(file != null && file.isDirectory())//1
{ 
dir = file;
} 
else
{ 
dir = file.getParentFile();
} 

} 

theImport.setSelectedFiles(files);
try //1
{ 
theImport.setSelectedSuffixFilter(
                    (SuffixFilter) getFileFilter());
} 
catch (Exception e) //1
{ 
theImport.setSelectedSuffixFilter(null);
} 


Globals.setLastDirectory(dir.getPath());
theImport.disposeDialog();
theImport.doFile();
} 

private void initChooser()
        { 
setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
setMultiSelectionEnabled(true);
setSelectedFile(getCurrentDirectory());
} 

public ImportFileChooser(Import imp, FileSystemView fsv)
        { 
super(fsv);
theImport = imp;
initChooser();
} 

@Override
        public void cancelSelection()
        { 
theImport.disposeDialog();
} 

public ImportFileChooser(Import imp)
        { 
super();
theImport = imp;
initChooser();
} 

public ImportFileChooser(Import imp, String currentDirectoryPath)
        { 
super(currentDirectoryPath);
theImport = imp;
initChooser();
} 

 } 

class ConfigPanelExtension extends JPanel
  { 
private GridBagConstraints createGridBagConstraintsFinal()
        { 
GridBagConstraints gbc = createGridBagConstraints(false, true,
                                     false);
gbc.gridheight = GridBagConstraints.REMAINDER;
gbc.weighty = 1.0;
return gbc;
} 

private GridBagConstraints createGridBagConstraints(boolean topInset,
                boolean bottomInset, boolean fill)
        { 
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = GridBagConstraints.RELATIVE;
gbc.gridy = GridBagConstraints.RELATIVE;
gbc.gridwidth = GridBagConstraints.REMAINDER;
gbc.gridheight = 1;
gbc.weightx = 1.0;
gbc.weighty = 0.0;
gbc.anchor = GridBagConstraints.NORTHWEST;
gbc.fill = fill ? GridBagConstraints.HORIZONTAL
                       : GridBagConstraints.NONE;
gbc.insets =
                new Insets(
                topInset ? 5 : 0,
                5,
                bottomInset ? 5 : 0,
                5);
gbc.ipadx = 0;
gbc.ipady = 0;
return gbc;
} 

public ConfigPanelExtension(final List<Setting> settings)
        { 
setLayout(new GridBagLayout());
if(settings == null || settings.size() == 0)//1
{ 
JLabel label = new JLabel("No settings for this importer");
add(label, createGridBagConstraints(true, false, false));
add(new JPanel(), createGridBagConstraintsFinal());
return;
} 

for (Setting setting : settings) //1
{ 
if(setting instanceof UniqueSelection2)//1
{ 
JLabel label = new JLabel(setting.getLabel());
add(label, createGridBagConstraints(true, false, false));
final UniqueSelection2 us = (UniqueSelection2) setting;
ButtonGroup group = new ButtonGroup();
int count = 0;
for (String option : us.getOptions()) //1
{ 
JRadioButton button = new JRadioButton(option);
final int index = count++;
if(us.getDefaultSelection() == index)//1
{ 
button.setSelected(true);
} 

group.add(button);
button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                us.setSelection(index);
                            }
                        });
add(button, createGridBagConstraints(false, false,
                                                             false));
} 

} 
else
if(setting instanceof UserString2)//1
{ 
JLabel label = new JLabel(setting.getLabel());
add(label, createGridBagConstraints(true, false, false));
final UserString2 us = (UserString2) setting;
final JTextField text =
                        new JTextField(us.getDefaultString());
text.addFocusListener(new FocusListener() {
                        public void focusGained(FocusEvent e) { }
                        public void focusLost(FocusEvent e) {
                            us.setUserString(text.getText());
                        }

                    });
add(text, createGridBagConstraints(true, false, false));
} 
else
if(setting instanceof BooleanSelection2)//1
{ 
final BooleanSelection2 bs = (BooleanSelection2) setting;
final JCheckBox button = new JCheckBox(setting.getLabel());
button.setEnabled(bs.isSelected());
button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            bs.setSelected(button.isSelected());
                        }
                    });
add(button, createGridBagConstraints(true, false, false));
} 
else
if(setting instanceof PathSelection)//1
{ 
JLabel label = new JLabel(setting.getLabel());
add(label, createGridBagConstraints(true, false, false));
PathSelection ps = (PathSelection) setting;
JTextField text = new JTextField(ps.getDefaultPath());
add(text, createGridBagConstraints(true, false, false));
} 
else
if(setting instanceof PathListSelection)//1
{ 
PathListSelection pls = (PathListSelection) setting;
add(new ImportClasspathDialog(pls),
                        createGridBagConstraints(true, false, false));
} 
else
{ 
throw new RuntimeException("Unknown setting type requested "
                                               + setting);
} 





} 

add(new JPanel(), createGridBagConstraintsFinal());
} 

 } 

private class SelectedLanguageListener implements ActionListener
  { 
private JTabbedPane tab;
public void actionPerformed(ActionEvent e)
        { 
JComboBox cb = (JComboBox) e.getSource();
String selected = (String) cb.getSelectedItem();
ImportInterface oldModule = getCurrentModule();
setCurrentModule(getModules().get(selected));
updateFilters((JFileChooser) dialog.getContentPane()
                          .getComponent(0), oldModule.getSuffixFilters(),
                          getCurrentModule().getSuffixFilters());
updateTabbedPane();
} 

private void updateTabbedPane()
        { 
String name = ((ModuleInterface) getCurrentModule()).getName();
if(tab.indexOfTab(name) < 0)//1
{ 
tab.add(getConfigPanelExtension(), name);
} 

} 

SelectedLanguageListener(JTabbedPane t)
        { 
tab = t;
} 

 } 

 } 


