
//#if -1755163302 
// Compilation Unit of /LastRecentlyUsedMenuList.java 
 

//#if 1193582834 
package org.argouml.ui.cmd;
//#endif 


//#if 1902569209 
import javax.swing.JMenu;
//#endif 


//#if 104091430 
import javax.swing.JMenuItem;
//#endif 


//#if 1045737876 
import org.argouml.application.api.Argo;
//#endif 


//#if -1103739271 
import org.argouml.configuration.Configuration;
//#endif 


//#if 773573342 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if -614994311 
import org.argouml.uml.ui.ActionReopenProject;
//#endif 


//#if -1991285468 
import java.io.File;
//#endif 


//#if -1725036211 
public class LastRecentlyUsedMenuList  { 

//#if 1474679875 
private static final int MAX_COUNT_DEFAULT = 4;
//#endif 


//#if 1748172005 
private JMenu fileMenu;
//#endif 


//#if 1505831674 
private int lruCount;
//#endif 


//#if 2096743062 
private int maxCount = MAX_COUNT_DEFAULT;
//#endif 


//#if 486817996 
private int menuIndex = -1;
//#endif 


//#if 1951390826 
private JMenuItem[] menuItems;
//#endif 


//#if -1693524118 
private ConfigurationKey[] confKeys;
//#endif 


//#if -2051605067 
private JMenuItem addEventHandler(String filename, int addAt)
    { 

//#if -1212450567 
File f = new File(filename);
//#endif 


//#if -771780955 
JMenuItem item =
            fileMenu.insert(new ActionReopenProject(filename), addAt);
//#endif 


//#if -728715373 
String entryName = f.getName();
//#endif 


//#if -1707116928 
if(entryName.length() > 40)//1
{ 

//#if 1181105788 
entryName = entryName.substring(0, 40) + "...";
//#endif 

} 

//#endif 


//#if 1448515420 
item.setText(entryName);
//#endif 


//#if -442692935 
item.setToolTipText(filename);
//#endif 


//#if -680356585 
return item;
//#endif 

} 

//#endif 


//#if -2142827081 
public LastRecentlyUsedMenuList(JMenu filemenu)
    { 

//#if -635654356 
String newName;
//#endif 


//#if 1039910422 
int i;
//#endif 


//#if 1842338697 
fileMenu = filemenu;
//#endif 


//#if 2024982941 
lruCount = 0;
//#endif 


//#if -1953476458 
menuIndex = filemenu.getItemCount();
//#endif 


//#if 215948470 
maxCount =
            Configuration.getInteger(Argo.KEY_NUMBER_LAST_RECENT_USED,
                                     MAX_COUNT_DEFAULT);
//#endif 


//#if -1392130009 
Configuration.setInteger(Argo.KEY_NUMBER_LAST_RECENT_USED, maxCount);
//#endif 


//#if 1470751605 
confKeys = new ConfigurationKey[maxCount];
//#endif 


//#if -1069857983 
menuItems = new JMenuItem[maxCount];
//#endif 


//#if -280859747 
for (i = 0; i < maxCount; i++) //1
{ 

//#if -1568559633 
confKeys[i] =
                Configuration.makeKey("project",
                                      "mostrecent",
                                      "filelist".concat(Integer.toString(i)));
//#endif 

} 

//#endif 


//#if 1557516906 
i = 0;
//#endif 


//#if -1074990305 
boolean readOK = true;
//#endif 


//#if 1451806074 
while (i < maxCount && readOK) //1
{ 

//#if -896895740 
newName = Configuration.getString(confKeys[i], "");
//#endif 


//#if -872951299 
if(newName.length() > 0)//1
{ 

//#if -1581635928 
menuItems[i] = addEventHandler(newName, menuIndex + i);
//#endif 


//#if -1095582946 
i++;
//#endif 

} 
else
{ 

//#if 1002157715 
readOK = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2024984708 
lruCount = i;
//#endif 

} 

//#endif 


//#if -1951170356 
public void addEntry(String filename)
    { 

//#if 1653387868 
String[] tempNames = new String[maxCount];
//#endif 


//#if 74091339 
for (int i = 0; i < lruCount; i++) //1
{ 

//#if 235507010 
ActionReopenProject action =
                (ActionReopenProject) menuItems[i].getAction();
//#endif 


//#if 14771313 
tempNames[i] = action.getFilename();
//#endif 

} 

//#endif 


//#if -358033530 
for (int i = 0; i < lruCount; i++) //2
{ 

//#if -622777323 
fileMenu.remove(menuItems[i]);
//#endif 

} 

//#endif 


//#if 1699145664 
menuItems[0] = addEventHandler(filename, menuIndex);
//#endif 


//#if -2086319018 
int i, j;
//#endif 


//#if 474055724 
i = 0;
//#endif 


//#if 474085546 
j = 1;
//#endif 


//#if -211580804 
while (i < lruCount && j < maxCount) //1
{ 

//#if -521325512 
if(!(tempNames[i].equals(filename)))//1
{ 

//#if 769067377 
menuItems[j] = addEventHandler(tempNames[i], menuIndex + j);
//#endif 


//#if -116214246 
j++;
//#endif 

} 

//#endif 


//#if 446294385 
i++;
//#endif 

} 

//#endif 


//#if 59900065 
lruCount = j;
//#endif 


//#if 73808713 
for (int k = 0; k < lruCount; k++) //1
{ 

//#if 603741804 
ActionReopenProject action =
                (ActionReopenProject) menuItems[k].getAction();
//#endif 


//#if 1576683010 
Configuration.setString(confKeys[k], action.getFilename());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

