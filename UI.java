import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UI {
    JFrame window = new JFrame("Physics");
    JTextField tfmass = new JTextField("Enter mass");
    JTextField tfAcceleration = new JTextField("Acceleration");
    JButton btnCalculate = new JButton("calculate");

    void drawUI(){
        window.add(tfmass);
        window.add(tfAcceleration);
        window.add(btnCalculate);
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
              try{  Physics physics = new Physics();
                float mass = Float.valueOf(tfmass.getText());
                float acceleration = Float.valueOf(tfAcceleration.getText());
                JOptionPane.showMessageDialog(null, physics.calculateForce(mass, acceleration));
              }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,  "enter only numeric values");
                nfe.prtintStackTrace();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Something strange happened" , null, 0);
            }
            }
        });
        
        window.setSize(299,250);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setLayout(new GridLayout(3,2));
    }
}
