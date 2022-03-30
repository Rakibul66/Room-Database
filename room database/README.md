# RoomDatabase

![Image description](https://i.ytimg.com/vi/0cg09tlAAQ0/maxresdefault.jpg)

Home » Android Room Database Example – Building a Student App
Android Room Database Example – Building a Student App

Hi everyone, in this post we will learn about another architectural component of android which is Room Persistence Library. In this android room database example, we will learn how to use room for handling our SQLite database.

Here is a new Android Room Database Example using Kotlin.

This is a video tutorial series and throughout this we will build a basic notes application using Room persistence library. 


1 What is Room?

2 Components of Room

3 Android Room Database Example

3.1 Creating a new Project

3.2 Adding Dependencies

3.3 Creating Activities

3.3.1 MainActivity

3.3.2 AddTaskActivity

3.3.3 UpdateTaskActivity

3.3.4 Tasks RecyclerView Layout

3.4 Creating Entity

3.5 Creating Dao

3.6 Creating Database

3.7 Database Client

3.8 Adding a Task

3.9 Reading All Tasks

3.9.1 RecyclerView Adapter

3.9.2 Reading Tasks

3.10 Updating and Deleting Task

5 Android Room Database Example Source Code


What is Room?
The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.

Basically, with the help of room we can quickly create sqlite databases and perform the operations like create, read, update and delete. Room makes everything very easy and quick.

Components of Room
We have 3 components of room.

Entity: Instead of creating the SQLite table, we will create the Entity. Entity is nothing but a model class annotated with @Entity. The variables of this class is our columns, and the class is our table.
Database: It is an abstract class where we define all our entities.
DAO: Stands for Data Access Object. It is an interface that defines all the operations that we need to perform in our database.
I will not go to further theoretical details of Room. But you can check this link for more details.

Android Room Database Example
So what we are going to do is, we are going to create a To Do application using SQLite and in this application we will learn how we can use Room for handling SQLite.
