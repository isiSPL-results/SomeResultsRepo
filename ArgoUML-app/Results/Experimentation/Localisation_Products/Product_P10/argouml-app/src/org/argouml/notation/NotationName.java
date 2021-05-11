package org.argouml.notation;
import javax.swing.Icon;
public interface NotationName  { 
String getTitle();Icon getIcon();String getName();String getVersion();String getConfigurationValue();boolean sameNotationAs(NotationName notationName);String toString();
 } 
