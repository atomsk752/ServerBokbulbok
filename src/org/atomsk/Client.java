package org.atomsk;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {


    //bad code
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("127.0.0.1", 7777);
        System.out.println(socket);

        InputStream in = socket.getInputStream();
        OutputStream out = new FileOutputStream("C:\\zzz\\sample.jpg");

        byte[] buffer = new byte[1024*8];



        while (true) {

            int count = in.read(buffer); //why int?? -1이 안나오게 보장함. -1은 더이상 값이 안나올때
            System.out.println("count: "+count);
            if (count == -1) {
                break;
            }
            out.write(buffer, 0, count);
            System.out.println(count);
        }


        in.close();
        out.close();
        socket.close();

    }




}


