
//#if -1408734094 
// Compilation Unit of /Setting.java 
 

//#if 1816734542 
package org.argouml.uml.reveng;
//#endif 


//#if -1265821450 
import java.util.Collections;
//#endif 


//#if -1113350739 
import java.util.List;
//#endif 


//#if -1316459412 
public class Setting implements 
//#if -881030869 
SettingsTypes.Setting2
//#endif 

  { 

//#if 718288298 
private String label;
//#endif 


//#if 1991088994 
private String description;
//#endif 


//#if -1042873966 
public String getDescription()
    { 

//#if -1060449796 
return description;
//#endif 

} 

//#endif 


//#if 1875285311 
public Setting(String labelText, String descriptionText)
    { 

//#if 1592199092 
this(labelText);
//#endif 


//#if 1132557150 
description = descriptionText;
//#endif 

} 

//#endif 


//#if -1474429045 
public Setting(String labelText)
    { 

//#if 416565555 
super();
//#endif 


//#if -503823913 
label = labelText;
//#endif 

} 

//#endif 


//#if -11215156 
public final String getLabel()
    { 

//#if -1064527308 
return label;
//#endif 

} 

//#endif 


//#if 2056004055 
public static class PathSelection extends 
//#if -1892210795 
Setting
//#endif 

 implements 
//#if 1491050932 
SettingsTypes.PathSelection
//#endif 

  { 

//#if 94651197 
private String path;
//#endif 


//#if -79011186 
private String defaultPath;
//#endif 


//#if -1906797210 
public String getDefaultPath()
        { 

//#if 761225439 
return defaultPath;
//#endif 

} 

//#endif 


//#if -2114502733 
public PathSelection(String labelText, String descriptionText,
                             String defaultValue)
        { 

//#if 71075469 
super(labelText, descriptionText);
//#endif 


//#if 898369054 
defaultPath = defaultValue;
//#endif 


//#if 1784570601 
path = defaultValue;
//#endif 

} 

//#endif 


//#if 598941614 
public void setPath(String newPath)
        { 

//#if -809917433 
path = newPath;
//#endif 

} 

//#endif 


//#if -1750881049 
public String getPath()
        { 

//#if 1326264522 
return path;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1609450841 
public static class PathListSelection extends 
//#if 1740420796 
Setting
//#endif 

 implements 
//#if -562505507 
SettingsTypes.PathListSelection
//#endif 

  { 

//#if 185614773 
private List<String> defaultPathList;
//#endif 


//#if 2123659066 
private List<String> pathList;
//#endif 


//#if 133139689 
public void setPathList(List<String> newPathList)
        { 

//#if 1101656363 
pathList = newPathList;
//#endif 

} 

//#endif 


//#if -1318105074 
public List<String> getPathList()
        { 

//#if 1306733552 
return pathList;
//#endif 

} 

//#endif 


//#if 1398048539 
public List<String> getDefaultPathList()
        { 

//#if 1523615424 
return defaultPathList;
//#endif 

} 

//#endif 


//#if 283238789 
public PathListSelection(String labelText, String descriptionText,
                                 List<String> defaultList)
        { 

//#if -2073663225 
super(labelText, descriptionText);
//#endif 


//#if 1630721265 
defaultPathList = defaultList;
//#endif 


//#if -139423622 
pathList = defaultList;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1311174316 
public static class BooleanSelection extends 
//#if -1204856361 
Setting
//#endif 

 implements 
//#if 1415933693 
SettingsTypes.BooleanSelection2
//#endif 

  { 

//#if -1696522355 
private boolean defaultValue;
//#endif 


//#if -387176920 
private boolean value;
//#endif 


//#if 1870921850 
public final boolean isSelected()
        { 

//#if 115840647 
return value;
//#endif 

} 

//#endif 


//#if -1067177806 
public BooleanSelection(String labelText, boolean initialValue)
        { 

//#if 953272351 
super(labelText);
//#endif 


//#if 927018122 
this.defaultValue = initialValue;
//#endif 


//#if -492533573 
value = initialValue;
//#endif 

} 

//#endif 


//#if -523416871 
public final void setSelected(boolean selected)
        { 

//#if -791843935 
this.value = selected;
//#endif 

} 

//#endif 


//#if -1288433837 
public final boolean getDefaultValue()
        { 

//#if 2141013277 
return defaultValue;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1427300267 
public static class UniqueSelection extends 
//#if 1571831656 
Setting
//#endif 

 implements 
//#if 1991997367 
SettingsTypes.UniqueSelection2
//#endif 

  { 

//#if -588249401 
private List<String> options;
//#endif 


//#if -231435204 
private int defaultSelection = UNDEFINED_SELECTION;
//#endif 


//#if 1800290499 
private int selection = UNDEFINED_SELECTION;
//#endif 


//#if 1317237495 
public boolean setSelection(int sel)
        { 

//#if -1537693271 
if(isOption(sel))//1
{ 

//#if -1037653726 
selection = sel;
//#endif 


//#if -1115241235 
return true;
//#endif 

} 
else
{ 

//#if -2019247241 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1482684777 
private boolean isOption(int opt)
        { 

//#if -266104425 
if(options == null)//1
{ 

//#if 1151517079 
return false;
//#endif 

} 

//#endif 


//#if -1108742333 
return opt >= 0 && opt < options.size() ? true : false;
//#endif 

} 

//#endif 


//#if 1034092030 
public UniqueSelection(String label, List<String> variants,
                               int defaultVariant)
        { 

//#if 184336080 
super(label);
//#endif 


//#if -1678328891 
options = variants;
//#endif 


//#if 1571003654 
if(isOption(defaultVariant))//1
{ 

//#if -283423434 
defaultSelection = defaultVariant;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1716884297 
public List<String> getOptions()
        { 

//#if -1802762641 
return Collections.unmodifiableList(options);
//#endif 

} 

//#endif 


//#if -86013451 
public int getSelection()
        { 

//#if -240972275 
if(selection == UNDEFINED_SELECTION)//1
{ 

//#if -1249265790 
return defaultSelection;
//#endif 

} 
else
{ 

//#if -1275796306 
return selection;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1892910884 
public int getDefaultSelection()
        { 

//#if 1435757052 
return defaultSelection;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

