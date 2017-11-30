import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Gui extends JFrame implements ActionListener{
	
	JLabel lYearChooser, lDayChooser, lMonthChooser, lClientChooser, JResult;
    JMenuBar menuBar;
    JButton bSearch, bReset;
    JMenu menuFile, menuHelp;
    JMenuItem menuClose, menuAbout;
    JComboBox<String> bYear, bDay, bMonth, bClient;
    JTextArea textField;
    
	
	private static final String UNDERSCORE = "_";

	 private static final String SLASH = "/";

	
	 public boolean sampleMethod() throws IOException {

	       String path = "res/data" + SLASH + bClient.getSelectedItem();
	        
	        String filePrefix = new StringBuilder()
	                .append(bClient.getSelectedItem())
	                .append(UNDERSCORE)
	                .append(bYear.getSelectedItem())
	                .append(bMonth.getSelectedItem().toString())
	                .append(bDay.getSelectedItem().toString())
	                .toString();
	        
	        return (Files.list(Paths.get(path))
	                .map(onePath -> onePath.getFileName().toString())
	                .anyMatch(file -> file.startsWith(filePrefix)));
	        
	        
	    }
    
    

    public Gui() {
        setLayout(null);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuClose = new JMenuItem("Close");

        menuClose.addActionListener(this);
        menuClose.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        menuFile.add(menuClose);

        menuHelp = new JMenu("Help");
        menuAbout = new JMenuItem("About");
        menuAbout.addActionListener(this);
        menuHelp.add(menuAbout);

        setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuHelp);

        menuFile.setFont(new Font("SansSerif", Font.BOLD, 20));
        menuHelp.setFont(new Font("SansSerif", Font.BOLD, 20));
        menuClose.setFont(new Font("SansSerif", Font.BOLD, 20));
        menuAbout.setFont(new Font("SansSerif", Font.BOLD, 20));

        textField = new JTextArea();
        textField.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textField);
        scrollPane.setBounds(20, 135, 760, 270);
        textField.setFont(new Font("SansSerif", Font.BOLD, 16));
        textField.setForeground(Color.BLUE);
        add(scrollPane);

        JResult = new JLabel("Searching results: ", JLabel.LEFT);
        JResult.setFont(new Font("SansSerif", Font.BOLD, 20));
        JResult.setBounds(20, 90, 250, 25);
        add(JResult);

        bYear = new JComboBox();
        bYear.setBounds(20, 40, 120, 40);
        bYear.setFont(new Font("SansSerif", Font.BOLD, 20));
        bYear.addItem(" ");
        bYear.addItem("2016");
        bYear.addItem("2015");
        bYear.addItem("2014");
        bYear.addItem("2013");
        bYear.addItem("2012");
        bYear.addItem("2011");
        add(bYear);
        bYear.addActionListener(this);

        bMonth = new JComboBox();
        bMonth.setBounds(180, 40, 120, 40);
        bMonth.setFont(new Font("SansSerif", Font.BOLD, 20));
        bMonth.addItem(" ");
        bMonth.addItem("01");
        bMonth.addItem("02");
        bMonth.addItem("03");
        bMonth.addItem("04");
        bMonth.addItem("05");
        bMonth.addItem("06");
        bMonth.addItem("07");
        bMonth.addItem("08");
        bMonth.addItem("09");
        bMonth.addItem("10");
        bMonth.addItem("11");
        bMonth.addItem("12");
        add(bMonth);
        bMonth.addActionListener(this);

        bDay = new JComboBox();
        bDay.setBounds(320, 40, 120, 40);
        bDay.setFont(new Font("SansSerif", Font.BOLD, 20));
        bDay.addItem(" ");
        bDay.addItem("01");
        bDay.addItem("02");
        bDay.addItem("03");
        bDay.addItem("04");
        bDay.addItem("05");
        bDay.addItem("06");
        bDay.addItem("07");
        bDay.addItem("08");
        bDay.addItem("09");
        bDay.addItem("10");
        bDay.addItem("11");
        bDay.addItem("12");
        bDay.addItem("13");
        bDay.addItem("14");
        bDay.addItem("15");
        bDay.addItem("16");
        bDay.addItem("17");
        bDay.addItem("18");
        bDay.addItem("19");
        bDay.addItem("20");
        bDay.addItem("21");
        bDay.addItem("22");
        bDay.addItem("23");
        bDay.addItem("24");
        bDay.addItem("25");
        bDay.addItem("26");
        bDay.addItem("27");
        bDay.addItem("28");
        bDay.addItem("29");
        bDay.addItem("30");
        bDay.addItem("31");
        add(bDay);
        bDay.addActionListener(this);
        
        bClient = new JComboBox();
        bClient.setBounds(460, 40, 120, 40);
        bClient.setFont(new Font("SansSerif", Font.BOLD, 20));
        bClient.addItem(" ");
        bClient.addItem("ssc");
        bClient.addItem("gmbh");
        add(bClient);
        bClient.addActionListener(this);

        bSearch = new JButton("SEARCH !");
        bSearch.setBounds(620, 40, 130, 40);
        add(bSearch);
        bSearch.addActionListener(this);
        bSearch.setFont(new Font("SansSerif", Font.BOLD, 20));

        bReset = new JButton("RESET");
        bReset.setBounds(320, 410, 130, 40);
        add(bReset);
        bReset.addActionListener(this);
        bReset.setFont(new Font("SansSerif", Font.BOLD, 20));

        lYearChooser = new JLabel("Choose YEAR", JLabel.LEFT);
        lYearChooser.setBounds(15, 20, 160, 20);
        lYearChooser.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(lYearChooser);

        lMonthChooser = new JLabel("Choose MONTH", JLabel.LEFT);
        lMonthChooser.setBounds(180, 20, 160, 20);
        lMonthChooser.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(lMonthChooser);

        lDayChooser = new JLabel("Choose DAY", JLabel.LEFT);
        lDayChooser.setBounds(320, 20, 180, 20);
        lDayChooser.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(lDayChooser);
        
        lClientChooser = new JLabel("Choose CLIENT", JLabel.LEFT);
        lClientChooser.setBounds(460, 20, 180, 20);
        lClientChooser.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(lClientChooser);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        FlightSearch flightSearch = new FlightSearch();

        if (e.getSource() == menuClose) {
            int odp = JOptionPane.showConfirmDialog(null, "ARE YOU SURE?", "QUESTION",
                    JOptionPane.YES_NO_OPTION);
            if (odp == JOptionPane.YES_OPTION)
                dispose();
            else if (odp == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "OK");
            } else if (odp == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "YOU HAVE TO CHOOSE YES OR NO", "TITLE", JOptionPane.WARNING_MESSAGE);
            }

        }
        
        if (e.getSource() == bSearch)
        {

           
            textField.setText("");
            try {
            	if (sampleMethod() == true);
				textField.setText("Is Nav file with requested date " + bYear.getSelectedItem() 
				+ "/" + bMonth.getSelectedItem() + "/" + bDay.getSelectedItem() + " in " + bClient.getSelectedItem() + " folder ? - " + sampleMethod());
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

        }

        if (e.getSource() == menuAbout)
        {
            JOptionPane.showMessageDialog(null, "Simple Searcher for State Street \n Version Alfa 0.1", "TITLE",
                    JOptionPane.WARNING_MESSAGE);
        }

        if (e.getSource() == bReset)
        {

            textField.setText(" ");

        }
        

    }

	
	
	
}