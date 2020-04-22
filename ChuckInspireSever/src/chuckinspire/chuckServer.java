///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package chuckinspire;
//
//import java.io.File;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;
//
//
//
///**
// *
// * @author cshsb
// */
//public class chuckServer {
//    private Scanner chuck;
//    private Scanner insp;
//    String txt;
//    public String [] ChuckQuotes;
//    public String [][] InspireQuotes;
//    int numLines = 0;
//    static int iChuck = 0;
//    static int iInsp = 0;
//    
//    
//    public int randInt(int max, int min){
//        return ThreadLocalRandom.current().nextInt(max)+1;
//    }
//    public void openChuckFile(){
//        try{
//            //chuck = new Scanner(new File("BareChuck.txt"));            
////            File file = new File(".");
////            for(String fileNames : file.list()) System.out.println(fileNames);
//        chuck = new Scanner(new File("BareChuck.txt"));
//        }catch(Exception e){
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//    public void readChuckFile(){
//        while(chuck.hasNextLine()){
//            txt = chuck.nextLine();
//            //System.out.println(txt);
//            iChuck++;
//        }
//        chuck.close();
//        try{
//            Scanner scan = new Scanner(new File(txt));
//            int i = 0;
//            ChuckQuotes = new String[iChuck];
//            while(scan.hasNextLine() ){
//                String s = scan.nextLine();
//                ChuckQuotes[i] =s;
//                //System.out.println(ChuckQuotes[i]);
//                i++;
//            }
//            scan.close();
//        }
//        catch(Exception e){
//            e.getStackTrace();
//        }
//    }
//    public void assignTxtToChuck(){
//         try{
//            Scanner scan = new Scanner(new File(txt));
//            
//            ChuckQuotes = new String[iChuck];
//            
//            for (int x = 0; x < iChuck; x++){
//                ChuckQuotes[x] = scan.nextLine();               
//                
//            }
//            
////            while(scan.hasNextLine() ){
////                String s = scan.nextLine();
////                ChuckQuotes[i] =s;
////                //System.out.println(ChuckQuotes[i]);
////                i++;
////            }
//            scan.close();
//        }
//        catch(Exception e){
//            e.getStackTrace();
//        }
//    }
//    public void openInspFile(){
//        try{
//            //in = new Scanner(new File("BareChuck.txt"));            
////            File file = new File(".");
////            for(String fileNames : file.list()) System.out.println(fileNames);
//        insp = new Scanner(new File("InspirationalQuotes.txt"));
//        }catch(Exception e){
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//    public void readInspFile(){
//        while(insp.hasNextLine()){
//            txt = insp.nextLine();
//            
//            //System.out.println(txt);
//            iInsp++;
//        }
//        
//        
//        insp.close();
//        try{
//            Scanner scan = new Scanner(new File("InspirationalQuotes.txt"));
//            int i = 0;
//            InspireQuotes = new String[iInsp][3];
//            String line = "";
//            while(scan.hasNextLine() && scan.nextLine() != null){
//                line = scan.nextLine();
//                String [] strSplit = line.split(";");
//                
//                //System.out.println("strSplit: "+ Arrays.toString(strSplit));
//                
//                for (int x = 0; x < strSplit.length; x++){
//                    InspireQuotes[i][x] = strSplit[x];
//                }
//                
//                
//                // test
////                System.out.println("[" + i + "]" + " [" + 0 + "]: " + InspireQuotes[i][0]);
////                System.out.println("[" + i + "]" + " [" + 1 + "]: " + InspireQuotes[i][1]+ "\n");
//                
//                i++;
//            }
//            scan.close();
//        }
//        catch(Exception e){
//            e.getStackTrace();
//        }
//    }
//}
