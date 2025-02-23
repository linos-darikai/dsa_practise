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

    public void removePage(String timestamp){
        //setting p to be the 1 element
        HistoryNode p = head.next;
        int counter = 0;
       //while we havent reached the tail node
        while(p.next != null){
            if(p.timestamp.equals(timestamp)){
                break;
            }
            p = p.next;
            counter ++;
        }
        //there three cases for deletion, in the middle, the start and the end
        // at the middle this is the logic 
        if(counter < size || counter > 0){
            p.prev.next = p.next;
            p.next.prev = p.prev;
            p.next = null;
            p.prev = null;

        }
        //this is the logic when its at the end
        if(counter == 0){

        }
        size --;

    }






}