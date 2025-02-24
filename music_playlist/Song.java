public class Song {
    private String title;
    private String artist;
    private double duration;

    public Song(String title, String artist, double duration){
        this.duration = duration;
        this.artist = artist;
        this.title = title;
    }


    //getter methods for the attributes
    public String getTitle(){
        return this.title;
    }
    public String getArtist(){
        return this.artist;
    }
    public double getDuration(){
        return this.duration;
    }

    //setter methods 
    public String toString(){
        return String.format("%s, %s, %f", title, artist, duration);
    }

    
}
