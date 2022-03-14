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

	/// --------------------- Tab Layout ---------------------
	@AndroidFindBy(accessibility = "In progress")
	MobileElement tabInProgress;

	/// --------------------- Search ---------------------
	@AndroidFindBy(id = "et_search")
	MobileElement searchInput;

	@AndroidFindBy(id = "tv_no_inventory_count")
	MobileElement tvNoResultsFound;

	/// --------------------- Inventory List ---------------------
	@AndroidFindBy(id = "rv_inventory_counts")
	MobileElement inventoryCountsList;

	@AndroidFindBy(id = "tv_inventory_name")
	List<MobileElement> tvInventoryName;

	/// ------------------------------------------------------------------
	/// --------------------- Storage Locations Screen ---------------------
	/// ------------------------------------------------------------------
	@AndroidFindBy(id = "rv_items")
	MobileElement storageList;

	@AndroidFindBy(id = "tv_storage_name")
	List<MobileElement> tvStorageName;

	@AndroidFindBy(id = "tv_items")
	List<MobileElement> tvStorageItemsCount;

	/// ------------------------------------------------------------------
	/// --------------------- Storage Details Screen ---------------------
	/// ------------------------------------------------------------------
	/// --------------------- Items List ---------------------
	@AndroidFindBy(id = "rv_items")
	MobileElement storageItemsList;

	@AndroidFindBy(id = "tv_item_name")
	List<MobileElement> tvItemName;

	@AndroidFindBy(id = "tv_unit")
	List<MobileElement> tvItemUnitAndQty;

	@AndroidFindBy(id = "tv_cost")
	List<MobileElement> tvItemCost;

	@AndroidFindBy(id = "tv_total_cost")
	List<MobileElement> tvItemTotalCost;
	
	@AndroidFindBy(id = "btn_enter")
	MobileElement enterElement;

	@AndroidFindBy(id = "btn_enter")
	MobileElement enterElement;

	/// --------------------- Item Details Dialog ---------------------
	@AndroidFindBy(id = "design_bottom_sheet")
	MobileElement itemDialog;

	@AndroidFindBy(id = "tv_status")
	MobileElement tvDialogItemStatus;

	@AndroidFindBy(id = "tv_item_name")
	MobileElement tvDialogItemName;

	@AndroidFindBy(id = "tv_item_price")
	MobileElement tvDialogItemPrice;

	@AndroidFindBy(id = "tv_unit_name_1")
	MobileElement tvDialogItemUnit;

	@AndroidFindBy(id = "et_unit_amount_1")
	MobileElement etDialogItemAmount;

	@AndroidFindBy(id = "btn_enter")
	MobileElement btnDialogEnter;

	@AndroidFindBy(id = "iv_close")
	MobileElement imvCloseDialog;

	/// --------------------- Calculator ---------------------
	@AndroidFindBy(id = "btn_clear")
	MobileElement btn_clear;
	@AndroidFindBy(id = "btn_num_0")
	MobileElement btn_num_0;
	@AndroidFindBy(id = "btn_num_1")
	MobileElement btn_num_1;
	@AndroidFindBy(id = "btn_num_2")
	MobileElement btn_num_2;
	@AndroidFindBy(id = "btn_num_3")
	MobileElement btn_num_3;
	@AndroidFindBy(id = "btn_num_4")
	MobileElement btn_num_4;
	@AndroidFindBy(id = "btn_num_5")
	MobileElement btn_num_5;
	@AndroidFindBy(id = "btn_num_6")
	MobileElement btn_num_6;
	@AndroidFindBy(id = "btn_num_7")
	MobileElement btn_num_7;
	@AndroidFindBy(id = "btn_num_8")
	MobileElement btn_num_8;
	@AndroidFindBy(id = "btn_num_9")
	MobileElement btn_num_9;

	/// --------------------- Totals ---------------------
	@AndroidFindBy(id = "tv_count_total")
	MobileElement tvCountTotal;

}
