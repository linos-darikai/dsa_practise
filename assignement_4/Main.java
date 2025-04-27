public class Main {
    public static void main(String[] args) {
        ContactListBST n = new ContactListBST();

        n.insert("M", "0773");
        n.insert("L", "7873");
        n.insert("A", "224");
        n.insert("B", "224");
        n.insert("H", "224");
        n.insert("Z", "224");
        n.insert("K", "224");

        System.out.println(n.search("L"));

        n.printAll();
        System.out.println("");
        n.delete("A");
        n.printAll();
    }
    
}
