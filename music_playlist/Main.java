



public class Main {
    public static void main(String[] args) {
        Song s1 = new Song("Doc Doc Shebeleza", "Casper Nyovest", 3.23);
        Song s2 = new Song("Baxolele", "Dj Maphorisa", 4.50);
        Song s3 = new Song("Biri Marung", "Dj Maphorisa", 5.50);
        Song s4 = new Song("Pepepepe", "Dj Waffles", 6.50);
        
        System.out.println(s1);
        System.out.println(s2);
     
        EnhancedPlaylist bc = new EnhancedPlaylist();
        bc.addSong(s1, 1);
        bc.addSong(s2, 1);
        bc.addLast(s3);
        bc.addLast(s3);
        bc.displaySongs();
        System.out.println(bc.playListDuration());

        bc.removeSong("biri marung");
    
        bc.displaySongs();
        System.out.println(bc.playListDuration());

        System.out.println(bc.displaySong(2));

        System.out.println(bc.displayCurrentSong());
        bc.playNextSong();
        bc.playNextSong();
        System.out.println(bc.displayCurrentSong());
        bc.playPrevSong();
        System.out.println(bc.displayCurrentSong());
        System.out.println("Random song");
        
        bc.shuffleNextSong();
        System.out.println(bc.displayCurrentSong());

       
    }
    
}
