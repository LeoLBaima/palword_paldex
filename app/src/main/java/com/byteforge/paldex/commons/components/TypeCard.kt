package com.byteforge.paldex.commons.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.byteforge.paldex.R
import com.byteforge.paldex.ui.theme.DarkColor
import com.byteforge.paldex.ui.theme.DragonColor
import com.byteforge.paldex.ui.theme.ElectricColor
import com.byteforge.paldex.ui.theme.FireColor
import com.byteforge.paldex.ui.theme.GrassColor
import com.byteforge.paldex.ui.theme.GroundColor
import com.byteforge.paldex.ui.theme.IceColor
import com.byteforge.paldex.ui.theme.NeutralColor
import com.byteforge.paldex.ui.theme.WaterColor
import java.util.Locale

@Composable
fun TypeCard(type: String) {
    val image = when (type) {
        "electric" -> R.drawable.ic_eletric
        "water" -> R.drawable.ic_water
        "fire" -> R.drawable.ic_fire
        "ice" -> R.drawable.ic_ice
        "grass" -> R.drawable.ic_grass
        "ground" -> R.drawable.ic_ground
        "dragon" -> R.drawable.ic_dragon
        "dark" -> R.drawable.ic_dark
        "neutral" -> R.drawable.ic_neutral
        else -> R.drawable.ic_neutral
    }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = when (type) {
                "electric" -> ElectricColor
                "water" -> WaterColor
                "fire" -> FireColor
                "ice" -> IceColor
                "grass" -> GrassColor
                "ground" -> GroundColor
                "dragon" -> DragonColor
                "dark" -> DarkColor
                "neutral" -> NeutralColor
                else -> Color(0xFFB6968C)
            }
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
    ) {
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        )
        {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Type",
            )
            Text(
                text = type.replaceFirstChar { it.titlecase(Locale.ROOT) },
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun TypeCardPreview() {
    TypeCard(type = "electric")
}