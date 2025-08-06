# IronLibrary
[![Ask DeepWiki](https://devin.ai/assets/askdeepwiki.png)](https://deepwiki.com/Carol-88/IronLibrary)

IronLibrary is a command-line library management system built with Java. It provides essential functionalities for managing books, students, and lending records through a simple console interface. All data is persisted using CSV files, making it a lightweight and portable application.

## Features

-   **Add Books**: Add new books to the library catalogue, specifying ISBN, title, category, quantity, and author details.
-   **Add Students**: Register new students with a unique USN (University Serial Number) and name.
-   **Search**: Find books in the catalogue by title, category, or author.
-   **Issue Books**: Lend books to registered students. The system automatically records the issue date and calculates a return date (7 days from issue).
-   **View Records**:
    -   List all books available in the library along with their authors.
    -   List all books currently checked out by a specific student.

## Getting Started

### Prerequisites

-   Java Development Kit (JDK) 17 or higher
-   Apache Maven

### Running the Application

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/carol-88/IronLibrary.git
    ```

2.  **Navigate to the project directory:**
    ```sh
    cd IronLibrary
    ```

3.  **Compile the project using Maven:**
    ```sh
    mvn compile
    ```

4.  **Run the application:**
    ```sh
    mvn exec:java -Dexec.mainClass="IronLibrary.Main"
    ```

Once running, the application will display a menu of options in the console.

## Data Management

The application uses CSV files to store and retrieve data. These files are located in `src/main/java/IronLibrary/csv/`:

-   `books.csv`: Contains the list of all books, including their ISBN, title, category, quantity, and author information.
-   `students.csv`: A registry of all students, containing their USN and name.
-   `issues.csv`: A log of all lending transactions, linking a student's USN to a book's ISBN, along with the issue and return dates.

## Project Structure

The project is organized into several packages to separate concerns:

```
└── IronLibrary/
    ├── pom.xml                     # Maven project configuration
    └── src/main/java/IronLibrary/
        ├── Main.java                 # Application entry point
        ├── csv/
        │   ├── books.csv             # Database for books
        │   ├── issues.csv            # Database for book loans
        │   └── students.csv          # Database for students
        ├── menu/
        │   └── LibraryMenu.java      # Handles console menu display and input
        ├── model/
        │   ├── Author.java           # Data model for authors
        │   ├── Book.java             # Data model for books
        │   ├── Issue.java            # Data model for lending records
        │   └── Student.java          # Data model for students
        └── utils/
            ├── Choices.java          # Implements the logic for menu choices
            ├── Prints.java           # Formatted console output methods
            └── Utils.java            # Helper functions for CSV operations and searches
```
## Team Members

###

<div align="left">
  <img height="100" src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExZHAxazJtZGdoNXFha2RqdnJ6emRyeGZ2YjNob2FnYmdsdDVlZDB4NyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Brdlc8ulgB5Vk5mAhL/giphy.gif"  />
    <a href:"https://github.com/AidaG91">AidaG91</a>
</div>

###

<div align="left">
  <img height="100" src="https://media.giphy.com/media/v1.Y2lkPWVjZjA1ZTQ3eHc3bnRxZnJ3eDJvamduM2xicmV3d3c0YXZ2cWs5MG5nZ3phdzM3NiZlcD12MV9naWZzX3NlYXJjaCZjdD1n/Y01jP8QeLOox2/giphy.gif"  />
    <a href:"https://github.com/krub-dev>krub-dev</a>
</div>

###

<div align="left">
  <img height="100" src="https://i.imgflip.com/65efzo.gif"  />
    <a href:"https://github.com/Lucintheskies">Lucintheskies</a>
</div>

###

<div align="left">
  <img height="100" src="https://media.giphy.com/media/v1.Y2lkPWVjZjA1ZTQ3eHc3bnRxZnJ3eDJvamduM2xicmV3d3c0YXZ2cWs5MG5nZ3phdzM3NiZlcD12MV9naWZzX3NlYXJjaCZjdD1n/jAe22Ec5iICCk/giphy.gif"  />
    <a href"https://github.com/Carol-88">Carol-88</a>
</div>

###
