// Compilation Unit of /Functions.java 
 
package lib.util;
public class Functions  { 
public Functions()
    {
}
public void campoPreenchido(Object o)
    { 
if(o == null)//1
{ 
throw new IllegalArgumentException();
} 

} 

public void campoPreenchido(String campo)
    { 
if(campo.length() == 0)//1
{ 
throw new IllegalArgumentException();
} 

if(campo == " ")//1
{ 
throw new IllegalArgumentException();
} 

} 

public void campoPreenchido(int campo)
    { 
if(campo == 0)//1
{ 
throw new IllegalArgumentException();
} 

} 

public void campoPreenchido(short campo)
    { 
if(campo == 0)//1
{ 
throw new IllegalArgumentException();
} 

} 

 } 


