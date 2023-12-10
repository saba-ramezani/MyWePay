package com.example.wepay.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.wepay.R
import com.example.wepay.data.DataSource
import com.example.wepay.model.Expense
import getUserExpenseAggregation


@Composable
fun ExpensesList(expensesList: List<Expense>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.zIndex(500F)) {
        items(expensesList) { expense ->
            ExpenseCard(
                expense = expense,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}


@Composable
fun ExpenseCard(expense: Expense, modifier: Modifier = Modifier) {
    if (expense.expenseType == 0) {
        Card(modifier = modifier.zIndex(500F)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp)
                    .background(color = Color(0xFFEEC6C6))
            )
            {
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                ) {
                    Text(
                        text = expense.expenseName,
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.Black,
                        textAlign = TextAlign.Left
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                ) {
                    Text(
                        text = expense.totalAmount.toString(),
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.Black,
                        textAlign = TextAlign.Right
                    )
                }
            }
        }
    } else {
        Card(modifier = modifier.zIndex(500F)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp)
                    .background(color = Color(0xFFB6D1E2))
            )
            {
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                ) {
                    Text(
                        text = expense.expenseName,
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.Black,
                        textAlign = TextAlign.Left
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxWidth(0.5F)
                ) {
                    Text(
                        text = expense.totalAmount.toString(),
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.Black,
                        textAlign = TextAlign.Right
                    )
                }
            }
        }
    }

}

@Composable
fun HomeTabScreen(
    onAddExpenseClicked : () -> Unit,
    onAddGroupClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    var expensesList by remember { mutableStateOf(emptyList<Expense>()) }

    // Simulate loading the expenses from a data source
    LaunchedEffect(true) {
        expensesList = DataSource().loadAllExpenses()
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(
            modifier = Modifier
                .padding(start = 5.dp, top = 90.dp, bottom = 100.dp, end = 5.dp)
                .background(color = Color.White)
                .fillMaxSize(),

            ) {
            ExpensesList(
                expensesList = expensesList,
            )

            Column(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .align(Alignment.BottomEnd)
                    .zIndex(1000F)
            ) {
                // Add the new button here
                Button(
                    onClick = {onAddGroupClicked()},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF3A00E5),
                            shape = CircleShape,
                        )
                        .width(40.dp)
                        .height(40.dp)
                        .zIndex(1000F)
                        .align(Alignment.CenterHorizontally)
                        .padding(0.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
                        modifier = Modifier.size(40.dp)
                    ) {
                        //val image = painterResource(R.drawable.add_expense)
                        Icon(
                            imageVector = Icons.Default.Person,
                            tint = Color.White,
                            contentDescription = "Navigation Icon",
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp)
                        )

                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp))
                Button(
                    onClick = {onAddExpenseClicked()},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF3A00E5),
                            shape = CircleShape,
                        )
                        .width(60.dp)
                        .height(60.dp)
                        .zIndex(1000F)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        //val image = painterResource(R.drawable.add_expense)
                        Icon(
                            imageVector = Icons.Default.Add,
                            tint = Color.White,
                            contentDescription = "Navigation Icon",
                            modifier = Modifier
                                .height(35.dp)
                                .width(35.dp)
                        )

                    }
                }
            }

        }
    }

}