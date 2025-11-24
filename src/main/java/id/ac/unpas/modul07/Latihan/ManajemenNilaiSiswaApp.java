package id.ac.unpas.modul07.Latihan;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ManajemenNilaiSiswaApp extends JFrame {

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;

    private JTable tableData;
    private DefaultTableModel tableModel;

    private JTabbedPane tabbedPane;

    // Panel Input
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {
            "Matematika Dasar",
            "Bahasa Indonesia",
            "Algoritma dan Pemrograman I",
            "Praktikum Pemrograman II"
        };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        panel.add(new JLabel("Nilai (0–100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        panel.add(new JLabel(""));
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(btnSimpan);

        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        return panel;
    }

    // Panel Tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = { "Nama", "Mata Kuliah", "Nilai", "Grade" };
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        panel.add(new JScrollPane(tableData), BorderLayout.CENTER);

        return panel;
    }

    // Proses Simpan (versi latihan)
    private void prosesSimpan() {
        String nama = txtNama.getText().trim();
        String strNilai = txtNilai.getText().trim();
        String matkul = (String) cmbMatkul.getSelectedItem();
        int nilai;

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!");
            return;
        }

        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!");
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this, "Nilai harus 0–100!");
            return;
        }

        // Logika grade (latihan: pakai if)
        String grade;
        if (nilai >= 90) grade = "A";
        else if (nilai >= 80) grade = "B";
        else if (nilai >= 70) grade = "C";
        else if (nilai >= 60) grade = "D";
        else grade = "E";

        tableModel.addRow(new Object[] { nama, matkul, nilai, grade });

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
    }

    // Konstruktor
    public ManajemenNilaiSiswaApp() {
        setTitle("Manajemen Nilai Siswa");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Input Data", createInputPanel());
        tabbedPane.addTab("Daftar Nilai", createTablePanel());

        add(tabbedPane);
    }

    // Main
    public static void main(String[] args) {
        new ManajemenNilaiSiswaApp().setVisible(true);
    }
}
