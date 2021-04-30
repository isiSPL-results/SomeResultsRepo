
//#if 1504835385
// Compilation Unit of /ForcedField.java


//#if 581089683
package p;
//#endif


//#if -905436240

//#if 733493812
@p.R4Feature(p.R4Feature.SOLVER)
//#endif

public class ForcedField implements
//#if -1299246245
    Solver
//#endif

{

//#if 1202323548

//#if 1735983604
    @p.R4Feature(p.R4Feature.SOLVER)
//#endif


    public boolean trySolve(Board board)
    {

//#if -1475926456
        for (int i = 0; i < Field.POSSIBILITIES; i++) { //1

//#if -2016286852
            for (int j = 0; j < Field.POSSIBILITIES; j++) { //1

//#if -1173407371
                if((board.getField(Structure.ROW, i, j).getRemainingPos()
                        .size() == 1)
                        && !board.getField(Structure.ROW, i, j).isSet()) { //1

//#if -1478680998
                    if(!board.trySetField(Structure.ROW, i, j, new Field(
                                              (Integer) board.getField(Structure.ROW, i, j)
                                              .getRemainingPos().get(0)))) { //1

//#if -1416573676
                        return false;
//#endif

                    }

//#endif

                }

//#endif

            }

//#endif

        }

//#endif


//#if 1619106406
        return true;
//#endif

    }

//#endif

}

//#endif


//#endif

