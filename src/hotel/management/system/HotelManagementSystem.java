package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){
//        setSize(1366, 565);
//        setLocation(100, 100);  wrt screen
        setBounds(100, 100, 1366, 565);
        setLayout(null);  // by default, it is set to border layout
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);  // location x, location y, length, breadth
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 24));
        image.add(next);
        
        setVisible(true);  // by default, it is set to false
        
        // Dipper Functionality
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }     
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
