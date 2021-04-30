package p;

//#if SOLVER
@p.R4Feature(p.R4Feature.SOLVER)
public interface Solver
{
    @p.R4Feature(p.R4Feature.SOLVER)
    public boolean trySolve(Board board);
}
// #endif
