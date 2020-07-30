# Solid principles + Got patterns
- References from the course: https://www.udemy.com/course/design-patterns-java

# Introduction
This is an Udemy course that explorer the advantages of good oriented-programming-language could provide us. It shows 
step by step how to improve a bad code or a code that may grow up and be more complexity. Using S.O.L.I.D. and project 
patterns it reduces the problems to occur.

# SOLID

## Single Responsibility Principle - SRP
This principle advice us about pieces of code that should do only a unique purpose. When a class is doing more things 
that it should be done, it can be very difficult to maintain and change for new features. Separating classes for one 
propose, can help us to reuse code and read more clearly.
- A class should only have one reason to change
- Separation of concerns

## Open Closed Principle - OCP
Basically, a class, or a method should have only one reason to change. To achieve this, you can apply OCP to think more 
in extension and less in modifying an existing class - when the feature does not require at all. So, using abstract 
classes, inheritance and some others object-orientation resources, may help us to achieve this principle.
- Classes hould be open for extension, but closed for modification

## Liskov Substitution Principle - LSP
This principle propose to programming more for abstractions and less for concrete implementation. That is, think methods
to deal more with superclasses and interfaces that can substitute concreted inheritance classes. Doing this, a method 
could accept all implementations that follow the superclasses or interfaces requirement, but does not need to be a 
specific class implementation.
- Yu should be able to substitute a base type for a subtype

## Interface Segregation Principle - ISP
Make into small pieces. Do not create giant interfaces forcing classes to implement a lot of things that it will not be 
used - of courses, try to keep what is summary part of this interface concern.
- Don't put too much into an interface; split into separate interfaces instead
- YAGNI - You ain't going to need it

## Dependency Inversion Principle - DIP
This principle propose to invert the responsibility of control for some perspective way. It proposes to decouple code.
- High level modules should not depend on low-level module's implementation, but abstraction (interfaces). 
- Abstraction should not depend on concrete implementations. Details, should depend on abstraction.

# Creation Patterns

## Introduction
These patterns can be resumed on:
 - Deal with the creation
 - Explicit (constructor) vs implicit (DI, reflection)
 - Wholesale (single statement) vs piecewise (step-by-step)

## Builder
When constructing an object is complicated, sometimes it could be created in parts. This design pattern help us to 
"build" part-by-part.

# Structural Patterns

## Introduction

# Behavior Patterns


## Introduction
