
//#if 2134633853 
// Compilation Unit of /MyTokenizer.java 
 

//#if 688859638 
package org.argouml.util;
//#endif 


//#if -2130412983 
import java.util.ArrayList;
//#endif 


//#if -278694856 
import java.util.Collection;
//#endif 


//#if -1676883111 
import java.util.Enumeration;
//#endif 


//#if 200651384 
import java.util.List;
//#endif 


//#if 1424804219 
import java.util.NoSuchElementException;
//#endif 


//#if -442209020 
class ExprSeparatorWithStrings extends 
//#if 760735196 
CustomSeparator
//#endif 

  { 

//#if -1085233370 
private boolean isSQuot;
//#endif 


//#if -1514670635 
private boolean isDQuot;
//#endif 


//#if 101278893 
private boolean isEsc;
//#endif 


//#if -1544058845 
private int tokLevel;
//#endif 


//#if -2088755534 
private int tokLen;
//#endif 


//#if -1338360781 
public boolean hasFreePart()
    { 

//#if -1131142332 
return true;
//#endif 

} 

//#endif 


//#if -950371058 
public ExprSeparatorWithStrings()
    { 

//#if -1597656785 
super('(');
//#endif 


//#if -1005262298 
isEsc = false;
//#endif 


//#if 219896351 
isSQuot = false;
//#endif 


//#if -1716344434 
isDQuot = false;
//#endif 


//#if 1250958487 
tokLevel = 1;
//#endif 


//#if -1165456057 
tokLen = 0;
//#endif 

} 

//#endif 


//#if 176719826 
public int tokenLength()
    { 

//#if 1262237206 
return super.tokenLength() + tokLen;
//#endif 

} 

//#endif 


//#if -983591142 
public boolean endChar(char c)
    { 

//#if 481790462 
tokLen++;
//#endif 


//#if 1212439847 
if(isSQuot)//1
{ 

//#if -1895521469 
if(isEsc)//1
{ 

//#if -851460752 
isEsc = false;
//#endif 


//#if 642015854 
return false;
//#endif 

} 

//#endif 


//#if 1188698171 
if(c == '\\')//1
{ 

//#if -1607419022 
isEsc = true;
//#endif 

} 
else

//#if 2018893803 
if(c == '\'')//1
{ 

//#if 1748971405 
isSQuot = false;
//#endif 

} 

//#endif 


//#endif 


//#if -1288427965 
return false;
//#endif 

} 
else

//#if 1592637731 
if(isDQuot)//1
{ 

//#if 845420020 
if(isEsc)//1
{ 

//#if -1306300595 
isEsc = false;
//#endif 


//#if 187176011 
return false;
//#endif 

} 

//#endif 


//#if -1876450644 
if(c == '\\')//1
{ 

//#if -1583937545 
isEsc = true;
//#endif 

} 
else

//#if -442470508 
if(c == '\"')//1
{ 

//#if -1765068946 
isDQuot = false;
//#endif 

} 

//#endif 


//#endif 


//#if 1452513524 
return false;
//#endif 

} 
else
{ 

//#if 25369082 
if(c == '\'')//1
{ 

//#if -610569981 
isSQuot = true;
//#endif 

} 
else

//#if 1116101201 
if(c == '\"')//1
{ 

//#if -2106012862 
isDQuot = true;
//#endif 

} 
else

//#if 272426224 
if(c == '(')//1
{ 

//#if -1127968798 
tokLevel++;
//#endif 

} 
else

//#if -255067348 
if(c == ')')//1
{ 

//#if -188209157 
tokLevel--;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 1412648853 
return tokLevel <= 0;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1862856197 
public void reset()
    { 

//#if 499400672 
super.reset();
//#endif 


//#if -1064068276 
isEsc = false;
//#endif 


//#if -458073659 
isSQuot = false;
//#endif 


//#if 1900652852 
isDQuot = false;
//#endif 


//#if -1937527119 
tokLevel = 1;
//#endif 


//#if 1754127841 
tokLen = 0;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1527637085 
class TokenSep  { 

//#if 1547538806 
private TokenSep next = null;
//#endif 


//#if 1413826009 
private final String theString;
//#endif 


//#if 990097621 
private final int length;
//#endif 


//#if 997830579 
private int pattern;
//#endif 


//#if -1481033865 
public void reset()
    { 

//#if -1638152481 
pattern = 0;
//#endif 

} 

//#endif 


//#if 2136863936 
public TokenSep getNext()
    { 

//#if -155326969 
return next;
//#endif 

} 

//#endif 


//#if 1322091058 
public String getString()
    { 

//#if -15008032 
return theString;
//#endif 

} 

//#endif 


//#if 550831185 
public int length()
    { 

//#if 1849262563 
return length;
//#endif 

} 

//#endif 


//#if 631810576 
public boolean addChar(char c)
    { 

//#if -690142435 
int i;
//#endif 


//#if 931737755 
pattern <<= 1;
//#endif 


//#if 1417436599 
pattern |= 1;
//#endif 


//#if 1174591505 
for (i = 0; i < length; i++) //1
{ 

//#if 1846466330 
if(theString.charAt(i) != c)//1
{ 

//#if -1514892658 
pattern &= ~(1 << i);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1409804337 
return (pattern & (1 << (length - 1))) != 0;
//#endif 

} 

//#endif 


//#if -1411340537 
public TokenSep(String str)
    { 

//#if -2066363760 
theString = str;
//#endif 


//#if -658371189 
length = str.length();
//#endif 


//#if -1335969729 
if(length > 32)//1
{ 

//#if 2084626854 
throw new IllegalArgumentException("TokenSep " + str
                                               + " is " + length + " (> 32) chars long");
//#endif 

} 

//#endif 


//#if 826290755 
pattern = 0;
//#endif 

} 

//#endif 


//#if 437830988 
public void setNext(TokenSep n)
    { 

//#if 1642414621 
this.next = n;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 904884628 
class QuotedStringSeparator extends 
//#if -311296465 
CustomSeparator
//#endif 

  { 

//#if -2077950635 
private final char escChr;
//#endif 


//#if 2037775682 
private final char startChr;
//#endif 


//#if -90917506 
private final char stopChr;
//#endif 


//#if -1051028367 
private boolean esced;
//#endif 


//#if -1519030715 
private int tokLen;
//#endif 


//#if -1672390840 
private int level;
//#endif 


//#if -1317899066 
public QuotedStringSeparator(char sq, char eq, char esc)
    { 

//#if -1406933888 
super(sq);
//#endif 


//#if -954017596 
esced = false;
//#endif 


//#if -500340568 
escChr = esc;
//#endif 


//#if 643919310 
startChr = sq;
//#endif 


//#if 2101619962 
stopChr = eq;
//#endif 


//#if 815324928 
tokLen = 0;
//#endif 


//#if -146928442 
level = 1;
//#endif 

} 

//#endif 


//#if -1553662945 
public int tokenLength()
    { 

//#if 543082203 
return super.tokenLength() + tokLen;
//#endif 

} 

//#endif 


//#if -503725568 
public boolean hasFreePart()
    { 

//#if 538375444 
return true;
//#endif 

} 

//#endif 


//#if 2056494853 
public QuotedStringSeparator(char q, char esc)
    { 

//#if -730117559 
super(q);
//#endif 


//#if 1395176878 
esced = false;
//#endif 


//#if -1394391426 
escChr = esc;
//#endif 


//#if -596186736 
startChr = 0;
//#endif 


//#if -1207971831 
stopChr = q;
//#endif 


//#if -977782186 
tokLen = 0;
//#endif 


//#if -1313149264 
level = 1;
//#endif 

} 

//#endif 


//#if -879703315 
public boolean endChar(char c)
    { 

//#if 198778955 
tokLen++;
//#endif 


//#if -1853911108 
if(esced)//1
{ 

//#if -1919134180 
esced = false;
//#endif 


//#if 413742115 
return false;
//#endif 

} 

//#endif 


//#if 68512487 
if(escChr != 0 && c == escChr)//1
{ 

//#if -317833688 
esced = true;
//#endif 


//#if 653205284 
return false;
//#endif 

} 

//#endif 


//#if -1381851123 
if(startChr != 0 && c == startChr)//1
{ 

//#if -1108443125 
level++;
//#endif 

} 

//#endif 


//#if 1847589584 
if(c == stopChr)//1
{ 

//#if 800726962 
level--;
//#endif 

} 

//#endif 


//#if 85665301 
return level <= 0;
//#endif 

} 

//#endif 


//#if -1293131378 
public void reset()
    { 

//#if -146545056 
super.reset();
//#endif 


//#if 1652565857 
tokLen = 0;
//#endif 


//#if -1089751995 
level = 1;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -2067345540 
public class MyTokenizer implements 
//#if 167982430 
Enumeration
//#endif 

  { 

//#if -1451317373 
public static final CustomSeparator SINGLE_QUOTED_SEPARATOR =
        new QuotedStringSeparator('\'', '\\');
//#endif 


//#if -322317497 
public static final CustomSeparator DOUBLE_QUOTED_SEPARATOR =
        new QuotedStringSeparator('\"', '\\');
//#endif 


//#if 2111620632 
public static final CustomSeparator PAREN_EXPR_SEPARATOR =
        new QuotedStringSeparator('(', ')', '\0');
//#endif 


//#if -42318179 
public static final CustomSeparator PAREN_EXPR_STRING_SEPARATOR =
        new ExprSeparatorWithStrings();
//#endif 


//#if 1696406116 
public static final CustomSeparator LINE_SEPARATOR =
        new LineSeparator();
//#endif 


//#if 2010074076 
private int sIdx;
//#endif 


//#if -1969013232 
private final int eIdx;
//#endif 


//#if 926422905 
private int tokIdx;
//#endif 


//#if -575719885 
private final String source;
//#endif 


//#if 408154230 
private final TokenSep delims;
//#endif 


//#if -1506912002 
private String savedToken;
//#endif 


//#if 2089992816 
private int savedIdx;
//#endif 


//#if -210489571 
private List customSeps;
//#endif 


//#if 1847402694 
private String putToken;
//#endif 


//#if -2044870121 
private static TokenSep parseDelimString(String str)
    { 

//#if 475311938 
TokenSep first = null;
//#endif 


//#if 732058242 
TokenSep p = null;
//#endif 


//#if -103650969 
int idx0, idx1, length;
//#endif 


//#if -1616562582 
StringBuilder val = new StringBuilder();
//#endif 


//#if -343151090 
char c;
//#endif 


//#if -380076416 
length = str.length();
//#endif 


//#if 382489514 
for (idx0 = 0; idx0 < length;) //1
{ 

//#if -608673740 
for (idx1 = idx0; idx1 < length; idx1++) //1
{ 

//#if -75542940 
c = str.charAt(idx1);
//#endif 


//#if -477954966 
if(c == '\\')//1
{ 

//#if 290985123 
idx1++;
//#endif 


//#if -1610656209 
if(idx1 < length)//1
{ 

//#if 86544722 
val.append(str.charAt(idx1));
//#endif 

} 

//#endif 

} 
else

//#if -1699529974 
if(c == ',')//1
{ 

//#if -760318048 
break;

//#endif 

} 
else
{ 

//#if -1593560740 
val.append(c);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -96189040 
idx1 = Math.min(idx1, length);
//#endif 


//#if 1372493767 
if(idx1 > idx0)//1
{ 

//#if 1478317265 
p = new TokenSep(val.toString());
//#endif 


//#if -925096353 
val = new StringBuilder();
//#endif 


//#if 417890684 
p.setNext(first);
//#endif 


//#if 1891689197 
first = p;
//#endif 

} 

//#endif 


//#if 815418244 
idx0 = idx1 + 1;
//#endif 

} 

//#endif 


//#if -1374754629 
return first;
//#endif 

} 

//#endif 


//#if 914494580 
public boolean hasMoreTokens()
    { 

//#if -1010410111 
return sIdx < eIdx || savedToken != null
               || putToken != null;
//#endif 

} 

//#endif 


//#if 619849887 
public void putToken(String s)
    { 

//#if 697599003 
if(s == null)//1
{ 

//#if -1419735246 
throw new NullPointerException(
                "Cannot put a null token");
//#endif 

} 

//#endif 


//#if -1024397961 
putToken = s;
//#endif 

} 

//#endif 


//#if -1180681647 
public boolean hasMoreElements()
    { 

//#if -472378737 
return hasMoreTokens();
//#endif 

} 

//#endif 


//#if -1070408685 
public int getTokenIndex()
    { 

//#if -1468668347 
return tokIdx;
//#endif 

} 

//#endif 


//#if 899176621 
public MyTokenizer(String string, String delim, Collection seps)
    { 

//#if 1643090586 
source = string;
//#endif 


//#if 1345404525 
delims = parseDelimString(delim);
//#endif 


//#if -435406932 
sIdx = 0;
//#endif 


//#if -1209250999 
tokIdx = 0;
//#endif 


//#if -1124395030 
eIdx = string.length();
//#endif 


//#if -2090223301 
savedToken = null;
//#endif 


//#if -584078381 
customSeps = new ArrayList(seps);
//#endif 

} 

//#endif 


//#if 980612902 
public MyTokenizer(String string, String delim)
    { 

//#if 900061044 
source = string;
//#endif 


//#if -1014626093 
delims = parseDelimString(delim);
//#endif 


//#if 1136022546 
sIdx = 0;
//#endif 


//#if 1400956463 
tokIdx = 0;
//#endif 


//#if -1238332976 
eIdx = string.length();
//#endif 


//#if 1117925269 
savedToken = null;
//#endif 


//#if -1354936375 
customSeps = null;
//#endif 


//#if 1850626317 
putToken = null;
//#endif 

} 

//#endif 


//#if 1781340900 
public String nextToken()
    { 

//#if -54900208 
CustomSeparator csep;
//#endif 


//#if 611685958 
TokenSep sep;
//#endif 


//#if 813788533 
String s = null;
//#endif 


//#if 1783526847 
int i, j;
//#endif 


//#if 1247152252 
if(putToken != null)//1
{ 

//#if 1964395690 
s = putToken;
//#endif 


//#if -623447810 
putToken = null;
//#endif 


//#if 1465217013 
return s;
//#endif 

} 

//#endif 


//#if -1651783612 
if(savedToken != null)//1
{ 

//#if 908254044 
s = savedToken;
//#endif 


//#if -1137789544 
tokIdx = savedIdx;
//#endif 


//#if -1808339572 
savedToken = null;
//#endif 


//#if 487550011 
return s;
//#endif 

} 

//#endif 


//#if -1473389648 
if(sIdx >= eIdx)//1
{ 

//#if -920394620 
throw new NoSuchElementException(
                "No more tokens available");
//#endif 

} 

//#endif 


//#if -575007820 
for (sep = delims; sep != null; sep = sep.getNext()) //1
{ 

//#if 808234143 
sep.reset();
//#endif 

} 

//#endif 


//#if 175353464 
if(customSeps != null)//1
{ 

//#if 1906570339 
for (i = 0; i < customSeps.size(); i++) //1
{ 

//#if 1126208732 
((CustomSeparator) customSeps.get(i)).reset();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -473819269 
for (i = sIdx; i < eIdx; i++) //1
{ 

//#if -1554314544 
char c = source.charAt(i);
//#endif 


//#if -269832646 
for (j = 0; customSeps != null
                    && j < customSeps.size(); j++) //1
{ 

//#if -226038136 
csep = (CustomSeparator) customSeps.get(j);
//#endif 


//#if -1646990190 
if(csep.addChar(c))//1
{ 

//#if 776200230 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -78441541 
if(customSeps != null && j < customSeps.size())//1
{ 

//#if 1084187210 
csep = (CustomSeparator) customSeps.get(j);
//#endif 


//#if -1990829064 
while (csep.hasFreePart() && i + 1 < eIdx)//1
{ 

//#if -1147866785 
if(csep.endChar(source.charAt(++i)))//1
{ 

//#if 1397842107 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1110555983 
i -= Math.min(csep.getPeekCount(), i);
//#endif 


//#if 566929404 
int clen = Math.min(i + 1, source.length());
//#endif 


//#if 1849324385 
if(i - sIdx + 1 > csep.tokenLength())//1
{ 

//#if 1523416120 
s = source.substring(sIdx,
                                         i - csep.tokenLength() + 1);
//#endif 


//#if -962936726 
savedIdx = i - csep.tokenLength() + 1;
//#endif 


//#if -2052589426 
savedToken = source.substring(
                                     savedIdx, clen);
//#endif 

} 
else
{ 

//#if 1226735118 
s = source.substring(sIdx, clen);
//#endif 

} 

//#endif 


//#if 194180782 
tokIdx = sIdx;
//#endif 


//#if 3084626 
sIdx = i + 1;
//#endif 


//#if 1172225001 
break;

//#endif 

} 

//#endif 


//#if -812938017 
for (sep = delims; sep != null; sep = sep.getNext())//1
{ 

//#if 1073601309 
if(sep.addChar(c))//1
{ 

//#if -1408156103 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 422438829 
if(sep != null)//1
{ 

//#if -2143067669 
if(i - sIdx + 1 > sep.length())//1
{ 

//#if 968912933 
s = source.substring(sIdx,
                                         i - sep.length() + 1);
//#endif 


//#if 567070275 
savedIdx = i - sep.length() + 1;
//#endif 


//#if 750109310 
savedToken = sep.getString();
//#endif 

} 
else
{ 

//#if -1468256351 
s = sep.getString();
//#endif 

} 

//#endif 


//#if -1604682962 
tokIdx = sIdx;
//#endif 


//#if 497671378 
sIdx = i + 1;
//#endif 


//#if -708599703 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1187823803 
if(s == null)//1
{ 

//#if -1683665269 
s = source.substring(sIdx);
//#endif 


//#if -436061326 
tokIdx = sIdx;
//#endif 


//#if -372585759 
sIdx = eIdx;
//#endif 

} 

//#endif 


//#if -1424244036 
return s;
//#endif 

} 

//#endif 


//#if -1446772202 
public MyTokenizer(String string, String delim, CustomSeparator sep)
    { 

//#if -1136862036 
source = string;
//#endif 


//#if 925047451 
delims = parseDelimString(delim);
//#endif 


//#if 1820474842 
sIdx = 0;
//#endif 


//#if 2029616631 
tokIdx = 0;
//#endif 


//#if 115062168 
eIdx = string.length();
//#endif 


//#if 2139932365 
savedToken = null;
//#endif 


//#if 1808343632 
customSeps = new ArrayList();
//#endif 


//#if 1647874789 
customSeps.add(sep);
//#endif 

} 

//#endif 


//#if 48447545 
public Object nextElement()
    { 

//#if -177623738 
return nextToken();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 779939737 
class LineSeparator extends 
//#if 1540638463 
CustomSeparator
//#endif 

  { 

//#if 1144846444 
private boolean hasCr;
//#endif 


//#if 1144854721 
private boolean hasLf;
//#endif 


//#if 251063041 
private boolean hasPeeked;
//#endif 


//#if -2102987721 
public boolean addChar(char c)
    { 

//#if -1486916021 
if(c == '\n')//1
{ 

//#if -1027101974 
hasLf = true;
//#endif 


//#if 1788430115 
return true;
//#endif 

} 

//#endif 


//#if -1372399417 
if(c == '\r')//1
{ 

//#if 1423731667 
hasCr = true;
//#endif 


//#if 684578007 
return true;
//#endif 

} 

//#endif 


//#if 1452382629 
return false;
//#endif 

} 

//#endif 


//#if 1530682301 
public boolean endChar(char c)
    { 

//#if -1173515431 
if(c == '\n')//1
{ 

//#if -27332654 
hasLf = true;
//#endif 

} 
else
{ 

//#if 2102861416 
hasPeeked = true;
//#endif 

} 

//#endif 


//#if 1496670802 
return true;
//#endif 

} 

//#endif 


//#if 299873886 
public void reset()
    { 

//#if 97167393 
super.reset();
//#endif 


//#if -692974257 
hasCr = false;
//#endif 


//#if 780917220 
hasLf = false;
//#endif 


//#if -1736384604 
hasPeeked = false;
//#endif 

} 

//#endif 


//#if 1394154708 
public LineSeparator()
    { 

//#if 1399490888 
hasCr = false;
//#endif 


//#if -1421584931 
hasLf = false;
//#endif 


//#if -868698339 
hasPeeked = false;
//#endif 

} 

//#endif 


//#if 1582704975 
public int tokenLength()
    { 

//#if -936645588 
return hasCr && hasLf ? 2 : 1;
//#endif 

} 

//#endif 


//#if 804737872 
public int getPeekCount()
    { 

//#if 1018604689 
return hasPeeked ? 1 : 0;
//#endif 

} 

//#endif 


//#if 959502128 
public boolean hasFreePart()
    { 

//#if 1001645748 
return !hasLf;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

