public class Track implements Playable{
    private String title;
    private int length;
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass() || o == null) return false;
        Track other = (Track) o;
        return this.getTitle().equals(other.getTitle());
    }
    @Override
    public String toString(){
        return String.format("\nTitle: %s, Length: %d", title, length);
    }
}