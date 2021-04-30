
//#if -2101807231 
// Compilation Unit of /HTMLCode.java 
 

//#if 966113320 
package lib.util;
//#endif 


//#if 1596079549 
import healthwatcher.Constants;
//#endif 


//#if 66616137 
public class HTMLCode  { 

//#if 808654117 
private static final int REGULAR_PAGE = 1;
//#endif 


//#if -1495964914 
private static final int QUERIES_PAGE = 2;
//#endif 


//#if 1276460948 
private static final int ADMINISTRATOR_PAGE = 3;
//#endif 


//#if -428680073 
private static String foot()
    { 

//#if 237349253 
return "<a href=\"" + Constants.SYSTEM_INDEX + "\">" + "Main menu</a>"
               + "<p><small>Health-Watcher - 2006</small></center></body></html>";
//#endif 

} 

//#endif 


//#if 1704578093 
public static String open()
    { 

//#if -1673711525 
return HTMLCode.open("");
//#endif 

} 

//#endif 


//#if 835189818 
public static String htmlPage(String title, String text)
    { 

//#if 1635995993 
return htmlPage(title, text, REGULAR_PAGE);
//#endif 

} 

//#endif 


//#if 1232398584 
public static String link(String url, String description)
    { 

//#if -962193032 
return "<a href=\"" + url + "\">" + description + "</a>";
//#endif 

} 

//#endif 


//#if -1771719538 
public static String htmlPage(String title, String text, int pageType)
    { 

//#if 1550623014 
StringBuffer pagina = new StringBuffer();
//#endif 


//#if 1769140459 
pagina.append(HTMLCode.open(title, "white"));
//#endif 


//#if 516068596 
pagina.append("<center>");
//#endif 


//#if 2064652757 
pagina.append("<font face=\"Arial\" color=\"black\" size=+1>" + title + "</font></td>");
//#endif 


//#if -216940303 
pagina.append("</center>");
//#endif 


//#if -1131526987 
pagina.append("<font face=\"Arial\" color=\"black\"><small>");
//#endif 


//#if 508399702 
pagina.append("<p align=\"center\">");
//#endif 


//#if -1498931762 
pagina.append(text);
//#endif 


//#if -284465355 
pagina.append("</small></font>");
//#endif 


//#if -505861753 
switch (pageType) //1
{ 
case QUERIES_PAGE://1


//#if -749397216 
pagina.append(HTMLCode.closeQueries());
//#endif 


//#if 1945441069 
break;

//#endif 


case ADMINISTRATOR_PAGE://1


//#if -739734591 
pagina.append(HTMLCode.closeAdministrator());
//#endif 


//#if 919932531 
break;

//#endif 


default://1


//#if 1048884064 
pagina.append(HTMLCode.close());
//#endif 


} 

//#endif 


//#if 994505983 
return pagina.toString();
//#endif 

} 

//#endif 


//#if -1149526735 
public static String closeQueries()
    { 

//#if 109080550 
return "<p><center>" + HTMLCode.linkQueries() + " - " + HTMLCode.foot();
//#endif 

} 

//#endif 


//#if -1361669210 
public static String errorPage(String message)
    { 

//#if 243477910 
return HTMLCode.htmlPage("Error message", message);
//#endif 

} 

//#endif 


//#if -276125443 
public static String open(String title, String bgColor)
    { 

//#if 927514888 
return HTMLCode.open1() + title + HTMLCode.open2() + "<body bgcolor=\"" + bgColor + "\">";
//#endif 

} 

//#endif 


//#if -1418093910 
public static String errorPageQueries(String message)
    { 

//#if -1595192810 
return HTMLCode.htmlPage("Queries - Error message", message, QUERIES_PAGE);
//#endif 

} 

//#endif 


//#if -987357023 
private static String open2()
    { 

//#if 279237421 
return "</TITLE></HEAD>";
//#endif 

} 

//#endif 


//#if -2120238609 
public static String htmlPageAdministrator(String title, String text)
    { 

//#if -1267695864 
return htmlPage(title, text, ADMINISTRATOR_PAGE);
//#endif 

} 

//#endif 


//#if -806171732 
private static String linkAdministrator()
    { 

//#if -1175391503 
return link(Constants.SYSTEM_INDEX_ADMINISTRATOR, "Employee's menu");
//#endif 

} 

//#endif 


//#if -862870057 
public static String close()
    { 

//#if -52709965 
return "<p><center>" + HTMLCode.foot();
//#endif 

} 

//#endif 


//#if 499572360 
public static String htmlPageQueries(String title, String text)
    { 

//#if 2009955686 
return htmlPage(title, text, QUERIES_PAGE);
//#endif 

} 

//#endif 


//#if -1675867003 
private static String linkQueries()
    { 

//#if -900886894 
return link(Constants.SYSTEM_QUERIES, "Queries' menu");
//#endif 

} 

//#endif 


//#if 692448088 
public static String closeAdministrator()
    { 

//#if -417645548 
return "<p><center>" + HTMLCode.linkAdministrator() + " - " + HTMLCode.foot();
//#endif 

} 

//#endif 


//#if 1168643518 
public static String open(String title)
    { 

//#if 1577432710 
return HTMLCode.open("Health-Watcher - 2006 - " + title, "white");
//#endif 

} 

//#endif 


//#if 343451811 
public static String errorPageAdministrator(String message)
    { 

//#if -190100656 
return HTMLCode.htmlPage("Administrator - Error message", message, ADMINISTRATOR_PAGE);
//#endif 

} 

//#endif 


//#if -987357984 
private static String open1()
    { 

//#if -1352279198 
return "<HTML><HEAD><TITLE>";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

