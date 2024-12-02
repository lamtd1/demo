import java.util.Comparator;

public abstract class Media{
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbDigitalVideoDiscs = 1;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
    new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
    new MediaComparatorByCostTitle();
    public Media(String title, String category, float cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs++;
    }
    public Media(){
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Media other = (Media) obj;
        return this.getTitle().equals(other.getTitle());
    }
    
    

}