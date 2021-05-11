package org.argouml.uml.reveng;
import java.util.List;
public interface SettingsTypes  { 
interface Setting  { 
String getLabel();
 } 
interface UniqueSelection extends Setting
  { 
public int UNDEFINED_SELECTION = -1;
boolean setSelection(int selection);int getSelection();List<String> getOptions();int getDefaultSelection();
 } 
interface PathListSelection extends Setting2
  { 
void setPathList(List<String> pathList);List<String> getPathList();List<String> getDefaultPathList();
 } 
interface PathSelection extends Setting2
  { 
String getDefaultPath();String getPath();void setPath(String path);
 } 
interface UserString extends Setting
  { 
String getDefaultString();void setUserString(String userString);String getUserString();
 } 
interface BooleanSelection extends Setting
  { 
boolean getDefaultValue();boolean isSelected();void setSelected(boolean selected);
 } 
interface UniqueSelection2 extends UniqueSelection
,Setting2
  { 

 } 
interface UserString2 extends UserString
,Setting2
  { 

 } 
interface Setting2 extends Setting
  { 
String getDescription();
 } 
interface BooleanSelection2 extends BooleanSelection
,Setting2
  { 

 } 

 } 
