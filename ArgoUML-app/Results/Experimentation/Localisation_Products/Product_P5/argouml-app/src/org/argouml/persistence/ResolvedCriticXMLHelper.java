package org.argouml.persistence;
import java.util.List;
import java.util.Vector;
import org.argouml.cognitive.ResolvedCritic;
public class ResolvedCriticXMLHelper  { 
private final ResolvedCritic item;
public ResolvedCriticXMLHelper(ResolvedCritic rc)
    { 
if(rc == null)//1
{ 
throw new IllegalArgumentException(
                "There must be a ResolvedCritic supplied.");
} 
item = rc;
} 
public Vector<OffenderXMLHelper> getOffenderList()
    { 
List<String> in = item.getOffenderList();
Vector<OffenderXMLHelper> out;
if(in == null)//1
{ 
return null;
} 
out = new Vector<OffenderXMLHelper>();
for (String elem : in) //1
{ 
try//1
{ 
OffenderXMLHelper helper =
                    new OffenderXMLHelper(elem);
out.addElement(helper);
} 
catch (ClassCastException cce) //1
{ 
} 
} 
return out;
} 
public String getCritic()
    { 
return item.getCritic();
} 

 } 
