# Quick Start Guide

## Running the Application

### Option 1: Using Maven Command Line
```bash
cd "c:\Users\HP\Desktop\Springboot\SPRINGBOOT 2"
mvn spring-boot:run
```

### Option 2: Using IDE (IntelliJ IDEA / Eclipse / VS Code)
1. Open the project folder in your IDE
2. Wait for Maven dependencies to download
3. Run `RestfulApiApplication.java` main class
4. Application will start on port 8080

## Testing the APIs

### Using Browser (for GET requests only)
- Open browser and navigate to: `http://localhost:8080/api/books`
- Try other GET endpoints from README.md

### Using Postman (Recommended)
1. Open Postman
2. Import `Postman_Collection.json` file
3. All endpoints are pre-configured
4. Click on any request and click "Send"

### Using cURL (Command Line)
```bash
# Get all books
curl http://localhost:8080/api/books

# Add a new book
curl -X POST http://localhost:8080/api/books ^
  -H "Content-Type: application/json" ^
  -d "{\"title\":\"Test Book\",\"author\":\"Test Author\",\"isbn\":\"123456\",\"publicationYear\":2024}"

# Get all students
curl http://localhost:8080/api/students

# Filter students by GPA
curl "http://localhost:8080/api/students/filter?gpa=3.5"
```

## Sample Test Scenarios

### Question 1: Library API
1. GET all books → Should return 3 books
2. POST new book → Should return 201 Created
3. GET book by ID → Should return specific book
4. Search by title "clean" → Should find "Clean Code"
5. DELETE book → Should return 204 No Content

### Question 2: Student API
1. GET all students → Should return 5 students
2. GET students by major "Computer Science" → Should return 3 students
3. Filter by GPA >= 3.5 → Should return 4 students
4. POST new student → Should return 201 Created
5. PUT update student → Should return 200 OK

### Question 3: Restaurant Menu API
1. GET all menu items → Should return 8 items
2. GET by category "Appetizer" → Should return 2 items
3. GET available items → Should return 7 items
4. Search by name "chicken" → Should find "Grilled Chicken"
5. Toggle availability → Should change available status

### Question 4: E-Commerce Product API
1. GET all products → Should return 10 products
2. GET with pagination ?page=0&limit=5 → Should return 5 products
3. GET by category "Electronics" → Should return 6 products
4. GET by brand "Apple" → Should return 2 products
5. Search keyword "phone" → Should return 2 products
6. Price range ?min=100&max=500 → Should return filtered products
7. GET in-stock products → Should return 9 products (1 out of stock)
8. PATCH update stock → Should update quantity

### Question 5: Task Management API
1. POST create task → Should return 201 Created
2. GET all tasks → Should return created tasks
3. GET by status ?completed=false → Should return incomplete tasks
4. GET by priority "HIGH" → Should return high priority tasks
5. PATCH mark as complete → Should set completed=true

### Bonus: User Profile API
1. POST create user → Should return wrapped response
2. GET all users → Should return ApiResponse with data
3. Search by username → Should return matching users
4. Search by country → Should return users from that country
5. Search by age range → Should return users in range
6. PATCH activate/deactivate → Should toggle active status

## Troubleshooting

### Port Already in Use
If port 8080 is already in use, change it in `application.properties`:
```properties
server.port=8081
```

### Maven Dependencies Not Downloading
```bash
mvn clean install
```

### Application Not Starting
1. Check Java version: `java -version` (should be 17+)
2. Check Maven version: `mvn -version`
3. Verify pom.xml is present
4. Check console for error messages

## Git Submission

### Create and Push Branch
```bash
# Initialize git (if not already done)
git init

# Add all files
git add .

# Commit
git commit -m "Complete RESTful API assignment"

# Create branch (replace STUDENT_ID with your actual student ID)
git checkout -b restFull_api_STUDENT_ID

# Push to remote
git push origin restFull_api_STUDENT_ID
```

## Verification Checklist
- [ ] Application starts without errors
- [ ] All 6 question packages are present
- [ ] All endpoints return correct status codes
- [ ] POST requests create new resources
- [ ] PUT/PATCH requests update resources
- [ ] DELETE requests remove resources
- [ ] Search and filter endpoints work correctly
- [ ] README.md is complete
- [ ] Postman collection is included
- [ ] Code follows naming conventions
- [ ] All files are properly organized

## Contact
If you encounter any issues, refer to the README.md for detailed endpoint documentation.

Good luck with your assignment!
