package lib.exceptions;
public class InvalidDateException extends Exception
{
    public InvalidDateException(String erro)
    {
        super("ExcecaoHora:" + erro);
    }
    public InvalidDateException(int segundos, int minutos, int hora)
    {
        super("ExcecaoHora: ");
    }

}
