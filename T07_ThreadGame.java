package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성
 * 
 * 컴퓨터의 가위 바우이 보는 난수를 이용하여 구하고
 * 사용자의 가위 바위 보는 showInputDiglog()메서드를 이용하여 입력받는다.
 * 
 * 입력시간은 5초로 제한하고 카운트다운을 진행한다.
 * 5초동안 입력이 없으면 게임을 진것으로 처리한다.
 * 
 * 5초안에 입력이완료되면 승패를 출력한다.
 * 
 * 결과예시)
 * ==결과==
 * 컴퓨터 : 가위
 * 나      : 바위
 * 결과   : 나가 이겼습니다.
 */
public class T07_ThreadGame {
	public static boolean inputCheck =false;
	static String  computer="";
	
	public static void main(String[] args) {
		Thread cut = new Me();
			cut.start();
			
			int num =(int) ((Math.random()*3)+1);
			
			if(num == 1) {
				computer="가위";
			}
			if(num == 2) {
				computer="바위";
			}
			if(num == 3) {
				computer="보";
			}
			
	}
}

class Me extends Thread{
	String str ="";
	@Override
	public void run() {
		do {
			str = JOptionPane.showInputDialog("가위,바위,보 중 하나를 입력하세요.");
			
		}while(!str.equals("가위") && !str.equals("바위") && !str.equals("보") );
		
		T07_ThreadGame.inputCheck =true;
		
		
	}
}

class CountDown2 extends Thread{
	@Override
	public void run() {
			for(int i =10; i>=1; i--) {
				if(T07_ThreadGame.inputCheck == true) {
					return;
				}
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("시간초과");
			System.exit(0);
	}
	
}
