package com.enjoyer.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.enjoyer.icr.ChatRobot;
import com.enjoyer.util.datetime.CurrentDateTime;

/**
 * 主界面框架类
 * @author yxg
 *
 */
public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 定义聊天机器人对象实例
	 */
	private ChatRobot cr = null;
	private String currentRequest = "";
	
	protected JPanel panel = null;
	protected JTextArea txtView = null;
	protected JTextArea txtSend = null;
	protected JButton btnSend = null;
	
	private static final int width = 500;
	private static final int height = 400;
	
	/**
	 * 
	 * @param titile
	 */
	public MainFrame(String titile)
	{
		super(titile);
	}
	
	/**
	 * 初始化界面显示及其消息循环
	 */
	public void Init()
	{
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(NORMAL);
		
		int xpos = (Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2;
		int ypos = (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2;
		this.setLocation(xpos, ypos);
		
		BorderLayout layout = new BorderLayout(10,10);
		getContentPane().setLayout(layout);
		
		txtView = new JTextArea(14,35);
		JScrollPane scrollpane = new JScrollPane(txtView);
		txtView.setEditable(false);

		txtSend = new JTextArea();
		
		
		btnSend = new JButton("Send");
		//btnSend.setSize(8, 8);
		btnSend.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if((e.getSource() == btnSend) && (!txtSend.getText().equals("")) )
				{
					//JOptionPane.showMessageDialog(null, txtSend.getText(), "info", JOptionPane.INFORMATION_MESSAGE);
					sendAskContext();
					showAnswerContext();
				}
			}
		});
		
		getContentPane().add(scrollpane, BorderLayout.NORTH);
		getContentPane().add(txtSend, BorderLayout.CENTER);
		getContentPane().add(btnSend, BorderLayout.LINE_END);

		this.setVisible(true);
		
		cr = new ChatRobot();
	}
	
	/**
	 * 发送本地输入内容
	 */
	private void sendAskContext()
	{
		this.appendRecordView("我", txtSend.getText());
		this.currentRequest = txtSend.getText();
		txtSend.setText(null);
	}
	
	/**
	 * 显示对方应答内容
	 */
	private void showAnswerContext()
	{
		String response = cr.RobotChatResponse(this.currentRequest);
		this.appendRecordView("机器人：", response);
	}
	
	/**
	 * 
	 * @param record
	 */
	private void appendRecordView(String roleName, String record)
	{
		CurrentDateTime dateTime = new CurrentDateTime();
		
		txtView.append(roleName + ": \t" + dateTime.getCurrentTimeString() + "\n");
		txtView.append(record + "\n");
	}	

}
