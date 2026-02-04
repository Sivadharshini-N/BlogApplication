import java.util.HashMap;
import java.util.Map;

public class Post {

    private String postName;
    private String postContent;
    private String authorName;
    private int upvote;
    private int downvote;
    boolean isCommentsAllowed;
    Map<User,Comment> comments;

    public Post ( String postName, String postContent, boolean isCommentsAllowed, String username){
        this.postName = postName;
        this.postContent = postContent;
        this.authorName = username;
        upvote = 0;
        downvote =0;
        this.isCommentsAllowed = isCommentsAllowed;
        if(isCommentsAllowed)
            comments = new HashMap<>();
    }

    public String getPostName() { return postName; }
    public String getPostContent() { return postContent; }
    public String getAuthorName() { return authorName; }
    public int getUpvote() { return upvote; }
    public int getDownvote() { return downvote; }

    public void setUpvote(){
        upvote+=1;
    }
    public void setDownvote(){
        downvote+=1;
    }




}
