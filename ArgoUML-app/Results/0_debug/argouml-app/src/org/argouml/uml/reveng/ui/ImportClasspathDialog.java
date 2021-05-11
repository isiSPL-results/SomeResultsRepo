
//#if 1839017824 
// Compilation Unit of /ImportClasspathDialog.java 
 

//#if -115406560 
package org.argouml.uml.reveng.ui;
//#endif 


//#if -288572801 
import java.awt.BorderLayout;
//#endif 


//#if -2047413324 
import java.awt.Frame;
//#endif 


//#if 1307084965 
import java.awt.GridLayout;
//#endif 


//#if -1276060719 
import java.awt.event.ActionEvent;
//#endif 


//#if -1618628329 
import java.awt.event.ActionListener;
//#endif 


//#if 841611021 
import java.io.File;
//#endif 


//#if 1619445146 
import java.util.ArrayList;
//#endif 


//#if 217307271 
import java.util.List;
//#endif 


//#if -715148141 
import javax.swing.DefaultListModel;
//#endif 


//#if 759765565 
import javax.swing.JButton;
//#endif 


//#if -1759259256 
import javax.swing.JFileChooser;
//#endif 


//#if 1677252179 
import javax.swing.JLabel;
//#endif 


//#if 1024191313 
import javax.swing.JList;
//#endif 


//#if 1792126275 
import javax.swing.JPanel;
//#endif 


//#if -1210569734 
import javax.swing.JScrollPane;
//#endif 


//#if -2004187452 
import org.argouml.i18n.Translator;
//#endif 


//#if 4792304 
import org.argouml.uml.reveng.SettingsTypes.PathListSelection;
//#endif 


//#if -1993008386 
import org.tigris.gef.base.Globals;
//#endif 


//#if -288043806 
public class ImportClasspathDialog extends 
//#if -1213330514 
JPanel
//#endif 

  { 

//#if -578988154 
private JList paths;
//#endif 


//#if 1072430311 
private DefaultListModel pathsModel;
//#endif 


//#if -2103996363 
private JButton addButton;
//#endif 


//#if 1656175160 
private JButton removeButton;
//#endif 


//#if 192935300 
private JFileChooser chooser;
//#endif 


//#if 206584805 
private PathListSelection setting;
//#endif 


//#if -29958048 
public ImportClasspathDialog(PathListSelection pathListSetting)
    { 

//#if 1003758478 
super();
//#endif 


//#if 763342058 
setting = pathListSetting;
//#endif 


//#if 1515322850 
setToolTipText(setting.getDescription());
//#endif 


//#if 823925028 
setLayout(new BorderLayout(0, 0));
//#endif 


//#if -92865873 
JLabel label = new JLabel(setting.getLabel());
//#endif 


//#if 1762201197 
add(label, BorderLayout.NORTH);
//#endif 


//#if -713255421 
pathsModel = new DefaultListModel();
//#endif 


//#if 374158283 
for (String path : setting.getDefaultPathList()) //1
{ 

//#if 408643696 
pathsModel.addElement(path);
//#endif 

} 

//#endif 


//#if -559337361 
paths = new JList(pathsModel);
//#endif 


//#if 2001017523 
paths.setVisibleRowCount(5);
//#endif 


//#if -296787934 
paths.setToolTipText(setting.getDescription());
//#endif 


//#if -1514584756 
JScrollPane listScroller = new JScrollPane(paths);
//#endif 


//#if 502312993 
add(listScroller, BorderLayout.CENTER);
//#endif 


//#if 1556831768 
JPanel controlsPanel = new JPanel();
//#endif 


//#if -2142527389 
controlsPanel.setLayout(new GridLayout(0, 2, 50, 0));
//#endif 


//#if -1155269982 
addButton = new JButton(Translator.localize("button.add"));
//#endif 


//#if -1650916753 
controlsPanel.add(addButton);
//#endif 


//#if -1352959345 
addButton.addActionListener(new AddListener());
//#endif 


//#if 546883478 
removeButton = new JButton(Translator.localize("button.remove"));
//#endif 


//#if 1991943550 
controlsPanel.add(removeButton);
//#endif 


//#if -1174320731 
removeButton.addActionListener(new RemoveListener());
//#endif 


//#if 1174024571 
add(controlsPanel, BorderLayout.SOUTH);
//#endif 

} 

//#endif 


//#if 1638161552 
private void updatePathList()
    { 

//#if -509100800 
List<String> pathList = new ArrayList<String>();
//#endif 


//#if -478775774 
for (int i = 0; i < pathsModel.size(); i++) //1
{ 

//#if 934691059 
String path = (String) pathsModel.getElementAt(i);
//#endif 


//#if 1848404830 
pathList.add(path);
//#endif 

} 

//#endif 


//#if -2054414001 
setting.setPathList(pathList);
//#endif 

} 

//#endif 


//#if 315975068 
class RemoveListener implements 
//#if 238627004 
ActionListener
//#endif 

  { 

//#if -530869989 
public void actionPerformed(ActionEvent e)
        { 

//#if -1482260188 
int index = paths.getSelectedIndex();
//#endif 


//#if -1245928952 
if(index < 0)//1
{ 

//#if 1948499037 
return;
//#endif 

} 

//#endif 


//#if -1355789330 
pathsModel.remove(index);
//#endif 


//#if -1031406551 
updatePathList();
//#endif 


//#if -1367206172 
int size = pathsModel.getSize();
//#endif 


//#if 1338188465 
if(size == 0)//1
{ 

//#if -288252322 
removeButton.setEnabled(false);
//#endif 

} 
else
{ 

//#if -2113685429 
if(index == pathsModel.getSize())//1
{ 

//#if -1932163545 
index--;
//#endif 

} 

//#endif 


//#if -1857666936 
paths.setSelectedIndex(index);
//#endif 


//#if 1927949159 
paths.ensureIndexIsVisible(index);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 367718065 
class AddListener implements 
//#if 1726556463 
ActionListener
//#endif 

  { 

//#if -2108954616 
public void actionPerformed(ActionEvent e)
        { 

//#if 631997042 
if(chooser == null)//1
{ 

//#if 551598315 
chooser = new JFileChooser(Globals.getLastDirectory());
//#endif 


//#if 518068067 
if(chooser == null)//1
{ 

//#if -40522029 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if 140900756 
chooser.setFileSelectionMode(
                    JFileChooser.FILES_AND_DIRECTORIES);
//#endif 


//#if 1316576389 
chooser.setMultiSelectionEnabled(true);
//#endif 


//#if -1646583419 
chooser.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e1) {
                        if (e1.getActionCommand().equals(
                                    JFileChooser.APPROVE_SELECTION)) {
                            File[] files = chooser.getSelectedFiles();
                            for (File theFile : files) {
                                if (theFile != null) {
                                    pathsModel.addElement(theFile.toString());
                                }
                            }
                            updatePathList();
                        } else if (e1.getActionCommand().equals(
                                       JFileChooser.CANCEL_SELECTION)) {
                            // Just quit
                        }

                    }
                });
//#endif 

} 

//#endif 


//#if -618912013 
chooser.showOpenDialog(new Frame());
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

