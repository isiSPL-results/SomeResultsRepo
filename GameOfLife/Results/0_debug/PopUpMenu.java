
//#if 1622536299
// Compilation Unit of /PopUpMenu.java


//#if -1698190557
import java.awt.event.ActionEvent;
//#endif


//#if -1624389499
import java.awt.event.ActionListener;
//#endif


//#if -704287970
import javax.swing.JMenu;
//#endif


//#if 838482123
import javax.swing.JMenuItem;
//#endif


//#if -989898162
import javax.swing.JPopupMenu;
//#endif


//#if -1307398981
public class PopUpMenu extends
//#if 1238639991
    JPopupMenu
//#endif

{

//#if -1050552911
    private ModelObservable model;
//#endif


//#if -1207133468
    int xCoordinate;
//#endif


//#if -1078050749
    int yCoordinate;
//#endif


//#if -509290609
    public PopUpMenu(  ModelObservable model,  int x,  int y)
    {

//#if -1054411956
        this.xCoordinate=x;
//#endif


//#if -1559970550
        this.yCoordinate=y;
//#endif


//#if -1093047806
        this.model=model;
//#endif


//#if -602941625
        this.add(new StaticObjectsMenu("statische Objekte"));
//#endif


//#if -1417111206
        this.add(new PulsatingObjectsMenu("pulsierende Objekte"));
//#endif


//#if 1773139917
        this.add(new MovingObjectsMenu("Raumschiffe/ Gleiter"));
//#endif

    }

//#endif


//#if -1256714205
    class StaticObjectsMenu extends
//#if 1752406653
        JMenu
//#endif

    {

//#if 1479613141
        public StaticObjectsMenu(    String name)
        {

//#if 1885333911
            super(name);
//#endif


//#if 805929632
            this.add(new static1());
//#endif


//#if 806853153
            this.add(new static2());
//#endif


//#if 807776674
            this.add(new static3());
//#endif


//#if 808700195
            this.add(new static4());
//#endif

        }

//#endif


//#if -1987909929
        class static1 extends
//#if 1457161450
            JMenuItem
//#endif

        {

//#if -2128074679
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate > PopUpMenu.this.model.getPlayground().length - 3) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate > PopUpMenu.this.model.getPlayground()[0].length - 3) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,0);
                }
            }
            ;
//#endif


//#if -898783639
            public static1()
            {

//#if 824827664
                super("static1");
//#endif


//#if -750278867
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif


//#if -1987909928
        class static2 extends
//#if 1653674955
            JMenuItem
//#endif

        {

//#if 7334547
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate >= PopUpMenu.this.model.getPlayground().length - 3) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate >= PopUpMenu.this.model.getPlayground()[0].length - 4) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 3,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 3,0);
                }
            }
            ;
//#endif


//#if -388248501
            public static2()
            {

//#if 1440496947
                super("static2");
//#endif


//#if 427604713
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif


//#if -1987909927
        class static3 extends
//#if 1850188460
            JMenuItem
//#endif

        {

//#if -1265762255
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate >= PopUpMenu.this.model.getPlayground().length - 4) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate >= PopUpMenu.this.model.getPlayground()[0].length - 4) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 3,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 3,0);
                }
            }
            ;
//#endif


//#if 122286637
            public static3()
            {

//#if -1402738084
                super("static3");
//#endif


//#if 653197279
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif


//#if -1987909926
        class static4 extends
//#if 2046701965
            JMenuItem
//#endif

        {

//#if 218160913
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate >= PopUpMenu.this.model.getPlayground().length - 4) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate >= PopUpMenu.this.model.getPlayground()[0].length - 4) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 3,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 3,0);
                }
            }
            ;
//#endif


//#if 632821775
            public static4()
            {

//#if -374788906
                super("static4");
//#endif


//#if 2046419684
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif

    }

//#endif


//#if -1293907726
    class PulsatingObjectsMenu extends
