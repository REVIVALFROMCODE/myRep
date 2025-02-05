Consistency

Lost Updates:

Scenario: Two or more transactions read the same data and update it concurrently, leading to one update being lost.

Impact: Only the last update remains, and previous updates are lost.

Example: Two users trying to book the last seat on a flight at the same time; both transactions read the availability as "1," both update it, and one booking is lost.


BLOB

[For a table with several columns, to reduce memory requirements for queries that do not use the BLOB column, consider splitting the BLOB column into a separate table and referencing it with a join query when needed.](https://dev.mysql.com/doc/refman/8.0/en/optimize-blob.html)
awioajifjw
D7WVE7Hz5kEIiBgRw9ndCDVAAUhiNgaCxSyipVCqR5jzPdMY42tYJQQJ99BBBCYeBjFXJ3w3AAABACOGqSih
