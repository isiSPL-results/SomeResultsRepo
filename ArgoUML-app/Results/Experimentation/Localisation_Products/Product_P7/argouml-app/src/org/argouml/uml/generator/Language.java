package org.argouml.uml.generator;
import javax.swing.Icon;
public class Language  { 
private String name;
private String title;
private Icon icon;
public String getTitle()
    { 
return title;
} 
public String toString()
    { 
String tit = getTitle();
return tit == null ? "(no name)" : tit;
} 
public Language(String theName, Icon theIcon)
    { 
this(theName, theName, theIcon);
} 
public Language(String theName)
    { 
this(theName, theName, null);
} 
public void setIcon(Icon theIcon)
    { 
this.icon = theIcon;
} 
public Icon getIcon()
    { 
return icon;
} 
public Language(String theName, String theTitle)
    { 
this(theName, theTitle, null);
} 
public String getName()
    { 
return name;
} 
public Language(String theName, String theTitle, Icon theIcon)
    { 
this.name = theName;
if(theTitle == null)//1
{ 
this.title = theName;
} 
else
{ 
this.title = theTitle;
} 
this.icon = theIcon;
} 
public void setTitle(String theTitle)
    { 
this.title = theTitle;
} 
public void setName(String theName)
    { 
this.name = theName;
} 

 } 
