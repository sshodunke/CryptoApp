package com.smithshodunke.cryptoapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.smithshodunke.cryptoapp.data.remote.dto.coininfo.Team
import com.smithshodunke.cryptoapp.presentation.theme.MediumDimension

@Composable
fun TeamMemberItem(
    teamMember: Team
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(vertical = MediumDimension)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h1,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis
        )
    }
}