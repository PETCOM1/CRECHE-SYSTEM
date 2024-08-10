
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Munzhedzi Munyadziwa Petrus @Petcom Digital and Software Distribution
 */
public class CrecheGUI extends JFrame implements ActionListener{
    
    //Panels 
    private JPanel namePanel;
    private JPanel genderPanel;
    private JPanel buttonPanel;
    private JPanel displayPanel;
    private JPanel mainPanel;
    
    //Collective Panels
    private JPanel nameNGenderPanel;
    private JPanel buttonsNDispAreaPanel;
    
    //labels
    private JLabel nameLabel;
    private JLabel genderLabel;
    
    //Text Field
    private JTextField nameTextField;
   
    //Radio Buttons
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    
    //Buttons
    private JButton registerButton;
    private JButton displayKiddiesButton;
    
    //TextArea
    private JTextArea displayArea;
    
    //Scroll pane
    private JScrollPane scrollPane;
    
    //Create a portal to accesss Crech Backend and make it global
    private CrecheChildReg crech = new CrecheChildReg();

    public CrecheGUI(){
        setSize(500, 550);
        setResizable(false);
        setTitle("CRECHE 4 YOUR KIDDIE");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setLayout();
        
        //My code starts Here
        
        //Intialize the panels
        namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        displayPanel = new JPanel(new BorderLayout());
        
        nameNGenderPanel = new JPanel(new BorderLayout());
        buttonsNDispAreaPanel = new JPanel(new BorderLayout());
        
        mainPanel = new JPanel(new BorderLayout());
        
        //Intialize labels
        nameLabel = new JLabel("Name: ");
        genderLabel = new JLabel("Gender");
        
        //Initialize the the Textfield
        nameTextField = new JTextField(10);
        
        
        //Intialize Buttons Group
        ButtonGroup groupMyButtons = new ButtonGroup();
        //Initialize radio buttons
        maleButton = new JRadioButton("Male");
        femaleButton= new JRadioButton("Female");
        groupMyButtons.add(maleButton);
        groupMyButtons.add(femaleButton);
        maleButton.addActionListener(this);
        femaleButton.addActionListener(this);
        maleButton.setFocusable(false);
        femaleButton.setFocusable(false);
        
        //Initialize my buttons;
        registerButton = new JButton("Register Kiddie");
        registerButton.setBounds(100, 30, 3, 3);
        registerButton.addActionListener(this);
        registerButton.setFocusable(false);
        
        displayKiddiesButton = new JButton("Display Kiddies");
        displayKiddiesButton.setBounds(100, 30, 3, 3);
        displayKiddiesButton.addActionListener(this);
        registerButton.setFocusable(false);
        
        //Initialize the Text Area
        displayArea = new JTextArea(20 ,30);
        displayArea.setEditable(false);
        //displayArea.setBounds(500, 500, 1, 1);
        scrollPane = new JScrollPane(displayArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //Now put everything together
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        
        genderPanel.add(genderLabel);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        
        buttonPanel.add(registerButton);
        buttonPanel.add(displayKiddiesButton);
        
        //displayPanel.add(displayArea,BorderLayout.CENTER);
        displayPanel.add(scrollPane,BorderLayout.CENTER);
        
        //Collective Panel 1
        nameNGenderPanel.add(namePanel,BorderLayout.NORTH);
        nameNGenderPanel.add(genderPanel,BorderLayout.SOUTH);
        
        //Collective Panel 2
        buttonsNDispAreaPanel.add(buttonPanel,BorderLayout.NORTH);
        buttonsNDispAreaPanel.add(displayPanel,BorderLayout.SOUTH);
        
        
        mainPanel.add(nameNGenderPanel,BorderLayout.NORTH);
        mainPanel.add(buttonsNDispAreaPanel,BorderLayout.SOUTH);
        add(mainPanel);
        
        
        pack();
        //My code ends Here
        
        setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(e.getSource() == displayKiddiesButton){
            
            File myfile = new File("C:\\Users\\Khalushi\\Desktop\\Kids.txt");
            
            try {
                
                displayArea.setText("Munzhedzi Munyadziwa Petrus");
                
                System.out.println("Hello ive initiaded the reading sequence");
                FileReader flRead = new FileReader(myfile);
                BufferedReader bfRead= new BufferedReader(flRead);
                StringBuilder content = new StringBuilder();
                
                String line = bfRead.readLine()+"";
                
                while ((line = bfRead.readLine()) != null) {    
                    
                    //line += bfRead.readLine()+"/n";
                    content.append(line).append("\n");
                    
                    //System.out.println(line);
                            
                    
                }
                
                displayArea.setText(content.toString());
                //displayArea.setText(line);
                //bfRead.close();
                //flRead.close();
                
               
                System.out.println("File Read Successfully" + line);
            } catch (IOException x) {
                
                System.out.print("Oops unable to connect to the file");
            }
            
        }
        
        
        else if(e.getSource() == registerButton){
            
            File myfile = new File("C:\\Users\\Khalushi\\Desktop\\Kids.txt");
            
            try {
                
                
                crech.setChildName(nameTextField.getText());
                if(maleButton.isSelected()){
                    crech.setGender("Male");
                }
                else if(femaleButton.isSelected()){
                    crech.setGender("Female");
                }
                
                FileWriter flWrite = new FileWriter(myfile,true);
                BufferedWriter bfWrite = new BufferedWriter(flWrite);
                
                
                //Debugger statement
              
                bfWrite.write(crech.joinString()+"\n");
                bfWrite.close();
                flWrite.close();
                nameTextField.setText(null);
                JOptionPane.showMessageDialog(null, "Child add Successfully");
            
                
            } catch (IOException y) {
                System.out.println("Couldnt save the child, please ensure that your path name is correct");
            }
        }
           
            
     }
    
    public static void main(String[] args) {
        
        new CrecheGUI();
        
        
    }
        
    
}
