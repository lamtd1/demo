import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    private String content;

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println("Add Successfully!");
        }else{
            System.out.println("Not Found!");
        }
    }
    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("Remove Successfully!");
        }else{
            System.out.println("Not Found");
        }
    }
    public int getContentLength() {
        if (content != null) {
            // Split the content by whitespace to count the tokens
            return content.split("\\s+").length;
        }
        return 0;
    }

    @Override
    public String toString() {
        String res = "Book: ";
        res += String.format("ID: %d, Title: %s, Category: %s, Author List: ",getId(), getTitle(), getCategory());
        for(String a : authors){
            res += a + " - ";
        }
        res = res.substring(0, res.length() - 3);
        res += ", Content Length: " + getContentLength();
        return res;
    }
}
