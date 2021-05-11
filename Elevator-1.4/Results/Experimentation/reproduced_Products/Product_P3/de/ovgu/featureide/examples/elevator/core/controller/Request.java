package de.ovgu.featureide.examples.elevator.core.controller;
import java.util.Comparator;
public class Request
{
    private int floor;
    private long timestamp = System.currentTimeMillis();
    public long getTimestamp()
    {
        return timestamp;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) { //1
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) { //1
            return false;
        }
        Request other = (Request) obj;
        return (floor != other.floor);
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + floor;
        return result;
    }
    @Override
    public String toString()
    {
        return "Request [floor=" + floor + "]";
    }
    public Request(int floor)
    {
        this.floor = floor;
    }
    public int getFloor()
    {
        return floor;
    }
    public static class RequestComparator implements Comparator<Request>
    {
        @Override
        public int compare(Request o1, Request o2)
        {
            return (int) Math.signum(o1.timestamp - o2.timestamp);
        }
        protected int compareDirectional(Request o1, Request o2)
        {
            return 0;
        }

    }

}
