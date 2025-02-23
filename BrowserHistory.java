import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class BrowserHistory{
    //The history node and its instance variables
    private class HistoryNode{
        private String url;
        private String timestamp;
        private HistoryNode prev = null;
        private HistoryNode next = null;

        public HistoryNode(String url, String timestamp){
            this.url = url;
            this.timestamp = timestamp;
        }      


    }

    private HistoryNode head;
    private HistoryNode tail;
    private int size;

   
    public BrowserHistory(){
        this.head = new HistoryNode(null, null);
        this.tail = new HistoryNode(null, null);
        this.size = 0;
    }

   
    public void addPage(String timestamp, String url){
        //Create a Node with the page details
        // Add the node to the end of the linked list
        // make sure that the case its not the first node
        HistoryNode newNode = new HistoryNode(url, timestamp);
        //adding the first node
        if(size == 0){            
            head.next = newNode;
            newNode.prev = head;
            newNode.next = tail;
            tail.prev = newNode;            
        }
        else{
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            newNode.next = tail;
            tail.prev = newNode;
        }
        size ++;  


        
    }

    public void removePage(String time){
        //setting p to be the 1 element
        HistoryNode p = head.next;
       //while we havent reached the tail node
        while(p.next != null){
            if(p.timestamp.equals(time)){
                p.prev.next = p.next;
                p.next.prev = p.prev;
                p.next = null;
                p.prev = null;
                break;
            }
            p = p.next;
            
        }             
        size --;

    }

    public void displayHistoryForward(){
        int count = 1;
        HistoryNode p = head.next;
        String s = "";
        while(p.next != null){
            s = String.format("%s %d. %s %s\n", s, count, p.timestamp, p.url);
            count ++;
            p = p.next;
        }
        System.out.println(s);
    }
    public void displayHistoryBackward(){
        String s = getHistory(); 
        System.out.println(s);
    }

    public String getHistory(){
        int count = size;
        HistoryNode p = tail.prev;
        String s = "";
        while(p.prev != null){
            s = String.format("%s %d. %s %s\n", s, count, p.timestamp, p.url);
            count --;
            p = p.prev;
        }
        return s;

    }


    public void saveToFile(){        
        try {
            FileWriter file = new FileWriter("./history.txt");
            file.write(getHistory());
            file.close();

            System.out.println("Successfully saved");
            
        } catch (Exception e) {
            System.out.println("Not saved" + e.getMessage());
        }
    }
    public void loadFromFile(){
        try {
            File file = new File("./history.txt");
            Scanner scanFile = new Scanner(file);

            while(scanFile.hasNextLine()){
                String s = scanFile.nextLine();
                String[] s_split = s.split("\\s+");
                addPage(s_split[2], s_split[3]);
            }
            System.out.println("Successfully loaded");
            
        } catch (Exception e) {
            System.out.println("Failed to Load" + e.getMessage());
        }
    }




    public static void main(String[] args) {
        BrowserHistory bs = new BrowserHistory();
        bs.loadFromFile();
        bs.addPage("12-10-25", "www.win.com");
        bs.addPage("02-10-21", "www.lose.com");
        bs.addPage("18-10-28", "www.getMoney.com");
        bs.addPage("19-10-20", "www.chopMoney.com");
        bs.displayHistoryBackward();
        bs.displayHistoryForward();

        bs.removePage("02-10-21");
        bs.displayHistoryBackward();
        bs.displayHistoryForward();
        bs.saveToFile();


    }






}