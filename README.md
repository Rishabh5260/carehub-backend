# 🩺 HealthSync - Health-Tech Backend API

A **Spring Boot-based backend application** designed to power a secure, scalable, and modern healthcare system. It manages patients, doctors, appointments, medical records, reports, and more — all through robust RESTful APIs.

---

## 🚀 Features

- 👤 User Registration and Login (Patients & Doctors)
- 🔐 JWT-based Authentication and Spring Security
- 📄 Medical Record Management
- 📅 Appointment Scheduling
- 📊 Report Generation
- 🎥 (Upcoming) Video Call Integration with Jitsi/Zoom
- ⚙️ Global Exception Handling using `@ControllerAdvice`
- 📈 Caching & Rate Limiting (Planned)
- 🗃️ MySQL database integration

---

## 🛠️ Tech Stack

| Layer         | Technology                      |
|---------------|----------------------------------|
| Backend       | Spring Boot, Spring Security     |
| Database      | MySQL                            |
| ORM           | Hibernate / JPA                  |
| Auth          | JWT (Access & Refresh Tokens)                 |
| Build Tool    | Maven                            |
| Caching       | Redis (Planned)                  |
| Video Call    | Jitsi/Zoom SDK (Planned)         |

---

## 📦 Getting Started

```bash
# Clone the repo
git clone https://github.com/your-username/carehub-backend.git
cd carehub-backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
