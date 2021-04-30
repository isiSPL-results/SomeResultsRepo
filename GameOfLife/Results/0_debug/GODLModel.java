
//#if 831653292 
// Compilation Unit of /GODLModel.java 
 

//#if -311782501 
import java.util.Iterator;
//#endif 


//#if -554253258 
import java.util.ArrayList;
//#endif 


//#if -1483563912 
import java.util.Collections;
//#endif 


//#if -424794005 
import java.util.List;
//#endif 


//#if -2021127674 
import generator.FormGeneratorStrategy;
//#endif 


//#if 977451170 
import generator.GeneratorStrategy;
//#endif 


//#if -506324011 
import generator.ClearGeneratorStrategy;
//#endif 


//#if -1842022574 
import java.util.LinkedList;
//#endif 


//#if -728306322 
class GODLModel  { 

//#if -1017024195 
private GeneratorStrategy generator = null;
//#endif 


//#if 821309053 
public void generate()
    { 

//#if -1854062487 
if(generator == null)//1
{ 

//#if -917754090 
generator = new ClearGeneratorStrategy();
//#endif 

} 

//#endif 


//#if 1147856905 
Playground newGround = new Playground(playground.getXSize(), playground.getYSize(), 0);
//#endif 


//#if 406581419 
Iterator it = playground.iterator();
//#endif 


//#if -946983620 
while(it.hasNext()) //1
{ 

//#if 1899350236 
LifeForm current = (LifeForm) it.next();
//#endif 


//#if -358311737 
newGround.set(current.getX(), current.getY(), generator.getNext(current.getX(), current.getY()));
//#endif 

} 

//#endif 


//#if -1823271016 
this.playground = newGround;
//#endif 


//#if -1530735752 
notifyObservers();
//#endif 

} 

//#endif 


//#if 1945222912 
public List getGeneratorStrategies()
    { 

//#if 1556741942 
return java.util.Collections.unmodifiableList(this.generators);
//#endif 

} 

//#endif 


//#if -1800626848 
GODLModel  (int xSize, int ySize, RuleSet rules)
    { 

//#if 916074170 
for (int i = 0;  i < generators.size(); i++) //1
{ 

//#if 674669309 
if(generators.get(i) instanceof FormGeneratorStrategy)//1
{ 

//#if -463266518 
generator = (GeneratorStrategy) generators.get(i);
//#endif 


//#if 1296578126 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 475682822 
FormGeneratorStrategy fgs = new FormGeneratorStrategy(playground.getXSize(), playground.getYSize());
//#endif 


//#if -2124198235 
generators.add(fgs);
//#endif 


//#if 310319853 
generators.add(new ClearGeneratorStrategy());
//#endif 

} 

//#endif 


//#if 1732445804 
public void setGenerator(GeneratorStrategy generator)
    { 

//#if -686356629 
this.generator = generator;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -36501929 
public class GODLModel extends 
//#if 219627282 
ModelObservable
//#endif 

  { 

//#if 1182704257 
private RuleSet rules;
//#endif 


//#if -64307364 
private Playground playground;
//#endif 


//#if 436368436 
private List generators;
//#endif 


//#if -503494803 
private GeneratorStrategy generator = null;
//#endif 


//#if -641157771 
private final LinkedList undoList;
//#endif 


//#if 1980814491 
private final LinkedList redoList;
//#endif 


//#if 1300729878 
public void redo()
    { 

//#if -284245977 
undoList.push((Object) playground);
//#endif 


//#if -1095246871 
playground = (Playground) redoList.pop();
//#endif 


//#if -1655113412 
notifyObservers();
//#endif 

} 

//#endif 


//#if 1394929020 
public void undo()
    { 

//#if -176643956 
redoList.push((Object) playground);
//#endif 


//#if -1778541426 
playground = (Playground) undoList.pop();
//#endif 


//#if 1816180743 
notifyObservers();
//#endif 

} 

//#endif 


//#if 719854279 
public GODLModel(int xSize, int ySize, RuleSet rules)
    { 

//#if -2053621413 
this.undoList = new LinkedList();
//#endif 


//#if 486100097 
this.redoList = new LinkedList();
//#endif 


//#if 967044945 
for (int i = 0;  i < generators.size(); i++) //1
{ 

//#if -1687566110 
if(generators.get(i) instanceof FormGeneratorStrategy)//1
{ 

//#if -789317541 
generator = (GeneratorStrategy) generators.get(i);
//#endif 


//#if -981316611 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 983645007 
FormGeneratorStrategy fgs = new FormGeneratorStrategy(playground.getXSize(), playground.getYSize());
//#endif 


//#if 9950972 
generators.add(fgs);
//#endif 


//#if -888811964 
generators.add(new ClearGeneratorStrategy());
//#endif 


//#if 873902605 
this.rules = rules;
//#endif 


//#if 397659377 
this.playground = new Playground(xSize, ySize, 0);
//#endif 


//#if -1837414295 
this.generators = new java.util.ArrayList();
//#endif 

} 

//#endif 


//#if -1393044319 
public void setPlayground(int[][] pg)
    { 

//#if -450139070 
Playground newGround = new Playground(pg.length, pg[0].length, 0);
//#endif 


//#if -925625875 
for(int i = 0; i < pg.length; i++) //1
{ 

//#if 1216505747 
for(int j = 0; j < pg[i].length; j++) //1
{ 

//#if -278593758 
newGround.set(i, j, pg[i][j]);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -914825694 
this.playground = newGround;
//#endif 


//#if -2030779390 
notifyObservers();
//#endif 

} 

//#endif 


//#if 548218445 
public void generate()
    { 

//#if 1676142529 
if(generator == null)//1
{ 

//#if 56764449 
generator = new ClearGeneratorStrategy();
//#endif 

} 

//#endif 


//#if -222705231 
Playground newGround = new Playground(playground.getXSize(), playground.getYSize(), 0);
//#endif 


//#if 126075475 
Iterator it = playground.iterator();
//#endif 


//#if -1711745900 
while(it.hasNext()) //1
{ 

//#if -1663476895 
LifeForm current = (LifeForm) it.next();
//#endif 


//#if 297863948 
newGround.set(current.getX(), current.getY(), generator.getNext(current.getX(), current.getY()));
//#endif 

} 

//#endif 


//#if 1458197232 
this.playground = newGround;
//#endif 


//#if 1888937680 
notifyObservers();
//#endif 

} 

//#endif 


//#if 930400976 
public List getGeneratorStrategies()
    { 

//#if 1018120557 
return java.util.Collections.unmodifiableList(this.generators);
//#endif 

} 

//#endif 


//#if 1736116001 
public String toString()
    { 

//#if 295699356 
StringBuilder sb = new StringBuilder();
//#endif 


//#if -166120852 
sb.append(playground);
//#endif 


//#if -1793953137 
return sb.toString();
//#endif 

} 

//#endif 


//#if -1198778147 
public boolean equals(Object o)
    { 

//#if -478580379 
if(o == null)//1
{ 

//#if -287442956 
return false;
//#endif 

} 
else

//#if 334898497 
if(o instanceof GODLModel)//1
{ 

//#if -2068341489 
GODLModel ogm = (GODLModel) o;
//#endif 


//#if 670589345 
return playground.equals(ogm.playground) && rules.equals(ogm.rules);
//#endif 

} 
else
{ 

//#if 1699348813 
return false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1313418655 
public boolean undoAvailable()
    { 

//#if -542773729 
return undoList != null && !undoList.isEmpty();
//#endif 

} 

//#endif 


//#if -1314402078 
public int[][] getPlayground()
    { 

//#if 1579532388 
return playground.getField();
//#endif 

} 

//#endif 


//#if -1688964548 
public void setGenerator(GeneratorStrategy generator)
    { 

//#if -397294638 
this.generator = generator;
//#endif 

} 

//#endif 


//#if -1286046457 
public boolean redoAvailable()
    { 

//#if -1871367480 
return redoList != null && !redoList.isEmpty();
//#endif 

} 

//#endif 


//#if 1019565003 
public void setLifeform(int x, int y, int value)
    { 

//#if 1385465885 
playground.set(x, y, value);
//#endif 


//#if -1858948128 
notifyObservers();
//#endif 

} 

//#endif 


//#if -323880317 
public void nextGeneration()
    { 

//#if 973929349 
Playground newGround = new Playground(playground.getXSize(), playground.getYSize(), playground.getGeneration() + 1);
//#endif 


//#if 1611063443 
Iterator it = playground.iterator();
//#endif 


//#if 1815748180 
while(it.hasNext()) //1
{ 

//#if 17686109 
LifeForm current = (LifeForm) it.next();
//#endif 


//#if -1868695181 
newGround.set(current.getX(), current.getY(),  rules.apply(current));
//#endif 

} 

//#endif 


//#if 804306096 
this.playground = newGround;
//#endif 


//#if -863825776 
notifyObservers();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

