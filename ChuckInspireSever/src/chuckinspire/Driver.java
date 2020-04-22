/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuckinspire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author cshsb
 */
public class Driver {

    static ArrayList chuckList;
    static String[][] inspArr;

    public static void main(String[] args) throws IOException {
        chuckList = getChuck();

        inspArr = getInsp();

        startServer();

    }

    public static int randInt(int max, int min) {
        return ThreadLocalRandom.current().nextInt(max) + 1;
    }

    public static String[][] getInsp() throws IOException {
        Scanner insp = new Scanner(new FileReader("InspirationalQuotes.txt"));

        int numLines = 0;

        while (insp.hasNextLine()) {
            insp.nextLine();
            numLines++;
        }
        insp.close();
        Scanner scan = new Scanner(new File("InspirationalQuotes.txt"));
        String[][] arr = new String[numLines][3];
        int z = 0;
        while (scan.hasNextLine()) {
            String[] a = scan.nextLine().split(";");

            for (int i = 0; i < a.length; i++) {
                arr[z][i] = a[i];
            }
//            arr[z][0] = a[0]; // quote
//            arr[z][1] = a[1]; // author 
            z++;
        }

        scan.close();
        return arr;
    }

    public static ArrayList getChuck() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("BareChuck.txt"));
        ArrayList<String> arrList = new ArrayList<String>();

        while (br.readLine() != null) {
            String line = br.readLine();
            arrList.add(line);
        }

        br.close();

        return arrList;
    }

    public static String printChuck(int i, ArrayList al) {
        return al.get(i).toString();
    }

    public static String printInspire(int i, String[][] arr) {
        String s = arr[i][0];
        String s2 = arr[i][1];
        String str = "Quote: " + s + "\nAuthor: " + s2;
        return str;
    }

    public static void startServer() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(5555);
                    System.out.println("Waiting for client connections...");
                    while (true) {
                        Socket socket = serverSocket.accept(); // blocks code, waiting for client connection; gives back control when client arrives
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    System.out.println("Received Client connection");
                                    OutputStream outputStream = socket.getOutputStream();
                                    InputStream inputStream = socket.getInputStream(); // receive data from client.
                                    ObjectOutputStream oOutputStream = new ObjectOutputStream(outputStream);
                                    ObjectInputStream oInputStream = new ObjectInputStream(inputStream);
                                    while (true) {
                                        String clientMessage = (String) oInputStream.readObject();

                                        // chuck quote request
                                        if (clientMessage.equals("chuck")) { // requesting chatList
                                            oOutputStream.writeObject(printChuck(randInt(chuckList.size(), 0), chuckList));
                                            oOutputStream.flush(); // forces TCP to send to client (no waiting in queue).
                                        } // inspirational quote request
                                        else if (clientMessage.contains("inspire")) { // 
                                            oOutputStream.writeObject(printInspire(randInt(inspArr.length, 0), inspArr));
                                            oOutputStream.flush();
                                        } else if (clientMessage.contains("bye")) { // closing connection
                                            socket.close();
                                            break;
                                        }

                                    }
                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                        }).start();

                    }
                } catch (Exception e) {
                    System.out.println("Error message: " + e.getMessage());
                }
            }
        }).start();

    }

}
