package lib.util;
import java.util.Calendar;
import java.util.GregorianCalendar;
import lib.exceptions.InvalidDateException;
public class Schedule
{
    private int segundo;
    private int hora;
    private int minuto;
    public static final int FORMATO1 = 1;
    public static final int FORMATO2 = 2;
    public Schedule()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        hora = calendar.get(Calendar.HOUR_OF_DAY);
        minuto = calendar.get(Calendar.MINUTE);
        segundo = calendar.get(Calendar.SECOND);
    }
    public int getHora()
    {
        return hora;
    }
    public static Schedule stringToHorario(String horarioStr, int formato)
    throws InvalidDateException
    {
        String segundoStr = null, minutoStr = null, horaStr = null;
        Schedule horario = null;
        try { //1
            switch (formato) { //1
            case (Schedule.FORMATO1)://1

                horaStr = horarioStr.substring(0, 2);
                minutoStr = horarioStr.substring(3, 5);
                segundoStr = horarioStr.substring(6, 8);
                break;


            case (Schedule.FORMATO2)://1

                segundoStr = horarioStr.substring(0, 2);
                minutoStr = horarioStr.substring(2, 4);
                horaStr = horarioStr.substring(4, 6);
                break;


            default://1

                horario = null;
                break;


            }
            horario = new Schedule(segundoStr, minutoStr, horaStr);
        } catch (Exception nb) { //1
            throw new InvalidDateException(horarioStr);
        }
        return horario;
    }
    private void validaHorario(int segundo, int minuto, int hora) throws InvalidDateException
    {
        if(!((segundo >= 0) && (segundo <= 59) && (minuto >= 0) && (minuto <= 59) && (hora >= 0) && (hora <= 23))) { //1
            throw new InvalidDateException(segundo, minuto, hora);
        }
    }
    public int getMinuto()
    {
        return minuto;
    }
    public int compara(Schedule horario)
    {
        int retorno = 0;
        if(hora > horario.getHora()) { //1
            retorno = 1;
        } else if(hora < horario.getHora()) { //1
            retorno = -1;
        } else {
            if(minuto > horario.getMinuto()) { //1
                retorno = 1;
            } else if(minuto < horario.getMinuto()) { //1
                retorno = -1;
            } else {
                if(segundo > horario.getSegundo()) { //1
                    retorno = 1;
                } else if(segundo < horario.getSegundo()) { //1
                    retorno = -1;
                }
            }
        }
        return retorno;
    }
    public Schedule(int segundo, int minuto, int hora) throws InvalidDateException
    {
        this.segundo = segundo;
        this.minuto = minuto;
        this.hora = hora;
        validaHorario(segundo, minuto, hora);
    }
    public Schedule(String segundoStr, String minutoStr, String horaStr)
    throws InvalidDateException
    {
        try { //1
            this.segundo = Integer.parseInt(segundoStr);
            this.minuto = Integer.parseInt(minutoStr);
            this.hora = Integer.parseInt(horaStr);
            validaHorario(segundo, minuto, hora);
        } catch (NumberFormatException ne) { //1
            throw new InvalidDateException(segundo, minuto, hora);
        }
    }
    public int getSegundo()
    {
        return segundo;
    }
    public String format(int formato)
    {
        return format(this, formato);
    }
    public static String format(Schedule horario, int formato)
    {
        String segundoStr = "", minutoStr = "", horaStr = "";
        String texto = null;
        try { //1
            segundoStr = String.valueOf(horario.getSegundo());
            minutoStr = String.valueOf(horario.getMinuto());
            horaStr = String.valueOf(horario.getHora());
            if(segundoStr.length() < 2) { //1
                segundoStr = "0" + segundoStr;
            }
            if(minutoStr.length() < 2) { //1
                minutoStr = "0" + minutoStr;
            }
            if(horaStr.length() < 2) { //1
                horaStr = "0" + horaStr;
            }
        } catch (NumberFormatException nb) { //1
        } switch (formato) { //1
        case (FORMATO1)://1

            texto = horaStr + ":" + minutoStr + ":" + segundoStr;
            break;


        case (FORMATO2)://1

            texto = horaStr + minutoStr + segundoStr;
            break;


        default://1

            texto = null;
            break;


        }
        return texto;
    }

}
