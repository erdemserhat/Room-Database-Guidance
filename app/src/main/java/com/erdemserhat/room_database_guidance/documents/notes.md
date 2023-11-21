# Room Database

-Room Database is built on the top of SQLite

->Pros
-Compile time verification of SQL queries.
-Less boilerplate code
-Easily integrated with other components.

There are 3 main components in the Room Database
a) @Entity
b) @Dao
c) @Database

1) @Entity
   Represents a table within the database. Room creates a table for each class that has @Entity
   annotation, the fields in the
   class correspond to columns in the table.
   Therefore , the entity classes tend to be small model classes that don't contain any business
   logic.

2) @Dao ( Data Access Object)
   DAOs are responsible for defining the methods that access the database. This is the place where
   we write our queries.

3) @Database
   Contains the database holder and serves as the main access point for the underlying connection to
   your app's data

   

