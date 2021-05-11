package healthwatcher.model.address;
public class Address implements java.io.Serializable
{
    private int code;
    private String street;
    private String complement;
    private String zip;
    private String state;
    private String phone;
    private String city;
    private String neighbourhood;
    public void setCity(String city)
    {
        this.city = city;
    }
    public Address()
    {
    } public void setNeighbourhood(String neighbourhood)
    {
        this.neighbourhood = neighbourhood;
    }
    public String getCity()
    {
        return city;
    }
    public Address(String street, String complement, String zip, String state, String phone,
                   String city, String neighbourhood)
    {
        this.street = street;
        this.complement = complement;
        this.zip = zip;
        this.state = state;
        this.phone = phone;
        this.city = city;
        this.neighbourhood = neighbourhood;
    }
    public String getStreet()
    {
        return street;
    }
    public String getState()
    {
        return state;
    }
    public void setStreet(String street)
    {
        this.street = street;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public void setCode(int code)
    {
        this.code = code;
    }
    public int getCode()
    {
        return code;
    }
    public String getNeighbourhood()
    {
        return neighbourhood;
    }
    public void setComplement(String complement)
    {
        this.complement = complement;
    }
    public String getComplement()
    {
        return complement;
    }
    public void setZip(String zip)
    {
        this.zip = zip;
    }
    public String getZip()
    {
        return zip;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

}
