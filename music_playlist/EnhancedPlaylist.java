
public class EnhancedPlaylist {
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

    public EnhancedPlaylist(){
        head = new Node(null);
        tail = new Node(null);
    }

    public void addSong(Song song,int pos){
        //if list is empty
        Node newNode = new Node(song);
        if(size == 0){
            head.next = newNode;
            newNode.prev = head;
            newNode.next = tail;
            tail.prev = newNode;
            size ++;
            return;   
        }
        else if(pos > 1 && pos <= size + 1){
            Node p = head.next;
            while(p != null){
                
            }
        }

    }

    
}
