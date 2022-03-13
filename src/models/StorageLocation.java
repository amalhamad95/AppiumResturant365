package models;

public class StorageLocation {

	private String StorageName;
	private int itemsCount;

	public String getStorageName() {
		return StorageName;
	}

	public void setStorageName(String storageName) {
		StorageName = storageName;
	}

	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	@Override
	public String toString() {
		return "StorageLocation [StorageName=" + StorageName + ", itemsCount=" + itemsCount + "]";
	}

}
