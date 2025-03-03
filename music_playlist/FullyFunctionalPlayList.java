
import java.util.Random;

public class FullyFunctionalPlayList{
    private class Node{
        Node prev;
        Node next;
        Song song;
        public Node(Song song){
            this.song = song;
        }

    }
    private Node head;
    private Node tail;
    private int size;
    private Node currentSong = head;


    public void addSong(Song song,int pos){
        //if list is empty
        Node newNode = new Node(song);

       
        if(pos == 1){
            newNode.next = head;
            if (head != null)
                head.prev = newNode;
            head = newNode;
            currentSong = head;
            if(size == 0){
                tail = newNode;
            }          
        }
        if(pos > 1 && pos <= size){
            Node p = head;
            int count = 1;
            while(count < pos - 1){
                p = p.next;
                count ++;                
            }
            newNode.next = p.next;
            newNode.prev = p;
            p.next = newNode;
            newNode.next.prev = newNode;
        }
        if(pos == size + 1){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size ++;
        tail.next = head;
        head.prev = tail;

    }

    public void addLast(Song song){
        addSong(song, size + 1);
    }
    public void removeSong(String title){
        Node p = head;
        while(p.next != null){
            if(p.next.song.getTitle().equalsIgnoreCase(title)){                
               p.next = p.next.next;
               p.next.prev = p;
            }
            p = p.next;
        }
        size --;
    }

    public void displaySongs(){
        String s = "";
        Node p = head;
        int count = 1;

        while(count <= size){
            s += count + ". " + p.song.toString() + "\n";
            p = p.next;
            count ++;
        }
        System.out.println(s);
    }

    public double playListDuration(){
        double total = 0;
        Node p = head;
        while(p != null){
            total += p.song.getDuration();
            p = p.next;
        }
        return total;
    }

    public void playNexSong(){
        if (currentSong != null){
            currentSong = currentSong.next;
        }
        else{
            System.out.println("This is the end of the list");
            currentSong = head;
        }
       
    }
    public void continiousPlay(){
        currentSong = currentSong.next;
    }

    public Node get(int pos){

        if(pos <= 0 || pos > size ){
            System.out.println("Out of size index error");
            return null;
        }
        Node p = head;
        int count = 1;
        while(count < pos){
            p = p.next;
            count ++;
        }
        return p;
    }

    public void playPrevSong(){
        if (currentSong != null)
            currentSong = currentSong.prev;
        else{
            System.out.println("This is end of the list");
            currentSong = head;
        }
    }

    public void shuffleNextSong(){
        Random rand = new Random();
        int randomNum = rand.nextInt(size - 1 + 1) + 1;
        currentSong = get(randomNum);
        if(currentSong == null)
            currentSong = head;
        
    }

    public String displaySong(int pos){
        Node p = get(pos);
        String s = p.song.toString();
        return s;
    }
    
    public String displayCurrentSong(){
        Node p = currentSong;
        String s = p.song.toString();
        return s;
    }

    
}
