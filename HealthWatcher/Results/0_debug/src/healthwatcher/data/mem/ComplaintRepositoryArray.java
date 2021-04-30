
//#if -1911914705 
// Compilation Unit of /ComplaintRepositoryArray.java 
 

//#if -1768504949 
package healthwatcher.data.mem;
//#endif 


//#if 977779443 
import healthwatcher.data.IComplaintRepository;
//#endif 


//#if -1037710432 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 276130166 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1759117025 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 1772272093 
import lib.exceptions.RepositoryException;
//#endif 


//#if 953678902 
import lib.util.IteratorDsk;
//#endif 


//#if -1764540002 
public class ComplaintRepositoryArray implements 
//#if 1502834110 
IComplaintRepository
//#endif 

  { 

//#if -542345553 
private Complaint[] vetor;
//#endif 


//#if -258109135 
private int indice;
//#endif 


//#if -652166441 
private int ponteiro;
//#endif 


//#if 1472857656 
public boolean exists(int codigo) throws RepositoryException
    { 

//#if 1182509993 
synchronized (this) //1
{ 

//#if 1953686998 
int i = getIndex(codigo);
//#endif 


//#if 442337645 
return (i != indice);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1108387630 
public Object next()
    { 

//#if -1376288817 
synchronized (this) //1
{ 

//#if -1658709066 
if(ponteiro >= indice)//1
{ 

//#if -269187019 
return null;
//#endif 

} 
else
{ 

//#if 2067308112 
return vetor[ponteiro++];
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -874486336 
public ComplaintRepositoryArray()
    { 

//#if 1664120833 
vetor = new Complaint[5000];
//#endif 


//#if -153060119 
indice = 0;
//#endif 

} 

//#endif 


//#if -1539090015 
public boolean hasNext()
    { 

//#if -377328842 
synchronized (this) //1
{ 

//#if -596452831 
return ponteiro < indice;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -530523877 
private int getIndex(int code)
    { 

//#if 916870311 
synchronized (this) //1
{ 

//#if -1228826887 
int temp;
//#endif 


//#if -1568577214 
boolean flag = false;
//#endif 


//#if 929823661 
int i = 0;
//#endif 


//#if -1314798314 
while ((!flag) && (i < indice)) //1
{ 

//#if 1540658040 
temp = vetor[i].getCodigo();
//#endif 


//#if 312688581 
if(temp == code)//1
{ 

//#if -179919808 
flag = true;
//#endif 

} 
else
{ 

//#if -1493213846 
i = i + 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2119690045 
return i;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1578682138 
public int insert(Complaint q) throws RepositoryException, ObjectAlreadyInsertedException
    { 

//#if -835367810 
synchronized (this) //1
{ 

//#if -673520611 
if(q == null)//1
{ 

//#if -13029274 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 1448784401 
this.vetor[indice] = q;
//#endif 


//#if -1905240377 
indice++;
//#endif 


//#if 1567603095 
return vetor[indice - 1].getCodigo();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1930850249 
public void remove(int codigo) throws RepositoryException, ObjectNotFoundException
    { 

//#if -1479839924 
synchronized (this) //1
{ 

//#if 1611508700 
int i = getIndex(codigo);
//#endif 


//#if 71225882 
if(i == indice)//1
{ 

//#if 23168593 
throw new ObjectNotFoundException("Complaint not found");
//#endif 

} 
else
{ 

//#if 2060534452 
vetor[i] = vetor[indice - 1];
//#endif 


//#if -2037082339 
indice = indice - 1;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -936037926 
public void update(Complaint q) throws RepositoryException, ObjectNotFoundException
    { 

//#if 246584235 
synchronized (this) //1
{ 

//#if -1729744334 
int i = getIndex(q.getCodigo());
//#endif 


//#if 275292412 
if(i == indice)//1
{ 

//#if -788563550 
throw new ObjectNotFoundException("Complaint not found");
//#endif 

} 
else
{ 

//#if 389271949 
vetor[i] = q;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -197603012 
public Complaint search(int codigo) throws RepositoryException, ObjectNotFoundException
    { 

//#if 2039243340 
synchronized (this) //1
{ 

//#if 248492665 
Complaint response = null;
//#endif 


//#if 1170544734 
int i = getIndex(codigo);
//#endif 


//#if -1323677668 
if(i == indice)//1
{ 

//#if 929844677 
throw new ObjectNotFoundException("Complaint not found");
//#endif 

} 
else
{ 

//#if 1291040233 
response = vetor[i];
//#endif 

} 

//#endif 


//#if 1189928736 
return response;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1174628161 
public void reset()
    { 

//#if -1176809716 
synchronized (this) //1
{ 

//#if -377733486 
this.ponteiro = 0;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1461543111 
public IteratorDsk getComplaintList()
    { 

//#if 450655015 
synchronized (this) //1
{ 

//#if -126566782 
return null;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

