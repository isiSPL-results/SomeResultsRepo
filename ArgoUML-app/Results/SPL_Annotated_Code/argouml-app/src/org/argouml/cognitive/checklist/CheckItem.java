// Compilation Unit of /CheckItem.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.checklist;
//#endif 


//#if COGNITIVE 
import java.io.Serializable;
//#endif 


//#if COGNITIVE 
import org.argouml.util.Predicate;
//#endif 


//#if COGNITIVE 
import org.argouml.util.PredicateGefWrapper;
//#endif 


//#if COGNITIVE 
import org.argouml.util.PredicateTrue;
//#endif 


//#if COGNITIVE 
public class CheckItem implements Serializable
  { 
private String category;
private String description;
private String moreInfoURL = "http://argouml.tigris.org/";
private Predicate predicate = PredicateTrue.getInstance();
public String expand(String desc, Object dm)
    { 
return desc;
} 

public CheckItem(String c, String d)
    { 
setCategory(c);
setDescription(d);
} 

public String getMoreInfoURL()
    { 
return moreInfoURL;
} 

@Override
    public String toString()
    { 
return getDescription();
} 

public void setDescription(String d)
    { 
description = d;
} 

public void setMoreInfoURL(String m)
    { 
moreInfoURL = m;
} 

public String getCategory()
    { 
return category;
} 

public void setPredicate(Predicate p)
    { 
predicate = p;
} 

public void setCategory(String c)
    { 
category = c;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public org.tigris.gef.util.Predicate getPredicate()
    { 
if(predicate instanceof PredicateGefWrapper)//1
{ 
return ((PredicateGefWrapper) predicate).getGefPredicate();
} 

throw new IllegalStateException("Mixing legacy API and new API is not"
                                        + "supported.  Please update your code.");
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public CheckItem(String c, String d, String m,
                     org.tigris.gef.util.Predicate p)
    { 
this(c, d);
setMoreInfoURL(m);
predicate = new PredicateGefWrapper(p);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public void setPredicate(org.tigris.gef.util.Predicate p)
    { 
predicate = new PredicateGefWrapper(p);
} 

public String getDescription(Object dm)
    { 
return expand(description, dm);
} 

public String getDescription()
    { 
return description;
} 

public CheckItem(String c, String d, String m,
                     Predicate p)
    { 
this(c, d);
setMoreInfoURL(m);
predicate = p;
} 

@Override
    public int hashCode()
    { 
return getDescription().hashCode();
} 

public Predicate getPredicate2()
    { 
return predicate;
} 

@Override
    public boolean equals(Object o)
    { 
if(!(o instanceof CheckItem))//1
{ 
return false;
} 

CheckItem i = (CheckItem) o;
return getDescription().equals(i.getDescription());
} 

 } 

//#endif 


