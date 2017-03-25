package edu.ipfw.sumfun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestFrame extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 398);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton button = new JButton("0");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		getContentPane().add(button, gbc_button);
		
		JButton button_17 = new JButton("0");
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.insets = new Insets(0, 0, 5, 5);
		gbc_button_17.gridx = 2;
		gbc_button_17.gridy = 1;
		getContentPane().add(button_17, gbc_button_17);
		
		JButton button_25 = new JButton("0");
		GridBagConstraints gbc_button_25 = new GridBagConstraints();
		gbc_button_25.insets = new Insets(0, 0, 5, 5);
		gbc_button_25.gridx = 3;
		gbc_button_25.gridy = 1;
		getContentPane().add(button_25, gbc_button_25);
		
		JButton button_26 = new JButton("0");
		GridBagConstraints gbc_button_26 = new GridBagConstraints();
		gbc_button_26.insets = new Insets(0, 0, 5, 5);
		gbc_button_26.gridx = 4;
		gbc_button_26.gridy = 1;
		getContentPane().add(button_26, gbc_button_26);
		
		JButton button_38 = new JButton("0");
		GridBagConstraints gbc_button_38 = new GridBagConstraints();
		gbc_button_38.insets = new Insets(0, 0, 5, 5);
		gbc_button_38.gridx = 5;
		gbc_button_38.gridy = 1;
		getContentPane().add(button_38, gbc_button_38);
		
		JButton button_37 = new JButton("0");
		GridBagConstraints gbc_button_37 = new GridBagConstraints();
		gbc_button_37.insets = new Insets(0, 0, 5, 5);
		gbc_button_37.gridx = 6;
		gbc_button_37.gridy = 1;
		getContentPane().add(button_37, gbc_button_37);
		
		JButton button_36 = new JButton("0");
		GridBagConstraints gbc_button_36 = new GridBagConstraints();
		gbc_button_36.insets = new Insets(0, 0, 5, 5);
		gbc_button_36.gridx = 7;
		gbc_button_36.gridy = 1;
		getContentPane().add(button_36, gbc_button_36);
		
		JButton button_35 = new JButton("0");
		GridBagConstraints gbc_button_35 = new GridBagConstraints();
		gbc_button_35.insets = new Insets(0, 0, 5, 5);
		gbc_button_35.gridx = 8;
		gbc_button_35.gridy = 1;
		getContentPane().add(button_35, gbc_button_35);
		
		JButton button_34 = new JButton("0");
		GridBagConstraints gbc_button_34 = new GridBagConstraints();
		gbc_button_34.gridwidth = 2;
		gbc_button_34.anchor = GridBagConstraints.WEST;
		gbc_button_34.insets = new Insets(0, 0, 5, 5);
		gbc_button_34.gridx = 9;
		gbc_button_34.gridy = 1;
		getContentPane().add(button_34, gbc_button_34);
		
		JLabel label = new JLabel("Score:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 11;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 12;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("0");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton button_18 = new JButton("0");
		GridBagConstraints gbc_button_18 = new GridBagConstraints();
		gbc_button_18.insets = new Insets(0, 0, 5, 5);
		gbc_button_18.gridx = 2;
		gbc_button_18.gridy = 2;
		getContentPane().add(button_18, gbc_button_18);
		
		JButton button_39 = new JButton("0");
		GridBagConstraints gbc_button_39 = new GridBagConstraints();
		gbc_button_39.insets = new Insets(0, 0, 5, 5);
		gbc_button_39.gridx = 3;
		gbc_button_39.gridy = 2;
		getContentPane().add(button_39, gbc_button_39);
		
		JButton button_46 = new JButton("0");
		GridBagConstraints gbc_button_46 = new GridBagConstraints();
		gbc_button_46.insets = new Insets(0, 0, 5, 5);
		gbc_button_46.gridx = 4;
		gbc_button_46.gridy = 2;
		getContentPane().add(button_46, gbc_button_46);
		
		JButton button_53 = new JButton("0");
		GridBagConstraints gbc_button_53 = new GridBagConstraints();
		gbc_button_53.insets = new Insets(0, 0, 5, 5);
		gbc_button_53.gridx = 5;
		gbc_button_53.gridy = 2;
		getContentPane().add(button_53, gbc_button_53);
		
		JButton button_68 = new JButton("0");
		GridBagConstraints gbc_button_68 = new GridBagConstraints();
		gbc_button_68.insets = new Insets(0, 0, 5, 5);
		gbc_button_68.gridx = 6;
		gbc_button_68.gridy = 2;
		getContentPane().add(button_68, gbc_button_68);
		
		JButton button_69 = new JButton("0");
		GridBagConstraints gbc_button_69 = new GridBagConstraints();
		gbc_button_69.insets = new Insets(0, 0, 5, 5);
		gbc_button_69.gridx = 7;
		gbc_button_69.gridy = 2;
		getContentPane().add(button_69, gbc_button_69);
		
		JButton button_70 = new JButton("0");
		GridBagConstraints gbc_button_70 = new GridBagConstraints();
		gbc_button_70.insets = new Insets(0, 0, 5, 5);
		gbc_button_70.gridx = 8;
		gbc_button_70.gridy = 2;
		getContentPane().add(button_70, gbc_button_70);
		
		JButton button_33 = new JButton("0");
		GridBagConstraints gbc_button_33 = new GridBagConstraints();
		gbc_button_33.insets = new Insets(0, 0, 5, 5);
		gbc_button_33.gridx = 9;
		gbc_button_33.gridy = 2;
		getContentPane().add(button_33, gbc_button_33);
		
		JLabel lblMovesRemaining = new JLabel("Moves Remaining:");
		GridBagConstraints gbc_lblMovesRemaining = new GridBagConstraints();
		gbc_lblMovesRemaining.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovesRemaining.gridx = 11;
		gbc_lblMovesRemaining.gridy = 2;
		getContentPane().add(lblMovesRemaining, gbc_lblMovesRemaining);
		
		JButton button_1 = new JButton("0");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 3;
		getContentPane().add(button_1, gbc_button_1);
		
		JButton button_19 = new JButton("0");
		GridBagConstraints gbc_button_19 = new GridBagConstraints();
		gbc_button_19.insets = new Insets(0, 0, 5, 5);
		gbc_button_19.gridx = 2;
		gbc_button_19.gridy = 3;
		getContentPane().add(button_19, gbc_button_19);
		
		JButton button_40 = new JButton("0");
		GridBagConstraints gbc_button_40 = new GridBagConstraints();
		gbc_button_40.insets = new Insets(0, 0, 5, 5);
		gbc_button_40.gridx = 3;
		gbc_button_40.gridy = 3;
		getContentPane().add(button_40, gbc_button_40);
		
		JButton button_47 = new JButton("0");
		GridBagConstraints gbc_button_47 = new GridBagConstraints();
		gbc_button_47.insets = new Insets(0, 0, 5, 5);
		gbc_button_47.gridx = 4;
		gbc_button_47.gridy = 3;
		getContentPane().add(button_47, gbc_button_47);
		
		JButton btnNewButton_1 = new JButton("0");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 3;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton button_67 = new JButton("0");
		GridBagConstraints gbc_button_67 = new GridBagConstraints();
		gbc_button_67.insets = new Insets(0, 0, 5, 5);
		gbc_button_67.gridx = 6;
		gbc_button_67.gridy = 3;
		getContentPane().add(button_67, gbc_button_67);
		
		JButton button_71 = new JButton("0");
		GridBagConstraints gbc_button_71 = new GridBagConstraints();
		gbc_button_71.insets = new Insets(0, 0, 5, 5);
		gbc_button_71.gridx = 7;
		gbc_button_71.gridy = 3;
		getContentPane().add(button_71, gbc_button_71);
		
		JButton button_72 = new JButton("0");
		GridBagConstraints gbc_button_72 = new GridBagConstraints();
		gbc_button_72.insets = new Insets(0, 0, 5, 5);
		gbc_button_72.gridx = 8;
		gbc_button_72.gridy = 3;
		getContentPane().add(button_72, gbc_button_72);
		
		JButton button_32 = new JButton("0");
		GridBagConstraints gbc_button_32 = new GridBagConstraints();
		gbc_button_32.insets = new Insets(0, 0, 5, 5);
		gbc_button_32.gridx = 9;
		gbc_button_32.gridy = 3;
		getContentPane().add(button_32, gbc_button_32);
		
		JButton button_2 = new JButton("0");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 4;
		getContentPane().add(button_2, gbc_button_2);
		
		JButton button_20 = new JButton("0");
		GridBagConstraints gbc_button_20 = new GridBagConstraints();
		gbc_button_20.insets = new Insets(0, 0, 5, 5);
		gbc_button_20.gridx = 2;
		gbc_button_20.gridy = 4;
		getContentPane().add(button_20, gbc_button_20);
		
		JButton button_41 = new JButton("0");
		GridBagConstraints gbc_button_41 = new GridBagConstraints();
		gbc_button_41.insets = new Insets(0, 0, 5, 5);
		gbc_button_41.gridx = 3;
		gbc_button_41.gridy = 4;
		getContentPane().add(button_41, gbc_button_41);
		
		JButton button_48 = new JButton("0");
		GridBagConstraints gbc_button_48 = new GridBagConstraints();
		gbc_button_48.insets = new Insets(0, 0, 5, 5);
		gbc_button_48.gridx = 4;
		gbc_button_48.gridy = 4;
		getContentPane().add(button_48, gbc_button_48);
		
		JButton button_16 = new JButton("0");
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.insets = new Insets(0, 0, 5, 5);
		gbc_button_16.gridx = 5;
		gbc_button_16.gridy = 4;
		getContentPane().add(button_16, gbc_button_16);
		
		JButton button_66 = new JButton("0");
		GridBagConstraints gbc_button_66 = new GridBagConstraints();
		gbc_button_66.insets = new Insets(0, 0, 5, 5);
		gbc_button_66.gridx = 6;
		gbc_button_66.gridy = 4;
		getContentPane().add(button_66, gbc_button_66);
		
		JButton button_73 = new JButton("0");
		GridBagConstraints gbc_button_73 = new GridBagConstraints();
		gbc_button_73.insets = new Insets(0, 0, 5, 5);
		gbc_button_73.gridx = 7;
		gbc_button_73.gridy = 4;
		getContentPane().add(button_73, gbc_button_73);
		
		JButton button_74 = new JButton("0");
		GridBagConstraints gbc_button_74 = new GridBagConstraints();
		gbc_button_74.insets = new Insets(0, 0, 5, 5);
		gbc_button_74.gridx = 8;
		gbc_button_74.gridy = 4;
		getContentPane().add(button_74, gbc_button_74);
		
		JButton button_31 = new JButton("0");
		GridBagConstraints gbc_button_31 = new GridBagConstraints();
		gbc_button_31.insets = new Insets(0, 0, 5, 5);
		gbc_button_31.gridx = 9;
		gbc_button_31.gridy = 4;
		getContentPane().add(button_31, gbc_button_31);
		
		JButton button_3 = new JButton("0");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 1;
		gbc_button_3.gridy = 5;
		getContentPane().add(button_3, gbc_button_3);
		
		JButton button_21 = new JButton("0");
		GridBagConstraints gbc_button_21 = new GridBagConstraints();
		gbc_button_21.insets = new Insets(0, 0, 5, 5);
		gbc_button_21.gridx = 2;
		gbc_button_21.gridy = 5;
		getContentPane().add(button_21, gbc_button_21);
		
		JButton button_42 = new JButton("0");
		GridBagConstraints gbc_button_42 = new GridBagConstraints();
		gbc_button_42.insets = new Insets(0, 0, 5, 5);
		gbc_button_42.gridx = 3;
		gbc_button_42.gridy = 5;
		getContentPane().add(button_42, gbc_button_42);
		
		JButton button_49 = new JButton("0");
		GridBagConstraints gbc_button_49 = new GridBagConstraints();
		gbc_button_49.insets = new Insets(0, 0, 5, 5);
		gbc_button_49.gridx = 4;
		gbc_button_49.gridy = 5;
		getContentPane().add(button_49, gbc_button_49);
		
		JButton button_54 = new JButton("0");
		GridBagConstraints gbc_button_54 = new GridBagConstraints();
		gbc_button_54.insets = new Insets(0, 0, 5, 5);
		gbc_button_54.gridx = 5;
		gbc_button_54.gridy = 5;
		getContentPane().add(button_54, gbc_button_54);
		
		JButton button_65 = new JButton("0");
		GridBagConstraints gbc_button_65 = new GridBagConstraints();
		gbc_button_65.insets = new Insets(0, 0, 5, 5);
		gbc_button_65.gridx = 6;
		gbc_button_65.gridy = 5;
		getContentPane().add(button_65, gbc_button_65);
		
		JButton button_75 = new JButton("0");
		GridBagConstraints gbc_button_75 = new GridBagConstraints();
		gbc_button_75.insets = new Insets(0, 0, 5, 5);
		gbc_button_75.gridx = 7;
		gbc_button_75.gridy = 5;
		getContentPane().add(button_75, gbc_button_75);
		
		JButton button_76 = new JButton("0");
		GridBagConstraints gbc_button_76 = new GridBagConstraints();
		gbc_button_76.insets = new Insets(0, 0, 5, 5);
		gbc_button_76.gridx = 8;
		gbc_button_76.gridy = 5;
		getContentPane().add(button_76, gbc_button_76);
		
		JButton button_30 = new JButton("0");
		GridBagConstraints gbc_button_30 = new GridBagConstraints();
		gbc_button_30.insets = new Insets(0, 0, 5, 5);
		gbc_button_30.gridx = 9;
		gbc_button_30.gridy = 5;
		getContentPane().add(button_30, gbc_button_30);
		
		JButton button_4 = new JButton("0");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 1;
		gbc_button_4.gridy = 6;
		getContentPane().add(button_4, gbc_button_4);
		
		JButton button_22 = new JButton("0");
		GridBagConstraints gbc_button_22 = new GridBagConstraints();
		gbc_button_22.insets = new Insets(0, 0, 5, 5);
		gbc_button_22.gridx = 2;
		gbc_button_22.gridy = 6;
		getContentPane().add(button_22, gbc_button_22);
		
		JButton button_43 = new JButton("0");
		GridBagConstraints gbc_button_43 = new GridBagConstraints();
		gbc_button_43.insets = new Insets(0, 0, 5, 5);
		gbc_button_43.gridx = 3;
		gbc_button_43.gridy = 6;
		getContentPane().add(button_43, gbc_button_43);
		
		JButton button_50 = new JButton("0");
		GridBagConstraints gbc_button_50 = new GridBagConstraints();
		gbc_button_50.insets = new Insets(0, 0, 5, 5);
		gbc_button_50.gridx = 4;
		gbc_button_50.gridy = 6;
		getContentPane().add(button_50, gbc_button_50);
		
		JButton button_55 = new JButton("0");
		GridBagConstraints gbc_button_55 = new GridBagConstraints();
		gbc_button_55.insets = new Insets(0, 0, 5, 5);
		gbc_button_55.gridx = 5;
		gbc_button_55.gridy = 6;
		getContentPane().add(button_55, gbc_button_55);
		
		JButton button_64 = new JButton("0");
		GridBagConstraints gbc_button_64 = new GridBagConstraints();
		gbc_button_64.insets = new Insets(0, 0, 5, 5);
		gbc_button_64.gridx = 6;
		gbc_button_64.gridy = 6;
		getContentPane().add(button_64, gbc_button_64);
		
		JButton button_77 = new JButton("0");
		GridBagConstraints gbc_button_77 = new GridBagConstraints();
		gbc_button_77.insets = new Insets(0, 0, 5, 5);
		gbc_button_77.gridx = 7;
		gbc_button_77.gridy = 6;
		getContentPane().add(button_77, gbc_button_77);
		
		JButton button_78 = new JButton("0");
		GridBagConstraints gbc_button_78 = new GridBagConstraints();
		gbc_button_78.insets = new Insets(0, 0, 5, 5);
		gbc_button_78.gridx = 8;
		gbc_button_78.gridy = 6;
		getContentPane().add(button_78, gbc_button_78);
		
		JButton button_29 = new JButton("0");
		GridBagConstraints gbc_button_29 = new GridBagConstraints();
		gbc_button_29.insets = new Insets(0, 0, 5, 5);
		gbc_button_29.gridx = 9;
		gbc_button_29.gridy = 6;
		getContentPane().add(button_29, gbc_button_29);
		
		JButton button_5 = new JButton("0");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 1;
		gbc_button_5.gridy = 7;
		getContentPane().add(button_5, gbc_button_5);
		
		JButton button_23 = new JButton("0");
		GridBagConstraints gbc_button_23 = new GridBagConstraints();
		gbc_button_23.insets = new Insets(0, 0, 5, 5);
		gbc_button_23.gridx = 2;
		gbc_button_23.gridy = 7;
		getContentPane().add(button_23, gbc_button_23);
		
		JButton button_44 = new JButton("0");
		GridBagConstraints gbc_button_44 = new GridBagConstraints();
		gbc_button_44.insets = new Insets(0, 0, 5, 5);
		gbc_button_44.gridx = 3;
		gbc_button_44.gridy = 7;
		getContentPane().add(button_44, gbc_button_44);
		
		JButton button_51 = new JButton("0");
		GridBagConstraints gbc_button_51 = new GridBagConstraints();
		gbc_button_51.insets = new Insets(0, 0, 5, 5);
		gbc_button_51.gridx = 4;
		gbc_button_51.gridy = 7;
		getContentPane().add(button_51, gbc_button_51);
		
		JButton button_56 = new JButton("0");
		GridBagConstraints gbc_button_56 = new GridBagConstraints();
		gbc_button_56.insets = new Insets(0, 0, 5, 5);
		gbc_button_56.gridx = 5;
		gbc_button_56.gridy = 7;
		getContentPane().add(button_56, gbc_button_56);
		
		JButton button_63 = new JButton("0");
		GridBagConstraints gbc_button_63 = new GridBagConstraints();
		gbc_button_63.insets = new Insets(0, 0, 5, 5);
		gbc_button_63.gridx = 6;
		gbc_button_63.gridy = 7;
		getContentPane().add(button_63, gbc_button_63);
		
		JButton button_62 = new JButton("0");
		GridBagConstraints gbc_button_62 = new GridBagConstraints();
		gbc_button_62.insets = new Insets(0, 0, 5, 5);
		gbc_button_62.gridx = 7;
		gbc_button_62.gridy = 7;
		getContentPane().add(button_62, gbc_button_62);
		
		JButton button_61 = new JButton("0");
		GridBagConstraints gbc_button_61 = new GridBagConstraints();
		gbc_button_61.insets = new Insets(0, 0, 5, 5);
		gbc_button_61.gridx = 8;
		gbc_button_61.gridy = 7;
		getContentPane().add(button_61, gbc_button_61);
		
		JButton button_28 = new JButton("0");
		GridBagConstraints gbc_button_28 = new GridBagConstraints();
		gbc_button_28.insets = new Insets(0, 0, 5, 5);
		gbc_button_28.gridx = 9;
		gbc_button_28.gridy = 7;
		getContentPane().add(button_28, gbc_button_28);
		
		JButton button_79 = new JButton("");
		GridBagConstraints gbc_button_79 = new GridBagConstraints();
		gbc_button_79.insets = new Insets(0, 0, 5, 5);
		gbc_button_79.gridx = 11;
		gbc_button_79.gridy = 7;
		getContentPane().add(button_79, gbc_button_79);
		
		JButton button_6 = new JButton("0");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 1;
		gbc_button_6.gridy = 8;
		getContentPane().add(button_6, gbc_button_6);
		
		JButton button_24 = new JButton("0");
		GridBagConstraints gbc_button_24 = new GridBagConstraints();
		gbc_button_24.insets = new Insets(0, 0, 5, 5);
		gbc_button_24.gridx = 2;
		gbc_button_24.gridy = 8;
		getContentPane().add(button_24, gbc_button_24);
		
		JButton button_45 = new JButton("0");
		GridBagConstraints gbc_button_45 = new GridBagConstraints();
		gbc_button_45.insets = new Insets(0, 0, 5, 5);
		gbc_button_45.gridx = 3;
		gbc_button_45.gridy = 8;
		getContentPane().add(button_45, gbc_button_45);
		
		JButton button_52 = new JButton("0");
		GridBagConstraints gbc_button_52 = new GridBagConstraints();
		gbc_button_52.insets = new Insets(0, 0, 5, 5);
		gbc_button_52.gridx = 4;
		gbc_button_52.gridy = 8;
		getContentPane().add(button_52, gbc_button_52);
		
		JButton button_57 = new JButton("0");
		GridBagConstraints gbc_button_57 = new GridBagConstraints();
		gbc_button_57.insets = new Insets(0, 0, 5, 5);
		gbc_button_57.gridx = 5;
		gbc_button_57.gridy = 8;
		getContentPane().add(button_57, gbc_button_57);
		
		JButton button_58 = new JButton("0");
		GridBagConstraints gbc_button_58 = new GridBagConstraints();
		gbc_button_58.insets = new Insets(0, 0, 5, 5);
		gbc_button_58.gridx = 6;
		gbc_button_58.gridy = 8;
		getContentPane().add(button_58, gbc_button_58);
		
		JButton button_59 = new JButton("0");
		GridBagConstraints gbc_button_59 = new GridBagConstraints();
		gbc_button_59.insets = new Insets(0, 0, 5, 5);
		gbc_button_59.gridx = 7;
		gbc_button_59.gridy = 8;
		getContentPane().add(button_59, gbc_button_59);
		
		JButton button_60 = new JButton("0");
		GridBagConstraints gbc_button_60 = new GridBagConstraints();
		gbc_button_60.insets = new Insets(0, 0, 5, 5);
		gbc_button_60.gridx = 8;
		gbc_button_60.gridy = 8;
		getContentPane().add(button_60, gbc_button_60);
		
		JButton button_27 = new JButton("0");
		GridBagConstraints gbc_button_27 = new GridBagConstraints();
		gbc_button_27.insets = new Insets(0, 0, 5, 5);
		gbc_button_27.gridx = 9;
		gbc_button_27.gridy = 8;
		getContentPane().add(button_27, gbc_button_27);
		
		JButton button_7 = new JButton("0");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 0, 5);
		gbc_button_7.gridx = 1;
		gbc_button_7.gridy = 9;
		getContentPane().add(button_7, gbc_button_7);
		
		JButton button_8 = new JButton("0");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 0, 5);
		gbc_button_8.gridx = 2;
		gbc_button_8.gridy = 9;
		getContentPane().add(button_8, gbc_button_8);
		
		JButton button_9 = new JButton("0");
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 0, 5);
		gbc_button_9.gridx = 3;
		gbc_button_9.gridy = 9;
		getContentPane().add(button_9, gbc_button_9);
		
		JButton button_10 = new JButton("0");
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 0, 5);
		gbc_button_10.gridx = 4;
		gbc_button_10.gridy = 9;
		getContentPane().add(button_10, gbc_button_10);
		
		JButton button_11 = new JButton("0");
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 0, 5);
		gbc_button_11.gridx = 5;
		gbc_button_11.gridy = 9;
		getContentPane().add(button_11, gbc_button_11);
		
		JButton button_12 = new JButton("0");
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 0, 5);
		gbc_button_12.gridx = 6;
		gbc_button_12.gridy = 9;
		getContentPane().add(button_12, gbc_button_12);
		
		JButton button_13 = new JButton("0");
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.insets = new Insets(0, 0, 0, 5);
		gbc_button_13.gridx = 7;
		gbc_button_13.gridy = 9;
		getContentPane().add(button_13, gbc_button_13);
		
		JButton button_14 = new JButton("0");
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.insets = new Insets(0, 0, 0, 5);
		gbc_button_14.gridx = 8;
		gbc_button_14.gridy = 9;
		getContentPane().add(button_14, gbc_button_14);
		
		JButton button_15 = new JButton("0");
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.insets = new Insets(0, 0, 0, 5);
		gbc_button_15.gridx = 9;
		gbc_button_15.gridy = 9;
		getContentPane().add(button_15, gbc_button_15);
	}

}
