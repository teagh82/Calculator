import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CalcDialog extends JDialog {
	private JTextField tf1 = new JTextField(10);
	private JTextField tf2 = new JTextField(10);
	private JButton addButton = new JButton("Add");
	public int result;
	
	public CalcDialog(JFrame frame, String title) {
		super(frame, title, true); // true�� ��� Ÿ���� ���鵵�� ����
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(new JLabel("�� ���� ���մϴ�."));
		add(tf1);
		add(tf2);
		add(addButton);
		setSize(150, 200);
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						int a = Integer.parseInt(tf1.getText());
						int b = Integer.parseInt(tf2.getText());
						result = a + b;
					} catch(NumberFormatException d) {
					} catch (Exception d) {}	
				
				setVisible(false); // ���̾�α׸� �ݴ´�.
			}
		});
	}
	public int getInput() { 
		if(tf1.getText().length() == 0 || tf2.getText().length() == 0) return 0;
		else return result;
	}
}

public class Calculate extends JFrame{
	private CalcDialog dialog; // ���̾�α��� ���۷���
	
	public Calculate() {
		super("���̾�α� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn  = new JButton("calculate");
		JLabel la = new JLabel("��� ��� ���");
		la.setOpaque(true); 
		la.setBackground(Color.GREEN);
		
		// ��� ���̾�α� ����
		dialog = new CalcDialog(this, "Calculation Dialog");
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true); // ��� ���̾�α� �۵� ����
				
				String text =  Integer.toString(dialog.getInput());
				la.setText(text);
			}
		});
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(btn);
		c.add(la);
		setSize(250,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Calculate();
	}
}