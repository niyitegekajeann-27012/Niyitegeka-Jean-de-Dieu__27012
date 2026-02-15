# Testing Checklist

Use this checklist to verify all endpoints are working correctly before submission.

## Question 1: Library Book Management API ✅

### GET Endpoints
- [ ] GET /api/books → Returns 3 books (200 OK)
- [ ] GET /api/books/1 → Returns specific book (200 OK)
- [ ] GET /api/books/999 → Returns 404 Not Found
- [ ] GET /api/books/search?title=clean → Returns Clean Code book (200 OK)
- [ ] GET /api/books/search?title=xyz → Returns 404 Not Found

### POST Endpoints
- [ ] POST /api/books → Creates new book (201 Created)
- [ ] Verify new book has auto-generated ID

### DELETE Endpoints
- [ ] DELETE /api/books/1 → Deletes book (204 No Content)
- [ ] DELETE /api/books/999 → Returns 404 Not Found

---

## Question 2: Student Registration API ✅

### GET Endpoints
- [ ] GET /api/students → Returns 5 students (200 OK)
- [ ] GET /api/students/1 → Returns specific student (200 OK)
- [ ] GET /api/students/999 → Returns 404 Not Found
- [ ] GET /api/students/major/Computer Science → Returns 3 students (200 OK)
- [ ] GET /api/students/major/Business → Returns 1 student (200 OK)
- [ ] GET /api/students/filter?gpa=3.5 → Returns 4 students with GPA >= 3.5 (200 OK)
- [ ] GET /api/students/filter?gpa=4.0 → Returns 0 students (200 OK)

### POST Endpoints
- [ ] POST /api/students → Creates new student (201 Created)
- [ ] Verify new student has auto-generated ID

### PUT Endpoints
- [ ] PUT /api/students/1 → Updates student (200 OK)
- [ ] PUT /api/students/999 → Returns 404 Not Found

---

## Question 3: Restaurant Menu API ✅

### GET Endpoints
- [ ] GET /api/menu → Returns 8 menu items (200 OK)
- [ ] GET /api/menu/1 → Returns specific item (200 OK)
- [ ] GET /api/menu/999 → Returns 404 Not Found
- [ ] GET /api/menu/category/Appetizer → Returns 2 items (200 OK)
- [ ] GET /api/menu/category/Main Course → Returns 3 items (200 OK)
- [ ] GET /api/menu/category/Dessert → Returns 2 items (200 OK)
- [ ] GET /api/menu/category/Beverage → Returns 1 item (200 OK)
- [ ] GET /api/menu/available?available=true → Returns 7 available items (200 OK)
- [ ] GET /api/menu/available?available=false → Returns 1 unavailable item (200 OK)
- [ ] GET /api/menu/search?name=chicken → Returns Grilled Chicken (200 OK)
- [ ] GET /api/menu/search?name=xyz → Returns 404 Not Found

### POST Endpoints
- [ ] POST /api/menu → Creates new menu item (201 Created)

### PUT Endpoints
- [ ] PUT /api/menu/1/availability → Toggles availability (200 OK)
- [ ] PUT /api/menu/999/availability → Returns 404 Not Found

### DELETE Endpoints
- [ ] DELETE /api/menu/1 → Deletes item (204 No Content)
- [ ] DELETE /api/menu/999 → Returns 404 Not Found

---

## Question 4: E-Commerce Product API ✅

### GET Endpoints
- [ ] GET /api/products → Returns 10 products (200 OK)
- [ ] GET /api/products?page=0&limit=5 → Returns first 5 products (200 OK)
- [ ] GET /api/products?page=1&limit=5 → Returns next 5 products (200 OK)
- [ ] GET /api/products?page=10&limit=5 → Returns empty array (200 OK)
- [ ] GET /api/products/1 → Returns specific product (200 OK)
- [ ] GET /api/products/999 → Returns 404 Not Found
- [ ] GET /api/products/category/Electronics → Returns 6 products (200 OK)
- [ ] GET /api/products/category/Footwear → Returns 2 products (200 OK)
- [ ] GET /api/products/category/Clothing → Returns 2 products (200 OK)
- [ ] GET /api/products/brand/Apple → Returns 2 products (200 OK)
- [ ] GET /api/products/brand/Nike → Returns 1 product (200 OK)
- [ ] GET /api/products/search?keyword=phone → Returns 2 products (200 OK)
- [ ] GET /api/products/search?keyword=laptop → Returns 1 product (200 OK)
- [ ] GET /api/products/price-range?min=100&max=500 → Returns filtered products (200 OK)
- [ ] GET /api/products/price-range?min=0&max=50 → Returns products under $50 (200 OK)
- [ ] GET /api/products/in-stock → Returns 9 products (200 OK)

### POST Endpoints
- [ ] POST /api/products → Creates new product (201 Created)

### PUT Endpoints
- [ ] PUT /api/products/1 → Updates product (200 OK)
- [ ] PUT /api/products/999 → Returns 404 Not Found

