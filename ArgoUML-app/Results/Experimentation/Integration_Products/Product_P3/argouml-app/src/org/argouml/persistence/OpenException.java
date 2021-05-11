package org.argouml.persistence;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.xml.sax.SAXException;
public class OpenException extends PersistenceException
  { 
private static final long serialVersionUID = -4787911270548948677L;
public OpenException(String message)
    { 
super(message);
} 
public void printStackTrace(PrintStream ps)
    { 
super.printStackTrace(ps);
if(getCause() instanceof SAXException
                && ((SAXException) getCause()).getException() != null)//1
{ 
((SAXException) getCause()).getException().printStackTrace(ps);
} 
} 
public void printStackTrace(PrintWriter pw)
    { 
super.printStackTrace(pw);
if(getCause() instanceof SAXException
                && ((SAXException) getCause()).getException() != null)//1
{ 
((SAXException) getCause()).getException().printStackTrace(pw);
} 
} 
public void printStackTrace()
    { 
super.printStackTrace();
if(getCause() instanceof SAXException
                && ((SAXException) getCause()).getException() != null)//1
{ 
((SAXException) getCause()).getException().printStackTrace();
} 
} 
public OpenException(String message, Throwable cause)
    { 
super(message, cause);
} 
public OpenException(Throwable cause)
    { 
super(cause);
} 

 } 
