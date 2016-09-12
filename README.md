# Advanced Internet Programming Assignment 1: JXPens#

This README would give details of the project and the steps to setup the project.

## Basic Functionality ##

* Login
* Create a Pen
* View or search for pens
* Edit the record of a pen
* Delete a record of a pen
* Logout

## Innovation Functionality ##
* RESTful API which outputs XML
* Register
* Beautiful UI

## How do I get set up? ##
### First, Clone Project with following line ###

```
#!shell

git clone https://ShaoxiHe@bitbucket.org/ShaoxiHe/jxpens.git
```

### Database Configuration ###
Create a Database following the instructions provided in the link, but without creating any tables:
[https://benatuts.github.io/aip/05-practice.html](Link URL)

Steps:

1. Create a JavaDB database with the name, username and password assigned to "**aip**" without the quotes.
1. Run the SQL file name **create_jxpens_db.sql** to setup table structures in the database
1. Go the GlassFish Admin Console, Create a connection pool called **AIPPool**, with the Type javax.sql.DataSource and **JavaDB** driver.


This will create jdbc connection pool, container and realm



Finally, run the sql file named create_jxpens_db.sql located in the project directory to create tables needed.
### 
Dependencies ###





### Who do I talk to? ###

* This repo contains a project for education purpose, it is used only for practicing skills
* For more information please email shaoxi.he@student.uts.edu.au