//#if 1889482054
        JMenu
//#endif

    {

//#if 1622922881
        public PulsatingObjectsMenu(    String name)
        {

//#if 40803018
            super(name);
//#endif


//#if 1183510003
            this.add(new Blinker());
//#endif


//#if 1636514785
            this.add(new Laser0());
//#endif


//#if 1638361827
            this.add(new Laser2());
//#endif

        }

//#endif


//#if 1368818970
        class Laser0 extends
//#if 798787557
            JMenuItem
//#endif

        {

//#if -1243289717
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate > PopUpMenu.this.model.getPlayground().length - 4) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate > PopUpMenu.this.model.getPlayground()[0].length - 4) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 3,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 3,1);
                }
            }
            ;
//#endif


//#if 1042753862
            public Laser0()
            {

//#if -1121830535
                super("0-Laser");
//#endif


//#if 2106327321
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif


//#if -495438508
        class Blinker extends
//#if -664871467
            JMenuItem
//#endif

        {

//#if -1058045345
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate > PopUpMenu.this.model.getPlayground().length - 3) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate > PopUpMenu.this.model.getPlayground()[0].length - 3) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,0);
                }
            }
            ;
//#endif


//#if -912748806
            public Blinker()
            {

//#if 907497322
                super("blinker");
//#endif


//#if -517331059
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif


//#if 1368818972
        class Laser2 extends
//#if 405760547
            JMenuItem
//#endif

        {

//#if -1243260002
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate > PopUpMenu.this.model.getPlayground().length - 5) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate > PopUpMenu.this.model.getPlayground()[0].length - 5) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 3,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate + 3,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 4,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 4,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 4,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 4,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate + 4,1);
                }
            }
            ;
//#endif


//#if -237107894
            public Laser2()
            {

//#if 727660902
                super("2-Laser");
//#endif


//#if 198037514
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif

    }

//#endif


//#if -619623869
    class MovingObjectsMenu extends
//#if -1115549580
        JMenu
//#endif

    {

//#if -382660436
        public MovingObjectsMenu(    String name)
        {

//#if -1539690803
            super(name);
//#endif


//#if 281436563
            this.add(new LightWeightSpaceship());
//#endif


//#if -1159820596
            this.add(new Glider());
//#endif

        }

//#endif


//#if 1528167536
        class Glider extends
//#if -1018553300
            JMenuItem
//#endif

        {

//#if -1238249306
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate > PopUpMenu.this.model.getPlayground().length - 3) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate > PopUpMenu.this.model.getPlayground()[0].length - 3) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,1);
                }
            }
            ;
//#endif


//#if 576280071
            public Glider()
            {

//#if 702018380
                super("Gleiter");
//#endif


//#if -2009748836
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif


//#if 680368759
        class LightWeightSpaceship extends
//#if -1175557112
            JMenuItem
//#endif

        {

//#if 359614968
            ActionListener act=new ActionListener()
            {
                public void actionPerformed(        ActionEvent e) {
                    if (xCoordinate < 0 || xCoordinate > PopUpMenu.this.model.getPlayground().length - 5) {
                        System.err.println("not in range");
                        return;
                    }
                    if (yCoordinate < 0 || yCoordinate > PopUpMenu.this.model.getPlayground()[0].length - 5) {
                        System.err.println("not in range");
                        return;
                    }
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 1,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate + 1,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 2,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate + 2,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 3,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 3,1);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate + 3,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate,yCoordinate + 4,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 1,yCoordinate + 4,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 2,yCoordinate + 4,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 3,yCoordinate + 4,0);
                    PopUpMenu.this.model.setLifeform(xCoordinate + 4,yCoordinate + 4,0);
                }
            }
            ;
//#endif


//#if -485139854
            public LightWeightSpaceship()
            {

//#if 1344393431
                super("Segler1");
//#endif


//#if 1056776476
                this.addActionListener(act);
//#endif

            }

//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

