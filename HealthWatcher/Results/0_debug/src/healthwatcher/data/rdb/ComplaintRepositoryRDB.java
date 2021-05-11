
//#if -736355472
// Compilation Unit of /ComplaintRepositoryRDB.java


//#if 888913700
package healthwatcher.data.rdb;
//#endif


//#if 1616793543
import healthwatcher.data.IComplaintRepository;
//#endif


//#if 549644898
import healthwatcher.model.address.Address;
//#endif


//#if -424883056
import healthwatcher.model.complaint.AnimalComplaint;
//#endif


//#if -398696332
import healthwatcher.model.complaint.Complaint;
//#endif


//#if 1839303026
import healthwatcher.model.complaint.FoodComplaint;
//#endif


//#if -164471163
import healthwatcher.model.complaint.SpecialComplaint;
//#endif


//#if -1981172114
import healthwatcher.model.employee.Employee;
//#endif


//#if -675661612
import java.sql.ResultSet;
//#endif


//#if 539892348
import java.sql.SQLException;
//#endif


//#if -318863446
import java.sql.Statement;
//#endif


//#if 909634322
import java.util.ArrayList;
//#endif


//#if 118433807
import java.util.List;
//#endif


//#if 1385303811
import java.util.StringTokenizer;
//#endif


//#if 556846451
import lib.exceptions.ExceptionMessages;
//#endif


//#if -1466291074
import lib.exceptions.InvalidDateException;
//#endif


//#if -1225388214
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -437026931
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -1602902137
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -626757383
import lib.exceptions.PersistenceMechanismException;
//#endif


//#if 429572642
import lib.exceptions.PersistenceSoftException;
//#endif


//#if 781152393
import lib.exceptions.RepositoryException;
//#endif


//#if -112296770
import lib.persistence.IPersistenceMechanism;
//#endif


//#if -1864144485
import lib.persistence.PersistenceMechanism;
//#endif


//#if -1615413933
import lib.util.ConcreteIterator;
//#endif


//#if 20497304
import lib.util.Date;
//#endif


//#if 1960218594
import lib.util.IteratorDsk;
//#endif


//#if 259747169
import lib.exceptions.SQLPersistenceMechanismException;
//#endif


//#if 419541921
public class ComplaintRepositoryRDB implements
//#if 308171822
    IComplaintRepository
//#endif

