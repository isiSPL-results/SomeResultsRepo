
//#if 1790080736 
// Compilation Unit of /SettingsTypes.java 
 

//#if 660979826 
package org.argouml.uml.reveng;
//#endif 


//#if 1470623753 
import java.util.List;
//#endif 


//#if -1286023883 
public interface SettingsTypes  { 

//#if -124991099 
interface Setting  { 

//#if -8580427 
String getLabel();
//#endif 

 } 

//#endif 


//#if -1965852944 
interface UniqueSelection extends 
//#if 1032248856 
Setting
//#endif 

  { 

//#if 801226185 
public int UNDEFINED_SELECTION = -1;
//#endif 


//#if 9749502 
boolean setSelection(int selection);
//#endif 


//#if 936806894 
int getSelection();
//#endif 


//#if 508975408 
List<String> getOptions();
//#endif 


//#if 685001995 
int getDefaultSelection();
//#endif 

 } 

//#endif 


//#if 669392734 
interface PathListSelection extends 
//#if 1418317959 
Setting2
//#endif 

  { 

//#if 1054241883 
void setPathList(List<String> pathList);
//#endif 


//#if 1238517734 
List<String> getPathList();
//#endif 


//#if -788820925 
List<String> getDefaultPathList();
//#endif 

 } 

//#endif 


//#if -1750874532 
interface PathSelection extends 
//#if -1423280753 
Setting2
//#endif 

  { 

//#if -1357585713 
String getDefaultPath();
//#endif 


//#if -1091849314 
String getPath();
//#endif 


//#if -1762512943 
void setPath(String path);
//#endif 

 } 

//#endif 


//#if 1722970215 
interface UserString extends 
//#if -1327099706 
Setting
//#endif 

  { 

//#if -161401320 
String getDefaultString();
//#endif 


//#if 559203252 
void setUserString(String userString);
//#endif 


//#if -1059625992 
String getUserString();
//#endif 

 } 

//#endif 


//#if 875258543 
interface BooleanSelection extends 
//#if 1693140219 
Setting
//#endif 

  { 

//#if -1847981292 
boolean getDefaultValue();
//#endif 


//#if -468848615 
boolean isSelected();
//#endif 


//#if 719320474 
void setSelected(boolean selected);
//#endif 

 } 

//#endif 


//#if -811899070 
interface UniqueSelection2 extends 
//#if -2054867553 
UniqueSelection
//#endif 

, 
//#if 1506885502 
Setting2
//#endif 

  { 
 } 

//#endif 


//#if 1872469163 
interface UserString2 extends 
//#if 635717557 
UserString
//#endif 

, 
//#if 432519707 
Setting2
//#endif 

  { 
 } 

//#endif 


//#if 420243277 
interface Setting2 extends 
//#if 1129468957 
Setting
//#endif 

  { 

//#if -1343612181 
String getDescription();
//#endif 

 } 

//#endif 


//#if 1363211107 
interface BooleanSelection2 extends 
//#if 1542047849 
BooleanSelection
//#endif 

, 
//#if -331274489 
Setting2
//#endif 

  { 
 } 

//#endif 

 } 

//#endif 


//#endif 

