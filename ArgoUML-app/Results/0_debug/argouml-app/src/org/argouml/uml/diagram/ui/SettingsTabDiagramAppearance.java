
//#if 996847612 
// Compilation Unit of /SettingsTabDiagramAppearance.java 
 

//#if 292615457 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -872614304 
import java.awt.BorderLayout;
//#endif 


//#if 1872434915 
import java.awt.Component;
//#endif 


//#if -1560751206 
import java.awt.Dimension;
//#endif 


//#if -1029708656 
import java.awt.event.ActionEvent;
//#endif 


//#if 1651538936 
import java.awt.event.ActionListener;
//#endif 


//#if 505687333 
import javax.swing.BoxLayout;
//#endif 


//#if 325638750 
import javax.swing.JButton;
//#endif 


//#if -692056558 
import javax.swing.JLabel;
//#endif 


//#if -577182462 
import javax.swing.JPanel;
//#endif 


//#if -914132356 
import org.argouml.application.api.Argo;
//#endif 


//#if 301882239 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -385863535 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1927509562 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 1337759205 
import org.argouml.i18n.Translator;
//#endif 


//#if 1407633407 
import org.argouml.kernel.Project;
//#endif 


//#if 987037194 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1763988452 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if 2119805180 
import org.argouml.swingext.JLinkButton;
//#endif 


//#if 1104736891 
import org.argouml.ui.ActionProjectSettings;
//#endif 


//#if -572792198 
import org.argouml.ui.ArgoJFontChooser;
//#endif 


//#if 717672813 
import org.argouml.uml.diagram.DiagramAppearance;
//#endif 


//#if 1848574271 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -306783102 
public class SettingsTabDiagramAppearance extends 
//#if -846498169 
JPanel
//#endif 

 implements 
