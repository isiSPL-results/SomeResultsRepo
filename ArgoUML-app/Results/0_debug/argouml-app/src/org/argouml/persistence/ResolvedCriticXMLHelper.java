
//#if -125577019 
// Compilation Unit of /ResolvedCriticXMLHelper.java 
 

//#if -1149498635 
package org.argouml.persistence;
//#endif 


//#if 1745870734 
import java.util.List;
//#endif 


//#if -1394574519 
import java.util.Vector;
//#endif 


//#if -716302769 
import org.argouml.cognitive.ResolvedCritic;
//#endif 


//#if 1462340436 
public class ResolvedCriticXMLHelper  { 

//#if -453865310 
private final ResolvedCritic item;
//#endif 


//#if 1836780173 
public ResolvedCriticXMLHelper(ResolvedCritic rc)
    { 

//#if -73829550 
if(rc == null)//1
{ 

//#if -609577877 
throw new IllegalArgumentException(
                "There must be a ResolvedCritic supplied.");
//#endif 

} 

//#endif 


//#if -534486727 
item = rc;
//#endif 

} 

//#endif 


//#if -716792589 
public Vector<OffenderXMLHelper> getOffenderList()
    { 

//#if -1520499911 
List<String> in = item.getOffenderList();
//#endif 


//#if 49885406 
Vector<OffenderXMLHelper> out;
//#endif 


//#if -1975089787 
if(in == null)//1
{ 

//#if 1599556170 
return null;
//#endif 

} 

//#endif 


//#if -1726433818 
out = new Vector<OffenderXMLHelper>();
//#endif 


//#if 974411726 
for (String elem : in) //1
{ 

//#if 1091777461 
try //1
{ 

//#if -21081836 
OffenderXMLHelper helper =
                    new OffenderXMLHelper(elem);
//#endif 


//#if -1992853081 
out.addElement(helper);
//#endif 

} 

//#if -1316939975 
catch (ClassCastException cce) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if -748707113 
return out;
//#endif 

} 

//#endif 


//#if 1918768074 
public String getCritic()
    { 

//#if 2136115419 
return item.getCritic();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

