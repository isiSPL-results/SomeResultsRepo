
//#if -239883405 
// Compilation Unit of /DiseaseTypeRepositoryArray.java 
 

//#if 131829543 
package healthwatcher.data.mem;
//#endif 


//#if -616116898 
import healthwatcher.data.IDiseaseRepository;
//#endif 


//#if -626890383 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if 661548715 
import java.util.Arrays;
//#endif 


//#if 1688984082 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 178570693 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -987304513 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 931959489 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1113046043 
import lib.util.ConcreteIterator;
//#endif 


//#if 2083746842 
import lib.util.IteratorDsk;
//#endif 


//#if -1464756105 
public class DiseaseTypeRepositoryArray implements 
//#if -2126178615 
IDiseaseRepository
//#endif 

  { 

//#if 1410288468 
private DiseaseType[] vetor;
//#endif 


//#if -2031631689 
private int indice;
//#endif 


//#if 94675677 
private int ponteiro;
//#endif 


//#if -1906372159 
public DiseaseType search(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if 125210468 
DiseaseType response = null;
//#endif 


//#if -312160270 
int i = getIndex(code);
//#endif 


//#if -121143140 
if(i == indice)//1
{ 

//#if 663325104 
throw new ObjectNotFoundException("Disease not found");
//#endif 

} 
else
{ 

//#if -389629470 
response = vetor[i];
//#endif 

} 

//#endif 


//#if 813078176 
return response;
//#endif 

} 

//#endif 


//#if 395263557 
public void remove(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if 791299147 
int i = getIndex(code);
//#endif 


//#if -174126731 
if(i == indice)//1
{ 

//#if 449346547 
throw new ObjectNotFoundException("Disease not found");
//#endif 

} 
else
{ 

//#if 2083184113 
vetor[i] = vetor[indice - 1];
//#endif 


//#if -1293094080 
indice = indice - 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1963763304 
public Object next()
    { 

//#if 1819610705 
if(ponteiro >= indice)//1
{ 

//#if -540018321 
return null;
//#endif 

} 
else
{ 

//#if 548465477 
return vetor[ponteiro++];
//#endif 

} 

//#endif 

} 

//#endif 


//#if -598894393 
public void reset()
    { 

//#if 268222086 
this.ponteiro = 0;
//#endif 

} 

//#endif 


//#if 649989807 
public void insert(DiseaseType tp) throws RepositoryException, ObjectAlreadyInsertedException
    { 

//#if 709078870 
if(tp == null)//1
{ 

//#if -2122795424 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 1603270192 
this.vetor[indice] = tp;
//#endif 


//#if -1857058929 
indice++;
//#endif 

} 

//#endif 


//#if -913364235 
public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException
    { 

//#if -775334084 
return new ConcreteIterator(Arrays.asList(vetor));
//#endif 

} 

//#endif 


//#if 1281942334 
public boolean exists(int codigo) throws RepositoryException
    { 

//#if -575999649 
int i = getIndex(codigo);
//#endif 


//#if -2139963018 
return (i != indice);
//#endif 

} 

//#endif 


//#if -1161065285 
public void update(DiseaseType tp) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    { 

//#if -1982168596 
int i = getIndex(tp.getCode());
//#endif 


//#if 2113225361 
if(i == indice)//1
{ 

//#if 909290787 
throw new ObjectNotFoundException("Disease not found");
//#endif 

} 
else
{ 

//#if 516802469 
vetor[i] = tp;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1477925665 
private int getIndex(int code)
    { 

//#if -1249415709 
int temp;
//#endif 


//#if -176217172 
boolean flag = false;
//#endif 


//#if -1703239805 
int i = 0;
//#endif 


//#if -801487764 
while ((!flag) && (i < indice)) //1
{ 

//#if 1929661282 
temp = vetor[i].getCode();
//#endif 


//#if 1026275207 
if(temp == code)//1
{ 

//#if -504668925 
flag = true;
//#endif 

} 
else
{ 

//#if -1754651914 
i = i + 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2140278867 
return i;
//#endif 

} 

//#endif 


//#if -167587985 
public DiseaseTypeRepositoryArray()
    { 

//#if 1650614196 
vetor = new DiseaseType[100];
//#endif 


//#if 1395168167 
indice = 0;
//#endif 

} 

//#endif 


//#if -296145957 
public boolean hasNext()
    { 

//#if 1045721342 
return ponteiro < indice;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

