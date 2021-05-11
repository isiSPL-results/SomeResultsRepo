
//#if -1902469923
// Compilation Unit of /HealthUnitRepositoryArray.java


//#if 432593200
package healthwatcher.data.mem;
//#endif


//#if 934706751
import healthwatcher.data.IHealthUnitRepository;
//#endif


//#if -1616321797
import healthwatcher.model.healthguide.HealthUnit;
//#endif


//#if -1908451741
import java.util.ArrayList;
//#endif


//#if 1038249154
import java.util.Arrays;
//#endif


//#if 1490300446
import java.util.List;
//#endif


//#if -1998321829
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 1499138204
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1049352472
import lib.exceptions.RepositoryException;
//#endif


//#if -1910855708
import lib.util.ConcreteIterator;
//#endif


//#if 498896561
import lib.util.IteratorDsk;
//#endif


//#if -1973106278
public class HealthUnitRepositoryArray implements
//#if -603769786
    IHealthUnitRepository
//#endif

{

//#if 1934868267
    private HealthUnit[] vetor;
//#endif


//#if -1886450474
    private int indice;
//#endif


//#if -2120097476
    private int ponteiro;
//#endif


//#if -2125553623
    public Object next()
    {

//#if 98627615
        if(ponteiro >= indice) { //1

//#if -1014480522
            return null;
//#endif

        } else {

//#if -981896157
            return vetor[ponteiro++];
//#endif

        }

//#endif

    }

//#endif


//#if -2111238592
    public IteratorDsk getHealthUnitListBySpeciality(int code) throws RepositoryException,
               ObjectNotFoundException
    {

//#if 1388273084
        int aux = 0;
//#endif


//#if 1627143260
        List response = new ArrayList();
//#endif


//#if 1401609658
        while (aux < indice) { //1

//#if -1061610128
            if(vetor[aux].hasSpeciality(code)) { //1

//#if -1692081283
                response.add(vetor[aux]);
//#endif

            }

//#endif


//#if -752594341
            aux++;
//#endif

        }

//#endif


//#if -599737012
        if(! response.isEmpty()) { //1

//#if -642795454
            return new ConcreteIterator(response);
//#endif

        } else {

//#if 1983610031
            throw new ObjectNotFoundException(
                "There isn't registered health units for the specialty");
//#endif

        }

//#endif

    }

//#endif


//#if -751532902
    public HealthUnitRepositoryArray()
    {

//#if 1003534575
        vetor = new HealthUnit[100];
//#endif


//#if -261558324
        indice = 0;
//#endif

    }

//#endif


//#if 1564010955
    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException
    {

//#if -736439231
        return new ConcreteIterator(Arrays.asList(vetor));
//#endif

    }

//#endif


//#if 543527345
    public boolean exists(int code) throws RepositoryException
    {

//#if 1364606145
        boolean flag = false;
//#endif


//#if -533956572
        for (int i = 0; i < indice; i++) { //1

//#if -1723617932
            if(this.vetor[i].getCode() == code) { //1

//#if 940363937
                flag = true;
//#endif


//#if -667829887
                break;

//#endif

            }

//#endif

        }

//#endif


//#if -1992584641
        return flag;
//#endif

    }

//#endif


//#if -1315545828
    public boolean hasNext()
    {

//#if -924200264
        return ponteiro < indice;
//#endif

    }

//#endif


//#if 791956573
    public void update(HealthUnit unit) throws RepositoryException, ObjectNotFoundException
    {

//#if 398180186
        int i = getIndex(unit.getCode());
//#endif


//#if 699452791
        if(i == indice) { //1

//#if 1824213464
            throw new ObjectNotFoundException("Health unit not found");
//#endif

        } else {

//#if 955247982
            vetor[i] = unit;
//#endif

        }

//#endif

    }

//#endif


//#if -453713178
    public void reset()
    {

//#if -1921667054
        this.ponteiro = 0;
//#endif

    }

//#endif


//#if -1104346874
    public void remove(int code) throws RepositoryException, ObjectNotFoundException
    {

//#if -1808247880
        int i = getIndex(code);
//#endif


//#if 483383138
        if(i == indice) { //1

//#if 1007237525
            throw new ObjectNotFoundException("Health unit not found");
//#endif

        } else {

//#if -1915310901
            vetor[i] = vetor[indice - 1];
//#endif


//#if -454678746
            indice = indice - 1;
//#endif

        }

//#endif

    }

//#endif


//#if 526109312
    private int getIndex(int code)
    {

//#if -1805003683
        int temp;
//#endif


//#if 907491750
        boolean flag = false;
//#endif


//#if 1188331977
        int i = 0;
//#endif


//#if -693203406
        while ((!flag) && (i < indice)) { //1

//#if 33449306
            temp = vetor[i].getCode();
//#endif


//#if -296852337
            if(temp == code) { //1

//#if -1466767717
                flag = true;
//#endif

            } else {

//#if -1880265065
                i = i + 1;
//#endif

            }

//#endif

        }

//#endif


//#if 1599100455
        return i;
//#endif

    }

//#endif


//#if 109702454
    public HealthUnit search(int code) throws RepositoryException, ObjectNotFoundException
    {

//#if 127335456
        HealthUnit response = null;
//#endif


//#if 2008180976
        int i = getIndex(code);
//#endif


//#if -1890236262
        if(i == indice) { //1

//#if -572760470
            throw new ObjectNotFoundException("Health unit not found");
//#endif

        } else {

//#if 1061040537
            response = vetor[i];
//#endif

        }

//#endif


//#if -1322199326
        return response;
//#endif

    }

//#endif


//#if -933186510
    public void insert(HealthUnit unit) throws RepositoryException, ObjectAlreadyInsertedException
    {

//#if -65293130
        if(unit == null) { //1

//#if -566281595
            throw new IllegalArgumentException();
//#endif

        }

//#endif


//#if -1910700592
        this.vetor[indice] = unit;
//#endif


//#if -879557977
        indice++;
//#endif

    }

//#endif


//#if -1664692848
    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException
    {

//#if 255315167
        if(indice == 0) { //1

//#if -1577296450
            throw new ObjectNotFoundException("There isn't registered Health units");
//#endif

        }

//#endif


//#if 1331376378
        return new ConcreteIterator(Arrays.asList(vetor));
//#endif

    }

//#endif

}

//#endif


//#endif

