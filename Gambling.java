package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gambling {
		static String strRank ="";
		volatile static int rank;
		public static void main(String[] args) {
			List<Horse> list = new ArrayList<>();
					
					list.add(new Horse("1번 말 "));
					list.add(new Horse("2번 말 "));
					list.add(new Horse("3번 말 "));
					list.add(new Horse("4번 말 "));
					list.add(new Horse("5번 말 "));
					list.add(new Horse("6번 말 "));
					list.add(new Horse("7번 말 "));
					list.add(new Horse("8번 말 "));
					list.add(new Horse("9번 말 "));
					list.add(new Horse("10번 말 "));
			
			for(int i=0; i<list.size(); i++) {
				list.get(i).start();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(Horse dc : list) {
				try {
					dc.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			Collections.sort(list);
			for(Horse hr : list) {
				System.out.println(hr.getRank() + "등 " +hr.getHorse());
				System.out.println();
			}
			System.out.println("경기 끝..");
		}
	}
	class Horse extends Thread implements Comparable<Horse> {
		private String horse;
		private int rank2;
		
		
		//생성자
		public Horse(String horse) {
			this.horse = horse;

		}
		
		public String getHorse() {
			return horse;
		}


		public void setHorse(String horse) {
			this.horse = horse;
		}

		public int getRank() {
			return rank2;
		}

		public void setRank(int rank) {
			this.rank2 = rank;
		}

		@Override
		public void run() {
			
			for(int i=0; i<50; i++) {
				System.out.print(horse);
				for(int j =0; j<50; j++) {
					if(i==j) {
						System.out.print(">");
					}
					System.out.print("-");
				}
				System.out.println();
				System.out.println();
				try {
					//sleep()메서드의 값을 200~500사이의 난수로 한다
					Thread.sleep((int) (Math.random()*800+200));
					}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			setRank(++Gambling.rank);
		}

		@Override
		public int compareTo(Horse o) {
			return Integer.compare(this.rank2,o.rank2);
		}
	}