package healthwatcher.business.healthguide;
import healthwatcher.data.IHealthUnitRepository;
import healthwatcher.model.healthguide.HealthUnit;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;
import lib.exceptions.ObjectAlreadyInsertedException;
public class HealthUnitRecord
{
    private IHealthUnitRepository healthUnitRep;
    public IteratorDsk searchHealthUnitsBySpeciality(int code) throws ObjectNotFoundException,
               RepositoryException
    {
        return healthUnitRep.getHealthUnitListBySpeciality(code);
    }
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException
    {
        return healthUnitRep.getPartialHealthUnitList();
    }
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException
    {
        return healthUnitRep.getHealthUnitList();
    }
    public IteratorDsk searchSpecialityByHealthUnit(int code) throws ObjectNotFoundException,
        RepositoryException
    {
        HealthUnit us = healthUnitRep.search(code);
        return new ConcreteIterator(us.getSpecialities());
    }
    public void insert(HealthUnit us) throws ObjectNotValidException,
        ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException
    {
        healthUnitRep.insert(us);
    }
    public HealthUnitRecord(IHealthUnitRepository repUnidadeSaude)
    {
        this.healthUnitRep = repUnidadeSaude;
    }
    public void update(HealthUnit unit) throws RepositoryException, ObjectNotFoundException,
        ObjectNotValidException
    {
        healthUnitRep.update(unit);
    }
    public HealthUnit search(int healthUnitCode) throws ObjectNotFoundException,
        RepositoryException
    {
        return healthUnitRep.search(healthUnitCode);
    }

}
