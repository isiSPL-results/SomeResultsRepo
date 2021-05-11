package org.argouml.util;
public class CustomSeparator  { 
private char pattern[];
private char match[];
public CustomSeparator(char start)
    { 
pattern = new char[1];
pattern[0] = start;
match = new char[pattern.length];
} 
public int getPeekCount()
    { 
return 0;
} 
public boolean hasFreePart()
    { 
return false;
} 
public void reset()
    { 
int i;
for (i = 0; i < match.length; i++) //1
{ 
match[i] = 0;
} 
} 
public int tokenLength()
    { 
return pattern.length;
} 
public boolean addChar(char c)
    { 
int i;
for (i = 0; i < match.length - 1; i++) //1
{ 
match[i] = match[i + 1];
} 
match[match.length - 1] = c;
for (i = 0; i < match.length; i++)//1
{ 
if(match[i] != pattern[i])//1
{ 
return false;
} 
} 
return true;
} 
public CustomSeparator(String start)
    { 
pattern = start.toCharArray();
match = new char[pattern.length];
} 
protected CustomSeparator()
    { 
pattern = new char[0];
match = pattern;
} 
public boolean endChar(char c)
    { 
return true;
} 

 } 
