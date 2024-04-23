package dw.gameshop.model;


import jakarta.persistence.*;

@Entity
@Table (name = "games")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", length = 100, nullable = false)
    private String title;
    @Column(name = "genre", length = 100, nullable = false)
    private String genre;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "image", length = 65535)
    private String image;
    @Column(name = "text", length = 65535)
    private String text;

    public Games() {
    }

    public Games(long id, String tile, String genre, int price, String image, String text) {
        this.id = id;
        this.title = tile;
        this.genre = genre;
        this.price = price;
        this.image = image;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTile() {
        return title;
    }

    public void setTile(String tile) {
        this.title = tile;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
