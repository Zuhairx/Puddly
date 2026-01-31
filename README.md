# Pudding Data Management System V 1.0 - User Tutorial

<div align="center">
<img width="256" height="256" alt="Application Icon" src="image/iconLogo.png" />
</div>

## Initial Preparation

### 1. System Requirements
- Java Development Kit (JDK) installed
- MySQL Server installed

### 2. Database Setup
1. Create a new database in MySQL
2. Import the file `Database/Pudding_database.sql` into the database
3. Ensure the database connection is configured correctly (see `KoneksiDatabase.java`)

### 3. Running the Application
- **Via Batch File**: Run `run.bat` (for Windows) - this will compile and run the application automatically.
- **Via Terminal**:
  - Run the following command to build the project:
    ```bash
    javac -d bin -cp "lib/mysql-connector-j-9.5.0.jar" src/PTPudding/*.java
    ```
  - After successful build, run the program with the command:
    ```bash
    java -cp "bin;lib/mysql-connector-j-9.5.0.jar" PTPudding.launch
    ```

## User Guide

### Main Menu
1. Run the application
2. You will see the main menu with options: Insert, Update, Delete, View Data

### Insert Data
1. Click "Insert" in the main menu
2. Fill in the pudding data (name, price, etc.)
3. Click "Insert" to save

### Update Data
1. Click "Update" in the main menu
2. Search or Select a pudding data from the table on the right
3. Modify the required data in the fields on the left
4. Click "Update"

### Delete Data
1. Click "Delete" in the main menu
2. Select pudding data from the table
3. Click "Delete"

### View Data
1. Click "View Data" in the main menu
2. View all pudding data in the table

## Database Structure

### Table `menu`
- `id` (INT): Unique pudding ID
- `nama` (VARCHAR): Pudding name
- `harga` (INT): Pudding price
- `stok` (INT): Stock quantity
- etc. (according to Pudding.java model)

## Troubleshooting

### Cannot Connect to Database
- Ensure MySQL server is running
- Check configuration in `KoneksiDatabase.java`

### Application Cannot Run
- Ensure JDK is installed
- Ensure all .class files are compiled

## Support
For questions or issues, contact the developer.

## Recent Updates
- Updated Update Data interface layout: Repositioned ID field to top left, arranged labels and fields vertically on the left, moved table to right column, kept buttons at bottom.
