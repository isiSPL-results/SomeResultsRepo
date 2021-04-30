// Compilation Unit of /IteratorDsk.java 
 
package lib.util;
import lib.exceptions.CommunicationException;
public interface IteratorDsk  { 
public Object next() throws CommunicationException;
public void remove() throws CommunicationException;
public boolean hasNext() throws CommunicationException;
public void close() throws CommunicationException;
 } 


