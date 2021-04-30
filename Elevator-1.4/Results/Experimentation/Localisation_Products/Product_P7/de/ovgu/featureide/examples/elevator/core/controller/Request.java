package de.ovgu.featureide.examples.elevator.core.controller;
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
import java.util.Comparator;
public class Request  { 
private int floor;
@Override
	public boolean equals(Object obj) { 
if(this == obj)//1
return true;
if(obj == null || getClass() != obj.getClass())//1
return false;
Request other = (Request) obj;
return (floor != other.floor);
} 
@Override
	public int hashCode() { 
final int prime = 31;
int result = 1;
result = prime * result + floor;
return result;
} 
@Override
	public String toString() { 
return "Request [floor=" + floor + "]";
} 
public Request(int floor) { 
this.floor = floor;
} 
public int getFloor() { 
return floor;
} 
public static class RequestComparator implements Comparator<Request>
  { 
protected ControlUnit controller;
@Override
		public int compare(Request o1, Request o2) { 
int diff0 = Math.abs(o1.floor - controller.getCurrentFloor());
int diff1 = Math.abs(o2.floor - controller.getCurrentFloor());
return diff0 - diff1;
} 
protected int compareDirectional(Request o1, Request o2) { 
return 0;
} 
public RequestComparator(ControlUnit controller) { 
this.controller = controller;
} 

 } 

 } 
