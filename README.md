# restaurant 365
<a href="https://github.com/amalhamad95/AppiumResturant365/blob/main/src/runners/JUnitTestRunner.java" alt="Contributors">
  <img src="https://img.shields.io/badge/-Contributors-blueviolet">
  <img src="https://img.shields.io/badge/-Amal-blue">
  <img src="https://img.shields.io/badge/-Tasneem-brightgreen">
  <img src="https://img.shields.io/badge/-Norhan-yellow">
  <img src="https://img.shields.io/badge/-Yasmeen-orange">
  <img src="https://img.shields.io/badge/-Mohammed-green">
  <img src="https://img.shields.io/badge/-appium-gray">
  <img src="https://img.shields.io/badge/-junit-red">
</a>

 <a href="https://github.com/amalhamad95/AppiumResturant365/blob/main/src/runners/JUnitTestRunner.java">
  <img src="https://img.shields.io/badge/-appium-gray"><img src="https://img.shields.io/badge/-junit-red">
</a>
 




![Appium](https://user-images.githubusercontent.com/94033644/158073029-e1964543-646d-46fc-a030-b53ebd7abc03.png)

###Prerequisites for Appium Installation
1.  [Java (JDK)](https://www.guru99.com/install-java.html)
2.  [Install Android SDK (Software Development Kit)](https://developer.android.com/about/versions/12/setup-sdk)
3.  [Install Appium](https://appium.io/docs/en/about-appium/getting-started/?lang=en)
4.  [Eclipse IDE – Download and Install](https://www.eclipse.org/downloads/)
5.  Enable USB Debugging on Android Phone



### How to start using this script
```
git clone https://github.com/amalhamad95/AppiumResturant365.git
```

**To run the code**
1. File > open project (give the location for the cloned file)
2. Open JUnitTestRunner file
```
https://github.com/amalhamad95/AppiumResturant365/blob/main/src/runners/JUnitTestRunner.java
```
3. Click run as JUnit test


### Test cases covered by this app
Checkout Scenarios suite => 

###Scenario 1
1. verify user can login with a valid credentials 
2. verify username is reflected on password page
3. verify user is able click on humburger menu
4. verify side menu is opened 
5. verify user is directed into Inventory Counts when clicking on 'Inventory Counts'tab
6. Verify Inventory Counts header is displayed
7. verify in progress is selected by default 
8. verify search placeholder is displayed 
9. verify "no results are found " is displayed when entering an invalid value in the search field 
10. Verify search results contains the same value of  the search field

***********************************************

###Scenario 2
1. verify template name is displayed at the header of the storage page 
2. verify the number of items on the storage page is the same on the items page 
3. verify the item details match the details in the dialog.
4. verify the user can change the quantity from the item dialog
5. verify the user can close item dialog 
6. verify the new quantity is reflected on the item page 
7. verify the total price for an item equals the price of the item multiplied by the  quantity 
8. Verify the total amount at the end of the page equals the summation of all total prices for items 

***********************************************

###The End Report for the app

<img width="1152" alt="Screen Shot 2022-03-14 at 11 22 42 AM" src="https://user-images.githubusercontent.com/94033644/158148093-c847f986-8323-4ebc-bd63-e6d0be98938a.png">

***********************************************

### To generate the report
Go to build.xml file then run as a Ant Build

***For more information 
```
https://earlwillis.wordpress.com/2012/01/31/getting-started-with-junit-reports/
```



