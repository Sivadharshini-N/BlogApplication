import java.util.*;

public class BlogSystem {
    Scanner sc = new Scanner(System.in);
    static Set<User> users;
    static Set<Post> posts;
    User currentUser;
    public BlogSystem(){
        users = new HashSet<>();
        posts = new HashSet<>();
    }

    public User isValidUser(String userName, String password){
        for(User user:users){
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void votingPost(Post post){
        System.out.println("Welcome to voting\n");
        System.out.println("1.Upvote\n2.Downvote");
        int option = sc.nextInt();
        switch (option){
            case 1:{
                post.setUpvote();
                break;
            }
            case 2: {
                post.setDownvote();
                break;
            }
            default: System.out.println("Enter a valid option");
        }
        System.out.println("Voting saved successfully");
    }

    public void votingComment(Post commentedOn, User commentedUser){
        if(commentedOn==null || commentedUser==null)
        {
            System.out.println("The searched comment not exists. Try something else.");
            return;
        }
        Comment filteredComment = getCommentByPostUser(commentedOn,commentedUser);

        System.out.println("1.Upvote\n2.Downvote");
        int option = sc.nextInt();

        if(option==1){
            filteredComment.upvote+=1;
        }
        else if(option == 2){
            filteredComment.downvote+=1;
        }
        else{
            System.out.println("Invalid option");
        }

    }

    public void viewUpvoteDownvote(Post post){
        System.out.println("--------------------------------------");
        System.out.println("Upvote: "+post.getUpvote());
        System.out.println("Downvote: "+post.getDownvote());
        System.out.println("--------------------------------------");
    }

    public void viewComments(Post post){
        System.out.println("--------Welcome to comment section------");
        if(!post.isCommentsAllowed){
            System.out.println("Comments are not enabled for this post!");
            return;
        }

        for(Map.Entry<User,Comment> comments:post.comments.entrySet()){
            User currUser = comments.getKey();
            Comment comment = comments.getValue();

            System.out.println(currUser.getUserName()+" Commented - "+ comment.commentContent);
        }
    }

    public void createPost(){
        sc.nextLine();
        System.out.println("Enter the title of the post:");
        String title=sc.nextLine();
        System.out.println("Enter the content of the post:");
        String content = sc.nextLine();
        System.out.println("Do you want to enable comment for this post:(y/n)");
        boolean isCommentAllowed = sc.nextLine().charAt(0) == 'y';

        Post newPost = new Post(title,content,isCommentAllowed,currentUser.getUserName());
        posts.add(newPost);

        System.out.println("Post created successfully");

    }

    public void displayPosts(){
        System.out.println("---All Posts---");
        for(Post post:posts){
            System.out.println("\n------------------------------------------------");
            System.out.print(post.getPostName()+" - ");
            System.out.print(post.getAuthorName());
            System.out.println("\n------------------------------------------------");

        }
    }

    public Post getPostByPostName(String postName){
        for(Post post:posts){
            if(post.getPostName().equals(postName)){
                return post;
            }
        }
        return null;
    }

    public User getUserByUsername(String username){
        for(User user:users){
            if(user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }

    public Comment getCommentByPostUser(Post commentedOn, User commentedUser){
        Map<User,Comment> commentMap = commentedOn.comments;
        return  commentMap.get(commentedUser);

    }

    public void addCommentToPost() {
        System.out.println("Enter the title of post to add comment:");
        String postName = sc.nextLine().trim();

        Post currPost = getPostByPostName(postName);
        if (currPost == null || !currPost.isCommentsAllowed) {
            System.out.println("No post available in the specified title OR Comments is not allowed to the post");
            return;
        }
        System.out.println("Type your comment and hit enter:");
        String commentContent = sc.nextLine();
        Comment comment = new Comment(currentUser, currPost, commentContent);

        currPost.comments.put(currentUser, comment);

    }

    public void viewPost(){
        System.out.println("Enter the title of post to View");
        String postName = sc.nextLine();
        Post currPost = getPostByPostName(postName);

        System.out.println("\n----------------------------------------");
        System.out.println("-----"+currPost.getPostName()+" - "+currPost.getAuthorName()+"----");
        System.out.println(currPost.getPostContent());
        System.out.println("\n----------------------------------------");
        viewUpvoteDownvote(currPost);
        votingPost(currPost);
        viewComments(currPost);

    }


    public void login(){
        System.out.println("Welcome to login");
        System.out.println("Enter the userName");
        String userName = sc.next().trim();
        System.out.println("Enter the password:");
        String password = sc.next().trim();

        currentUser = isValidUser(userName,password);
        if(currentUser==null){
            System.out.println("Invalid credentials");
            return;
        }
        displayMenu();
    }

    public void register(){
        System.out.println("Enter the proper credentials to register:");
        System.out.println("Enter the username:");
        String username = sc.next().trim();
        System.out.println("Enter the password:");
        String password = sc.next().trim();
        System.out.println("Confirm password:");
        String reEnteredPassword = sc.next().trim();

        if(!password.equals(reEnteredPassword)){
            System.out.println("password mismatch. Register again..");
            register();
            return;
        }
        User newUser = new User(username,password);
        users.add(newUser);
        login();
    }


    public void displayMenu(){
        while(true){
            System.out.println("Welcome user\n\nPlease select your option:");

            System.out.println("1.Create a Post\n2.List all posts\n3.Add comment for a post\n4. View post\n5. View comments of a post\n6. Upvote/Downvote a comment\n7. View upvotes and downvotes of a post\n8. Upvote/Downvote a post\n9. View upovotes and downvotes of a comment in a post");
            int options = sc.nextInt();

            switch (options){
                case 1:{
                    createPost();
                    break;
                }
                case 2: {
                    displayPosts();
                    break;
                }
                case 3: {
                    addCommentToPost();
                    break;
                }
                case 4:{
                    viewPost();
                    break;
                }
                case 5:{
                    System.out.println("Enter post title to view comments");
                    String postName = sc.nextLine();
                    Post currPost = getPostByPostName(postName);
                    viewComments(currPost);
                    break;

                }
                case 6:{
                    System.out.println("Enter the postname for voting a particular comment:");
                    Post votingPost = getPostByPostName(sc.nextLine());
                    System.out.println("Enter the username for who you want to vote");
                    User commentedUser = getUserByUsername(sc.nextLine());

                    votingComment();

                }
                default:{
                    return;
                }
            }

        }


    }
}
