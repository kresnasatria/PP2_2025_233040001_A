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
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                JFrame frame = new JFrame("Jendela Pertamaku");
//                
//                frame.setSize(400, 300);
//                
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                
//                frame.setVisible(true);
//            }
//        });
        
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Label diletakkan di bagian bawah (SOUTH)
                JLabel label = new JLabel("Tombol South diklik", JLabel.CENTER);

                // Membuat semua tombol
                JButton btnNorth = new JButton("NORTH");
                JButton btnSouth = new JButton("SOUTH (tidak bisa diklik)");
                JButton btnEast = new JButton("EAST");
                JButton btnWest = new JButton("WEST");
                JButton btnCenter = new JButton("CENTER");

                // Tambahkan tombol dan label ke frame
                frame.add(btnNorth, BorderLayout.NORTH);
                frame.add(btnSouth, BorderLayout.SOUTH); // tombol SOUTH tetap di bawah
                frame.add(btnEast, BorderLayout.EAST);
                frame.add(btnWest, BorderLayout.WEST);
                frame.add(btnCenter, BorderLayout.CENTER); // tombol utama di tengah
                frame.add(label, BorderLayout.PAGE_END); // label di bagian paling bawah

                // Aksi untuk setiap tombol selain SOUTH
                btnNorth.addActionListener(e -> label.setText("Tombol NORTH diklik!"));
                btnEast.addActionListener(e -> label.setText("Tombol EAST diklik!"));
                btnWest.addActionListener(e -> label.setText("Tombol WEST diklik!"));
                btnCenter.addActionListener(e -> label.setText("Tombol CENTER diklik!"));

                // Tombol SOUTH tidak bisa diklik
                btnSouth.setEnabled(false);

                frame.setVisible(true);
            }
        });
        
    }  
    
    
}
