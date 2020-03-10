import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Choice;

public class BillBook extends JFrame {
	
	double amount;
	double remain;
	double gross;
	double rate;
	double tax;
	double net;
	double diff;
	double v;

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblAmount;
	private JLabel lblRemainAmount;
	private JLabel lblDate;
	private JLabel lblFinalDate;
	private JLabel lblDiff;
	private JLabel lblGrossAmount;
	private JLabel lblRate;
	private JLabel lblTaxAmount;
	private JLabel lblNetAmount;
	private JTextField ratxt;
	private JTextField gatxt;
	private JTextField rtxt;
	private JTextField tatxt;
	private JTextField natxt;
	private JTextField dtxt;
	private JDateChooser id;
	private JDateChooser fd;
	private JButton btnCalculate;
	private JButton btnClear;
	private JTextField r1txt;
	private JLabel lblRerate;
	private Choice choice;
	private JTextField value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillBook frame = new BillBook();
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
	public BillBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 578, 440);
			panel.setLayout(null);
			panel.add(getLblAmount());
			panel.add(getLblRemainAmount());
			panel.add(getLblDate());
			panel.add(getLabel_1());
			panel.add(getLabel_1_1());
			panel.add(getLabel_1_2());
			panel.add(getLblRate());
			panel.add(getLblTaxAmount());
			panel.add(getLblNetAmount());
			panel.add(getRatxt());
			panel.add(getGatxt());
			panel.add(getRtxt());
			panel.add(getTatxt());
			panel.add(getNatxt());
			panel.add(getDtxt());
			panel.add(getId());
			panel.add(getFd());
			panel.add(getBtnCalculate());
			panel.add(getBtnClear());
			panel.add(getR1txt());
			panel.add(getLblRerate());
			panel.add(getChoice());
			panel.add(getValue());
		}
		return panel;
	}
	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount");
			lblAmount.setBounds(36, 36, 71, 26);
		}
		return lblAmount;
	}
	private JLabel getLblRemainAmount() {
		if (lblRemainAmount == null) {
			lblRemainAmount = new JLabel("Remain amount");
			lblRemainAmount.setForeground(Color.RED);
			lblRemainAmount.setBounds(36, 75, 90, 26);
		}
		return lblRemainAmount;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Initial Date");
			lblDate.setBounds(36, 120, 71, 32);
		}
		return lblDate;
	}
	private JLabel getLabel_1() {
		if (lblFinalDate == null) {
			lblFinalDate = new JLabel("Final Date");
			lblFinalDate.setBounds(36, 165, 71, 26);
		}
		return lblFinalDate;
	}
	private JLabel getLabel_1_1() {
		if (lblDiff == null) {
			lblDiff = new JLabel("Diff");
			lblDiff.setBounds(355, 137, 56, 16);
		}
		return lblDiff;
	}
	private JLabel getLabel_1_2() {
		if (lblGrossAmount == null) {
			lblGrossAmount = new JLabel("Gross Amount");
			lblGrossAmount.setBounds(36, 212, 90, 32);
		}
		return lblGrossAmount;
	}
	private JLabel getLblRate() {
		if (lblRate == null) {
			lblRate = new JLabel("Rate(%)");
			lblRate.setBounds(36, 257, 56, 16);
		}
		return lblRate;
	}
	private JLabel getLblTaxAmount() {
		if (lblTaxAmount == null) {
			lblTaxAmount = new JLabel("Tax Amount");
			lblTaxAmount.setBounds(36, 303, 71, 26);
		}
		return lblTaxAmount;
	}
	private JLabel getLblNetAmount() {
		if (lblNetAmount == null) {
			lblNetAmount = new JLabel("Net Amount");
			lblNetAmount.setBounds(36, 350, 71, 32);
		}
		return lblNetAmount;
	}
	private JTextField getRatxt() {
		if (ratxt == null) {
			ratxt = new JTextField();
			ratxt.setColumns(10);
			ratxt.setBounds(157, 77, 116, 22);
		}
		return ratxt;
	}
	private JTextField getGatxt() {
		if (gatxt == null) {
			gatxt = new JTextField();
			gatxt.setColumns(10);
			gatxt.setBounds(157, 217, 116, 22);
		}
		return gatxt;
	}
	private JTextField getRtxt() {
		if (rtxt == null) {
			rtxt = new JTextField();
			rtxt.setColumns(10);
			rtxt.setBounds(157, 254, 116, 22);
		}
		return rtxt;
	}
	private JTextField getTatxt() {
		if (tatxt == null) {
			tatxt = new JTextField();
			tatxt.setColumns(10);
			tatxt.setBounds(157, 303, 116, 22);
		}
		return tatxt;
	}
	private JTextField getNatxt() {
		if (natxt == null) {
			natxt = new JTextField();
			natxt.setColumns(10);
			natxt.setBounds(157, 355, 116, 22);
		}
		return natxt;
	}
	private JTextField getDtxt() {
		if (dtxt == null) {
			dtxt = new JTextField();
			dtxt.setColumns(10);
			dtxt.setBounds(412, 130, 116, 22);
		}
		return dtxt;
	}
	private JDateChooser getId() {
		if (id == null) {
			id = new JDateChooser();
			id.setBounds(157, 120, 116, 22);
		}
		return id;
	}
	private JDateChooser getFd() {
		if (fd == null) {
			fd = new JDateChooser();
			
			fd.setBounds(157, 165, 116, 22);
		}
		return fd;
	}
	private JButton getBtnCalculate() {
		if (btnCalculate == null) {
			btnCalculate = new JButton("Calculate");
			btnCalculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double day;
					String answer2;
					String answer3;
					
					//amount = Double.parseDouble(amtxt.getText());
					remain = Double.parseDouble(ratxt.getText());
					
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					Date d1 = null;
					Date d2 = null;
			
					try {
						d1 = format.parse(format.format(id.getDate()));
						d2 = format.parse(format.format(fd.getDate()));
						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					long diff = d2.getTime() - d1.getTime();
					if (diff < 0) {
						JOptionPane.showMessageDialog(gatxt, "Invalid Date");
					}else {
					gross = amount+remain;
					String g = Double.toString(gross);
					gatxt.setText(g);
					
					long sec = diff/1000%60;
					long min = diff/(60*1000)%60;
					long hour = diff/(60*60*1000);
					long days = hour/24;
					
					dtxt.setText(Long.toString(days));
					
					day = Double.parseDouble(dtxt.getText());
					
					
					
					if (remain == 0)
					{
						
						
					if(day <=90) {
						rate = 2.5;
					}
					else if (day>90 && day<=120) {
						rate = 2.5+5;;
					}
					else if(day>120 && day<=165) {
						rate = 2.5+5+10;
					}
					else {
						rate = 2.5+5+10+20;
					}
					
					
				
					
					
					String r = Double.toString(rate);
					tax = amount * (rate/100);
					answer2 = String.format("%.0f", tax);
					tatxt.setText(answer2);
					rtxt.setText(r);
					
					net = gross + tax;
					answer3 = String.format("%.0f", net);
					natxt.setText(answer3);
					
					}
				
				else {
					if(day <=90) {
						rate = 2.5;
					}
					else if (day>90 && day<=120) {
						rate = 5;
					}
					else if(day>120 && day<=165) {
						rate = 10;
					}
					else {
						rate = 20;
					}
					double tax1 = amount * (rate/100);

					double rate1 = 32;
					double tax2 = remain * (rate1/100);
					
					tax = tax1 + tax2;
					net = gross + tax;
					String r = Double.toString(rate);
					String r1 = Double.toString(rate1);
					rtxt.setText(r);
					r1txt.setText(r1);
					String t = Double.toString(tax);
					tatxt.setText(t);
					String n = Double.toString(net);
					natxt.setText(n);
					if(choice.getSelectedItem().equals("Car")) {
						v = 19000;
						String answer4 = String.format("%.0f", v);
						value.setText(answer4);
						
					}
					else {
						value.setText(null);
						
					}
				}
					}
					
					
					
				}
			});
			btnCalculate.setBounds(413, 253, 97, 25);
		}
		return btnCalculate;
	}
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//amtxt.setText("");
					ratxt.setText("");
					gatxt.setText("");
					rtxt.setText("");
					tatxt.setText("");
					natxt.setText("");
					dtxt.setText("");
					r1txt.setText("");
					
				}
			});
			btnClear.setBounds(412, 304, 97, 25);
		}
		return btnClear;
	}
	private JTextField getR1txt() {
		if (r1txt == null) {
			r1txt = new JTextField();
			r1txt.setBounds(412, 77, 116, 22);
			r1txt.setColumns(10);
		}
		return r1txt;
	}
	private JLabel getLblRerate() {
		if (lblRerate == null) {
			lblRerate = new JLabel("Re-Rate(%)");
			lblRerate.setForeground(Color.RED);
			lblRerate.setBounds(318, 81, 71, 14);
		}
		return lblRerate;
	}
	private Choice getChoice() {
		
			choice = new Choice();
			choice.addItem("Car");
			choice.addItem("Dozer");
			choice.addItem("Auto");
			choice.addItem("Mini");
			choice.addItem("Truck/Bus");
			choice.addItem("Bike");
			
			choice.setBounds(157, 40, 116, 22);
		
		return choice;
	}
	private JTextField getValue() {
		if (value == null) {
			value = new JTextField();
			value.setBounds(412, 38, 116, 22);
			value.setColumns(10);
		}
		return value;
	}
}
