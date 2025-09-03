# Smart Clinic Management System - User Stories

## Admin User Stories

### User Story 1: Manage User Accounts
- **Title**: Admin can create, update, and delete user accounts
- **Role**: Admin
- **Description**: As an admin, I want to manage user accounts so that I can maintain accurate user records.
- **Acceptance Criteria**:
  1. Admin can create a new user with name, email, and role.
  2. Admin can update existing user information.
  3. Admin can delete a user account.
  4. System displays confirmation messages for each action.
- **Priority**: High
- **Story Points**: 3

### User Story 2: View All Appointments
- **Title**: Admin can view all appointments
- **Role**: Admin
- **Description**: As an admin, I want to see all appointments in the system to monitor clinic operations.
- **Acceptance Criteria**:
  1. Admin can filter appointments by date, doctor, or patient.
  2. Appointment list shows patient name, doctor name, time, and status.
  3. Admin can export appointments list as CSV.
- **Priority**: High
- **Story Points**: 2

### User Story 3: Manage Doctors
- **Title**: Admin can add, update, or remove doctor profiles
- **Role**: Admin
- **Description**: As an admin, I want to manage doctor information to keep profiles up to date.
- **Acceptance Criteria**:
  1. Admin can add new doctors with specialty, contact, and schedule.
  2. Admin can update doctor details.
  3. Admin can deactivate or delete doctor profiles.
- **Priority**: Medium
- **Story Points**: 3

### User Story 4: Manage Patients
- **Title**: Admin can manage patient profiles
- **Role**: Admin
- **Description**: As an admin, I want to manage patient accounts for accurate records.
- **Acceptance Criteria**:
  1. Admin can create new patient accounts.
  2. Admin can update patient information.
  3. Admin can delete or deactivate patient accounts.
- **Priority**: Medium
- **Story Points**: 2

---

## Doctor User Stories

### User Story 1: View Daily Appointments
- **Title**: Doctor can view daily appointments
- **Role**: Doctor
- **Description**: As a doctor, I want to see all my daily appointments so that I can manage my schedule.
- **Acceptance Criteria**:
  1. The system displays a list of all appointments for the current day.
  2. Each appointment shows patient name, time, and status.
  3. Doctor can mark appointment as completed.
- **Priority**: High
- **Story Points**: 2

### User Story 2: Manage Prescriptions
- **Title**: Doctor can create and update prescriptions
- **Role**: Doctor
- **Description**: As a doctor, I want to write prescriptions for patients after consultation.
- **Acceptance Criteria**:
  1. Doctor can add medications, dosage, and instructions.
  2. Doctor can update or delete prescriptions.
  3. Prescriptions are linked to patient accounts and visible to patients.
- **Priority**: High
- **Story Points**: 3

### User Story 3: View Patient History
- **Title**: Doctor can view patient medical history
- **Role**: Doctor
- **Description**: As a doctor, I want to review a patient’s history to provide accurate treatment.
- **Acceptance Criteria**:
  1. Doctor can access past appointments, diagnoses, and prescriptions.
  2. History is displayed in chronological order.
- **Priority**: Medium
- **Story Points**: 2

---

## Patient User Stories

### User Story 1: Book an Appointment
- **Title**: Patient can book an appointment
- **Role**: Patient
- **Description**: As a patient, I want to book an appointment with a doctor online.
- **Acceptance Criteria**:
  1. Patient selects doctor and available time slot.
  2. System confirms booking and sends a notification.
  3. Patient can cancel or reschedule the appointment.
- **Priority**: High
- **Story Points**: 3

### User Story 2: View Appointments
- **Title**: Patient can view their upcoming appointments
- **Role**: Patient
- **Description**: As a patient, I want to see all my scheduled appointments.
- **Acceptance Criteria**:
  1. Patient can view all upcoming appointments.
  2. Appointment details show doctor name, time, and status.
- **Priority**: High
- **Story Points**: 2

### User Story 3: View Prescriptions
- **Title**: Patient can view prescriptions
- **Role**: Patient
- **Description**: As a patient, I want to view prescriptions from my doctor.
- **Acceptance Criteria**:
  1. Patient can see all prescriptions linked to their account.
  2. Each prescription shows medication, dosage, instructions, and date.
- **Priority**: Medium
- **Story Points**: 2

### User Story 4: Update Profile
- **Title**: Patient can update personal information
- **Role**: Patient
- **Description**: As a patient, I want to update my contact information.
- **Acceptance Criteria**:
  1. Patient can update phone number and email.
  2. Changes are saved and reflected immediately in their account.
- **Priority**: Medium
- **Story Points**: 1
