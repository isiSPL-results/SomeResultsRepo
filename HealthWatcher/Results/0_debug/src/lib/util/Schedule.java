
//#if 1350773037
// Compilation Unit of /Schedule.java


//#if 1249595688
package lib.util;
//#endif


//#if -230990310
import java.util.Calendar;
//#endif


//#if 1030123450
import java.util.GregorianCalendar;
//#endif


//#if -1691614669
import lib.exceptions.InvalidDateException;
//#endif


//#if 304932040
public class Schedule
{

//#if -969028871
    private int segundo;
//#endif


//#if 436755086
    private int hora;
//#endif


//#if -1217421146
    private int minuto;
//#endif


//#if -2023758893
    public static final int FORMATO1 = 1;
//#endif


//#if -2023729071
    public static final int FORMATO2 = 2;
//#endif


//#if -625400148
    public Schedule()
    {

//#if -509531408
        GregorianCalendar calendar = new GregorianCalendar();
//#endif


//#if 345639639
        hora = calendar.get(Calendar.HOUR_OF_DAY);
//#endif


//#if -1816738808
        minuto = calendar.get(Calendar.MINUTE);
//#endif


//#if -2003122717
        segundo = calendar.get(Calendar.SECOND);
//#endif

    }

//#endif


//#if -1302848366
    public int getHora()
    {

//#if -1894422031
        return hora;
//#endif

    }

//#endif


//#if -755368938
    public static Schedule stringToHorario(String horarioStr, int formato)
    throws InvalidDateException
    {

//#if 1654573562
        String segundoStr = null, minutoStr = null, horaStr = null;
//#endif


//#if -1852864080
        Schedule horario = null;
//#endif


//#if 1690820936
        try { //1

//#if -567901637
            switch (formato) { //1
            case (Schedule.FORMATO1)://1


//#if 903721457
                horaStr = horarioStr.substring(0, 2);
//#endif


//#if 635034399
                minutoStr = horarioStr.substring(3, 5);
//#endif


//#if -724433754
                segundoStr = horarioStr.substring(6, 8);
//#endif


//#if 433148793
                break;

//#endif


            case (Schedule.FORMATO2)://1


//#if 238160348
                segundoStr = horarioStr.substring(0, 2);
//#endif


//#if -27396389
                minutoStr = horarioStr.substring(2, 4);
//#endif


//#if 321256823
                horaStr = horarioStr.substring(4, 6);
//#endif


//#if -270583049
                break;

//#endif


            default://1


//#if 906015379
                horario = null;
//#endif


//#if -206294622
                break;

//#endif


            }

//#endif


//#if -1359088725
            horario = new Schedule(segundoStr, minutoStr, horaStr);
//#endif

        }

//#if -645474340
        catch (Exception nb) { //1

//#if -1263516512
            throw new InvalidDateException(horarioStr);
//#endif

        }

//#endif


//#endif


//#if 1697487451
        return horario;
//#endif

    }

//#endif


//#if -2002803835
    private void validaHorario(int segundo, int minuto, int hora) throws InvalidDateException
    {

//#if 2140425550
        if(!((segundo >= 0) && (segundo <= 59) && (minuto >= 0) && (minuto <= 59) && (hora >= 0) && (hora <= 23))) { //1

//#if 900787056
            throw new InvalidDateException(segundo, minuto, hora);
//#endif

        }

//#endif

    }

//#endif


//#if 1093519482
    public int getMinuto()
    {

//#if -245146359
        return minuto;
//#endif

    }

//#endif


//#if -1505250720
    public int compara(Schedule horario)
    {

//#if 1788873998
        int retorno = 0;
//#endif


//#if -1092465080
        if(hora > horario.getHora()) { //1

//#if 2064578013
            retorno = 1;
//#endif

        } else

//#if -1661766252
            if(hora < horario.getHora()) { //1

//#if 1352707632
                retorno = -1;
//#endif

            } else {

//#if -304995865
                if(minuto > horario.getMinuto()) { //1

//#if -1436780733
                    retorno = 1;
//#endif

                } else

//#if -1407785230
                    if(minuto < horario.getMinuto()) { //1

//#if 1041158104
                        retorno = -1;
//#endif

                    } else {

//#if 1571147613
                        if(segundo > horario.getSegundo()) { //1

//#if -1433423444
                            retorno = 1;
//#endif

                        } else

//#if -1189629308
                            if(segundo < horario.getSegundo()) { //1

//#if -1921425161
                                retorno = -1;
//#endif

                            }

//#endif


//#endif

                    }

//#endif


//#endif

            }

//#endif


//#endif


//#if -1230418806
        return retorno;
//#endif

    }

//#endif


//#if 1614633823
    public Schedule(int segundo, int minuto, int hora) throws InvalidDateException
    {

//#if 601644435
        this.segundo = segundo;
//#endif


//#if 1756397227
        this.minuto = minuto;
//#endif


//#if -364727701
        this.hora = hora;
//#endif


//#if -1949423531
        validaHorario(segundo, minuto, hora);
//#endif

    }

//#endif


//#if -1825851642
    public Schedule(String segundoStr, String minutoStr, String horaStr)
    throws InvalidDateException
    {

//#if -69621055
        try { //1

//#if -1123941960
            this.segundo = Integer.parseInt(segundoStr);
//#endif


//#if 139110846
            this.minuto = Integer.parseInt(minutoStr);
//#endif


//#if -1916970290
            this.hora = Integer.parseInt(horaStr);
//#endif


//#if -789891022
            validaHorario(segundo, minuto, hora);
//#endif

        }

//#if 1728141046
        catch (NumberFormatException ne) { //1

//#if 1694524907
            throw new InvalidDateException(segundo, minuto, hora);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1274874879
    public int getSegundo()
    {

//#if -1072533221
        return segundo;
//#endif

    }

//#endif


//#if 277308596
    public String format(int formato)
    {

//#if 2021593204
        return format(this, formato);
//#endif

    }

//#endif


//#if -738613439
    public static String format(Schedule horario, int formato)
    {

//#if 1123556059
        String segundoStr = "", minutoStr = "", horaStr = "";
//#endif


//#if -2138075428
        String texto = null;
//#endif


//#if -687384478
        try { //1

//#if 1053699262
            segundoStr = String.valueOf(horario.getSegundo());
//#endif


//#if -1249189204
            minutoStr = String.valueOf(horario.getMinuto());
//#endif


//#if -639189220
            horaStr = String.valueOf(horario.getHora());
//#endif


//#if 1749603092
            if(segundoStr.length() < 2) { //1

//#if 1436499779
                segundoStr = "0" + segundoStr;
//#endif

            }

//#endif


//#if -153986009
            if(minutoStr.length() < 2) { //1

//#if -284533680
                minutoStr = "0" + minutoStr;
//#endif

            }

//#endif


//#if 438211391
            if(horaStr.length() < 2) { //1

//#if -271878435
                horaStr = "0" + horaStr;
//#endif

            }

//#endif

        }

//#if -555956080
        catch (NumberFormatException nb) { //1
        }
//#endif


//#endif


//#if -1637524579
        switch (formato) { //1
        case (FORMATO1)://1


//#if 24388680
            texto = horaStr + ":" + minutoStr + ":" + segundoStr;
//#endif


//#if 1170826386
            break;

//#endif


        case (FORMATO2)://1


//#if -40612562
            texto = horaStr + minutoStr + segundoStr;
//#endif


//#if -1395119890
            break;

//#endif


        default://1


//#if 76563480
            texto = null;
//#endif


//#if -1924173699
            break;

//#endif


        }

//#endif


//#if 1460888949
        return texto;
//#endif

    }

//#endif

}

//#endif


//#endif

