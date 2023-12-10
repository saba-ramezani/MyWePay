package com.example.wepay.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.wepay.data.DataSource
import java.lang.reflect.Member



class TextFieldState(){
    var text: String by mutableStateOf("")
}



@Composable
private fun FromNameDropdown(
    modifier: Modifier = Modifier,
    fromNames: List<String>,
    selectedFromName: String,
    onFromNameSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .width(280.dp)
            .height(50.dp)
            .background(color = Color.White)
            .border(
                width = 1.dp,
                color = Color(0xFFAFB1B6),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            .clickable { expanded = true }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = if (selectedFromName.isEmpty()) "Name" else selectedFromName,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = if (selectedFromName.isEmpty()) Color.LightGray else Color.Black
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.Black
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.White)
        ) {
            fromNames.forEach { fromName ->
                DropdownMenuItem(
                    onClick = {
                        onFromNameSelected(fromName)
                        expanded = false
                    },
                    text = { Text(text = fromName) }
                )
            }
        }
    }
}


@Composable
private fun FromNameField(modifier: Modifier = Modifier, FromNameState : TextFieldState = remember { TextFieldState() }) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth(0.25F)
                .height(76.dp)
        ) {
            FieldTitle(title = "From")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
        ) {
            val fromNames = listOf("Saba", "Hiva", "Ali")
            var selectedFromName by remember { mutableStateOf("") }

            FromNameDropdown(
                modifier = Modifier,
                fromNames = fromNames,
                selectedFromName = selectedFromName,
                onFromNameSelected = { selectedFromName = it }
            )
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
                    .width(280.dp)
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
            .fillMaxWidth()
            .height(76.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .height(76.dp)
                .fillMaxWidth(0.25F)
        ) {
            FieldTitle(title = "Amount")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .height(76.dp)
                .fillMaxWidth()
        ) {
            AmountTextField(AmountState = AmountState)
        }
    }
}


@Composable
private fun GroupNameDropdown(
    modifier: Modifier = Modifier,
    groupNames: List<String>,
    selectedGroupName: String,
    onGroupNameSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .width(280.dp)
            .height(50.dp)
            .background(color = Color.White)
            .border(
                width = 1.dp,
                color = Color(0xFFAFB1B6),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            .clickable { expanded = true }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = if (selectedGroupName.isEmpty()) "Name" else selectedGroupName,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = if (selectedGroupName.isEmpty()) Color.LightGray else Color.Black
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.Black
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.White)
        ) {
            groupNames.forEach { groupName ->
                DropdownMenuItem(
                    onClick = {
                        onGroupNameSelected(groupName)
                        expanded = false
                    },
                    text = { Text(text = groupName) }
                )
            }
        }
    }
}


@Composable
private fun GroupNameField(modifier: Modifier = Modifier, GroupNameState : TextFieldState = remember { TextFieldState() }) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth(0.25F)
                .height(76.dp)
        ) {
            FieldTitle(title = "Group")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
        ) {
            val groupNames = listOf("Group A", "Group B", "Group C")
            var selectedGroupName by remember { mutableStateOf("") }

            GroupNameDropdown(
                modifier = Modifier,
                groupNames = groupNames,
                selectedGroupName = selectedGroupName,
                onGroupNameSelected = { selectedGroupName = it }
            )
        }
    }
}

@Composable
private fun AddToNameButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFF3A00E5),
                shape = CircleShape
            )
            .width(40.dp)
            .height(40.dp)
            .padding(0.dp)
            .background(color = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = Color.White)
                .size(40.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                tint = Color.White,
                contentDescription = "Navigation Icon",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )
        }
    }
}


@Composable
private fun ToNameDropdown(
    modifier: Modifier = Modifier,
    toNames: List<String>,
    selectedToName: String,
    onToNameSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .width(280.dp)
            .height(50.dp)
            .background(color = Color.White)
            .border(
                width = 1.dp,
                color = Color(0xFFAFB1B6),
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            .clickable { expanded = true }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = if (selectedToName.isEmpty()) "Name" else selectedToName,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = if (selectedToName.isEmpty()) Color.LightGray else Color.Black
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.Black
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.White)
        ) {
            toNames.forEach { toName ->
                DropdownMenuItem(
                    onClick = {
                        onToNameSelected(toName)
                        expanded = false
                    },
                    text = { Text(text = toName) }
                )
            }
        }
    }
}


@Composable
private fun ToNameField(modifier: Modifier = Modifier) {
    var toNameFields by remember { mutableStateOf(listOf(TextFieldState())) }
    var userInputs by remember { mutableStateOf(listOf<String>()) }
    var selectedToName by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .height(76.dp)
                    .fillMaxWidth(0.25F)
            ) {
                FieldTitle(title = "To")
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth(0.75F)
                ) {
                    val toNames = listOf("Saba", "Hiva", "Ali", "Reza", "Sara", "Maryam", "Amir", "Iman", "Mehdi")

                    ToNameDropdown(
                        modifier = Modifier,
                        toNames = toNames,
                        selectedToName = selectedToName,
                        onToNameSelected = { selectedToName = it }
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    AddToNameButton(onClick = {
                        if (selectedToName.isNotEmpty() && !userInputs.contains(selectedToName)) {
                            userInputs = userInputs.toMutableList() + selectedToName
                            toNameFields = toNameFields.toMutableList() + TextFieldState()
                        }
                    })
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(top = 10.dp)
        ) {
            items(userInputs) { userInput ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(color = Color(0xFFdcd8e8))
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        tint = Color.Black,
                        contentDescription = "Navigation Icon",
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                    Text(
                        text = userInput,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth(0.7F)
                            .height(30.dp)
                            .background(color = Color.White)
                            .border(width = 1.dp, color = Color.Black, shape = RectangleShape)
                            .padding(start = 10.dp, top = 4.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Delete,
                        tint = Color.Black,
                        contentDescription = "Navigation Icon",
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                }
            }
        }
    }
}



@Composable
@Preview
private fun AddExpenseForm(
    modifier: Modifier = Modifier,
    FromNameState : TextFieldState = remember { TextFieldState()},
    AmountState : TextFieldState = remember { TextFieldState()},
    GroupNameState : TextFieldState = remember { TextFieldState()}) {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
        horizontalAlignment = Alignment.End,
    ) {
        FromNameField(FromNameState = FromNameState)
        AmountField(AmountState = AmountState)
        GroupNameField(GroupNameState = GroupNameState)
        ToNameField()
    }
}


@Composable
private fun AddExpenseButton(modifier: Modifier = Modifier, onAddClick: () -> Unit) {

    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(20.dp)
        .background(color = Color.White)
    )


    Button(
        onClick = { onAddClick()} ,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),

        modifier = Modifier
            .fillMaxWidth()
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
                .zIndex(1000F)
        )
    }
}


@Composable
private fun FieldTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,

        // label large
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 17.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF3A00E5),
            letterSpacing = 0.2.sp,
            textAlign = TextAlign.Start
        ),
        modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
            .padding(end = 20.dp)
    )
}





@Composable
fun AddExpenseScreen(
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit,
) {
    var FromNameState = remember { TextFieldState() }
    var AmountState = remember { TextFieldState() }





    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .background(color = Color.White),
        color = Color.White,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(60.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 15.dp, top = 50.dp, bottom = 50.dp, end = 15.dp)
                .background(color = Color.White)
                .fillMaxSize(),

            ) {
            AddExpenseForm(FromNameState = FromNameState, AmountState = AmountState)
            AddExpenseButton {
                onAddClick()
            }
        }
    }

}