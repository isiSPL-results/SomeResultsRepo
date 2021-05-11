
//#if -1685507436
// Compilation Unit of /Suite.java


//#if -1786884646
import junit.framework.TestCase;
//#endif


//#if 1004991731
public class Suite extends
//#if -225098679
    TestCase
//#endif

{

//#if 1844339299
    public void testBaseModel()
    {

//#if 1674020399
        boolean[] rules = {false, false, false, true, false, false, false, false, false};
//#endif


//#if -1524125161
        boolean[] rules2 = {true, true, false, false,true, true, true, true, true};
//#endif


//#if -1138074979
        RuleSet r = new RuleSet(rules, rules2);
//#endif


//#if -775120908
        GODLModel m = new GODLModel(10, 10, r);
//#endif


//#if 148519038
        GODLModel m2 = new GODLModel(10, 10, r);
//#endif


//#if -189529510
        m.setLifeform(0, 0, 1);
//#endif


//#if 697974171
        m.setLifeform(1, 0, 1);
//#endif


//#if -188605989
        m.setLifeform(0, 1, 1);
//#endif


//#if 1585477852
        m.setLifeform(2, 0, 1);
//#endif


//#if -1821985763
        m.setLifeform(3, 0, 1);
//#endif


//#if -934482082
        m.setLifeform(4, 0, 1);
//#endif


//#if -46978401
        m.setLifeform(5, 0, 1);
//#endif


//#if -1678511133
        m.setLifeform(8, 1, 1);
//#endif


//#if -788236889
        m.setLifeform(9, 4, 1);
//#endif


//#if -786389847
        m.setLifeform(9, 6, 1);
//#endif


//#if 1024771540
        for(int i = 0; i < 6; i++) { //1

//#if 387653444
            m.nextGeneration();
//#endif


//#if 208246288
            m2.nextGeneration();
//#endif

        }

//#endif


//#if -1469982801
        assertEquals(m, m2);
//#endif

    }

//#endif

}

//#endif


//#endif

