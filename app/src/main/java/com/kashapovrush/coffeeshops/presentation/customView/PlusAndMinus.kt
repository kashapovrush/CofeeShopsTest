package com.kashapovrush.coffeeshops.presentation.customView

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.kashapovrush.coffeeshops.ui.theme.BrownColor
import com.kashapovrush.coffeeshops.ui.theme.BrownLightColor

@Composable
fun MinusEnabled() {
    Box(modifier = Modifier.size(12.dp)) {
        Canvas(modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawPath(
                    path = Path().apply {
                        moveTo(0.dp.toPx(), 6.dp.toPx())
                        lineTo(12.dp.toPx(), 6.dp.toPx())


                    },
                    color = BrownColor,
                    style = Stroke(2.dp.toPx())
                )
            })
    }
}

@Composable
fun PlusEnabled() {
    Box(modifier = Modifier.size(12.dp)) {
        Canvas(modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawPath(
                    path = Path().apply {
                        moveTo(0.dp.toPx(), 6.dp.toPx())
                        lineTo(12.dp.toPx(), 6.dp.toPx())
                        moveTo(6.dp.toPx(), 0.dp.toPx())
                        lineTo(6.dp.toPx(), 12.dp.toPx())

                    },
                    color = BrownColor,
                    style = Stroke(2.dp.toPx())
                )
            })
    }
}

@Composable
fun MinusDisabled() {
    Box(modifier = Modifier.size(12.dp)) {
        Canvas(modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawPath(
                    path = Path().apply {
                        moveTo(0.dp.toPx(), 6.dp.toPx())
                        lineTo(12.dp.toPx(), 6.dp.toPx())


                    },
                    color = BrownLightColor,
                    style = Stroke(2.dp.toPx())
                )
            })
    }
}


@Composable
fun PlusDisabled() {
    Box(modifier = Modifier.size(12.dp)) {
        Canvas(modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawPath(
                    path = Path().apply {
                        moveTo(0.dp.toPx(), 6.dp.toPx())
                        lineTo(12.dp.toPx(), 6.dp.toPx())
                        moveTo(6.dp.toPx(), 0.dp.toPx())
                        lineTo(6.dp.toPx(), 12.dp.toPx())

                    },
                    color = BrownLightColor,
                    style = Stroke(2.dp.toPx())
                )
            })
    }
}