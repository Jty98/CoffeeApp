package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;;

public class Jty_Main extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnHome;
	private JButton btnMenu;
	private JButton btnOrder;
	private JButton btnReview;
	private JLabel lblBar;
	private Timer timer;
	private int counter;
	
	// Table
	
	// image 배열에 넣어주기
	private ImageIcon[] imageIcons = {
	        new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/coffee광고.png")),
	        new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/mega1.jpg")),
	        new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/mega2.jpg"))
	    };
	private JLabel lblPpl;
	private JButton btnCategory;
	private JLabel lblLine;
	private JLabel lbl1;
	private JLabel lblPpl_1;
	private JLabel lblLogo;
	private JLabel lbl2;
	private JPanel Category;
	private JButton btnProfile;
	private JButton btnHelp;
	private JButton btnLogout;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jty_Main frame = new Jty_Main();
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
	public Jty_Main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
		        // JFrame이 열릴 때 수행할 작업
				//Category = new JPanel();
				Category.setVisible(false);
				//CategoryAction();    
				timer = new Timer(5000, new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent e) {
						counter++;
						int index = counter % imageIcons.length;
						ImageIcon icon = imageIcons[index];
						setLabelIcon(icon);
						
					}
				});
				timer.start();
			}
		});
		setTitle("홈화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 390, 872);							// 백그라운드 프레임 패널 사이즈
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Category.setVisible(false);
			}
		});
		contentPane.setBackground(new Color(248, 227, 182));	// 백그라운드 프레임 패널 색
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblBar());
		contentPane.add(getLblPpl());
		contentPane.add(getBtnCategory());
		contentPane.add(getLblLine());
		contentPane.add(getLbl1());
		contentPane.add(getLblPpl_1());
		contentPane.add(getLblLogo());
		contentPane.add(getLbl2());
		contentPane.add(getCategory());
	}
	
	private void setLabelIcon(ImageIcon icon) {
        Image image = icon.getImage().getScaledInstance(321, 162, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        lblPpl.setIcon(scaledImageIcon);
        panel.revalidate();
        panel.repaint();
    }
	
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(131, 77, 30));		// 하단 버튼바 패널 색상
			panel.setBounds(0, 757, 390, 87);					// 하단 버튼바 패널 위치,사이즈
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getBtnHome());
			panel.add(getBtnMenu());
			panel.add(getBtnOrder());
			panel.add(getBtnReview());
		}
		return panel;
	}
	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("");
			btnHome.setBackground(new Color(131, 77, 30));
			btnHome.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/btnHome.png")));
			btnHome.setFocusPainted(false);					// 버튼 포커스라인 없애기
			btnHome.setBorderPainted(false);
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnHome;
	}
	private JButton getBtnMenu() {
		if (btnMenu == null) {
			btnMenu = new JButton("");
			btnMenu.setBackground(new Color(131, 77, 30));
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnMenu.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/btnMenu.png")));
			btnMenu.setFocusPainted(false);
			btnMenu.setBorderPainted(false);
		}
		return btnMenu;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("");
			btnOrder.setBackground(new Color(131, 77, 30));
			btnOrder.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/btnOrder.png")));
			btnOrder.setFocusPainted(false);
			btnOrder.setBorderPainted(false);
		}
		return btnOrder;
	}
	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("");
			btnReview.setBackground(new Color(131, 77, 30));
			btnReview.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/btnReview.png")));
			btnReview.setFocusPainted(false);
			btnReview.setBorderPainted(false);
		}
		return btnReview;
	}
	
	private JLabel getLblBar() {
		if (lblBar == null) {
			lblBar = new JLabel("");
			lblBar.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/wifi.png")));
			lblBar.setBounds(303, 15, 65, 18);
		}
		return lblBar;
	}
	private JLabel getLblPpl() {
		if (lblPpl == null) {
			lblPpl = new JLabel("");
			lblPpl.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/coffee광고.png")));
			lblPpl.setBounds(35, 112, 321, 162);
		}
		return lblPpl;
	}
	private JButton getBtnCategory() {
		if (btnCategory == null) {
			btnCategory = new JButton("");
			btnCategory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					CategoryAction();
				}
			});
			btnCategory.setBackground(new Color(248, 227, 172));
			btnCategory.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/홈카테고리.png")));
			btnCategory.setBounds(331, 44, 25, 34);
		}
		return btnCategory;
	}
	private JLabel getLblLine() {
		if (lblLine == null) {
			lblLine = new JLabel("");
			lblLine.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/Home_Line.png")));
			lblLine.setBounds(73, 300, 252, 20);
		}
		return lblLine;
	}
	private JLabel getLbl1() {
		if (lbl1 == null) {
			lbl1 = new JLabel("이달의 이벤트");
			lbl1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lbl1.setForeground(new Color(131, 77, 30));
			lbl1.setBounds(35, 349, 117, 24);
		}
		return lbl1;
	}
	private JLabel getLblPpl_1() {
		if (lblPpl_1 == null) {
			lblPpl_1 = new JLabel("");
			lblPpl_1.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/이달의 이벤트.png")));
			lblPpl_1.setBounds(35, 383, 321, 180);
		}
		return lblPpl_1;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/storeLogo.png")));
			lblLogo.setBounds(133, 44, 113, 48);
		}
		return lblLogo;
	}
	private JLabel getLbl2() {
		if (lbl2 == null) {
			lbl2 = new JLabel("클릭시 이벤트창으로 넘어갑니다.");
			lbl2.setForeground(new Color(131, 77, 30));
			lbl2.setFont(new Font("맑은 고딕", Font.BOLD, 11));
			lbl2.setBounds(196, 555, 168, 24);
		}
		return lbl2;
	}
	
	private JPanel getCategory() {
		if (Category == null) {
			Category = new JPanel();
			Category.setBackground(new Color(248, 227, 182));
			Category.setBounds(178, 43, 178, 135);
			Category.setLayout(null);
			Category.add(getBtnProfile());
			Category.add(getBtnHelp());
			Category.add(getBtnLogout());
		}
		return Category;
	}
	private JButton getBtnProfile() {
		if (btnProfile == null) {
			btnProfile = new JButton("");
			btnProfile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProfileACtion();
					
				}
			});
			btnProfile.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/C_Profile.png")));
			btnProfile.setBounds(0, 0, 178, 45);
			btnProfile.setBackground(new Color(248, 227, 182));
		}
		return btnProfile;
	}
	private JButton getBtnHelp() {
		if (btnHelp == null) {
			btnHelp = new JButton("");
			btnHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HelpAction();
				}
			});
			btnHelp.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/C_Help.png")));
			btnHelp.setBounds(0, 45, 178, 45);
			btnHelp.setBackground(new Color(248, 227, 182));
		}
		return btnHelp;
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("");
			btnLogout.setIcon(new ImageIcon(Jty_Main.class.getResource("/com/javalec/image/C_Logout.png")));
			btnLogout.setBounds(0, 90, 178, 45);
			btnLogout.setBackground(new Color(248, 227, 182));
		}
		return btnLogout;
	}
	// ----- functions -----
	public void CategoryAction() {
		getContentPane().add(Category); // 패널을 프레임에 추가
		getContentPane().setComponentZOrder(Category, 0); // Category 패널을 맨 앞으로 보이게 설정
		contentPane.setVisible(true);
		Category.setVisible(true); // 패널을 보이도록 설정
 
	}
	private void ProfileACtion() {
		Jty_Profile jty_Profile = new Jty_Profile();
		jty_Profile.setVisible(true);
		dispose();
	
	}
	private void HelpAction() {
		Jty_Help helJty_Help = new Jty_Help();
		helJty_Help.setVisible(true);
		dispose();
	}
	}
