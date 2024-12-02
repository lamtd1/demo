import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cart{
    public static final int MAX_NUMBERS_ORDERED = 20;
    public static int nbDigitalVideoDiscs;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();
    
    public void addMedia(Media obj){
            if(!itemsOrdered.contains(obj)){
                itemsOrdered.add(obj);
                System.out.println("Added Successfully");
                return;
            }
            
        System.out.println("Media already in cart");
        
    }
    public void removeMedia(Media obj){
            if(itemsOrdered.contains(obj)){
                itemsOrdered.remove(obj);
                System.out.println("Remove Successfully");
                return;
            }
            
        System.out.println("Media not in cart");
        
    }
    public float totalCost(){
        float sum = 0;
        for(Media x : itemsOrdered){
            sum += x.getCost();
        }
        return sum;
    }
    public void print(){
        for(Media x : itemsOrdered){
            System.out.println(x.toString());
        }
    }   
    public int getItemOrdered(){
        return itemsOrdered.size();
    }
    public void toEmpty(){
        itemsOrdered.clear();
    }
    public void filter(String a){
        Scanner sc = new Scanner(System.in);
        if(a.equals("id")){
            System.out.println("Enter ID: ");
            int id = sc.nextInt(); sc.nextLine();
            Media x = filterById(id);
            if(x != null){
                System.out.println(x);
            }else System.out.println("Not Found");
        }else{
            System.out.println("Enter Title: ");
            String title = sc.nextLine();
            ArrayList<Media> x = filterByTitle(title);
            if(x.size() != 0){
                for(Media m : x){
                    System.out.println(m);
                }
            }else System.out.println("Not Found");
        }
    }
    public ArrayList<Media> filterByTitle(String title) {
        ArrayList<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                filteredList.add(media);
            }
        }
        
        return filteredList;
    }

    public Media filterById(int id){
        for(Media x : itemsOrdered){
            if(x.getId() == id){
                return x;
            }
        }
        return null;
    }
   
    public int size(){
        return itemsOrdered.size();
    }
    public void sort(int type){
        if(type==1){
            Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        }else{
            Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        }
    }
    public void removeByTitle(String title){
        for(Media x : itemsOrdered){
            if(x.getTitle().equals(title)){
                removeMedia(x);
                return;
            }
        }
    }
    public void playMedia(String title){
        for(Media x : itemsOrdered){
            if(x.getTitle().equals(title)){
                if(x instanceof Playable){
                    ((Playable) x).play(); 
                }else{
                    System.out.println("Media can't be played");
                }
            }
        }
    }
    

}