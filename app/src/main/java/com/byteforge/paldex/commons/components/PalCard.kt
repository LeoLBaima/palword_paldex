package com.byteforge.paldex.commons.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.byteforge.paldex.ui.theme.BlackF8
import com.byteforge.paldex.ui.theme.DarkColor
import com.byteforge.paldex.ui.theme.DragonColor
import com.byteforge.paldex.ui.theme.ElectricColor
import com.byteforge.paldex.ui.theme.FireColor
import com.byteforge.paldex.ui.theme.GrassColor
import com.byteforge.paldex.ui.theme.GroundColor
import com.byteforge.paldex.ui.theme.IceColor
import com.byteforge.paldex.ui.theme.NeutralColor
import com.byteforge.paldex.ui.theme.WaterColor

@Composable
fun PalCard(
    id: Int,
    name: String,
    types: List<String>,
    image: String,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = when (types.first()) {
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
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = if (id < 100) "#0$id" else "#$id",
                        fontSize = 12.sp,
                        color = BlackF8
                    )
                    Text(text = name, fontSize = 18.sp, color = Color.White)
                    Row {
                        types.forEach { type ->
                            TypeCard(type = type)
                        }
                    }
                }
                AsyncImage(
                    model = image,
                    contentDescription = "Image of $name",
                    modifier = Modifier
                        .weight(1f)
                        .size(125.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Preview
@Composable
fun PalCardPreview() {
    PalCard(
        id = 1,
        name = "Bulbasaur",
        types = listOf("grass", "poison"),
        image = "https://static.wikia.nocookie.net/palworld/images/0/01/Lamball_menu.png/",
    )
}