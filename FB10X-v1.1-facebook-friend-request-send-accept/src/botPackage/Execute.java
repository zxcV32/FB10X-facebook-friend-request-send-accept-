package botPackage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Execute extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel statusLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel;
	JTextArea textArea;
	static FirefoxDriver driver = null;
	public Execute(String osName,String botName,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Parameters", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 18, 398, 320);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(12, 29, 99, 16);
		panel.add(lblUsername);
		
		JLabel label = new JLabel("");
		label.setBounds(120, 29, 268, 16);
		panel.add(label);
		label.setText(username);
		
		JLabel lblConfirmations = new JLabel("Confirmations:");
		lblConfirmations.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmations.setBounds(12, 174, 99, 16);
		panel.add(lblConfirmations);
		
		JLabel lblWaveNumber = new JLabel("Waves Passed:");
		lblWaveNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWaveNumber.setBounds(12, 145, 99, 16);
		panel.add(lblWaveNumber);
		
		lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(120, 145, 270, 16);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setBounds(120, 174, 70, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblOutOf = new JLabel("Out of ");
		lblOutOf.setBounds(189, 174, 199, 16);
		panel.add(lblOutOf);
		lblOutOf.setText("Out of "+Integer.toString(confirmations));
		
		JLabel lblNewLabel_2 = new JLabel("Status: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(12, 203, 99, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Time: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(12, 87, 99, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(120, 87, 268, 16);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setText(rangeMin+" - "+rangeMax+" Seconds");
		
		JLabel lblNewLabel_6 = new JLabel("Wave Time: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(12, 116, 99, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(120, 116, 268, 16);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setText(waveMin+" - "+waveMax+" Minutes");
		
		statusLabel = new JLabel("");
		statusLabel.setBounds(120, 203, 268, 16);
		panel.add(statusLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Logs...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(426, 18, 394, 320);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 23, 370, 284);
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(textArea);
		
		statusLabel.setText("Stopped!");
		
		JLabel lblNewLabel_9 = new JLabel("Copyright \u00A9 2017 zxcV32 | Email: c34r534w@gmail.com");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(-8, 288, 398, 16);
		panel.add(lblNewLabel_9);
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("data"+File.separator+"logo.png"));
		} catch (IOException e) {
		}
		
		BufferedImage btcReader = null;
		try {
			btcReader = ImageIO.read(new File("data"+File.separator+"btc.png"));
		} catch (IOException e) {
		}
		
		JLabel lblBotName = new JLabel("Bot Name:");
		lblBotName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBotName.setBounds(12, 58, 99, 16);
		panel.add(lblBotName);
		
		JLabel lblBotname = new JLabel(botName);
		lblBotname.setBounds(120, 58, 268, 16);
		panel.add(lblBotname);
		
		JButton btnStartstop = new JButton("Stop");
		btnStartstop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				driver.quit();
				textArea.append("bot stopped!");
			}
		});
		btnStartstop.setBounds(130, 232, 118, 43);
		panel.add(btnStartstop);
		
		if(botName=="FB101"){
			Thread fb101=new Thread(){
				public void run(){
					FB101(osName,botName,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath);
				}
			};
			fb101.start();					
		}
			
		else if(botName=="FB102"){
			Thread fb102=new Thread(){
				public void run(){
					FB102(osName,botName,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath);
				}
			};
			fb102.start();	
		}
		
	}
	
	void FB101(String osName,String botName,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath) {

				BufferedWriter br2 = null;
				String executableLocation=null;
				statusLabel.setText("Opening new browser session...");
			System.setProperty("webdriver.firefox.bin", fpath);
			if(osName=="windows")
				executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
			else 
				executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver";
			try{ 
						System.setProperty("webdriver.gecko.driver",executableLocation);
						driver=new FirefoxDriver();
					}
			catch(IllegalStateException x){
				try {
					br2 = new BufferedWriter(new FileWriter("error_log", true));
					br2.write(">>"+x.toString()+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textArea.append(">>ERROR<<\nPossible causes:\n1) either \""+executableLocation+"\" do not exist or does not have execute permission\n2) Path of firefox is wrong!\n");
				textArea.append("FireFox Path: "+fpath);
				statusLabel.setText("firefox error");
				return;
			}
			statusLabel.setText("Logging In.");
			driver.get("https://www.facebook.com/?_rdr=p");	
			(driver.findElement(By.id("email"))).sendKeys(username);
			(driver.findElement(By.id("pass"))).sendKeys(password); 
			(driver.findElement(By.id("loginbutton"))).submit();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			int abort=0;
			long timec;int timew = 0;int i;
			  while(true){
					  i=0;					  
				  while(++i<=confirmations){ 
					  if(abort>10){
						  statusLabel.setText("Stopped...");
						  textArea.append("10 successive failed confirmation,there might be no friend requests or permanent error\nExiting the program...");
						  try {
							driver.close();
						} catch (Exception e) {
						}
						  System.exit(-99);
					  }
					  try{
						  driver.get("https://mbasic.facebook.com/friends/center/requests/");
						  timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
						  textArea.append("confirming="+i+" Wait time: "+timec/1000+"s\n");
						  statusLabel.setText("waiting for next confirmation...");
						  Thread.sleep(timec);
						  statusLabel.setText("accepting request...");
						  driver.findElement(By.xpath(".//*[@id='friends_center_main']/div[1]/div[1]/table/tbody/tr/td[2]/div[2]/a[1]")).click();
						  Thread.sleep(1500);
						  abort=0;
					  }		
				  catch(Exception e){
						try {
							br2 = new BufferedWriter(new FileWriter("error_log", true));
							br2.write(">>"+e.toString()+"\n");
							br2.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						--i;
				  ++abort;
				  textArea.append("Error:There was a problem finding friends to confirm.May be network lag,Trying again\n");
				  statusLabel.setText("Friend request not confirmed");
				  }
					  lblNewLabel_1.setText(Integer.toString(i));
				}
				  timew = (int) (Math.random()*(waveMax-waveMin)+waveMin)*60;
				  textArea.append("----------------------------------------\nWaiting for next wave to start\n");
				  for(;timew>0;--timew){
					  statusLabel.setText("Next wave starts in "+timew);
					  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				  }
				  lblNewLabel.setText(Integer.toString(Integer.parseInt(lblNewLabel.getText())+1));
			  }  	
}
	void FB102(String osName,String botName,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath) {
		BufferedWriter br2 = null;
		String executableLocation=null;
		statusLabel.setText("Opening new browser session...");
	System.setProperty("webdriver.firefox.bin", fpath);
	if(osName=="windows")
		executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
	else 
		executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver";
	try{ 
				System.setProperty("webdriver.gecko.driver",executableLocation);
				driver=new FirefoxDriver();
			}
	catch(IllegalStateException x){
		try {
			br2 = new BufferedWriter(new FileWriter("error_log", true));
			br2.write(">>"+x.toString()+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textArea.append(">>ERROR<<\nPossible causes:\n1) either \""+executableLocation+"\" do not exist or does not have execute permission\n2) Path of firefox is wrong!\n");
		textArea.append("FireFox Path: "+fpath);
		statusLabel.setText("firefox error");
		return;
	}
	statusLabel.setText("Logging In.");
	driver.get("https://www.facebook.com/?_rdr=p");	
	(driver.findElement(By.id("email"))).sendKeys(username);
	(driver.findElement(By.id("pass"))).sendKeys(password); 
	(driver.findElement(By.id("loginbutton"))).submit();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	int abort=0;
	long timec;int timew = 0;int i;
	while(true){
		i=0;
		  while(++i<=confirmations){ 
			  if(abort>10){
				  textArea.append("10 successive failed confirmation,there might be no friend requests or permanent error\nExiting the program...");
				  driver.close();
				  System.exit(-99);
			  }
			  try{
				  driver.get("https://mbasic.facebook.com/friends/center/suggestions/");
				  timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
				  textArea.append("confirming="+i+" Wait time: "+timec/1000+"s\n");
				  statusLabel.setText("waiting for next confirmation...");
				  Thread.sleep(timec);
				  statusLabel.setText("sending request...");
				  driver.findElement(By.xpath(".//*[@id='friends_center_main']/div[1]/div[1]/table/tbody/tr/td[2]/div[2]/a[1]")).click();
				  
				  if(driver.getPageSource().contains("Add Only People You Know")){
					textArea.append("\n\nWarning form facebook: Add Only People You Know\nBreaking out to wait for next wave!\n");
					break;
				  }
				  textArea.setCaretPosition(textArea.getDocument().getLength());
				  Thread.sleep(1500);
				  abort=0;
			  }		
		  catch(Exception e){
				try {
					br2 = new BufferedWriter(new FileWriter("error_log", true));
					br2.write(">>"+e.toString()+"\n");
					br2.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				--i;
		  ++abort;
		  textArea.append("Error:There was a problem finding friends to add.May be network lag,Trying again");
		  statusLabel.setText("Friend request not sent");
		  }
			  lblNewLabel_1.setText(Integer.toString(i));
		}
		  timew = (int) (Math.random()*(waveMax-waveMin)+waveMin)*60;
		  textArea.append("----------------------------------------\nWaiting for next wave to start\n");
		  for(;timew>0;--timew){
			  statusLabel.setText("Next wave starts in "+timew);
			  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  lblNewLabel.setText(Integer.toString(Integer.parseInt(lblNewLabel.getText())+1));
	}
		
	}
}
