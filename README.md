# CS-320
Portfolio for CS-320 Software Test, Automation, QA

How can I ensure that my code, program, or software is functional and secure?
How do I interpret user needs and incorporate them into a program?
How do I approach designing software?


To ensure that my software is both functional and secure I rely on strict input validation thorough unit testing and defensive coding practices. For example, in my Appointment class, validation is the first step in the constructor, which prevents invalid IDs, past dates, or overly long descriptions from being accepted. I also used defensive copies for Date objects to prevent outside modification, which secures the integrity of the data after creation. Combined with negative JUnit tests that expect exceptions, these techniques provide confidence that my code not only functions correctly under valid inputs but also handles invalid inputs safely without compromising security or stability.

When it comes to interpreting user needs, I start by looking at the explicit requirements in the rubric or specifications and then translate those into enforceable constraints in my classes. For example, the rubric stated that appointment descriptions must be no longer than 50 characters; I implemented this directly in a validation method, and then wrote unit tests to ensure it was consistently enforced. This process demonstrates how I convert abstract user needs into concrete, testable rules in my program.

My approach to designing software begins with breaking the problem down into small, modular classes, each with clear responsibilities. For this project, I created separate classes for Contact, Task, and Appointment, supported by service classes that managed collections of these objects (ContactService, TaskService, AppointmentService). This separation of concerns made it easier to test each piece in isolation, ensured scalability, and reduced complexity. I also made design choices with maintainability in mind, such as using HashMaps for fast lookups and generating unique IDs to avoid collisions. Overall, my approach balances meeting user needs with writing clean, modular, and maintainable code.
