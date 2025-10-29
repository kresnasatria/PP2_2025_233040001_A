/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package id.ac.unpas.modul05;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ROG STRIX
 */
public class Latihan1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Jendela Pertamaku");
                
                frame.setSize(400, 300);
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.setVisible(true);
            }
        });
        
    }  
}
