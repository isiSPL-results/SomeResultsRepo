// Compilation Unit of /Date.java 
 
package lib.util;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import lib.exceptions.InvalidDateException;
public class Date implements Serializable
  { 
private int dia;
private int mes;
private int ano;
public Schedule horario;
public static final int FORMATO1 = 1;
public static final int FORMATO2 = 2;
public static final int FORMATO3 = 3;
public static final int FORMATO4 = 4;
public static final int FORMATO5 = 5;
public Date(String diaStr, String mesStr, String anoStr) throws InvalidDateException
    { 
try //1
{ 
this.dia = Integer.parseInt(diaStr);
this.mes = Integer.parseInt(mesStr);
this.ano = Integer.parseInt(anoStr);
this.horario = null;
} 
catch (Exception e) //1
{ 
throw new InvalidDateException(dia, mes, ano);
} 


validaData(dia, mes, ano);
} 

public Date(int dia, int mes, int ano) throws InvalidDateException
    { 
this.dia = dia;
this.mes = mes;
this.ano = ano;
this.horario = null;
validaData(dia, mes, ano);
} 

public Schedule getHorario()
    { 
return horario;
} 

public Date(int segundo, int minuto, int hora, int dia, int mes, int ano)
    throws InvalidDateException
    { 
try //1
{ 
this.dia = dia;
this.mes = mes;
this.ano = ano;
horario = new Schedule(segundo, minuto, hora);
validaData(dia, mes, ano);
} 
catch (InvalidDateException e) //1
{ 
throw new InvalidDateException(dia, mes, ano);
} 


} 

public static int diferencaEmDias(Date dtIni, Date dtFim)
    { 
int diferenca = 0;
while (dtIni.compara(dtFim) != 0) //1
{ 
dtIni = dtIni.proximaData();
diferenca++;
} 

return diferenca;
} 

public static void addDias(Date data, int dias)
    { 
Date novaData;
novaData = data;
while (dias > 0) //1
{ 
novaData = novaData.proximaData();
dias = dias - 1;
} 

data.dia = novaData.dia;
data.mes = novaData.mes;
data.ano = novaData.ano;
data.horario = novaData.horario;
} 

public long diferencaEmSegundos(Date data)
    { 
int segundo2, minuto2, hora2, dia2, mes2, ano2;
int segundo1, minuto1, hora1;
int diferSegundo, diferMinuto, diferHora, diferDia, diferMes, diferAno;
Schedule horario2;
long diferenca = 0;
horario2 = data.getHorario();
dia2 = data.getDia();
mes2 = data.getMes();
ano2 = data.getAno();
if(horario2 != null)//1
{ 
segundo2 = horario2.getSegundo();
minuto2 = horario2.getMinuto();
hora2 = horario2.getHora();
} 
else
{ 
segundo2 = 0;
minuto2 = 0;
hora2 = 0;
} 

if(horario != null)//1
{ 
segundo1 = horario.getSegundo();
minuto1 = horario.getMinuto();
hora1 = horario.getHora();
} 
else
{ 
segundo1 = 0;
minuto1 = 0;
hora1 = 0;
} 

diferSegundo = segundo2 - segundo1;
diferMinuto = minuto2 - minuto1;
diferHora = hora2 - hora1;
diferDia = dia2 - dia;
diferMes = mes2 - mes;
diferAno = ano2 - ano;
diferenca = (diferSegundo + 60 * (diferMinuto + 60 * (diferHora + 24 * (diferDia + 30 * (diferMes + 12 * diferAno)))));
return diferenca;
} 

public int getMes()
    { 
return mes;
} 

public String format(int formato)
    { 
return format(this, formato);
} 

private void validaData(int dia, int mes, int ano) throws InvalidDateException
    { 
if(1 == 2)//1
{ 
throw new InvalidDateException(dia, mes, ano);
} 

} 

private int numeroDeDiasDoMes(int mes)
    { 
int retorno = -1;
GregorianCalendar calendar = new GregorianCalendar();
switch (mes) //1
{ 
case 1://1

retorno = 31;
break;


case 2://1

if(calendar.isLeapYear(ano))//1
{ 
retorno = 29;
} 
else
{ 
retorno = 28;
} 

break;


case 3://1

retorno = 31;
break;


case 4://1

retorno = 30;
break;


case 5://1

retorno = 31;
break;


case 6://1

retorno = 30;
break;


case 7://1

retorno = 31;
break;


case 8://1

retorno = 31;
break;


case 9://1

retorno = 30;
break;


case 10://1

retorno = 31;
break;


case 11://1

retorno = 30;
break;


case 12://1

retorno = 31;

} 

return retorno;
} 

public Date anteriorData()
    { 
Date dataRetorno = null;
int tag;
int monat;
int jahre;
if(dia > 1)//1
{ 
tag = dia - 1;
monat = mes;
jahre = ano;
} 
else
if(dia == 1 && (mes != 1))//1
{ 
tag = numeroDeDiasDoMes(mes - 1);
monat = mes - 1;
jahre = ano;
} 
else
{ 
tag = 31;
monat = 12;
jahre = ano - 1;
} 


try //1
{ 
dataRetorno = new Date(tag, monat, jahre);
} 
catch (InvalidDateException die) //1
{
}

return dataRetorno;
} 

public boolean ehFinalDeSemana()
    { 
Date data = null;
try //1
{ 
data = new Date(dia, mes, ano);
} 
catch (Exception e) //1
{
}

return ehFinalDeSemana(data);
} 

public int getDia()
    { 
return dia;
} 

public static String format(Date data, int formato)
    { 
String diaStr = "", mesStr = "", anoStr = "";
String texto = "";
Schedule horario;
try //1
{ 
horario = data.getHorario();
diaStr = String.valueOf(data.getDia());
mesStr = String.valueOf(data.getMes());
anoStr = String.valueOf(data.getAno());
if(diaStr.length() < 2)//1
{ 
diaStr = "0" + diaStr;
} 

if(mesStr.length() < 2)//1
{ 
mesStr = "0" + mesStr;
} 

for (int i = anoStr.length(); i < 4; i++) //1
{ 
anoStr = "0" + anoStr;
} 

switch (formato) //1
{ 
case (FORMATO1)://1

texto = diaStr + "/" + mesStr + "/" + anoStr;
break;


case (FORMATO2)://1

texto = diaStr + "/" + mesStr + "/" + anoStr;
texto += ":" + horario.format(Schedule.FORMATO1);
break;


case (FORMATO3)://1

texto = diaStr + mesStr + anoStr;
break;


case (FORMATO4)://1

texto = diaStr + mesStr + anoStr;
texto += horario.format(Schedule.FORMATO2);
break;


case (FORMATO5)://1

texto = diaStr + "/" + mesStr + "/" + anoStr;
break;


default://1

texto = null;
break;


} 

} 
catch (NumberFormatException nb) //1
{
}

return texto;
} 

public static Date stringToData(String dataStr, int formato) throws InvalidDateException
    { 
String diaStr, mesStr, anoStr;
String minutoStr, segundoStr, horaStr;
Date data = null;
try //1
{ 
switch (formato) //1
{ 
case (FORMATO1)://1

diaStr = dataStr.substring(0, 2);
mesStr = dataStr.substring(3, 5);
anoStr = dataStr.substring(6, 10);
data = new Date(diaStr, mesStr, anoStr);
break;


case (FORMATO2)://1

diaStr = dataStr.substring(0, 2);
mesStr = dataStr.substring(3, 5);
anoStr = dataStr.substring(6, 10);
horaStr = dataStr.substring(11, 13);
minutoStr = dataStr.substring(14, 16);
segundoStr = dataStr.substring(17, 19);
data = new Date(segundoStr, minutoStr, horaStr, diaStr, mesStr, anoStr);
break;


case (FORMATO3)://1

diaStr = dataStr.substring(0, 2);
mesStr = dataStr.substring(2, 4);
anoStr = dataStr.substring(4, 8);
break;


case (FORMATO4)://1

diaStr = dataStr.substring(0, 2);
mesStr = dataStr.substring(2, 4);
anoStr = dataStr.substring(4, 8);
horaStr = dataStr.substring(8, 10);
minutoStr = dataStr.substring(10, 12);
segundoStr = dataStr.substring(12, 14);
data = new Date(segundoStr, minutoStr, horaStr, diaStr, mesStr, anoStr);
break;


case (FORMATO5)://1

anoStr = dataStr.substring(0, 4);
mesStr = dataStr.substring(5, 7);
diaStr = dataStr.substring(8, 10);
data = new Date(diaStr, mesStr, anoStr);
break;


default://1

data = null;
break;


} 

} 
catch (Exception nb) //1
{ 
throw new InvalidDateException(dataStr);
} 


return data;
} 

public static void main(String args[])
    { 
try //1
{ 
Calendar agora = Calendar.getInstance();
Date d = new Date(agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH), agora
                              .get(Calendar.YEAR));
System.out.println(d.toString());
} 
catch (Exception ex) //1
{ 
System.out.println(ex.getMessage());
} 


} 

