package IronLibrary.model;

public class Book {
private String isbn;
private String title;
private String category;
public int quantity;

    public Book(String isbn, String title, String category, int quantity) {
        setIsbn(isbn);
        setTitle(title);
        setCategory(category);
        setQuantity(quantity);
    } //comprobaciones con los setters desde el constructor, asi se aplican validaciones al crear el objeto

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty.");
        }
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    //evitar cantidades negativas
    public int setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        return this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    //facilitar debug e impresion de libros
    @Override
    public String toString() {
        return String.format("%-22s %-20s %-12s %-10d",
                isbn,
                title,
                category,
                quantity);
    }
}
