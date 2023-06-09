/** Account class
 *  Contains Account information and returns relevant data called by the Program class
 */

import java.util.ArrayList;

/** Class containing data attached to an account */
public class Account implements Comparable<Account> {

    private String username;
    private String userDescription;
    private ArrayList<Post> posts = new ArrayList<>();
    
    public Account(String username, String userDescription) {
        
        this.username = username;
        this.userDescription = userDescription;
    }

    /** Methods returning relevant information called by the Program class */
    public String getAccount() {
        return username;
    }
    
    /** Returns account
     *  Used when calling a list of all accounts, returning each account on a new line
     */
    public String toString() {
        return getAccount() + "\n";
    }

    public String getProfileDescription() {
        return userDescription;
    }

    public void displayDescription() {
        System.out.println("Account Description: " + getProfileDescription() );
    }

    public ArrayList<Post> getPosts() {
        return new ArrayList<>(posts);
    }

    public void addPost(String title, String fileName, int likes) {
        posts.add(new Post(title, fileName, likes));
    }

    public void displayPosts() {
        /** Method foe returning posts in order with the most recent first */
        for ( int i = posts.size() -1;i >= 0;i-- ) {
            System.out.println(posts.get(i));
        }

        System.out.println();
    }
    

    /** The compareTo method uses ASCII comparison to compare two strings 
     *  It returns 0 if the strings are identical, <0 if the first is 'smaller' than the second and >0 if the first is greater than the second.
     *  Note: Case sensitive
    */
    @Override
    public int compareTo(Account other) {
        return this.username.compareTo(other.username);
    }

    public static void main(String[] args) {};
    
}
