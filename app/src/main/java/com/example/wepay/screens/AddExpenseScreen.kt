package com.example.wepay.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wepay.data.DataSource




class TextFieldState(){
    var text: String by mutableStateOf("")
}

@Composable
private fun FromNameTextField(modifier: Modifier = Modifier, FromNameState : TextFieldState = remember { TextFieldState() }) {
    BasicTextField(
        value = FromNameState.text,
        onValueChange = {
            FromNameState.text = it

        },
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 15.sp,
            lineHeight = 35.sp,
            fontWeight = FontWeight(400),
            color = Color.Black,
            letterSpacing = 0.2.sp,
            textAlign = TextAlign.Left,

            ),
        cursorBrush = SolidColor(Color(0xFF3A00E5)),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .background(color = Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFAFB1B6),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            ) {
                if (FromNameState.text.isEmpty()) {
                    Text(
                        text = "Name",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    )
                }
                innerTextField()
            }
        },
    )

}

@Composable
private fun FromNameField(modifier: Modifier = Modifier, FromNameState : TextFieldState = remember { TextFieldState() }) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(448.dp)
            .height(76.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
        ) {
            FieldTitle(title = "From")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
        ) {
            FromNameTextField(FromNameState = FromNameState)
        }
    }
}

@Composable
private fun AmountTextField(modifier: Modifier = Modifier, AmountState : TextFieldState = remember { TextFieldState() }) {
    BasicTextField(
        value = AmountState.text,
        onValueChange = {
            AmountState.text = it

        },
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 15.sp,
            lineHeight = 35.sp,
            fontWeight = FontWeight(400),
            color = Color.Black,
            letterSpacing = 0.2.sp,
            textAlign = TextAlign.Left,

            ),
        cursorBrush = SolidColor(Color(0xFF3A00E5)),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .background(color = Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFAFB1B6),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            ) {
                if (AmountState.text.isEmpty()) {
                    Text(
                        text = "Amount",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    )
                }
                innerTextField()
            }
        },
    )

}

@Composable
private fun AmountField(modifier: Modifier = Modifier, AmountState : TextFieldState = remember { TextFieldState() }) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(448.dp)
            .height(76.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
        ) {
            FieldTitle(title = "Amount")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
        ) {
            AmountTextField(AmountState = AmountState)
        }
    }
}

@Composable
private fun CurrencyTextField(modifier: Modifier = Modifier, CurrencyState : TextFieldState = remember { TextFieldState() }) {
    BasicTextField(
        value = CurrencyState.text,
        onValueChange = {
            CurrencyState.text = it

        },
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 15.sp,
            lineHeight = 35.sp,
            fontWeight = FontWeight(400),
            color = Color.Black,
            letterSpacing = 0.2.sp,
            textAlign = TextAlign.Left,

            ),
        cursorBrush = SolidColor(Color(0xFF3A00E5)),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .background(color = Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFAFB1B6),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            ) {
                if (CurrencyState.text.isEmpty()) {
                    Text(
                        text = "Currency",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    )
                }
                innerTextField()
            }
        },
    )

}

@Composable
private fun CurrencyField(modifier: Modifier = Modifier, CurrencyState : TextFieldState = remember { TextFieldState() }) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(448.dp)
            .height(76.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
        ) {
            FieldTitle(title = "Currency")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
        ) {
            CurrencyTextField(CurrencyState = CurrencyState)
        }
    }
}


@Composable
private fun ToNameTextField(modifier: Modifier = Modifier, ToNameState : TextFieldState = remember { TextFieldState() }) {
    BasicTextField(
        value = ToNameState.text,
        onValueChange = {
            ToNameState.text = it


        },
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 15.sp,
            lineHeight = 35.sp,
            fontWeight = FontWeight(400),
            color = Color.Black,
            letterSpacing = 0.2.sp,
            textAlign = TextAlign.Left,

            ),
        cursorBrush = SolidColor(Color(0xFF3A00E5)),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp)
                    .background(color = Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFAFB1B6),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            ) {
                if (ToNameState.text.isEmpty()) {
                    Text(
                        text = "Name",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    )
                }
                innerTextField()
            }
        },
    )

}

@Composable
private fun ToNameField(modifier: Modifier = Modifier, ToNameState : TextFieldState = remember { TextFieldState() }) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(448.dp)
            .height(76.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
        ) {
            FieldTitle(title = "To")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
        ) {
            ToNameTextField(ToNameState = ToNameState)
        }
    }
}


@Composable
private fun AddExpenseForm(
    modifier: Modifier = Modifier,
    FromNameState : TextFieldState = remember { TextFieldState()},
    AmountState : TextFieldState = remember { TextFieldState()} ,
    CurrencyState : TextFieldState = remember { TextFieldState()},
    ToNameState : TextFieldState = remember { TextFieldState() }) {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
        horizontalAlignment = Alignment.End,
    ) {
        FromNameField(FromNameState = FromNameState)
        AmountField(AmountState = AmountState)
        //CurrencyField(CurrencyState = CurrencyState)
        ToNameField(ToNameState = ToNameState)
    }
}


@Composable
private fun AddExpenseButton(modifier: Modifier = Modifier, onAddClick: () -> Unit) {

    Button(
        onClick = { onAddClick()} ,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),
        modifier = Modifier
            .width(448.dp)
            .height(44.dp)
            .background(color = Color(0xFF3A00E5), shape = RoundedCornerShape(size = 12.dp))
    ) {
        Text(
            text = "Add",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.4.sp,
            ),
            modifier = Modifier
                .width(54.dp)
                .height(20.dp)
        )
    }
}


@Composable
private fun FieldTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,

        // label large
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF3A00E5),
            letterSpacing = 0.2.sp,
            textAlign = TextAlign.End
        ),
        modifier = Modifier
            .height(24.dp)
            .width(80.dp)
            .padding(end = 20.dp)
    )
}





@Composable
fun AddExpenseScreen(
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit,
    ) {
    var fromNameState = remember { TextFieldState() }
    var amountState = remember { TextFieldState() }
    var currencyState = remember { TextFieldState() }
    var toNameState = remember { TextFieldState() }


    // Function to store data in SharedPreferences
    /*fun storeDataInPreferences(applicationContext: Context, key: String, value: String) {
        val sharedPreferences = applicationContext.getSharedPreferences("ExpensePreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }*/




    Surface(
        modifier = Modifier.fillMaxSize().padding(top = 65.dp).background(color = Color.White),
        color = Color.White,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(60.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 40.dp, top = 50.dp, bottom = 15.dp, end = 40.dp)
                .background(color = Color.White)
                .fillMaxSize(),

            ) {
            AddExpenseForm(FromNameState = fromNameState, AmountState = amountState, CurrencyState = currencyState, ToNameState = toNameState)
            AddExpenseButton {
                // Call the onAddClick callback if provided

                if (fromNameState.text == "" || toNameState.text == "" || amountState.text == "") {
                    onAddClick()
                } else {
                    DataSource().addExpense(fromNameState.text + " to " + toNameState.text, amountState.text.toInt(), 0)
                    onAddClick()
                }


                // Store fromNameState.text in SharedPreferences
                //storeDataInPreferences(applicationContext, "fromName", fromNameState.text)
            }
        }
    }

}