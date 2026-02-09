# Blog Application

A Java-based console application for managing a simple blogging system with user authentication, post creation, and community engagement features.

## Features

- **User Authentication**: Login and register functionality for users
- **Post Management**: Create and manage blog posts
- **Commenting System**: Add comments to posts (when enabled by the author)
- **Voting System**: Upvote or downvote posts and comments to show community engagement
- **User Profiles**: Unique user identity with usernames and passwords

## Project Structure

```
BlogApplication/
├── src/
│   ├── Main.java          # Entry point - provides CLI menu
│   ├── BlogSystem.java    # Core system managing users, posts, and voting
│   ├── User.java          # User entity with authentication
│   ├── Post.java          # Blog post entity with metadata
│   └── Comment.java       # Comment entity for posts
└── README.md              # This file
```

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal

### Compilation
```bash
cd src
javac *.java
```

### Running the Application
```bash
java Main
```

## Usage

1. **Start the Application**: Run the Main class
2. **Main Menu Options**:
   - **1. Login**: Enter an existing username and password to access your account
   - **2. Register**: Create a new account with a username and password
   - **3. Exit**: Close the application

3. **Post Operations** (after login):
   - Create new blog posts
   - View existing posts
   - Vote on posts

4. **Comment Operations** (if enabled):
   - Add comments to posts that allow comments
   - Vote on comments

## Class Descriptions

### Main.java
Provides the main entry point and user interface menu. Handles user input and navigation through the application.

### BlogSystem.java
Core business logic class that manages:
- User registration and authentication
- Post creation and retrieval
- Voting mechanisms for posts and comments
- Comment management

### User.java
Represents a user account with:
- Unique user ID (auto-incremented)
- Username and password for authentication

### Post.java
Represents a blog post containing:
- Post title and content
- Author information
- Upvote and downvote counts
- Comments (optional, based on author preference)

### Comment.java
Represents a comment on a post with:
- Comment author and content
- Associated post reference
- Upvote and downvote counts

## Technical Details

- **Data Structure**: Uses HashSet for users and posts, HashMap for comments
- **Security**: Basic username/password authentication (for educational purposes)
- **User Input**: Handled via Scanner for command-line interface

## Future Enhancements

- Persistent storage (database integration)
- User authentication with encryption
- Search and filter functionality
- Post editing and deletion
- Timestamp tracking for posts and comments
- User profiles with bio information

## Notes

This is an educational project demonstrating core object-oriented programming concepts in Java, including encapsulation, collections, and user interaction patterns.
