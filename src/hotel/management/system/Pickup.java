package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener{
    
    JTable table;
    JButton back, submit;
    Choice typeofcar;
    JCheckBox available;

    Pickup(){
        
        setBounds(300, 200, 1050, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);
        
        JLabel lblcar = new JLabel("Type of Car");
        lblcar.setBounds(50, 100, 100, 20);
        add(lblcar);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150, 100, 200, 25);
        typeofcar.setBackground(Color.WHITE);
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("model"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel l1 = new JLabel("NAME");
        l1.setBounds(50, 160, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("AGE");
        l2.setBounds(200, 160, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("GENDER");
        l3.setBounds(340, 160, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("COMPANY");
        l4.setBounds(480, 160, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("MODEL");
        l5.setBounds(620, 160, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("AVAILABILITY");
        l6.setBounds(760, 160, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("LOCATION");
        l7.setBounds(900, 160, 100, 20);
        add(l7);
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);
        
        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn c = new Conn();
            String query = "select * from driver";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                
                String car = (String)typeofcar.getSelectedItem();
                Conn c = new Conn();
                ResultSet rs;
                String query1 = "select * from driver where model = '"+car+"'";
                rs = c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new Pickup();
    }
}
