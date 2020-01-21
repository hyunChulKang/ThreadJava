package kr.or.ddit.basic;
/**
 * 은행의 입출금울 쓰레드로 처리하는 예제
 * 
 * 
 * @author PC-10
 *
 */
public class T16_SyncAccountTest {
	public static void main(String[] args) {
		SyncAccount sAcc = new SyncAccount();
		sAcc.setBalance(10000); // 입금처리
		
		BankThread bth1 = new BankThread(sAcc);
		BankThread bth2 = new BankThread(sAcc);
		
		bth1.start();
		bth2.start();
	}
}


//은행의 입출금을 관리하는 클래스
class  SyncAccount{
	private int balance; //전액이 저장될 변수

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금처리를 수항하는 메서드
	public synchronized void deposot(int money) {
		balance += money;
	}
	
	//출금을 처리하는 메서트(성공 : true 실패 : false 반환)
	//동기화 영역에서 호출하는 메서드도 동기화 처리를 해 주어야 한다.
	synchronized  boolean withdraw(int money) {
		if(balance >= money) { //잔액이 많을 경우...
			for(int i = 1; i <= 1000000000; i++) {}//시간때우기
			balance -= money;
			System.out.println("메서드 안어세 balance = " + getBalance());
			
			return true;
		}else {
			return false;
		}
	}
}


//은행 업무를 처리하는 쓰레드
class BankThread extends Thread {
	private SyncAccount sAcc;
	
	public BankThread(SyncAccount sAcc) {
		this.sAcc = sAcc;
	}
	
	@Override
	public void run() {
		boolean result = sAcc.withdraw(6000); //6000원 인출
		System.out.println("쓰레드 안에서 result = " + result + ", balance = " + sAcc.getBalance());
		
	}
}