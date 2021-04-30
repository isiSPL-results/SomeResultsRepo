
//#if -475495867 
// Compilation Unit of /EmployeeRepositoryArray.java 
 

//#if 854984804 
package healthwatcher.data.mem;
//#endif 


//#if -2075593059 
import healthwatcher.data.IEmployeeRepository;
//#endif 


//#if 1735775155 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -1175778584 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -926839008 
public class EmployeeRepositoryArray implements 
//#if 1265970871 
IEmployeeRepository
//#endif 

  { 

//#if -1733843814 
private static final long serialVersionUID = 1L;
//#endif 


//#if -1513518257 
private Employee[] vector;
//#endif 


//#if 1666037247 
private int index;
//#endif 


//#if 871328269 
private int iteratorIndex;
//#endif 


//#if -1073084603 
public void insert(Employee employee)
    { 

//#if -517020836 
synchronized (this) //1
{ 

//#if 1952890949 
if(employee == null)//1
{ 

//#if -1474634995 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 1803802438 
this.vector[index] = employee;
//#endif 


//#if 456847276 
index++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1295939385 
private int getIndex(String login)
    { 

//#if -623596833 
synchronized (this) //1
{ 

//#if -74556544 
String temp;
//#endif 


//#if 1108067959 
boolean flag = false;
//#endif 


//#if -954741352 
int i = 0;
//#endif 


//#if -929950269 
while ((!flag) && (i < index)) //1
{ 

//#if 1087109955 
temp = vector[i].getLogin();
//#endif 


//#if -1280717253 
if(temp.equals(login))//1
{ 

//#if 2034203040 
flag = true;
//#endif 

} 
else
{ 

//#if -1052474040 
i = i + 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -411663304 
return i;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -988145274 
public void remove(String login) throws ObjectNotFoundException
    { 

//#if -1057157075 
synchronized (this) //1
{ 

//#if -119844824 
int i = getIndex(login);
//#endif 


//#if -711445230 
if(i == index)//1
{ 

//#if 1784585196 
throw new ObjectNotFoundException("Employee not found");
//#endif 

} 
else
{ 

//#if -944913588 
vector[i] = vector[index - 1];
//#endif 


//#if 1613778127 
index = index - 1;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 366354415 
public EmployeeRepositoryArray()
    { 

//#if 560841521 
vector = new Employee[5000];
//#endif 


//#if 1653666053 
index = 0;
//#endif 

} 

//#endif 


//#if 1540384745 
public void reset()
    { 

//#if 1591696924 
synchronized (this) //1
{ 

//#if 526053835 
this.iteratorIndex = 0;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2089825384 
public boolean exists(String login)
    { 

//#if -2014888488 
synchronized (this) //1
{ 

//#if -1442926467 
int i = getIndex(login);
//#endif 


//#if 473937154 
return (i != index);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -648399649 
public void update(Employee employee) throws ObjectNotFoundException
    { 

//#if -758100742 
synchronized (this) //1
{ 

//#if -637138695 
int i = getIndex(employee.getLogin());
//#endif 


//#if -1084099432 
if(i == index)//1
{ 

//#if 1924888169 
throw new ObjectNotFoundException("Employee not found");
//#endif 

} 
else
{ 

//#if 270068303 
vector[i] = employee;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1162117625 
public boolean hasNext()
    { 

//#if -698154109 
synchronized (this) //1
{ 

//#if -321733692 
return (iteratorIndex < index);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -950540956 
public Employee search(String login) throws ObjectNotFoundException
    { 

//#if 339634723 
synchronized (this) //1
{ 

//#if 1147691088 
Employee response = null;
//#endif 


//#if 1878342952 
int i = getIndex(login);
//#endif 


//#if 1843913234 
if(i == index)//1
{ 

//#if -429685092 
throw new ObjectNotFoundException("Employee not found");
//#endif 

} 
else
{ 

//#if 81083966 
response = vector[i];
//#endif 

} 

//#endif 


//#if 818140960 
return response;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -438060154 
public Object next()
    { 

//#if 2112236828 
synchronized (this) //1
{ 

//#if -911205737 
if(iteratorIndex >= index)//1
{ 

//#if 1528310464 
return null;
//#endif 

} 
else
{ 

//#if -249439590 
return vector[iteratorIndex++];
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

