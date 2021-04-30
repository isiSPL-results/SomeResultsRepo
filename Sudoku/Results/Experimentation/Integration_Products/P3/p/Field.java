package p;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Field implements Cloneable
,Serializable
  { 
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
@p.R4Feature(p.R4Feature.STATES)

    private void writeObject(ObjectOutputStream aOutputStream)
    throws IOException
    { 
aOutputStream.writeBoolean(set);
aOutputStream.writeBoolean(initialSet);
aOutputStream.writeInt(value);
aOutputStream.defaultWriteObject();
} 
public int getValue()
    { 
return value;
} 
@p.R4Feature(p.R4Feature.STATES)

    private void readObject(ObjectInputStream aInputStream)
    throws ClassNotFoundException, IOException
    { 
aInputStream.defaultReadObject();
set = aInputStream.readBoolean();
initialSet = aInputStream.readBoolean();
value = aInputStream.readInt();
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
@p.R4Feature(p.R4Feature.STATES)

    public Object clone() throws CloneNotSupportedException
    { 
Field clone = new Field();
clone.initialSet = initialSet;
clone.set = set;
clone.value = value;
return clone;
} 

 } 
