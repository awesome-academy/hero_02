package com.sun.hero_02.data.repository.source

import com.sun.hero_02.data.model.ChampionsResponse

interface HeroDataSource {

    interface Local {
    }

    interface Remote {
        suspend fun getChampions(): ChampionsResponse
    }
}
