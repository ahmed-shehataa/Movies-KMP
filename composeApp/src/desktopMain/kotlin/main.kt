
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.shehata.movies_kmp.App
import com.shehata.movies_kmp.di.commonModule
import org.koin.core.context.startKoin

fun main() = application {

    startKoin {
        modules(commonModule)
    }
    Window(onCloseRequest = ::exitApplication, title = "Movies-KMP") {
        App()
    }
}