package com.example.biblicalpaintings

import AppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.biblicalpaintings.datasource.PaintingList
import com.example.biblicalpaintings.model.Painting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface
                ) {
                    BiblePicturesApp()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiblePicturesApp() {
    val paintingList = PaintingList.paintings

    Scaffold(topBar = {
        TopBar()
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(paintingList) {
                PaintingCard(painting = it, modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.app_top_name),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(canScroll = { false }),
        colors = TopAppBarDefaults.largeTopAppBarColors(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun PaintingCard(
    painting: Painting, modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(modifier = modifier, elevation = CardDefaults.cardElevation(4.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize(animationSpec = spring(
                    stiffness = Spring.StiffnessLow,
                    dampingRatio = Spring.DampingRatioMediumBouncy
                )),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_painting_number, painting.id),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(start = 8.dp, top = 8.dp)
            )
            Text(
                text = stringResource(id = painting.paintingName),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp),

                )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "${painting.creationStart} - ${painting.creationEnd}",
                    style = MaterialTheme.typography.titleSmall
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = painting.paintingImage),
                contentScale = ContentScale.FillHeight,
                contentDescription = null,
                alignment = Center,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .clip(shape = MaterialTheme.shapes.small)
                    .shadow(
                        elevation = 16.dp,
                        ambientColor = MaterialTheme.colorScheme.onPrimary,
                        shape = MaterialTheme.shapes.large
                    )
            )
            PaintingIconButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                expanded = expanded,
                onClick = { expanded = !expanded })

            if (expanded) TextInfo(
                textInfo = painting.pictureInfo,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
private fun PaintingIconButton(
    expanded: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick, modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = if (expanded) R.drawable.down_arrow_pressed else R.drawable.down_arrow),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
private fun TextInfo(@StringRes textInfo: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = textInfo),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BiblePicturesApp()
        }
    }
}