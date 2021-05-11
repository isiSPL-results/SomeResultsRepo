package org.argouml.util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;
class ExprSeparatorWithStrings extends CustomSeparator
  { 
private boolean isSQuot;
private boolean isDQuot;
private boolean isEsc;
private int tokLevel;
private int tokLen;
public boolean hasFreePart()
    { 
return true;
} 
public ExprSeparatorWithStrings()
    { 
super('(');
isEsc = false;
isSQuot = false;
isDQuot = false;
tokLevel = 1;
tokLen = 0;
} 
public int tokenLength()
    { 
return super.tokenLength() + tokLen;
} 
public boolean endChar(char c)
    { 
tokLen++;
if(isSQuot)//1
{ 
if(isEsc)//1
{ 
isEsc = false;
return false;
} 
if(c == '\\')//1
{ 
isEsc = true;
} 
else
if(c == '\'')//1
{ 
isSQuot = false;
} 
return false;
} 
else
if(isDQuot)//1
{ 
if(isEsc)//1
{ 
isEsc = false;
return false;
} 
if(c == '\\')//1
{ 
isEsc = true;
} 
else
if(c == '\"')//1
{ 
isDQuot = false;
} 
return false;
} 
else
{ 
if(c == '\'')//1
{ 
isSQuot = true;
} 
else
if(c == '\"')//1
{ 
isDQuot = true;
} 
else
if(c == '(')//1
{ 
tokLevel++;
} 
else
if(c == ')')//1
{ 
tokLevel--;
} 
return tokLevel <= 0;
} 
} 
public void reset()
    { 
super.reset();
isEsc = false;
isSQuot = false;
isDQuot = false;
tokLevel = 1;
tokLen = 0;
} 

 } 
class TokenSep  { 
private TokenSep next = null;
private final String theString;
private final int length;
private int pattern;
public void reset()
    { 
pattern = 0;
} 
public TokenSep getNext()
    { 
return next;
} 
public String getString()
    { 
return theString;
} 
public int length()
    { 
return length;
} 
public boolean addChar(char c)
    { 
int i;
pattern <<= 1;
pattern |= 1;
for (i = 0; i < length; i++) //1
{ 
if(theString.charAt(i) != c)//1
{ 
pattern &= ~(1 << i);
} 
} 
return (pattern & (1 << (length - 1))) != 0;
} 
public TokenSep(String str)
    { 
theString = str;
length = str.length();
if(length > 32)//1
{ 
throw new IllegalArgumentException("TokenSep " + str
                                               + " is " + length + " (> 32) chars long");
} 
pattern = 0;
} 
public void setNext(TokenSep n)
    { 
this.next = n;
} 

 } 
class QuotedStringSeparator extends CustomSeparator
  { 
private final char escChr;
private final char startChr;
private final char stopChr;
private boolean esced;
private int tokLen;
private int level;
public QuotedStringSeparator(char sq, char eq, char esc)
    { 
super(sq);
esced = false;
escChr = esc;
startChr = sq;
stopChr = eq;
tokLen = 0;
level = 1;
} 
public int tokenLength()
    { 
return super.tokenLength() + tokLen;
} 
public boolean hasFreePart()
    { 
return true;
} 
public QuotedStringSeparator(char q, char esc)
    { 
super(q);
esced = false;
escChr = esc;
startChr = 0;
stopChr = q;
tokLen = 0;
level = 1;
} 
public boolean endChar(char c)
    { 
tokLen++;
if(esced)//1
{ 
esced = false;
return false;
} 
if(escChr != 0 && c == escChr)//1
{ 
esced = true;
return false;
} 
if(startChr != 0 && c == startChr)//1
{ 
level++;
} 
if(c == stopChr)//1
{ 
level--;
} 
return level <= 0;
} 
public void reset()
    { 
super.reset();
tokLen = 0;
level = 1;
} 

 } 
