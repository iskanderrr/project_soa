# Donations API Documentation

## Overview
This API allows users to manage donations, including creating, reading, updating, and deleting donation records.

## Base URL
```
/lineoFundMe
```

## Endpoints

### Create Donation
**POST** `/donations`

Creates a new donation record.

#### Request
- **Headers**:
  - `Content-Type: application/json`
- **Body** (JSON):
  ```json
  {
    "name": "John Doe",
    "amount": 50.0
  }
  ```

#### Response
- **201 Created**:
  ```json
  {
    "message": "Donation created successfully!",
    "donation": "<Donation object representation>"
  }
  ```
- **400 Bad Request**:
  ```json
  {
    "error": "Error details"
  }
  ```

---

### Get All Donations
**GET** `/donations`

Retrieves a list of all donations.

#### Response
- **200 OK**:
  ```json
  [
    {
      "id": 1,
      "name": "John Doe",
      "amount": 50.0,
      "date": "2025-01-01T12:00:00"
    },
    {
      "id": 2,
      "name": "Jane Smith",
      "amount": 75.5,
      "date": "2025-01-02T14:30:00"
    }
  ]
  ```

---

### Get Donation by ID
**GET** `/donations/<int:id>`

Retrieves details of a specific donation by ID.

#### Parameters
- `id` (int): ID of the donation to retrieve.

#### Response
- **200 OK**:
  ```json
  {
    "id": 1,
    "name": "John Doe",
    "amount": 50.0,
    "date": "2025-01-01T12:00:00"
  }
  ```
- **404 Not Found**:
  ```json
  {
    "error": "Donation not found"
  }
  ```

---

### Update Donation
**PUT** `/donations/<int:id>`

Updates details of a specific donation by ID.

#### Parameters
- `id` (int): ID of the donation to update.

#### Request
- **Headers**:
  - `Content-Type: application/json`
- **Body** (JSON):
  ```json
  {
    "name": "John Smith",
    "amount": 60.0
  }
  ```

#### Response
- **200 OK**:
  ```json
  {
    "message": "Donation updated successfully!",
    "donation": "<Donation object representation>"
  }
  ```
- **404 Not Found**:
  ```json
  {
    "error": "Donation not found"
  }
  ```
- **400 Bad Request**:
  ```json
  {
    "error": "Error details"
  }
  ```

---

### Delete Donation
**DELETE** `/donations/<int:id>`

Deletes a specific donation by ID.

#### Parameters
- `id` (int): ID of the donation to delete.

#### Response
- **200 OK**:
  ```json
  {
    "message": "Donation deleted successfully!"
  }
  ```
- **404 Not Found**:
  ```json
  {
    "error": "Donation not found"
  }
  ```
- **400 Bad Request**:
  ```json
  {
    "error": "Error details"
  }
  ```

---

## Models
### Donation
The `Donation` model includes the following fields:
- `id` (int): Unique identifier for the donation.
- `name` (string): Name of the donor.
- `amount` (float): Donation amount.
- `date` (datetime): Timestamp of the donation.
