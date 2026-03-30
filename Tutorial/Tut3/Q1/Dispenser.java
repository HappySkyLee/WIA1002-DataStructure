package Tutorial.Tut3.Q1;

public class Dispenser {
	private final String productName;
	private final int itemCost;
	private int numberOfItems;

	public Dispenser(String productName, int itemCost, int numberOfItems) {
		this.productName = productName;
		this.itemCost = itemCost;
		this.numberOfItems = numberOfItems;
	}

	public String getProductName() {
		return productName;
	}

	public int getItemCost() {
		return itemCost;
	}

	public int getCount() {
		return numberOfItems;
	}

	public boolean isEmpty() {
		return numberOfItems <= 0;
	}

	public boolean makeSale() {
		if (isEmpty()) {
			return false;
		}

		numberOfItems--;
		return true;
	}
}
