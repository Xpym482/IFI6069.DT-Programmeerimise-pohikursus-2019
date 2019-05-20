package exam.exam;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

enum Category {
    politics, education, culture, entertainment
}

@Entity
class TextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String author;

    private String title;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(length = 1200)
    private String text;

    public TextEntity() {
    }

    public TextEntity(String author, String title, Category category, String text) {
        this.author = author;
        this.title = title;
        this.category = category;
        this.text = text;
    }

    public HashMap<String, String> toJSON() {
        HashMap<String, String> json = new HashMap<>();
        json.put("author", this.author);
        json.put("title", this.title);
        json.put("category", this.category.toString());
        json.put("text", this.text);
        return json;
    }

    @Override
    public String toString() {
        return "{" + " author='" + getAuthor() + "'" + ", title='" + getTitle() + "'" + ", category='" + getCategory()
                + "'" + ", text='" + getText() + "'" + "}";
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}