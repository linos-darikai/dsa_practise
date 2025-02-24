

public class BasicPlaylist{
    private class Node{
        private Song data;
        private Node next;

        public Node(Song data){
            this.data = data;
        }

    }
    private Node head;
    private Node tail;
    private int numberOfSongs;

    public BasicPlaylist(){
        head = new Node(null);
        tail = new Node(null);
        numberOfSongs = 0;
    }

    public void addSong(Song song, int pos){
        Node songNode = new Node(song);
        //there three cases
        //Adding at the center, the start and the end
        if(numberOfSongs == 0 && pos == 1){
            head.next = songNode;
            tail = songNode; 
            numberOfSongs++;
            return;        
        

        }
        else if(pos == 1){
            songNode.next = head.next;
            head.next = songNode;
            numberOfSongs ++;
            System.out.println("added at 0");
            return;
        }
        else if (pos > 1 && pos <= numberOfSongs + 1){
            Node p = head.next;
            int count = 1;
            while(p.next != null){
                p = p.next;
                count ++;
            }
            
            songNode.next = p.next;
            p.next = songNode;
            if (pos == numberOfSongs + 1){
                tail = songNode;
            }
        
            numberOfSongs ++;
            System.out.println("added");
        }
        else{
            System.out.println("pos is not correct playlist has " + numberOfSongs + " Songs");
        }

    }


    // the method that adds to the end
    public void addSongLast(Song song){
        addSong(song, numberOfSongs + 1);     
        
    }

    public void removeSong(String title){
        Node p = head;
        while(p.next != null){
            if(p.next.data.getTitle().equalsIgnoreCase(title)){                
                p.next = p.next.next;
                break;               
            }
            p = p.next;
        }
        numberOfSongs --;
    }

    public void displaySongs(){
        String s = "";
        Node p = head.next;
        int count = 1;

        while(p != null){
            s += count + ". " + p.data.toString() + "\n";
            p = p.next;
            count ++;

        }
        System.out.println(s);
    }
    //calculating the total duration
    public double playListDuration(){
        double total = 0;
        Node p = head.next;
        while(p != null){
            total += p.data.getDuration();
            p = p.next;
        }
        return total;

    }
    
}
