package com.example.wepay.data



import UserExpenseAggregation
import com.example.wepay.model.Expense
import getUserExpenseAggregation
import java.time.temporal.TemporalAmount
import kotlin.math.exp

class DataSource() {
    private var expenses = arrayListOf<Expense>(
        Expense("friday night", 1000, 0),
        Expense("office", 800, 1),
        Expense("family", 550, 1),
        Expense("book club", 230, 0),
        Expense("wednesday lunch", 400, 1),
        Expense("friday night", 1000, 0),
        Expense("office", 800, 1),
        Expense("family", 550, 1),
        Expense("book club", 230, 0),
        Expense("wednesday lunch", 400, 1),
        Expense("friday night", 1000, 0),
        Expense("office", 800, 1),
        Expense("family", 550, 1),
        Expense("book club", 230, 0),
        Expense("wednesday lunch", 400, 1),)

    fun loadAllExpenses(): ArrayList<Expense> {

        return expenses
    }


    fun addExpense(name: String, amount: Int, type: Int) {
        expenses.add(Expense("wednesday lunch", 400, 1))
    }


    suspend fun getAllExpenses(): String {
        try {
            val result = getUserExpenseAggregation(2)
            println(result)
            return "error neo;irthn;aoeirhnoeirnoieroenrgoinroignoerig \n oirngoeirnoiernoeignoi \n owierngowirngowiregnowirg \n weoinwoeiwoiegnwoieg"
        } catch (e: Exception) {
            e.printStackTrace()
            return "error neo;irthn;aoeirhnoeirnoieroenrgoinroignoerig \n oirngoeirnoiernoeignoi \n owierngowirngowiregnowirg \n weoinwoeiwoiegnwoieg"
        }
        return "error neo;irthn;aoeirhnoeirnoieroenrgoinroignoerig \n oirngoeirnoiernoeignoi \n owierngowirngowiregnowirg \n weoinwoeiwoiegnwoieg"
    }
}