
//#if -170448714 
// Compilation Unit of /TodoTokenTable.java 
 

//#if -1153158976 
package org.argouml.persistence;
//#endif 


//#if -212459052 
class TodoTokenTable extends 
//#if -870913278 
XMLTokenTableBase
//#endif 

  { 

//#if -1213924266 
private static final String STRING_TO_DO                = "todo";
//#endif 


//#if 1887001421 
private static final String STRING_TO_DO_LIST           = "todolist";
//#endif 


//#if -1007607945 
private static final String STRING_TO_DO_ITEM           = "todoitem";
//#endif 


//#if 1910176067 
private static final String STRING_HEADLINE             = "headline";
//#endif 


//#if 1721392081 
private static final String STRING_DESCRIPTION          = "description";
//#endif 


//#if -1405491997 
private static final String STRING_PRIORITY             = "priority";
//#endif 


//#if -835578415 
private static final String STRING_MOREINFOURL          = "moreinfourl";
//#endif 


//#if 1497980593 
private static final String STRING_RESOLVEDCRITICS      = "resolvedcritics";
//#endif 


//#if 4365297 
private static final String STRING_ISSUE                = "issue";
//#endif 


//#if -1662314635 
private static final String STRING_POSTER               = "poster";
//#endif 


//#if 1809669709 
private static final String STRING_OFFENDER             = "offender";
//#endif 


//#if 1466906048 
public static final String STRING_PRIO_HIGH            = "high";
//#endif 


//#if 118672033 
public static final String STRING_PRIO_MED             = "medium";
//#endif 


//#if -1451471630 
public static final String STRING_PRIO_LOW             = "low";
//#endif 


//#if 2133401257 
public static final int    TOKEN_TO_DO                 = 1;
//#endif 


//#if 1628007015 
public static final int    TOKEN_TO_DO_LIST            = 2;
//#endif 


//#if -732721167 
public static final int    TOKEN_TO_DO_ITEM            = 3;
//#endif 


//#if 1676721375 
public static final int    TOKEN_HEADLINE              = 4;
//#endif 


//#if 1392874552 
public static final int    TOKEN_DESCRIPTION           = 5;
//#endif 


//#if -916160691 
public static final int    TOKEN_PRIORITY              = 6;
//#endif 


//#if 52525414 
public static final int    TOKEN_MOREINFOURL           = 7;
//#endif 


//#if 1964100778 
public static final int    TOKEN_RESOLVEDCRITICS       = 8;
//#endif 


//#if -930743433 
public static final int    TOKEN_ISSUE                 = 9;
//#endif 


//#if -399984163 
public static final int    TOKEN_POSTER                = 10;
//#endif 


//#if -147229400 
public static final int    TOKEN_OFFENDER              = 11;
//#endif 


//#if -966872580 
public static final int    TOKEN_UNDEFINED             = 12;
//#endif 


//#if 515033841 
protected void setupTokens()
    { 

//#if 1388926112 
addToken(STRING_TO_DO, Integer.valueOf(TOKEN_TO_DO));
//#endif 


//#if 1555150202 
addToken(STRING_TO_DO_LIST, Integer.valueOf(TOKEN_TO_DO_LIST));
//#endif 


//#if -1852748070 
addToken(STRING_TO_DO_ITEM, Integer.valueOf(TOKEN_TO_DO_ITEM));
//#endif 


//#if 1443400122 
addToken(STRING_HEADLINE, Integer.valueOf(TOKEN_HEADLINE));
//#endif 


//#if 827441094 
addToken(STRING_DESCRIPTION, Integer.valueOf(TOKEN_DESCRIPTION));
//#endif 


//#if -2128854086 
addToken(STRING_PRIORITY, Integer.valueOf(TOKEN_PRIORITY));
//#endif 


//#if 1086606758 
addToken(STRING_MOREINFOURL, Integer.valueOf(TOKEN_MOREINFOURL));
//#endif 


//#if -1642220240 
addToken(STRING_RESOLVEDCRITICS, Integer.valueOf(TOKEN_RESOLVEDCRITICS));
//#endif 


//#if 1690668876 
addToken(STRING_ISSUE, Integer.valueOf(TOKEN_ISSUE));
//#endif 


//#if -1094384614 
addToken(STRING_POSTER, Integer.valueOf(TOKEN_POSTER));
//#endif 


//#if -893932966 
addToken(STRING_OFFENDER, Integer.valueOf(TOKEN_OFFENDER));
//#endif 

} 

//#endif 


//#if -1290490176 
public TodoTokenTable()
    { 

//#if -1830846663 
super(32);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