### PATCH Endpoints
- [ ] PATCH /api/products/1/stock?quantity=100 → Updates stock (200 OK)
- [ ] PATCH /api/products/999/stock?quantity=50 → Returns 404 Not Found

### DELETE Endpoints
- [ ] DELETE /api/products/1 → Deletes product (204 No Content)
- [ ] DELETE /api/products/999 → Returns 404 Not Found

---

## Question 5: Task Management API ✅

### Initial Setup
- [ ] Create 3 sample tasks using POST endpoint first

### GET Endpoints
- [ ] GET /api/tasks → Returns all tasks (200 OK)
- [ ] GET /api/tasks/1 → Returns specific task (200 OK)
- [ ] GET /api/tasks/999 → Returns 404 Not Found
- [ ] GET /api/tasks/status?completed=false → Returns incomplete tasks (200 OK)
- [ ] GET /api/tasks/status?completed=true → Returns completed tasks (200 OK)
- [ ] GET /api/tasks/priority/HIGH → Returns high priority tasks (200 OK)
- [ ] GET /api/tasks/priority/MEDIUM → Returns medium priority tasks (200 OK)
- [ ] GET /api/tasks/priority/LOW → Returns low priority tasks (200 OK)

### POST Endpoints
- [ ] POST /api/tasks → Creates new task (201 Created)
- [ ] Verify task has completed=false by default

### PUT Endpoints
- [ ] PUT /api/tasks/1 → Updates task (200 OK)
- [ ] PUT /api/tasks/999 → Returns 404 Not Found

### PATCH Endpoints
- [ ] PATCH /api/tasks/1/complete → Marks task as completed (200 OK)
- [ ] Verify task.completed is now true
- [ ] PATCH /api/tasks/999/complete → Returns 404 Not Found

### DELETE Endpoints
- [ ] DELETE /api/tasks/1 → Deletes task (204 No Content)
- [ ] DELETE /api/tasks/999 → Returns 404 Not Found

---

## Bonus: User Profile API ✅

### Initial Setup
- [ ] Create 2-3 sample users using POST endpoint first

### GET Endpoints
- [ ] GET /api/users → Returns ApiResponse with users array (200 OK)
- [ ] Verify response has success, message, and data fields
- [ ] GET /api/users/1 → Returns ApiResponse with user (200 OK)
- [ ] GET /api/users/999 → Returns ApiResponse with success=false (404 Not Found)
- [ ] GET /api/users/search/username?username=john → Returns matching users (200 OK)
- [ ] GET /api/users/search/country?country=USA → Returns users from USA (200 OK)
- [ ] GET /api/users/search/age-range?min=20&max=30 → Returns users in range (200 OK)

### POST Endpoints
- [ ] POST /api/users → Creates new user (201 Created)
- [ ] Verify response is wrapped in ApiResponse
- [ ] Verify success=true and message="User created successfully"

### PUT Endpoints
- [ ] PUT /api/users/1 → Updates user (200 OK)
- [ ] Verify response is wrapped in ApiResponse
- [ ] PUT /api/users/999 → Returns ApiResponse with success=false (404 Not Found)

### PATCH Endpoints
- [ ] PATCH /api/users/1/activate → Activates user (200 OK)
- [ ] Verify user.active is now true
- [ ] PATCH /api/users/1/deactivate → Deactivates user (200 OK)
- [ ] Verify user.active is now false
- [ ] PATCH /api/users/999/activate → Returns 404 Not Found

### DELETE Endpoints
- [ ] DELETE /api/users/1 → Deletes user (200 OK)
- [ ] Verify response is wrapped in ApiResponse
- [ ] DELETE /api/users/999 → Returns 404 Not Found

---

## General Verification ✅

### Application
- [ ] Application starts without errors
- [ ] Port 8080 is accessible
- [ ] No compilation errors
- [ ] All dependencies downloaded

### Code Quality
- [ ] All files follow naming conventions
- [ ] Proper package structure (controller/model with sub-packages)
- [ ] Code is properly indented
- [ ] No unused imports
- [ ] Meaningful variable names

### Documentation
- [ ] README.md is complete
- [ ] All endpoints documented
- [ ] Sample requests/responses included
- [ ] QUICK_START.md is clear
- [ ] PROJECT_SUMMARY.md is accurate

### Testing Tools
- [ ] Postman collection imports successfully
- [ ] All requests in collection are valid
- [ ] Request bodies are properly formatted

---

## Final Checks Before Submission ✅

- [ ] All 48 endpoints tested and working
- [ ] Screenshots taken for at least 5 endpoints per question
- [ ] Git repository initialized
- [ ] Branch created: restFull_api_[STUDENT_ID]
- [ ] All files committed
- [ ] Branch pushed to remote
- [ ] Submission deadline noted: Next class at 17:59

---

## Notes
- Test endpoints in order (GET → POST → PUT/PATCH → DELETE)
- For POST/PUT requests, use Content-Type: application/json header
- Save Postman test results as screenshots
- Document any issues encountered during testing

**Good luck! 🚀**
