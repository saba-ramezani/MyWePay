package com.example.wepay.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wepay.R



@Composable
private fun NameTextField(modifier: Modifier = Modifier) {
    val inputName = remember {
        mutableStateOf(value = "")
    }

    BasicTextField(
        value = inputName.value,
        onValueChange = {
                newInputName -> inputName.value = newInputName

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
                    .width(448.dp)
                    .height(60.dp)
                    .background(color = Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFAFB1B6),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            ) {
                if (inputName.value.isEmpty()) {
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
private fun CurrencyTextField(modifier: Modifier = Modifier) {
    val inputCurrency = remember {
        mutableStateOf(value = "")
    }

    BasicTextField(
        value = inputCurrency.value,
        onValueChange = {
                newInputCurrency -> inputCurrency.value = newInputCurrency
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
                    .width(448.dp)
                    .height(60.dp)
                    .background(color = Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFAFB1B6),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 10.dp, top = 12.5.dp, bottom = 12.5.dp, end = 10.dp)
            ) {
                if (inputCurrency.value.isEmpty()) {
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
private fun NameField(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(448.dp)
            .height(76.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(168.dp)
                .height(24.dp)
        ) {
            Text(
                text = "What's your name? *",

                // label large
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF3A00E5),
                    letterSpacing = 0.2.sp,
                ),
                modifier = Modifier
                    .width(168.dp)
                    .height(24.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(448.dp)
                .height(60.dp)
        ) {
            NameTextField()
        }
    }
}


@Composable
private fun CurrencyField(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(448.dp)
            .height(76.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(448.dp)
                .height(24.dp)
        ) {
            Text(
                text = "What currency do you use the most? *",

                // label large
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF3A00E5),
                    letterSpacing = 0.2.sp,
                ),
                modifier = Modifier
                    .width(448.dp)
                    .height(24.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(448.dp)
                .height(44.dp)
        ) {
            CurrencyTextField()
        }
    }
}


@Composable
private fun SkipForm(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(448.dp)
            .height(176.dp)
    ) {
        NameField()
        CurrencyField()
    }
}


@Composable
private fun SkipPageNavigationButtons(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    onNextClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .width(448.dp)
            .height(48.dp)
    ) {
        BackButton(modifier, onBackClicked)
        NextButton(modifier, onNextClicked)
    }
}


@Composable
private fun BackButton(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit) {
    Button(
        onClick = { onBackClicked() },
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFF3A00E5),
                shape = RoundedCornerShape(size = 228.dp)
            )
            .width(110.dp)
            .height(60.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = Color.White)
        ) {
            val image = painterResource(R.drawable.left_arrow)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.None,
                modifier = Modifier
                    .padding(0.dp)
                    .width(20.dp)
                    .height(20.dp)
            )

            Text(
                text = "Back",

                // label large
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF3A00E5),
                    letterSpacing = 0.2.sp,
                ),
                modifier = Modifier
                    .width(39.dp)
                    .height(24.dp)
            )
        }
    }
}



@Composable
private fun NextButton(
    modifier: Modifier = Modifier,
    onNextClicked: () -> Unit) {
    Button(
        onClick = { onNextClicked() },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5),),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFF3A00E5),
                shape = RoundedCornerShape(size = 228.dp)
            )
            .width(110.dp)
            .height(60.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = Color(0xFF3A00E5),)
        ) {
            Text(
                text = "Next",

                // label large
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color.White,
                    letterSpacing = 0.2.sp,
                ),
                modifier = Modifier
                    .width(39.dp)
                    .height(24.dp)
            )
            val image = painterResource(R.drawable.right_arrow)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.None,
                modifier = Modifier
                    .padding(0.dp)
                    .width(20.dp)
                    .height(20.dp)
            )
        }
    }
}


@Composable
fun SkipScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    onNextClicked: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.Bottom),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(start = 15.dp, top = 0.dp, bottom = 15.dp, end = 15.dp)
            .background(color = Color.White)
            .fillMaxSize(),

        ) {
        SkipForm()
        SkipPageNavigationButtons(modifier, onBackClicked, onNextClicked)
    }
}