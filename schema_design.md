# Smart Clinic Management System – MySQL Database Schema

## Tables

### users
| Column    | Type         | Constraints             |
|-----------|-------------|------------------------|
| id        | BIGINT      | PRIMARY KEY, AUTO_INCREMENT |
| username  | VARCHAR(50) | UNIQUE, NOT NULL       |
| password  | VARCHAR(255)| NOT NULL               |
| email     | VARCHAR(100)| NOT NULL               |
| role      | ENUM('ADMIN','DOCTOR','PATIENT') | NOT NULL |

### doctor
| Column      | Type         | Constraints             |
|-------------|-------------|------------------------|
| id          | BIGINT      | PRIMARY KEY, AUTO_INCREMENT |
| full_name   | VARCHAR(100)| NOT NULL               |
| specialty   | VARCHAR(50) | NOT NULL               |
| phone       | VARCHAR(20) | NOT NULL               |
| email       | VARCHAR(100)| NOT NULL               |

### patient
| Column      | Type         | Constraints             |
|-------------|-------------|------------------------|
| id          | BIGINT      | PRIMARY KEY, AUTO_INCREMENT |
| full_name   | VARCHAR(100)| NOT NULL               |
| birth_date  | DATE        |                        |
| phone       | VARCHAR(20) | NOT NULL               |
| email       | VARCHAR(100)| NOT NULL               |

### appointment
| Column     | Type         | Constraints             |
|------------|-------------|------------------------|
| id         | BIGINT      | PRIMARY KEY, AUTO_INCREMENT |
| doctor_id  | BIGINT      | FOREIGN KEY → doctor(id) |
| patient_id | BIGINT      | FOREIGN KEY → patient(id) |
| start_at   | DATETIME    | NOT NULL               |
| end_at     | DATETIME    | NOT NULL               |
| status     | VARCHAR(20) | NOT NULL               |

## Relationships

- `users` contient tous les comptes (Admin, Doctor, Patient)
- `doctor` et `patient` contiennent les informations métier spécifiques
- `appointment` relie `doctor` et `patient` via des clés étrangères
- Chaque `appointment` appartient à un seul docteur et un seul patient

