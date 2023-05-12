package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jty_Help extends JFrame {
	
	
	
	

	private JPanel contentPane;
	private Image backgroundImage = Toolkit.getDefaultToolkit().getImage(Jty_Profile.class.getResource("/com/javalec/image/helpbackgorund.png"));
	private JLabel lblLogo;
	private JButton btnBackAction;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jty_Help frame = new Jty_Help();
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
	public Jty_Help() {
	    setTitle("매장정보");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 390, 872);

	    contentPane = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    // contentPane.setBackground(new Color(248, 227, 182)); // 백그라운드 프레임 패널 색

	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    contentPane.add(getLblLogo());
	    contentPane.add(getBtnBackAction());
	    contentPane.add(getLblNewLabel());
	    contentPane.add(getLblNewLabel_1());
	    contentPane.add(getLblNewLabel_2());
	    contentPane.add(getLblNewLabel_3());
	    contentPane.add(getLblNewLabel_4());
	    contentPane.add(getLblNewLabel_4_1());
	    contentPane.add(getLblNewLabel_5());
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(Jty_Help.class.getResource("/com/javalec/image/storeLogo.png")));
			lblLogo.setBounds(133, 44, 113, 48);
		}
		return lblLogo;
	}
	private JButton getBtnBackAction() {
		if (btnBackAction == null) {
			btnBackAction = new JButton("");
			btnBackAction.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backAction();
				}
			});
			btnBackAction.setIcon(new ImageIcon(Jty_Help.class.getResource("/com/javalec/image/BackIcon.png")));
			btnBackAction.setBackground(new Color(248, 227, 172));
			btnBackAction.setBounds(31, 54, 18, 24);
		}
		return btnBackAction;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("주소");
			lblNewLabel.setForeground(new Color(131, 77, 30));
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel.setBackground(new Color(248, 227, 182));
			lblNewLabel.setBounds(158, 436, 195, 20);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("전화번호");
			lblNewLabel_1.setForeground(new Color(131, 77, 30));
			lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_1.setBackground(new Color(248, 227, 182));
			lblNewLabel_1.setBounds(158, 480, 195, 20);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("오픈시간");
			lblNewLabel_2.setForeground(new Color(131, 77, 30));
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_2.setBackground(new Color(248, 227, 182));
			lblNewLabel_2.setBounds(158, 526, 195, 20);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("마감시간");
			lblNewLabel_3.setForeground(new Color(131, 77, 30));
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_3.setBackground(new Color(248, 227, 182));
			lblNewLabel_3.setBounds(158, 573, 195, 20);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("상호명");
			lblNewLabel_4.setForeground(new Color(131, 77, 30));
			lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_4.setBackground(new Color(248, 227, 182));
			lblNewLabel_4.setBounds(158, 620, 195, 20);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("사업자등록번호");
			lblNewLabel_4_1.setForeground(new Color(131, 77, 30));
			lblNewLabel_4_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblNewLabel_4_1.setBackground(new Color(248, 227, 182));
			lblNewLabel_4_1.setBounds(158, 666, 195, 20);
		}
		return lblNewLabel_4_1;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("매장정보");
			lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblNewLabel_5.setForeground(new Color(131, 77, 30));
			lblNewLabel_5.setBounds(31, 108, 80, 36);
		}
		return lblNewLabel_5;
	}
	// ---- functions -----
	private void backAction(){
		Jty_Main jty_Main = new Jty_Main();
		jty_Main.setVisible(true);
		dispose();
		
	}
	
	
	
}
