public class ContactListBST {

    private Node root;
    private int numberOfContacts;

    public class Node{
        String name;
        String phoneNumber;
        Node left;
        Node right;
        
    
        public Node(String name, String phoneNumber){
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
        public String toString(){
            return String.format("%s, %s", name, phoneNumber);
        }

    }

    public ContactListBST(){
    }

    public void insert(String name, String phoneNumber){
        Node newNode = new Node(name, phoneNumber);
        if(root == null){
            root = newNode;
        }
        else{
            insertRec(root, newNode);
        }
    }

    public void insertRec(Node parent, Node newNode){
        if(parent.name.compareTo(newNode.name) > 0){
            if(parent.left == null){
                parent.left = newNode;
            }
            else{
                insertRec(parent.left, newNode);
            }
        }
        else{
            if(parent.right == null){
                parent.right = newNode;
            }
            else{
                insertRec(parent.right, newNode);
            }
        }

    }
    
    public Node search(String name){
        if (root == null){
            return null;
        }
        return searchRec(root, name);
    }

    public Node searchRec(Node parent, String name){
        if(parent == null){
            return null;
        }
        if(parent.name.equals(name)){
            return parent;
        }
        else if(parent.name.compareTo(name) > 0){
            return searchRec(parent.left, name);
        }
        else{
            return searchRec(parent.right, name);
        }
    }

    public void delete(String name){
        root = deleteRec(root, name);
    }

    public Node deleteRec(Node parent, String name){
        if (parent == null){
            return null;
        }

        if(parent.name.compareTo(name) > 0){
            parent.left = deleteRec(parent.left, name);
        }
        else if(parent.name.compareTo(name) < 0){
            parent.right = deleteRec(parent.left, name);
        }

        else{
            if(parent.left == null && parent.right == null)
                return null;
            else if(parent.left == null)
                return parent.right;
            else if(parent.right == null)
                return parent.left;
            else{
                Node minNode = minimumValue(parent.right);
                parent.name = minNode.name;
                parent.phoneNumber = minNode.phoneNumber;
                parent.right = deleteRec(parent.right, minNode.name);
            }
        }

        return parent;      

    }



    public Node minimumValue(Node parent){
        if(parent.left == null){
            return parent;
        }
        else{
           return minimumValue(parent.left);
        }
    }

    public void printAll(){
        inOrderTrav(root);
    }
    public void inOrderTrav(Node node){
        if(node == null){
            return;
        }               
        inOrderTrav(node.left); 
        System.out.print(node.name + "->");                     
        inOrderTrav(node.right);          
    }
}
