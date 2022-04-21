package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ReceiveThread extends Thread {
    // 이클립스 단축키와 VSCode 단축키 같음
    private final Socket socket;

    // 생성자
    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 채팅에서 메세지 받는 부분 준비
            DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());

            String receiveString;
            while(true) {
                // readUTF : 상대방 메세지 수신 메소드
                receiveString = tmpbuf.readUTF();
                System.out.println("상대방 : " + receiveString);
            }
        } catch (SocketException e) {
            System.out.println("상대방 연결이 종료되었습니다.");
        } catch ( IOException e2) {
            e2.printStackTrace();
        }
    }

    
}
