
//#if 299626868 
// Compilation Unit of /ArgoJFontChooser.java 
 

//#if -319268458 
package org.argouml.ui;
//#endif 


//#if 1182777178 
import java.awt.Dimension;
//#endif 


//#if 1741321959 
import java.awt.Font;
//#endif 


//#if -1851216205 
import java.awt.Frame;
//#endif 


//#if 247391288 
import java.awt.GraphicsEnvironment;
//#endif 


//#if 385288866 
import java.awt.GridBagConstraints;
//#endif 


//#if 1154026068 
import java.awt.GridBagLayout;
//#endif 


//#if 1011268192 
import java.awt.Insets;
//#endif 


//#if -2057367472 
import java.awt.event.ActionEvent;
//#endif 


//#if 1194637368 
import java.awt.event.ActionListener;
//#endif 


//#if 68339026 
import javax.swing.DefaultListModel;
//#endif 


//#if -524327266 
import javax.swing.JButton;
//#endif 


//#if -242671767 
import javax.swing.JComponent;
//#endif 


//#if 889344840 
import javax.swing.JDialog;
//#endif 


//#if 2051471826 
import javax.swing.JLabel;
//#endif 


//#if 482073586 
import javax.swing.JList;
//#endif 


//#if -2128621374 
import javax.swing.JPanel;
//#endif 


//#if -190881829 
import javax.swing.JScrollPane;
//#endif 


//#if -2128792964 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if -633383284 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if -454893019 
import org.argouml.i18n.Translator;
//#endif 


//#if 1893870360 
public class ArgoJFontChooser extends 
//#if -1207912107 
JDialog
//#endif 

  { 

//#if 842933486 
private JPanel jContentPane = null;
//#endif 


//#if -1575430242 
private JList jlstFamilies = null;
//#endif 


//#if -829093372 
private JList jlstSizes = null;
//#endif 


//#if 265194517 
private JLabel jlblFamilies = null;
//#endif 


//#if 1266056148 
private JLabel jlblSize = null;
//#endif 


//#if 462486179 
private JLabel jlblPreview = null;
//#endif 


//#if 1878759899 
private JButton jbtnOk = null;
//#endif 


//#if -584103943 
private JButton jbtnCancel = null;
//#endif 


//#if 1951144212 
private int resultSize;
//#endif 


//#if -1100427204 
private String resultName;
//#endif 


//#if 1999270029 
private boolean isOk = false;
//#endif 


//#if -153876772 
private JList getJlstSizes()
    { 

//#if 1322541405 
if(jlstSizes == null)//1
{ 

//#if 1536262756 
jlstSizes = new JList(new Integer[] {Integer.valueOf(8),
                                                 Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11),
                                                 Integer.valueOf(12), Integer.valueOf(14), Integer.valueOf(16),
                                                 Integer.valueOf(18), Integer.valueOf(20), Integer.valueOf(22),
                                                 Integer.valueOf(24), Integer.valueOf(26), Integer.valueOf(28),
                                                 Integer.valueOf(36), Integer.valueOf(48), Integer.valueOf(72)
                                                });
//#endif 


//#if -2143325493 
jlstSizes.setSelectedValue(resultSize, true);
//#endif 


//#if 994900430 
jlstSizes.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (jlstSizes.getSelectedValue() != null) {
                        resultSize = (Integer) jlstSizes
                                     .getSelectedValue();
                        updatePreview();
                    }
                }
            });
//#endif 

} 

//#endif 


//#if -1935722010 
return jlstSizes;
//#endif 

} 

//#endif 


//#if 1392675400 
public String getResultName()
    { 

//#if 322996035 
return resultName;
//#endif 

} 

//#endif 


//#if 651473178 
private JList getJlstFamilies()
    { 

//#if -346598371 
if(jlstFamilies == null)//1
{ 

//#if -14147250 
jlstFamilies = new JList();
//#endif 


//#if 1989661809 
jlstFamilies.setModel(new DefaultListModel());
//#endif 


//#if -462703613 
String[] fontNames = GraphicsEnvironment
                                 .getLocalGraphicsEnvironment()
                                 .getAvailableFontFamilyNames();
//#endif 


//#if -1114717019 
for (String fontName : fontNames) //1
{ 

//#if 258012372 
((DefaultListModel) jlstFamilies.getModel())
                .addElement(fontName);
//#endif 

} 

//#endif 


//#if -1349316059 
jlstFamilies.setSelectedValue(resultName, true);
//#endif 


//#if -972297003 
jlstFamilies.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if (jlstFamilies.getSelectedValue() != null) {
                        resultName = (String) jlstFamilies
                                     .getSelectedValue();
                        updatePreview();
                    }
                }
            });
//#endif 

} 

//#endif 


//#if -774240156 
return jlstFamilies;
//#endif 

} 

