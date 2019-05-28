package models;

public class Note {
    private String title;
    private String author;
    private String message;
    //private int vek;
    //private boolean isDeleted;
    //private List<String> hashTags;

    public Note(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getMessage(){
        return message;
    }
}
