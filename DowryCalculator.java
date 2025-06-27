import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DowryCalculator extends JFrame {

    private JComboBox<String> professionCombo;
    private JComboBox<String> incomeCombo;
    private JTextArea resultArea;

    public DowryCalculator() {
        setTitle("Dowry Calculator");
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("....WELCOME TO HELL MY FRIEND....", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 18));
        welcomeLabel.setForeground(Color.RED);

        professionCombo = new JComboBox<>(new String[]{
                "Select Profession",
                "Government & Public Services",
                "Private Sector",
                "Business Sector"
        });

        incomeCombo = new JComboBox<>(new String[]{"Select Profession First"});
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JButton calculateButton = new JButton("Calculate Dowry");

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Choose Profession:"));
        inputPanel.add(professionCombo);
        inputPanel.add(new JLabel("Choose Salary/Income Range:"));
        inputPanel.add(incomeCombo);
        inputPanel.add(calculateButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(welcomeLabel, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        professionCombo.addActionListener(e -> updateIncomeOptions());
        calculateButton.addActionListener(e -> calculateResult());

        setVisible(true);
    }

    private void updateIncomeOptions() {
        int selectedIndex = professionCombo.getSelectedIndex();
        incomeCombo.removeAllItems();

        if (selectedIndex == 1) {
            incomeCombo.addItem("1. ₹40K–₹50K");
            incomeCombo.addItem("2. ₹80K–₹100K");
            incomeCombo.addItem("3. ₹100K+");
        } else if (selectedIndex == 2) {
            incomeCombo.addItem("1. ₹40K–₹50K");
            incomeCombo.addItem("2. ₹60K–₹80K");
            incomeCombo.addItem("3. ₹80K+");
        } else if (selectedIndex == 3) {
            incomeCombo.addItem("1. Agro-based & Rural Business");
            incomeCombo.addItem("2. Retail & Wholesale Business");
            incomeCombo.addItem("3. Manufacturing / Production (Small Scale)");
        } else {
            incomeCombo.addItem("Select Profession First");
        }
    }

    private void calculateResult() {
        int choice = professionCombo.getSelectedIndex();
        int range = incomeCombo.getSelectedIndex();
        resultArea.setText("");

        if (choice == 1) {
            if (range == 0) {
                resultArea.setText("A car up to ₹10 lakhs\nCash up to ₹5 lakhs plus gold up to ₹3 lakhs\nOther essentials: AC, Washing Machine, etc.\nApprox total = ₹25 lakhs");
            } else if (range == 1) {
                resultArea.setText("A car up to ₹20 lakhs\nCash up to ₹8 lakhs plus gold up to ₹5 lakhs\nOther essentials: AC, Washing Machine, etc.\nApprox total = ₹40 lakhs");
            } else if (range == 2) {
                resultArea.setText("A car up to ₹25 lakhs\nCash up to ₹10 lakhs plus gold up to ₹10 lakhs\nOther essentials: AC, Washing Machine, etc.\nApprox total = ₹55 lakhs");
            }
        }

        if (choice == 2) {
            if (range == 0) {
                resultArea.setText("A car up to ₹6 lakhs\nCash up to ₹1.5 lakhs plus gold up to ₹1 lakh\nOther essentials: Washing Machine, etc.\nApprox total = ₹10 lakhs");
            } else if (range == 1) {
                resultArea.setText("A car up to ₹8 lakhs\nCash up to ₹2.5 lakhs plus gold up to ₹2 lakhs\nOther essentials: AC, Washing Machine, etc.\nApprox total = ₹15 lakhs");
            } else if (range == 2) {
                resultArea.setText("A car up to ₹10 lakhs\nCash up to ₹3.5 lakhs plus gold up to ₹3 lakhs\nOther essentials: AC, Washing Machine, etc.\nApprox total = ₹22 lakhs");
            }
        }

        if (choice == 3) {
            if (range == 0) {
                resultArea.setText("A car/bike depending on land ownership\nCash up to ₹1.5 lakhs plus gold up to ₹1 lakh\nOther essentials: Washing Machine, etc.\nApprox total = ₹8 lakhs");
            } else if (range == 1) {
                resultArea.setText("A car up to ₹10 lakhs\nCash up to ₹5 lakhs plus gold up to ₹3 lakhs\nOther essentials: AC, Washing Machine, etc.\nApprox total = ₹20 lakhs");
            } else if (range == 2) {
                resultArea.setText("A car up to ₹20 lakhs\nCash up to ₹10 lakhs plus gold up to ₹6 lakhs\nOther essentials: AC, Washing Machine, etc.\nApprox total = ₹40 lakhs");
            }
        }

        if (resultArea.getText().isEmpty()) {
            resultArea.setText("Please make valid selections.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DowryCalculator::new);
    }
}
