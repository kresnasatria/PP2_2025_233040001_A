package id.ac.unpas.modul08.view;

/**
 *
 * @author ROG STRIX
 */

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    private JLabel lblKeliling = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        // Inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 250);
        this.setLayout(new GridLayout(6, 2, 10, 10));  // 6 baris × 2 kolom
        this.setTitle("MVC Kalkulator");

        // Baris 1
        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);

        // Baris 2
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);

        // Baris 3
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);

        // Baris 4
        this.add(new JLabel("Keliling:"));
        this.add(lblKeliling);

        // Baris 5
        this.add(new JLabel(""));
        this.add(btnHitung);

        // Baris 6 (Reset)
        this.add(new JLabel(""));
        this.add(btnReset);
    }

    // Setter hasil keliling
    public void setKeliling(double k) {
        lblKeliling.setText(String.valueOf(k));
    }

    // Mengambil nilai panjang dari Textfield
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    // Mengambil nilai lebar dari Textfield
    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    // Menampilkan hasil luas ke Label
    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }

    // Menampilkan pesan error
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    // Mendaftarkan Listener tombol hitung
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }

    // Mendaftarkan Listener tombol reset
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }

    // Method untuk mengosongkan input dan mengembalikan hasil default
    public void resetInput() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("-");
        lblKeliling.setText("-");
    }
}
