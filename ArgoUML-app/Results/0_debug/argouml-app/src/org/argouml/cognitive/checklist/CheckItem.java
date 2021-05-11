
//#if -644776110 
// Compilation Unit of /CheckItem.java 
 

//#if -1552847703 
package org.argouml.cognitive.checklist;
//#endif 


//#if -883447304 
import java.io.Serializable;
//#endif 


//#if 881040587 
import org.argouml.util.Predicate;
//#endif 


//#if 301074912 
import org.argouml.util.PredicateGefWrapper;
//#endif 


//#if -568844067 
import org.argouml.util.PredicateTrue;
//#endif 


//#if -1687332625 
public class CheckItem implements 
//#if 1188217815 
Serializable
//#endif 

  { 

//#if -1668967743 
private String category;
//#endif 


//#if 271648123 
private String description;
//#endif 


//#if 148681208 
private String moreInfoURL = "http://argouml.tigris.org/";
//#endif 


//#if 1058318410 
private Predicate predicate = PredicateTrue.getInstance();
//#endif 


//#if -835638765 
public String expand(String desc, Object dm)
    { 

//#if -10637272 
return desc;
//#endif 

} 

//#endif 


//#if 1949916062 
public CheckItem(String c, String d)
    { 

//#if -1213918344 
setCategory(c);
//#endif 


//#if -647920515 
setDescription(d);
//#endif 

} 

//#endif 


//#if 1990892969 
public String getMoreInfoURL()
    { 

//#if 971485001 
return moreInfoURL;
//#endif 

} 

//#endif 


//#if -793803461 
@Override
    public String toString()
    { 

//#if -631639018 
return getDescription();
//#endif 

} 

//#endif 


//#if 47682447 
public void setDescription(String d)
    { 

//#if 1763770988 
description = d;
//#endif 

} 

//#endif 


//#if 1226514902 
public void setMoreInfoURL(String m)
    { 

//#if -2135706158 
moreInfoURL = m;
//#endif 

} 

//#endif 


//#if 1536593187 
public String getCategory()
    { 

//#if -1685403850 
return category;
//#endif 

} 

//#endif 


//#if 710079890 
public void setPredicate(Predicate p)
    { 

//#if -628512658 
predicate = p;
//#endif 

} 

//#endif 


//#if -1916871564 
public void setCategory(String c)
    { 

//#if -821768518 
category = c;
//#endif 

} 

//#endif 


//#if -1283954647 

//#if -903870625 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public org.tigris.gef.util.Predicate getPredicate()
    { 

//#if -1501402144 
if(predicate instanceof PredicateGefWrapper)//1
{ 

//#if -855156293 
return ((PredicateGefWrapper) predicate).getGefPredicate();
//#endif 

} 

//#endif 


//#if -1990966927 
throw new IllegalStateException("Mixing legacy API and new API is not"
                                        + "supported.  Please update your code.");
//#endif 

} 

//#endif 


//#if -1052392816 

//#if -1724870609 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public CheckItem(String c, String d, String m,
                     org.tigris.gef.util.Predicate p)
    { 

//#if 1441022180 
this(c, d);
//#endif 


//#if -1981278622 
setMoreInfoURL(m);
//#endif 


//#if 1168093635 
predicate = new PredicateGefWrapper(p);
//#endif 

} 

//#endif 


//#if 178601993 

//#if -1470848957 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setPredicate(org.tigris.gef.util.Predicate p)
    { 

//#if 1671811558 
predicate = new PredicateGefWrapper(p);
//#endif 

} 

//#endif 


//#if -479213135 
public String getDescription(Object dm)
    { 

//#if 444220029 
return expand(description, dm);
//#endif 

} 

//#endif 


//#if 1169077465 
public String getDescription()
    { 

//#if 1605818469 
return description;
//#endif 

} 

//#endif 


//#if 1289117951 
public CheckItem(String c, String d, String m,
                     Predicate p)
    { 

//#if 1003935275 
this(c, d);
//#endif 


//#if 1366324393 
setMoreInfoURL(m);
//#endif 


//#if -1911281383 
predicate = p;
//#endif 

} 

//#endif 


//#if -336703794 
@Override
    public int hashCode()
    { 

//#if -200595145 
return getDescription().hashCode();
//#endif 

} 

//#endif 


//#if 943869884 
public Predicate getPredicate2()
    { 

//#if 1865203167 
return predicate;
//#endif 

} 

//#endif 


//#if 457972599 
@Override
    public boolean equals(Object o)
    { 

//#if -1651326429 
if(!(o instanceof CheckItem))//1
{ 

//#if -1416264503 
return false;
//#endif 

} 

//#endif 


//#if 1268661047 
CheckItem i = (CheckItem) o;
//#endif 


//#if 1290226068 
return getDescription().equals(i.getDescription());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

