
//#if -363737118 
// Compilation Unit of /Language.java 
 

//#if -1001311963 
package org.argouml.uml.generator;
//#endif 


//#if -1695553675 
import javax.swing.Icon;
//#endif 


//#if 49032487 
public class Language  { 

//#if 509635557 
private String name;
//#endif 


//#if -1201787218 
private String title;
//#endif 


//#if -110336561 
private Icon icon;
//#endif 


//#if 1974399942 
public String getTitle()
    { 

//#if 1236091307 
return title;
//#endif 

} 

//#endif 


//#if -275238128 
public String toString()
    { 

//#if -1609038852 
String tit = getTitle();
//#endif 


//#if -813093387 
return tit == null ? "(no name)" : tit;
//#endif 

} 

//#endif 


//#if -1064638985 
public Language(String theName, Icon theIcon)
    { 

//#if -983115857 
this(theName, theName, theIcon);
//#endif 

} 

//#endif 


//#if 317563900 
public Language(String theName)
    { 

//#if 1918789338 
this(theName, theName, null);
//#endif 

} 

//#endif 


//#if 2129568203 
public void setIcon(Icon theIcon)
    { 

//#if 1960943625 
this.icon = theIcon;
//#endif 

} 

//#endif 


//#if 311148357 
public Icon getIcon()
    { 

//#if -363873974 
return icon;
//#endif 

} 

//#endif 


//#if -1722493518 
public Language(String theName, String theTitle)
    { 

//#if 2115137081 
this(theName, theTitle, null);
//#endif 

} 

//#endif 


//#if -531331905 
public String getName()
    { 

//#if 1417547690 
return name;
//#endif 

} 

//#endif 


//#if -1982384467 
public Language(String theName, String theTitle, Icon theIcon)
    { 

//#if 966689211 
this.name = theName;
//#endif 


//#if 997795751 
if(theTitle == null)//1
{ 

//#if -324484535 
this.title = theName;
//#endif 

} 
else
{ 

//#if -197105641 
this.title = theTitle;
//#endif 

} 

//#endif 


//#if 1619756895 
this.icon = theIcon;
//#endif 

} 

//#endif 


//#if 609785797 
public void setTitle(String theTitle)
    { 

//#if -685285079 
this.title = theTitle;
//#endif 

} 

//#endif 


//#if 1932344447 
public void setName(String theName)
    { 

//#if 992353731 
this.name = theName;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

