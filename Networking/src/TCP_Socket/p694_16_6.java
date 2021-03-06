package TCP_Socket;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class p694_16_6 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			// 서버 소켓을 생성하여 7777번 포트와 결합.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 클라이언트로부터 응답 대기
		// 무한루프 : 데몬 형태 (계속 실행 대기하는 프로세스)
		while(true) {
			try {
				System.out.println(getTime() + "연결 요청을 기다립니다.");
				
				// 서버 소켓은 클라이언트의 연결 요청이 올 때까지 실행을 멈추고 계속 기다립니다.
				// 클라이언트의 연결 요청이 오면 클아이언트 소켓과 통신할 새로운 소켓을 생성한다.
				// 클라이언트로부터 소켓을 연결하는 부분
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "로부터 연결 요청이 들어왔습니다.");
				
				// 소켓의 출력 스트림을 얻음
				// Output : 메세지 전송을 위한 부분
				// 네트웍 패킷 전송을 위한 준비 단계
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// 원격 소켓에 데이터를 보낸다.
				// writeUTF : 네트웍 메세지를 전송 메소드(문자열 메세지)
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "데이터를 전송하였습니다.");
				
				// 스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 현재 시간을 문자열로 반환하는 함수
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}
