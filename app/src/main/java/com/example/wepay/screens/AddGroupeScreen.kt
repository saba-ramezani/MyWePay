package com.example.wepay.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.wepay.data.DataSource
import java.lang.reflect.Member


@Composable
private fun GroupNameTextField(modifier: Modifier = Modifier, GroupNameState : TextFieldState = remember { TextFieldState() }) {
    BasicTextField(
        value = GroupNameState.text,
        onValueChange = {
            GroupNameState.text = it

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
                if (GroupNameState.text.isEmpty()) {
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
            FieldTitle(title = "Name")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
        ) {
            GroupNameTextField(GroupNameState = GroupNameState)
        }
    }
}

@Composable
private fun CategoryTextField(modifier: Modifier = Modifier, CategoryState : TextFieldState = remember { TextFieldState() }) {
    BasicTextField(
        value = CategoryState.text,
        onValueChange = {
            CategoryState.text = it

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
                if (CategoryState.text.isEmpty()) {
                    Text(
                        text = "Category",
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
private fun CategoryField(modifier: Modifier = Modifier, CategoryState : TextFieldState = remember { TextFieldState() }) {
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
            FieldTitle(title = "Category")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .height(76.dp)
                .fillMaxWidth()
        ) {
            CategoryTextField(CategoryState = CategoryState)
        }
    }
}

@Composable
private fun AddMemberButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
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
private fun MemberNameTextField(modifier: Modifier = Modifier, MemberNameState : TextFieldState = remember { TextFieldState() }) {
    BasicTextField(
        value = MemberNameState.text,
        onValueChange = {
            MemberNameState.text = it

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
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFAFB1B6),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            ) {
                if (MemberNameState.text.isEmpty()) {
                    Text(
                        text = "Write name",
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
private fun MemberNameField(modifier: Modifier = Modifier) {

    var MemberNameFields by remember { mutableStateOf(listOf(TextFieldState())) }
    var userInputs by remember { mutableStateOf(listOf<String>()) }

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
            FieldTitle(title = "Members")
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
                MemberNameTextField(MemberNameState = MemberNameFields.lastOrNull() ?: TextFieldState())
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AddMemberButton(onClick = {
                    val newUserInput = MemberNameFields.lastOrNull()?.text.orEmpty()
                    if (newUserInput != "") {
                        userInputs = userInputs.toMutableList() + newUserInput
                        MemberNameFields = MemberNameFields.toMutableList() + TextFieldState()
                    }
                })
            }
        }

    }


    userInputs.forEach { userInput ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(color = Color.White)
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


@Composable
@Preview
private fun CreateGroupForm(
    modifier: Modifier = Modifier,
    GroupNameState : TextFieldState = remember { TextFieldState()},
    CategoryState : TextFieldState = remember { TextFieldState()} ) {
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
        horizontalAlignment = Alignment.End,
    ) {
        GroupNameField(GroupNameState = GroupNameState)
        CategoryField(CategoryState = CategoryState)
        MemberNameField()
    }
}


@Composable
private fun CreateGroupButton(modifier: Modifier = Modifier, onAddClick: () -> Unit) {

    Button(
        onClick = { onAddClick()} ,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),
        modifier = Modifier
            .width(448.dp)
            .height(44.dp)
            .background(color = Color(0xFF3A00E5), shape = RoundedCornerShape(size = 12.dp))
    ) {
        Text(
            text = "Create",
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
fun AddGroupScreen(
    modifier: Modifier = Modifier,
    onAddGroupClick: () -> Unit,
    ) {
    var GroupNameState = remember { TextFieldState() }
    var CategoryState = remember { TextFieldState() }





    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 65.dp)
            .background(color = Color.White),
        color = Color.White,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(60.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 15.dp, top = 50.dp, bottom = 15.dp, end = 15.dp)
                .background(color = Color.White)
                .fillMaxSize(),

            ) {
            CreateGroupForm(GroupNameState = GroupNameState, CategoryState = CategoryState)
            CreateGroupButton {
                // Call the onAddClick callback if provided

                /*if (fromNameState.text == "" || toNameState.text == "" || amountState.text == "") {
                    onAddGroupClick()
                } else {
                    //DataSource().addExpense(fromNameState.text + " to " + toNameState.text, amountState.text.toInt(), 0)
                    onAddGroupClick()
                }*/

                onAddGroupClick()

            }
        }
    }

}