
# 🌟 Job Portal

## 🚀 Introduction
**Job Portal** is a web application that connects recruiters and job seekers, allowing recruiters to post job openings and job seekers to search, save, and apply for jobs.

## 📦 Key Features
- **Recruiters:**
    - Register an account and create company profiles.
    - Post job openings.
- **Job Seekers:**
    - Register an account and create personal profiles.
    - Search, save, and apply for jobs.
- **Admin:**
    - Manage users and job postings.

## 🏗️ Database Structure
The project uses **MySQL** with the following key tables:
- **users_type:** Defines user types (Recruiter, Job Seeker).
- **users:** Stores user information.
- **job_company:** Contains company details.
- **job_location:** Stores job location data.
- **job_seeker_profile:** Contains job seekers’ profiles.
- **recruiter_profile:** Contains recruiters’ profiles.
- **job_post_activity:** Stores job postings.
- **job_seeker_save:** Tracks jobs saved by job seekers.
- **job_seeker_apply:** Tracks job applications submitted by job seekers.
- **skills:** Stores job seekers’ skills and experience.

## 🔧 How to Run the Project
1. **Clone the repository:**
   ```bash
   git clone https://github.com/dorisanseanh/recruiter-project.git
   cd job-portal
   ```
2. **Set up the database:**
    - Open MySQL CLI or a database tool like MySQL Workbench.
    - Run the `jobportal.sql` file:
 
3. **Configure the application:**
    - Add database credentials in `application.properties` (for Spring Boot).
    - 
4. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```


## 📚 Technologies Used
- **Backend:** Java Spring Boot
- **Frontend:** Thymeleaf
- **Database:** MySQL
- **Deployment:** Docker

## ✨ Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

## 📄 License
This project is licensed under the [MIT License](LICENSE).

---

