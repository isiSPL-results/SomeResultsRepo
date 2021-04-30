
//#if -253110205 
// Compilation Unit of /Field.java 
 

//#if -1075761817 
package p;
//#endif 


//#if 521987029 
import java.util.LinkedList;
//#endif 


//#if 152466222 
import java.util.List;
//#endif 


//#if 407791773 
import java.io.IOException;
//#endif 


//#if 1325925211 
import java.io.ObjectInputStream;
//#endif 


//#if 399100912 
import java.io.ObjectOutputStream;
//#endif 


//#if 232855377 
import java.io.Serializable;
//#endif 


//#if -356723723 
public class Field implements 
//#if 1076303216 
Cloneable
//#endif 

, 
//#if -1750202074 
Serializable
//#endif 

  { 

//#if -701162465 
public static int POSSIBILITIES = 9;
//#endif 


//#if -370841382 
protected boolean set;
//#endif 


//#if -262433380 
protected boolean initialSet;
//#endif 


//#if 166402162 
protected int value;
//#endif 


//#if -196412572 
@p.R4Feature(p.R4Feature.SOLVER)
    protected List remainingPos;
//#endif 


//#if -1121199049 

//#if -2065196944 
@p.R4Feature(p.R4Feature.GENERATOR)
//#endif 


    public void setInitial(boolean flag)
    { 

//#if -1666750283 
initialSet = flag;
//#endif 

} 

//#endif 


//#if 290071817 
public Field(int value)
    { 

//#if 816263711 
this.value = value;
//#endif 


//#if 2100795529 
this.set = true;
//#endif 


//#if 1250629134 
this.initialSet = false;
//#endif 


//#if -1551731209 
if(p.R4Feature.SOLVER)//1
{ 

//#if -1027174724 
remainingPos = new LinkedList();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1764814606 

//#if -2127685647 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public String toString()
    { 

//#if -1456258968 
String output = "";
//#endif 


//#if 1351972911 
if(remainingPos.isEmpty())//1
{ 

//#if 982904405 
output = "[" + value + "]";
//#endif 

} 
else
{ 

//#if -1890644570 
output = "{";
//#endif 


//#if -974595058 
for (int i = 0; i < remainingPos.size(); i++) //1
{ 

//#if 999013670 
output += remainingPos.get(i).toString();
//#endif 

} 

//#endif 


//#if 1026606159 
output += "}";
//#endif 

} 

//#endif 


//#if 531965138 
return output;
//#endif 

} 

//#endif 


//#if 261063083 
public Field()
    { 

//#if -489781850 
this.initialSet = false;
//#endif 


//#if 584883780 
this.set = false;
//#endif 


//#if -1290158241 
if(p.R4Feature.SOLVER)//1
{ 

//#if -1172945209 
remainingPos = new LinkedList();
//#endif 


//#if -224626209 
for (int i = 1; i <= POSSIBILITIES; i++)
               // #if SOLVER
            //1
{ 

//#if 43980308 
remainingPos.add((Object) i);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 788313211 

//#if -1029386927 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    private void writeObject(ObjectOutputStream aOutputStream)
    throws IOException
    { 

//#if -504022423 
aOutputStream.writeBoolean(set);
//#endif 


//#if -491876037 
aOutputStream.writeBoolean(initialSet);
//#endif 


//#if -1406317121 
aOutputStream.writeInt(value);
//#endif 


//#if -1241125175 
aOutputStream.defaultWriteObject();
//#endif 

} 

//#endif 


//#if 1536332155 
public int getValue()
    { 

//#if -1303485537 
return value;
//#endif 

} 

//#endif 


//#if 1603130122 

//#if 1450899208 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    private void readObject(ObjectInputStream aInputStream)
    throws ClassNotFoundException, IOException
    { 

//#if -98633728 
aInputStream.defaultReadObject();
//#endif 


//#if 1521287913 
set = aInputStream.readBoolean();
//#endif 


//#if 538068919 
initialSet = aInputStream.readBoolean();
//#endif 


//#if 2126366609 
value = aInputStream.readInt();
//#endif 

} 

//#endif 


//#if 1530248783 
public Field(int value, boolean initialSet)
    { 

//#if -1431511831 
this.value = value;
//#endif 


//#if 566030847 
this.set = true;
//#endif 


//#if -171199759 
this.initialSet = initialSet;
//#endif 


//#if -1203915071 
if(p.R4Feature.SOLVER)//1
{ 

//#if -1847748020 
remainingPos = new LinkedList();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 308681409 
public boolean isInitialSet()
    { 

//#if -1834051920 
return initialSet;
//#endif 

} 

//#endif 


//#if -1977784249 

//#if -1812517403 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public List getRemainingPos()
    { 

//#if 331080101 
return remainingPos;
//#endif 

} 

//#endif 


//#if 125771873 
public boolean isSet()
    { 

//#if 891288613 
return set;
//#endif 

} 

//#endif 


//#if -378729233 

//#if 1178652519 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public Field(List remainingPos)
    { 

//#if 1424231347 
this.remainingPos = remainingPos;
//#endif 

} 

//#endif 


//#if -109114509 

//#if 1803676756 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    public Object clone() throws CloneNotSupportedException
    { 

//#if 1176410633 
Field clone = new Field();
//#endif 


//#if 1410690130 
clone.initialSet = initialSet;
//#endif 


//#if -1207670936 
clone.set = set;
//#endif 


//#if 1791732618 
clone.value = value;
//#endif 


//#if 1037212635 
if(p.R4Feature.SOLVER)//1
{ 

//#if -325465401 
LinkedList remainingPosClone = new LinkedList();
//#endif 


//#if 1039570650 
for (int i = 0; i < remainingPos.size(); i++)
               // #if SOLVER
            //1
{ 

//#if -1076007308 
remainingPosClone.add(new Integer(((Integer) remainingPos.get(i))
                                                  .intValue()));
//#endif 

} 

//#endif 


//#if -1798252773 
clone.remainingPos = remainingPosClone;
//#endif 

} 

//#endif 


//#if 1600248753 
return clone;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

