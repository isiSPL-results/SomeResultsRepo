package p;
import java.util.LinkedList;
import java.util.List;
public class Field  { 
public static int POSSIBILITIES = 9;
protected boolean set;
protected boolean initialSet;
protected int value;
public Field(int value)
    { 
this.value = value;
this.set = true;
this.initialSet = false;
} 
public Field()
    { 
this.initialSet = false;
this.set = false;
} 
public int getValue()
    { 
return value;
} 
public Field(int value, boolean initialSet)
    { 
this.value = value;
this.set = true;
this.initialSet = initialSet;
} 
public boolean isInitialSet()
    { 
return initialSet;
} 
public boolean isSet()
    { 
return set;
} 

 } 
