# Online-Ticket-Booking-System: Microservices Suite

A Distributed Ticket Booking System built with **Spring Boot** and **React**.

## 🏗️ The 3-Service Architecture

| Service | Port | Key Logic |
|---------|------|-----------|
| **User Service** | 8080 | The Master: Manages User profiles & Wallet Balance |
| **Ticket Service** | 8081 | The Engine: Handles Source/Destination & Ticket Status |
| **Payment Service** | 8082 | The Vault: Idempotent processing (No Duplicate Transactions) |

## 🔄 The Complete Flow

1. **Frontend (React)** sends a request to User Service
2. **User Service** checks for valid User & Wallet Balance
3. **Ticket Service** creates a PENDING ticket
4. **Payment Service** simulates the bank call
5. **Final Update**: On success, Wallet balance is deducted and Ticket is marked SUCCESS

## 🛠️ Key Technical Solves (Edge Cases)

- **Double Payment Prevention**: Using `findByTicketId` check in Payment Service
- **Identifier Fix**: Restricting Primary Key updates during payment retries
- **Service Fault Tolerance**: try-catch blocks to handle downtime of any service
- **Sync Issues**: Custom `PaymentFailedException` for clean error propagation

## 🚀 Getting Started

### Prerequisites
- Java 11+ (for Spring Boot services)
- Node.js & npm (for React frontend)

### Running the Services

1. **Start Payment Service** (runs on port 8082)
   ```bash
   cd PaymentService
   mvn spring-boot:run
   ```

2. **Start Ticket Service** (runs on port 8081)
   ```bash
   cd TicketService
   mvn spring-boot:run
   ```

3. **Start User Service** (runs on port 8080)
   ```bash
   cd UserService
   mvn spring-boot:run
   ```

4. **Start Frontend** (React)
   ```bash
   cd frontend
   npm install
   npm start
   ```

The application will be available at `http://localhost:3000`

## 📦 Project Structure

```
Online-Ticket-Booking-System/
├── PaymentService/          # Payment processing microservice
├── TicketService/           # Ticket management microservice
├── UserService/             # User & wallet management microservice
└── frontend/                # React frontend application
```

## 🔐 Features

- ✅ Distributed microservices architecture
- ✅ Fault-tolerant payment processing
- ✅ Idempotent transaction handling
- ✅ Real-time ticket status tracking
- ✅ Wallet-based payment system
- ✅ Error handling and recovery mechanisms



## 👤 Author

**Akhil Sharma** - [GitHub Profile](https://github.com/akhilSharma25)
```

