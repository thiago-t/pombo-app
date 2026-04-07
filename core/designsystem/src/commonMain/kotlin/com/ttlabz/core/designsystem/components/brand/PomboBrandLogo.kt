package com.ttlabz.core.designsystem.components.brand

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.vectorResource
import pombo.core.designsystem.generated.resources.Res
import pombo.core.designsystem.generated.resources.logo_chirp

@Composable
fun PomboBrandLogo(
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = vectorResource(Res.drawable.logo_chirp),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 32.dp)
    )
}