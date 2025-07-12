# Splitwise - Low Level Design

This folder contains the low-level design of a Splitwise-like expense sharing app.

## 📌 Key Features

- Users can add expenses with payer, participants, and split method.
- System auto-calculates balances between users.
- Supports detailed balance view and optimized debt settlement.

## 📦 Core Entities

- `User`
- `Expense` (amount, paidBy, splitWith)
- `Transaction` (userFrom → userTo)
- `BalanceSheet` (who owes whom and how much)

## ⚙️ High-Level Modules

- `ExpenseManager` to manage expense entries and update balances.
- `BalanceSheet` to keep track of net balances.
- `DebtSettlement` to compute optimal way to minimize transactions.

## 💡 Optimizations

- Reduce total number of transactions using Greedy or Min-Cash-Flow.
- Group people into +ve/-ve balances and settle accordingly.

## ⏱️ Designed for:
- 1-hour LLD interview at Microsoft or similar companies.
