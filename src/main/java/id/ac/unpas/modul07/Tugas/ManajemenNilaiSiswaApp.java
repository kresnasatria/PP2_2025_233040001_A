package id.ac.unpas.modul07.Tugas;

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
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
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

        // Tombol Simpan
        panel.add(new JLabel(""));
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(btnSimpan);

        // Tombol Reset (TUGAS)
        panel.add(new JLabel(""));
        JButton btnReset = new JButton("Reset Input");
        panel.add(btnReset);

        // Event tombol simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        // Event tombol reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtNilai.setText("");
                cmbMatkul.setSelectedIndex(0);
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

        // Panel tombol hapus
        JPanel panelBottom = new JPanel();
        JButton btnHapus = new JButton("Hapus Data");
        panelBottom.add(btnHapus);

        panel.add(panelBottom, BorderLayout.SOUTH);

        // Event tombol hapus (TUGAS)
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableData.getSelectedRow();
                if (row >= 0) {
                    tableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(null,
                        "Pilih data yang akan dihapus!");
                }
            }
        });

        return panel;
    }

    // Proses Simpan (versi tugas)
    private void prosesSimpan() {
        String nama = txtNama.getText().trim();
        String strNilai = txtNilai.getText().trim();
        String matkul = (String) cmbMatkul.getSelectedItem();
        int nilai;

        // Validasi nama kosong
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!");
            return;
        }

        // Validasi minimal 3 karakter (TUGAS)
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                "Nama harus minimal 3 karakter!");
            return;
        }

        // Validasi nilai angka
        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Nilai harus berupa angka!");
            return;
        }

        // Validasi rentang nilai
        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this,
                "Nilai harus berada pada rentang 0–100!");
            return;
        }

        // Logika Grade menggunakan SWITCH CASE (TUGAS)
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9: grade = "A"; break;
            case 8: grade = "B"; break;
            case 7: grade = "C"; break;
            case 6: grade = "D"; break;
            default: grade = "E"; break;
        }

        // Menambah ke tabel
        tableModel.addRow(new Object[] { nama, matkul, nilai, grade });

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
    }

    // Konstruktor
    public ManajemenNilaiSiswaApp() {
        setTitle("Manajemen Nilai Siswa - Tugas Modifikasi");
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
