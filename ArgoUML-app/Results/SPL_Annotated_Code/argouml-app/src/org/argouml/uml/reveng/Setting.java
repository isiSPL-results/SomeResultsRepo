// Compilation Unit of /Setting.java 
 
package org.argouml.uml.reveng;
import java.util.Collections;
import java.util.List;
public class Setting implements SettingsTypes.Setting2
  { 
private String label;
private String description;
public String getDescription()
    { 
return description;
} 

public Setting(String labelText, String descriptionText)
    { 
this(labelText);
description = descriptionText;
} 

public Setting(String labelText)
    { 
super();
label = labelText;
} 

public final String getLabel()
    { 
return label;
} 

public static class PathSelection extends Setting
 implements SettingsTypes.PathSelection
  { 
private String path;
private String defaultPath;
public String getDefaultPath()
        { 
return defaultPath;
} 

public PathSelection(String labelText, String descriptionText,
                             String defaultValue)
        { 
super(labelText, descriptionText);
defaultPath = defaultValue;
path = defaultValue;
} 

public void setPath(String newPath)
        { 
path = newPath;
} 

public String getPath()
        { 
return path;
} 

 } 

public static class PathListSelection extends Setting
 implements SettingsTypes.PathListSelection
  { 
private List<String> defaultPathList;
private List<String> pathList;
public void setPathList(List<String> newPathList)
        { 
pathList = newPathList;
} 

public List<String> getPathList()
        { 
return pathList;
} 

public List<String> getDefaultPathList()
        { 
return defaultPathList;
} 

public PathListSelection(String labelText, String descriptionText,
                                 List<String> defaultList)
        { 
super(labelText, descriptionText);
defaultPathList = defaultList;
pathList = defaultList;
} 

 } 

public static class BooleanSelection extends Setting
 implements SettingsTypes.BooleanSelection2
  { 
private boolean defaultValue;
private boolean value;
public final boolean isSelected()
        { 
return value;
} 

public BooleanSelection(String labelText, boolean initialValue)
        { 
super(labelText);
this.defaultValue = initialValue;
value = initialValue;
} 

public final void setSelected(boolean selected)
        { 
this.value = selected;
} 

public final boolean getDefaultValue()
        { 
return defaultValue;
} 

 } 

public static class UniqueSelection extends Setting
 implements SettingsTypes.UniqueSelection2
  { 
private List<String> options;
private int defaultSelection = UNDEFINED_SELECTION;
private int selection = UNDEFINED_SELECTION;
public boolean setSelection(int sel)
        { 
if(isOption(sel))//1
{ 
selection = sel;
return true;
} 
else
{ 
return false;
} 

} 

private boolean isOption(int opt)
        { 
if(options == null)//1
{ 
return false;
} 

return opt >= 0 && opt < options.size() ? true : false;
} 

public UniqueSelection(String label, List<String> variants,
                               int defaultVariant)
        { 
super(label);
options = variants;
if(isOption(defaultVariant))//1
{ 
defaultSelection = defaultVariant;
} 

} 

public List<String> getOptions()
        { 
return Collections.unmodifiableList(options);
} 

public int getSelection()
        { 
if(selection == UNDEFINED_SELECTION)//1
{ 
return defaultSelection;
} 
else
{ 
return selection;
} 

} 

public int getDefaultSelection()
        { 
return defaultSelection;
} 

 } 

 } 


