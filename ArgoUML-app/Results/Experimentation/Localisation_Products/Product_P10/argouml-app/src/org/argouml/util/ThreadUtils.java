package org.argouml.util;
public class ThreadUtils  { 
public static void checkIfInterrupted() throws InterruptedException
    { 
if(Thread.interrupted())//1
{ 
throw new InterruptedException();
} 
} 

 } 
