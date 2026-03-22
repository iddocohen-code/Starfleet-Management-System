# Starfleet Management System

A comprehensive Java-based backend system for managing a futuristic fleet of spaceships and their diverse crew members. This project focuses on high-level Object-Oriented Programming (OOP) patterns, data structures, and algorithmic sorting.

## 🚀 Core Features

- **Complex Class Hierarchy**: Implements a sophisticated inheritance tree using Interfaces and Abstract Classes to model various ship types and crew roles.
- **Dynamic Maintenance Logic**: Each vessel type features a unique annual maintenance cost algorithm, factoring in variables like speed, cargo capacity, and weapon systems.
- **Advanced Data Analytics**: Includes a `StarfleetManager` utility that performs complex fleet-wide operations:
  - Multi-level sorting (Fire Power -> Commission Year -> Name).
  - Fleet-wide weapon inventory extraction.
  - Crew demographic analysis (Officer rank distribution, average age).
- **Persistence-Ready Design**: Overrides `equals()` and `hashCode()` for all entities to ensure seamless integration with Hash-based collections (HashSet, HashMap).

## 🛠 Technical Architecture

### Fleet Personnel
- **CrewMember (Interface)**: The foundation for all staff.
- **CrewWoman & Cylon**: Base implementations for regular crew.
- **Officer**: A specialized extension of `CrewWoman` featuring a rank-based system.

### Fleet Vessels
- **Spaceship (Interface)**: Defines core flight and maintenance attributes.
- **TransportShip**: Optimized for logistical operations (Cargo/Passengers).
- **Combat Classes**: A specialized hierarchy including `Fighter`, `Bomber`, `StealthCruiser`, and specialized interceptors like `CylonRaider` and `ColonialViper`.

## 📊 Analytics & Reporting
The system provides several static analytical tools via the `StarfleetManager`:
1. **Sorted Fleet Descriptions**: Generates a detailed string report of all ships based on combat efficiency and age.
2. **Rank Popularity**: Maps and sorts officer ranks by their frequency in the fleet.
3. **Maintenance Overhead**: Calculates the total financial cost of maintaining the entire fleet.

## 🔧 Installation & Usage
1. Clone the repository to your local machine.
2. Ensure you have **JDK 8** or higher.
3. The source code is organized under the `il.ac.tau.cs.sw1.ex.starfleet` package.
4. Run `StarfleetManagerTester.java` to execute the automated system test and view the fleet report.

---
*Developed as part of the Software 1 Course at Tel Aviv University.*
