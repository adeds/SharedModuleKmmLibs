package id.adeds.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import id.adeds.sharedmodulekmmlibs.model.CharacterUiModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                Greeting(
                    mainViewModel.characters.observeAsState(),
                    mainViewModel.error.observeAsState()
                )
            }
        }

        mainViewModel.getCharacter()
    }
}

@Composable
fun Greeting(list: State<List<CharacterUiModel>?>, error: State<String?>) {
    list.value?.let {
        Text(modifier = Modifier.fillMaxSize(), text = "data: $it")
    }

    error.value?.let {
        Text(text = "error: $it")
    }

}