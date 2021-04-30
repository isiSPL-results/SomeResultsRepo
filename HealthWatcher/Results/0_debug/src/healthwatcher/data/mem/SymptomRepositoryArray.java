
//#if -387639283 
// Compilation Unit of /SymptomRepositoryArray.java 
 

//#if 808406572 
package healthwatcher.data.mem;
//#endif 


//#if 1426908374 
import healthwatcher.data.ISymptomRepository;
//#endif 


//#if -1564633917 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if -1324460201 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 240417824 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 1580445340 
import lib.exceptions.RepositoryException;
//#endif 


//#if -1915790522 
import java.util.Arrays;
//#endif 


//#if -1531458080 
import lib.util.ConcreteIterator;
//#endif 


//#if -1194943691 
import lib.util.IteratorDsk;
//#endif 


//#if -1946868065 
public class SymptomRepositoryArray implements 
//#if 25597142 
ISymptomRepository
//#endif 

  { 

//#if -1087798841 
private Symptom[] vetor;
//#endif 


//#if 1410242839 
private int indice;
//#endif 


//#if 611279165 
private int ponteiro;
//#endif 


//#if 1894627713 
private int getIndex(int code)
    { 

//#if -1986956970 
int temp;
//#endif 


//#if 1440592735 
boolean flag = false;
//#endif 


//#if 1043915184 
int i = 0;
//#endif 


//#if -978127143 
while ((!flag) && (i < indice)) //1
{ 

//#if -519294858 
temp = vetor[i].getCode();
//#endif 


//#if -1472552717 
if(temp == code)//1
{ 

//#if -1564286378 
flag = true;
//#endif 

} 
else
{ 

//#if 1617294294 
i = i + 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1417147168 
return i;
//#endif 

} 

//#endif 


//#if -1451987161 
public void reset()
    { 

//#if -399262682 
this.ponteiro = 0;
//#endif 

} 

//#endif 


//#if 47222773 
public void insert(Symptom symptom) throws RepositoryException, ObjectAlreadyInsertedException
    { 

//#if 1669612966 
if(symptom == null)//1
{ 

//#if 880973821 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 1514033512 
this.vetor[indice] = symptom;
//#endif 


//#if -323916842 
indice++;
//#endif 

} 

//#endif 


//#if -1836691870 
public IteratorDsk getSymptomList() throws RepositoryException,	ObjectNotFoundException
    { 

//#if 924631750 
return new ConcreteIterator(Arrays.asList(vetor));
//#endif 

} 

//#endif 


//#if 1667617765 
public void remove(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if 1380629838 
int i = getIndex(code);
//#endif 


//#if 2089974776 
if(i == indice)//1
{ 

//#if -403789547 
throw new ObjectNotFoundException("Symptom not found");
//#endif 

} 
else
{ 

//#if 635212585 
vetor[i] = vetor[indice - 1];
//#endif 


//#if -1026031864 
indice = indice - 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1287691272 
public Object next()
    { 

//#if -1359209508 
if(ponteiro >= indice)//1
{ 

//#if 1423487198 
return null;
//#endif 

} 
else
{ 

//#if -992024058 
return vetor[ponteiro++];
//#endif 

} 

//#endif 

} 

//#endif 


//#if 7432068 
public void update(Symptom s) throws RepositoryException, ObjectNotFoundException
    { 

//#if -820212060 
int i = getIndex(s.getCode());
//#endif 


//#if -111325728 
if(i == indice)//1
{ 

//#if -364310812 
throw new ObjectNotFoundException("Symptom not found");
//#endif 

} 
else
{ 

//#if -2022448673 
vetor[i] = s;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1919788276 
public Symptom search(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if 565949113 
Symptom response = null;
//#endif 


//#if -1855954576 
int i = getIndex(code);
//#endif 


//#if -70024934 
if(i == indice)//1
{ 

//#if 610257502 
throw new ObjectNotFoundException("Symptom not found");
//#endif 

} 
else
{ 

//#if 620284983 
response = vetor[i];
//#endif 

} 

//#endif 


//#if 399085154 
return response;
//#endif 

} 

//#endif 


//#if 561811612 
public SymptomRepositoryArray()
    { 

//#if -664892393 
vetor = new Symptom[100];
//#endif 


//#if -1131735209 
indice = 0;
//#endif 

} 

//#endif 


//#if 1008464286 
public boolean exists(int codigo) throws RepositoryException
    { 

//#if -597787352 
boolean flag = false;
//#endif 


//#if -470238307 
for (int i = 0; i < indice; i++) //1
{ 

//#if 527050510 
if(this.vetor[i].getCode() == codigo)//1
{ 

//#if -482494340 
flag = true;
//#endif 


//#if -844183844 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 503834552 
return flag;
//#endif 

} 

//#endif 


//#if 970543483 
public boolean hasNext()
    { 

//#if -91223738 
return ponteiro < indice;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

