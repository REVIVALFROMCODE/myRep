Consistency

Lost Updates:

Scenario: Two or more transactions read the same data and update it concurrently, leading to one update being lost.

Impact: Only the last update remains, and previous updates are lost.

Example: Two users trying to book the last seat on a flight at the same time; both transactions read the availability as "1," both update it, and one booking is lost.
