package healthwatcher.view.command;
import healthwatcher.view.IFacade;
public abstract class Command  { 
protected IFacade facade;
protected CommandRequest request;
protected CommandResponse response;
public Command(IFacade f)
    { 
facade= f;
} 
public void setRequest(CommandRequest request)
    { 
this.request = request;
} 
public void setReponse(CommandResponse response)
    { 
this.response = response;
} 
public abstract void execute() throws Exception;
 } 
