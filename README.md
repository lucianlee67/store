1. Create database 
    ```sql 
    CREATE DATABASE bookstore;
    
    USE bookstore;
    
    CREATE TABLE authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthday DATE
    );
    
    CREATE TABLE books (
    isbn VARCHAR(13) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    year INT,
    price DECIMAL(10, 2),
    genre VARCHAR(255)
    );
    
    CREATE TABLE book_authors (
    book_isbn VARCHAR(13),
    author_id INT,
    PRIMARY KEY (book_isbn, author_id),
    FOREIGN KEY (book_isbn) REFERENCES books(isbn),
    FOREIGN KEY (author_id) REFERENCES authors(id)
    );

2. CHANGE DATABASE CONNECTION CONFIG in APPLICATION.YML

3. APIS
     ```text 
    ADD REQUEST
    POST localhost:8001/book/add
    BODY
       {
           "isbn": "1234567890",
           "title": "Book Title",
           "year": 2023,
           "price": 19.99,
           "genre": "Fiction",
           "authors": [
               {
                   "id": "1",
                   "name": "Author One",
                   "birthday": "2000-01-01"
               },
               {
                   "id": "2",
                   "name": "Author Two",
                   "birthday": "1995-05-15"
               }
           ]
       }
    
    UPDATE REQUEST
    PUT localhost:8001/book/update
    BODY
    {
        "isbn": "1234567890",
        "title": "Book Title",
        "year": 2023,
        "price": 19.99,
        "genre": "Fiction",
        "authors": [
            {
                "id": "1",
                "name": "Author One",
                "birthday": "2000-01-01"
            },
            {
                "id": "2",
                "name": "Author Two",
                "birthday": "1995-05-15"
            }
        ]
    }'
    
    DELETE REQUEST 
    DELETE localhost:8001/book/del/{isbn}

    GET REQUEST WITH TITLE 
    GET localhost:8001/book/get/title/{title}

