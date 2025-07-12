// Main class to manage all operations
class Splitwise {
    private Map<User, Map<User, Double>> balances;

    public Splitwise() {
        balances = new HashMap<>();
    }

    // Add new expense
    public void addExpense(User paidBy, List<User> participants, double amount) {
        double splitAmount = amount / participants.size();
        for (User participant : participants) {
            if (participant == paidBy) continue;
            updateBalance(paidBy, participant, splitAmount);
        }
    }

    // Balance update logic
    private void updateBalance(User payer, User borrower, double amount) {
        balances.putIfAbsent(payer, new HashMap<>());
        balances.putIfAbsent(borrower, new HashMap<>());

        double prev = balances.get(payer).getOrDefault(borrower, 0.0);
        balances.get(payer).put(borrower, prev + amount);
    }

    // View balances
    public void showBalances() {
        for (User u1 : balances.keySet()) {
            for (Map.Entry<User, Double> entry : balances.get(u1).entrySet()) {
                User u2 = entry.getKey();
                double amount = entry.getValue();
                if (amount > 0)
                    System.out.println(u2.name + " owes " + u1.name + ": " + amount);
            }
        }
    }

    // Optimize the number of transactions
    public List<Transaction> minimizeTransactions() {
        // Step 1: Build netBalance array
        // Step 2: Settle using backtracking/greedy (Min Cash Flow)
        return new ArrayList<>(); // placeholder
    }
}

// Helper Classes
class User {
    String id;
    String name;
}

class Transaction {
    User from;
    User to;
    double amount;
}
