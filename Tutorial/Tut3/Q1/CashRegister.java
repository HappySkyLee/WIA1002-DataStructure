package Tutorial.Tut3.Q1;

public class CashRegister {
	private int cashOnHand;

	public CashRegister(int cashOnHand) {
		this.cashOnHand = cashOnHand;
	}

	public int getCurrentBalance() {
		return cashOnHand;
	}

	public void acceptAmount(int amount) {
		if (amount > 0) {
			cashOnHand += amount;
		}
	}
}
