package healthwatcher.view.command;
public interface CommandRequest  { 
public void put(String key, Object value);public String getInput(String key);public void reset();public Object get(String key);public void setAuthorized(boolean authorized);public boolean isAuthorized();
 } 
