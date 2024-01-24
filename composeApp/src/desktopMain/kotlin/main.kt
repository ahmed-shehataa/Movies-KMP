import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.shehata.movies_kmp.App
import com.shehata.movies_kmp.di.commonModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(commonModule)
    }

    application {
        val windowState = rememberWindowState(size = DpSize(850.dp, 650.dp))

        Window(
            title = "Movies-KMP",
            onCloseRequest = ::exitApplication,
            state = windowState
        ) {
            App()
        }
    }
}