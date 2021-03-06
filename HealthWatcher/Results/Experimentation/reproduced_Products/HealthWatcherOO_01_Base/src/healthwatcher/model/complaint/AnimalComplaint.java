package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;
public class AnimalComplaint extends Complaint
{
    private short animalQuantity;
    private Date inconvenienceDate;
    private String animal;
    private Address occurenceLocalAddress;
    public AnimalComplaint()
    {
    }
    public Address getOccurenceLocalAddress()
    {
        return occurenceLocalAddress;
    }
    public AnimalComplaint(String solicitante, String descricao, String observacao, String email,
                           Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                           Address enderecoSolicitante, short animalQuantity, Date inconvenienceDate,
                           String animal, Address occurenceLocalAddress)
    {
        super(solicitante, descricao, observacao, email, atendente, situacao, dataParecer,
              dataQueixa, enderecoSolicitante, 0);
        this.animalQuantity = animalQuantity;
        this.inconvenienceDate = inconvenienceDate;
        this.animal = animal;
        this.occurenceLocalAddress = occurenceLocalAddress;
    }
    public void setOccurenceLocalAddress(Address occurenceLocalAddress)
    {
        this.occurenceLocalAddress = occurenceLocalAddress;
    }
    public void setAnimal(String animal)
    {
        this.animal = animal;
    }
    public Date getInconvenienceDate()
    {
        return inconvenienceDate;
    }
    public short getAnimalQuantity()
    {
        return animalQuantity;
    }
    public void setInconvenienceDate(Date inconvenienceDate)
    {
        this.inconvenienceDate = inconvenienceDate;
    }
    public String getAnimal()
    {
        return animal;
    }
    public void setAnimalQuantity(short animalQuantity)
    {
        this.animalQuantity = animalQuantity;
    }

}
