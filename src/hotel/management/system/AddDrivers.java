package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddDrivers extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox genderCombo, availableCombo;
    
    AddDrivers(){
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("ADD DRIVERS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblname.setBounds(60, 70, 120, 30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 70, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblage.setBounds(60, 110, 120, 30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(220, 110, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblgender.setBounds(60, 150, 120, 30);
        add(lblgender);
        
        String genderOptions[] = {"Male", "Female"};
        genderCombo = new JComboBox(genderOptions);
        genderCombo.setBounds(220, 150, 150, 30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);
        
        JLabel lblcar = new JLabel("CAR COMPANY");
        lblcar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblcar.setBounds(60, 190, 120, 30);
        add(lblcar);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(220, 190, 150, 30);
        add(tfcompany);
        
        JLabel lblmodel = new JLabel("CAR MODEL");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblmodel.setBounds(60, 230, 120, 30);
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(220, 230, 150, 30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("AVAILABILITY");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblavailable.setBounds(60, 270, 120, 30);
        add(lblavailable);
        
        String driverOptions[] = {"Available", "Busy"};
        availableCombo = new JComboBox(driverOptions);
        availableCombo.setBounds(220, 270, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);
        
        JLabel lbllocation = new JLabel("LOCATION");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbllocation.setBounds(60, 310, 120, 30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(220, 310, 150, 30);
        add(tflocation);
 
        add = new JButton("ADD DRIVER");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 360, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 360, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(300, 200, 980, 470);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)genderCombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String availability = (String)availableCombo.getSelectedItem();
            String location = tflocation.getText();
            
            try{
                
                Conn c = new Conn();
                String query = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"', '"+availability+"', '"+location+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new AddDrivers();
    }
}
