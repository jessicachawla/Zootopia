# ZooTopia 
## Assumptions
-  Discount can be only of type MINOR and SENIOR
-  Discount code is NOT case sensitive.
-  Deals have been hardcoded.
-  Deals are only applicable if the 2 or more tickets are bought for the same attraction.
-  The 6 animals have been hardcoded.
-  Input datatype is assumed to be taken correctly.
-  Money is taken to be in decimal after discount applied.
-  Animal and Attraction names are case sensitive in most of the places.
-  While adding animal, name is not case sensitive, rest everywhere it is case sensitive.
-  Special Deals have already been added from the beginning, however they can be added or deleted.

## Classes
### Admin
- Represents an administrator responsible for managing zoo operations.
- Admins can add discounts, special deals, view visitor statistics, and view feedback.
### Attraction
- Represents a zoo attraction.
- Contains information about the attraction, including its name, description, ticket price, and status (open or closed).
- Attraction objects are part of the zoo's catalog of attractions.
### Animal
- Represents an animal at the zoo.
- Contains information about the animal, including its name and the sound it makes.
- Animals are divided into categories: Mammals, Reptiles, and Amphibians, which inherit from the `Animal` class.
### Mammal, Reptile, Amphibian
- Subclasses of the `Animal` class.
- Specific animal types inherit properties and methods from the `Animal` class.
- Demonstrates inheritance in the project.
### applyDiscount
- An interface that defines a method `apply` for applying discounts.
- Implemented by the `Discount` and `SpecialDeal` classes.
### Discount
- Represents a discount offered to zoo visitors.
- Contains information about the discount, such as the category it applies to and the discount percentage.
### SpecialDeal
- Represents a special deal offered to zoo visitors.
- Contains information about the deal, such as the minimum number of tickets required and the discount percentage.
- Implements the `applyDiscount` interface to calculate discounts.
### Ticket
- Represents a ticket for a specific attraction.
- Maintains a reference to the attraction it is associated with.
- Used to track visitor tickets.
### Visitor
- Represents a visitor to the zoo.
- Contains visitor information, including name, age, phone number, balance, and email.
- Visitors can buy memberships, purchase tickets, and interact with attractions and animals.
### User
- An abstract class with common user properties like name and password.
- Used as a base class for `Admin` and `Visitor` classes.
### Zoo
- Represents the zoo itself.
- Contains a list of attractions, animals, and feedback.
- Admins can manage zoo resources and settings.
### ZooPortal
- The main application class, serving as the entry point for administrators and visitors.
- Admins and visitors can interact with the zoo system through this class.