//#endif 


//#if 882239785 
public boolean isOk()
    { 

//#if 1874084353 
return isOk;
//#endif 

} 

//#endif 


//#if -2047274035 
private JButton getJbtnCancel()
    { 

//#if 64341856 
if(jbtnCancel == null)//1
{ 

//#if -390410596 
jbtnCancel = new JButton();
//#endif 


//#if -1782280540 
jbtnCancel.setText(Translator.localize("button.cancel"));
//#endif 


//#if 1480214507 
jbtnCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    isOk = false;
                    dispose();
                    setVisible(false);
                }
            });
//#endif 

} 

//#endif 


//#if 1168921721 
return jbtnCancel;
//#endif 

} 

//#endif 


//#if -363464884 
public int getResultSize()
    { 

//#if -2018801244 
return resultSize;
//#endif 

} 

//#endif 


//#if -614794215 
public ArgoJFontChooser(Frame owner, JComponent parent, String name,
                            int size)
    { 

//#if -1346995698 
super(owner, true);
//#endif 


//#if 1571388014 
setLocationRelativeTo(parent);
//#endif 


//#if -898303389 
this.resultName = name;
//#endif 


//#if 2025928867 
this.resultSize = size;
//#endif 


//#if -742370398 
initialize();
//#endif 

} 

//#endif 


//#if 2002815179 
private void initialize()
    { 

//#if 1003284102 
this.setSize(299, 400);
//#endif 


//#if 1282120069 
this.setTitle(Translator.localize("dialog.fontchooser"));
//#endif 


//#if -111073352 
this.setContentPane(getJContentPane());
//#endif 


//#if 1834631850 
updatePreview();
//#endif 

} 

//#endif 


