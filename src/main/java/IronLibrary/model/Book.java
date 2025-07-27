package IronLibrary.model;

public class Book {
private String isbn;
private String title;
private String category;
private int quantity;
private Author author;
//referencia al autor en la clase book ya que tienen relacion
// 1:1 y facilita la busqueda por autor (no obligatorio)

    public Book(String isbn, String title, String category, int quantity, Author author) {
        setIsbn(isbn);
        setTitle(title);
        setCategory(category);
        setQuantity(quantity);
        setAuthor(author);
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
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null.");
        }
        this.author = author;
    }

    //reducir cantidad al retirar un libro
    public boolean issueBook() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }

    //añado una excepcion si no hay libros disponibles
    public void issueBookOrThrow() {
        if (quantity <= 0) {
            throw new IllegalStateException("No copies of \"" + title + "\" available to issue.");
        }
        quantity--;
    }

    //incrementar cantidad al devolver un libro
    public void returnBook() {
        quantity++;
    }



    //facilitar debug e impresion de libros
    @Override
    public String toString() {
        return String.format("%-22s %-20s %-12s %-10d %-20s %-30s",
                isbn,
                title,
                category,
                quantity,
                author != null ? author.getName() : "N/A",
                author != null ? author.getEmail() : "N/A");
    }
}
// getName y getEmail vendran de la clase Author, cuando se haga
// el merge se tienen que hacer las importaciones.