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
@p.R4Feature(p.R4Feature.SOLVER)
    protected List remainingPos;
@p.R4Feature(p.R4Feature.GENERATOR)

    public void setInitial(boolean flag)
    { 
initialSet = flag;
} 
public Field(int value)
    { 
this.value = value;
this.set = true;
this.initialSet = false;
if(p.R4Feature.SOLVER)//1
{ 
remainingPos = new LinkedList();
} 
} 
@p.R4Feature(p.R4Feature.SOLVER)

    public String toString()
    { 
String output = "";
if(remainingPos.isEmpty())//1
{ 
output = "[" + value + "]";
} 
else
{ 
output = "{";
for (int i = 0; i < remainingPos.size(); i++) //1
{ 
output += remainingPos.get(i).toString();
} 
output += "}";
} 
return output;
} 
public Field()
    { 
this.initialSet = false;
this.set = false;
if(p.R4Feature.SOLVER)//1
{ 
remainingPos = new LinkedList();
for (int i = 1; i <= POSSIBILITIES; i++)
               // #if SOLVER
            //1
{ 
remainingPos.add((Object) i);
} 
} 
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
if(p.R4Feature.SOLVER)//1
{ 
remainingPos = new LinkedList();
} 
} 
public boolean isInitialSet()
    { 
return initialSet;
} 
@p.R4Feature(p.R4Feature.SOLVER)

    public List getRemainingPos()
    { 
return remainingPos;
} 
public boolean isSet()
    { 
return set;
} 
@p.R4Feature(p.R4Feature.SOLVER)

    public Field(List remainingPos)
    { 
this.remainingPos = remainingPos;
} 
@p.R4Feature(p.R4Feature.STATES)

    public Object clone() throws CloneNotSupportedException
    { 
Field clone = new Field();
clone.initialSet = initialSet;
clone.set = set;
clone.value = value;
if(p.R4Feature.SOLVER)//1
{ 
LinkedList remainingPosClone = new LinkedList();
for (int i = 0; i < remainingPos.size(); i++)
               // #if SOLVER
            //1
{ 
remainingPosClone.add(new Integer(((Integer) remainingPos.get(i))
                                                  .intValue()));
} 
clone.remainingPos = remainingPosClone;
} 
return clone;
} 

 } 
