package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox availableCombo, typeCombo, cleanCombo;
    
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblroomno = new JLabel("ROOM NO");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblroomno.setBounds(60, 80, 120, 30);
        add(lblroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(220, 80, 150, 30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("AVAILABLE");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        
        String availableOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(220, 130, 150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);
        
        JLabel lblclean = new JLabel("CLEANING STATUS");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        
        String cleanOptions[] = {"Cleaned", "Dirty"};
        cleanCombo = new JComboBox(cleanOptions);
        cleanCombo.setBounds(220, 180, 150, 30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);
        
        JLabel lblprice = new JLabel("ROOM RENT");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(220, 230, 150, 30);
        add(tfprice);
        
        JLabel lbltype = new JLabel("ROOM TYPE");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);
        
        String typeOptions[] = {"Single Bed", "Double Bed"};
        typeCombo = new JComboBox(typeOptions);
        typeCombo.setBounds(220, 280, 150, 30);
        typeCombo.setBackground(Color.WHITE);
        add(typeCombo);
        
        add = new JButton("ADD ROOM");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(330, 200, 940, 470);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            
            String roomnumber = tfroom.getText();
            String roomprice = tfprice.getText();
            String availability = (String)availableCombo.getSelectedItem();
            String status = (String)cleanCombo.getSelectedItem();
            String type = (String)typeCombo.getSelectedItem();
            
            try{
                
                Conn c = new Conn();
                String query = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+roomprice+"', '"+type+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
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
        new AddRooms();
    }
}
