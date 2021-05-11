
//#if -650128350 
// Compilation Unit of /PathComparator.java 
 

//#if -1748532745 
package org.argouml.uml.util;
//#endif 


//#if -1934832380 
import java.text.Collator;
//#endif 


//#if -623921690 
import java.util.Collections;
//#endif 


//#if -1180724859 
import java.util.Comparator;
//#endif 


//#if 1721475309 
import java.util.Iterator;
//#endif 


//#if 722382525 
import java.util.List;
//#endif 


//#if 2021202452 
import org.argouml.model.Model;
//#endif 


//#if -1094961585 
public class PathComparator implements 
//#if -724497061 
Comparator
//#endif 

  { 

//#if 342462105 
private Collator collator;
//#endif 


//#if 1096717962 
public PathComparator()
    { 

//#if 810476506 
collator = Collator.getInstance();
//#endif 


//#if -1374844289 
collator.setStrength(Collator.PRIMARY);
//#endif 

} 

//#endif 


//#if 1744887360 
public int compare(Object o1, Object o2)
    { 

//#if -198464139 
if(o1 == null)//1
{ 

//#if 214671610 
if(o2 == null)//1
{ 

//#if 446038547 
return 0;
//#endif 

} 

//#endif 


//#if 766189412 
return -1;
//#endif 

} 

//#endif 


//#if -1995415498 
if(o2 == null)//1
{ 

//#if -1014414165 
return 1;
//#endif 

} 

//#endif 


//#if -1686519251 
if(o1.equals(o2))//1
{ 

//#if -725122130 
return 0;
//#endif 

} 

//#endif 


//#if -1637084629 
if(o1 instanceof String)//1
{ 

//#if 1434875736 
if(o2 instanceof String)//1
{ 

//#if -868473625 
return collator.compare((String) o1, (String) o2);
//#endif 

} 
else

//#if -2021051648 
if(Model.getFacade().isAUMLElement(o2))//1
{ 

//#if -163918180 
return -1;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1217591360 
if(o2 instanceof String && Model.getFacade().isAUMLElement(o1))//1
{ 

//#if -2134921113 
return 1;
//#endif 

} 

//#endif 


//#if 1297212050 
String name1, name2;
//#endif 


//#if -953335395 
try //1
{ 

//#if -1075410851 
name1 = Model.getFacade().getName(o1);
//#endif 


//#if 1209453565 
name2 = Model.getFacade().getName(o2);
//#endif 

} 

//#if -1336427264 
catch (IllegalArgumentException e) //1
{ 

//#if -223289928 
throw new ClassCastException(
                "Model element or String required"
                + "\n - o1 = " + ((o1 == null) ? "(null)" : o1.toString())
                + "\n - o2 = " + ((o2 == null) ? "(null)" : o2.toString()));
//#endif 

} 

//#endif 


//#endif 


//#if -1791988403 
if(name1 != null && name2 != null)//1
{ 

//#if 930234530 
int comparison = collator.compare(name1, name2);
//#endif 


//#if 1404644289 
if(comparison != 0)//1
{ 

//#if 661542178 
return comparison;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1908065111 
return comparePaths(o1, o2);
//#endif 

} 

//#endif 


//#if -345477398 
private int comparePaths(Object o1, Object o2)
    { 

//#if 1230994 
List<String> path1 =
            Model.getModelManagementHelper().getPathList(o1);
//#endif 


//#if 785276522 
Collections.reverse(path1);
//#endif 


//#if 1134422548 
List<String> path2 =
            Model.getModelManagementHelper().getPathList(o2);
//#endif 


//#if 785277483 
Collections.reverse(path2);
//#endif 


//#if -1041521653 
Iterator<String> i2 = path2.iterator();
//#endif 


//#if 96353225 
Iterator<String> i1 = path1.iterator();
//#endif 


//#if -685354637 
int caseSensitiveComparison = 0;
//#endif 


//#if 751828125 
while (i2.hasNext()) //1
{ 

//#if 1917535646 
String name2 = i2.next();
//#endif 


//#if 1840092123 
if(!i1.hasNext())//1
{ 

//#if 2015848921 
return -1;
//#endif 

} 

//#endif 


//#if -699059906 
String name1 = i1.next();
//#endif 


//#if 2019840088 
int comparison;
//#endif 


//#if -14373761 
if(name1 == null)//1
{ 

//#if 1906182215 
if(name2 == null)//1
{ 

//#if 444328514 
comparison = 0;
//#endif 

} 
else
{ 

//#if 984735857 
comparison = -1;
//#endif 

} 

//#endif 

} 
else

//#if 522518590 
if(name2 == null)//1
{ 

//#if 1390021059 
comparison = 1;
//#endif 

} 
else
{ 

//#if -1657788238 
comparison = collator.compare(name1, name2);
//#endif 

} 

//#endif 


//#endif 


//#if 30923293 
if(comparison != 0)//1
{ 

//#if -778798689 
return comparison;
//#endif 

} 

//#endif 


//#if -1303885249 
if(caseSensitiveComparison == 0)//1
{ 

//#if -1671736233 
if(name1 == null)//1
{ 

//#if -1049754599 
if(name2 == null)//1
{ 

//#if -1463474657 
caseSensitiveComparison = 0;
//#endif 

} 
else
{ 

//#if 432709526 
caseSensitiveComparison = -1;
//#endif 

} 

//#endif 

} 
else

//#if -53038641 
if(name2 == null)//1
{ 

//#if 1609437960 
caseSensitiveComparison = 1;
//#endif 

} 
else
{ 

//#if 1968419476 
caseSensitiveComparison = name1.compareTo(name2);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -408008025 
if(i2.hasNext())//1
{ 

//#if -1170208963 
return 1;
//#endif 

} 

//#endif 


//#if 633719203 
if(caseSensitiveComparison != 0)//1
{ 

//#if -528461466 
return caseSensitiveComparison;
//#endif 

} 

//#endif 


//#if 990237384 
return o1.toString().compareTo(o2.toString());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

