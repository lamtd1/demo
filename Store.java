
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store{
    ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media... obj){
        for(Media x : obj){
            if(!itemsInStore.contains(x)){
                itemsInStore.add(x);
                return;
            }
            
        }
        System.out.println("Add Failed");
    }
    public void removeMedia(Media... obj){
        for(Media x : obj){
            if(itemsInStore.contains(x)){
                itemsInStore.remove(x);
                System.out.println("Remove Successfully");
                return;
            }
            
        }
        System.out.println("Remove Failed");
    }
    public void print(){
        for(Media x : itemsInStore){
            System.out.println(x.toString());
        }
    }
    public Media findByTitle(String title){
       for(Media x : itemsInStore){
            if(x.getTitle().compareTo(title)==0){
                return x;
            }
       }
       System.out.println("Not Found");
       return null;
    }
    public void updateStore(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose media type to add:");
        System.out.println("1. DigitalVideoDisc (DVD)");
        System.out.println("2. CompactDisc (CD)");
        System.out.println("3. Book");
        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                addDVD(sc);
                break;
            case 2:
                addCD(sc);
                break;
            case 3:
                addBook(sc);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private void addDVD(Scanner scanner) {
        System.out.print("Enter DVD title: ");
        String title = scanner.nextLine();
        System.out.print("Enter DVD category: ");
        String category = scanner.nextLine();
        System.out.print("Enter DVD director: ");
        String director = scanner.nextLine();
        System.out.print("Enter DVD length: ");
        int length = scanner.nextInt();
        System.out.print("Enter DVD cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); 

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        addMedia(dvd);
        System.out.println("DVD added successfully.");
    }

    // Thêm CD vào Store
    private void addCD(Scanner scanner) {
        System.out.print("Enter CD title: ");
        String title = scanner.nextLine();
        System.out.print("Enter CD category: ");
        String category = scanner.nextLine();
        System.out.print("Enter CD director: ");
        String director = scanner.nextLine();
        System.out.print("Enter CD length: ");
        int length = scanner.nextInt();
        System.out.print("Enter CD cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine();  

        System.out.print("Enter artist: ");
        String artist = scanner.nextLine();

        System.out.print("Enter number of tracks: ");
        int trackCount = scanner.nextInt();
        scanner.nextLine(); 
        ArrayList<Track> tracks = new ArrayList<>();
        for (int i = 0; i < trackCount; i++) {
            System.out.print("Enter track " + (i + 1) + " title: ");
            String trackTitle = scanner.nextLine();
            System.out.print("Enter track " + (i + 1) + " length: ");
            int trackLength = scanner.nextInt();
            scanner.nextLine(); 
            tracks.add(new Track(trackTitle, trackLength));
        }

        CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist, tracks);
        addMedia(cd);
        System.out.println("CD added successfully.");
    }

    // Thêm Book vào Store
    private void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book category: ");
        String category = scanner.nextLine();
        System.out.print("Enter book cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); 

        System.out.print("Enter authors (comma separated): ");
        String authorsInput = scanner.nextLine();
        List<String> authors = List.of(authorsInput.split(","));

        Book book = new Book(title, category, cost, authors);
        addMedia(book);
        System.out.println("Book added successfully.");
    }




}