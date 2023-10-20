package ver0_0_1;

import javax.swing.*;

//창만 만드는 코드(맵을 보여주는 코드는 Map.java)

public class Frame {
	private JFrame base = new JFrame();
	Frame(){
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setTitle("미림 금칙어");
		base.setSize(1000, 1000);
		base.setLayout(null);
		base.setLocationRelativeTo(null);
		base.setVisible(true);
		
		new Map(getFrame());
	}
	
	JFrame getFrame() {
		return base;
	}
}
