/**
 * Author:  harold
 */

/**
 * This script file creates a database for the project JXPens
 * which contains two tables: user and pen
 */

-- For testing purpose
-- SELECT tablename from sys.systables;

-- Table Structure for pen
create table pen(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), 
    pen_name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    nib_size DECIMAL(2,1) NOT NULL,
    colour VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

-- Testing insert query
INSERT INTO pen(pen_name,brand,nib_size,colour) values('Test brush', '晨光', 2.0, 'blue');

-- Checking Table Data
SELECT * FROM pen;

-- User details
create table account (
    username varchar(255) not null primary key,
    password varchar(255) not null
 );

-- User view used by JDBC Realm
create view jdbcrealm_user (username, password) as
select username, password
from account;

-- Group view used by JDBC Realm
-- This view ensure every account belongs in the 'Users' group
create view jdbcrealm_group (username, groupname) as
select username, 'Users'
from account;
