
public class DigitalVideoDisc extends Disc implements Playable{
    
    // public DigitalVideoDisc(String title){
    //     setTitle(title);
    //     setId(nbDigitalVideoDiscs);
    //     nbDigitalVideoDiscs++;
    // }
    // public DigitalVideoDisc(String category, String title, float cost){
    //     setTitle(title);
    //     setCategory(category);
    //     setCost(cost);
    //     setId(nbDigitalVideoDiscs);
    //     nbDigitalVideoDiscs++;
    // }
    // public DigitalVideoDisc(String director, String category, String title, float cost){
    //     this.director = director;
    //     setTitle(title);
    //     setCategory(category);
    //     setCost(cost);
    //     setId(nbDigitalVideoDiscs);
    //     nbDigitalVideoDiscs++;
    // }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(title, category, cost, length, director);
    }
    @Override
    public String toString(){
        String res = "DVD: ";
        res +="ID: " + getId()+  ", Title: " + getTitle() + ", Category: " + getCategory()  + ", Director: " + getDirector() + ", Length: " + getLength() + ", Cost: " + getCost();
        return res;
    }
    public boolean isMatch(String title){
        if(getTitle().compareToIgnoreCase(title)==0) return true;
        return false;
    }
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}