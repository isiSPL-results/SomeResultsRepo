
//#if -1999145947
// Compilation Unit of /Date.java


//#if -2071499191
package lib.util;
//#endif


//#if 1016662684
import java.io.Serializable;
//#endif


//#if 351761945
import java.util.Calendar;
//#endif


//#if 1551623835
import java.util.GregorianCalendar;
//#endif


//#if -1332672492
import lib.exceptions.InvalidDateException;
//#endif


//#if 2120957214
public class Date implements
//#if -486935306
    Serializable
//#endif

{

//#if -1611402526
    private int dia;
//#endif


//#if -1611137693
    private int mes;
//#endif


//#if -1611486660
    private int ano;
//#endif


//#if -1618973744
    public Schedule horario;
//#endif


//#if 1767335815
    public static final int FORMATO1 = 1;
//#endif


//#if 1767365637
    public static final int FORMATO2 = 2;
//#endif


//#if 1767395459
    public static final int FORMATO3 = 3;
//#endif


//#if 1767425281
    public static final int FORMATO4 = 4;
//#endif


//#if 1767455103
    public static final int FORMATO5 = 5;
//#endif


//#if 2064253991
    public Date(String diaStr, String mesStr, String anoStr) throws InvalidDateException
    {

//#if 1837359070
        try { //1

//#if 293221922
            this.dia = Integer.parseInt(diaStr);
//#endif


//#if -1144966974
            this.mes = Integer.parseInt(mesStr);
//#endif


//#if 1422791266
            this.ano = Integer.parseInt(anoStr);
//#endif


//#if 1923599225
            this.horario = null;
//#endif

        }

//#if -1372223928
        catch (Exception e) { //1

//#if 973027053
            throw new InvalidDateException(dia, mes, ano);
//#endif

        }

//#endif


//#endif


//#if -871557822
        validaData(dia, mes, ano);
//#endif

    }

//#endif


//#if -814677614
    public Date(int dia, int mes, int ano) throws InvalidDateException
    {

//#if -2138272066
        this.dia = dia;
//#endif


//#if 1922661184
        this.mes = mes;
//#endif


//#if 1766506610
        this.ano = ano;
//#endif


//#if -1156405797
        this.horario = null;
//#endif


//#if 353102316
        validaData(dia, mes, ano);
//#endif

    }

//#endif


//#if -204304028
    public Schedule getHorario()
    {

//#if 1084103227
        return horario;
//#endif

    }

//#endif


//#if 765337118
    public Date(int segundo, int minuto, int hora, int dia, int mes, int ano)
    throws InvalidDateException
    {

//#if 1805635499
        try { //1

//#if -1271444925
            this.dia = dia;
//#endif


//#if -1505478971
            this.mes = mes;
//#endif


//#if -1661633545
            this.ano = ano;
//#endif


//#if -228522006
            horario = new Schedule(segundo, minuto, hora);
//#endif


//#if -1774634681
            validaData(dia, mes, ano);
//#endif

        }

//#if -285717202
        catch (InvalidDateException e) { //1

//#if 1925518860
            throw new InvalidDateException(dia, mes, ano);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -1752562504
    public static int diferencaEmDias(Date dtIni, Date dtFim)
    {

//#if 486754658
        int diferenca = 0;
//#endif


//#if 1727026453
        while (dtIni.compara(dtFim) != 0) { //1

//#if 1211872380
            dtIni = dtIni.proximaData();
//#endif


//#if 1591582753
            diferenca++;
//#endif

        }

//#endif


//#if -2031640170
        return diferenca;
//#endif

    }

//#endif


//#if 1424217093
    public static void addDias(Date data, int dias)
    {

//#if -131996365
        Date novaData;
//#endif


//#if -702826386
        novaData = data;
//#endif


//#if -1465155828
        while (dias > 0) { //1

//#if -641383422
            novaData = novaData.proximaData();
//#endif


//#if 247134381
            dias = dias - 1;
//#endif

        }

//#endif


//#if 629765270
        data.dia = novaData.dia;
//#endif


//#if -961786314
        data.mes = novaData.mes;
//#endif


//#if -2057062698
        data.ano = novaData.ano;
//#endif


//#if 934842454
        data.horario = novaData.horario;
//#endif

    }

//#endif


//#if -720378236
    public long diferencaEmSegundos(Date data)
    {

//#if 218631121
        int segundo2, minuto2, hora2, dia2, mes2, ano2;
//#endif


//#if -745640019
        int segundo1, minuto1, hora1;
//#endif


//#if -570164003
        int diferSegundo, diferMinuto, diferHora, diferDia, diferMes, diferAno;
//#endif


//#if 1261108005
        Schedule horario2;
//#endif


//#if -875414978
        long diferenca = 0;
//#endif


//#if 305599080
        horario2 = data.getHorario();
//#endif


//#if 555165864
        dia2 = data.getDia();
//#endif


//#if 82451016
        mes2 = data.getMes();
//#endif


//#if -211166488
        ano2 = data.getAno();
//#endif


//#if 841782295
        if(horario2 != null) { //1

//#if -905372464
            segundo2 = horario2.getSegundo();
//#endif


//#if -2004683314
            minuto2 = horario2.getMinuto();
//#endif


//#if -2069664674
            hora2 = horario2.getHora();
//#endif

        } else {

//#if -1548242882
            segundo2 = 0;
//#endif


//#if -509700507
            minuto2 = 0;
//#endif


//#if -394972675
            hora2 = 0;
//#endif

        }

//#endif


//#if 1160065521
        if(horario != null) { //1

//#if -1284512605
            segundo1 = horario.getSegundo();
//#endif


//#if 74362009
            minuto1 = horario.getMinuto();
//#endif


//#if -1761583079
            hora1 = horario.getHora();
//#endif

        } else {

//#if -1353677748
            segundo1 = 0;
//#endif


//#if -1196189703
            minuto1 = 0;
//#endif


//#if -230353839
            hora1 = 0;
//#endif

        }

//#endif


//#if 1712395826
        diferSegundo = segundo2 - segundo1;
//#endif


//#if -1595300671
        diferMinuto = minuto2 - minuto1;
//#endif


//#if -578567271
        diferHora = hora2 - hora1;
//#endif


//#if 308789974
        diferDia = dia2 - dia;
//#endif


//#if 493380117
        diferMes = mes2 - mes;
//#endif


//#if -1056491268
        diferAno = ano2 - ano;
//#endif


//#if 330342948
        diferenca = (diferSegundo + 60 * (diferMinuto + 60 * (diferHora + 24 * (diferDia + 30 * (diferMes + 12 * diferAno)))));
//#endif


//#if -836914459
        return diferenca;
//#endif

    }

//#endif


//#if -960403499
    public int getMes()
    {

//#if -1480323646
        return mes;
//#endif

    }

//#endif


//#if -1401513344
    public String format(int formato)
    {

//#if 1158339131
        return format(this, formato);
//#endif

    }

//#endif


//#if 401813587
    private void validaData(int dia, int mes, int ano) throws InvalidDateException
    {

//#if 1913327023
        if(1 == 2) { //1

//#if 1465050215
            throw new InvalidDateException(dia, mes, ano);
//#endif

        }

//#endif

    }

//#endif


//#if 1823384590
    private int numeroDeDiasDoMes(int mes)
    {

//#if -582765939
        int retorno = -1;
//#endif


//#if 865839646
        GregorianCalendar calendar = new GregorianCalendar();
//#endif


//#if -593341895
        switch (mes) { //1
        case 1://1


//#if 1690465457
            retorno = 31;
//#endif


//#if -121031760
            break;

//#endif


        case 2://1


//#if 315919060
            if(calendar.isLeapYear(ano)) { //1

//#if -689672923
                retorno = 29;
//#endif

            } else {

//#if -47623520
                retorno = 28;
//#endif

            }

//#endif


//#if -1400679637
            break;

//#endif


        case 3://1


//#if -1531739044
            retorno = 31;
//#endif


//#if 1345439013
            break;

//#endif


        case 4://1


//#if -1188288074
            retorno = 30;
//#endif


//#if 1281611788
            break;

//#endif


        case 5://1


//#if 1283347671
            retorno = 31;
//#endif


//#if 1379881930
            break;

//#endif


        case 6://1


//#if 681257946
            retorno = 30;
//#endif


//#if -1071837336
            break;

//#endif


        case 7://1


//#if 270975349
            retorno = 31;
//#endif


//#if -1546584980
            break;

//#endif


        case 8://1


//#if -1350720057
            retorno = 31;
//#endif


//#if -699585318
            break;

//#endif


        case 9://1


//#if -223482437
            retorno = 30;
//#endif


//#if -811670297
            break;

//#endif


        case 10://1


//#if 845453550
            retorno = 31;
//#endif


//#if 340172115
            break;

//#endif


        case 11://1


//#if 1150345146
            retorno = 30;
//#endif


//#if 1419669384
            break;

//#endif


        case 12://1


//#if 1957905956
            retorno = 31;
//#endif


        }

//#endif


//#if -1433700701
        return retorno;
//#endif

    }

//#endif


//#if 1315384785
    public Date anteriorData()
    {

//#if 1676417536
        Date dataRetorno = null;
//#endif


//#if 1906356268
        int tag;
//#endif


//#if -2129887897
        int monat;
//#endif


//#if 2066099778
        int jahre;
//#endif


//#if -894380400
        if(dia > 1) { //1

//#if 1743426128
            tag = dia - 1;
//#endif


//#if 907471408
            monat = mes;
//#endif


//#if 937517668
            jahre = ano;
//#endif

        } else

//#if 434560256
            if(dia == 1 && (mes != 1)) { //1

//#if 307829622
                tag = numeroDeDiasDoMes(mes - 1);
//#endif


//#if 816855078
                monat = mes - 1;
//#endif


//#if 1939274046
                jahre = ano;
//#endif

            } else {

//#if -413308675
                tag = 31;
//#endif


//#if -647238913
                monat = 12;
//#endif


//#if -1210018901
                jahre = ano - 1;
//#endif

            }

//#endif


//#endif


//#if 1904211802
        try { //1

//#if -1300704583
            dataRetorno = new Date(tag, monat, jahre);
//#endif

        }

//#if 1339983453
        catch (InvalidDateException die) { //1
        }
//#endif


//#endif


//#if 662109044
        return dataRetorno;
//#endif

    }

//#endif


//#if 1880490310
    public boolean ehFinalDeSemana()
    {

//#if 326814484
        Date data = null;
//#endif


//#if -1233974565
        try { //1

//#if 1338573738
            data = new Date(dia, mes, ano);
//#endif

        }

//#if -790827721
        catch (Exception e) { //1
        }
//#endif


//#endif


//#if -803223476
        return ehFinalDeSemana(data);
//#endif

    }

//#endif


//#if -968613322
    public int getDia()
    {

//#if -1990730488
        return dia;
//#endif

    }

//#endif


//#if 1949508382
    public static String format(Date data, int formato)
    {

//#if 522554664
        String diaStr = "", mesStr = "", anoStr = "";
//#endif


//#if 146826222
        String texto = "";
//#endif


//#if 1089939889
        Schedule horario;
//#endif


//#if -1336241833
        try { //1

//#if -1877534530
            horario = data.getHorario();
//#endif


//#if 1629593455
            diaStr = String.valueOf(data.getDia());
//#endif


//#if 1384841965
            mesStr = String.valueOf(data.getMes());
//#endif


//#if 1977322939
            anoStr = String.valueOf(data.getAno());
//#endif


//#if -176773492
            if(diaStr.length() < 2) { //1

//#if -2091296797
                diaStr = "0" + diaStr;
//#endif

            }

//#endif


//#if 1045089835
            if(mesStr.length() < 2) { //1

//#if 1194292261
                mesStr = "0" + mesStr;
//#endif

            }

//#endif


//#if 479935287
            for (int i = anoStr.length(); i < 4; i++) { //1

//#if -1830988820
                anoStr = "0" + anoStr;
//#endif

            }

//#endif


//#if 1752387364
            switch (formato) { //1
            case (FORMATO1)://1


//#if -1780180853
                texto = diaStr + "/" + mesStr + "/" + anoStr;
//#endif


//#if -1631168605
                break;

//#endif


            case (FORMATO2)://1


//#if 1959349357
                texto = diaStr + "/" + mesStr + "/" + anoStr;
//#endif


//#if -719492723
                texto += ":" + horario.format(Schedule.FORMATO1);
//#endif


//#if 244480129
                break;

//#endif


            case (FORMATO3)://1


//#if 1598571277
                texto = diaStr + mesStr + anoStr;
//#endif


//#if -1441063007
                break;

//#endif


            case (FORMATO4)://1


//#if -2041954412
                texto = diaStr + mesStr + anoStr;
//#endif


//#if -1324790892
                texto += horario.format(Schedule.FORMATO2);
//#endif


//#if 815037626
                break;

//#endif


            case (FORMATO5)://1


//#if 992176705
                texto = diaStr + "/" + mesStr + "/" + anoStr;
//#endif


//#if 1780042285
                break;

//#endif


            default://1


//#if 358651688
                texto = null;
//#endif


//#if 1396405101
                break;

//#endif


            }

//#endif

        }

//#if 96127907
        catch (NumberFormatException nb) { //1
        }
//#endif


//#endif


//#if -1552723286
        return texto;
//#endif

    }

//#endif


//#if -2045658965
    public static Date stringToData(String dataStr, int formato) throws InvalidDateException
    {

//#if 1784208300
        String diaStr, mesStr, anoStr;
//#endif


//#if -922836070
        String minutoStr, segundoStr, horaStr;
//#endif


//#if -1978994433
        Date data = null;
//#endif


//#if -730772538
        try { //1

//#if -1310813099
            switch (formato) { //1
            case (FORMATO1)://1


//#if 307575099
                diaStr = dataStr.substring(0, 2);
//#endif


//#if 1644463682
                mesStr = dataStr.substring(3, 5);
//#endif


//#if 1234314810
                anoStr = dataStr.substring(6, 10);
//#endif


//#if 7982484
                data = new Date(diaStr, mesStr, anoStr);
//#endif


//#if -2100395755
                break;

//#endif


            case (FORMATO2)://1


//#if -425430191
                diaStr = dataStr.substring(0, 2);
//#endif


//#if 911458392
                mesStr = dataStr.substring(3, 5);
//#endif


//#if -14012700
                anoStr = dataStr.substring(6, 10);
//#endif


//#if -818084079
                horaStr = dataStr.substring(11, 13);
//#endif


//#if -39080887
                minutoStr = dataStr.substring(14, 16);
//#endif


//#if 1229654060
                segundoStr = dataStr.substring(17, 19);
//#endif


//#if 1942385216
                data = new Date(segundoStr, minutoStr, horaStr, diaStr, mesStr, anoStr);
//#endif


//#if -2146755285
                break;

//#endif


            case (FORMATO3)://1


//#if -1139106551
                diaStr = dataStr.substring(0, 2);
//#endif


//#if 196857550
                mesStr = dataStr.substring(2, 4);
//#endif


//#if -1270158227
                anoStr = dataStr.substring(4, 8);
//#endif


//#if 921497315
                break;

//#endif


            case (FORMATO4)://1


//#if 37355009
                diaStr = dataStr.substring(0, 2);
//#endif


//#if 1373319110
                mesStr = dataStr.substring(2, 4);
//#endif


//#if -93696667
                anoStr = dataStr.substring(4, 8);
//#endif


//#if -800645916
                horaStr = dataStr.substring(8, 10);
//#endif


//#if 2038291993
                minutoStr = dataStr.substring(10, 12);
//#endif


//#if 315719932
                segundoStr = dataStr.substring(12, 14);
//#endif


//#if -159559440
                data = new Date(segundoStr, minutoStr, horaStr, diaStr, mesStr, anoStr);
//#endif


//#if 1981396955
                break;

//#endif


            case (FORMATO5)://1


//#if -333539205
                anoStr = dataStr.substring(0, 4);
//#endif


//#if 1139947946
                mesStr = dataStr.substring(5, 7);
//#endif


//#if -1638500690
                diaStr = dataStr.substring(8, 10);
//#endif


//#if -1220100304
                data = new Date(diaStr, mesStr, anoStr);
//#endif


//#if -1345099271
                break;

//#endif


            default://1


//#if 1110259879
                data = null;
//#endif


//#if 1709629730
                break;

//#endif


            }

//#endif

        }

//#if -2080085489
        catch (Exception nb) { //1

//#if -561287815
            throw new InvalidDateException(dataStr);
//#endif

        }

//#endif


//#endif


//#if -834323567
        return data;
//#endif

    }

//#endif


//#if 307381388
    public static void main(String args[])
    {

//#if 671292413
        try { //1

//#if -613190775
            Calendar agora = Calendar.getInstance();
//#endif


//#if 371777859
            Date d = new Date(agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH), agora
                              .get(Calendar.YEAR));
//#endif


//#if 1908551982
            System.out.println(d.toString());
//#endif

        }

//#if 309557218
        catch (Exception ex) { //1

//#if -2016258709
            System.out.println(ex.getMessage());
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -484777317
    public int compara(Date data)
    {

//#if 324484343
        int retorno = 0;
//#endif


//#if -1026492531
        if(ano > data.getAno()) { //1

//#if -1057893716
            retorno = 1;
//#endif

        } else

//#if -248549750
            if(ano < data.getAno()) { //1

//#if -1377154001
                retorno = -1;
//#endif

            } else {

//#if -1514105395
                if(mes > data.getMes()) { //1

//#if 1430019004
                    retorno = 1;
//#endif

                } else

//#if -2092865773
                    if(mes < data.getMes()) { //1

//#if -672563732
                        retorno = -1;
//#endif

                    } else {

//#if 1408909686
                        if(dia > data.getDia()) { //1

//#if -1798421508
                            retorno = 1;
//#endif

                        } else

//#if 466548773
                            if(dia < data.getDia()) { //1

//#if 1144971596
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


//#if 618142145
        return retorno;
//#endif

    }

//#endif


//#if -971221476
    public int getAno()
    {

//#if 1358241944
        return ano;
//#endif

    }

//#endif


//#if 264240303
    public Date proximaData()
    {

//#if 1857204006
        Date dataRetorno = null;
//#endif


//#if -1162960942
        int tag;
//#endif


//#if -1101194355
        int monat;
//#endif


//#if -1200173976
        int jahre;
//#endif


//#if 1855975621
        if(dia < this.numeroDeDiasDoMes(mes)) { //1

//#if 1494181452
            tag = dia + 1;
//#endif


//#if 658228654
            monat = mes;
//#endif


//#if 688274914
            jahre = ano;
//#endif

        } else

//#if -1784490963
            if(dia == this.numeroDeDiasDoMes(mes) && (mes != 12)) { //1

//#if 223440844
                tag = 1;
//#endif


//#if -679411593
                monat = mes + 1;
//#endif


//#if 1307550161
                jahre = ano;
//#endif

            } else {

//#if -1283254883
                tag = 1;
//#endif


//#if -91299112
                monat = 1;
//#endif


//#if -1574534980
                jahre = ano + 1;
//#endif

            }

//#endif


//#endif


//#if 281180916
        try { //1

//#if -1219555870
            dataRetorno = new Date(tag, monat, jahre);
//#endif

        }

//#if 913042225
        catch (InvalidDateException die) { //1
        }
//#endif


//#endif


//#if 2061428750
        return dataRetorno;
//#endif

    }

//#endif


//#if 1017403102
    public String toString()
    {

//#if 1884376129
        return dia + "/" + mes + "/" + ano;
//#endif

    }

//#endif


//#if -373741844
    public Date(String segundoStr, String minutoStr, String horaStr, String diaStr, String mesStr,
                String anoStr) throws InvalidDateException
    {

//#if 1179899044
        try { //1

//#if -911735958
            this.dia = Integer.parseInt(diaStr);
//#endif


//#if 1945042442
            this.mes = Integer.parseInt(mesStr);
//#endif


//#if 217833386
            this.ano = Integer.parseInt(anoStr);
//#endif


//#if 711561423
            this.horario = new Schedule(Integer.parseInt(segundoStr), Integer.parseInt(minutoStr),
                                        Integer.parseInt(horaStr));
//#endif

        }

//#if 2076114821
        catch (Exception e) { //1

//#if -2004647645
            throw new InvalidDateException(dia, mes, ano);
//#endif

        }

//#endif


//#endif


//#if 638559368
        validaData(dia, mes, ano);
//#endif

    }

//#endif


//#if 1155358012
    public static boolean ehFinalDeSemana(Date data)
    {

//#if -1239486131
        GregorianCalendar calendar = new GregorianCalendar();
//#endif


//#if -1870815529
        int diaDaSemana = 0;
//#endif


//#if -1692499222
        boolean retorno = false;
//#endif


//#if -1312719877
        calendar.set(data.getAno() - 1900, data.getMes(), data.getDia());
//#endif


//#if -959918492
        diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK);
//#endif


//#if -1581587094
        if(diaDaSemana == Calendar.SUNDAY || diaDaSemana == Calendar.SATURDAY) { //1

//#if -1951399262
            retorno = true;
//#endif

        }

//#endif


//#if -886629932
        return retorno;
//#endif

    }

//#endif

}

//#endif


//#endif

