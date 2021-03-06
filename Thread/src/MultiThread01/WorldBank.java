package MultiThread01;

public class WorldBank implements Runnable {
	Account acc = new Account(); // 통장
	
	@Override
	public void run() {
		// 잔액이 > 0 일 동안 반복해서 실행
		while(acc.getBalance() >0) {
			int money = (int)(Math.random() * 3 + 1) * 100; // 100원 출금
			acc.withDraw(money); // 출금 메소드 호출
			// 현재 잔액 출력
			System.out.println("잔액(" + Thread.currentThread().getName()
					           + "):" + acc.getBalance());
		
		}
	}

}
