package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class Checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton checkout, back;
    
    Checkout(){
        getContentPane().setBackground(Color.white);
        setBounds(300, 200, 800, 400);
        
        JLabel heading = new JLabel("CheckOut");
        heading.setBounds(100, 20, 100, 30);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(heading);
        
        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 85, 150, 30);
        add(ccustomer);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310, 85, 20, 20);
        add(tick);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 100, 30);
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 100, 30);
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 200, 30);
        add(lblcheckouttime);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(170, 280, 120, 30);
        add(back);
        
        try{  
            Conn c = new Conn();
            String query = "select * from customer";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                ccustomer.add(rs.getString("docnumber"));
                lblroomnumber.setText(rs.getString("roomnumber"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        back.addActionListener(this);
        add(image);
        
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout){
            String number = ccustomer.getSelectedItem();
            String roomnumber = lblroomnumber.getText();
            
            try{
                String query1 = "delete from customer where docnumber = '"+number+"'";
                String query2 = "update room set availability = 'Available' where roomnumber = '"+roomnumber+"'";
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeQuery(query2);
                JOptionPane.showMessageDialog(null, "Checkout Done Successfully");
                setVisible(false);
                new Reception();
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Checkout();
    }
}
