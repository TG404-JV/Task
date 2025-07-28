package com.tg.societymanagment.dummyData

import com.tg.societymanagment.data.Task
import java.sql.Time

fun getTask(): List<Task> {
    val list = mutableListOf<Task>()

    val timeMorning = Time.valueOf("08:00:00").toString()
    val timeAfternoon = Time.valueOf("13:00:00").toString()
    val timeEvening = Time.valueOf("18:30:00").toString()
    val timeNight = Time.valueOf("21:45:00").toString()

    list.add(Task(1, "Buy Milk", "From Dairy Shop", "Home", timeMorning, false, true))
    list.add(Task(2, "Team Meeting", "Project Discussion", "Work", timeAfternoon, true, false))
    list.add(Task(3, "Call Plumber", "Kitchen Tap Issue", "Urgent", timeMorning, false, false))
    list.add(Task(4, "Pay Bills", "Electricity + WiFi", "Finance", timeNight, true, true))
    list.add(Task(5, "Workout", "Leg Day", "Health", timeMorning, false, true))
    list.add(Task(6, "Read Book", "Finish Chapter 4", "Personal", timeEvening, false, false))
    list.add(Task(7, "Doctor Appointment", "Dentist Visit", "Health", timeAfternoon, true, false))
    list.add(Task(8, "Project Deployment", "Push to production", "Work", timeNight, true, true))
    list.add(Task(9, "Buy Groceries", "Vegetables & Fruits", "Home", timeEvening, false, false))
    list.add(Task(10, "Online Course", "Watch Kotlin lesson", "Learning", timeMorning, false, true))
    list.add(Task(11, "Submit Report", "Weekly summary", "Work", timeAfternoon, true, false))
    list.add(Task(12, "Clean Room", "Closet + Desk", "Home", timeEvening, false, false))
    list.add(Task(13, "Laundry", "Wash white clothes", "Home", timeMorning, true, false))
    list.add(Task(14, "Call Mom", "Check-in call", "Family", timeNight, false, true))
    list.add(Task(15, "Prepare Presentation", "Client pitch", "Work", timeAfternoon, false, true))
    list.add(Task(16, "Fix Bug #233", "Crash on login", "Work", timeMorning, true, true))
    list.add(Task(17, "Grocery Delivery", "Check Swiggy order", "Home", timeNight, false, false))
    list.add(Task(18, "Update Resume", "Add recent project", "Career", timeEvening, false, true))
    list.add(Task(19, "Practice Interview", "Mock test", "Career", timeAfternoon, false, true))
    list.add(Task(20, "Walk Dog", "Evening walk", "Home", timeEvening, false, false))
    list.add(Task(21, "Meeting with HR", "Salary discussion", "Work", timeMorning, true, false))
    list.add(Task(22, "Meditation", "10 mins session", "Health", timeMorning, false, true))
    list.add(Task(23, "Order Medicine", "Monthly refill", "Health", timeNight, false, false))
    list.add(Task(24, "Learn Jetpack Compose", "UI Basics", "Learning", timeAfternoon, false, true))
    list.add(Task(25, "Install AC", "Technician visit", "Urgent", timeAfternoon, false, false))
    list.add(Task(26, "Recharge Phone", "Prepaid plan", "Finance", timeMorning, true, false))
    list.add(Task(27, "Clean Bathroom", "Deep cleaning", "Home", timeEvening, false, false))
    list.add(Task(28, "Buy Gifts", "Friend’s Birthday", "Personal", timeNight, false, true))
    list.add(Task(29, "Webinar", "Android AI Tools", "Learning", timeAfternoon, true, true))
    list.add(Task(30, "Water Plants", "Balcony garden", "Home", timeMorning, false, false))

    return list
}
