PrizyPrice
==========

This is the code for the Prizy Price App for survey related 

1. The rquirements to run the Prizy Price application

a). apache-tomcat-7.0.50
b). All the jar file listed in the nbproject/project.xml file
c). mysql database 
d). Netbean editor (Choose whatever you prefer)


STEPS TO CONFIGURE AND RUN: 

1. Create database as "prizy" in mysql

2. Export the database as I uploaded in the github

3. Open the project in your IDE

4. Add all the reuired JARS 

5. Add the server and Test the application 

6. build and Run the application on the server 


STEPS TO KNOW THE OUTPUT:

Follow the screens which added to screen folder

FRONTEND (TAKE SURVEY, URL will be like http://localhost:7272/PrizyPricer) 
1. surveyhome.png => Which show the screen where user can enter the price from selecting the product from the dropdown list

2. enterprice.png => When user will select the product from the drop-down list then user will see this screen, Here user can enter the price and his/her notes

ADMINISTATOR SECTION( Add/view/list product, URL will be like http://localhost:7272/PrizyPricer/admin)
3. productlist.png = > Admin can see all the product list at this screen, This time no pagination not added so its not good approch without pagination and search the product by name,barcode but It should be there while not yet

4. addnewproduct.png => Admin can add new product from this screen by passing the product name, description while the barcode is generated by using internal code 

5. productview.png = > On this screen admin can see the the detail by selecting the product from the list, This screen will the show all the details listed in the screen 


Note: You need to create directory to hold the barcode images but that directory should have the R/W permission, For it follow the properties file to se the URL(web/WEB_INF/prizyproperties/config.properties)


