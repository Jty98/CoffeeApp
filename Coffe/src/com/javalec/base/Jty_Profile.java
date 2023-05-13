package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Jty_Dao_Profile;
import com.javalec.dto.Jty_Dto_Profile;
import com.javalec.util.ShareVar;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Jty_Profile extends JFrame {

    private JPanel contentPane;
    private JButton btnBackAction;
    
    private Image backgroundImage = Toolkit.getDefaultToolkit().getImage(Jty_Profile.class.getResource("/com/javalec/image/mypagebackground.png"));
    private JLabel lblUserDelete;
    private JLabel lblLogo;
    private JTextField tfName;
    private JTextField tfUserid;
    private JTextField tfPassword;
    private JTextField tfConfirmPassword;
    private JTextField tfPhone;
    private JTextField tfEmail;
    private JTextField tfAddress;
    private JPasswordField pfPaymentPassword;
    private JButton btnCheck;
    private JButton btnPayUpdate;
    private JLabel lblInsertdate;
    private JButton btnAllUpdate;
    private JButton btnCuponBox;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private String cid; // 전역 변수로 cid 선언
    private JLabel lblInsertdate_1;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Jty_Profile frame = new Jty_Profile();
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
    public Jty_Profile() {
    	addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowOpened(WindowEvent e) {
    			profileOpend(cid);
    		}
    	});
    	setTitle("내정보");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 390, 872);
        
        // 수정된 부분: JPanel을 상속한 서브클래스로 변경
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        contentPane.setBackground(new Color(248, 227, 182));    // 백그라운드 프레임 패널 색
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(getBtnBackAction());
        contentPane.add(getLblUserDelete());
        contentPane.add(getLblLogo());
        contentPane.add(getTextField_1());
        contentPane.add(getTfUserid());
        contentPane.add(getTextField_1_1());
        contentPane.add(getTfConfirmPassword());
        contentPane.add(getTfPhone());
        contentPane.add(getTfEmail());
        contentPane.add(getTfAddress());
        contentPane.add(getPfPaymentPassword());
        contentPane.add(getBtnCheck());
        contentPane.add(getBtnPayUpdate());
        contentPane.add(getLblInsertdate());
        contentPane.add(getBtnAllUpdate());
        contentPane.add(getBtnCuponBox());
        contentPane.add(getLblNewLabel());
        contentPane.add(getLblNewLabel_1());
        contentPane.add(getLblInsertdate_1());
    }
    
    private JButton getBtnBackAction() {
        if (btnBackAction == null) {
            btnBackAction = new JButton("");
            btnBackAction.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		backAction();
            	}
            });
            btnBackAction.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/BackIcon.png")));
            btnBackAction.setBackground(new Color(248, 227, 172));
            btnBackAction.setBounds(31, 54, 18, 24);
        }
        return btnBackAction;
    }
	private JLabel getLblUserDelete() {
		if (lblUserDelete == null) {
			lblUserDelete = new JLabel("회원탈퇴");
			lblUserDelete.setForeground(new Color(131, 77, 30));
			lblUserDelete.setHorizontalAlignment(SwingConstants.CENTER);
			lblUserDelete.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblUserDelete.setBackground(new Color(252, 242, 217));
			lblUserDelete.setBounds(169, 745, 50, 21);
		}
		return lblUserDelete;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/storeLogo.png")));
			lblLogo.setBounds(133, 44, 113, 48);
		}
		return lblLogo;
	}
	private JTextField getTextField_1() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setForeground(new Color(131, 77, 30));
			tfName.setBackground(new Color(252, 242, 217));
			tfName.setBounds(178, 225, 143, 21);
			tfName.setColumns(10);
			tfName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return tfName;
	}
	private JTextField getTfUserid() {
		if (tfUserid == null) {
			tfUserid = new JTextField();
			tfUserid.setForeground(new Color(131, 77, 30));
			tfUserid.setColumns(10);
			tfUserid.setBackground(new Color(252, 242, 217));
			tfUserid.setBounds(178, 271, 143, 21);
			tfUserid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return tfUserid;
	}
	private JTextField getTextField_1_1() {
		if (tfPassword == null) {
			tfPassword = new JTextField();
			tfPassword.setForeground(new Color(131, 77, 30));
			tfPassword.setColumns(10);
			tfPassword.setBackground(new Color(252, 242, 217));
			tfPassword.setBounds(178, 317, 143, 21);
			tfPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return tfPassword;
	}
	private JTextField getTfConfirmPassword() {
		if (tfConfirmPassword == null) {
			tfConfirmPassword = new JTextField();
			tfConfirmPassword.setForeground(new Color(131, 77, 30));
			tfConfirmPassword.setColumns(10);
			tfConfirmPassword.setBackground(new Color(252, 242, 217));
			tfConfirmPassword.setBounds(178, 363, 143, 21);
			tfConfirmPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return tfConfirmPassword;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setForeground(new Color(131, 77, 30));
			tfPhone.setColumns(10);
			tfPhone.setBackground(new Color(252, 242, 217));
			tfPhone.setBounds(178, 407, 143, 21);
			tfPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return tfPhone;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setForeground(new Color(131, 77, 30));
			tfEmail.setColumns(10);
			tfEmail.setBackground(new Color(252, 242, 217));
			tfEmail.setBounds(178, 453, 143, 21);
			tfEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return tfEmail;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setForeground(new Color(131, 77, 30));
			tfAddress.setColumns(10);
			tfAddress.setBackground(new Color(252, 242, 217));
			tfAddress.setBounds(178, 499, 143, 21);
			tfAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return tfAddress;
	}
	private JPasswordField getPfPaymentPassword() {
		if (pfPaymentPassword == null) {
			pfPaymentPassword = new JPasswordField();
			pfPaymentPassword.setForeground(new Color(131, 77, 30));
			pfPaymentPassword.setEditable(false);
			pfPaymentPassword.setBackground(new Color(252, 242, 217));
			pfPaymentPassword.setBounds(178, 544, 143, 21);
			pfPaymentPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return pfPaymentPassword;
	}
	private JButton getBtnCheck() {
		if (btnCheck == null) {
			btnCheck = new JButton("");
			btnCheck.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/중복체크버튼.png")));
			btnCheck.setBackground(new Color(252, 242, 217));
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCheck.setBounds(260, 295, 60, 15);
		}
		return btnCheck;
	}
	private JButton getBtnPayUpdate() {
		if (btnPayUpdate == null) {
			btnPayUpdate = new JButton("");
			btnPayUpdate.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/결제비번변경버튼.png")));
			btnPayUpdate.setBackground(new Color(252, 242, 217));
			btnPayUpdate.setBounds(260, 567, 60, 15);
		}
		return btnPayUpdate;
	}
	private JLabel getLblInsertdate() {
		if (lblInsertdate == null) {
			lblInsertdate = new JLabel("");
			lblInsertdate.setHorizontalAlignment(SwingConstants.CENTER);
			lblInsertdate.setForeground(new Color(131, 77, 30));
			lblInsertdate.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblInsertdate.setBackground(new Color(252, 242, 217));
			lblInsertdate.setBounds(179, 776, 77, 21);
		}
		return lblInsertdate;
	}
	private JButton getBtnAllUpdate() {
		if (btnAllUpdate == null) {
			btnAllUpdate = new JButton("");
			btnAllUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					profileUpdate();
				}
			});
			btnAllUpdate.setBackground(new Color(248, 227, 182));
			btnAllUpdate.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/수정버튼.png")));
			btnAllUpdate.setBounds(274, 607, 76, 33);
		}
		return btnAllUpdate;
	}
	private JButton getBtnCuponBox() {
		if (btnCuponBox == null) {
			btnCuponBox = new JButton("");
			btnCuponBox.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/쿠폰함버튼.png")));
			btnCuponBox.setBackground(new Color(248, 227, 182));
			btnCuponBox.setBounds(43, 607, 76, 41);
		}
		return btnCuponBox;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("마이페이지");
			lblNewLabel.setForeground(new Color(131, 77, 30));
			lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			lblNewLabel.setBounds(59, 196, 78, 19);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Jty_Profile.class.getResource("/com/javalec/image/얼굴.png")));
			lblNewLabel_1.setBackground(new Color(252, 242, 217));
			lblNewLabel_1.setBounds(163, 129, 64, 64);
		}
		return lblNewLabel_1;
	}
	
	private JLabel getLblInsertdate_1() {
		if (lblInsertdate_1 == null) {
			lblInsertdate_1 = new JLabel("가입일 : ");
			lblInsertdate_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblInsertdate_1.setForeground(new Color(131, 77, 30));
			lblInsertdate_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lblInsertdate_1.setBackground(new Color(252, 242, 217));
			lblInsertdate_1.setBounds(117, 776, 50, 21);
		}
		return lblInsertdate_1;
	}
	
	// ----- function -----
	// cid 받는걸로 하기
	private void profileOpend(String cid) {
	    Jty_Dao_Profile jty_Dao_Profile = new Jty_Dao_Profile();
	    Jty_Dto_Profile jty_Dto_Profile = jty_Dao_Profile.profileOpend(cid);
	    
		tfName.setText(jty_Dto_Profile.getCname());
		tfUserid.setText(jty_Dto_Profile.getCid());
		tfPassword.setText(jty_Dto_Profile.getCpassword());
		tfConfirmPassword.setText(jty_Dto_Profile.getCpassword());		
		tfPhone.setText(jty_Dto_Profile.getCphone());
		tfEmail.setText(jty_Dto_Profile.getCemail());
		tfAddress.setText(jty_Dto_Profile.getCaddress());
		pfPaymentPassword.setText(jty_Dto_Profile.getCpayPassword());
		
	}
	//String id =ShareVar.testid;
	
	
	private void profileUpdate() {
		Jty_Dao_Profile Jty_dao_Profile = new Jty_Dao_Profile();
		
		String name = tfName.getText();
		String id = tfUserid.getText();
		String password = tfPassword.getText();
		String phone = tfPhone.getText();
		String email = tfEmail.getText();
		String address = tfAddress.getText();
		String payPassword = pfPaymentPassword.getText();
		
		
		Jty_Dao_Profile jty_Dao_profile = new Jty_Dao_Profile(name, id, password, phone, email, address, payPassword);
		boolean result = jty_Dao_profile.profileUpdate();
		
		if (result) {
			JOptionPane.showMessageDialog(this, "정보 수정\n"+tfName.getText()+ "님의 정보가 수정었습니다.", "주소록 정보",JOptionPane.INFORMATION_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}else {
			JOptionPane.showMessageDialog(this, "정보 수정\n"+ "수정 중 문제가 발생했습니다.", "주소록 정보",JOptionPane.ERROR_MESSAGE); //this 는 active 창에 띄우고 null은 화면아무데나 중앙에 띄워라
		}
	}
	
	
	
	
	
	
	private void backAction() {
		Jty_Main jty_Main = new Jty_Main();
		jty_Main.setVisible(true);
		dispose();
	}
	
	
	
	
}
