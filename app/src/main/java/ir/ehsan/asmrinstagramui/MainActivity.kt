package ir.ehsan.asmrinstagramui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ir.ehsan.asmrinstagramui.ui.theme.AsmrInstagramUITheme
import kotlinx.coroutines.delay

data class User(
    val profile: String,
    val name: String
)

data class Post(
    val user: User,
    val post: String,
    val description: String,
    val likesCount: Int,
    val commentsCount: Int
)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsmrInstagramUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopBar()
                        },
                        bottomBar = {
                            BottomBar()
                        }
                    ) { paddings ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddings)
                        ) {
                            val stories = listOf(
                                User(
                                    profile = "https://this-person-does-not-exist.com/img/avatar-gen11056f1df7cc58f605ce8029a84269fa.jpg",
                                    name = "ehsan"
                                ),
                                User(
                                    profile = "https://this-person-does-not-exist.com/img/avatar-gen11945081a5b36eebba0679f61dfbd225.jpg",
                                    name = "melika"
                                ),
                                User(
                                    profile = "https://this-person-does-not-exist.com/img/avatar-gen11458b284947739865cd857e828f1f21.jpg",
                                    name = "jax"
                                ),
                                User(
                                    profile = "https://this-person-does-not-exist.com/img/avatar-gen4f59c3a3f9487457d506860bb75e3247.jpg",
                                    name = "sara"
                                ),
                                User(
                                    profile = "https://this-person-does-not-exist.com/img/avatar-gen116a503718103ee85aa48038cc85d079.jpg",
                                    name = "marta"
                                ),
                                User(
                                    profile = "https://this-person-does-not-exist.com/img/avatar-gen11670e8d5aee2f5eacc036906962f823.jpg",
                                    name = "niki"
                                ),
                                User(
                                    profile = "https://this-person-does-not-exist.com/img/avatar-gena157df185052c72cc24fec571a77cdf0.jpg",
                                    name = "john"
                                ),
                            )
                            val posts = listOf(
                                Post(
                                    user = stories[0],
                                    post = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbOgDkM2In7l5CVeeJjwcdVRd9tdQ4r5wwzPkLOz9CP-Uxnx-rdtxHvXJWbIz6qUBjFHI&usqp=CAU",
                                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                                    likesCount = (100..10000).random(),
                                    commentsCount = (100..10000).random(),
                                ),
                                Post(
                                    user = stories[1],
                                    post = "https://www.wwf.org.uk/sites/default/files/styles/hero_s/public/2017-01/Ashley%20cooper%20forest.jpg?h=6f8e8448&itok=o0tpKRWJ",
                                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                                    likesCount = (100..10000).random(),
                                    commentsCount = (100..10000).random(),
                                ),
                                Post(
                                    user = stories[2],
                                    post = "https://www.iucn.org/sites/default/files/styles/what_we_do_large/public/images-themes/biodiversity-shutterstock_1477256246.jpg.webp?itok=4i9JdtFu",
                                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                                    likesCount = (100..10000).random(),
                                    commentsCount = (100..10000).random(),
                                ),
                                Post(
                                    user = stories[3],
                                    post = "https://www.naturebasedsolutionsinitiative.org/wp-content/uploads/2022/11/chuttersnap-MpxAiNDevjU-unsplash-1-aspect-ratio-1024-768.jpg",
                                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                                    likesCount = (100..10000).random(),
                                    commentsCount = (100..10000).random(),
                                ),
                                Post(
                                    user = stories[4],
                                    post = "https://cdn-blob.austria.info/cms-uploads-prod/default/0002/92/thumb_191674_default_teaser.jpeg?cachebuster=1682774670",
                                    description = "As you consider all the possible ways to improve yourself and the world, you notice John Travolta seems fairly unhappy.",
                                    likesCount = (100..10000).random(),
                                    commentsCount = (100..10000).random(),
                                ),
                            )
                            Posts(stories = stories, posts = posts)
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Posts(
    stories:List<User>,
    posts:List<Post>
) {
    val context = LocalContext.current
    LazyColumn(
        modifier=Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            Stories(stories = stories)
        }
        items(posts){ post->
            var liked by remember {
                mutableStateOf(false)
            }
            LaunchedEffect(liked){
                if (liked){
                    delay(2000)
                    liked = false
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 1.dp, horizontal = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier
                        .border(
                            1.dp, Brush.horizontalGradient(
                                listOf(
                                    Color(0xffff6f00),
                                    Color(0xffffeb35),
                                    Color(0xffff6f00),
                                    Color(0xffff2b99),
                                    Color(0xffff2bd1),
                                    Color(0xffff2bd1),
                                )
                            ), CircleShape
                        )
                        .size(33.dp),
                        contentAlignment = Alignment.Center
                    ){
                        AsyncImage(
                            model = ImageRequest
                                .Builder(context)
                                .data(post.user.profile)
                                .crossfade(400)
                                .build(),
                            modifier= Modifier
                                .clip(CircleShape)
                                .size(30.dp),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = post.user.name)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(onDoubleTap = {
                    liked = true
                })
            }, contentAlignment = Alignment.Center){
                AsyncImage(
                    model = ImageRequest
                        .Builder(context)
                        .data(post.post)
                        .crossfade(400)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier=Modifier.fillMaxWidth()
                )
                AnimatedVisibility(visible = liked, enter = scaleIn(spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )),exit = scaleOut()
                ) {
                    Image(
                        modifier=Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
                ) {
                val iconsModifier=Modifier.size(20.dp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        modifier=iconsModifier,
                        painter = painterResource(id = R.drawable.ic_heart),
                        contentDescription = null
                    )
                    Icon(
                        modifier=iconsModifier,
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = null
                    )
                    Icon(
                        modifier=iconsModifier,
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = null
                    )
                }
                Icon(
                    modifier=iconsModifier,
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(text = "${post.likesCount} likes", fontSize = 13.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = post.description, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = "View all ${post.commentsCount} comments", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun Stories(stories:List<User>) {
    val context = LocalContext.current
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        itemsIndexed(stories){index,story->
            if (index == 0){
                Spacer(modifier = Modifier.width(10.dp))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(modifier = Modifier
                    .border(
                        2.dp, Brush.horizontalGradient(
                            listOf(
                                Color(0xffff6f00),
                                Color(0xffffeb35),
                                Color(0xffff6f00),
                                Color(0xffff2b99),
                                Color(0xffff2bd1),
                                Color(0xffff2bd1),
                            )
                        ), CircleShape
                    )
                    .size(70.dp),
                    contentAlignment = Alignment.Center
                ){
                    AsyncImage(
                        model = ImageRequest
                            .Builder(context)
                            .data(story.profile)
                            .crossfade(400)
                            .build(),
                        modifier= Modifier
                            .clip(CircleShape)
                            .size(60.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = story.name, fontSize = 13.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 14.dp,
                vertical = 10.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier=Modifier.height(40.dp),
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = "instagram"
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier=Modifier.size(23.dp),
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                modifier=Modifier.size(23.dp),
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = null
            )
        }
    }
}

@Composable
fun BottomBar() {
    val context = LocalContext.current
    val bottomBarItems = listOf(
        R.drawable.ic_home,
        R.drawable.ic_search,
        R.drawable.ic_add,
        R.drawable.ic_ig
    )
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 10.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround) {
        bottomBarItems.forEach {
            Icon(
                modifier=Modifier.size(22.dp),
                painter = painterResource(id = it),
                contentDescription = null
            )
        }
        AsyncImage(
            modifier= Modifier
                .size(27.dp)
                .clip(CircleShape),
            model = ImageRequest
                .Builder(context)
                .data("https://this-person-does-not-exist.com/img/avatar-gen11add62e724cde7222c445a4af1a61fc.jpg")
                .crossfade(400)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}