{

//#if 793463062
    private IPersistenceMechanism mp;
//#endif


//#if -271278353
    protected ResultSet resultSet;
//#endif


//#if 351221567
    private AddressRepositoryRDB addressRep;
//#endif


//#if 2037708387
    private EmployeeRepositoryRDB employeeRep;
//#endif


//#if 202799925
    private static final int FOOD_COMPLAINT = 1;
//#endif


//#if 730718326
    private static final int ANIMAL_COMPLAINT = 2;
//#endif


//#if 2102256552
    private static final int SPECIAL_COMPLAINT = 3;
//#endif


//#if -1601647867
    public ComplaintRepositoryRDB(IPersistenceMechanism mp)
    {

//#if -651165480
        this.mp = mp;
//#endif


//#if 1193722025
        addressRep = new AddressRepositoryRDB(mp);
//#endif


//#if 2063073857
        employeeRep = new EmployeeRepositoryRDB(mp);
//#endif

    }

//#endif


//#if 1769825722
    private void accessComplaint(ResultSet resultSet, Complaint complaint) throws
        ObjectNotFoundException, RepositoryException
    {

//#if -1197242451
        try { //1

//#if -382523251
            complaint.setCodigo((new Integer(resultSet.getString("codigo"))).intValue());
//#endif


//#if -776263880
            complaint.setSolicitante(resultSet.getString("solicitante"));
//#endif


//#if 515481400
            complaint.setDescricao(resultSet.getString("descricao"));
//#endif


//#if -1195955094
            complaint.setObservacao(resultSet.getString("observacao"));
//#endif


//#if -250454568
            complaint.setEmail(resultSet.getString("email"));
//#endif


//#if -1729564498
            String funcionario = resultSet.getString("funcionario");
//#endif


//#if -1819632669
            Employee employee = null;
//#endif


//#if -1068636542
            if(funcionario != null && !funcionario.equalsIgnoreCase("null")) { //1

//#if 402499068
                employee = employeeRep.search(funcionario);
//#endif

            }

//#endif


//#if -442465803
            complaint.setAtendente(employee);
//#endif


//#if 23761073
            complaint.setSituacao((new Integer(resultSet.getString("situacao"))).intValue());
//#endif


//#if -187280730
            try { //1

//#if -1098443653
                java.util.Date d = null;
//#endif


//#if -854554370
                String date = resultSet.getString("dataParecer");
//#endif


//#if 206567239
                if(!date.equals("NULL")) { //1

//#if 885617483
                    StringTokenizer token = new StringTokenizer(date, "/");
//#endif


//#if -843499628
                    int day = (new Integer(token.nextToken())).intValue();
//#endif


//#if -1435730504
                    int month = (new Integer(token.nextToken())).intValue();
//#endif


//#if -1729703393
                    int year = (new Integer(token.nextToken())).intValue();
//#endif


//#if -1313675024
                    d = new java.util.Date(year, month, day);
//#endif

                }

//#endif


//#if 1317147798
                if(d != null) { //1

//#if -803297245
                    try { //1

//#if -734570908
                        complaint.setDataParecer(new Date(d.getDate(), d.getMonth() + 1, d
                                                          .getYear() + 1900));
//#endif

                    }

//#if 658819907
                    catch (InvalidDateException ex) { //1
                    }
//#endif


//#endif

                } else {

//#if -1402070387
                    complaint.setDataParecer(null);
//#endif

                }

//#endif


//#if 220133374
                date = resultSet.getString("dataQueixa");
//#endif


//#if -843441654
                if(!date.equals("NULL")) { //2

//#if 2038576720
                    StringTokenizer token = new StringTokenizer(date, "/");
//#endif


//#if 309459609
                    int day = (new Integer(token.nextToken())).intValue();
//#endif


//#if -1543466115
                    int month = (new Integer(token.nextToken())).intValue();
//#endif


//#if -347705414
                    int year = (new Integer(token.nextToken())).intValue();
//#endif


//#if 2129471669
                    d = new java.util.Date(year, month, day);
//#endif

                } else {

//#if -1730467611
                    d = null;
//#endif

                }

//#endif


//#if 328910427
                if(d != null) { //2

//#if 775664787
                    try { //1

//#if -2075063852
                        complaint.setDataQueixa(new Date(d.getDate(), d.getMonth() + 1,
                                                         d.getYear() + 1900));
//#endif

                    }

//#if 565011593
                    catch (InvalidDateException ex) { //1
                    }
//#endif


//#endif

                } else {

//#if -388052398
                    complaint.setDataQueixa(null);
//#endif

                }

//#endif

            }

//#if -631860872
            catch (Exception e) { //1

//#if 12741527
                e.printStackTrace();
//#endif

            }

//#endif


//#endif


//#if 467250305
            int codEndereco = resultSet.getInt("enderecosolicitante");
//#endif


//#if 1471282516
            Address endSol = addressRep.search(codEndereco);
//#endif


//#if 980878772
            complaint.setEnderecoSolicitante(endSol);
//#endif

        }

//#if 421186400
        catch (RepositoryException e) { //1

//#if -1013109493
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if 1913904612
        catch (ObjectNotFoundException e) { //1

//#if -1447758939
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if 122359796
        catch (SQLException e) { //1

//#if -1715323010
            throw new PersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -2055187981
    private void deepInsertCommon(Complaint complaint) throws ObjectAlreadyInsertedException,
                PersistenceMechanismException, RepositoryException
    {

//#if -687237473
        try { //1

//#if -1857867733
            if(complaint.getEnderecoSolicitante() != null) { //1

//#if -27436563
                try { //1

//#if 1236694000
                    addressRep.insert(complaint.getEnderecoSolicitante());
//#endif

                }

//#if -927017344
                catch (ObjectNotValidException e) { //1
                }
//#endif


//#endif

            }

//#endif


//#if 527418099
            int complaintType = -1;
//#endif


//#if 755637033
            if(complaint instanceof SpecialComplaint) { //1

//#if -819104642
                complaintType = SPECIAL_COMPLAINT;
//#endif

            } else

//#if 153732892
                if(complaint instanceof FoodComplaint) { //1

//#if 2080491817
                    complaintType = FOOD_COMPLAINT;
//#endif

                } else

//#if -1316861919
                    if(complaint instanceof AnimalComplaint) { //1

//#if -181398800
                        complaintType = ANIMAL_COMPLAINT;
//#endif

                    }

//#endif


//#endif


//#endif


//#if 1391557324
            String sql = "INSERT INTO SCBS_queixa (codigo,tipoqueixa,solicitante,descricao,observacao,email,funcionario,situacao,dataparecer,dataqueixa,enderecosolicitante,ts) VALUES(";
//#endif


//#if -368493414
            sql += "'" + complaint.getCodigo() + "'" + ",";
//#endif


//#if -1009403358
            sql += "'" + complaintType + "'" + ",";
//#endif


//#if -335379359
            sql += "'" + complaint.getSolicitante() + "',";
//#endif


//#if -2147067785
            sql += "'" + complaint.getDescricao() + "',";
//#endif


//#if -332655945
            sql += "'" + complaint.getObservacao() + "',";
//#endif


//#if 350996170
            sql += "'" + complaint.getEmail() + "',";
//#endif


//#if 2082856035
            if(complaint.getAtendente() != null) { //1

//#if 243389955
                sql += "'" + complaint.getAtendente().getLogin() + "','";
//#endif

            } else {

//#if -963302743
                sql += "'NULL',";
//#endif

            }

//#endif


//#if 1515180236
            sql += "'" + complaint.getSituacao() + "'" + ",";
//#endif


//#if -1140826781
            if(complaint.getDataParecer() != null) { //1

//#if 474758359
                sql += "'" + Date.format(complaint.getDataParecer(), Date.FORMATO1) + "'";
//#endif

            } else {

//#if -516022283
                sql += "'NULL',";
//#endif

            }

//#endif


//#if -462488206
            if(complaint.getDataQueixa() != null) { //1

//#if -680724170
                sql += "'" + Date.format(complaint.getDataQueixa(), Date.FORMATO1) + "',";
//#endif

            } else {

//#if 1742358006
                sql += "'',";
//#endif

            }

//#endif


//#if 1505986214
            if(complaint.getEnderecoSolicitante() != null) { //2

//#if 208335311
                sql += "'" + complaint.getEnderecoSolicitante().getCode() + "'";
//#endif

            } else {

//#if -20087481
                sql += "NULL";
//#endif

            }

//#endif


//#if -399317330
            sql += ",'" + complaint.getTimestamp() + "');";
//#endif


//#if -1916898421
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 622489363
            stmt.executeUpdate(sql);
//#endif


//#if -2112647707
            stmt.close();
//#endif

        }

//#if 298148583
        catch (PersistenceMechanismException e) { //1

//#if -76943396
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if 327623101
        catch (SQLException e) { //1

//#if -1864129754
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -572265662
    private void deepInsertSpecial(SpecialComplaint complaint)
    throws PersistenceMechanismException, RepositoryException,
        ObjectAlreadyInsertedException
    {

//#if 610806396
        if(complaint.getEnderecoOcorrencia() != null) { //1

//#if 835990070
            try { //1

//#if -2134195146
                addressRep.insert(complaint.getEnderecoOcorrencia());
//#endif

            }

//#if -1882381402
            catch (ObjectNotValidException e) { //1
            }
//#endif


//#endif

        }

//#endif


//#if -1109395699
        insertSpecial(complaint);
//#endif

    }

//#endif


//#if 1406210319
    private void accessComplaint(ResultSet resultSet, Complaint complaint) throws SQLException,
        ObjectNotFoundException, RepositoryException
    {

//#if 1779294547
        try { //1

//#if 1400041636
            complaint.setCodigo((new Integer(resultSet.getString("codigo"))).intValue());
//#endif


//#if 1131222017
            complaint.setSolicitante(resultSet.getString("solicitante"));
//#endif


//#if 1575704705
            complaint.setDescricao(resultSet.getString("descricao"));
//#endif


//#if -228608141
            complaint.setObservacao(resultSet.getString("observacao"));
//#endif


//#if -118329311
            complaint.setEmail(resultSet.getString("email"));
//#endif


//#if -1300973961
            String funcionario = resultSet.getString("funcionario");
//#endif


//#if -1558009030
            Employee employee = null;
//#endif


//#if -1925724917
            if(funcionario != null && !funcionario.equalsIgnoreCase("null")) { //1

//#if -1099530149
                employee = employeeRep.search(funcionario);
//#endif

            }

//#endif


//#if -1390918082
            complaint.setAtendente(employee);
//#endif


//#if 936015176
            complaint.setSituacao((new Integer(resultSet.getString("situacao"))).intValue());
//#endif


//#if -1148325891
            try { //1

//#if 1998647567
                java.util.Date d = null;
//#endif


//#if -1750451478
                String date = resultSet.getString("dataParecer");
//#endif


//#if -1641081637
                if(!date.equals("NULL")) { //1

//#if 336210603
                    StringTokenizer token = new StringTokenizer(date, "/");
//#endif


//#if -1392906508
                    int day = (new Integer(token.nextToken())).intValue();
//#endif


//#if -1134764776
                    int month = (new Integer(token.nextToken())).intValue();
//#endif


//#if -1581447489
                    int year = (new Integer(token.nextToken())).intValue();
//#endif


//#if 135137360
                    d = new java.util.Date(year, month, day);
//#endif

                }

//#endif


//#if 1207858818
                if(d != null) { //1

//#if 1568388737
                    try { //1

//#if -1862895267
                        complaint.setDataParecer(new Date(d.getDate(), d.getMonth() + 1, d
                                                          .getYear() + 1900));
//#endif

                    }

//#if 426183776
                    catch (InvalidDateException ex) { //1
                    }
//#endif


//#endif

                } else {

//#if 659308839
                    complaint.setDataParecer(null);
//#endif

                }

//#endif


//#if -2080745582
                date = resultSet.getString("dataQueixa");
//#endif


//#if 149758966
                if(!date.equals("NULL")) { //2

//#if 1822581115
                    StringTokenizer token = new StringTokenizer(date, "/");
//#endif


//#if 93464004
                    int day = (new Integer(token.nextToken())).intValue();
//#endif


//#if 1338154984
                    int month = (new Integer(token.nextToken())).intValue();
//#endif


//#if 1546365423
                    int year = (new Integer(token.nextToken())).intValue();
//#endif


//#if 1953721120
                    d = new java.util.Date(year, month, day);
//#endif

                } else {

//#if 1628876348
                    d = null;
//#endif

                }

//#endif


//#if 86117615
                if(d != null) { //2

//#if -2039743382
                    try { //1

//#if 1199719293
                        complaint.setDataQueixa(new Date(d.getDate(), d.getMonth() + 1,
                                                         d.getYear() + 1900));
//#endif

                    }

//#if -2075706566
                    catch (InvalidDateException ex) { //1
                    }
//#endif


//#endif

                } else {

//#if -353457636
                    complaint.setDataQueixa(null);
//#endif

                }

//#endif

            }

//#if 1387111574
            catch (Exception e) { //1

//#if -2128699470
                e.printStackTrace();
//#endif

            }

//#endif


//#endif


//#if 25895946
            int codEndereco = resultSet.getInt("enderecosolicitante");
//#endif


//#if -117400547
            Address endSol = addressRep.search(codEndereco);
//#endif


//#if 1198420221
            complaint.setEnderecoSolicitante(endSol);
//#endif

        }

//#if 1799023144
        catch (RepositoryException e) { //1

//#if 1949138899
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if 1710708908
        catch (ObjectNotFoundException e) { //1

//#if 807802230
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if -574062036
        catch (SQLException e) { //1

//#if -1325333483
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1059393181
    public int insert(Complaint complaint) throws ObjectAlreadyInsertedException,
        RepositoryException, ObjectNotValidException
    {

//#if -1532584959
        String consulta = null;
//#endif


//#if -1163219046
        try { //1

//#if -155542930
            if(complaint != null) { //1

//#if 248284898
                consulta = "select * FROM SCBS_queixa";
//#endif


//#if -815250146
                Statement stmt = (Statement) mp.getCommunicationChannel();
//#endif


//#if -105205786
                resultSet = stmt.executeQuery(consulta);
//#endif


//#if 1442849072
                int count = 0;
//#endif


//#if 1674458420
                while (resultSet.next()) { //1

//#if 343004064
                    count++;
//#endif

                }

//#endif


//#if 875969599
                complaint.setCodigo(count + 1);
//#endif


//#if 463897437
                deepInsertCommon(complaint);
//#endif


//#if -1965555586
                if(complaint instanceof SpecialComplaint) { //1

//#if -927193360
                    SpecialComplaint special = (SpecialComplaint) complaint;
//#endif


//#if 1339578236
                    deepInsertSpecial(special);
//#endif

                } else

//#if 1619772599
                    if(complaint instanceof FoodComplaint) { //1

//#if 497035154
                        FoodComplaint food = (FoodComplaint) complaint;
//#endif


//#if -1737293499
                        deepInsertFood(food);
//#endif

                    } else

//#if -2065036773
                        if(complaint instanceof AnimalComplaint) { //1

//#if 1878994728
                            AnimalComplaint animal = (AnimalComplaint) complaint;
//#endif


//#if 1224883453
                            deepInsertAnimal(animal);
//#endif

                        }

//#endif


//#endif


//#endif

            } else {

//#if -975253979
                throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif

            }

//#endif

        }

//#if -1141584921
        catch (PersistenceMechanismException e) { //1

//#if 1082459442
            e.printStackTrace();
//#endif


//#if 516993593
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_INCLUSAO);
//#endif

        }

//#endif


//#if -451635011
        catch (SQLException e) { //1

//#if -1575949178
            System.out.println(consulta);
//#endif


//#if 1826550162
            e.printStackTrace();
//#endif


//#if -1447847628
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_INCLUSAO,consulta);
//#endif

        }

//#endif


//#endif


//#if 1299177707
        updateTimestamp(complaint.getTimestamp() + "", "SCBS_queixa", complaint.getCodigo() + "");
//#endif


//#if 692110050
        return complaint.getCodigo();
//#endif

    }

//#endif


//#if -244516725
    private void deepInsertSpecial(SpecialComplaint complaint)
    throws RepositoryException,
        ObjectAlreadyInsertedException
    {

//#if -1415924255
        if(complaint.getEnderecoOcorrencia() != null) { //1

//#if 558913438
            try { //1

//#if -1906111110
                addressRep.insert(complaint.getEnderecoOcorrencia());
//#endif

            }

//#if 621562121
            catch (ObjectNotValidException e) { //1
            }
//#endif


//#endif

        }

//#endif


//#if -261917048
        insertSpecial(complaint);
//#endif

    }

//#endif


//#if -1506916640
    public Complaint search(int code) throws RepositoryException, ObjectNotFoundException
    {

//#if -1251786807
        String sql = "SELECT tipoqueixa FROM SCBS_queixa WHERE codigo = '" + code + "'";
//#endif


//#if 460592261
        int tipoQueixa;
//#endif


//#if 1021352123
        Complaint q = null;
//#endif


//#if 1801577140
        try { //1

//#if 2015182988
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -1107878472
            ResultSet rs = stmt.executeQuery(sql);
//#endif


//#if 107876384
            if(rs.next()) { //1

//#if -1227188034
                tipoQueixa = (new Integer(rs.getString("tipoqueixa"))).intValue();
//#endif

            } else {

//#if 273799304
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA + " code: "
                                                  + code);
//#endif

            }

//#endif


//#if 1652250061
            rs.close();
//#endif


//#if 1614415014
            stmt.close();
//#endif

        }

//#if 1935835429
        catch (PersistenceMechanismException e) { //1

//#if 321433214
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

        }

//#endif


//#if 688293823
        catch (SQLException e) { //1

//#if 2062570733
            System.out.println(sql);
//#endif


//#if -1046726393
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif


//#if -732382679
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif

        }

//#endif


//#endif


//#if -961360145
        switch (tipoQueixa) { //1
        case Complaint.QUEIXA_ALIMENTAR://1


//#if 338945984
            q = accessFood(code);
//#endif


//#if 1143506805
            break;

//#endif


        case Complaint.QUEIXA_ANIMAL://1


//#if 849464017
            q = accessAnimal(code);
//#endif


//#if -1580653786
            break;

//#endif


        case Complaint.QUEIXA_DIVERSA://1


//#if 293244766
            q = accessSpecial(code);
//#endif


//#if 818763996
            break;

//#endif


        default://1


//#if -224617666
            throw new IllegalArgumentException();
//#endif


        }

//#endif


//#if -1783834596
        long timestamp = searchTimestamp("SCBS_queixa", q.getCodigo() + "");
//#endif


//#if 425131087
        q.setTimestamp(timestamp);
//#endif


//#if -1770896488
        return q;
//#endif

    }

//#endif


//#if -858527098
    private FoodComplaint accessFood(int code) throws RepositoryException, ObjectNotFoundException
    {

//#if 1052900695
        FoodComplaint complaint;
//#endif


//#if -40648562
        String sql = null;
//#endif


//#if 977627292
        try { //1

//#if -65637553
            complaint = new FoodComplaint();
//#endif


//#if -1615898126
            sql = "select * from SCBS_queixa q,SCBS_queixaalimentar qa where q.codigo=qa.codigo and q."
                  + "codigo = '" + code + "';";
//#endif


//#if -825545566
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -682376467
            resultSet = stmt.executeQuery(sql);
//#endif


//#if -390864668
            if(resultSet.next()) { //1

//#if -1553848242
                try { //1

//#if 1310138431
                    accessComplaint(resultSet, complaint);
//#endif

                }

//#if -722384452
                catch (ObjectNotFoundException e) { //1

//#if 2086561724
                    e.printStackTrace();
//#endif

                }

//#endif


//#endif


//#if 1456207005
                complaint.setQtdeComensais(resultSet.getShort("qtdeComensais"));
//#endif


//#if -1460555019
                complaint.setQtdeDoentes(resultSet.getShort("qtdeDoentes"));
//#endif


//#if -538087701
                complaint.setQtdeInternacoes(resultSet.getShort("qtdeInternacoes"));
//#endif


//#if 808209763
                complaint.setQtdeObitos(resultSet.getShort("qtdeObitos"));
//#endif


//#if 417446106
                complaint.setLocalAtendimento(resultSet.getString("localAtendimento"));
//#endif


//#if -171804892
                complaint.setRefeicaoSuspeita(resultSet.getString("refeicaoSuspeita"));
//#endif


//#if 241828084
                String endDoente = resultSet.getString("enderecodoente");
//#endif


//#if -200064589
                Address endDo = addressRep.search((new Integer(endDoente)).intValue());
//#endif


//#if -719509179
                complaint.setEnderecoDoente(endDo);
//#endif

            } else {

//#if 1721273459
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if -293306825
            resultSet.close();
//#endif


//#if -280426692
            stmt.close();
//#endif

        }

//#if 1588212046
        catch (PersistenceMechanismException e) { //1

//#if -1467845887
            e.printStackTrace();
//#endif


//#if -1477234576
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if -1150217354
        catch (java.sql.SQLException e) { //1

//#if 1735751375
            e.printStackTrace();
//#endif


//#if 1095355966
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 873418462
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif


//#if 1689552006
        return complaint;
//#endif

    }

//#endif


//#if 1717546170
    private SpecialComplaint accessSpecial(int code) throws RepositoryException,
        ObjectNotFoundException
    {

//#if -1587393331
        SpecialComplaint complaint;
//#endif


//#if 152981065
        String sql = null;
//#endif


//#if -685740927
        try { //1

//#if -1354968708
            complaint = new SpecialComplaint();
//#endif


//#if 1698785610
            sql = "select * from SCBS_queixa q, SCBS_queixadiversa qd where q.codigo=qd.codigo and q."
                  + "codigo = '" + code + "'";
//#endif


//#if -542121140
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -1754105321
            resultSet = stmt.executeQuery(sql);
//#endif


//#if 1972085902
            if(resultSet.next()) { //1

//#if 281785800
                accessComplaint(resultSet, complaint);
//#endif


//#if -1302204440
                complaint.setTimestamp((new Long(resultSet.getString("ts"))).longValue());
//#endif


//#if 192141028
                complaint.setIdade(resultSet.getShort("idade"));
//#endif


//#if 1587515227
                complaint.setInstrucao(resultSet.getString("instrucao"));
//#endif


//#if 1588440697
                complaint.setOcupacao(resultSet.getString("ocupacao"));
//#endif


//#if -1538234061
                Address endO = addressRep.search((new Integer(resultSet
                                                  .getString("enderecoocorrencia")).intValue()));
//#endif


//#if -2021205572
                complaint.setEnderecoOcorrencia(endO);
//#endif

            } else {

//#if 550417174
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if -1994942387
            resultSet.close();
//#endif


//#if 770144102
            stmt.close();
//#endif

        }

//#if -1809938538
        catch (PersistenceMechanismException e) { //1

//#if 591351445
            e.printStackTrace();
//#endif


//#if 135391236
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if -1532351186
        catch (SQLException e) { //1

//#if -922690707
            System.out.println(sql);
//#endif


//#if 144052606
            e.printStackTrace();
//#endif


//#if -1111110163
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -1930771697
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif


//#if -897864149
        return complaint;
//#endif

    }

//#endif


//#if -1793671105
    public void update(Complaint complaint) throws RepositoryException, ObjectNotFoundException,
        ObjectNotValidException
    {

//#if 20976393
        synchronized (this) { //1

//#if -1798353943
            long timestamp;
//#endif


//#if -1716726466
            try { //1

//#if 627726259
                if(complaint != null) { //1

//#if 203864763
                    String sql = null;
//#endif


//#if -926885937
                    try { //1

//#if -761850352
                        Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 1243686155
                        sql = "select ts from SCBS_queixa " + " where codigo='"
                              + complaint.getCodigo() + "'";
//#endif


//#if 468672786
                        ResultSet resultSet = stmt.executeQuery(sql);
//#endif


//#if -918099630
                        if(resultSet.next()) { //1

//#if 1894075078
                            timestamp = (new Long(resultSet.getString("ts"))).longValue();
//#endif


//#if 1022022895
                            if(timestamp != complaint.getTimestamp()) { //1

//#if 1317375580
                                throw new RepositoryException(
                                    ExceptionMessages.EXC_FALHA_ATUALIZACAO_COPIA);
//#endif

                            } else {

//#if -1299911902
                                complaint.incTimestamp();
//#endif

                            }

//#endif

                        } else {

//#if -1923459663
                            throw new ObjectNotFoundException(
                                ExceptionMessages.EXC_FALHA_ATUALIZACAO);
//#endif

                        }

//#endif


//#if -11704055
                        resultSet.close();
//#endif


//#if 768155946
                        stmt.close();
//#endif


//#if 958142589
                        stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 452586906
                        sql = "update SCBS_queixa set " + "observacao='"
                              + complaint.getObservacao() + "', " + "situacao= '"
                              + complaint.getSituacao() + "', " + "funcionario= '"
                              + complaint.getAtendente().getLogin() + "', " + "ts= '"
                              + complaint.getTimestamp() + "'";
//#endif


//#if 1712084762
                        sql = "update SCBS_queixa set " + "observacao='"
                              + complaint.getObservacao() + "', " + "situacao= '"
                              + complaint.getSituacao() + "', ts= '"
                              + complaint.getTimestamp() + "'";
//#endif


//#if -166252376
                        if(complaint.getAtendente() != null) { //1

//#if -1586471155
                            sql += ", funcionario= '" + complaint.getAtendente().getLogin() + "'";
//#endif

                        }

//#endif


//#if 2129507432
                        if(complaint.getDataParecer() != null) { //1

//#if -159537875
                            sql += ", dataparecer= '" + complaint.getDataParecer() + "'";
//#endif

                        }

//#endif


//#if -1711464785
                        sql += " where codigo = '" + complaint.getCodigo() + "'";
//#endif


//#if 736211899
                        int response = stmt.executeUpdate(sql);
//#endif


//#if -719561078
                        if(response == 0) { //1

//#if 792339053
                            throw new ObjectNotFoundException(
                                ExceptionMessages.EXC_FALHA_ATUALIZACAO);
//#endif

                        }

//#endif


//#if 548080872
                        stmt.close();
//#endif

                    }

//#if 1338804647
                    catch (SQLException e) { //1

//#if -1948935677
                        System.out.println(sql);
//#endif


//#if -1175881341
                        throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

                    }

//#endif


//#endif

                } else {

//#if 503555843
                    throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif

                }

//#endif

            }

//#if -1918295786
            catch (PersistenceMechanismException e) { //1

//#if 837344775
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
//#endif

            }

//#endif


//#endif


//#if 802568079
            updateTimestamp(complaint.getTimestamp() + "", "SCBS_queixa", complaint.getCodigo()
                            + "");
//#endif

        }

//#endif

    }

//#endif


//#if -309997322
    public IteratorDsk getComplaintList() throws ObjectNotFoundException, RepositoryException
    {

//#if 1491122377
        List cList = new ArrayList();
//#endif


//#if 797708402
        String sql = "SELECT * FROM SCBS_queixa";
//#endif


//#if 403337405
        ResultSet rs = null;
//#endif


//#if -1386601961
        Complaint complaint = null;
//#endif


//#if -2026616106
        try { //1

//#if -1685424772
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -1903904345
            rs = stmt.executeQuery(sql);
//#endif


//#if 533584449
            if(!rs.next()) { //1

//#if -117125423
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if -2121284537
            do {

//#if -840690752
                int tipoQueixa = (new Integer(rs.getString("tipoqueixa"))).intValue();
//#endif


//#if -849906804
                int code = (new Integer(rs.getString("codigo"))).intValue();
//#endif


//#if -1326655985
                switch (tipoQueixa) { //1
                case SPECIAL_COMPLAINT://1


//#if -1034205393
                    complaint = accessSpecial(code);
//#endif


//#if 1348466087
                    break;

//#endif


                case FOOD_COMPLAINT://1


//#if 399438077
                    complaint = accessFood(code);
//#endif


//#if -5178094
                    break;

//#endif


                case ANIMAL_COMPLAINT://1


//#if -50054375
                    complaint = accessAnimal(code);
//#endif


//#if 1436291032
                    break;

//#endif


                default://1


//#if -468728233
                    throw new IllegalArgumentException();
//#endif


                }

//#endif


//#if 1998274558
                cList.add(complaint);
//#endif

            } while (rs.next()); //1

//#endif


//#if -648009027
            rs.close();
//#endif


//#if -1321378410
            stmt.close();
//#endif

        }

//#if -1944168464
        catch (PersistenceMechanismException e) { //1

//#if 1431491881
            e.printStackTrace();
//#endif


//#if 948136176
            throw new RepositoryException("PersistenceMechanismException: " + e.getMessage());
//#endif

        }

//#endif


//#if 1937995156
        catch (SQLException e) { //1

//#if -1857454746
            e.printStackTrace();
//#endif


//#if -550897225
            throw new RepositoryException("SQLException: " + e.getMessage());
//#endif


//#if 1550103305
            throw new SQLPersistenceMechanismException("SQLException: " + e.getMessage(),sql);
//#endif

        }

//#endif


//#if -1051536960
        catch (RepositoryException e) { //1

//#if -931392679
            e.printStackTrace();
//#endif


//#if 829186218
            throw new RepositoryException("SQLException: " + e.getMessage());
//#endif

        }

//#endif


//#endif


//#if 409350382
        return new ConcreteIterator(cList);
//#endif

    }

//#endif


//#if 1708911433
    private void insertFood(FoodComplaint complaint) throws RepositoryException
    {

//#if 758670902
        String sql = null;
//#endif


//#if 482887156
        try { //1

//#if 1188688620
            sql = "insert into SCBS_queixaalimentar (codigo,qtdecomensais,qtdedoentes,qtdeinternacoes,qtdeobitos,localatendimento,refeicaosuspeita,enderecodoente) values (";
//#endif


//#if -531751310
            sql += "'" + complaint.getCodigo() + "','";
//#endif


//#if 1768992075
            sql += complaint.getQtdeComensais() + "','";
//#endif


//#if 1429266687
            sql += complaint.getQtdeDoentes() + "','";
//#endif


//#if -716619467
            sql += complaint.getQtdeInternacoes() + "',";
//#endif


//#if 28199937
            sql += complaint.getQtdeObitos() + ",";
//#endif


//#if 2102810419
            sql += "'" + complaint.getLocalAtendimento() + "',";
//#endif


//#if -1922554559
            sql += "'" + complaint.getRefeicaoSuspeita() + "','";
//#endif


//#if 662136405
            if(complaint.getEnderecoDoente() != null) { //1

//#if -816684981
                sql += complaint.getEnderecoDoente().getCode() + "')";
//#endif

            } else {

//#if 1474282698
                sql += "NULL')";
//#endif

            }

//#endif


//#if 1793113275
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -820546589
            stmt.executeUpdate(sql);
//#endif


//#if -1979094251
            stmt.close();
//#endif

        }

//#if -1849678610
        catch (PersistenceMechanismException e) { //1

//#if 1535040193
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if 1927795926
        catch (SQLException e) { //1

//#if 41444147
            System.out.println(sql);
//#endif


//#if 2081647283
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -2132964599
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1555249899
    private void insertSpecial(SpecialComplaint complaint) throws RepositoryException
    {

//#if 1294965788
        String sql = null;
//#endif


//#if -963660466
        try { //1

//#if 627493037
            sql = "insert into SCBS_queixadiversa (codigo,idade,ocupacao,instrucao,enderecoocorrencia) values (";
//#endif


//#if 1655138790
            sql += "'" + complaint.getCodigo() + "','";
//#endif


//#if 77784619
            sql += complaint.getIdade() + "',";
//#endif


//#if -616576359
            sql += "'" + complaint.getOcupacao() + "',";
//#endif


//#if 1780109375
            sql += "'" + complaint.getInstrucao() + "','";
//#endif


//#if 1267297331
            if(complaint.getEnderecoOcorrencia() != null) { //1

//#if -2052724273
                sql += complaint.getEnderecoOcorrencia().getCode() + "')";
//#endif

            } else {

//#if 1852247721
                sql += "NULL')";
//#endif

            }

//#endif


//#if -623298257
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 1271176175
            stmt.executeUpdate(sql);
//#endif


//#if -1199254903
            stmt.close();
//#endif

        }

//#if -961987470
        catch (PersistenceMechanismException e) { //1

//#if 1985774173
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if -706530094
        catch (SQLException e) { //1

//#if -605113524
            System.out.println(sql);
//#endif


//#if -1341824436
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -915892080
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -801204883
    private void deepInsertFood(FoodComplaint complaint) throws RepositoryException, ObjectAlreadyInsertedException
    {

//#if -1674580891
        if(complaint.getEnderecoDoente() != null) { //1

//#if 1044522315
            try { //1

//#if 1214028887
                addressRep.insert(complaint.getEnderecoDoente());
//#endif

            }

//#if -1700430604
            catch (ObjectNotValidException e) { //1
            }
//#endif


//#endif

        }

//#endif


//#if -119722609
        insertFood(complaint);
//#endif

    }

//#endif


//#if -2076132356
    public boolean exists(int code)
    {

//#if -134669039
        boolean response = false;
//#endif


//#if -1830900990
        String consulta = null;
//#endif


//#if -1317886885
        try { //1

//#if -515236238
            consulta = "select codigo from SCBS_queixa where codigo='" + code + "'";
//#endif


//#if 969380915
            Statement stmt = (Statement) mp.getCommunicationChannel();
//#endif


//#if -209925893
            resultSet = stmt.executeQuery(consulta);
//#endif


//#if 930759663
            response = resultSet.next();
//#endif


//#if -857160936
            resultSet.close();
//#endif


//#if -2007795269
            stmt.close();
//#endif

        }

//#if 1969813049
        catch (PersistenceMechanismException e) { //1

//#if 813104002
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#if -1798735829
        catch (SQLException e) { //1

//#if -819556915
            System.out.println(consulta);
//#endif


//#if 817770625
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#endif


//#if -1343141659
        return response;
//#endif

    }

//#endif


//#if -723725838
    private AnimalComplaint accessAnimal(int codigo) throws RepositoryException,
        ObjectNotFoundException
    {

//#if 720788990
        AnimalComplaint complaint;
//#endif


//#if -1793463213
        String sql = null;
//#endif


//#if 358284087
        try { //1

//#if 1153966368
            complaint = new AnimalComplaint();
//#endif


//#if 718828471
            sql = "select * from SCBS_queixa q,SCBS_queixaanimal qa where q.codigo=qa.codigo and q."
                  + "codigo = '" + codigo + "'";
//#endif


//#if 5592021
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -814021664
            resultSet = stmt.executeQuery(sql);
//#endif


//#if -1925765737
            if(resultSet.next()) { //1

//#if -1405703511
                accessComplaint(resultSet, complaint);
//#endif


//#if -1263876520
                complaint.setAnimalQuantity(resultSet.getShort("qtdeAnimais"));
//#endif


//#if -2041047066
                String date = resultSet.getString("dataIncomodo");
//#endif


//#if -1899955167
                java.util.Date d = null;
//#endif


//#if 445319789
                if(!date.equals("NULL")) { //1

//#if -1162297225
                    StringTokenizer token = new StringTokenizer(date, "/");
//#endif


//#if 1403552960
                    int day = (new Integer(token.nextToken())).intValue();
//#endif


//#if 1908223972
                    int month = (new Integer(token.nextToken())).intValue();
//#endif


//#if -790549901
                    int year = (new Integer(token.nextToken())).intValue();
//#endif


//#if 774206236
                    d = new java.util.Date(year, month, day);
//#endif

                }

//#endif


//#if 1783159728
                if(d != null) { //1

//#if 292085050
                    try { //1

//#if -2017212742
                        complaint.setInconvenienceDate(new Date(d.getDate(), d.getMonth() + 1, d
                                                                .getYear() + 1900));
//#endif

                    }

//#if 288493179
                    catch (InvalidDateException ex) { //1
                    }
//#endif


//#endif

                } else {

//#if 13166768
                    complaint.setInconvenienceDate(null);
//#endif

                }

//#endif


//#if -854859692
                complaint.setAnimal(resultSet.getString("animal"));
//#endif


//#if -1919032368
                String endAnimal = resultSet.getString("enderecolocalocorrencia");
//#endif


//#if -1692716816
                Address endLO = addressRep.search((new Integer(endAnimal)).intValue());
//#endif


//#if 412902965
                complaint.setOccurenceLocalAddress(endLO);
//#endif

            } else {

//#if 998948002
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if 1048565156
            resultSet.close();
//#endif


//#if -152698961
            stmt.close();
//#endif

        }

//#if -1045473124
        catch (PersistenceMechanismException e) { //1

//#if -2113702194
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if -1829775512
        catch (SQLException e) { //1

//#if 986795418
            e.printStackTrace();
//#endif


//#if -996557303
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -362181005
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, sql);
//#endif

        }

//#endif


//#endif


//#if -1108094623
        return complaint;
//#endif

    }

//#endif


//#if -2059726675
    private void deepInsertAnimal(AnimalComplaint complaint) throws
        RepositoryException, ObjectAlreadyInsertedException
    {

//#if 2021313945
        if(complaint.getOccurenceLocalAddress() != null) { //1

//#if -1701230369
            try { //1

//#if 630935905
                addressRep.insert(complaint.getOccurenceLocalAddress());
//#endif

            }

//#if 735929262
            catch (ObjectNotValidException e) { //1
            }
//#endif


//#endif

        }

//#endif


//#if -1120412843
        insertAnimal(complaint);
//#endif

    }

//#endif


//#if -287138844
    private void deepInsertAnimal(AnimalComplaint complaint) throws PersistenceMechanismException,
        RepositoryException, ObjectAlreadyInsertedException
    {

//#if 2055123813
        if(complaint.getOccurenceLocalAddress() != null) { //1

//#if -583843921
            try { //1

//#if 786685189
                addressRep.insert(complaint.getOccurenceLocalAddress());
//#endif

            }

//#if -509004073
            catch (ObjectNotValidException e) { //1
            }
//#endif


//#endif

        }

//#endif


//#if 1575479305
        insertAnimal(complaint);
//#endif

    }

//#endif


//#if 142430372
    private void deepInsertFood(FoodComplaint complaint) throws PersistenceMechanismException,
        RepositoryException, ObjectAlreadyInsertedException
    {

//#if 2009876817
        if(complaint.getEnderecoDoente() != null) { //1

//#if -132963842
            try { //1

//#if -1338105445
                addressRep.insert(complaint.getEnderecoDoente());
//#endif

            }

//#if -1076329578
            catch (ObjectNotValidException e) { //1
            }
//#endif


//#endif

        }

//#endif


//#if -1654638469
        insertFood(complaint);
//#endif

    }

//#endif


//#if -198708727
    private void insertAnimal(AnimalComplaint complaint) throws RepositoryException
    {

//#if 1629200445
        String sql = null;
//#endif


//#if -1230678003
        try { //1

//#if 1198197439
            sql = "insert into SCBS_queixaanimal (codigo,qtdeanimais,dataincomodo,animal,enderecolocalocorrencia) values (";
//#endif


//#if -721288159
            sql += "'" + complaint.getCodigo() + "','";
//#endif


//#if -1855907852
            sql += complaint.getAnimalQuantity() + "',";
//#endif


//#if 2065631693
            sql += "'" + complaint.getInconvenienceDate() + "',";
//#endif


//#if -1400203234
            sql += "'" + complaint.getAnimal() + "','";
//#endif


//#if 2021386240
            if(complaint.getOccurenceLocalAddress() != null) { //1

//#if -491852288
                sql += complaint.getOccurenceLocalAddress().getCode() + "')";
//#endif

            } else {

//#if -647210623
                sql += "NULL')";
//#endif

            }

//#endif


//#if -1655528150
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 607452628
            stmt.executeUpdate(sql);
//#endif


//#if -1663128124
            stmt.close();
//#endif

        }

//#if -1393486804
        catch (PersistenceMechanismException e) { //1

//#if 1678160751
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if 949176792
        catch (SQLException e) { //1

//#if -689124414
            System.out.println(sql);
//#endif


//#if 1328740290
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 1303764442
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1311935901
    private void updateTimestamp(String value, String tableName, String id)
    {

//#if -1591455130
        Statement stmt = null;
//#endif


//#if -2024919772
        int result = 0;
//#endif


//#if -612549858
        try { //1

//#if 2068160986
            String sql = "update " + tableName + " set ts='" + value + "' where codigo='" + id
                         + "'";
//#endif


//#if 48722359
            stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -1739945224
            result = stmt.executeUpdate(sql);
//#endif


//#if 1946319784
            if(result == 0) { //1

//#if 1743505974
                throw new RuntimeException("ERRO no aspecto TimestampAspectHealthWatcher ##2");
//#endif

            }

//#endif

        }

//#if -1312797966
        catch (Exception ex) { //1

//#if 1227925664
            ex.printStackTrace();
//#endif


//#if 1082719505
            throw new RuntimeException(ex);
//#endif

        }

//#endif

        finally {

//#if -311677490
            try { //1

//#if -1074908504
                if(stmt != null) { //1

//#if 1719867605
                    stmt.close();
//#endif

                }

//#endif

            }

//#if -101186206
            catch (Exception ex) { //1

//#if 1369845112
                throw new RuntimeException(ex);
//#endif

            }

//#endif


//#endif

        }

//#endif

    }

//#endif


//#if -795973977
    public void remove(int codigo) throws RepositoryException, ObjectNotFoundException
    {
    }
//#endif


//#if -1679534270
    private long searchTimestamp(String tableName, String id)
    {

//#if -2040883498
        Statement stmt = null;
//#endif


//#if -2127419601
        ResultSet resultSet = null;
//#endif


//#if 328375958
        long answer = 0;
//#endif


//#if 1061191854
        try { //1

//#if 391177822
            String sql = "SELECT ts FROM " + tableName + " WHERE codigo='" + id + "'";
//#endif


//#if -1219367488
            PersistenceMechanism pm = PersistenceMechanism.getInstance();
//#endif


//#if -1667972872
            stmt = (Statement) pm.getCommunicationChannel();
//#endif


//#if 1741365462
            resultSet = stmt.executeQuery(sql);
//#endif


//#if 493018637
            if(resultSet.next()) { //1

//#if 1565917335
                answer = resultSet.getLong(1);
//#endif

            } else {

//#if -1777082970
                throw new RuntimeException("ERRO no aspecto TimestampAspectHealthWatcher ##2");
//#endif

            }

//#endif


//#if -101027094
            return answer;
//#endif

        }

//#if -948510859
        catch (Exception ex) { //1

//#if -1236456231
            ex.printStackTrace();
//#endif


//#if 505296970
            throw new RuntimeException(ex);
//#endif

        }

//#endif

        finally {

//#if 768890745
            try { //1

//#if 1176158420
                if(resultSet != null) { //1

//#if -13384796
                    resultSet.close();
//#endif

                }

//#endif


//#if -1312812337
                if(stmt != null) { //1

//#if -463666577
                    stmt.close();
//#endif

                }

//#endif

            }

//#if -1364055365
            catch (Exception ex) { //1

//#if -861401930
                throw new RuntimeException(ex);
//#endif

            }

//#endif


//#endif

        }

//#endif

    }

//#endif


//#if -1687804150
    private void deepInsertCommon(Complaint complaint) throws ObjectAlreadyInsertedException,
        RepositoryException
    {

//#if 2022464222
        String sql = null;
//#endif


//#if 1968632908
        try { //1

//#if 1254974115
            if(complaint.getEnderecoSolicitante() != null) { //1

//#if -580102904
                try { //1

//#if -341772852
                    addressRep.insert(complaint.getEnderecoSolicitante());
//#endif

                }

//#if -1599310691
                catch (ObjectNotValidException e) { //1
                }
//#endif


//#endif

            }

//#endif


//#if -1182893189
            int complaintType = -1;
//#endif


//#if -1189593679
            if(complaint instanceof SpecialComplaint) { //1

//#if 1037722647
                complaintType = SPECIAL_COMPLAINT;
//#endif

            } else

//#if 609672562
                if(complaint instanceof FoodComplaint) { //1

//#if -1362838393
                    complaintType = FOOD_COMPLAINT;
//#endif

                } else

//#if 1052563404
                    if(complaint instanceof AnimalComplaint) { //1

//#if -383144648
                        complaintType = ANIMAL_COMPLAINT;
//#endif

                    }

//#endif


//#endif


//#endif


//#if -1325216413
            sql = "INSERT INTO SCBS_queixa (codigo,tipoqueixa,solicitante,descricao,observacao,email,funcionario,situacao,dataparecer,dataqueixa,enderecosolicitante,ts) VALUES(";
//#endif


//#if 692676370
            sql += "'" + complaint.getCodigo() + "'" + ",";
//#endif


//#if -1169957734
            sql += "'" + complaintType + "'" + ",";
//#endif


//#if 1541533913
            sql += "'" + complaint.getSolicitante() + "',";
//#endif


//#if -1085898001
            sql += "'" + complaint.getDescricao() + "',";
//#endif


//#if -1796131009
            sql += "'" + complaint.getObservacao() + "',";
//#endif


//#if 169078082
            sql += "'" + complaint.getEmail() + "',";
//#endif


//#if -941734693
            if(complaint.getAtendente() != null) { //1

//#if 499741361
                sql += "'" + complaint.getAtendente().getLogin() + "','";
//#endif

            } else {

//#if 24220053
                sql += "'NULL',";
//#endif

            }

//#endif


//#if -902873788
            sql += "'" + complaint.getSituacao() + "'" + ",";
//#endif


//#if -79656997
            if(complaint.getDataParecer() != null) { //1

//#if -1974286986
                sql += "'" + Date.format(complaint.getDataParecer(), Date.FORMATO1) + "'";
//#endif

            } else {

//#if 391321816
                sql += "'NULL',";
//#endif

            }

//#endif


//#if 264479738
            if(complaint.getDataQueixa() != null) { //1

//#if -581527837
                sql += "'" + Date.format(complaint.getDataQueixa(), Date.FORMATO1) + "',";
//#endif

            } else {

//#if 1670922966
                sql += "'',";
//#endif

            }

//#endif


//#if -756375250
            if(complaint.getEnderecoSolicitante() != null) { //2

//#if 165613927
                sql += "'" + complaint.getEnderecoSolicitante().getCode() + "'";
//#endif

            } else {

//#if -220970301
                sql += "NULL";
//#endif

            }

//#endif


//#if 1477595942
            sql += ",'" + complaint.getTimestamp() + "');";
//#endif


//#if -1392987645
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 814326683
            stmt.executeUpdate(sql);
//#endif


//#if -1961370019
            stmt.close();
//#endif

        }

//#if -170827653
        catch (PersistenceMechanismException e) { //1

//#if 511702766
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if 1492154793
        catch (SQLException e) { //1

//#if 793620641
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1757015068
    public boolean exists(int code) throws RepositoryException
    {

//#if -74102348
        boolean response = false;
//#endif


//#if -2907035
        String consulta = null;
//#endif


//#if -1899333890
        try { //1

//#if -1265741715
            consulta = "select codigo from SCBS_queixa where codigo='" + code + "'";
//#endif


//#if -1888758120
            Statement stmt = (Statement) mp.getCommunicationChannel();
//#endif


//#if 586446176
            resultSet = stmt.executeQuery(consulta);
//#endif


//#if 216899540
            response = resultSet.next();
//#endif


//#if -969616387
            resultSet.close();
//#endif


//#if -302010954
            stmt.close();
//#endif

        }

//#if -2023234283
        catch (PersistenceMechanismException e) { //1

//#if -765150310
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if 1340802511
        catch (SQLException e) { //1

//#if -1470635850
            throw new SQLPersistenceMechanismException(e.getMessage(),consulta);
//#endif

        }

//#endif


//#endif


//#if -1375158878
        return response;
//#endif

    }

//#endif

}

//#endif


//#endif

