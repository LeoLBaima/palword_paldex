package com.byteforge.paldex.home.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.byteforge.paldex.MyApplication
import com.byteforge.paldex.commons.components.PalCard
import com.byteforge.paldex.home.domain.model.Pal
import com.byteforge.paldex.ui.theme.PaldexTheme
import javax.inject.Inject

class HomeActivity : ComponentActivity() {
    @Inject lateinit var viewModel: HomeViewModel

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
    context: Context
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
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun LoadedState(pals: List<Pal>, context: Context) {
    Surface {
        LazyColumn {
            items(pals.size) { index ->
                PalCard(
                    id = pals[index].id,
                    name = pals[index].name,
                    types = pals[index].types,
                    image = pals[index].imageWiki,
                )
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