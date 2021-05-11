package lib.patterns.observer;
public interface Subject
{
    public void removeObserver(Observer observer);
    public void addObserver(Observer observer);
    public void notifyObservers();
}
