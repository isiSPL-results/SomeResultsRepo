
//#if 727235387 
// Compilation Unit of /ArgoTokenTable.java 
 

//#if 250376037 
package org.argouml.persistence;
//#endif 


//#if 1958444236 
class ArgoTokenTable extends 
//#if 936045745 
XMLTokenTableBase
//#endif 

  { 

//#if -1441924228 
private static final String STRING_ARGO                   = "argo";
//#endif 


//#if 1235980406 
private static final String STRING_AUTHORNAME            = "authorname";
//#endif 


//#if -1666830176 
private static final String STRING_AUTHOREMAIL            = "authoremail";
//#endif 


//#if 1401636224 
private static final String STRING_VERSION               = "version";
//#endif 


//#if -805911936 
private static final String STRING_DESCRIPTION           = "description";
//#endif 


//#if -1216618268 
private static final String STRING_SEARCHPATH            = "searchpath";
//#endif 


//#if 1039842302 
private static final String STRING_MEMBER                = "member";
//#endif 


//#if 2021384960 
private static final String STRING_HISTORYFILE           = "historyfile";
//#endif 


//#if 35614976 
private static final String STRING_DOCUMENTATION         = "documentation";
//#endif 


//#if 636736912 
private static final String STRING_SETTINGS = "settings";
//#endif 


//#if 554693822 
private static final String STRING_NOTATIONLANGUAGE = "notationlanguage";
//#endif 


//#if -699408512 
private static final String STRING_SHOWBOLDNAMES = "showboldnames";
//#endif 


//#if 469053952 
private static final String STRING_USEGUILLEMOTS = "useguillemots";
//#endif 


//#if 1540517586 
private static final String STRING_SHOWASSOCIATIONNAMES
        = "showassociationnames";
//#endif 


//#if -1519026456 
private static final String STRING_SHOWVISIBILITY = "showvisibility";
//#endif 


//#if 241536642 
private static final String STRING_SHOWMULTIPLICITY = "showmultiplicity";
//#endif 


//#if -43567522 
private static final String STRING_SHOWINITIALVALUE = "showinitialvalue";
//#endif 


//#if 1707206826 
private static final String STRING_SHOWPROPERTIES = "showproperties";
//#endif 


//#if 1718606912 
private static final String STRING_SHOWTYPES = "showtypes";
//#endif 


//#if -1960020992 
private static final String STRING_SHOWSTEREOTYPES = "showstereotypes";
//#endif 


//#if -73053140 
private static final String STRING_SHOWSINGULARMULTIPLICITIES
        = "showsingularmultiplicities";
//#endif 


//#if -776018208 
private static final String STRING_HIDEBIDIRECTIONALARROWS
        = "hidebidirectionalarrows";
//#endif 


//#if -1884777772 
private static final String STRING_DEFAULTSHADOWWIDTH
        = "defaultshadowwidth";
//#endif 


//#if -483139650 
private static final String STRING_FONTNAME = "fontname";
//#endif 


//#if -1691704278 
private static final String STRING_FONTSIZE = "fontsize";
//#endif 


//#if 2084761763 
@Deprecated
    private static final String STRING_GENERATION_OUTPUT_DIR
        = "generationoutputdir";
//#endif 


//#if -12116901 
private static final String STRING_ACTIVE_DIAGRAM = "activediagram";
//#endif 


//#if -1920087412 
public static final int    TOKEN_ARGO                    = 1;
//#endif 


//#if 844887374 
public static final int    TOKEN_AUTHORNAME              = 2;
//#endif 


//#if -657975210 
public static final int    TOKEN_AUTHOREMAIL              = 3;
//#endif 


//#if -1436381138 
public static final int    TOKEN_VERSION                 = 4;
//#endif 


//#if 1131486633 
public static final int    TOKEN_DESCRIPTION             = 5;
//#endif 


//#if 1653391155 
public static final int    TOKEN_SEARCHPATH              = 6;
//#endif 


//#if 901870181 
public static final int    TOKEN_MEMBER                  = 7;
//#endif 


//#if -2083206798 
public static final int    TOKEN_HISTORYFILE             = 8;
//#endif 


//#if -1260058073 
public static final int    TOKEN_DOCUMENTATION           = 9;
//#endif 


//#if -1037864156 
public static final int    TOKEN_SETTINGS           = 10;
//#endif 


//#if 564920058 
public static final int    TOKEN_NOTATIONLANGUAGE           = 11;
//#endif 


//#if -1446473651 
public static final int    TOKEN_USEGUILLEMOTS           = 12;
//#endif 


//#if -1390646867 
public static final int    TOKEN_SHOWVISIBILITY           = 13;
//#endif 


//#if 1872621049 
public static final int    TOKEN_SHOWMULTIPLICITY           = 14;
//#endif 


//#if 1817949766 
public static final int    TOKEN_SHOWINITIALVALUE           = 15;
//#endif 


//#if -262169685 
public static final int    TOKEN_SHOWPROPERTIES           = 16;
//#endif 


//#if 684860242 
public static final int    TOKEN_SHOWTYPES           = 17;
//#endif 


//#if 2073643449 
public static final int    TOKEN_SHOWSTEREOTYPES           = 18;
//#endif 


//#if 417652829 
public static final int    TOKEN_DEFAULTSHADOWWIDTH           = 19;
//#endif 


//#if -1539796956 
public static final int    TOKEN_SHOWBOLDNAMES           = 20;
//#endif 


//#if -696185157 
public static final int    TOKEN_FONTNAME           = 21;
//#endif 


//#if -1689794224 
public static final int    TOKEN_FONTSIZE           = 22;
//#endif 


//#if 1329936694 
@Deprecated
    public static final int    TOKEN_GENERATION_OUTPUT_DIR     = 23;
//#endif 


//#if -1358644190 
public static final int    TOKEN_SHOWASSOCIATIONNAMES     = 24;
//#endif 


//#if 1051625175 
public static final int    TOKEN_ACTIVE_DIAGRAM     = 25;
//#endif 


//#if 611875181 
public static final int    TOKEN_SHOWSINGULARMULTIPLICITIES = 26;
//#endif 


//#if 1584249730 
public static final int TOKEN_HIDEBIDIRECTIONALARROWS = 27;
//#endif 


//#if -1668033204 
public static final int    TOKEN_UNDEFINED               = 99;
//#endif 


//#if 1286702724 
public ArgoTokenTable()
    { 

//#if 1139183831 
super(32);
//#endif 

} 

//#endif 


//#if -450609630 
protected void setupTokens()
    { 

//#if -797169344 
addToken(STRING_ARGO, Integer.valueOf(TOKEN_ARGO));
//#endif 


//#if 1388065248 
addToken(STRING_AUTHORNAME, Integer.valueOf(TOKEN_AUTHORNAME));
//#endif 


//#if 1901676226 
addToken(STRING_AUTHOREMAIL, Integer.valueOf(TOKEN_AUTHOREMAIL));
//#endif 


//#if 942809588 
addToken(STRING_VERSION, Integer.valueOf(TOKEN_VERSION));
//#endif 


//#if 133286828 
addToken(STRING_DESCRIPTION, Integer.valueOf(TOKEN_DESCRIPTION));
//#endif 


//#if 465617664 
addToken(STRING_SEARCHPATH, Integer.valueOf(TOKEN_SEARCHPATH));
//#endif 


//#if 229442656 
addToken(STRING_MEMBER, Integer.valueOf(TOKEN_MEMBER));
//#endif 


//#if -612415612 
addToken(STRING_HISTORYFILE, Integer.valueOf(TOKEN_HISTORYFILE));
//#endif 


//#if 930965168 
addToken(STRING_DOCUMENTATION, Integer.valueOf(TOKEN_DOCUMENTATION));
//#endif 


//#if -796536832 
addToken(STRING_SETTINGS, Integer.valueOf(TOKEN_SETTINGS));
//#endif 


//#if 1138162912 
addToken(STRING_NOTATIONLANGUAGE, Integer.valueOf(TOKEN_NOTATIONLANGUAGE));
//#endif 


//#if 2040014872 
addToken(STRING_SHOWBOLDNAMES, Integer.valueOf(TOKEN_SHOWBOLDNAMES));
//#endif 


//#if 1442184128 
addToken(STRING_USEGUILLEMOTS, Integer.valueOf(TOKEN_USEGUILLEMOTS));
//#endif 


//#if -1950892736 
addToken(STRING_SHOWVISIBILITY, Integer.valueOf(TOKEN_SHOWVISIBILITY));
//#endif 


//#if 875009824 
addToken(STRING_SHOWMULTIPLICITY, Integer.valueOf(TOKEN_SHOWMULTIPLICITY));
//#endif 


//#if 1044202254 
addToken(STRING_HIDEBIDIRECTIONALARROWS, Integer.valueOf(TOKEN_HIDEBIDIRECTIONALARROWS));
//#endif 


//#if -873642272 
addToken(STRING_SHOWINITIALVALUE, Integer.valueOf(TOKEN_SHOWINITIALVALUE));
//#endif 


//#if 942803104 
addToken(STRING_SHOWPROPERTIES, Integer.valueOf(TOKEN_SHOWPROPERTIES));
//#endif 


//#if 1255592300 
addToken(STRING_SHOWTYPES, Integer.valueOf(TOKEN_SHOWTYPES));
//#endif 


//#if -2029218596 
addToken(STRING_SHOWSTEREOTYPES, Integer.valueOf(TOKEN_SHOWSTEREOTYPES));
//#endif 


//#if -1253469056 
addToken(STRING_SHOWSINGULARMULTIPLICITIES,
                 Integer.valueOf(TOKEN_SHOWSINGULARMULTIPLICITIES));
//#endif 


//#if 605225728 
addToken(STRING_DEFAULTSHADOWWIDTH,
                 Integer.valueOf(TOKEN_DEFAULTSHADOWWIDTH));
//#endif 


//#if 1491952352 
addToken(STRING_FONTNAME, Integer.valueOf(TOKEN_FONTNAME));
//#endif 


//#if -623113824 
addToken(STRING_FONTSIZE, Integer.valueOf(TOKEN_FONTSIZE));
//#endif 


//#if 1610094968 
addToken(STRING_GENERATION_OUTPUT_DIR,
                 Integer.valueOf(TOKEN_GENERATION_OUTPUT_DIR));
//#endif 


//#if -618572768 
addToken(STRING_SHOWASSOCIATIONNAMES,
                 Integer.valueOf(TOKEN_SHOWASSOCIATIONNAMES));
//#endif 


//#if 732066400 
addToken(STRING_ACTIVE_DIAGRAM,
                 Integer.valueOf(TOKEN_ACTIVE_DIAGRAM));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

