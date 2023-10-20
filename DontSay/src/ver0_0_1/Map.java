package ver0_0_1;

import java.awt.*;
import java.io.File;
import javax.swing.*;

//맵이 바뀌는 것을 판단하고 보여주는 코드.
//Frame.java의 JFrame에 배경 컴포넌트를 add시키는 방식으로 진행.

public class Map {
	private JPanel background;
	private String imagePath = "images/";
	private static int mapNum = 0;
	
	private String mapName[] = {
			"unusless.png",
			"holy.png"
	};
	
	//맵이 생길때마다 여기 하나씩 추가.
	private ImageIcon map[] = {
			new ImageIcon(imagePath + mapName[0]),
			new ImageIcon(imagePath + mapName[1]),
			new ImageIcon(imagePath + "yes.png"),
			new ImageIcon(imagePath + "yes.png"),
			new ImageIcon(imagePath + "yes.png")
	};
	
	Map(JFrame bg){
		for(int i = 0; i < mapName.length; i++) {
			File img = new File(imagePath + mapName[i]);
			if(!img.isFile()) {
				JOptionPane.showMessageDialog(null, mapName[i] + "가(이) 존재하지 않습니다.", "이미지 로딩 오류", 1);
			}
		}
		
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(map[mapNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        bg.setContentPane(background);
        bg.setVisible(true);
        try {
        	Thread.sleep(3000);
        }catch (InterruptedException e) {}
        nextMap(bg);
        try {
        	Thread.sleep(3000);
        }catch (InterruptedException e) {}
        previousMap(bg);
	}// Map()
	
	//다음 맵
	void nextMap(JFrame bg) {
		mapNum++;
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(map[mapNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        bg.setContentPane(background);
        bg.setVisible(true);
	}
	
	//이전 맵
	void previousMap(JFrame bg) {
		--mapNum;
		background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(map[mapNum].getImage(), 0, 0, this);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        bg.setContentPane(background);
        bg.setVisible(true);
	}
	
	int getMapNum() {
		return mapNum;
	}
}