//#if -1999702123 
GUISettingsTabInterface
//#endif 

  { 

//#if -232306063 
private JButton jbtnDiagramFont;
//#endif 


//#if 1313690704 
private String selectedDiagramFontName;
//#endif 


//#if 2058170156 
private int selectedDiagramFontSize;
//#endif 


//#if -1761698464 
private int scope;
//#endif 


//#if -961681587 
private JLabel jlblDiagramFont = null;
//#endif 


//#if -471007684 
public void handleSettingsTabRefresh()
    { 

//#if 1754713457 
if(scope == Argo.SCOPE_APPLICATION)//1
{ 

//#if 74607164 
selectedDiagramFontName = DiagramAppearance.getInstance()
                                      .getConfiguredFontName();
//#endif 


//#if 57634597 
selectedDiagramFontSize = Configuration
                                      .getInteger(DiagramAppearance.KEY_FONT_SIZE);
//#endif 

} 

//#endif 


//#if -1535818950 
if(scope == Argo.SCOPE_PROJECT)//1
{ 

//#if 1411328584 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 127032794 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if -1503621652 
selectedDiagramFontName = ps.getFontName();
//#endif 


//#if -2049318740 
selectedDiagramFontSize = ps.getFontSize();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 278543902 
public void handleSettingsTabSave()
    { 

//#if -1790228771 
if(scope == Argo.SCOPE_APPLICATION)//1
{ 

//#if 1632350957 
Configuration.setString(DiagramAppearance.KEY_FONT_NAME,
                                    selectedDiagramFontName);
//#endif 


//#if -1570270346 
Configuration.setInteger(DiagramAppearance.KEY_FONT_SIZE,
                                     selectedDiagramFontSize);
//#endif 

} 

//#endif 


//#if -120106330 
if(scope == Argo.SCOPE_PROJECT)//1
{ 

//#if 3132736 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 410513618 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if -263938061 
ps.setFontName(selectedDiagramFontName);
//#endif 


//#if -2118165025 
ps.setFontSize(selectedDiagramFontSize);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -951441445 
public void handleSettingsTabCancel()
    { 

//#if 127892526 
handleSettingsTabRefresh();
//#endif 

} 

//#endif 


//#if 461642858 
public void handleResetToDefault()
    { 

//#if 454037690 
if(scope == Argo.SCOPE_PROJECT)//1
{ 

//#if 296034792 
selectedDiagramFontName = DiagramAppearance.getInstance()
                                      .getConfiguredFontName();
//#endif 


//#if -1898779695 
selectedDiagramFontSize = Configuration
                                      .getInteger(DiagramAppearance.KEY_FONT_SIZE);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1877376737 
private JButton getJbtnDiagramFont()
    { 

//#if -1821867150 
if(jbtnDiagramFont == null)//1
{ 

//#if 924584496 
jbtnDiagramFont = new JButton(
                Translator.localize("label.diagramappearance.changefont"));
//#endif 


//#if 709397508 
jbtnDiagramFont.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ArgoJFontChooser jFontChooser = new ArgoJFontChooser(
                        ArgoFrame.getInstance(), jbtnDiagramFont,
                        selectedDiagramFontName, selectedDiagramFontSize);
                    jFontChooser.setVisible(true);

                    if (jFontChooser.isOk()) {
                        selectedDiagramFontName = jFontChooser.getResultName();
                        selectedDiagramFontSize = jFontChooser.getResultSize();
                    }
                }
            });
//#endif 

} 

//#endif 


//#if -1192646375 
return jbtnDiagramFont;
//#endif 

} 

//#endif 


//#if 1165203824 
protected static boolean getBoolean(ConfigurationKey key)
    { 

//#if -922463308 
return Configuration.getBoolean(key, false);
//#endif 

} 

//#endif 


//#if 1851662902 
public JPanel getTabPanel()
    { 

//#if -455996677 
return this;
//#endif 

} 

//#endif 


//#if 1804226715 
private void initialize()
    { 

//#if 802432185 
this.setLayout(new BorderLayout());
//#endif 


//#if -317793058 
JPanel top = new JPanel();
//#endif 


//#if -1542554120 
top.setLayout(new BorderLayout());
//#endif 


//#if -2071293699 
if(scope == Argo.SCOPE_APPLICATION)//1
{ 

//#if -746824505 
JPanel warning = new JPanel();
//#endif 


//#if 1191495244 
warning.setLayout(new BoxLayout(warning, BoxLayout.PAGE_AXIS));
//#endif 


//#if -1003625583 
JLabel warningLabel = new JLabel(
                Translator.localize("label.warning"));
//#endif 


//#if 358478022 
warningLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
//#endif 


//#if -1530856817 
warning.add(warningLabel);
//#endif 


//#if 1312665081 
JLinkButton projectSettings = new JLinkButton();
//#endif 


//#if -841331225 
projectSettings.setAction(new ActionProjectSettings());
//#endif 


//#if -1561284660 
projectSettings.setText(
                Translator.localize("button.project-settings"));
//#endif 


//#if 1965541956 
projectSettings.setIcon(null);
//#endif 


//#if 1180418706 
projectSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
//#endif 


//#if -1405100087 
warning.add(projectSettings);
//#endif 


//#if -496745765 
top.add(warning, BorderLayout.NORTH);
//#endif 

} 

//#endif 


//#if 1309365028 
JPanel settings = new JPanel();
//#endif 


//#if -1368292109 
jlblDiagramFont = new JLabel();
//#endif 


//#if 32594720 
jlblDiagramFont.setText(Translator
                                .localize("label.diagramappearance.diagramfont"));
//#endif 


//#if 908216355 
settings.add(getJbtnDiagramFont());
//#endif 


//#if 633714258 
settings.add(jlblDiagramFont);
//#endif 


//#if 2142267474 
top.add(settings, BorderLayout.CENTER);
//#endif 


//#if 263733265 
this.add(top, BorderLayout.NORTH);
//#endif 


//#if 1815091469 
this.setSize(new Dimension(296, 169));
//#endif 

} 

//#endif 


//#if -2147044138 
protected JLabel createLabel(String key)
    { 

//#if -40684540 
return new JLabel(Translator.localize(key));
//#endif 

} 

//#endif 


//#if -82529995 
public void setVisible(boolean arg0)
    { 

//#if 2082358230 
super.setVisible(arg0);
//#endif 


//#if 148974098 
if(arg0)//1
{ 

//#if 2028224239 
handleSettingsTabRefresh();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1591051098 
public String getTabKey()
    { 

//#if 1012244117 
return "tab.diagramappearance";
//#endif 

} 

//#endif 


//#if -962589015 
protected JButton createCheckBox(String key)
    { 

//#if 1650345195 
JButton j = new JButton(Translator.localize(key));
//#endif 


//#if -1446756760 
return j;
//#endif 

} 

//#endif 


//#if 956295066 
public SettingsTabDiagramAppearance(int settingsScope)
    { 

//#if -1426472842 
super();
//#endif 


//#if -1012433142 
scope = settingsScope;
//#endif 


//#if -2081534541 
initialize();
//#endif 

} 

//#endif 


//#if -205676038 
protected JButton createButton(String key)
    { 

//#if -158239633 
return new JButton(Translator.localize(key));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

