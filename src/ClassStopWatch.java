import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClassStopWatch implements ActionListener{
	
	JFrame canvas = new JFrame("Stopwatch");
	JButton startButton = new JButton("Start");
	JButton stopButton = new JButton("Stop");
	JButton resetButton = new JButton("Reset");
	JLabel timeLabel = new JLabel("Time");
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String hours_string = String.format("%02d", hours);
	String minutes_string = String.format("%02d", minutes);
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime = elapsedTime+1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			
		}
		
	});
	
	ClassStopWatch(){
		
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(100,200,100,50);
		startButton.setFont(new Font("Ink Free", Font.PLAIN,20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(200,200,100,50);
		resetButton.setFont(new Font("Ink Free", Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		canvas.add(startButton);
		canvas.add(resetButton);
		canvas.add(timeLabel);
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.setSize(420,420);
		canvas.setLayout(null);
		canvas.setVisible(true);
		canvas.setResizable(false);
		canvas.setLocationRelativeTo(null);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == startButton) {
			start();
			if(started == false) {
				started = true;
				startButton.setText("Stop");
			
			}
			else {
				started = false;
				startButton.setText("Start");
				stop();
			}
		}
		else if(e.getSource() == resetButton) {
			reset();
		}
	}
	
	void start() {
		
		timer.start();
	}
	
	void stop() {
		
		timer.stop();
		
	}
	
	void reset() {
		
		timer.stop();
		timeLabel.setText("00"+":"+"00"+":"+"00");
		started = false;
		startButton.setText("Start");
	}

}
