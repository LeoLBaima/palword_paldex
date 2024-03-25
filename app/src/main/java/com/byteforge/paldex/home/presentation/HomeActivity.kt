package com.byteforge.paldex.home.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.byteforge.paldex.MyApplication
import com.byteforge.paldex.commons.components.PalCard
import com.byteforge.paldex.commons.components.SearchBar
import com.byteforge.paldex.commons.components.ShimmerListItem
import com.byteforge.paldex.commons.extensions.shimmerEffect
import com.byteforge.paldex.home.domain.model.Pal
import com.byteforge.paldex.ui.theme.PaldexTheme
import javax.inject.Inject

class HomeActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel.fetchPals()
        setContent {
            PaldexTheme {
                HomeScreen(viewModel = viewModel, context = this)
            }
        }
    }
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    context: Context,
) {
    val uiState by viewModel.uiState.observeAsState()
    val currentState = uiState
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentState) {
            is UIState.Loading -> LoadingState()
            is UIState.Loaded -> LoadedState(currentState.pals, context)
            is UIState.Error -> ErrorState(currentState.message)
            else -> {}
        }
    }
}

@Composable
fun LoadingState() {
    Surface {
        Column {
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .shimmerEffect()
            )
            LazyColumn {
                items(7) {
                    Spacer(modifier = Modifier.height(8.dp))
                    ShimmerListItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun LoadedState(pals: List<Pal>, context: Context) {
    var searchQuery by remember { mutableStateOf("") }
    var filteredPalList: List<Pal> = pals

    Surface {
        Column {
            Spacer(modifier = Modifier.height(8.dp))
            SearchBar(
                value = searchQuery,
                onValueChange = { name ->
                    searchQuery = name
                    filteredPalList =
                        pals.filter { it.name.contains(searchQuery, ignoreCase = true) }
                },
                hint = "Pal name",
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(filteredPalList.size) { index ->
                    PalCard(
                        id = filteredPalList[index].id,
                        name = filteredPalList[index].name,
                        types = filteredPalList[index].types,
                        image = filteredPalList[index].imageWiki,
                    )
                }
            }
        }
    }
}

@Composable
fun ErrorState(message: String) {
    Surface {
        Text(text = message)
    }
}