# Spring Boot RESTful API Assignment

This project contains 6 RESTful APIs (5 main questions + 1 bonus) built with Spring Boot.

## Prerequisites
- Java 17 or higher
- Maven 3.6+
- Postman (for testing)

## How to Run
1. Navigate to project directory
2. Run: `mvn spring-boot:run`
3. Application starts on: `http://localhost:8080`

## Project Structure
```
src/main/java/com/restapi/
├── RestfulApiApplication.java (Main class)
├── controller/
│   ├── library/BookController.java
│   ├── student/StudentController.java
│   ├── restaurant/MenuController.java
│   ├── ecommerce/ProductController.java
│   ├── task/TaskController.java
│   └── user/UserProfileController.java
└── model/
    ├── library/Book.java
    ├── student/Student.java
    ├── restaurant/MenuItem.java
    ├── ecommerce/Product.java
    ├── task/Task.java
    ├── user/UserProfile.java
    └── user/ApiResponse.java
```

---

## Question 1: Library Book Management API

### Endpoints

#### 1. Get All Books
- **URL**: `GET /api/books`
- **Response**: 200 OK
```json
[
  {
    "id": 1,
    "title": "Inyigisho z'Ubuntu",
    "author": "Uwase Aline",
    "isbn": "978-0132350884",
    "publicationYear": 2020
  }
]
```

#### 2. Get Book by ID
- **URL**: `GET /api/books/{id}`
- **Example**: `GET /api/books/1`
- **Response**: 200 OK / 404 Not Found

#### 3. Search Books by Title
- **URL**: `GET /api/books/search?title={title}`
- **Example**: `GET /api/books/search?title=ubuntu`
- **Response**: 200 OK / 404 Not Found

#### 4. Add New Book
- **URL**: `POST /api/books`
- **Request Body**:
```json
{
  "title": "Kinyarwanda Grammar",
  "author": "Mugabo Eric",
  "isbn": "978-0201633610",
  "publicationYear": 2022
}
```
- **Response**: 201 Created

#### 5. Delete Book
- **URL**: `DELETE /api/books/{id}`
- **Response**: 204 No Content / 404 Not Found

---

## Question 2: Student Registration API

### Endpoints

#### 1. Get All Students
- **URL**: `GET /api/students`
- **Response**: 200 OK

#### 2. Get Student by ID
- **URL**: `GET /api/students/{studentId}`
- **Example**: `GET /api/students/1`
- **Response**: 200 OK / 404 Not Found

#### 3. Get Students by Major
- **URL**: `GET /api/students/major/{major}`
- **Example**: `GET /api/students/major/Computer Science`
- **Response**: 200 OK

#### 4. Filter Students by GPA
- **URL**: `GET /api/students/filter?gpa={minGpa}`
- **Example**: `GET /api/students/filter?gpa=3.5`
- **Response**: 200 OK

#### 5. Register New Student
- **URL**: `POST /api/students`
- **Request Body**:
```json
{
  "firstName": "Ishimwe",
  "lastName": "Grace",
  "email": "ishimwe.grace@ur.ac.rw",
  "major": "Computer Science",
  "gpa": 3.7
}
```
- **Response**: 201 Created

#### 6. Update Student
- **URL**: `PUT /api/students/{studentId}`
- **Request Body**: Same as POST
- **Response**: 200 OK / 404 Not Found

---

## Question 3: Restaurant Menu API

### Endpoints

#### 1. Get All Menu Items
- **URL**: `GET /api/menu`
- **Response**: 200 OK

#### 2. Get Menu Item by ID
- **URL**: `GET /api/menu/{id}`
- **Response**: 200 OK / 404 Not Found

#### 3. Get Items by Category
- **URL**: `GET /api/menu/category/{category}`
- **Example**: `GET /api/menu/category/Appetizer`
- **Response**: 200 OK

#### 4. Get Available Items
- **URL**: `GET /api/menu/available?available=true`
- **Response**: 200 OK

#### 5. Search Menu Items
- **URL**: `GET /api/menu/search?name={name}`
- **Example**: `GET /api/menu/search?name=isombe`
- **Response**: 200 OK / 404 Not Found

#### 6. Add Menu Item
- **URL**: `POST /api/menu`
- **Request Body**:
```json
{
  "name": "Ubugali",
  "description": "Traditional cassava dish",
  "price": 2500.0,
  "category": "Main Course",
  "available": true
}
```
- **Response**: 201 Created

#### 7. Toggle Availability
- **URL**: `PUT /api/menu/{id}/availability`
- **Response**: 200 OK / 404 Not Found

#### 8. Delete Menu Item
- **URL**: `DELETE /api/menu/{id}`
- **Response**: 204 No Content / 404 Not Found

---

## Question 4: E-Commerce Product API

### Endpoints

#### 1. Get All Products (with pagination)
- **URL**: `GET /api/products`
- **With Pagination**: `GET /api/products?page=0&limit=5`
- **Response**: 200 OK

#### 2. Get Product by ID
- **URL**: `GET /api/products/{productId}`
- **Response**: 200 OK / 404 Not Found

#### 3. Get Products by Category
- **URL**: `GET /api/products/category/{category}`
- **Example**: `GET /api/products/category/Electronics`
- **Response**: 200 OK