//#if 1020186862 
private JPanel getJContentPane()
    { 

//#if 1776218697 
if(jContentPane == null)//1
{ 

//#if -2129846696 
GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
//#endif 


//#if 1027013025 
gridBagConstraints8.gridx = 4;
//#endif 


//#if -974237734 
gridBagConstraints8.anchor = GridBagConstraints.NORTHEAST;
//#endif 


//#if 1697160814 
gridBagConstraints8.insets = new Insets(0, 0, 5, 5);
//#endif 


//#if 1809447701 
gridBagConstraints8.weightx = 0.0;
//#endif 


//#if -1786374295 
gridBagConstraints8.ipadx = 0;
//#endif 


//#if 1027042847 
gridBagConstraints8.gridy = 5;
//#endif 


//#if 2134100793 
GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
//#endif 


//#if 1223526499 
gridBagConstraints7.gridx = 3;
//#endif 


//#if 397581971 
gridBagConstraints7.fill = GridBagConstraints.NONE;
//#endif 


//#if -1979931179 
gridBagConstraints7.weightx = 1.0;
//#endif 


//#if 1687925563 
gridBagConstraints7.anchor = GridBagConstraints.NORTHEAST;
//#endif 


//#if 1951897359 
gridBagConstraints7.insets = new Insets(0, 0, 5, 5);
//#endif 


//#if -1951331819 
gridBagConstraints7.weighty = 0.0;
//#endif 


//#if -1828813545 
gridBagConstraints7.gridwidth = 1;
//#endif 


//#if -1589860790 
gridBagConstraints7.ipadx = 0;
//#endif 


//#if 1223556352 
gridBagConstraints7.gridy = 5;
//#endif 


//#if 2103080986 
GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
//#endif 


//#if 1420039911 
gridBagConstraints6.gridx = 0;
//#endif 


//#if -1323254796 
gridBagConstraints6.gridwidth = 5;
//#endif 


//#if -710087770 
gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if -1474372554 
gridBagConstraints6.weightx = 1.0;
//#endif 


//#if 1901847290 
gridBagConstraints6.insets = new Insets(5, 5, 5, 5);
//#endif 


//#if 71864106 
gridBagConstraints6.anchor = GridBagConstraints.NORTHWEST;
//#endif 


//#if 1420069826 
gridBagConstraints6.gridy = 4;
//#endif 


//#if 239997878 
jlblPreview = new JLabel();
//#endif 


//#if -524104183 
jlblPreview.setText(Translator
                                .localize("label.diagramappearance.preview"));
//#endif 


//#if -302207870 
jlblPreview.setPreferredSize(new Dimension(52, 50));
//#endif 


//#if 2072061179 
GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
//#endif 


//#if 1616553540 
gridBagConstraints5.gridx = 4;
//#endif 


//#if -1560939893 
gridBagConstraints5.anchor = GridBagConstraints.NORTHWEST;
//#endif 


//#if -2143005871 
gridBagConstraints5.insets = new Insets(5, 5, 0, 0);
//#endif 


//#if 1616583207 
gridBagConstraints5.gridy = 0;
//#endif 


//#if 867060635 
jlblSize = new JLabel();
//#endif 


//#if 1050745916 
jlblSize.setText(Translator
                             .localize("label.diagramappearance.fontsize"));
//#endif 


//#if 2041041372 
GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
//#endif 


//#if 1813066921 
gridBagConstraints4.gridx = 0;
//#endif 


//#if 1101223404 
gridBagConstraints4.anchor = GridBagConstraints.NORTHWEST;
//#endif 


//#if -1888269326 
gridBagConstraints4.insets = new Insets(5, 5, 0, 0);
//#endif 


//#if 1813096712 
gridBagConstraints4.gridy = 0;
//#endif 


//#if 1207636666 
jlblFamilies = new JLabel();
//#endif 


//#if -397392742 
jlblFamilies.setText(Translator
                                 .localize("label.diagramappearance.fontlist"));
//#endif 


//#if 1947981951 
GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
//#endif 


//#if -1718294044 
gridBagConstraints1.fill = GridBagConstraints.BOTH;
//#endif 


//#if -1892330007 
gridBagConstraints1.gridy = 2;
//#endif 


//#if 1053390780 
gridBagConstraints1.weightx = 0.0;
//#endif 


//#if 1082049722 
gridBagConstraints1.weighty = 1.0;
//#endif 


//#if -1266605995 
gridBagConstraints1.insets = new Insets(5, 0, 0, 5);
//#endif 


//#if 497778703 
gridBagConstraints1.anchor = GridBagConstraints.NORTHWEST;
//#endif 


//#if 1204538236 
gridBagConstraints1.gridwidth = 2;
//#endif 


//#if -1892359736 
gridBagConstraints1.gridx = 4;
//#endif 


//#if -910424170 
GridBagConstraints gridBagConstraints = new GridBagConstraints();
//#endif 


//#if 1509801477 
gridBagConstraints.fill = GridBagConstraints.BOTH;
//#endif 


//#if 1840451368 
gridBagConstraints.gridy = 2;
//#endif 


//#if -918884902 
gridBagConstraints.weightx = 1.0;
//#endif 


//#if -890255751 
gridBagConstraints.weighty = 1.0;
//#endif 


//#if -1815097319 
gridBagConstraints.insets = new Insets(5, 5, 0, 5);
//#endif 


//#if -767767175 
gridBagConstraints.gridwidth = 4;
//#endif 


//#if 406779525 
gridBagConstraints.gridheight = 1;
//#endif 


//#if 1970468046 
gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
//#endif 


//#if 1840421515 
gridBagConstraints.gridx = 0;
//#endif 


//#if -2102437951 
jContentPane = new JPanel();
//#endif 


//#if -636514707 
jContentPane.setLayout(new GridBagLayout());
//#endif 


//#if -1752619760 
JScrollPane jscpFamilies = new JScrollPane();
//#endif 


//#if -668659966 
jscpFamilies.setViewportView(getJlstFamilies());
//#endif 


//#if -142419968 
JScrollPane jscpSizes = new JScrollPane();
//#endif 


//#if 1149615966 
jscpSizes.setViewportView(getJlstSizes());
//#endif 


//#if 486460833 
jContentPane.add(jscpFamilies, gridBagConstraints);
//#endif 


//#if -19021722 
jContentPane.add(jscpSizes, gridBagConstraints1);
//#endif 


//#if 908167405 
jContentPane.add(jlblFamilies, gridBagConstraints4);
//#endif 


//#if -1613100307 
jContentPane.add(jlblSize, gridBagConstraints5);
//#endif 


//#if -789388341 
jContentPane.add(jlblPreview, gridBagConstraints6);
//#endif 


//#if -445896747 
jContentPane.add(getJbtnOk(), gridBagConstraints7);
//#endif 


//#if 1779737268 
jContentPane.add(getJbtnCancel(), gridBagConstraints8);
//#endif 

} 

//#endif 


//#if -307303444 
return jContentPane;
//#endif 

} 

//#endif 


//#if 978145670 
private void updatePreview()
    { 

//#if -466035960 
int style = 0;
//#endif 


//#if 149329475 
Font previewFont = new Font(resultName, style, resultSize);
//#endif 


//#if -1676728286 
jlblPreview.setFont(previewFont);
//#endif 

} 

//#endif 


//#if 2096421807 
private JButton getJbtnOk()
    { 

//#if 1640496246 
if(jbtnOk == null)//1
{ 

//#if 1869942181 
jbtnOk = new JButton();
//#endif 


//#if -1491306723 
jbtnOk.setText(Translator.localize("button.ok"));
//#endif 


//#if 609062469 
jbtnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    isOk = true;
                    dispose();
                    setVisible(false);
                }
            });
//#endif 

} 

//#endif 


//#if 1067870475 
return jbtnOk;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

