package kr.or.ddit.basic;


public class Gambling {
	static String strRank ="";
	public static void main(String[] args) {
		GameHores[] plays =new GameHores[] {
				new GameHores("1"),
				new GameHores("2"),
				new GameHores("3"),
				new GameHores("4"),
				new GameHores("5"),
				new GameHores("6"),
				new GameHores("7"),
				new GameHores("8"),
				new GameHores("9"),
				new GameHores("10"),
				
		};
		for(int i=0; i<plays.length; i++) {
			plays[i].start();
			System.out.println();
		}
		for(GameHores gh : plays) {
			try {
				gh.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("경기 끝..");
			System.out.println("--------------------------------------------------");
			System.out.println();
			System.out.println("경기 결과");
			System.out.println("순서: " + strRank);
		}
	}
}

class GameHores extends Thread {
	private String name;
	private int cnt=1;
	
	public GameHores(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		
		for(int i =1; i<=50; i++) {
			for(int j =1; j<=50; i++) {
				if(cnt==i) {
					System.out.print(">");	
				}else {
					System.out.print("-");
			}
			}
			cnt++;
			
			try {
				
				Thread.sleep((int)(Math.random()*10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		System.out.println(name + "출력 끝...");
		Gambling.strRank += name + " ";
	}
}