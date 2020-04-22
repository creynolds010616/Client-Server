///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package chuckinspire;
//
//import java.net.*;
//import java.io.*;
//
///**
// *
// * @author cshsb
// */
//public class ChuckInspire {
//    
//    private String choice;
//    private String chuckQuote;
//    private String jsonStr;
//    
//    public final String strRandomChuck = "https://api.chucknorris.io/jokes/random";
//    //public final String strRandomChuck = "http://api.icndb.com/jokes/random";
//    //public final String strRandomChuck = "https://chucknorrisfacts.net/random-fact";
//    public ChuckInspire(){
//        choice = "";
//        chuckQuote = "";
//        jsonStr = "";
//    }
////    public void setChoice(String choice){
////        this.choice = choice;
////    }
////    public String getChoice(){ return choice; }
////    
////    public void setChuckQuote(String chuckQuote){
////        this.chuckQuote = chuckQuote;
////    }
////    public String getChuckQuote(){return chuckQuote;}
//       
//    
//    public static void main(String[] args) {
//        ChuckInspire chuck = new ChuckInspire();
//        
//        // test
//        chuck.apiChuck();
//        
//        // uncomment below
//        //chuck.startServer();
//    }
//    
//    public void apiChuck(){
//        try{
//            
//            //RestAPI  
//            
//            URL urlChuck = new URL(strRandomChuck);
//            Header header = new Header("accept: application/json");
//            HttpURLConnection httpURL = (HttpURLConnection) urlChuck.openConnection();
//            InputStream inputStream = httpURL.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            
//            while( chuckQuote != null){
//                chuckQuote = bufferedReader.readLine();
//            }
//            // test
//            System.out.println(chuckQuote);
//        }catch(Exception e){
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//    
//    public void startServer(){
//        new Thread(new Runnable(){
//            public void run(){
//                try{
//                    ServerSocket serverSocket = new ServerSocket(5555);
//                    while(true){
//                        Socket socket = serverSocket.accept(); // blocks code, waiting for client connection; gives back control when client arrives
//
//                        new Thread(new Runnable(){
//                            public void run(){
//                                try{
//                                    System.out.println("Received Client connection");
//                                    OutputStream outputStream = socket.getOutputStream();
//                                    InputStream inputStream = socket.getInputStream(); // receive data from client.
//                                    ObjectOutputStream oOutputStream = new ObjectOutputStream(outputStream);
//                                    ObjectInputStream oInputStream = new ObjectInputStream(inputStream);
//                                    while(true){
//                                        String clientMessage = (String)oInputStream.readObject();
//                                        
//                                        // if client requests chuck quote
//                                        if (clientMessage.equals("chuckQuote")){ // requesting chatList
//                                            apiChuck();
//                                            oOutputStream.writeObject(chuckQuote);
//                                            oOutputStream.flush(); // forces TCP to send to client (no waiting in queue).
//                                        }
//                                        else if(clientMessage.contains("bye")){ // closing connection
//                                            socket.close();
//                                            break;
//                                        }
//
//                                    }
//                                    }
//                                    catch(Exception e){
//                                        System.out.println("Error: " + e.getMessage());
//                                    }
//                            }
//                        }).start();
//                    
//                    
//                    }            
//                }
//                catch (Exception e){
//                    System.out.println("Error message: "+e.getMessage());
//                }
//            }
//        }).start();
//        
//        
//    }    
//    
//}
