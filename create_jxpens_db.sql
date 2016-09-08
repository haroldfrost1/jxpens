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
