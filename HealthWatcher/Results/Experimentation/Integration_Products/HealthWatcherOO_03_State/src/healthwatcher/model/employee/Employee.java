package healthwatcher.model.employee;
import java.io.Serializable;
public class Employee implements Serializable
  { 
private String name;
private String login;
private String password;
public String getPassword()
    { 
return password;
} 
public void setName(String name)
    { 
this.name = name;
} 
public String getLogin()
    { 
return login;
} 
public void setLogin(String login)
    { 
this.login = login;
} 
public boolean validatePassword(String password)
    { 
return this.password.equals(password);
} 
public String getName()
    { 
return name;
} 
public Employee(String login, String password, String name)
    { 
this.name = name;
this.login = login;
this.password = password;
} 
public void setPassword(String password)
    { 
this.password = password;
} 

 } 
