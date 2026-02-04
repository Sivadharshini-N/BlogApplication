public class Comment {

    User commentAuthor;
    Post commentedOn;
    String commentContent;
    int upvote;
    int downvote;


    public Comment(User commentAuthor, Post commentedOn, String commentContent ){
        this.commentAuthor = commentAuthor;
        this.commentedOn  = commentedOn;
        this.commentContent = commentContent;
        upvote = 0;
        downvote = 0;
    }



}