public class MyTokenizer implements Enumeration
  { 
public static final CustomSeparator SINGLE_QUOTED_SEPARATOR =
        new QuotedStringSeparator('\'', '\\');
public static final CustomSeparator DOUBLE_QUOTED_SEPARATOR =
        new QuotedStringSeparator('\"', '\\');
public static final CustomSeparator PAREN_EXPR_SEPARATOR =
        new QuotedStringSeparator('(', ')', '\0');
public static final CustomSeparator PAREN_EXPR_STRING_SEPARATOR =
        new ExprSeparatorWithStrings();
public static final CustomSeparator LINE_SEPARATOR =
        new LineSeparator();
private int sIdx;
private final int eIdx;
private int tokIdx;
private final String source;
private final TokenSep delims;
private String savedToken;
private int savedIdx;
private List customSeps;
private String putToken;
private static TokenSep parseDelimString(String str)
    { 
TokenSep first = null;
TokenSep p = null;
int idx0, idx1, length;
StringBuilder val = new StringBuilder();
char c;
length = str.length();
for (idx0 = 0; idx0 < length;) //1
{ 
for (idx1 = idx0; idx1 < length; idx1++) //1
{ 
c = str.charAt(idx1);
if(c == '\\')//1
{ 
idx1++;
if(idx1 < length)//1
{ 
val.append(str.charAt(idx1));
} 
} 
else
if(c == ',')//1
{ 
break;

} 
else
{ 
val.append(c);
} 
} 
idx1 = Math.min(idx1, length);
if(idx1 > idx0)//1
{ 
p = new TokenSep(val.toString());
val = new StringBuilder();
p.setNext(first);
first = p;
} 
idx0 = idx1 + 1;
} 
return first;
} 
public boolean hasMoreTokens()
    { 
return sIdx < eIdx || savedToken != null
               || putToken != null;
} 
public void putToken(String s)
    { 
if(s == null)//1
{ 
throw new NullPointerException(
                "Cannot put a null token");
} 
putToken = s;
} 
public boolean hasMoreElements()
    { 
return hasMoreTokens();
} 
public int getTokenIndex()
    { 
return tokIdx;
} 
public MyTokenizer(String string, String delim, Collection seps)
    { 
source = string;
delims = parseDelimString(delim);
sIdx = 0;
tokIdx = 0;
eIdx = string.length();
savedToken = null;
customSeps = new ArrayList(seps);
} 
public MyTokenizer(String string, String delim)
    { 
source = string;
delims = parseDelimString(delim);
sIdx = 0;
tokIdx = 0;
eIdx = string.length();
savedToken = null;
customSeps = null;
putToken = null;
} 
public String nextToken()
    { 
CustomSeparator csep;
TokenSep sep;
String s = null;
int i, j;
if(putToken != null)//1
{ 
s = putToken;
putToken = null;
return s;
} 
if(savedToken != null)//1
{ 
s = savedToken;
tokIdx = savedIdx;
savedToken = null;
return s;
} 
if(sIdx >= eIdx)//1
{ 
throw new NoSuchElementException(
                "No more tokens available");
} 
for (sep = delims; sep != null; sep = sep.getNext()) //1
{ 
sep.reset();
} 
if(customSeps != null)//1
{ 
for (i = 0; i < customSeps.size(); i++) //1
{ 
((CustomSeparator) customSeps.get(i)).reset();
} 
} 
for (i = sIdx; i < eIdx; i++) //1
{ 
char c = source.charAt(i);
for (j = 0; customSeps != null
                    && j < customSeps.size(); j++) //1
{ 
csep = (CustomSeparator) customSeps.get(j);
if(csep.addChar(c))//1
{ 
break;

} 
} 
if(customSeps != null && j < customSeps.size())//1
{ 
csep = (CustomSeparator) customSeps.get(j);
while (csep.hasFreePart() && i + 1 < eIdx)//1
{ 
if(csep.endChar(source.charAt(++i)))//1
{ 
break;

} 
} 
i -= Math.min(csep.getPeekCount(), i);
int clen = Math.min(i + 1, source.length());
if(i - sIdx + 1 > csep.tokenLength())//1
{ 
s = source.substring(sIdx,
                                         i - csep.tokenLength() + 1);
savedIdx = i - csep.tokenLength() + 1;
savedToken = source.substring(
                                     savedIdx, clen);
} 
else
{ 
s = source.substring(sIdx, clen);
} 
tokIdx = sIdx;
sIdx = i + 1;
break;

} 
for (sep = delims; sep != null; sep = sep.getNext())//1
{ 
if(sep.addChar(c))//1
{ 
break;

} 
} 
if(sep != null)//1
{ 
if(i - sIdx + 1 > sep.length())//1
{ 
s = source.substring(sIdx,
                                         i - sep.length() + 1);
savedIdx = i - sep.length() + 1;
savedToken = sep.getString();
} 
else
{ 
s = sep.getString();
} 
tokIdx = sIdx;
sIdx = i + 1;
break;

} 
} 
if(s == null)//1
{ 
s = source.substring(sIdx);
tokIdx = sIdx;
sIdx = eIdx;
} 
return s;
} 
public MyTokenizer(String string, String delim, CustomSeparator sep)
    { 
source = string;
delims = parseDelimString(delim);
sIdx = 0;
tokIdx = 0;
eIdx = string.length();
savedToken = null;
customSeps = new ArrayList();
customSeps.add(sep);
} 
public Object nextElement()
    { 
return nextToken();
} 

 } 
class LineSeparator extends CustomSeparator
  { 
private boolean hasCr;
private boolean hasLf;
private boolean hasPeeked;
public boolean addChar(char c)
    { 
if(c == '\n')//1
{ 
hasLf = true;
return true;
} 
if(c == '\r')//1
{ 
hasCr = true;
return true;
} 
return false;
} 
public boolean endChar(char c)
    { 
if(c == '\n')//1
{ 
hasLf = true;
} 
else
{ 
hasPeeked = true;
} 
return true;
} 
public void reset()
    { 
super.reset();
hasCr = false;
hasLf = false;
hasPeeked = false;
} 
public LineSeparator()
    { 
hasCr = false;
hasLf = false;
hasPeeked = false;
} 
public int tokenLength()
    { 
return hasCr && hasLf ? 2 : 1;
} 
public int getPeekCount()
    { 
return hasPeeked ? 1 : 0;
} 
public boolean hasFreePart()
    { 
return !hasLf;
} 

 } 
