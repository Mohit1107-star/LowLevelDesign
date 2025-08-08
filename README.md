# UrbanCompanyLLD

A low-level design (LLD) of an Urban Company-like platform that supports creation and retrieval of service bookings such as Cleaning, Plumbing, and AC Repair.

---

## 📌 Features

- Create a service booking
- Mark a booking as completed
- Fetch all previous completed services by a user
- Thread-safe Singleton + clean factory-based architecture
- In-memory repository (easily replaceable with DB)
- Built using core Java (no frameworks)

---

## ✅ Design Patterns Used

| Pattern     | Purpose |
|-------------|---------|
| **Factory** | To instantiate correct `Service` subtype (CleaningService, PlumbingService...) |
| **Singleton** | `ServicePlatform` is a thread-safe singleton acting as the system entry point |
| **Façade** | `ServicePlatform` exposes a unified API: `createService`, `getPreviousServices`, etc. |
| **Repository** | `BookingRepository` hides storage logic behind an interface |

---

## 📁 Project Structure

