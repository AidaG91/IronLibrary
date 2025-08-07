# IronLibrary
[![Ask DeepWiki](https://devin.ai/assets/askdeepwiki.png)](https://deepwiki.com/Carol-88/IronLibrary)

IronLibrary is a command-line library management system built with Java. It provides essential functionalities for managing books, students, and lending records through a simple console interface. All data is persisted using CSV files, making it a lightweight and portable application.

[Canva presentation](https://www.canva.com/design/DAGvBTHpIj0/pHdhT1a4oEAZA7MYU-sqFA/edit?utm_content=DAGvBTHpIj0&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

## Features

-   **Add Books**: Add new books to the library catalogue, specifying ISBN, title, category, quantity, and author details.
-   **Add Students**: Register new students with a unique USN (University Serial Number) and name.
-   **Search**: Find books in the catalogue by title, category, or author.
-   **Issue Books**: Lend books to registered students. The system automatically records the issue date and calculates a return date (7 days from issue).
-   **Return Books**: Mark books as returned, updating both the lending record and the book's availability. 
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
IronLibrary/
├── README.md                               # About the project and how to use it
├── pom.xml                                 # Maven project configuration
└── src/
    ├── main/
    │   └── java/
    │       └── IronLibrary/
    │           ├── assets/
    │           │   ├── Colors.java         # Contains color codes for console output
    │           │   └── Emojis.java         # Contains emoji constants for console output
    │           ├── csv/
    │           │   ├── books.csv           # Database for books
    │           │   ├── issues.csv          # Database for book loans
    │           │   └── students.csv        # Database for students
    │           ├── Main.java               # Application entry point
    │           ├── menu/
    │           │   └── LibraryMenu.java    # Handles console menu display and input
    │           ├── model/
    │           │   ├── Author.java         # Data model for authors
    │           │   ├── Book.java           # Data model for books
    │           │   ├── Issue.java          # Data model for lending records
    │           │   └── Student.java        # Data model for students
    │           └── utils/
    │               ├── Choices.java        # Implements the logic for menu choices
    │               ├── Prints.java         # Formatted console output methods
    │               └── Utils.java          # Helper functions for CSV operations and searches
    │
    └── test/
        └── java/
            └── IronLibrary/
                ├── model/
                │   └── IssueTest.java          # Unit tests for lending records logic
                └── utils/
                    └── ChoicesTest.java        # Unit tests for menu choices logic

```
## Team Members

| <a href="https://github.com/AidaG91"><img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExZHAxazJtZGdoNXFha2RqdnJ6emRyeGZ2YjNob2FnYmdsdDVlZDB4NyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Brdlc8ulgB5Vk5mAhL/giphy.gif" width="150"/></a> | <a href="https://github.com/krub-dev"><img src="https://iili.io/FPL1Cba.gif" width="150"/></a> | <a href="https://github.com/Lucintheskies"><img src="https://i.imgflip.com/65efzo.gif" width="150"/></a> | <a href="https://github.com/Carol-88"><img src="https://i.giphy.com/EtL0qcnsplmMu169zO.webp" width="150"/></a> |
| :---: | :---: | :---: | :---: |
| [AidaG91](https://github.com/AidaG91) | [krub-dev](https://github.com/krub-dev) | [Lucintheskies](https://github.com/Lucintheskies) | [Carol-88](https://github.com/Carol-88) |
