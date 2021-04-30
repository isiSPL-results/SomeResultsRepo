
//#if -1803964528 
// Compilation Unit of /SpecialityRepositoryArray.java 
 

//#if -382077967 
package healthwatcher.data.mem;
//#endif 


//#if 1419310889 
import healthwatcher.data.ISpecialityRepository;
//#endif 


//#if -108482314 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 


//#if 1257994529 
import java.util.Arrays;
//#endif 


//#if -1232458916 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 2034955195 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -432788553 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1169167973 
import lib.util.ConcreteIterator;
//#endif 


//#if -1532341360 
import lib.util.IteratorDsk;
//#endif 


//#if 394275750 
public class SpecialityRepositoryArray implements 
//#if -810580520 
ISpecialityRepository
//#endif 

  { 

//#if -1673161752 
private MedicalSpeciality[] vetor;
//#endif 


//#if -316875821 
private int indice;
//#endif 


//#if -1292376839 
private int ponteiro;
//#endif 


//#if 27661518 
public void update(MedicalSpeciality specialty) throws RepositoryException,
               ObjectNotFoundException
    { 

//#if -1639841 
int i = getIndex(specialty.getCodigo());
//#endif 


//#if 1694681500 
if(i == indice)//1
{ 

//#if 1407712551 
throw new ObjectNotFoundException("Specialty not found");
//#endif 

} 
else
{ 

//#if -2062952175 
vetor[i] = specialty;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 163774178 
public SpecialityRepositoryArray()
    { 

//#if -882003362 
vetor = new MedicalSpeciality[100];
//#endif 


//#if -920392019 
indice = 0;
//#endif 

} 

//#endif 


//#if -1665445215 
public void insert(MedicalSpeciality specialty) throws RepositoryException,
        ObjectAlreadyInsertedException
    { 

//#if -596778953 
if(specialty == null)//1
{ 

//#if 205032896 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1266252105 
this.vetor[indice] = specialty;
//#endif 


//#if 943946970 
indice++;
//#endif 

} 

//#endif 


//#if -97295297 
public boolean hasNext()
    { 

//#if 2142434221 
return ponteiro < indice;
//#endif 

} 

//#endif 


//#if 911303448 
public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException
    { 

//#if 1977640106 
if(indice == 0)//1
{ 

//#if -1819794068 
throw new ObjectNotFoundException("There isn't registered Health units");
//#endif 

} 

//#endif 


//#if 536468677 
return new ConcreteIterator(Arrays.asList(vetor));
//#endif 

} 

//#endif 


//#if -192911826 
public boolean exists(int code) throws RepositoryException
    { 

//#if -1476310462 
boolean flag = false;
//#endif 


//#if -1381889085 
for (int i = 0; i < indice; i++) //1
{ 

//#if 1194990547 
if(this.vetor[i].getCodigo() == code)//1
{ 

//#if -448004072 
flag = true;
//#endif 


//#if -1016513416 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1991394270 
return flag;
//#endif 

} 

//#endif 


//#if -869610327 
public void remove(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if 149323479 
int i = getIndex(code);
//#endif 


//#if -1302959615 
if(i == indice)//1
{ 

//#if -466479941 
throw new ObjectNotFoundException("Specialty not found");
//#endif 

} 
else
{ 

//#if -1083697728 
vetor[i] = vetor[indice - 1];
//#endif 


//#if 491644561 
indice = indice - 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 273828237 
public MedicalSpeciality search(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if -1290510190 
MedicalSpeciality response = null;
//#endif 


//#if -1560974092 
int i = getIndex(code);
//#endif 


//#if -2052919650 
if(i == indice)//1
{ 

//#if 866448280 
throw new ObjectNotFoundException("Specialty not found");
//#endif 

} 
else
{ 

//#if -302099975 
response = vetor[i];
//#endif 

} 

//#endif 


//#if 2136236126 
return response;
//#endif 

} 

//#endif 


//#if -561725123 
private int getIndex(int code)
    { 

//#if -1717282155 
int temp;
//#endif 


//#if -1033283106 
boolean flag = false;
//#endif 


//#if -1718332271 
int i = 0;
//#endif 


//#if -1499161862 
while ((!flag) && (i < indice)) //1
{ 

//#if 1928790311 
temp = vetor[i].getCodigo();
//#endif 


//#if 1051779382 
if(temp == code)//1
{ 

//#if 2139683609 
flag = true;
//#endif 

} 
else
{ 

//#if -498122003 
i = i + 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1686821983 
return i;
//#endif 

} 

//#endif 


//#if -713379636 
public Object next()
    { 

//#if -797987681 
if(ponteiro >= indice)//1
{ 

//#if -288251394 
return null;
//#endif 

} 
else
{ 

//#if 682102791 
return vetor[ponteiro++];
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1115861475 
public void reset()
    { 

//#if -505567640 
this.ponteiro = 0;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

