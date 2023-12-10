package com.example.wepay.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginContent(
    onLoginClick: () -> Unit,
    onLoginWithGoogleClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onSkipClick: () -> Unit,
) {
    OnBoardScreen(modifier = Modifier, onLoginClick, onLoginWithGoogleClick, onSignUpClick, onSkipClick)

}




@Composable
fun LoginButton(modifier: Modifier = Modifier, onLoginClick: () -> Unit) {
    Button(
        onClick = { onLoginClick() } ,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),
        modifier = Modifier
            .padding(16.dp)
            .width(448.dp)
            .height(44.dp)
            .background(color = Color(0xFF3A00E5), shape = RoundedCornerShape(size = 12.dp))
    ) {
        Text(
            text = "Login",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.4.sp,
            ),
            modifier = Modifier
                .width(39.dp)
                .height(20.dp)
        )
    }
}


@Composable
fun LoginWithGoogleButton(modifier: Modifier = Modifier, onLoginWithGoogleClick: () -> Unit) {
    Button(
        onClick = { onLoginWithGoogleClick() } ,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),
        modifier = Modifier
            .padding(16.dp)
            .width(448.dp)
            .height(44.dp)
            .background(color = Color(0xFF3A00E5), shape = RoundedCornerShape(size = 12.dp))
    ) {
        Text(
            text = "Login with Google",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.4.sp,
            ),
            modifier = Modifier
                .width(127.dp)
                .height(20.dp)
        )
    }
}


@Composable
fun SignUpButton(modifier: Modifier = Modifier, onSignUpClick: () -> Unit) {
    Button(
        onClick = { onSignUpClick() } ,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A00E5)),
        modifier = Modifier
            .padding(16.dp)
            .width(448.dp)
            .height(44.dp)
            .background(color = Color(0xFF3A00E5), shape = RoundedCornerShape(size = 12.dp))
    ) {
        Text(
            text = "Sign Up",
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
fun SkipButton(modifier: Modifier = Modifier, onSkipClick: () -> Unit) {
    Button(
        onClick = { onSkipClick() } ,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier
            .padding(16.dp)
            .width(448.dp)
            .height(44.dp)
            .border(
                width = 1.dp,
                color = Color(0xFF3A00E5),
                shape = RoundedCornerShape(size = 12.dp)
            )
            .background(color = Color.White, shape = RoundedCornerShape(size = 12.dp))
    ) {
        Text(
            text = "Skip",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF3A00E5),
                letterSpacing = 0.4.sp,
            ),
            modifier = Modifier
                .width(54.dp)
                .height(20.dp)
        )
    }
}


@Composable
fun OnBoardButtons(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onLoginWithGoogleClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onSkipClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Bottom),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        LoginButton(modifier, onLoginClick)

        LoginWithGoogleButton(modifier, onLoginWithGoogleClick)

        SignUpButton(modifier, onSignUpClick)

        SkipButton(modifier, onSkipClick)

    }
}


@Composable
fun OnBoardScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onLoginWithGoogleClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onSkipClick: () -> Unit
    ) {
    Column(
        verticalArrangement = Arrangement.spacedBy(100.dp, Alignment.Bottom),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(start = 15.dp, top = 0.dp, bottom = 15.dp, end = 15.dp)
            .background(color = Color.White)
            .fillMaxSize(),

        ) {
        OnBoardButtons(modifier, onLoginClick, onLoginWithGoogleClick, onSignUpClick, onSkipClick)
    }
}