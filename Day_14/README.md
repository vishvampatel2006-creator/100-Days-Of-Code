# Day 14 — Java OOP: Inheritance & Polymorphism (Societa Ledger)

Upgraded the Societa maintenance ledger using `Resident` as the base class and `Owner` and `Tenant` as subclasses with overridden `calculateTotalDues()` and `getSummary()` methods, storing them in an `ArrayList<Resident>` and writing output to `ledger_report.txt`.

## Run
```bash
javac Day_14/SocietaLedger.java
java -cp Day_14 SocietaLedger