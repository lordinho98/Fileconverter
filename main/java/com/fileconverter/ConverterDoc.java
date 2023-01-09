package com.fileconverter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class ConverterDoc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterDoc frame = new ConverterDoc();
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
	public ConverterDoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 275);

		JMenuBar main = new JMenuBar();
		setJMenuBar(main);

		JMenu main1 = new JMenu("Converter para :");
		main1.setFont(new Font("Arial", Font.PLAIN, 12));
		main1.setBackground(Color.LIGHT_GRAY);
		main.add(main1);

		JMenuItem bt_converterDoc = new JMenuItem("voltar");
		
		bt_converterDoc.setFont(new Font("Arial", Font.PLAIN, 12));
		main1.add(bt_converterDoc);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel bt_titulo = new JLabel("Converter JPG para PDF");
		bt_titulo.setFont(new Font("Arial", Font.BOLD, 15));
		bt_titulo.setHorizontalAlignment(SwingConstants.CENTER);

		JButton bt_select = new JButton("Selecione um arquivo:");
		bt_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfileChooser = new JFileChooser();	
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Apenas Doc", "Doc");
				jfileChooser.setAcceptAllFileFilterUsed(false);
				jfileChooser.addChoosableFileFilter(filtro);
				int resposta = jfileChooser.showOpenDialog(null);
				if(resposta == JFileChooser.APPROVE_OPTION) {
					File arq = jfileChooser.getSelectedFile();
					JOptionPane.showInputDialog(arq.getAbsolutePath());
				}else {
					JOptionPane.showInputDialog("nenhum arquivo encontro");
				}
			}
		});
		bt_select.setBackground(Color.GRAY);

		JButton bt_converter = new JButton("Convertar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(40).addComponent(bt_titulo,
										GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(87)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(bt_converter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(bt_select, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														154, Short.MAX_VALUE))))
						.addContainerGap(54, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(52)
						.addComponent(bt_titulo, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(bt_select, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(bt_converter, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
