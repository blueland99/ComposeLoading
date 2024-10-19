import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun LoadingView(isLoading: Boolean) {
    if (isLoading)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                color = Color.DarkGray,
                trackColor = Color.LightGray,
                strokeWidth = 5.dp,
                strokeCap = StrokeCap.Square
            )

            CircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                color = Color.DarkGray,
                trackColor = Color.LightGray,
                strokeWidth = 10.dp,
                strokeCap = StrokeCap.Round
            )

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .padding(horizontal = 30.dp),
                color = Color.DarkGray,
                trackColor = Color.LightGray,
                strokeCap = StrokeCap.Square
            )

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .padding(horizontal = 30.dp),
                color = Color.DarkGray,
                trackColor = Color.LightGray,
                strokeCap = StrokeCap.Round
            )
        }
}
