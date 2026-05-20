# poe-part-2-st10347225

# QuickChat Application

## Student Information

- **Student Name: Maanda Mahuwa
- **Student Number: ST10347225
- **Module:** Programming 1A
- **Module Code:** PROG5121
- **Project:** POE Part 2 – QuickChat Application

# Project Description

QuickChat is a Java console and GUI-based messaging application developed for the Programming 1A POE Part 2 assessment.

The application allows users to:

- Register an account
- Login using registered credentials
- Send messages
- Store messages in a JSON file
- Generate Message IDs
- Generate Message Hashes
- Validate usernames, passwords, and cellphone numbers
- Display message details

The project also includes JUnit testing for validation and message functionality.

# Features

## User Registration

The application validates:

### Username
- Must contain an underscore (`_`)
- Must not exceed 5 characters

### Password
- Minimum 8 characters
- Must contain:
  - Capital letter
  - Number
  - Special character

### Cellphone Number
- Must follow South African international format:
```text
+27831234567

# Login Functionality

Users can login using:
- Registered username
- Registered password

The system displays:
- Successful login message
- Failed login message

# Messaging Features

Users can:

- Send messages
- Store messages
- Disregard messages

The application also:
- Generates a unique Message ID
- Creates a Message Hash
- Displays full message details

---

# Message Validation

## Recipient Validation
Recipient number must:
- Start with `+27`
- Contain 9 digits after country code

## Message Length
- Maximum 250 characters

---

# Technologies Used

- Java
- NetBeans IDE
- JOptionPane
- ArrayList
- JSON File Storage
- JUnit Testing

---

# Project Structure

```text
src/
│
├── Main.java
├── Login.java
├── Message.java
├── MessageStore.java
├── LoginTest.java
└── MessageTest.java
```

---

# How to Run the Project

1. Open the project in NetBeans
2. Clean and Build the project
3. Run `Main.java`
4. Register a new user
5. Login
6. Start sending messages

# JSON Storage

Stored messages are saved inside:

```text
stored_messages.json
```

---

# Example Message Hash

```text
00:0:HITONIGHT
```

Format:
```text
First 2 digits of Message ID : Message Number : First and Last Word

# Unit Testing

JUnit tests included:

## Login Tests
- Username validation
- Password validation
- Cellphone validation
- Login validation

## Message Tests
- Recipient validation
- Message hash creation
- Message ID validation


# Author

Developed by:

```text
Maanda Mahuwa

For:
```text
IIE Rosebank College
Programming 1A POE Part 2
```
