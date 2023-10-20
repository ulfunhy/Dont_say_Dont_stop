package ver0_0_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Move {
    private JFrame frame;
    private JLabel imageLabel;
    private ImageIcon imageIcon;
    private int x, y;
    
    public Move() {
        frame = new JFrame("움직임 구현");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        
        // 이미지 로딩 및 JLabel 초기화
        imageIcon = new ImageIcon("./images/student.png"); // 이미지 경로 설정
        imageLabel = new JLabel(imageIcon);
        
        // 초기 위치 설정
        x = 100;
        y = 100;
        imageLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        
        // 이미지 JLabel을 프레임에 추가
        frame.add(imageLabel);

        // 키보드 입력을 처리하는 KeyListener 설정
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            	// 키 입력 이벤트 - 사용하지 않음
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int step = 10; // 이동 거리 설정
                
                // 방향키를 누를 때 x, y 좌표 이동
                if (keyCode == KeyEvent.VK_LEFT) {
                    x -= step;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    x += step;
                } else if (keyCode == KeyEvent.VK_UP) {
                    y -= step;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    y += step;
                }
                imageLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            	// 키 릴리스 이벤트 - 사용하지 않음
            }
        });

        // 프레임이 키 입력을 받을 수 있도록 설정
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Move();
        });
    }
}