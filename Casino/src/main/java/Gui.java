import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// My first Java Programm

/*
 +-------------------------------------------------------------------+
 |   Gui / JFrame / pane
 | +---------------------------------------------------------------+
 | |  centerFrame
 | | .............................................................
 | | :                        label Head
 | | :............................................................
 | | :
 | | :                         new JPanel
 | | :
 | | :   +--------------------------------------------------+
 | | :   | Grid inner Center
 | | :   |
 | | :   |
 | | :   |
 | | :   |
 | | :   +--------------------------------------------------+
 | | :...........................................................
 | +---------------------------------------------------------------+
 | |  Bottom
 | +---------------------------------------------------------------+
 +-------------------------------------------------------------------+
 */



class Gui extends JFrame{

    SlotMachine slotMachine = new SlotMachine();


    public Gui() {

        // Farben
        Color cBilder = new Color(204, 0, 0);
        Color cForeground = new Color(211, 211, 211);
        Color black = new Color(0, 0, 0);

        // Get Screen- height and width
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // JFrame declare
        setTitle("Bitterlins Casino Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MainContainer
        Container pane = getContentPane();
        pane.setBackground(cBilder);


        ////////////////////////////////////////
        // CenterFrame
        JPanel centerFrame = new JPanel();

        centerFrame.setBackground(black);
        centerFrame.setPreferredSize(new Dimension(500, 300));
        centerFrame.setLayout(new BorderLayout());

        // Picture
        ImageIcon icon = new ImageIcon("src/imges/gost.png");
        // SwingConstants.RIGHT -
        // um Labelinhalt R ausrichten.
        JLabel labelBild = new JLabel("Livia's Slot", icon, SwingConstants.LEFT);
        labelBild.setFont(new Font("Verdana", Font.BOLD, 33));
        labelBild.setBorder(new EmptyBorder(10, 10, 10, 10));
        labelBild.setForeground(cForeground);

        // Label Head
        JLabel labelHead = new JLabel(slotMachine.get_winMessage());
        labelHead.setFont(new Font("verdana", Font.BOLD, 15));
        labelHead.setForeground(Color.white);
        labelHead.setBorder(new EmptyBorder(10, 10, 10, 10));

        //=============================
        // Grid inner Center
        JPanel formFrame = new JPanel();
        formFrame.setBackground(Color.decode("#640C0C"));
        formFrame.setPreferredSize(new Dimension(300, 200));

        GridBagLayout gbl = new GridBagLayout();
        formFrame.setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        int sizeOfCharacters = 300;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JLabel l1 = new JLabel(slotMachine.get_RandomImageAfterPLayTheGame()[0], SwingConstants.RIGHT);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Verdana", Font.BOLD, sizeOfCharacters));
        l1.setForeground(cBilder);
        gbl.setConstraints(l1, gbc);
        formFrame.add(l1);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JLabel l2 = new JLabel(slotMachine.get_RandomImageAfterPLayTheGame()[1], SwingConstants.RIGHT);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Verdana", Font.BOLD, sizeOfCharacters));
        l2.setForeground(cBilder);
        gbl.setConstraints(l2, gbc);
        formFrame.add(l2);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JLabel l3 = new JLabel(slotMachine.get_RandomImageAfterPLayTheGame()[2], SwingConstants.RIGHT);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Verdana", Font.BOLD, sizeOfCharacters));
        l3.setForeground(cBilder);
        gbl.setConstraints(l3, gbc);
        formFrame.add(l3);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JLabel l4 = new JLabel(slotMachine.get_RandomImageAfterPLayTheGame()[3], SwingConstants.RIGHT);
        l4.setForeground(Color.white);
        l4.setFont(new Font("Verdana", Font.BOLD, sizeOfCharacters));
        l4.setForeground(cBilder);
        gbl.setConstraints(l4, gbc);
        formFrame.add(l4);

        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JLabel l5 = new JLabel(slotMachine.get_RandomImageAfterPLayTheGame()[3], SwingConstants.RIGHT);
        l5.setForeground(Color.white);
        l5.setFont(new Font("Verdana", Font.BOLD, sizeOfCharacters));
        l5.setForeground(cBilder);
        gbl.setConstraints(l5, gbc);
        formFrame.add(l5);

        // end inner Center
        //=============================

        centerFrame.add(labelHead, BorderLayout.NORTH);
        centerFrame.add(formFrame, BorderLayout.CENTER);
        ////////////////////////////////////////


        //--------------
        // Bottom
        Font bottomFont = new Font("verdana", Font.BOLD, 22);
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setBackground(cBilder);

        JLabel konto = new JLabel("Konto: " + slotMachine.get_cashAccount() + " $     |");
        konto.setFont(bottomFont);
        konto.setForeground(cForeground);

        JLabel einsatz = new JLabel(" Einsatz: " + slotMachine.get_betToString() + " $    |");
        einsatz.setFont(bottomFont);
        einsatz.setForeground(cForeground);

        JLabel lbl_letzterGewin = new JLabel("|   letzter Gewinn: " + slotMachine.get_lastWin() + "$");
        lbl_letzterGewin.setFont(bottomFont);
        lbl_letzterGewin.setForeground(cForeground);

        JButton einsatzPlus = new JButton("( + )");
        einsatzPlus.setFont(bottomFont);
        einsatzPlus.addActionListener(e -> {
            double einsatzPl = slotMachine.get_bet() + 0.5;
            if (slotMachine.get_bet() >= 2.0){
                einsatzPl = slotMachine.get_bet() + 1.0;
                if (slotMachine.get_bet() >= 5){
                    einsatzPl = slotMachine.get_bet() + 5;
                }
            }
            slotMachine.set_bet(einsatzPl);
            einsatz.setText(" Einsatz: " + slotMachine.get_betToString() + " $    |");
        });
        JButton einsatzMinus = new JButton("( - )");
        einsatzMinus.setFont(bottomFont);
        einsatzMinus.addActionListener(e -> {
            double einsatzMi = slotMachine.get_bet() - 0.5;
            if (slotMachine.get_bet() > 5.0) {
                einsatzMi = slotMachine.get_bet() - 5;
            }
            if (slotMachine.get_bet() <= 5.0){
                einsatzMi = slotMachine.get_bet() - 1.0;
            }
            slotMachine.set_bet(einsatzMi);
            einsatz.setText(" Einsatz: " + slotMachine.get_betToString() + " $    |");
        });
        JButton auszahlen = new JButton("payout");
        auszahlen.setFont(bottomFont);
        auszahlen.addActionListener(e -> {
            double k = slotMachine.get_cashAccount();
            labelHead.setText("Auszahlung Betrag: " + k + " \nDanke für dein Spiel :-)");
            String showInfoText = "Auszahlung Betrag: " + k + " \nDanke für dein Spiel :-)";
            showInfo(showInfoText);
            slotMachine.set_bet(0.5);
            slotMachine.set_cachAccount(100.0);
            slotMachine.set_lastWin(0.0);
            einsatz.setText(" Einsatz: " + slotMachine.get_betToString() + " $    |");
            konto.setText("Konto: " + slotMachine.get_cashAccount() + " $     |");
            lbl_letzterGewin.setText("|   letzter Gewinn: " + slotMachine.get_lastWin() + "$");
            slotMachine.resetImage();
            l1.setText(slotMachine.get_RandomImageAfterPLayTheGame()[0]);
            l2.setText(slotMachine.get_RandomImageAfterPLayTheGame()[1]);
            l3.setText(slotMachine.get_RandomImageAfterPLayTheGame()[2]);
            l4.setText(slotMachine.get_RandomImageAfterPLayTheGame()[3]);
            l5.setText(slotMachine.get_RandomImageAfterPLayTheGame()[4]);
            slotMachine.set_winMessage("Viel Glück");
            labelHead.setText(slotMachine.get_winMessage());

        });


        // ************************
        // ***BUTTON Start Spiel***

        JButton send = new JButton(" -  START  - ");
        send.setFont(bottomFont);
        send.addActionListener(e -> {
            if (!slotMachine.isAccountGreaterThanBet())
            {
                if (slotMachine.get_cashAccount() > 0.5) {
                    showInfo("Einsatz höher als Kontostand\nBitte setze einen kleineren Einsatz!");
                }

                else {
                    double k = slotMachine.get_cashAccount();
                    labelHead.setText("Auszahlung Betrag: " + k + " \nDanke für dein Spiel :-)");
                    String showInfoText = "Auszahlung Betrag: " + k + " \nDanke für dein Spiel :-)";
                    showInfo(showInfoText);
                    slotMachine.set_bet(0.5);
                    slotMachine.set_cachAccount(100.0);
                    slotMachine.set_lastWin(0.0);
                    einsatz.setText(" Einsatz: " + slotMachine.get_betToString() + " $    |");
                    konto.setText("Konto: " + slotMachine.get_cashAccount() + " $     |");
                    lbl_letzterGewin.setText("|   letzter Gewinn: " + slotMachine.get_lastWin() + "$");
                    slotMachine.resetImage();
                    l1.setText(slotMachine.get_RandomImageAfterPLayTheGame()[0]);
                    l2.setText(slotMachine.get_RandomImageAfterPLayTheGame()[1]);
                    l3.setText(slotMachine.get_RandomImageAfterPLayTheGame()[2]);
                    l4.setText(slotMachine.get_RandomImageAfterPLayTheGame()[3]);
                    l5.setText(slotMachine.get_RandomImageAfterPLayTheGame()[4]);
                    slotMachine.set_winMessage("Viel Glück");
                    labelHead.setText(slotMachine.get_winMessage());
                    Gui.showInfo("Sorry, leider zu wenig auf deinem Konto,\nWir verabschieden uns von dir\nDanke für das Spiel.");
                }
            }
            else
            {
                labelHead.setHorizontalAlignment(SwingConstants.CENTER);
                labelHead.setFont(new Font("Verdana", Font.BOLD, 33));
                slotMachine.set_winMessage("");
                labelHead.setText(slotMachine.get_winMessage());

                slotMachine.spiel();
                l1.setText(slotMachine.get_RandomImageAfterPLayTheGame()[0]);
                l2.setText(slotMachine.get_RandomImageAfterPLayTheGame()[1]);
                l3.setText(slotMachine.get_RandomImageAfterPLayTheGame()[2]);
                l4.setText(slotMachine.get_RandomImageAfterPLayTheGame()[3]);
                l5.setText(slotMachine.get_RandomImageAfterPLayTheGame()[4]);

                slotMachine.calculatetWin();
                konto.setText("Konto: " + slotMachine.get_cashAccount() + " $     |");
                lbl_letzterGewin.setText("|   letzter Gewinn: " + slotMachine.get_lastWin() + "$");
                labelHead.setText(slotMachine.get_winMessage());
            }
        });
        // *** END BUTTON ***
        // ******************

        panel.add(konto);
        panel.add(einsatz);
        panel.add(einsatzMinus);
        panel.add(einsatzPlus);
        panel.add(auszahlen);
        panel.add(send);
        panel.add(lbl_letzterGewin);
        // End Bottom
        //--------------

        getContentPane().add(labelBild, BorderLayout.PAGE_START);
        getContentPane().add(centerFrame, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.SOUTH);

        pack();

        // Set the window as big as screen and visible at the end
        setSize(screenWidth, screenHeight);
        setVisible(true);
    }

    public static void showInfo(String itext) {
        JFrame info = new JFrame("Information du Depp!!!");
        JOptionPane.showMessageDialog(info, itext);
    }

    public static void main(String[] args)
    {
        new Gui();
    }

}
