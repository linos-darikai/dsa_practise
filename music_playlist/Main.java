

public class Main {
    public static void main(String[] args) {
        Song s1 = new Song("Doc Doc Shebeleza", "Casper Nyovest", 3.23);
        Song s2 = new Song("Baxolele", "Dj Maphorisa", 4.50);
        Song s3 = new Song("Biri Marung", "Dj Maphorisa", 5.50);
        Song s4 = new Song("Pepepepe", "Dj Waffles", 6.50);
        
        System.out.println(s1);
        System.out.println(s2);
        BasicPlaylist bs = new BasicPlaylist();
        bs.addSong(s1, 1);
        bs.addSongLast(s2);
        bs.addSongLast(s3);
        bs.addSongLast(s4);
        bs.displaySongs();
        bs.removeSong("Doc doc shebeleza");
        bs.displaySongs();
        System.out.println(bs.playListDuration());
        
    }
    
}
