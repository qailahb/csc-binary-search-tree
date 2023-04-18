import java.util.ArrayList;

public class Account implements Comparable<Account> {

    private String username;
    private String userDescription;
    private ArrayList<Post> posts = new ArrayList<>();
    
    public Account(String username, String userDescription) {
        this.username = username;
        this.userDescription = userDescription;
    }

    public String getAccount() {
        return username;
    }
    
    public String getProfileDescription() {
        return userDescription;
    }

    public String toString() {
        return getAccount() + "\n";
    }

    public void displayDescription() {
        System.out.println("Account Description: " + getProfileDescription());
    }

    public ArrayList<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public void displayPosts() {
        for (int i = posts.size() -1; i >= 0; i--) {
            System.out.println(posts.get(i));
        }
        System.out.println();
    }
    
    public void addPost(String title, String fileName, int likes) {
        posts.add(new Post(title, fileName, likes));
    }

    @Override
    public int compareTo(Account other) {
        return this.username.compareTo(other.username);
    }

    public static void main(String[] args) {};
    
}
