import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.blueland.composeloading.viewmodel.MainViewModel
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    // 로딩 상태를 관찰
    val isLoading by viewModel.isLoading.collectAsState()

    Scaffold { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.fetchData()
                }
            ) {
                Text("fetch data")
            }

            // 각 텍스트 뷰마다 Shimmer 효과를 개별 적용
            repeat(5) { _ ->
                Text(
                    text = "로딩이 끝나면 텍스트가 표시됩니다.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight() // 텍스트의 높이
                        .clip(RoundedCornerShape(4.dp))
                        .placeholder(
                            visible = isLoading,
                            highlight = PlaceholderHighlight.shimmer(Color.LightGray)
                        ),
                    color = Color.Black
                )
            }
        }
    }

    LoadingView(isLoading) // 로딩 중일 때 로딩 뷰
}
