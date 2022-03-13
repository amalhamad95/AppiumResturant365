package ui.InventoryCount;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tests.BaseTest;

public class InventoryCount extends BaseTest {

	@AndroidFindBy(accessibility = "Open navigation drawer")
	MobileElement openNavigationIcon;

	@AndroidFindBy(id = "take_inventory")
	MobileElement inventoryCountNavigationButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Inventory Counts']")
	MobileElement InventoryCountTitle;

	@AndroidFindBy(accessibility = "In progress")
	MobileElement tabInProgress;

	@AndroidFindBy(id = "et_search")
	public MobileElement searchInput;

	@AndroidFindBy(id = "tv_inventory_name")
	List<MobileElement> tvInventoryName;

	@AndroidFindBy(id = "tv_no_inventory_count")
	MobileElement tvNoResultsFound;

	@AndroidFindBy(id = "rv_inventory_counts")
	MobileElement inventoryCountsList;

}
