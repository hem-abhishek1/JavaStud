import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class TC extends JFrame {
	double wage;
	double weeklyhours;
	double gross;
	double tax;
	double net;
	double Rate;
	
	
	

	private JPanel contentPane;
	private JTextField jtxt1;
	private JTextField jtxt2;
	private JTextField jtxt3;
	private JTextField jtxt4;
	private JTextField jtxt5;
	private JTextField jtxt7;
	private JTextField jtxt8;
	private JTextField textField;
	private JTextField jtxt6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TC frame = new TC();
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
	public TC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHourlyWage = new JLabel("Hourly Wage");
		lblHourlyWage.setBounds(34, 40, 92, 32);
		contentPane.add(lblHourlyWage);
		
		JLabel lblWeeklyHours = new JLabel("Weekly Hours");
		lblWeeklyHours.setBounds(34, 99, 92, 32);
		contentPane.add(lblWeeklyHours);
		
		JLabel lblGrossEarning = new JLabel("Gross Earning");
		lblGrossEarning.setBounds(34, 252, 92, 32);
		contentPane.add(lblGrossEarning);
		
		JLabel lblFwt = new JLabel("FWT");
		lblFwt.setBounds(34, 320, 92, 32);
		contentPane.add(lblFwt);
		
		JLabel lblNetEarning = new JLabel("Net Earning");
		lblNetEarning.setBounds(34, 396, 92, 32);
		contentPane.add(lblNetEarning);
		
		jtxt1 = new JTextField();
		jtxt1.setBounds(207, 50, 116, 22);
		contentPane.add(jtxt1);
		jtxt1.setColumns(10);
		
		jtxt2 = new JTextField();
		jtxt2.setColumns(10);
		jtxt2.setBounds(207, 104, 116, 22);
		contentPane.add(jtxt2);
		
		jtxt3 = new JTextField();
		jtxt3.setColumns(10);
		jtxt3.setBounds(207, 257, 116, 22);
		contentPane.add(jtxt3);
		
		jtxt4 = new JTextField();
		jtxt4.setColumns(10);
		jtxt4.setBounds(207, 325, 116, 22);
		contentPane.add(jtxt4);
		
		jtxt5 = new JTextField();
		jtxt5.setColumns(10);
		jtxt5.setBounds(207, 401, 116, 22);
		contentPane.add(jtxt5);
		JLabel lblDate = new JLabel("Date 1");
		lblDate.setBounds(34, 154, 56, 16);
		contentPane.add(lblDate);
		
		JLabel lblDate_1 = new JLabel("Date 2");
		lblDate_1.setBounds(34, 195, 56, 16);
		contentPane.add(lblDate_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(207, 148, 116, 22);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(207, 189, 116, 22);
		contentPane.add(dateChooser_1);
		
		jtxt6 = new JTextField();
		jtxt6.setBounds(338, 174, 116, 22);
		contentPane.add(jtxt6);
		jtxt6.setColumns(10);
		
		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer = null;
				String answer1;
				String answer2;
				String answer3;
				double day;
				
				
				
				wage= Double.parseDouble(jtxt1.getText());
				weeklyhours= Double.parseDouble(jtxt2.getText());
				gross= wage * weeklyhours;
				answer1 = String.format("%.0f", gross);
				jtxt3.setText(answer1);
				
				tax = gross * Rate;
				answer2 = String.format("%.0f", tax);
				jtxt4.setText(answer2);
				
				net = gross - tax;
				answer3 = String.format("%.0f", net);
				jtxt5.setText(answer3);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date d1 = null;
				Date d2 = null;
		
				try {
					d1 = format.parse(format.format(dateChooser.getDate()));
					d2 = format.parse(format.format(dateChooser_1.getDate()));
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				long diff = d2.getTime() - d1.getTime();
				
				long sec = diff/1000%60;
				long min = diff/(60*1000)%60;
				long hour = diff/(60*60*1000);
				long days = hour/24;
				
				jtxt6.setText(Long.toString(days));
				
				day = Double.parseDouble(jtxt6.getText());
				
				if(day ==90) {
					Rate = 0.025;
					tax = wage * Rate;
					answer2 = String.format("%.0f", tax);
					jtxt4.setText(answer2);
					
					net = wage + tax;
					answer3 = String.format("%.0f", net);
					jtxt5.setText(answer3);
					
				}
		
				
				
				
			
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnCalculate.setBounds(377, 284, 97, 25);
		contentPane.add(btnCalculate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxt1.setText("");
				jtxt2.setText("");
				jtxt3.setText("");
				jtxt4.setText("");
				jtxt5.setText("");
				
				
			}
		});
		btnClear.setBounds(377, 361, 97, 25);
		contentPane.add(btnClear);
		
		textField = new JTextField();
		textField.setBounds(338, 174, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
	}
}
