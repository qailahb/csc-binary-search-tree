import java.util.concurrent.ThreadLocalRandom;

public class Post {
    private String title;
    private String fileName;
    private int likes;
    //private int followers;

    public Post(String title, String fileName, int likes) {
        this.title = title;
        this.fileName = fileName;
        //this.followers = (followers == 0) ? ThreadLocalRandom.current().nextInt(0, 100000) : followers;
        this.likes = (likes == 0) ? ThreadLocalRandom.current().nextInt(0, 100000) : likes;
    }


    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLikes() {
        return likes;
    }
    
    
    @Override
    public String toString() {
        return
            ("\n" + "Title: " + getTitle() + "\n" +
            "Video: " + getFileName() + "\n" +
            "Number of likes: " + getLikes() + "\n");
    }

    public static void main(String[] args) {};
}


