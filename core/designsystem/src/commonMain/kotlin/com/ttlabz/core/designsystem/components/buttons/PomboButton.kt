package com.ttlabz.core.designsystem.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ttlabz.core.designsystem.theme.PomboTheme
import com.ttlabz.core.designsystem.theme.extended
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class PomboButtonStyle {
    PRIMARY,
    DESTRUCTIVE_PRIMARY,
    SECONDARY,
    DESTRUCTIVE_SECONDARY,
    TEXT,
}

@Composable
fun PomboButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: PomboButtonStyle = PomboButtonStyle.PRIMARY,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    val colors = when (style) {
        PomboButtonStyle.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.extended.disabledFill,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )

        PomboButtonStyle.DESTRUCTIVE_PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError,
            disabledContainerColor = MaterialTheme.colorScheme.extended.disabledFill,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )

        PomboButtonStyle.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.extended.textSecondary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )

        PomboButtonStyle.DESTRUCTIVE_SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.error,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )

        PomboButtonStyle.TEXT -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.tertiary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = MaterialTheme.colorScheme.extended.textDisabled
        )
    }

    val defaultBorderStroke =
        BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.extended.disabledOutline
        )
    val border = when {
        style == PomboButtonStyle.PRIMARY && !enabled -> defaultBorderStroke
        style == PomboButtonStyle.SECONDARY -> defaultBorderStroke
        style == PomboButtonStyle.DESTRUCTIVE_PRIMARY && !enabled -> defaultBorderStroke
        style == PomboButtonStyle.DESTRUCTIVE_SECONDARY -> {
            val borderColor = if (enabled) {
                MaterialTheme.colorScheme.extended.destructiveSecondaryOutline
            } else {
                MaterialTheme.colorScheme.extended.disabledOutline
            }
            BorderStroke(
                width = 1.dp,
                color = borderColor
            )
        }

        else -> null
    }

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        colors = colors,
        border = border
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(6.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(15.dp)
                    .alpha(
                        alpha = if (isLoading) 1f else 0f
                    ),
                strokeWidth = 1.5.dp,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp,
                    Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.alpha(
                    alpha = if (isLoading) 0f else 1f
                )
            ) {
                leadingIcon?.invoke()
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}

@Preview
@Composable
fun PomboPrimaryButtonPPreview() {
    PomboTheme {
        PomboButton(
            text = "Hello world!",
            onClick = { },
        )
    }
}

@Preview
@Composable
fun PomboDestructivePrimaryButtonPreview() {
    PomboTheme {
        PomboButton(
            text = "Hello world!",
            onClick = { },
            style = PomboButtonStyle.DESTRUCTIVE_PRIMARY
        )
    }
}

@Preview
@Composable
fun PomboSecondaryButtonPreview() {
    PomboTheme {
        PomboButton(
            text = "Hello world!",
            onClick = { },
            style = PomboButtonStyle.SECONDARY
        )
    }
}

@Preview
@Composable
fun PomboDestructiveSecondaryButtonPreview() {
    PomboTheme {
        PomboButton(
            text = "Hello world!",
            onClick = { },
            style = PomboButtonStyle.DESTRUCTIVE_SECONDARY
        )
    }
}

@Preview
@Composable
fun PomboTextButtonPreview() {
    PomboTheme {
        PomboButton(
            text = "Hello world!",
            onClick = { },
            style = PomboButtonStyle.TEXT
        )
    }
}