#### 4. Get Products by Brand
- **URL**: `GET /api/products/brand/{brand}`
- **Example**: `GET /api/products/brand/Apple`
- **Response**: 200 OK

#### 5. Search Products
- **URL**: `GET /api/products/search?keyword={keyword}`
- **Example**: `GET /api/products/search?keyword=tecno`
- **Response**: 200 OK

#### 6. Get Products by Price Range
- **URL**: `GET /api/products/price-range?min={min}&max={max}`
- **Example**: `GET /api/products/price-range?min=50000&max=200000`
- **Response**: 200 OK

#### 7. Get In-Stock Products
- **URL**: `GET /api/products/in-stock`
- **Response**: 200 OK

#### 8. Add Product
- **URL**: `POST /api/products`
- **Request Body**:
```json
{
  "name": "Samsung Tablet",
  "description": "Android tablet device",
  "price": 350000.0,
  "category": "Electronics",
  "stockQuantity": 25,
  "brand": "Samsung"
}
```
- **Response**: 201 Created

#### 9. Update Product
- **URL**: `PUT /api/products/{productId}`
- **Request Body**: Same as POST
- **Response**: 200 OK / 404 Not Found

#### 10. Update Stock Quantity
- **URL**: `PATCH /api/products/{productId}/stock?quantity={quantity}`
- **Example**: `PATCH /api/products/1/stock?quantity=75`
- **Response**: 200 OK / 404 Not Found

#### 11. Delete Product
- **URL**: `DELETE /api/products/{productId}`
- **Response**: 204 No Content / 404 Not Found

---

## Question 5: Task Management API

### Endpoints

#### 1. Get All Tasks
- **URL**: `GET /api/tasks`
- **Response**: 200 OK

#### 2. Get Task by ID
- **URL**: `GET /api/tasks/{taskId}`
- **Response**: 200 OK / 404 Not Found

#### 3. Get Tasks by Status
- **URL**: `GET /api/tasks/status?completed={true/false}`
- **Example**: `GET /api/tasks/status?completed=false`
- **Response**: 200 OK

#### 4. Get Tasks by Priority
- **URL**: `GET /api/tasks/priority/{priority}`
- **Example**: `GET /api/tasks/priority/HIGH`
- **Response**: 200 OK

#### 5. Create Task
- **URL**: `POST /api/tasks`
- **Request Body**:
```json
{
  "title": "Gusoma ibitabo",
  "description": "Read Kinyarwanda literature books",
  "completed": false,
  "priority": "HIGH",
  "dueDate": "2024-12-31"
}
```
- **Response**: 201 Created

#### 6. Update Task
- **URL**: `PUT /api/tasks/{taskId}`
- **Request Body**: Same as POST
- **Response**: 200 OK / 404 Not Found

#### 7. Mark Task as Completed
- **URL**: `PATCH /api/tasks/{taskId}/complete`
- **Response**: 200 OK / 404 Not Found

#### 8. Delete Task
- **URL**: `DELETE /api/tasks/{taskId}`
- **Response**: 204 No Content / 404 Not Found

---

## Bonus Question: User Profile API

### Endpoints

#### 1. Get All Users
- **URL**: `GET /api/users`
- **Response**: 200 OK
```json
{
  "success": true,
  "message": "Users retrieved successfully",
  "data": []
}
```

#### 2. Get User by ID
- **URL**: `GET /api/users/{userId}`
- **Response**: 200 OK / 404 Not Found

#### 3. Search by Username
- **URL**: `GET /api/users/search/username?username={username}`
- **Response**: 200 OK

#### 4. Search by Country
- **URL**: `GET /api/users/search/country?country={country}`
- **Response**: 200 OK

#### 5. Search by Age Range
- **URL**: `GET /api/users/search/age-range?min={min}&max={max}`
- **Example**: `GET /api/users/search/age-range?min=20&max=30`
- **Response**: 200 OK

#### 6. Create User
- **URL**: `POST /api/users`
- **Request Body**:
```json
{
  "username": "niyonzima",
  "email": "niyonzima@email.rw",
  "fullName": "Niyonzima Patrick",
  "age": 25,
  "country": "Rwanda",
  "bio": "Software developer from Kigali",
  "active": true
}
```
- **Response**: 201 Created

#### 7. Update User
- **URL**: `PUT /api/users/{userId}`
- **Request Body**: Same as POST
- **Response**: 200 OK / 404 Not Found

#### 8. Activate User
- **URL**: `PATCH /api/users/{userId}/activate`
- **Response**: 200 OK / 404 Not Found

#### 9. Deactivate User
- **URL**: `PATCH /api/users/{userId}/deactivate`
- **Response**: 200 OK / 404 Not Found

#### 10. Delete User
- **URL**: `DELETE /api/users/{userId}`
- **Response**: 200 OK / 404 Not Found

---

## HTTP Status Codes Used
- **200 OK**: Successful GET, PUT, PATCH requests
- **201 Created**: Successful POST requests
- **204 No Content**: Successful DELETE requests
- **404 Not Found**: Resource not found

## Testing with Postman
1. Import the endpoints into Postman
2. Set base URL: `http://localhost:8080`
3. Test each endpoint with sample data
4. Verify response status codes and data

## Notes
- All data is stored in-memory (List/ArrayList)
- Data resets when application restarts
- No database or service layer required
- Focus on REST controller implementation only
