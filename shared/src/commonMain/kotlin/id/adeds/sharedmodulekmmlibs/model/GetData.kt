package id.adeds.sharedmodulekmmlibs.model

data class GetData<DATA>(
    val data: DATA? = null,
    val errorTitleAndDesc: Pair<String, String>? = null
)
