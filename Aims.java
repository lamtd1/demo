import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Aims{
    public static void showMenu() { 

        System.out.println("AIMS: "); 
        
        System.out.println("--------------------------------"); 
        
        System.out.println("1. View store"); 
        
        System.out.println("2. Update store"); 
        
        System.out.println("3. See current cart"); 
        
        System.out.println("0. Exit"); 
        
        System.out.println("--------------------------------"); 
        
        System.out.println("Please choose a number: 0-1-2-3"); 
        
        } 
    public static void storeMenu() { 

        System.out.println("Options: "); 
        
        System.out.println("--------------------------------"); 
        
        System.out.println("1. See a media's details"); 
        
        System.out.println("2. Add a media to cart"); 
        
        System.out.println("3. Play a media"); 
        
        System.out.println("4. See current cart"); 
        
        System.out.println("0. Back"); 
        
        System.out.println("--------------------------------"); 
        
        System.out.println("Please choose a number: 0-1-2-3-4"); 
        
        } 
    public static void mediaDetailsMenu() { 

        System.out.println("Options: "); 
        
        System.out.println("--------------------------------"); 
        
        System.out.println("1. Add to cart"); 
        
        System.out.println("2. Play"); 
        
        System.out.println("0. Back"); 
        
        System.out.println("--------------------------------"); 
    }
    public static void cartMenu() { 

        System.out.println("Options: "); 
        
        System.out.println("--------------------------------"); 
        
        System.out.println("1. Filter medias in cart"); 
        
        System.out.println("2. Sort medias in cart"); 
        
        System.out.println("3. Remove media from cart"); 
        
        System.out.println("4. Play a media"); 
        
        System.out.println("5. Place order"); 
        
        System.out.println("0. Back"); 
        
        System.out.println("--------------------------------"); 
        
        System.out.println("Please choose a number: 0-1-2-3-4-5"); 
        
    } 
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        List<String> authors1 = new ArrayList<>(List.of("J.K. Rowling"));
        List<String> authors2 = new ArrayList<>(List.of("George R.R. Martin", "Elio M. García Jr."));
        store.addMedia(new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 10.5f, authors1));
        store.addMedia(new Book("A Game of Thrones", "Fantasy", 15.0f, authors2));

        // Thêm một số DigitalVideoDisc
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Disney", 90, 19.99f));
        store.addMedia(new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 25.5f));

        // Thêm một số CompactDisc
        ArrayList<Track> tracks1 = new ArrayList<>(List.of(new Track("Track 1", 4), new Track("Track 2", 5)));
        ArrayList<Track> tracks2 = new ArrayList<>(List.of(new Track("Song 1", 3), new Track("Song 2", 4)));
        store.addMedia(new CompactDisc("Greatest Hits", "Pop", 9.99f, 60, "Various Artists", "Sony Music", tracks1));
        store.addMedia(new CompactDisc("Classic Rock", "Rock", 12.5f, 70, "Rock Legends", "Universal", tracks2));
        boolean running = true;
        Scanner sc = new Scanner(System.in);
        while (running) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: // View store
                    boolean inStore = true;
                    while (inStore) {
                        System.out.println("--------------------------------");
                        store.print(); // Display store items
                        System.out.println("--------------------------------");
                        storeMenu();
                        int storeChoice = sc.nextInt();
                        sc.nextLine(); // Consume newline

                        switch (storeChoice) {
                            case 1: // See media details
                                System.out.print("Enter the title of the media: ");
                                String title = sc.nextLine();
                                Media media = store.findByTitle(title);
                                if (media != null) {
                                    System.out.println(media);
                                    mediaDetailsMenu();
                                    int detailChoice = sc.nextInt();
                                    sc.nextLine();
                                    switch (detailChoice) {
                                        case 1: // Add to cart
                                            cart.addMedia(media);
                                            System.out.println("Added to cart: " + media.getTitle());
                                            break;
                                        case 2: // Play (if playable)
                                            if (media instanceof Playable) {
                                                ((Playable) media).play();
                                            } else {
                                                System.out.println("This media cannot be played.");
                                            }
                                            break;
                                        case 0: // Back
                                            break;
                                        default:
                                            System.out.println("Invalid choice!");
                                    }
                                } else {
                                    System.out.println("Media not found!");
                                }
                                break;
                            case 2: // Add media to cart
                                System.out.print("Enter the title of the media: ");
                                String addTitle = sc.nextLine();
                                Media mediaToAdd = store.findByTitle(addTitle);
                                if (mediaToAdd != null) {
                                    cart.addMedia(mediaToAdd);
                                    System.out.println("Number of media: " + cart.getItemOrdered());
                                } else {
                                    System.out.println("Media not found!");
                                }
                                break;
                            case 3: // Play media
                                System.out.print("Enter the title of the media: ");
                                String playTitle = sc.nextLine();
                                Media mediaToPlay = store.findByTitle(playTitle);
                                if (mediaToPlay instanceof Playable) {
                                    ((Playable) mediaToPlay).play();
                                } else {
                                    System.out.println("This media cannot be played.");
                                }
                                break;
                            case 4: // See current cart
                                if(cart.size() == 0) System.out.println("Cart Empty");
                                cart.print();
                                break;
                            case 0: // Back
                                inStore = false;
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                    break;
                case 2: // Update store
                    System.out.print("Add or Remove (a/r): ");
                    char action = sc.nextLine().toLowerCase().charAt(0);
                    if (action == 'a') {
                        store.updateStore();
                    } else if (action == 'r') {
                        System.out.print("Enter title to remove: ");
                        String removeTitle = sc.nextLine();
                        Media x = store.findByTitle(removeTitle);
                        if(x != null){
                            store.removeMedia(x);
                        }
                        
                    } else {
                        System.out.println("Invalid action!");
                    }
                    break;
                case 3: // See current cart
                    boolean inCart = true;
                    while (inCart) {
                        if(cart.size() == 0) System.out.println("Cart Empty");
                        System.out.println("--------------------------------");
                        cart.print();
                        System.out.println("--------------------------------");
                        cartMenu();
                        int cartChoice = sc.nextInt();
                        sc.nextLine();

                        switch (cartChoice) {
                            case 1: // Filter media
                                System.out.println("Filter by: 1. ID 2. Title");
                                int filterChoice = sc.nextInt();
                                sc.nextLine();
                                cart.filter(filterChoice == 1 ? "id" : "title");
                                break;
                            case 2: // Sort media
                                System.out.println("Sort by: 1. Title 2. Cost");
                                int sortChoice = sc.nextInt();
                                sc.nextLine();
                                cart.sort(sortChoice);
                                break;
                            case 3: // Remove media
                                System.out.print("Enter title: ");
                                String removeFromCart = sc.nextLine();
                                cart.removeByTitle(removeFromCart);
                                break;
                            case 4: // Play a media
                                System.out.print("Enter title: ");
                                String playInCart = sc.nextLine();
                                cart.playMedia(playInCart);
                                break;
                            case 5: // Place order
                                System.out.println("Order is created");
                                cart.toEmpty();
                                break;
                            case 0: // Back
                                inCart = false;
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                    break;
                case 0: // Exit
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
     
}
