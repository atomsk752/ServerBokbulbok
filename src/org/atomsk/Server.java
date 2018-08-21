package org.atomsk;


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //bad code~
    public static void main(String[] args)throws Exception {
        // write your code here
        Bokbulbok finder=new Bokbulbok();
        ServerSocket serverSocket=new ServerSocket(7777);
        System.out.println(serverSocket);

        while (true){
            try{
                Socket client =serverSocket.accept();
                System.out.println(client);


                OutputStream out=client.getOutputStream();
                String fileName=finder.getName();
                if(fileName==null){break;}
                System.out.println("File Name: "+fileName);
                InputStream fin=new FileInputStream("C:\\zzz\\img\\"+fileName);

                byte[] buffer=new byte[1024*8];

                while(true){
                    int count=fin.read(buffer);

                    if(count==-1){break;}
                    out.write(buffer,0,count);



                }
                fin.close();
                out.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}