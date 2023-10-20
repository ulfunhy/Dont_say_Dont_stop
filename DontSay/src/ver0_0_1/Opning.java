package ver0_0_1;

import java.awt.*;
import java.io.File;
import javax.swing.*;

//맵이 바뀌는 것을 판단하고 보여주는 코드.
//Frame.java의 JFrame에 배경 컴포넌트를 add시키는 방식으로 진행.

public class Opning {
	private JPanel background;
	private String imagePath = "images/";
	private int storyNum = 0;
	
	private String sceneName[] = {
			"unusless.png",
			"holy.png"
	};
	
	//맵이 생길때마다 여기 하나씩 추가.
	private ImageIcon story[] = {
			new ImageIcon(imagePath + sceneName[0]),
			new ImageIcon(imagePath + sceneName[1]),
			new ImageIcon(imagePath + "yes.png"),
			new ImageIcon(imagePath + "yes.png"),
			new ImageIcon(imagePath + "yes.png")
	};
	
	Opning(JFrame bg){
		for(int i = 0; i < sceneName.length; i++) {
			File img = new File(imagePath + sceneName[i]);
			if(!img.isFile()) {
				JOptionPane.showMessageDialog(null, sceneName[i] + "가(이) 존재하지 않습니다.", "이미지 로딩 오류", 1);
			}
		}
		
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(story[storyNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        bg.setContentPane(background);
        bg.setVisible(true);
        try {
        	//쓰레드를 오래 멈추는 것은 좀 위험하다. 다른 방법을 찾아보자.
        	Thread.sleep(3000);
        	nextMap(bg);
        }catch (InterruptedException e) {}
	}// Map()
	
	//다음 맵
	void nextMap(JFrame bg) {
		storyNum++;
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(story[storyNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        bg.setContentPane(background);
        bg.setVisible(true);
	}
	
	//이전 맵
	void previousMap(JFrame bg) {
		storyNum--;
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(story[storyNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        bg.setContentPane(background);
        bg.setVisible(true);
	}
	
}
