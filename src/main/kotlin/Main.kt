package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//==============NUMBER 1================
class BankAccount(private var balance: Double) {

    fun deposit(amount:Double) {
        balance += amount
        println("Deposited: $amount. New balance: $balance")

    }

    fun withdraw(amount:Double) {
        balance -= amount
        println("Withdrawn: $amount. New balance: $balance")
    }

    fun checkBalance() {
        println("Balance: $balance")
    }
}

//==============NUMBER 2================
class Student(val name: String) {
    private val activities = mutableListOf<String>()

    fun participateInActivity(activity: String) {
        activities.add(activity)
        println("$name participated in $activity")
    }

    fun listActivities() {
        println("$name's Activities:")
        for (activity in activities) {
            println("- $activity")
        }
    }
}

//==============NUMBER 3================
interface MealBuilder {
    fun setName(name: String): MealBuilder
    fun setMainCourse(mainCourse: String): MealBuilder
    fun setSideDish(sideDish: String): MealBuilder
    fun setDessert(dessert: String): MealBuilder
    fun setDrink(drink: String): MealBuilder
    fun build(): Meal
}

data class Meal(
    val name: String,
    val mainCourse: String,
    val sideDish: String,
    val dessert: String,
    val drink: String
)

class MealBuilderImpl(
    private var name: String = "",
    private var mainCourse: String = "",
    private var sideDish: String = "",
    private var dessert: String = "",
    private var drink: String = ""
) : MealBuilder {

    override fun setName(name: String): MealBuilder {
        this.name = name
        return this
    }

    override fun setMainCourse(mainCourse: String): MealBuilder {
        this.mainCourse = mainCourse
        return this
    }

    override fun setSideDish(sideDish: String): MealBuilder {
        this.sideDish = sideDish
        return this
    }

    override fun setDessert(dessert: String): MealBuilder {
        this.dessert = dessert
        return this
    }

    override fun setDrink(drink: String): MealBuilder {
        this.drink = drink
        return this
    }

    override fun build(): Meal {
        return Meal(name, mainCourse, sideDish, dessert, drink)
    }
}

fun main() {
    //==============NUMBER 1================
    println("NUMBER 1 ANSWER:")
    val account = BankAccount(1000.0)
    account.checkBalance()
    account.deposit(500.0)
    account.withdraw(200.0)

    //==============NUMBER 2================
    println("")
    println("NUMBER 2 ANSWER:")
    val student1 = Student("Alice Guo")
    val student2 = Student("Bob")

    student1.participateInActivity("Science Fair")
    student1.participateInActivity("Chess Club")
    student2.participateInActivity("Soccer Tournament")
    student1.listActivities()
    student2.listActivities()

    //==============NUMBER 3================
    println("")
    println("NUMBER 3 ANSWER:")
    val mealBuilder: MealBuilder = MealBuilderImpl()
    val meal = mealBuilder
        .setName("Special Dinner")
        .setMainCourse("Grilled Salmon")
        .setSideDish("Roasted Vegetables")
        .setDessert("Chocolate Cake")
        .setDrink("Red Wine")
        .build()

    println("Meal Name: ${meal.name}")
    println("Main Course: ${meal.mainCourse}")
    println("Side Dish: ${meal.sideDish}")
    println("Dessert: ${meal.dessert}")
    println("Drink: ${meal.drink}")
}