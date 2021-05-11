package org.argouml.application.api;
import javax.swing.JPanel;
public interface GUISettingsTabInterface  { 
JPanel getTabPanel();String getTabKey();void handleSettingsTabRefresh();void handleSettingsTabCancel();void handleResetToDefault();void handleSettingsTabSave();
 } 
