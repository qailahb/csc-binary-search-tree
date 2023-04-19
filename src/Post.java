/** Post class
 *  Contains Post constructors and returns relevant data called by the Program class
 */

import java.util.concurrent.ThreadLocalRandom;

/** Class containing data attached to a post */
public class Post {

    private String title;
    private String fileName;
    private int likes;
    //private int followers;

    public Post(String title, String fileName, int likes) {
        this.title = title;
        this.fileName = fileName;
        //this.followers = (followers == 0) ? ThreadLocalRandom.current().nextInt(0, ):followers;
        this.likes = (likes==0) ? ThreadLocalRandom.current().nextInt(0,1000000):likes;
    }

    /** Methods returning data associated with a post */
    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLikes() {
        return likes;
    }
    
    /** Method to provide user interface of Post with its data */
    @Override
    public String toString() {
        return
            ("\n" + 
            "Title: " + getTitle() + "\n" +
            "Video: " + getFileName() + "\n" +
            "Number of likes: " + getLikes() + 
            "\n");
    }

    public static void main(String[] args) {};
}


