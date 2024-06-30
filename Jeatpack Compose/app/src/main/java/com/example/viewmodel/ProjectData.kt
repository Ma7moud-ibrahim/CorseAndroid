package com.example.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class MainAskar(
    val id :Int,
    val name: String,
    val icon: ImageVector,
    val backGroundColor: Color
)
data class DataAskar(
    val text: String,
    val share: String,
    val repeat: String
)
val askarMainList = listOf<MainAskar>(
    MainAskar(1,"Askar 1", Icons.Default.Face, Color.DarkGray),
    MainAskar(2,"Askar 2", Icons.Default.Face, Color.LightGray),
    MainAskar(3,"Askar 3", Icons.Default.Face, Color.Cyan))

val listDataAskar = listOf(
    DataAskar(
        text = "آية الكرسي:\n\nاللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ وَلَا يَئُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "سورة الإخلاص:\n\nقُلْ هُوَ اللَّهُ أَحَدٌ اللَّهُ الصَّمَدُ لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "سورة الفلق:\n\nقُلْ أَعُوذُ بِرَبِّ الْفَلَقِ مِن شَرِّ مَا خَلَقَ وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "سورة الناس:\n\nقُلْ أَعُوذُ بِرَبِّ النَّاسِ مَلِكِ النَّاسِ إِلَٰهِ النَّاسِ مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ مِنَ الْجِنَّةِ وَالنَّاسِ",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "أصبحنا وأصبح الملك لله والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير. رب أسألك خير ما في هذا اليوم وخير ما بعده، وأعوذ بك من شر ما في هذا اليوم وشر ما بعده. رب أعوذ بك من الكسل وسوء الكبر. رب أعوذ بك من عذاب في النار وعذاب في القبر.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "اللهم بك أصبحنا، وبك أمسينا، وبك نحيا، وبك نموت، وإليك النشور.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "اللهم أنت ربي لا إله إلا أنت، خلقتني وأنا عبدك، وأنا على عهدك ووعدك ما استطعت، أعوذ بك من شر ما صنعت، أبوء لك بنعمتك علي وأبوء بذنبي فاغفر لي، فإنه لا يغفر الذنوب إلا أنت.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "اللهم إني أصبحت أشهدك وأشهد حملة عرشك وملائكتك وجميع خلقك أنك أنت الله لا إله إلا أنت، وحدك لا شريك لك، وأن محمداً عبدك ورسولك.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "اللهم ما أصبح بي من نعمة أو بأحد من خلقك، فمنك وحدك لا شريك لك، فلك الحمد ولك الشكر.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "حسبي الله لا إله إلا هو عليه توكلت وهو رب العرش العظيم.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "بسم الله الذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "رضيت بالله ربا، وبالإسلام دينا، وبمحمد صلى الله عليه وسلم نبيا.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "يا حي يا قيوم برحمتك أستغيث، أصلح لي شأني كله ولا تكلني إلى نفسي طرفة عين.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "سبحان الله وبحمده عدد خلقه ورضا نفسه وزنة عرشه ومداد كلماته.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "اللهم إني أسألك علماً نافعاً، ورزقاً طيباً، وعملاً متقبلاً.",
        share = "Share",
        repeat = "Repeat"
    ),
    DataAskar(
        text = "أستغفر الله وأتوب إليه.",
        share = "Share",
        repeat = "Repeat"
    )
)