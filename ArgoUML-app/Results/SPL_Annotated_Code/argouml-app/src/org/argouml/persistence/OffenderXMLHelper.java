// Compilation Unit of /OffenderXMLHelper.java 
 

//#if COGNITIVE 
package org.argouml.persistence;
//#endif 


//#if COGNITIVE 
public class OffenderXMLHelper  { 
private final String item;
public OffenderXMLHelper(String offender)
    { 
if(offender == null)//1
{ 
throw new IllegalArgumentException(
                "An offender string must be supplied");
} 

item = offender;
} 

public String getOffender()
    { 
return item;
} 

 } 

//#endif 


