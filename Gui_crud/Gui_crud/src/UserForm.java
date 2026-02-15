import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserForm extends JFrame {
    public UserForm() {
        setTitle("User Data Collection");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        //panel components
        JLabel username = new JLabel("Username");
        JTextField usernameFiels = new JTextField();
        panel.add(username);
        panel.add(usernameFiels);

        JLabel age = new JLabel("Age");
        JTextField ageFiels = new JTextField();
        panel.add(age);
        panel.add(ageFiels);

        JLabel city = new JLabel("City");
        JTextField cityFiels = new JTextField();
        panel.add(city);
        panel.add(cityFiels);

        JComboBox<String> genderFiels = new JComboBox<>(new String[]{"Male","Female","Other"});
        panel.add(genderFiels);

        JButton submit = new JButton("Submit");
        panel.add(submit);

        add(panel);

        submit.addActionListener(e -> {
            String name = usernameFiels.getText();
            String ageStr = ageFiels.getText();
            String cityStr = cityFiels.getText();
            String genderStr = genderFiels.getSelectedItem().toString();

            JOptionPane.showMessageDialog(this,
                   "Name :" + name + " \nAge :" + ageStr + " \nCity :" + cityStr + " \nGender :" + genderStr );

            try {
                Connection conn = Config.getConnection();
                if(conn != null){
                    String sql = "INSERT INTO UserData (UserName,Age,City,Gender) VALUES (?,?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);

                    stmt.setString(1,name);
                    stmt.setString(2, String.valueOf(Integer.parseInt(ageStr)));
                    stmt.setString(3,cityStr);
                    stmt.setString(4,genderStr);

                    stmt.executeUpdate();
                    conn.close();

                    JOptionPane.showMessageDialog(this,"Data Added Successfully");
                }

                }catch (Exception ex){

                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,ex.getMessage());

            }

        });

    }
    public static void main(String[] args) {
        new UserForm().setVisible(true);
    }
}
