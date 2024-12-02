import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();
    public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }
    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track){
        if(!tracks.contains(track)){
            tracks.add(track);
            System.out.println("Add Successfully!");
        }
        System.out.println("Already have!");
    }
    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Remove Successfully!");
        }
        System.out.println("Not Found");
    }
    public int getLength(){
        int length = 0;
        for(Track x : tracks){
            length += x.getLength();
        }
        return length;
    }
    public void play(){
        for(Track x : tracks){
            x.play();
        }
    }
    @Override
    public String toString(){
       String res = "CD: ";
       res += "ID: "+ getId()+ ", Title: " + getTitle() + ", Category: " + getCategory() + ", Artist: " + artist + ", Director: " + getDirector() + ", Length: " + getLength() + ", Cost: " + getCost();
       res += "\nTracks: \n";
       for(Track x : tracks){
        res += x.toString() + "\n";
       }
       return res;
    }
}