public int compara(Date data)
    { 
int retorno = 0;
if(ano > data.getAno())//1
{ 
retorno = 1;
} 
else
if(ano < data.getAno())//1
{ 
retorno = -1;
} 
else
{ 
if(mes > data.getMes())//1
{ 
retorno = 1;
} 
else
if(mes < data.getMes())//1
{ 
retorno = -1;
} 
else
{ 
if(dia > data.getDia())//1
{ 
retorno = 1;
} 
else
if(dia < data.getDia())//1
{ 
retorno = -1;
} 


} 


} 


return retorno;
} 

public int getAno()
    { 
return ano;
} 

public Date proximaData()
    { 
Date dataRetorno = null;
int tag;
int monat;
int jahre;
if(dia < this.numeroDeDiasDoMes(mes))//1
{ 
tag = dia + 1;
monat = mes;
jahre = ano;
} 
else
if(dia == this.numeroDeDiasDoMes(mes) && (mes != 12))//1
{ 
tag = 1;
monat = mes + 1;
jahre = ano;
} 
else
{ 
tag = 1;
monat = 1;
jahre = ano + 1;
} 


try //1
{ 
dataRetorno = new Date(tag, monat, jahre);
} 
catch (InvalidDateException die) //1
{
}

return dataRetorno;
} 

public String toString()
    { 
return dia + "/" + mes + "/" + ano;
} 

public Date(String segundoStr, String minutoStr, String horaStr, String diaStr, String mesStr,
                String anoStr) throws InvalidDateException
    { 
try //1
{ 
this.dia = Integer.parseInt(diaStr);
this.mes = Integer.parseInt(mesStr);
this.ano = Integer.parseInt(anoStr);
this.horario = new Schedule(Integer.parseInt(segundoStr), Integer.parseInt(minutoStr),
                                        Integer.parseInt(horaStr));
} 
catch (Exception e) //1
{ 
throw new InvalidDateException(dia, mes, ano);
} 


validaData(dia, mes, ano);
} 

public static boolean ehFinalDeSemana(Date data)
    { 
GregorianCalendar calendar = new GregorianCalendar();
int diaDaSemana = 0;
boolean retorno = false;
calendar.set(data.getAno() - 1900, data.getMes(), data.getDia());
diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK);
if(diaDaSemana == Calendar.SUNDAY || diaDaSemana == Calendar.SATURDAY)//1
{ 
retorno = true;
} 

return retorno;
} 

 } 


